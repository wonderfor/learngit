package org.hydl.helloworld;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TextView;

public class AlertDialogActivity extends Activity {

	TextView show;
	String[] items = new String[] { "���Java����", "���Ajax����", "���JavaEE����",
			"���Android����" };

	final static int MAX_PROGRESS = 100;
	private int[] data = new int[50];
	// ��¼���ȶԻ������ɰٷֱ�
	int progressStatus = 0;
	int hasData = 0;
	ProgressDialog pd1, pd2;
	ActionBar actionBar;
	
	
	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			if (msg.what == 0x123) {
				pd2.setProgress(progressStatus);
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alertdialog);
		
		actionBar = getActionBar();
		show = (TextView) findViewById(R.id.text01);
		View root = this.getLayoutInflater().inflate(R.layout.login, null);
		// ����Popwindow����
		final PopupWindow popup = new PopupWindow(root, 280, 260);
		Button button = (Button) findViewById(R.id.btn_alert7);
		button.setOnClickListener(new android.view.View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				popup.showAsDropDown(v);
				// popup.showAtLocation(findViewById(R.id.btn_alert7),
				// Gravity.CENTER, 20, 20);
			}
		});

		root.findViewById(R.id.btn_close).setOnClickListener(
				new android.view.View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						popup.dismiss();
					}

				});
	}

	public void simple(View source) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
				.setTitle("�򵥶Ի���").setIcon(R.drawable.ic_launcher)
				.setMessage("�Ի���Ĳ�������\n�ڶ�������");
		setPositiveButton(builder);
		setNegativeButton(builder).create().show();

	}

	private AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder) {
		return builder.setPositiveButton("ȷ��", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				show.setText("�������ˡ�ȷ������ť��");
			}
		});
	}

	private AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder) {
		return builder.setNegativeButton("ȡ��", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				show.setText("�������ˡ�ȡ������ť��");
			}
		});
	}

	public void simpleList(View source) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
				.setTitle("���б�Ի���").setIcon(R.drawable.ic_launcher)
				.setItems(items, new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						show.setText("��ѡ���ˡ�" + items[which] + "��");
					}
				});
		setPositiveButton(builder);
		setNegativeButton(builder).create().show();

	}

	public void singleChoice(View source) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
				.setTitle("��ѡ�б���Ի���").setIcon(R.drawable.ic_launcher)
				.setSingleChoiceItems(items, 1, new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						show.setText("��ѡ���ˡ�" + items[which] + "��");
					}
				});
		setPositiveButton(builder);
		setNegativeButton(builder).create().show();
	}

	public void multiChoice(View source) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
				.setTitle("��ѡ�б���Ի���")
				.setIcon(R.drawable.ic_launcher)
				.setMultiChoiceItems(items,
						new boolean[] { false, true, false, true }, null);
		setPositiveButton(builder);
		setNegativeButton(builder).create().show();

	}

	public void customList(View source) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("�Զ����б���Ի���")
				.setIcon(R.drawable.ic_launcher)
				.setAdapter(
						new ArrayAdapter<String>(this, R.layout.array_item,
								items), null);
		setPositiveButton(builder);
		setNegativeButton(builder).create().show();
	}

	public void customView(View source) {
		TableLayout loginForm = (TableLayout) getLayoutInflater().inflate(
				R.layout.login, null);
		new AlertDialog.Builder(this).setIcon(R.drawable.ic_launcher)
				.setTitle("�Զ���View�Ի���").setView(loginForm)
				.setPositiveButton("��¼", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						show.setText("����� ��¼");
					}
				}).setNegativeButton("ȡ��", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						show.setText("����� ȡ��");
					}
				}).create().show();
	}

	public void showSpinner(View source) {
		ProgressDialog.show(this, "����ִ����", "����ִ����,���Ժ�", false, true);

	}

	public void showIndeterminate(View source) {
		pd1 = new ProgressDialog(AlertDialogActivity.this);
		pd1.setTitle("��������ִ����...");
		pd1.setMessage("��������ִ����,����ȴ���������");
		pd1.setCancelable(true);
		pd1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		pd1.setIndeterminate(true);
		pd1.show();
	}

	public void showProgress(View view) {
		progressStatus = 0;
		hasData = 0;
		pd2 = new ProgressDialog(AlertDialogActivity.this);
		pd2.setMax(MAX_PROGRESS);
		pd2.setTitle("������ɰٷֱ�");
		pd2.setMessage("��ʱ�������ɰٷֱ�");
		pd2.setCancelable(false);
		pd2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		pd2.setIndeterminate(false);
		pd2.show();
		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub

				while (progressStatus < MAX_PROGRESS) {
					progressStatus = MAX_PROGRESS * doWork() / data.length;
					handler.sendEmptyMessage(0x123);
				}

				if (progressStatus >= MAX_PROGRESS) {
					pd2.dismiss();
				}
				
			}
		}.start();

	}

	public int doWork() {
		data[hasData++] = (int) (Math.random() * 100);
		try {
			Thread.sleep(100);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return hasData;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater flater = new MenuInflater(AlertDialogActivity.this);
		flater.inflate(R.menu.menuview, menu);
		return super.onCreateOptionsMenu(menu);
	}

}
