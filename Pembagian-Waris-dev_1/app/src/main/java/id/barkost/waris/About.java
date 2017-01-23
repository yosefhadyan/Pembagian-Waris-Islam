package id.barkost.waris;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;

public class About extends Activity {

	Animation anim;
	public ScrollView scroll_cnt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);

		anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.enter_from_bottom);
		scroll_cnt = (ScrollView) findViewById(R.id.sc_about);
		scroll_cnt.setVisibility(View.GONE);
		
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				scroll_cnt.setVisibility(View.VISIBLE);
				scroll_cnt.startAnimation(anim);
			}
		}, 700);
	}
	
	public void onBackPressed() {
		finish();
		overridePendingTransition(R.anim.stand, R.anim.exit_to_bottom);
	}
}
