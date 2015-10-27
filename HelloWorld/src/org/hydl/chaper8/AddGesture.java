package org.hydl.chaper8;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class AddGesture extends Activity {

	EditText editText;
	GestureOverlayView gestureView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addgesture);

		editText = (EditText) findViewById(R.id.gesture_name);
		gestureView = (GestureOverlayView) findViewById(R.id.gesture);
		gestureView.setGestureColor(Color.RED);
		gestureView.setGestureStrokeWidth(4);
		gestureView
				.addOnGesturePerformedListener(new OnGesturePerformedListener() {

					@Override
					public void onGesturePerformed(GestureOverlayView overlay,
							final Gesture gesture) {
						// TODO Auto-generated method stub
						View saveDialog = getLayoutInflater().inflate(
								R.layout.save, null);
						ImageView imageView = (ImageView) saveDialog
								.findViewById(R.id.show);
						final EditText gestureName = (EditText) saveDialog
								.findViewById(R.id.gesture_name);
						Bitmap bitmap = gesture.toBitmap(128, 128, 10,
								0xffff0000);
						imageView.setImageBitmap(bitmap);
						new AlertDialog.Builder(AddGesture.this)
								.setView(saveDialog)
								.setPositiveButton("±£´æ", new OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub

										GestureLibrary gestureLib = GestureLibraries
												.fromFile("/mnt/sdcard/mygestures");
										gestureLib.addGesture(gestureName
												.getText().toString(), gesture);
										gestureLib.save();

									}
								}).setNegativeButton("È¡Ïû", null).show();
					}
				});

	}
}
