package org.hydl.chaper8;

import java.util.ArrayList;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class RecogniseGesture extends Activity {

	GestureOverlayView gestureView;
	GestureLibrary gestureLibrary;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recognisegesture);
		gestureLibrary = GestureLibraries.fromFile("/mnt/sdcard/mygestures");
		if (gestureLibrary.load()) {
			Toast.makeText(RecogniseGesture.this, "手势文件装载成功！",
					Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(RecogniseGesture.this, "手势文件转载失败！",
					Toast.LENGTH_LONG).show();
		}

		gestureView = (GestureOverlayView) findViewById(R.id.gesture);
		gestureView
				.addOnGesturePerformedListener(new OnGesturePerformedListener() {

					@Override
					public void onGesturePerformed(GestureOverlayView overlay,
							Gesture gesture) {
						// TODO Auto-generated method stub
						ArrayList<Prediction> predictions = gestureLibrary
								.recognize(gesture);
						ArrayList<String> result = new ArrayList<String>();
						for (Prediction pred : predictions) {
							if (pred.score > 2.0) {
								result.add("与手势【" + pred.name + "】相似度为"
										+ pred.score);
							}
						}
						if (result.size() > 0) {
							ArrayAdapter<Object> adapter = new ArrayAdapter<Object>(
									RecogniseGesture.this,
									android.R.layout.simple_dropdown_item_1line,
									result.toArray());
							new AlertDialog.Builder(RecogniseGesture.this)
									.setAdapter(adapter, null)
									.setPositiveButton("确定", null).show();
						} else {
							Toast.makeText(RecogniseGesture.this, "无法找到匹配的手势！",
									Toast.LENGTH_LONG).show();
						}
					}
				});

	}
}
