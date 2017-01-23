package id.barkost.waris;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ScrollView;
import android.widget.TextView;

@SuppressLint("SetJavaScriptEnabled")
public class MateriCnt extends Activity {

	public static int pos;
	public TextView head;
	public ScrollView scroll_cnt;
	public WebView view;
	public String desc;
	Animation anim;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.materi_cnt);
		
		anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.enter_from_bottom);
		scroll_cnt = (ScrollView) findViewById(R.id.scroll_cnt);
		
		head = (TextView) findViewById(R.id.materi_head);
		
		view = (WebView) findViewById(R.id.textContent);
		
		scroll_cnt.setVisibility(View.GONE);
		
		switch (pos){
		case 0:
			head.setText(getResources().getString(R.string.mat_definisi));
			desc = getResources().getString(R.string.mat_definisi_desc);
			break;
		case 1:
			head.setText(getResources().getString(R.string.mat_hadits));
			desc = getResources().getString(R.string.mat_hadits_desc);
			break;
		case 2:
			head.setText(getResources().getString(R.string.mat_hak_waris));
			desc = getResources().getString(R.string.mat_hak_waris_desc);
			break;
		case 3:
			head.setText(getResources().getString(R.string.mat_rukun_waris));
			desc = getResources().getString(R.string.mat_rukun_waris_desc);
			break;
		case 4:
			head.setText(getResources().getString(R.string.mat_syarat_waris));
			desc = getResources().getString(R.string.mat_syarat_waris_desc);
			break;
		case 5:
			head.setText(getResources().getString(R.string.mat_penghalang_waris));
			desc = getResources().getString(R.string.mat_penghalang_waris_desc);
			break;
		default:
			break;
		}
		
		show();
		
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				scroll_cnt.setVisibility(View.VISIBLE);
				scroll_cnt.startAnimation(anim);
				getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
			}
		}, 1000);
	}
	
	public void show() {
		String text = "<html xmlns=\"http://www.w3.org/1999/xhtml\"><p align=\"justify\">" + desc + "</p></body></html>";
		WebSettings webSetting = view.getSettings();
		webSetting.setJavaScriptEnabled(true);
		view.setBackgroundColor(Color.TRANSPARENT);
		view.loadData(text, "text/html; charset=utf-8", null);
	}
	
	public void onBackPressed() {
		finish();
		overridePendingTransition(R.anim.stand, R.anim.slide_to_right);
	}
}
