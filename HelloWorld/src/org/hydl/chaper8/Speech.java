package org.hydl.chaper8;

import java.util.Locale;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Speech extends Activity {
	
	TextToSpeech tts;
	EditText editText;
	Button speech;
	Button record;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_speech);
		tts = new TextToSpeech(this, new OnInitListener() {
			
			@Override
			public void onInit(int status) {
				// TODO Auto-generated method stub
				int result = tts.setLanguage(Locale.US);
				if(result != TextToSpeech.LANG_COUNTRY_AVAILABLE && result != TextToSpeech.LANG_AVAILABLE) {
					Toast.makeText(Speech.this, "TTS暂时不支持这种语言的朗读", Toast.LENGTH_LONG).show();
				}
			}
		});
		editText = (EditText) findViewById(R.id.txt);
		speech = (Button) findViewById(R.id.speech);
		record = (Button) findViewById(R.id.record);
		
		speech.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tts.speak(editText.getText().toString(), TextToSpeech.QUEUE_ADD, null);
			}
		});
		
		record.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tts.synthesizeToFile(editText.getText().toString(), null,"/mnt/sdcard/sound.wav");
				Toast.makeText(Speech.this, "声音记录成功！", Toast.LENGTH_LONG).show();
						
						
			}
		});
		
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		if(tts != null) {
			tts.shutdown();
		}
	}
}
