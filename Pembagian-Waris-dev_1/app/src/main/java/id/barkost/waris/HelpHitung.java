package id.barkost.waris;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HelpHitung extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help_hitung);
		
		DisplayMetrics displaymetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int width = displaymetrics.widthPixels;
		int new_w = (width / 9) * 8;
		
		ImageView a = (ImageView) findViewById(R.id.img_hitung1);
		a.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_w));
		ImageView b = (ImageView) findViewById(R.id.img_hitung2);
		b.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_w));
		ImageView c = (ImageView) findViewById(R.id.img_hitung3);
		c.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_w));
		ImageView d = (ImageView) findViewById(R.id.img_hitung4);
		d.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_w));
		ImageView e = (ImageView) findViewById(R.id.img_hitung5);
		e.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_w));
		ImageView f = (ImageView) findViewById(R.id.img_hitung6);
		f.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_w));
		ImageView g = (ImageView) findViewById(R.id.img_hitung7);
		g.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_w));
		ImageView h = (ImageView) findViewById(R.id.img_hitung8);
		h.setLayoutParams(new LinearLayout.LayoutParams(new_w, new_w));
		
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
