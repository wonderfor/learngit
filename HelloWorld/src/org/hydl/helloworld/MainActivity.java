package org.hydl.helloworld;

import org.hydl.chaper3.ActionCateAttr;
import org.hydl.chaper3.ActionDataActivity;
import org.hydl.chaper3.AlphaTest;
import org.hydl.chaper3.AnimationDrawables;
import org.hydl.chaper3.AnimatorTest;
import org.hydl.chaper3.AnimatorTestT;
import org.hydl.chaper3.ArrayResTest;
import org.hydl.chaper3.AsyncTaskActivity;
import org.hydl.chaper3.BitMapTest;
import org.hydl.chaper3.Blast;
import org.hydl.chaper3.BouncingBall;
import org.hydl.chaper3.BundleActivity;
import org.hydl.chaper3.Butterfly;
import org.hydl.chaper3.CalPrimeActivity;
import org.hydl.chaper3.CanvasTest;
import org.hydl.chaper3.ClipDrawActivity;
import org.hydl.chaper3.DataTypeOverride;
import org.hydl.chaper3.DateTypeActivity;
import org.hydl.chaper3.DrawViewActivity;
import org.hydl.chaper3.FatPo;
import org.hydl.chaper3.ForResultActivity;
import org.hydl.chaper3.HandDraw;
import org.hydl.chaper3.HandlerActivity;
import org.hydl.chaper3.I18nTest;
import org.hydl.chaper3.IntentTabActivity;
import org.hydl.chaper3.LaunchersActivity;
import org.hydl.chaper3.Layer;
import org.hydl.chaper3.ListViewTween;
import org.hydl.chaper3.MatrixActivity;
import org.hydl.chaper3.MoveBack;
import org.hydl.chaper3.PathTest;
import org.hydl.chaper3.PathTextTest;
import org.hydl.chaper3.PinBall;
import org.hydl.chaper3.PlayGameActivity;
import org.hydl.chaper3.RawResTest;
import org.hydl.chaper3.SelectBookActivity;
import org.hydl.chaper3.ShaderTest;
import org.hydl.chaper3.ShapeTest;
import org.hydl.chaper3.ShowWave;
import org.hydl.chaper3.StateList;
import org.hydl.chaper3.StyleTest;
import org.hydl.chaper3.SurfaceViewTest;
import org.hydl.chaper3.SysAction;
import org.hydl.chaper3.TweenAnim;
import org.hydl.chaper3.ValuesResTest;
import org.hydl.chaper3.WarpTest;
import org.hydl.chaper3.XmlResTest;
import org.hydl.chaper8.AddGesture;
import org.hydl.chaper8.DBTest;
import org.hydl.chaper8.Dict;
import org.hydl.chaper8.FileTest;
import org.hydl.chaper8.GestureFlip;
import org.hydl.chaper8.GestureTest;
import org.hydl.chaper8.GestureZoom;
import org.hydl.chaper8.RecogniseGesture;
import org.hydl.chaper8.SDCardTest;
import org.hydl.chaper8.SDFileExplorer;
import org.hydl.chaper8.SharedPreferencesTest;
import org.hydl.chaper8.Speech;
import org.hydl.chaper8.Usecount;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

	// 定义字体大小和菜单项的标识
	final int FONT_10 = 0x111;
	final int FONT_12 = 0x112;
	final int FONT_14 = 0x113;
	final int FONT_16 = 0x114;
	final int FONT_18 = 0x115;
	// 定义普通菜单项的标识
	final int PLAIN_ITEM = 0x11b;
	// 定义字体颜色菜单项的标识
	final int FONT_RED = 0x116;
	final int FONT_BLUE = 0x117;
	final int FONT_GREEN = 0x118;
	private EditText edit;
	final int MENU1 = 0x111;
	final int MENU2 = 0x112;
	final int MENU3 = 0x113;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout layout = new LinearLayout(this);
		super.setContentView(layout);
		setContentView(R.layout.activity_main);

		edit = (EditText) findViewById(R.id.editTextMain);
		registerForContextMenu(edit);

		Button btn_gird = (Button) findViewById(R.id.btn_grid);
		btn_gird.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,
						GridLayoutActivity.class);
				MainActivity.this.startActivity(i);
			}
		});

		Button btn_gridview = (Button) findViewById(R.id.btn_gridview);
		btn_gridview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this, GridViewActivity.class);
				MainActivity.this.startActivity(i);
			}
		});

		Button btn_gallery = (Button) findViewById(R.id.btn_gallery);
		btn_gallery.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this, GalleryActivity.class);
				MainActivity.this.startActivity(i);
			}
		});

		Button btn_imageswitcher = (Button) findViewById(R.id.btn_iswitcher);
		btn_imageswitcher.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,
						ImageSwitcherActivity.class);
				MainActivity.this.startActivity(i);
			}
		});

		Button btn_viewflipper = (Button) findViewById(R.id.btn_viewflipper);
		btn_viewflipper.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,
						ViewFlipperActivity.class);
				MainActivity.this.startActivity(i);
			}
		});

		Button btn_searchview = (Button) findViewById(R.id.btn_searchview);
		btn_searchview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,
						SearchViewActivity.class);
				MainActivity.this.startActivity(i);
			}
		});

		Button btn_tabhost = (Button) findViewById(R.id.btn_tabhost);
		btn_tabhost.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this, TabHostActivity.class);
				MainActivity.this.startActivity(i);
			}
		});

		Button btn_alertdialog = (Button) findViewById(R.id.btn_alertdialog);
		btn_alertdialog.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,
						AlertDialogActivity.class);
				MainActivity.this.startActivity(i);
			}
		});

		Button btn_menu = (Button) findViewById(R.id.btn_menu);
		btn_menu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this, MenuActivity.class);
				MainActivity.this.startActivity(i);
			}
		});

		Button btn_btab = (Button) findViewById(R.id.btn_actionbartab);
		btn_btab.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,
						ActionBarTabActivity.class);
				MainActivity.this.startActivity(i);
			}
		});

		Button btn_tabswipe = (Button) findViewById(R.id.btn_tabswipe);
		btn_tabswipe.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this, TabSwipeActivity.class);
				startActivity(i);
			}
		});

		Button btn_abardown = (Button) findViewById(R.id.btn_abardown);
		btn_abardown.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,
						AcionBarDownActivity.class);
				startActivity(i);
			}
		});

		Button btn_playgame = (Button) findViewById(R.id.btn_playgame);
		btn_playgame.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this, PlayGameActivity.class);
				startActivity(i);
			}
		});

		Button btn_drawview = (Button) findViewById(R.id.btn_drawview);
		btn_drawview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this, DrawViewActivity.class);
				startActivity(i);
			}
		});
		
		Button btn_handler = (Button) findViewById(R.id.btn_handler);
		btn_handler.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,HandlerActivity.class);
				startActivity(i);
			}
		});
		
		Button btn_cal = (Button) findViewById(R.id.btn_cal);
		btn_cal.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,CalPrimeActivity.class);
				startActivity(i);
			}
		});
		
		Button btn_asynctask = (Button) findViewById(R.id.btn_asynctask);
		btn_asynctask.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,AsyncTaskActivity.class);
				startActivity(i);
			}
		});
		
		Button btn_launcher = (Button) findViewById(R.id.btn_launcher);
		btn_launcher.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,LaunchersActivity.class);
				startActivity(i);
			}
		});
		
		Button btn_bundle = (Button) findViewById(R.id.btn_bundle);
		btn_bundle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,BundleActivity.class);
				startActivity(i);
			}
		});
		
		Button btn_forresult = (Button) findViewById(R.id.btn_forresult);
		btn_forresult.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,ForResultActivity.class);
				startActivity(i);
			}
		});
		
		Button btn_selectbook = (Button) findViewById(R.id.btn_selectbook);
		btn_selectbook.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,SelectBookActivity.class);
				startActivity(i);
			}
		});
		
		Button btn_sysaction = (Button) findViewById(R.id.btn_sysaction);
		btn_sysaction.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,SysAction.class);
				startActivity(i);
			}
		});
		
		Button btn_datatype = (Button) findViewById(R.id.btn_datatype);
		btn_datatype.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,DataTypeOverride.class);
				startActivity(i);
			}
		});
		
		Button btn_actioncate = (Button) findViewById(R.id.btn_catearr);
		btn_actioncate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,ActionCateAttr.class);
				startActivity(i);
			}
		});
		
		Button btn_datetype = (Button) findViewById(R.id.btn_datetype);
		btn_datetype.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,DateTypeActivity.class);
				startActivity(i);
			}
		});
		
		Button btn_actiondata = (Button) findViewById(R.id.btn_actiondata);
		btn_actiondata.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,ActionDataActivity.class);
				startActivity(i);
			}
		});
		
		Button btn_intenttab = (Button) findViewById(R.id.btn_intenttab);
		btn_intenttab.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,IntentTabActivity.class);
				startActivity(i);
			}
		});
		
		Button btn_valuetest = (Button) findViewById(R.id.btn_valuetest);
		btn_valuetest.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,ValuesResTest.class);
				startActivity(i);
			}
		});
		
		Button btn_arraytest = (Button) findViewById(R.id.btn_arraytest);
		btn_arraytest.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,ArrayResTest.class);
				startActivity(i);
			}
		});
		
		Button btn_statelist = (Button) findViewById(R.id.btn_statelist);
		btn_statelist.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,StateList.class);
				startActivity(i);
			}
		});
		
		Button btn_layer = (Button) findViewById(R.id.btn_layer);
		btn_layer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,Layer.class);
				startActivity(i);
			}
		});
		
		Button btn_shape = (Button) findViewById(R.id.btn_shape);
		btn_shape.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,ShapeTest.class);
				startActivity(i);
			}
		});
		
		Button btn_clipdraw = (Button) findViewById(R.id.btn_clipdraw);
		btn_clipdraw.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,ClipDrawActivity.class);
				startActivity(i);
			}
		});
		
		Button btn_animat = (Button) findViewById(R.id.btn_animat);
		btn_animat.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,AnimationDrawables.class);
				startActivity(i);
			}
		});
		
		Button btn_animator = (Button) findViewById(R.id.btn_animator);
		btn_animator.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,AnimatorTest.class);
				startActivity(i);
			}
		});
		
		Button btn_xmltest = (Button) findViewById(R.id.btn_xmlrestest);
		btn_xmltest.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,XmlResTest.class);
				startActivity(i);
			}
		});
		
		Button btn_style = (Button) findViewById(R.id.btn_style);
		btn_style.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,StyleTest.class);
				startActivity(i);
			}
		});
		
		Button btn_alpha = (Button) findViewById(R.id.btn_alphaimage);
		btn_alpha.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,AlphaTest.class);
				startActivity(i);
				
			}
		});
		
		Button btn_rawtest = (Button) findViewById(R.id.btn_rawrestest);
		btn_rawtest.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,RawResTest.class);
				startActivity(i);
			}
		});
		
		Button btn_i18n = (Button) findViewById(R.id.btn_i18n);
		btn_i18n.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,I18nTest.class);
				startActivity(i);
			}
		});
		
		Button btn_bitmap = (Button) findViewById(R.id.btn_bitmap);
		btn_bitmap.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,BitMapTest.class);
				startActivity(i);
			}
		});
		
		Button btn_canvas = (Button) findViewById(R.id.btn_canvas);
		btn_canvas.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,CanvasTest.class);
				startActivity(i);
			}
		});
		
		Button btn_path = (Button) findViewById(R.id.btn_path);
		btn_path.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,PathTest.class);
				startActivity(i);
			}
		});
		
		Button btn_pathtext = (Button) findViewById(R.id.btn_pathtext);
		btn_pathtext.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,PathTextTest.class);
				startActivity(i);
			}
		});
		
		Button btn_handdraw = (Button) findViewById(R.id.btn_handdraw);
		btn_handdraw.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,HandDraw.class);
				startActivity(i);
			}
		});
		
		Button btn_pinball = (Button) findViewById(R.id.btn_pinball);
		btn_pinball.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,PinBall.class);
				startActivity(i);
			}
		});
		
		Button btn_matrix = (Button) findViewById(R.id.btn_matrix);
		btn_matrix.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,MatrixActivity.class);
				startActivity(i);
			}
		});
		
		Button btn_move = (Button) findViewById(R.id.btn_move);
		btn_move.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,MoveBack.class);
				startActivity(i);
			}
		});
		
		Button btn_warp = (Button) findViewById(R.id.btn_warp);
		btn_warp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,WarpTest.class);
				startActivity(i);
			}
		});
		
		Button btn_shader = (Button) findViewById(R.id.btn_shader);
		btn_shader.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,ShaderTest.class);
				startActivity(i);
			}
		});
		
		Button btn_fatpo = (Button) findViewById(R.id.btn_FatPo);
		btn_fatpo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,FatPo.class);
				startActivity(i);
			}
		});
		
		Button btn_blast = (Button) findViewById(R.id.btn_blast);
		btn_blast.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,Blast.class);
				startActivity(i);
			}
		});
		
		Button btn_tweenanim = (Button) findViewById(R.id.btn_tweenanim);
		btn_tweenanim.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,TweenAnim.class);
				startActivity(i);
			}
		});
		
		Button btn_butter = (Button) findViewById(R.id.btn_butterfly);
		btn_butter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,Butterfly.class);
				startActivity(i);
			}
		});
		
		Button btn_listviewtween = (Button) findViewById(R.id.btn_listviewtween);
		btn_listviewtween.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,ListViewTween.class);
				startActivity(i);
			}
		});
		
		Button btn_animatortest = (Button) findViewById(R.id.btn_animatortest);
		btn_animatortest.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,AnimatorTestT.class);
				startActivity(i);
			}
		});
		
		Button btn_bouncingball = (Button) findViewById(R.id.btn_bouncingball);
		btn_bouncingball.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,BouncingBall.class);
				startActivity(i);
			}
		});
		
		Button btn_surface = (Button) findViewById(R.id.btn_surfaceview);
		btn_surface.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,SurfaceViewTest.class);
				startActivity(i);
			}
		});
		
		Button btn_showwave = (Button) findViewById(R.id.btn_showwave);
		btn_showwave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,ShowWave.class);
				startActivity(i);
			}
		});
		
		Button btn_sharepre = (Button) findViewById(R.id.btn_sharedpreferences);
		btn_sharepre.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,SharedPreferencesTest.class);
				startActivity(i);
			}
		});
		
		Button btn_usecount = (Button) findViewById(R.id.btn_usecount);
		btn_usecount.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,Usecount.class);
				startActivity(i);
			}
		});
		
		Button btn_filetest = (Button) findViewById(R.id.btn_filetest);
		btn_filetest.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,FileTest.class);
				startActivity(i);
			}
		});
		
		Button btn_sdcard = (Button) findViewById(R.id.btn_sdcadtest);
		btn_sdcard.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,SDCardTest.class);
				startActivity(i);
			}
		});
		
		Button btn_sdexplorer = (Button) findViewById(R.id.btn_sdexplorer);
		btn_sdexplorer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,SDFileExplorer.class);
				startActivity(i);
			}
		});
		
		Button btn_dbtest = (Button) findViewById(R.id.btn_dbtest);
		btn_dbtest.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,DBTest.class);
				startActivity(i);
			}
		});
		
		Button btn_dict = (Button) findViewById(R.id.btn_dict);
		btn_dict.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,Dict.class);
				startActivity(i);
			}
		});
		
		Button btn_gesturetest = (Button) findViewById(R.id.btn_gesturetest);
		btn_gesturetest.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,GestureTest.class);
				startActivity(i);
			}
		});
		
		Button btn_gesturezoom = (Button) findViewById(R.id.btn_gesturezoom);
		btn_gesturezoom.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,GestureZoom.class);
				startActivity(i);
			}
		});
		
		Button btn_gestureflip = (Button) findViewById(R.id.btn_gestureflip);
		btn_gestureflip.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,GestureFlip.class);
				startActivity(i);
			}
		});
		
		Button btn_addgesture = (Button) findViewById(R.id.btn_addgesture);
		btn_addgesture.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,AddGesture.class);
				startActivity(i);
			}
		});
		
		Button btn_recogniseGesture = (Button) findViewById(R.id.btn_recogesture);
		btn_recogniseGesture.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,RecogniseGesture.class);
				startActivity(i);
			}
		});
		
		Button btn_speech = (Button) findViewById(R.id.btn_speech);
		btn_speech.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,Speech.class);
				startActivity(i);
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.activity_main, menu);

		SubMenu fontMenu = menu.addSubMenu("字体大小");
		fontMenu.setIcon(R.drawable.bom1);
		fontMenu.setHeaderIcon(R.drawable.bom2);
		fontMenu.setHeaderTitle("选择字体大小");
		fontMenu.add(0, FONT_10, 0, "10号字体");
		fontMenu.add(0, FONT_12, 0, "12号字体");
		fontMenu.add(0, FONT_14, 0, "14号字体");
		fontMenu.add(0, FONT_16, 0, "16号字体");
		fontMenu.add(0, FONT_18, 0, "18号字体");
		menu.add(0, PLAIN_ITEM, 0, "普通菜单项");

		SubMenu colorMenu = menu.addSubMenu("字体颜色");
		colorMenu.setIcon(R.drawable.bom1);
		colorMenu.setHeaderIcon(R.drawable.bom2);
		colorMenu.setHeaderTitle("请选择文字颜色");
		colorMenu.add(0, FONT_RED, 0, "红色");
		colorMenu.add(0, FONT_GREEN, 0, "绿色");
		colorMenu.add(0, FONT_BLUE, 0, "蓝色");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem mi) {
		// TODO Auto-generated method stub

		switch (mi.getItemId()) {
		case FONT_10:
			edit.setTextSize(10 * 2);
			break;
		case FONT_12:
			edit.setTextSize(12 * 2);
			break;
		case FONT_14:
			edit.setTextSize(14 * 2);
			break;
		case FONT_16:
			edit.setTextSize(16 * 2);
			break;
		case FONT_18:
			edit.setTextSize(18 * 2);
			break;
		case FONT_RED:
			edit.setTextColor(Color.RED);
			break;
		case FONT_GREEN:
			edit.setTextColor(Color.GREEN);
			break;
		case FONT_BLUE:
			edit.setTextColor(Color.BLUE);
			break;
		case PLAIN_ITEM:
			Toast toast = Toast.makeText(MainActivity.this, "您点击了普通菜单项",
					Toast.LENGTH_LONG);
			toast.show();
			break;

		}

		return true;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View source,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub

		menu.add(0, MENU1, 0, "红色");
		menu.add(0, MENU2, 0, "绿色");
		menu.add(0, MENU3, 0, "蓝色");
		menu.setGroupCheckable(0, true, true);
		menu.setHeaderIcon(R.drawable.ic_launcher);
		menu.setHeaderTitle("选择背景色");

	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		switch (item.getItemId()) {
		case MENU1:
			edit.setBackgroundColor(Color.RED);
			break;
		case MENU2:
			edit.setBackgroundColor(Color.GREEN);
			break;
		case MENU3:
			edit.setBackgroundColor(Color.BLUE);
			break;
		}

		return true;
	}

}
