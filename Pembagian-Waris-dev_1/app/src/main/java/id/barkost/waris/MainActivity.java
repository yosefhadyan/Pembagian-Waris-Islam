package id.barkost.waris;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends Activity {

	public Button a, b, c, d;
	public ImageView image, image_f;
	public LinearLayout lin1, lin2;
	Animation slideL, slideR;
	
	private SharedPreferences prefs;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544~3347511713");

		AdView mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder()
				.build();

		//.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
		//.addTestDevice("0FA8A5448D208DD028A7697842BB9A6C")

		mAdView.loadAd(adRequest);

		slideL = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_from_left);
		slideR = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_from_right);
		
		DisplayMetrics displaymetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int width = displaymetrics.widthPixels;
		int new_w = width / 3;
		
		lin1 = (LinearLayout) findViewById(R.id.lay1);
		lin1.setVisibility(View.GONE);
		lin2 = (LinearLayout) findViewById(R.id.lay2);
		lin2.setVisibility(View.GONE);
		
//		image = (ImageView) findViewById(R.id.logo_main);
//		image.setLayoutParams(new RelativeLayout.LayoutParams(width, width));
//		image.setVisibility(View.GONE);
//		image_f = (ImageView) findViewById(R.id.logo_f);
//		image_f.setLayoutParams(new RelativeLayout.LayoutParams(width, width));
//		image_f.setVisibility(View.GONE);
		
		a = (Button) findViewById(R.id.btn_hitung);
		a.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_w));
		b = (Button) findViewById(R.id.btn_materi);
		b.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_w));
		c = (Button) findViewById(R.id.btn_help);
		c.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_w));
		d = (Button) findViewById(R.id.btn_about);
		d.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_w));
		
//		trans1();
		
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				prefs = getPreferences(Context.MODE_PRIVATE);
			    if (prefs.getBoolean("firstLaunch", true)) {
			        prefs.edit().putBoolean("firstLaunch", false).commit();
			        startActivity(new Intent(getApplicationContext(), ActHelp.class));
			        overridePendingTransition( R.anim.appear, R.anim.stand);
			    }
			}
		}, 1500);
		
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				lin1.setVisibility(View.VISIBLE);
				lin2.setVisibility(View.VISIBLE);
				lin1.startAnimation(slideL);
				lin2.startAnimation(slideR);
			}
		}, 1500);
	}
	
	public void klik (View v) {
		Intent i;
		switch (v.getId()) {
		case R.id.btn_hitung:
			i = new Intent(MainActivity.this,Hitung1.class);
			startActivity(i);
			break;
		case R.id.btn_materi:
			i = new Intent(MainActivity.this,Materi.class);
			startActivity(i);
			break;
		case R.id.btn_about:
			i = new Intent(MainActivity.this,About.class);
			startActivity(i);
			break;
		case R.id.btn_help:
			i = new Intent(MainActivity.this,Help.class);
			startActivity(i);
			break;
		default :
			break;
		}		
		overridePendingTransition( R.anim.enter_from_bottom, R.anim.stand);
	}

	@Override
	public void onBackPressed() {
		new AlertDialog.Builder(this)
				.setTitle(getResources().getString(R.string.confirm))
				.setMessage(getResources().getString(R.string.exit))
				.setCancelable(false)
				.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
					@SuppressWarnings("deprecation")
					public void onClick(DialogInterface dialog,int id) {
						finish();
						System.runFinalizersOnExit(true);
						android.os.Process.killProcess(android.os.Process.myPid());
					}
				})
				.setNegativeButton(getResources().getString(R.string.no), null)
				.show();
	}
}
