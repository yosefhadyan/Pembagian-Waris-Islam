package id.barkost.waris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MateriMasalah extends Activity {

	public Button a1, a2, a3, a4, a5, a6, a7;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.materi_masalah);
		
		DisplayMetrics displaymetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int width = displaymetrics.widthPixels;
		int height = displaymetrics.heightPixels;
		int new_h = height / 11;
		int new_w = width;
		
		a1 = (Button) findViewById(R.id.mat_masalah1);
		a2 = (Button) findViewById(R.id.mat_masalah2);
		a3 = (Button) findViewById(R.id.mat_masalah3);
		a4 = (Button) findViewById(R.id.mat_masalah4);
		a5 = (Button) findViewById(R.id.mat_masalah5);
		a6 = (Button) findViewById(R.id.mat_masalah6);
		a7 = (Button) findViewById(R.id.mat_masalah7);
		a1.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_h));
		a2.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_h));
		a3.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_h));
		a4.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_h));
		a5.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_h));
		a6.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_h));
		a7.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_h));
		
		
	}
	
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.mat_masalah1:
			MateriMasalahCnt.pos = 0;
			break;
		case R.id.mat_masalah2:
			MateriMasalahCnt.pos = 1;
			break;
		case R.id.mat_masalah3:
			MateriMasalahCnt.pos = 2;
			break;
		case R.id.mat_masalah4:
			MateriMasalahCnt.pos = 3;
			break;
		case R.id.mat_masalah5:
			MateriMasalahCnt.pos = 4;
			break;
		case R.id.mat_masalah6:
			MateriMasalahCnt.pos = 5;
			break;
		case R.id.mat_masalah7:
			MateriMasalahCnt.pos = 6;
			break;
		default:
			break;
		}
		
		Intent i = new Intent(MateriMasalah.this, MateriMasalahCnt.class);
		startActivity(i);
		overridePendingTransition(R.anim.slide_from_right, R.anim.stand);
	}
	
	public void onBackPressed() {
		finish();
		overridePendingTransition(R.anim.stand, R.anim.slide_to_right);
	}
}
