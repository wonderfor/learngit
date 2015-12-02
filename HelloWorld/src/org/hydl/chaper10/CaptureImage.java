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
		//设置该Surface不需要自己维护缓冲区
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
				//设置照片预览大小
				parameters.setPreviewSize(screenWidth, screenHeight);
				//设置预览照片时每秒显示多少帧的最小值和最大值
				parameters.setPreviewFpsRange(4, 10);
				//设置 图片格式
				parameters.setPictureFormat(ImageFormat.JPEG);
				//设置JPG照片的质量
				parameters.set("jpeg-quality", 85);
				//设置照片的大小
				parameters.setPictureSize(screenWidth, screenHeight);
				//通过surfaceview显示取景画面
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
		
		//当自动对焦时激发该方法
		@Override
		public void onAutoFocus(boolean success, Camera camera) {
			// TODO Auto-generated method stub
			if(success) {
				//takePicture()方法传入三个监听器参数
				//第一个监听器:当用户按下快门时激发该监听器
				//第二个监听器:当相机获取原始照片时激发该监听器
				//第三个监听器:当相机获取JPG照片时激发该监听器
				camera.takePicture(new ShutterCallback() {
					
					@Override
					public void onShutter() {
						// TODO Auto-generated method stub
						//按下快门瞬间会执行此处代码
					}
				}, new PictureCallback() {

					@Override
					public void onPictureTaken(byte[] data, Camera c) {
						// TODO Auto-generated method stub
						//此处代码可以决定是否需要保存原始照片信息
					}
					
				}, myJpegCallback);
			}
		}
	};
	
	PictureCallback myJpegCallback = new PictureCallback() {
		
		@Override
		public void onPictureTaken(byte[] data, Camera camera) {
			// TODO Auto-generated method stub
			//根据拍照所得的数据创建位图
			final Bitmap bm = BitmapFactory.decodeByteArray(data, 0, data.length);
			View saveDialog = getLayoutInflater().inflate(R.layout.saves, null);
			final EditText photoName = (EditText) saveDialog.findViewById(R.id.phone_name);
			ImageView show = (ImageView) saveDialog.findViewById(R.id.show);
			show.setImageBitmap(bm);
			new AlertDialog.Builder(CaptureImage.this).setView(saveDialog).setPositiveButton("保存", new OnClickListener() {
				
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
			}).setNegativeButton("取消",null).show();
			
			camera.stopPreview();
			camera.startPreview();
			isPreview = true;
		}
	};
}
