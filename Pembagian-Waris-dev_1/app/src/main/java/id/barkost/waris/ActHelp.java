package id.barkost.waris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ActHelp extends Activity {

	public ImageView image;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_help);
		
		image = (ImageView) findViewById(R.id.img_hand);
		image.setVisibility(View.GONE);
		
		new Handler().postDelayed(new Runnable() {
			Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.hand_up);
			@Override
			public void run() {
				image.setVisibility(View.VISIBLE);
				image.startAnimation(anim);
			}
		}, 1000);
	}
	
	public void dismiss(View v) {
		Intent i = new Intent(ActHelp.this, Help.class);
		startActivity(i);
		overridePendingTransition( R.anim.enter_from_bottom, R.anim.disappear);
		finish();
    }
}