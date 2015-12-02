package org.hydl.chaper10;

import java.io.File;
import java.io.FileOutputStream;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

public class CaptureImage extends Activity {
	SurfaceView sView;
	SurfaceHolder surfaceHolder;
	int screenWidth,screenHeight;
	Camera camera;
	boolean isPreview = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_captureimage);
		WindowManager wm = getWindowManager();
		Display display = wm.getDefaultDisplay();
		DisplayMetrics metrics = new DisplayMetrics();
		display.getMetrics(metrics);
		screenWidth = metrics.widthPixels;
		screenHeight = metrics.heightPixels;
		sView = (SurfaceView) findViewById(R.id.sView);
		//���ø�Surface����Ҫ�Լ�ά��������
		sView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		surfaceHolder = sView.getHolder();
		surfaceHolder.addCallback(new Callback() {
			
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				// TODO Auto-generated method stub
				if(camera != null) {
					if(isPreview) camera.stopPreview();
					camera.release();
					camera = null;
				}
			}
			
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				// TODO Auto-generated method stub
				initCamera();
			}
			
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int wdith, int height) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
	
	private void initCamera() {
		if(!isPreview) {
			camera = Camera.open(0);
			camera.setDisplayOrientation(90);
		}
		if(camera != null && !isPreview) {
			try {
				Camera.Parameters parameters = camera.getParameters();
				//������ƬԤ����С
				parameters.setPreviewSize(screenWidth, screenHeight);
				//����Ԥ����Ƭʱÿ����ʾ����֡����Сֵ�����ֵ
				parameters.setPreviewFpsRange(4, 10);
				//���� ͼƬ��ʽ
				parameters.setPictureFormat(ImageFormat.JPEG);
				//����JPG��Ƭ������
				parameters.set("jpeg-quality", 85);
				//������Ƭ�Ĵ�С
				parameters.setPictureSize(screenWidth, screenHeight);
				//ͨ��surfaceview��ʾȡ������
				camera.setPreviewDisplay(surfaceHolder);
				camera.startPreview();
			} catch (Exception e) {	
				// TODO: handle exception
				e.printStackTrace();
			}
			isPreview = true;
		}
	}
	
	public void capture(View source) {
		if(camera != null) {
			camera.autoFocus(autoFocusCallback);
		}
	}
	
	AutoFocusCallback autoFocusCallback = new AutoFocusCallback() {
		
		//���Զ��Խ�ʱ�����÷���
		@Override
		public void onAutoFocus(boolean success, Camera camera) {
			// TODO Auto-generated method stub
			if(success) {
				//takePicture()����������������������
				//��һ��������:���û����¿���ʱ�����ü�����
				//�ڶ���������:�������ȡԭʼ��Ƭʱ�����ü�����
				//������������:�������ȡJPG��Ƭʱ�����ü�����
				camera.takePicture(new ShutterCallback() {
					
					@Override
					public void onShutter() {
						// TODO Auto-generated method stub
						//���¿���˲���ִ�д˴�����
					}
				}, new PictureCallback() {

					@Override
					public void onPictureTaken(byte[] data, Camera c) {
						// TODO Auto-generated method stub
						//�˴�������Ծ����Ƿ���Ҫ����ԭʼ��Ƭ��Ϣ
					}
					
				}, myJpegCallback);
			}
		}
	};
	
	PictureCallback myJpegCallback = new PictureCallback() {
		
		@Override
		public void onPictureTaken(byte[] data, Camera camera) {
			// TODO Auto-generated method stub
			//�����������õ����ݴ���λͼ
			final Bitmap bm = BitmapFactory.decodeByteArray(data, 0, data.length);
			View saveDialog = getLayoutInflater().inflate(R.layout.saves, null);
			final EditText photoName = (EditText) saveDialog.findViewById(R.id.phone_name);
			ImageView show = (ImageView) saveDialog.findViewById(R.id.show);
			show.setImageBitmap(bm);
			new AlertDialog.Builder(CaptureImage.this).setView(saveDialog).setPositiveButton("����", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					File file = new File(Environment.getExternalStorageDirectory(),photoName.getText().toString() + ".jpg");
					FileOutputStream outStream = null;
					try {
						outStream = new FileOutputStream(file);
						bm.compress(CompressFormat.JPEG, 100, outStream);
						outStream.close();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
				}
			}).setNegativeButton("ȡ��",null).show();
			
			camera.stopPreview();
			camera.startPreview();
			isPreview = true;
		}
	};
}
