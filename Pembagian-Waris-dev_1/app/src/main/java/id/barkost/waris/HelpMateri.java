package id.barkost.waris;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HelpMateri extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help_materi);
		
		DisplayMetrics displaymetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int width = displaymetrics.widthPixels;
		int new_w = (width / 9) * 8;
		
		ImageView a = (ImageView) findViewById(R.id.img_materi1);
		a.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_w));
		ImageView b = (ImageView) findViewById(R.id.img_materi2);
		b.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_w));
		ImageView c = (ImageView) findViewById(R.id.img_materi3);
		c.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_w));
		
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
			}
		}, 300);
	}
	
	@Override
	public void onBackPressed() {
		finish();
		overridePendingTransition(R.anim.stand, R.anim.exit_to_bottom);
	}
}
