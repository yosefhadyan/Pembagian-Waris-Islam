package id.barkost.waris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ScrollView;
import android.widget.TextView;

public class Hitung1 extends Activity {

	public Button buttonNext, buttonBack;
	public TextView t_s1, t_s1_desc, t_kelamin, t_status, t_anak;
	public ScrollView scroll;
	public RadioGroup r_kelamin, r_status, r_anak;
	public RadioButton r_kelamin_l, r_kelamin_p, r_status_nikah_y, r_status_nikah_t, r_status_nikah_c, r_anak_y, r_anak_t;
	public boolean kelamin, status, anak, tampil_anak;

	Animation anim_fade_in, anim_slide, anim_appear;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hitung1);
		
		setAnim();
		
		scroll = (ScrollView) findViewById(R.id.sv_content);
		
		// -- Deskripsi step 1
		t_s1 = (TextView) findViewById(R.id.tx_s1_title);
		t_s1.setVisibility(View.GONE);
		t_s1_desc = (TextView) findViewById(R.id.tx_s1_desc);
		t_s1_desc.setVisibility(View.GONE);
		
		// -- Kelamin
		t_kelamin = (TextView) findViewById(R.id.tx_kelamin);
		t_kelamin.setVisibility(View.GONE);
		r_kelamin_l = (RadioButton) findViewById(R.id.radioLaki);
		r_kelamin_p = (RadioButton) findViewById(R.id.radioPerempuan);
		r_kelamin = (RadioGroup) findViewById(R.id.radioKelamin);
		r_kelamin.setVisibility(View.GONE);
		r_kelamin.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	        @Override
	        public void onCheckedChanged(RadioGroup group, int checkedId) {
	        	
	        	scroll.post(new Runnable() {
	        	    @Override
	        	    public void run() {
	        	        scroll.fullScroll(ScrollView.FOCUS_DOWN);
	        	    }
	        	});
	        	
	        	if(r_kelamin_l.isChecked()) {
	        		Hitung2.perempuan = false;
	        		Hitung3.kelamin = "laki-laki";
	        	} else if (r_kelamin_p.isChecked()) {
	        		Hitung3.kelamin = "perempuan";
	        		Hitung2.perempuan = true;
                }
	        	
	        	if (kelamin == false){
	        		t_status.setVisibility(View.VISIBLE);
					r_status.setVisibility(View.VISIBLE);
					t_status.startAnimation(anim_fade_in);
					r_status.startAnimation(anim_fade_in);
	        	}
				kelamin = true;
				check();
	        }
	        
	    });
		
		// -- Status Nikah
		t_status = (TextView) findViewById(R.id.tx_status);
		t_status.setVisibility(View.GONE);
		r_status_nikah_y = (RadioButton) findViewById(R.id.radioNikah);
		r_status_nikah_t = (RadioButton) findViewById(R.id.radioTNikah);
		r_status_nikah_c = (RadioButton) findViewById(R.id.radioCerai);
		r_status = (RadioGroup) findViewById(R.id.radioStatus);
		r_status.setVisibility(View.GONE);
		r_status.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	        @Override
	        public void onCheckedChanged(RadioGroup group, int checkedId) {
	        	
	        	scroll.post(new Runnable() {
	        	    @Override
	        	    public void run() {
	        	        scroll.fullScroll(ScrollView.FOCUS_DOWN);
	        	    }
	        	});
	        	
	        	if(r_status_nikah_y.isChecked()) {
	        		Hitung3.nikah = "nikah";
	        		if (status == false){
		        		t_anak.setVisibility(View.VISIBLE);
						r_anak.setVisibility(View.VISIBLE);
						t_anak.startAnimation(anim_fade_in);
						r_anak.startAnimation(anim_fade_in);
		        	}
	        		
	        		if (tampil_anak == false){
		        		t_anak.setVisibility(View.VISIBLE);
						r_anak.setVisibility(View.VISIBLE);
						t_anak.startAnimation(anim_fade_in);
						r_anak.startAnimation(anim_fade_in);
		        	}
	        		tampil_anak = true;
	        		Hitung3.nikah = "nikah";
	        		Hitung2.nikah = true;
	        	} else if (r_status_nikah_t.isChecked()) {
	        		Hitung3.nikah = "tidak nikah";
	        		r_anak_t.setChecked(true);
	        		t_anak.setVisibility(View.GONE);
					r_anak.setVisibility(View.GONE);
					tampil_anak = false;
					Hitung3.nikah = "tidak nikah";
					Hitung2.nikah = false;
                } else if (r_status_nikah_c.isChecked()) {
                	Hitung3.nikah = "cerai";
                	if (status == false){
    	        		t_anak.setVisibility(View.VISIBLE);
    					r_anak.setVisibility(View.VISIBLE);
    					t_anak.startAnimation(anim_fade_in);
    					r_anak.startAnimation(anim_fade_in);
    	        	}
                	if (tampil_anak == false){
    	        		t_anak.setVisibility(View.VISIBLE);
    					r_anak.setVisibility(View.VISIBLE);
    					t_anak.startAnimation(anim_fade_in);
    					r_anak.startAnimation(anim_fade_in);
    	        	}
                	tampil_anak = true;
                	Hitung3.nikah = "cerai";
                	Hitung2.nikah = false;
                }
	        	status = true;
	        	check();
	        }
	    });
		
		// -- Status Anak
		t_anak = (TextView) findViewById(R.id.tx_anak);
		t_anak.setVisibility(View.GONE);
		r_anak_y = (RadioButton) findViewById(R.id.radioAnakYa);
		r_anak_t = (RadioButton) findViewById(R.id.radioAnakTidak);
		r_anak = (RadioGroup) findViewById(R.id.radioAnak);
		r_anak.setVisibility(View.GONE);
		r_anak.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
		    public void onCheckedChanged(RadioGroup group, int checkedId) {
				if(r_anak_y.isChecked()) {
					Hitung3.anak = "ya";
				} else if (r_anak_t.isChecked()) {
					Hitung3.anak = "tidak";
				}
				anak = true;
				check();
			}
		});
		
		// -- Button next
		buttonNext = (Button) findViewById(R.id.btn_next_1);
		buttonNext.setEnabled(false);
		buttonNext.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(Hitung1.this, Hitung2.class);
				startActivity(i);
				overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
			}
		});
		
		// -- Button back
		buttonBack = (Button) findViewById(R.id.btn_back_1);
		buttonBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				reset();
				Intent i = new Intent(Hitung1.this, AdsActivity.class);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
				finish();
				//overridePendingTransition(R.anim.stand, R.anim.exit_to_bottom);
			}
		});
		
		trans1();
		trans2();
		trans3();
	}
	
	public void setAnim() {
		anim_appear = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.appear);
		anim_slide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_from_right);
		anim_fade_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_and_scale_in);
	}
	
	public void check() {
		if (kelamin == true && status == true && anak == true) {
			buttonNext.setEnabled(true);
		}
	}
	
	public void trans1() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				t_s1.setVisibility(View.VISIBLE);
				t_s1.startAnimation(anim_slide);
			}
		}, 1000);
	}
	
	public void trans2() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				t_s1_desc.setVisibility(View.VISIBLE);
				t_s1_desc.startAnimation(anim_appear);
			}
		}, 2500);
	}
	
	public void trans3() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				t_kelamin.setVisibility(View.VISIBLE);
				r_kelamin.setVisibility(View.VISIBLE);
				t_kelamin.startAnimation(anim_fade_in);
				r_kelamin.startAnimation(anim_fade_in);
			}
		}, 4000);
	}
	
	public void reset() {
		Varr.iJumlahBapak = 0;
		Varr.iJumlahIbu = 0;
		Varr.iJumlahSuami = 0;
		Varr.iJumlahIstri = 0;
		Varr.iJumlahAnakLaki = 0;
		Varr.iJumlahAnakPerempuan = 0;
		Varr.iJumlahCucuLaki = 0;
		Varr.iJumlahCucuPerempuan = 0;
		Varr.iJumlahKakek = 0;
		Varr.iJumlahNenekBapak = 0;
		Varr.iJumlahNenekIbu = 0;
		Varr.iJumlahNenekKakek = 0;
		Varr.iJumlahSaudaraKandung = 0;
		Varr.iJumlahSaudariKandung = 0;
		Varr.iJumlahSaudaraSebapak = 0;
		Varr.iJumlahSaudaraSeibu = 0;
		Varr.iJumlahSaudariSebapak = 0;
		Varr.iJumlahSaudariSeibu = 0;
		Varr.iJumlahPutraSaudaraKandung = 0;
		Varr.iJumlahPutraSaudaraSebapak = 0;
		Varr.iJumlahPamanKandung = 0;
		Varr.iJumlahPamanSebapak = 0;
		Varr.iJumlahPutraPamanKandung = 0;
		Varr.iJumlahPutraPamanSebapak = 0;
		Varr.iJumlahPriaMerdekakan = 0;
		Varr.iJumlahWanitaMerdekakan = 0;
		Varr.iHarta = 0;
		Varr.tarikah = 0;
		Varr.hak1 = 0;
		Varr.hak2 = 0;
		Varr.hak3 = 0;
		Varr.hak4 = 0;
	}
	
	public void onBackPressed() { 
		reset();
		finish();
		overridePendingTransition(R.anim.stand, R.anim.exit_to_bottom);
	}
}