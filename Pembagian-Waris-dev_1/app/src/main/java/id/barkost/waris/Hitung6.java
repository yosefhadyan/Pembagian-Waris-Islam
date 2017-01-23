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
import android.widget.Toast;

public class Hitung6 extends Activity {

	public Button buttonBack, buttonHitung;
	public EditText editKeponakanSekandung, editKeponakanSebapak, editPamanKandung, editPamanSebapak, editAnakPamanKandung, editAnakPamanSebapak;
	public TextView tKeponakanSekandung, tKeponakanSebapak, tPamanKandung, tPamanSebapak, tAnakPamanKandung, tAnakPamanSebapak, hKeponakanSekandung, hKeponakanSebapak, hPamanKandung, hPamanSebapak, hAnakPamanKandung, hAnakPamanSebapak;
	public LinearLayout linear;
	
	Animation anim_fade_in, anim_slide, anim_appear, hitung_disappear;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hitung6);
		
		anim_appear = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.appear);
		anim_slide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_from_right);
		anim_fade_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_and_scale_in);
		hitung_disappear = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.hitung_disappear);
		
		linear = (LinearLayout) findViewById(R.id.linear_hit4);
		linear.setVisibility(View.GONE);
		
		tKeponakanSekandung = (TextView) findViewById(R.id.textKeponakanSekandung);
		hKeponakanSekandung = (TextView) findViewById(R.id.halangKeponakanSekandung);
		editKeponakanSekandung = (EditText) findViewById(R.id.editKeponakanSekandung);
		onFocus(editKeponakanSekandung);
		listener(editKeponakanSekandung);

		tKeponakanSebapak = (TextView) findViewById(R.id.textKeponakanSebapak);
		hKeponakanSebapak = (TextView) findViewById(R.id.halangKeponakanSebapak);
		editKeponakanSebapak = (EditText) findViewById(R.id.editKeponakanSebapak);
		onFocus(editKeponakanSebapak);
		listener(editKeponakanSebapak);
		
		tPamanKandung = (TextView) findViewById(R.id.textPamanKandung);
		hPamanKandung = (TextView) findViewById(R.id.halangPamanKandung);
		editPamanKandung = (EditText) findViewById(R.id.editPamanKandung);
		onFocus(editPamanKandung);
		listener(editPamanKandung);
		
		tPamanSebapak = (TextView) findViewById(R.id.textPamanSebapak);
		hPamanSebapak = (TextView) findViewById(R.id.halangPamanSebapak);
		editPamanSebapak = (EditText) findViewById(R.id.editPamanSebapak);
		onFocus(editPamanSebapak);
		listener(editPamanSebapak);
		
		tAnakPamanKandung = (TextView) findViewById(R.id.textAnakPamanKandung);
		hAnakPamanKandung = (TextView) findViewById(R.id.halangAnakPamanKandung);
		editAnakPamanKandung = (EditText) findViewById(R.id.editAnakPamanKandung);
		onFocus(editAnakPamanKandung);
		listener(editAnakPamanKandung);
		
		tAnakPamanSebapak = (TextView) findViewById(R.id.textAnakPamanSebapak);
		hAnakPamanSebapak = (TextView) findViewById(R.id.halangAnakPamanSebapak);
		editAnakPamanSebapak = (EditText) findViewById(R.id.editAnakPamanSebapak);
		onFocus(editAnakPamanSebapak);
		listener(editAnakPamanSebapak);
		
		buttonBack = (Button) findViewById(R.id.btn_back6);
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

		buttonHitung= (Button) findViewById(R.id.btn_hitung);
		buttonHitung.setEnabled(false);
		buttonHitung.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (Varr.iJumlahBapak == 0 && Varr.iJumlahIbu == 0 && Varr.iJumlahSuami == 0 && Varr.iJumlahIstri == 0 && Varr.iJumlahAnakLaki == 0 && Varr.iJumlahAnakPerempuan == 0 && Varr.iJumlahCucuLaki == 0 && Varr.iJumlahCucuPerempuan == 0 && Varr.iJumlahKakek == 0 && Varr.iJumlahNenekBapak == 0 && Varr.iJumlahNenekIbu == 0 && Varr.iJumlahNenekKakek == 0 && Varr.iJumlahSaudaraKandung == 0 && Varr.iJumlahSaudariKandung == 0 && Varr.iJumlahSaudaraSebapak == 0 && Varr.iJumlahSaudaraSeibu == 0 && Varr.iJumlahSaudariSebapak == 0 && Varr.iJumlahSaudariSeibu == 0 && Varr.iJumlahPutraSaudaraKandung == 0 && Varr.iJumlahPutraSaudaraSebapak == 0 && Varr.iJumlahPamanKandung == 0 && Varr.iJumlahPamanSebapak == 0 && Varr.iJumlahPutraPamanKandung == 0 && Varr.iJumlahPutraPamanSebapak == 0 && Varr.iJumlahPriaMerdekakan == 0 && Varr.iJumlahWanitaMerdekakan == 0){
					Toast.makeText(getApplicationContext(), "Ahli waris masih kosong", Toast.LENGTH_SHORT).show();
				} else {
					nextStep();
				}
			}
		});
		
		hKeponakanSekandung.setVisibility(View.GONE);
		hKeponakanSebapak.setVisibility(View.GONE);
		hPamanKandung.setVisibility(View.GONE);
		hPamanSebapak.setVisibility(View.GONE);
		hAnakPamanKandung.setVisibility(View.GONE);
		hAnakPamanSebapak.setVisibility(View.GONE);
		
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				linear.setVisibility(View.VISIBLE);
				linear.startAnimation(anim_appear);
				buttonHitung.setEnabled(true);
			}
		}, 1000);
		
		set();
		show();
	}
	
	public void show(){
		if (Varr.iJumlahAnakLaki > 0 || Varr.iJumlahBapak > 0 || Varr.iJumlahCucuLaki > 0 || Varr.iJumlahKakek > 0 || Varr.iJumlahSaudaraKandung > 0 || Varr.iJumlahSaudaraSebapak > 0) {
			hKeponakanSekandung.setVisibility(View.VISIBLE);
			editKeponakanSekandung.setVisibility(View.GONE);
			Varr.iJumlahPutraSaudaraKandung = 0;
			hKeponakanSebapak.setVisibility(View.VISIBLE);
			editKeponakanSebapak.setVisibility(View.GONE);
			Varr.iJumlahPutraSaudaraSebapak = 0;
			hPamanKandung.setVisibility(View.VISIBLE);
			editPamanKandung.setVisibility(View.GONE);
			Varr.iJumlahPamanKandung = 0;
			hPamanSebapak.setVisibility(View.VISIBLE);
			editPamanSebapak.setVisibility(View.GONE);
			Varr.iJumlahPamanSebapak = 0;
			hAnakPamanKandung.setVisibility(View.VISIBLE);
			editAnakPamanKandung.setVisibility(View.GONE);
			Varr.iJumlahPutraPamanKandung = 0;
			hAnakPamanSebapak.setVisibility(View.VISIBLE);
			editAnakPamanSebapak.setVisibility(View.GONE);
			Varr.iJumlahPutraPamanSebapak = 0;
		}
	}
	
	public void nextStep(){
		Intent i = new Intent(Hitung6.this, HitungHasil.class);
		startActivity(i);
		overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
	}
	
	public void set() {
		editKeponakanSekandung.setText(String.valueOf(Varr.iJumlahPutraSaudaraKandung));
		editKeponakanSebapak.setText(String.valueOf(Varr.iJumlahPutraSaudaraSebapak));
		editPamanKandung.setText(String.valueOf(Varr.iJumlahPamanKandung));
		editPamanSebapak.setText(String.valueOf(Varr.iJumlahPamanSebapak));
		editAnakPamanKandung.setText(String.valueOf(Varr.iJumlahPutraPamanKandung));
		editAnakPamanSebapak.setText(String.valueOf(Varr.iJumlahPutraPamanSebapak));
	}
	
	public void btn() {
		boolean pnk, pnb, pmk, pmb, apmk, apmb;
		int a, b, c, d, e;
		
		if (editKeponakanSekandung.getText().toString().equals("")) {
			Varr.iJumlahPutraSaudaraKandung = 0;
			pnk = false;
			a = 0;
		} else {
			Varr.iJumlahPutraSaudaraKandung = Integer.parseInt(editKeponakanSekandung.getText().toString());
			pnk = true;
			a = Integer.parseInt(editKeponakanSekandung.getText().toString());
		}
		
		if (editKeponakanSebapak.getText().toString().equals("")) {
			Varr.iJumlahPutraSaudaraSebapak = 0;
			pnb = false;
			b = 0;
		} else {
			Varr.iJumlahPutraSaudaraSebapak = Integer.parseInt(editKeponakanSebapak.getText().toString());
			pnb = true;
			b = Integer.parseInt(editKeponakanSebapak.getText().toString());
		}
		
		if (editPamanKandung.getText().toString().equals("")) {
			Varr.iJumlahPamanKandung = 0;
			pmk = false;
			c = 0;
		} else {
			Varr.iJumlahPamanKandung = Integer.parseInt(editPamanKandung.getText().toString());
			pmk = true;
			c = Integer.parseInt(editPamanKandung.getText().toString());
		}
		
		if (editPamanSebapak.getText().toString().equals("")) {
			Varr.iJumlahPamanSebapak = 0;
			pmb = false;
			d = 0;
		} else {
			Varr.iJumlahPamanSebapak = Integer.parseInt(editPamanSebapak.getText().toString());
			pmb = true;
			d = Integer.parseInt(editPamanSebapak.getText().toString());
		}
		
		if (editAnakPamanKandung.getText().toString().equals("")) {
			Varr.iJumlahPutraPamanKandung = 0;
			apmk = false;
			e = 0;
		} else {
			Varr.iJumlahPutraPamanKandung = Integer.parseInt(editAnakPamanKandung.getText().toString());
			apmk = true;
			e = Integer.parseInt(editAnakPamanKandung.getText().toString());
		}
		
		if (editAnakPamanSebapak.getText().toString().equals("")) {
			Varr.iJumlahPutraPamanSebapak = 0;
			apmb = false;
		} else {
			Varr.iJumlahPutraPamanSebapak = Integer.parseInt(editAnakPamanSebapak.getText().toString());
			apmb = true;
		}
		

		if (a > 0){
			hKeponakanSebapak.setVisibility(View.VISIBLE);
			editKeponakanSebapak.setVisibility(View.GONE);
			Varr.iJumlahPutraSaudaraSebapak = 0;
			hPamanKandung.setVisibility(View.VISIBLE);
			editPamanKandung.setVisibility(View.GONE);
			Varr.iJumlahPamanKandung = 0;
			hPamanSebapak.setVisibility(View.VISIBLE);
			editPamanSebapak.setVisibility(View.GONE);
			Varr.iJumlahPamanSebapak = 0;
			hAnakPamanKandung.setVisibility(View.VISIBLE);
			editAnakPamanKandung.setVisibility(View.GONE);
			Varr.iJumlahPutraPamanKandung = 0;
			hAnakPamanSebapak.setVisibility(View.VISIBLE);
			editAnakPamanSebapak.setVisibility(View.GONE);
			Varr.iJumlahPutraPamanSebapak = 0;
			pnb = true;
			pmk = true;
			pmb = true;
			apmk = true;
			apmb = true;
		} else {
			hKeponakanSebapak.setVisibility(View.GONE);
			editKeponakanSebapak.setVisibility(View.VISIBLE);
			if (b > 0) {
				hPamanKandung.setVisibility(View.VISIBLE);
				editPamanKandung.setVisibility(View.GONE);
				Varr.iJumlahPamanKandung = 0;
				hPamanSebapak.setVisibility(View.VISIBLE);
				editPamanSebapak.setVisibility(View.GONE);
				Varr.iJumlahPamanSebapak = 0;
				hAnakPamanKandung.setVisibility(View.VISIBLE);
				editAnakPamanKandung.setVisibility(View.GONE);
				Varr.iJumlahPutraPamanKandung = 0;
				hAnakPamanSebapak.setVisibility(View.VISIBLE);
				editAnakPamanSebapak.setVisibility(View.GONE);
				Varr.iJumlahPutraPamanSebapak = 0;
				pmk = true;
				pmb = true;
				apmk = true;
				apmb = true;
			} else {
				hPamanKandung.setVisibility(View.GONE);
				editPamanKandung.setVisibility(View.VISIBLE);
				if (c > 0) {
					hPamanSebapak.setVisibility(View.VISIBLE);
					editPamanSebapak.setVisibility(View.GONE);
					Varr.iJumlahPamanSebapak = 0;
					hAnakPamanKandung.setVisibility(View.VISIBLE);
					editAnakPamanKandung.setVisibility(View.GONE);
					Varr.iJumlahPutraPamanKandung = 0;
					hAnakPamanSebapak.setVisibility(View.VISIBLE);
					editAnakPamanSebapak.setVisibility(View.GONE);
					Varr.iJumlahPutraPamanSebapak = 0;
					pmb = true;
					apmk = true;
					apmb = true;
				} else {
					hPamanSebapak.setVisibility(View.GONE);
					editPamanSebapak.setVisibility(View.VISIBLE);
					if (d > 0) {
						hAnakPamanKandung.setVisibility(View.VISIBLE);
						editAnakPamanKandung.setVisibility(View.GONE);
						Varr.iJumlahPutraPamanKandung = 0;
						hAnakPamanSebapak.setVisibility(View.VISIBLE);
						editAnakPamanSebapak.setVisibility(View.GONE);
						Varr.iJumlahPutraPamanSebapak = 0;
						apmk = true;
						apmb = true;
					} else {
						hAnakPamanKandung.setVisibility(View.GONE);
						editAnakPamanKandung.setVisibility(View.VISIBLE);
						if (e > 0) {
							hAnakPamanSebapak.setVisibility(View.VISIBLE);
							editAnakPamanSebapak.setVisibility(View.GONE);
							Varr.iJumlahPutraPamanSebapak = 0;
							apmb = true;
						} else {
							hAnakPamanSebapak.setVisibility(View.GONE);
							editAnakPamanSebapak.setVisibility(View.VISIBLE);
						}
					}
				}
			}
		}
			
		if (pnk == false || pnb == false || pmk == false || pmb == false || apmk == false || apmb == false) {
			buttonHitung.setEnabled(false);
		} else {
			buttonHitung.setEnabled(true);
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
