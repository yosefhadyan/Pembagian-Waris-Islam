package id.barkost.waris;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MateriMasalahCnt extends Activity {

	public static int pos;
	public TextView head;
	public WebView cnt;
	public String desc;
	Animation anim;
	public ScrollView scroll_cnt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.materi_masalah_cnt);
		
		head = (TextView) findViewById(R.id.materi_masalah_head);
		cnt = (WebView) findViewById(R.id.text_masalah_cnt);
		
		anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.enter_from_bottom);
		scroll_cnt = (ScrollView) findViewById(R.id.scroll_cnt_masalah);
		scroll_cnt.setVisibility(View.GONE);
		
		switch (pos){
		case 0:
			head.setText(getResources().getString(R.string.mat_masalah_1_head));
			desc = getResources().getString(R.string.mat_masalah_1_desc);
			break;
		case 1:
			head.setText(getResources().getString(R.string.mat_masalah_2_head));
			desc = getResources().getString(R.string.mat_masalah_2_desc);
			break;
		case 2:
			head.setText(getResources().getString(R.string.mat_masalah_3_head));
			desc = getResources().getString(R.string.mat_masalah_3_desc);
			break;
		case 3:
			head.setText(getResources().getString(R.string.mat_masalah_4_head));
			desc = getResources().getString(R.string.mat_masalah_4_desc);
			break;
		case 4:
			head.setText(getResources().getString(R.string.mat_masalah_5_head));
			desc = getResources().getString(R.string.mat_masalah_5_desc);
			break;
		case 5:
			head.setText(getResources().getString(R.string.mat_masalah_6_head));
			desc = getResources().getString(R.string.mat_masalah_6_desc);
			break;
		case 6:
			head.setText(getResources().getString(R.string.mat_masalah_7_head));
			desc = getResources().getString(R.string.mat_masalah_7_desc);
			break;
		default:
			break;
		}
		
		cnt.setBackgroundColor(Color.TRANSPARENT);
		cnt.loadData("<html><body><p align=\"justify\">" + desc + "</p></body></html>", "text/html; charset=utf-8", null);
		
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
				scroll_cnt.setVisibility(View.VISIBLE);
				scroll_cnt.startAnimation(anim);
			}
		}, 1000);
	}
	
	public void onBackPressed() {
		finish();
		overridePendingTransition(R.anim.stand, R.anim.slide_to_right);
	}
}
