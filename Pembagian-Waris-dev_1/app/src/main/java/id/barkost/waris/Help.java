package id.barkost.waris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class Help extends Activity {

	Animation anim1, anim2;
	public Button b1, b2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);

		b1 = (Button) findViewById(R.id.help_hitung);
		b2 = (Button) findViewById(R.id.help_materi);
		b1.setVisibility(View.GONE);
		b2.setVisibility(View.GONE);
		
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				anim1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_from_right);
				anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_from_left);
				b1.setVisibility(View.VISIBLE);
				b2.setVisibility(View.VISIBLE);
				b1.setAnimation(anim1);
				b2.setAnimation(anim2);
			}
		}, 800);
	}
	
	public void onClick(View view) {
		Intent d = null;
		switch (view.getId()) {
		case R.id.help_hitung:
			d = new Intent(Help.this, HelpHitung.class);
			break;
		case R.id.help_materi:
			d = new Intent(Help.this, HelpMateri.class);
			break;
		default:
			break;
		}
		startActivity(d);
		overridePendingTransition(R.anim.enter_from_bottom, R.anim.stand);
	}
	
	public void onBackPressed() {
		finish();
		overridePendingTransition(R.anim.stand, R.anim.exit_to_bottom);
	}
}
