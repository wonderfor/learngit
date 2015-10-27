package org.hydl.chaper3;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;

public class PinBall extends Activity {

	// ���ӵĿ��
	private int tableWidth;

	// ���ӵĸ߶�
	private int tableHeight;

	// ���ĵĴ�ֱλ��
	private int racketY;

	// ���涨�����ĵĸ߶ȺͿ��
	private final int RACKET_HEIGHT = 20;
	private final int RACKET_WIDTH = 70;

	// С��Ĵ�С
	private final int BALL_SIZE = 12;

	// С������������ٶ�
	private int ySpeed = 10;
	Random rand = new Random();
	// ����һ��-0.5~0.5�ı���,���ڿ���С������з���
	private double xyRate = rand.nextDouble() - 0.5;
	// С�����������ٶ�
	private int xSpeed = (int) (ySpeed * xyRate * 2);
	// ballX��ballY����С���λ��
	private int ballX = rand.nextInt(200) + 20;
	private int ballY = rand.nextInt(10) + 20;

	// ���ĵ�ˮƽλ��
	private int racketX = rand.nextInt(200);
	private boolean isLose = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		final GameView gameView = new GameView(this);
		setContentView(gameView);

		WindowManager windowManager = getWindowManager();
		Display display = windowManager.getDefaultDisplay();
		DisplayMetrics metrics = new DisplayMetrics();
		display.getMetrics(metrics);
		// �����Ļ�߿�
		tableWidth = metrics.widthPixels;
		tableHeight = metrics.heightPixels;
		racketY = tableHeight - 80;
		final Handler handler = new Handler() {
			public void handleMessage(Message msg) {
				if (msg.what == 0x123) {
					gameView.invalidate();
				}
			}
		};

		gameView.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View source, MotionEvent event) {
				// TODO Auto-generated method stub

				racketX = (int) event.getX();

				gameView.invalidate();
				return true;
			}
		});

		gameView.setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(View source, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub

				switch (event.getKeyCode()) {
				case KeyEvent.KEYCODE_A:
					if (racketX > 0)
						racketX -= 10;
					break;
				case KeyEvent.KEYCODE_D:
					if (racketX < tableWidth - RACKET_WIDTH)
						racketX += 10;
				default:
					break;
				}

				gameView.invalidate();
				return true;
			}
		});

		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (ballX <= 0 || ballX >= tableWidth - BALL_SIZE) {
					xSpeed = -xSpeed;
				}
				if (ballY >= racketY - BALL_SIZE
						&& (ballX < racketX || ballX > racketX + RACKET_WIDTH)) {
					timer.cancel();
					isLose = true;
				} else if (ballY <= 0
						|| (ballY >= racketY - BALL_SIZE && ballX > racketX && ballX <= racketX
								+ RACKET_WIDTH)) {
					ySpeed = -ySpeed;
				}

				ballY += ySpeed;
				ballX += xSpeed;
				handler.sendEmptyMessage(0x123);
			}
		}, 0, 100);

	}

	class GameView extends View {

		Paint paint = new Paint();

		public GameView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected void onDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			paint.setStyle(Paint.Style.FILL);
			paint.setAntiAlias(true);
			if (isLose) {
				paint.setColor(Color.RED);
				paint.setTextSize(40);
				canvas.drawText("��Ϸ�ѽ���", 50, 200, paint);
			} else {
				paint.setColor(Color.rgb(240, 240, 80));
				canvas.drawCircle(ballX, ballY, BALL_SIZE, paint);
				paint.setColor(Color.rgb(80, 80, 200));
				canvas.drawRect(racketX, racketY, racketX + RACKET_WIDTH,
						racketY + RACKET_HEIGHT, paint);
			}
		}

	}

}
