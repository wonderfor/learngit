package org.hydl.chaper3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AsyncTaskActivity extends Activity {
	
	private TextView show;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_async);
		show = (TextView) findViewById(R.id.textAsync);
		Log.i("Async", "---------onCreate-------------");
	}
	
	public void download(View source) throws MalformedURLException {
		Log.i("Async", "---------download-------------");
		DownTask task = new DownTask(this);
		task.execute(new URL("http://www.taobao.com/"));
	}
	
	class DownTask extends AsyncTask<URL, Integer, String>{

		ProgressDialog pdialog;
		int hasRead = 0;
		Context mContext;
		
		public DownTask(Context ctx) {
			mContext = ctx;
		}
		
		@Override
		protected String doInBackground(URL... params) {
			Log.i("Async", "---------doInBackground-------------");
			// TODO Auto-generated method stub
			StringBuilder sb = new StringBuilder();
			try {
				URLConnection conn = params[0].openConnection();
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line + "\n");
					hasRead++;
					publishProgress(hasRead);
				}
				return sb.toString();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(String result) {
			Log.i("Async", "---------onPostExecute-------------");
			// TODO Auto-generated method stub
			show.setText(result);
			pdialog.dismiss();
			super.onPostExecute(result);
		}
		
		@Override
		protected void onPreExecute() {
			Log.i("Async", "---------onPreExecute-------------");
			// TODO Auto-generated method stub
			pdialog = new ProgressDialog(mContext);
			pdialog.setTitle("��������ִ����");
			pdialog.setCancelable(false);
			pdialog.setMax(202);
			pdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			pdialog.setIndeterminate(false);
			pdialog.show();
		}
		
		@Override
		protected void onProgressUpdate(Integer... values) {
			Log.i("Async", "---------onProgressUpdate-------------");
			// TODO Auto-generated method stub
			show.setText("�Ѿ���ȡ�ˡ�" + values[0] + "���У�");
			pdialog.setProgress(values[0]);
		}
		
		
	}
	
	
}
