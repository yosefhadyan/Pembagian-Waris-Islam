package id.barkost.waris;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class Splash extends Activity {

	MediaPlayer audio;
	ProgressBar a;
	ImageView image;
	Animation anim, overshoot;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
				
		setContentView(R.layout.splash);
		a = (ProgressBar) findViewById(R.id.progressBar1);
		image = (ImageView) findViewById(R.id.image_splash);
		
		overshoot = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.overshoot);
		image.setAnimation(overshoot);
		a.setVisibility(View.GONE);
		a.getIndeterminateDrawable().setColorFilter(0xFF33FF33,android.graphics.PorterDuff.Mode.MULTIPLY);
		
		audio = MediaPlayer.create(this, R.raw.bismillah);
		try {
			audio.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		showMain();
		showProgressbar();
	}
	
	public void showProgressbar() {
		anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.appear);
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				a.setVisibility(View.VISIBLE);
				a.startAnimation(anim);
			}
		}, 3000);
	}
	
	public void showMain() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent i = new Intent(Splash.this, MainActivity.class);
				startActivity(i);
				finish();
				overridePendingTransition(R.anim.appear, R.anim.disappear);
				audio.start();
			}
		}, 5000);
	}
	
	@Override
	public void onBackPressed() {}
	
	@Override
	public void onPause() {
	    super.onPause();
	    if (audio.isPlaying() == true) {
	    	audio.pause();
	    }
	}
	
	@Override
	public void onResume() {
	    super.onResume();
	    if (audio.isPlaying() == true) {
	    	audio.start();
	    }
	}
}
