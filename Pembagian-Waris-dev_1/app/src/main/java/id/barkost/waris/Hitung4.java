package id.barkost.waris;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Hitung4 extends Activity {

	public Button buttonNext, buttonBack;
	public TextView t_s4, t_s4_desc, textCucuLaki, textCucuPerempuan, textKakek, textNenekIbu, textNenekBapak, hlgCucuLaki, hlgCucuPerempuan, hlgKakek, hlgNenekIbu, hlgNenekBapak;
	public EditText editCucuLaki, editCucuPerempuan;
	public CheckBox checkKakek, checkNenekBapak, checkNenekIbu;
	public LinearLayout linear;
	
	Animation anim_fade_in, anim_slide, anim_appear, hitung_disappear;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hitung4);
		
		anim_appear = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.appear);
		anim_slide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_from_right);
		anim_fade_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_and_scale_in);
		hitung_disappear = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.hitung_disappear);
		
		linear = (LinearLayout) findViewById(R.id.linear_hit2);
		linear.setVisibility(View.GONE);
		
		// -- cucu laki-laki
		textCucuLaki = (TextView) findViewById(R.id.textCucuLakilaki);
		hlgCucuLaki = (TextView) findViewById(R.id.terhalangCucuLakilaki);
		editCucuLaki = (EditText) findViewById(R.id.editCucuLakilaki);
		onFocus(editCucuLaki);
		listener(editCucuLaki);
				
		// -- cucu perempuan
		textCucuPerempuan = (TextView) findViewById(R.id.textCucuPerempuan);
		hlgCucuPerempuan = (TextView) findViewById(R.id.terhalangCucuPerempuan);
		editCucuPerempuan = (EditText) findViewById(R.id.editCucuPerempuan);
		onFocus(editCucuPerempuan);
		listener(editCucuPerempuan);
		
		if (Hitung3.nikah.equals("tidak nikah")) {
			textCucuLaki.setVisibility(View.GONE);
			editCucuLaki.setVisibility(View.GONE);
			hlgCucuLaki.setVisibility(View.GONE);
			textCucuPerempuan.setVisibility(View.GONE);
			hlgCucuPerempuan.setVisibility(View.GONE);
			editCucuPerempuan.setVisibility(View.GONE);
		}
		
		// -- Kakek
		textKakek = (TextView) findViewById(R.id.textKakek);
		hlgKakek = (TextView) findViewById(R.id.terhalangKakek);
		checkKakek = (CheckBox) findViewById(R.id.checkKakek);
		checkKakek.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (checkKakek.isChecked()) {
					Varr.iJumlahKakek = 1;
				} else {
					Varr.iJumlahKakek = 0;
				}
			}
		});
		
		// -- Nenek dari Ibu
		textNenekIbu = (TextView) findViewById(R.id.textNenekIbu);
		hlgNenekIbu = (TextView) findViewById(R.id.terhalangNenekIbu);
		checkNenekIbu = (CheckBox) findViewById(R.id.checkNenekIbu);
		checkNenekIbu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (checkNenekIbu.isChecked()) {
					Varr.iJumlahNenekIbu = 1;
				} else {
					Varr.iJumlahNenekIbu = 0;
				}
			}
		});

		// -- Nenek dari Bapak
		textNenekBapak = (TextView) findViewById(R.id.textNenekBapak);
		hlgNenekBapak = (TextView) findViewById(R.id.terhalangNenekBapak);
		checkNenekBapak = (CheckBox) findViewById(R.id.checkNenekBapak);
		checkNenekBapak.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (checkNenekBapak.isChecked()) {
					Varr.iJumlahNenekBapak = 1;
				} else {
					Varr.iJumlahNenekBapak = 0;
				}
			}
		});
		
		buttonBack = (Button) findViewById(R.id.btn_back4);
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

		buttonNext = (Button) findViewById(R.id.btn_next4);
		buttonNext.setEnabled(false);
		buttonNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//next
				nextStep();
			}
		});
		
		hlgCucuLaki.setVisibility(View.GONE);
		hlgCucuPerempuan.setVisibility(View.GONE);
		hlgKakek.setVisibility(View.GONE);
		hlgNenekIbu.setVisibility(View.GONE);
		hlgNenekBapak.setVisibility(View.GONE);
		
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				linear.setVisibility(View.VISIBLE);
				linear.startAnimation(anim_appear);
				buttonNext.setEnabled(true);
			}
		}, 1000);
		
		show();
		set();
		showFirst();
	}
	
	public void show(){
		if (Varr.iJumlahAnakLaki > 0) {
			hlgCucuLaki.setVisibility(View.VISIBLE);
			editCucuLaki.setVisibility(View.GONE);
			Varr.iJumlahCucuLaki = 0;
			hlgCucuPerempuan.setVisibility(View.VISIBLE);
			editCucuPerempuan.setVisibility(View.GONE);
			Varr.iJumlahCucuPerempuan = 0;
			hlgKakek.setVisibility(View.VISIBLE);
			checkKakek.setVisibility(View.GONE);
			Varr.iJumlahKakek = 0;
		}
		if (Varr.iJumlahAnakPerempuan > 1) {
			hlgCucuPerempuan.setVisibility(View.VISIBLE);
			editCucuPerempuan.setVisibility(View.GONE);
			Varr.iJumlahCucuPerempuan = 0;
		}
		if (Varr.iJumlahIbu > 0) {
			hlgNenekIbu.setVisibility(View.VISIBLE);
			checkNenekIbu.setVisibility(View.GONE);
			Varr.iJumlahNenekIbu = 0;
			hlgNenekBapak.setVisibility(View.VISIBLE);
			checkNenekBapak.setVisibility(View.GONE);
			Varr.iJumlahNenekBapak = 0;
		}
		if (Varr.iJumlahBapak > 0) {
			hlgKakek.setVisibility(View.VISIBLE);
			checkKakek.setVisibility(View.GONE);
			Varr.iJumlahKakek = 0;
			hlgNenekBapak.setVisibility(View.VISIBLE);
			checkNenekBapak.setVisibility(View.GONE);
			Varr.iJumlahNenekBapak = 0;
		}
	}
	
	public void showFirst() {
		if (Hitung3.nikah.equals("tidak nikah")) {
			Varr.iJumlahCucuLaki = 0;
			Varr.iJumlahCucuPerempuan = 0;
		}
	}
	
	public void set() {
		editCucuLaki.setText(String.valueOf(Varr.iJumlahCucuLaki));
		editCucuPerempuan.setText(String.valueOf(Varr.iJumlahCucuPerempuan));
		if (Varr.iJumlahKakek == 1) {
			checkKakek.setChecked(true);
		} else {
			checkKakek.setChecked(false);
		}
		
		if (Varr.iJumlahNenekIbu == 1) {
			checkNenekIbu.setChecked(true);
		} else {
			checkNenekIbu.setChecked(false);
		}
		
		if (Varr.iJumlahNenekBapak == 1) {
			checkNenekBapak.setChecked(true);
		} else {
			checkNenekBapak.setChecked(false);
		}
	}
	
	public void nextStep(){
		boolean cucuL = false, cucuP = false;
		if (editCucuLaki.getText().toString().equals("")) {
			cucuL = false;
		} else {
			Varr.iJumlahCucuLaki = Integer.parseInt(editCucuLaki.getText().toString());
			cucuL = true;
		}
		if (editCucuPerempuan.getText().toString().equals("")) {
			cucuP = false;
		} else {
			Varr.iJumlahCucuPerempuan = Integer.parseInt(editCucuPerempuan.getText().toString());
			cucuP = true;
		}
		
		if (cucuL == true && cucuP == true) {
			Intent i = new Intent(Hitung4.this, Hitung5.class);
			startActivity(i);
			overridePendingTransition(R.anim.hitung_appear, R.anim.hitung_disappear);
		} else {
			new AlertDialog.Builder(this)
			.setTitle(getResources().getString(R.string.error))
			.setMessage(getResources().getString(R.string.error_msg))
			.show();
		}
	}
	
	public void btn() {
		if (editCucuLaki.getText().toString().equals("") || editCucuPerempuan.getText().toString().equals("")) {
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
