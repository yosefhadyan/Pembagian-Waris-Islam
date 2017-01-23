package id.barkost.waris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Hitung5 extends Activity {

	public Button buttonNext, buttonBack;
	public TextView tSaudaraKandung, tSaudariKandung, tSaudaraSebapak, tSaudariSebapak, tSaudaraSeibu, tSaudariSeibu, hSaudaraKandung, hSaudariKandung, hSaudaraSebapak, hSaudariSebapak, hSaudaraSeibu, hSaudariSeibu;
	public EditText editSaudaraKandung, editSaudariKandung, editSaudaraSebapak, editSaudariSebapak, editSaudaraSeibu, editSaudariSeibu;
	public LinearLayout linear;
	
	Animation anim_fade_in, anim_slide, anim_appear, hitung_disappear;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hitung5);
		
		anim_appear = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.appear);
		anim_slide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_from_right);
		anim_fade_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_and_scale_in);
		hitung_disappear = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.hitung_disappear);
		
		linear = (LinearLayout) findViewById(R.id.linear_hit3);
		linear.setVisibility(View.GONE);
		
		tSaudaraKandung = (TextView) findViewById(R.id.textSaudaraKandung);
		hSaudaraKandung = (TextView) findViewById(R.id.terhalangSaudaraKandung);
		editSaudaraKandung = (EditText) findViewById(R.id.editSaudaraKandung);
		onFocus(editSaudaraKandung);
		listener(editSaudaraKandung);
		
		tSaudariKandung = (TextView) findViewById(R.id.textSaudariKandung);
		hSaudariKandung = (TextView) findViewById(R.id.terhalangSaudariKandung);
		editSaudariKandung = (EditText) findViewById(R.id.editSaudariKandung);
		onFocus(editSaudariKandung);
		listener(editSaudariKandung);
		
		tSaudaraSebapak = (TextView) findViewById(R.id.textSaudaraSebapak);
		hSaudaraSebapak = (TextView) findViewById(R.id.terhalangSaudaraSebapak);
		editSaudaraSebapak = (EditText) findViewById(R.id.editSaudaraSebapak);
		onFocus(editSaudaraSebapak);
		listener(editSaudaraSebapak);
		
		tSaudariSebapak = (TextView) findViewById(R.id.textSaudariSebapak);
		hSaudariSebapak = (TextView) findViewById(R.id.terhalangSaudariSebapak);
		editSaudariSebapak = (EditText) findViewById(R.id.editSaudariSebapak);
		onFocus(editSaudariSebapak);
		listener(editSaudariSebapak);
		
		tSaudaraSeibu = (TextView) findViewById(R.id.textSaudaraSeibu);
		hSaudaraSeibu = (TextView) findViewById(R.id.terhalangSaudaraSeibu);
		editSaudaraSeibu = (EditText) findViewById(R.id.editSaudaraSeibu);
		onFocus(editSaudaraSeibu);
		listener(editSaudaraSeibu);
		
		tSaudariSeibu = (TextView) findViewById(R.id.textSaudariSeibu);
		hSaudariSeibu = (TextView) findViewById(R.id.terhalangSaudariSeibu);
		editSaudariSeibu = (EditText) findViewById(R.id.editSaudariSeibu);
		onFocus(editSaudariSeibu);
		listener(editSaudariSeibu);
		
		buttonBack = (Button) findViewById(R.id.btn_back5);
		buttonBack.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				linear.startAnimation(hitung_disappear);
				linear.setVisibility(View.VISIBLE);
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						finish();
						overridePendingTransition(R.anim.stand, R.anim.disappear);
					}
				}, 800);
			}
		});

		buttonNext = (Button) findViewById(R.id.btn_next5);
		buttonNext.setEnabled(false);
		buttonNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				nextStep();
			}
		});
		
		hSaudaraKandung.setVisibility(View.GONE);
		hSaudariKandung.setVisibility(View.GONE);
		hSaudaraSebapak.setVisibility(View.GONE);
		hSaudariSebapak.setVisibility(View.GONE);
		hSaudaraSeibu.setVisibility(View.GONE);
		hSaudariSeibu.setVisibility(View.GONE);
		
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				linear.setVisibility(View.VISIBLE);
				linear.startAnimation(anim_appear);
				buttonNext.setEnabled(true);
			}
		}, 1000);
		
		set();
		show();
	}
	
	public void show(){
		if (Varr.iJumlahAnakLaki > 0 || Varr.iJumlahBapak > 0 || Varr.iJumlahCucuLaki > 0 || Varr.iJumlahKakek > 0 ) {
			editSaudaraKandung.setVisibility(View.GONE);
			hSaudaraKandung.setVisibility(View.VISIBLE);
			Varr.iJumlahSaudaraKandung = 0;
			editSaudariKandung.setVisibility(View.GONE);
			hSaudariKandung.setVisibility(View.VISIBLE);
			Varr.iJumlahSaudariKandung = 0;
			editSaudaraSebapak.setVisibility(View.GONE);
			hSaudaraSebapak.setVisibility(View.VISIBLE);
			Varr.iJumlahSaudaraSebapak = 0;
			editSaudariSebapak.setVisibility(View.GONE);
			hSaudariSebapak.setVisibility(View.VISIBLE);
			Varr.iJumlahSaudariSebapak = 0;
			editSaudaraSeibu.setVisibility(View.GONE);
			hSaudaraSeibu.setVisibility(View.VISIBLE);
			Varr.iJumlahSaudaraSeibu = 0;
			editSaudariSeibu.setVisibility(View.GONE);
			hSaudariSeibu.setVisibility(View.VISIBLE);
			Varr.iJumlahSaudariSeibu = 0;
		}
		
		if (Varr.iJumlahAnakPerempuan > 0 || Varr.iJumlahCucuPerempuan > 0) {
			editSaudaraSeibu.setVisibility(View.GONE);
			hSaudaraSeibu.setVisibility(View.VISIBLE);
			Varr.iJumlahSaudaraSeibu = 0;
			editSaudariSeibu.setVisibility(View.GONE);
			hSaudariSeibu.setVisibility(View.VISIBLE);
			Varr.iJumlahSaudariSeibu = 0;
		}
	}
	
	public void set() {
		editSaudaraKandung.setText(String.valueOf(Varr.iJumlahSaudaraKandung));
		editSaudariKandung.setText(String.valueOf(Varr.iJumlahSaudariKandung));
		editSaudaraSebapak.setText(String.valueOf(Varr.iJumlahSaudaraSebapak));
		editSaudariSebapak.setText(String.valueOf(Varr.iJumlahSaudariSebapak));
		editSaudaraSeibu.setText(String.valueOf(Varr.iJumlahSaudaraSeibu));
		editSaudariSeibu.setText(String.valueOf(Varr.iJumlahSaudariSeibu));
	}
	
	public void nextStep(){
		Intent i = new Intent(Hitung5.this, Hitung6.class);
		startActivity(i);
		overridePendingTransition(R.anim.hitung_appear, R.anim.hitung_disappear);
	}
	
	public void btn() {
		boolean sak, sik, sab, sib, sai, sii;
		int a;
	
		if (editSaudaraKandung.getText().toString().equals("")) { 
			Varr.iJumlahSaudaraKandung = 0;
			sak = false; 
			a = 0;
		} else {
			Varr.iJumlahSaudaraKandung = Integer.parseInt(editSaudaraKandung.getText().toString());
			sak = true; 
			a = Integer.parseInt(editSaudaraKandung.getText().toString());
		}
			
		if (editSaudariKandung.getText().toString().equals("")) { 
			Varr.iJumlahSaudariKandung = 0;
			sik = false;
		} else { 
			Varr.iJumlahSaudariKandung = Integer.parseInt(editSaudariKandung.getText().toString());
			sik = true; 
		}
			
		if (editSaudaraSebapak.getText().toString().equals("")) { 
			Varr.iJumlahSaudaraSebapak = 0;
			sab = false;
		} else { 
			Varr.iJumlahSaudaraSebapak = Integer.parseInt(editSaudaraSebapak.getText().toString());
			sab = true;
		}
			
		if (editSaudariSebapak.getText().toString().equals("")) { 
			Varr.iJumlahSaudariSebapak = 0;
			sib = false; 
		} else { 
			Varr.iJumlahSaudariSebapak = Integer.parseInt(editSaudariSebapak.getText().toString());
			sib = true; 
		}
			
		if (editSaudaraSeibu.getText().toString().equals("")) { 
			Varr.iJumlahSaudaraSeibu = 0;
			sai = false; 
		} else { 
			Varr.iJumlahSaudaraSeibu = Integer.parseInt(editSaudaraSeibu.getText().toString());
			sai = true; 
		}
			
		if (editSaudariSeibu.getText().toString().equals("")) { 
			Varr.iJumlahSaudariSeibu = 0;
			sii = false; 
		} else { 
			Varr.iJumlahSaudariSeibu = Integer.parseInt(editSaudariSeibu.getText().toString());
			sii = true; 
		}
		
		
		if (a > 0){
			editSaudaraSebapak.setVisibility(View.GONE);
			hSaudaraSebapak.setVisibility(View.VISIBLE);
			Varr.iJumlahSaudaraSebapak = 0;
			sab = true;
			editSaudariSebapak.setVisibility(View.GONE);
			hSaudariSebapak.setVisibility(View.VISIBLE);
			Varr.iJumlahSaudariSebapak = 0;
			sib = true;
		} else {
			editSaudaraSebapak.setVisibility(View.VISIBLE);
			hSaudaraSebapak.setVisibility(View.GONE);
			editSaudariSebapak.setVisibility(View.VISIBLE);
			hSaudariSebapak.setVisibility(View.GONE);
		}
		
		
		if (sak == false || sik == false || sab == false || sib == false || sai == false || sii == false) {
			buttonNext.setEnabled(false);
		} else {
			buttonNext.setEnabled(true);
		}
	}
	
	public void onFocus(final TextView a) {
		a.setOnFocusChangeListener(new OnFocusChangeListener(){
		    @Override public void onFocusChange(View v, boolean hasFocus){
		        if (hasFocus) {
		        	if(a.getText().toString().equals("0")){
		        		a.setText("");
		        	}
		        }
		    }
		});
	}
	
	public void listener(TextView a) {
		a.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				btn();
			}
			public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
			public void onTextChanged(CharSequence s, int start, int before,int count) {}
		});
	}
	
	public void onBackPressed() {}
}
