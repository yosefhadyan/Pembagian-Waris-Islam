package id.barkost.waris;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class MateriAyat extends Activity {

	public static int pos;
	public TextView head, cnt;
	public ScrollView scroll_cnt;
	public WebView view, view1, view2, view3;
	public Button sound1, sound2, sound3;
	public String desc, desc1, desc2, desc3;
	Animation anim;
	MediaPlayer audio1, audio2, audio3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.materi_ayat);
		anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.enter_from_bottom);
		scroll_cnt = (ScrollView) findViewById(R.id.scroll_cnt);
		scroll_cnt.setVisibility(View.GONE);
		
		audio1 = MediaPlayer.create(this, R.raw.annisa11);
		audio2 = MediaPlayer.create(this, R.raw.annisa12);
		audio3 = MediaPlayer.create(this, R.raw.annisa176);
		
		head = (TextView) findViewById(R.id.materi_head);
		
		view = (WebView) findViewById(R.id.textContent);
		view1 = (WebView) findViewById(R.id.textContent1);
		view2 = (WebView) findViewById(R.id.textContent2);
		view3 = (WebView) findViewById(R.id.textContent3);
		
		sound1 = (Button) findViewById(R.id.btn_ayat1);
		sound2 = (Button) findViewById(R.id.btn_ayat2);
		sound3 = (Button) findViewById(R.id.btn_ayat3);
		
		head.setText(getResources().getString(R.string.mat_ayat));
		desc = getResources().getString(R.string.mat_ayat_desc);		
		desc1 = getResources().getString(R.string.mat_ayat_desc1);
		desc2 = getResources().getString(R.string.mat_ayat_desc2);
		desc3 = getResources().getString(R.string.mat_ayat_desc3);
		
		
		
		String text = "<html><body><p align=\"justify\">" + desc + "</p></body></html>";
		String text1 = "<html><body><p align=\"justify\">" + desc1 + "</p></body></html>";
		String text2 = "<html><body><p align=\"justify\">" + desc2 + "</p></body></html>";
		String text3 = "<html><body><p align=\"justify\">" + desc3 + "</p></body></html>";
		view.setBackgroundColor(Color.TRANSPARENT);
		view1.setBackgroundColor(Color.TRANSPARENT);
		view2.setBackgroundColor(Color.TRANSPARENT);
		view3.setBackgroundColor(Color.TRANSPARENT);
		view.loadData(text, "text/html; charset=utf-8", null);
		view1.loadData(text1, "text/html; charset=utf-8", null);
		view2.loadData(text2, "text/html; charset=utf-8", null);
		view3.loadData(text3, "text/html; charset=utf-8", null);
		
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				scroll_cnt.setVisibility(View.VISIBLE);
				scroll_cnt.startAnimation(anim);
				getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
			}
		}, 1000);
	}
	
	public void play(final MediaPlayer a, final MediaPlayer b, final MediaPlayer c){
		try {
			if (a.isPlaying() == true) {
				a.pause();
				a.seekTo(0);
			} else if (b.isPlaying() == true) {
				b.pause();
				b.seekTo(0);
			} else if (c.isPlaying() == true) {
				c.pause();
				c.seekTo(0);
			} 
			
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					a.start();
				}
			}, 500);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void stop(View v){
		try {
			if (audio1.isPlaying() == true) {
				audio1.pause();
				audio1.seekTo(0);
			} else if (audio2.isPlaying() == true) {
				audio2.pause();
				audio2.seekTo(0);
			} else if (audio3.isPlaying() == true) {
				audio3.pause();
				audio3.seekTo(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void play1(View v){
		play(audio1, audio2, audio3);
	}
	
	public void play2(View v){
		play(audio2, audio1, audio3);
	}
	
	public void play3(View v){
		play(audio3, audio2, audio1);
	}
	
	@Override
	public void onPause() {
	    super.onPause();
	    audio1.pause();
	    audio2.pause();
	    audio3.pause();
	}
	
	@Override
	public void onResume() {
		super.onResume();
	}
	
	public void onBackPressed() {
		finish();
		overridePendingTransition(R.anim.stand, R.anim.slide_to_right);
		audio1.stop();
		audio2.stop();
		audio3.stop();
	}
}
