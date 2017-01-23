package id.barkost.waris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class Materi extends Activity {

	public Button a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;
	public ScrollView scroll;
	Animation anim1, anim2, anim;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.materi);
		
		DisplayMetrics displaymetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int width = displaymetrics.widthPixels;
		int height = displaymetrics.heightPixels;
		int new_h = height / 11;
		int new_w = width;
		
		a1 = (Button) findViewById(R.id.mat_definisi);
		a2 = (Button) findViewById(R.id.mat_hadits);
		a3 = (Button) findViewById(R.id.mat_hak);
		a4 = (Button) findViewById(R.id.mat_rukun);
		a5 = (Button) findViewById(R.id.mat_sebab);
		a6 = (Button) findViewById(R.id.mat_penghalang);
		a7 = (Button) findViewById(R.id.mat_masalah);
		a8 = (Button) findViewById(R.id.mat_ayat);
		a9 = (Button) findViewById(R.id.mat_ahli);
		a10 = (Button) findViewById(R.id.mat_pohon);
		a1.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_h));
		a2.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_h));
		a3.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_h));
		a4.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_h));
		a5.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_h));
		a6.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_h));
		a7.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_h));
		a8.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_h));
		a9.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_h));
		a10.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_h));
		
		a1.setVisibility(View.GONE);
		a2.setVisibility(View.GONE);
		a3.setVisibility(View.GONE);
		a4.setVisibility(View.GONE);
		a5.setVisibility(View.GONE);
		a6.setVisibility(View.GONE);
		a7.setVisibility(View.GONE);
		a8.setVisibility(View.GONE);
		a9.setVisibility(View.GONE);
		a10.setVisibility(View.GONE);
		
		trans();
	}
	
	public void trans() {
		anim1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_from_right);
		anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_from_left);
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				a1.setVisibility(View.VISIBLE);
				a2.setVisibility(View.VISIBLE);
				a3.setVisibility(View.VISIBLE);
				a4.setVisibility(View.VISIBLE);
				a5.setVisibility(View.VISIBLE);
				a6.setVisibility(View.VISIBLE);
				a7.setVisibility(View.VISIBLE);
				a8.setVisibility(View.VISIBLE);
				a9.setVisibility(View.VISIBLE);
				a10.setVisibility(View.VISIBLE);
				a1.setAnimation(anim1);
				a2.setAnimation(anim2);
				a3.setAnimation(anim1);
				a4.setAnimation(anim2);
				a5.setAnimation(anim1);
				a6.setAnimation(anim2);
				a7.setAnimation(anim1);
				a8.setAnimation(anim2);
				a9.setAnimation(anim1);
				a10.setAnimation(anim2);
			}
		}, 800);
	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.mat_definisi:
			MateriCnt.pos = 0;
			call();
			break;
		case R.id.mat_hadits:
			MateriCnt.pos = 1;
			call();
			break;
		case R.id.mat_hak:
			MateriCnt.pos = 2;
			call();
			break;
		case R.id.mat_rukun:
			MateriCnt.pos = 3;
			call();
			break;
		case R.id.mat_sebab:
			MateriCnt.pos = 4;
			call();
			break;
		case R.id.mat_penghalang:
			MateriCnt.pos = 5;
			call();
			break;
		case R.id.mat_masalah:
			Intent c = new Intent(Materi.this, MateriMasalah.class);
			startActivity(c);
			overridePendingTransition(R.anim.slide_from_right, R.anim.stand);
			break;
		case R.id.mat_ayat:
			Intent i = new Intent(Materi.this, MateriAyat.class);
			startActivity(i);
			overridePendingTransition(R.anim.slide_from_right, R.anim.stand);
			break;
		case R.id.mat_ahli:
			Intent a = new Intent(Materi.this, MateriAhli.class);
			startActivity(a);
			overridePendingTransition(R.anim.slide_from_right, R.anim.stand);
			break;
		case R.id.mat_pohon:
			Intent d = new Intent(Materi.this, MateriPohon.class);
			startActivity(d);
			overridePendingTransition(R.anim.slide_from_right, R.anim.stand);
			break;
		default:
			break;
		}
	}
	
	public void call(){
		Intent i = new Intent(Materi.this, MateriCnt.class);
		startActivity(i);
		overridePendingTransition(R.anim.slide_from_right, R.anim.stand);
	}

	public void onBackPressed() {
		finish();
		overridePendingTransition(R.anim.stand, R.anim.exit_to_bottom);
	}
}
