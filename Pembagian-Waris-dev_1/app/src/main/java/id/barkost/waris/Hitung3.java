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

public class Hitung3 extends Activity {

	public Button buttonNext, buttonBack;
	public TextView t_s3, t_s3_desc, textIstriSuami, textAnakL, textAnakP, textBapak, textIbu;
	public EditText editIstri, editAnakL, editAnakP;
	public CheckBox checkSuami, checkBapak, checkIbu;
	public LinearLayout linear1;
	public static String nikah, kelamin, anak;
	
	Animation anim_fade_in, anim_slide, anim_appear;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hitung3);
		
		setAnim();
		
		linear1 = (LinearLayout) findViewById(R.id.linear_hit1);
		linear1.setVisibility(View.GONE);
		
		// -- Deskripsi step 3
		t_s3 = (TextView) findViewById(R.id.tx_s3_title);
		t_s3.setVisibility(View.GONE);
		t_s3_desc = (TextView) findViewById(R.id.tx_s3_desc);
		t_s3_desc.setVisibility(View.GONE);
		
		// -- anak laki-laki
		textAnakL = (TextView) findViewById(R.id.textAnakLakilaki);
		editAnakL = (EditText) findViewById(R.id.editAnakLakilaki);
		onFocus(editAnakL);
		listener(editAnakL);
				
		// -- anak perempuan
		textAnakP = (TextView) findViewById(R.id.textAnakPerempuan);
		editAnakP = (EditText) findViewById(R.id.editAnakPerempuan);
		onFocus(editAnakP);
		listener(editAnakP);
		
		// -- sumi / istri
		textIstriSuami = (TextView) findViewById(R.id.textIstri_Suami);
		editIstri = (EditText) findViewById(R.id.editIstri);
		onFocus(editIstri);
		listener(editIstri);
		
		checkSuami = (CheckBox) findViewById(R.id.checkSuami);
		checkSuami.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (checkSuami.isChecked()) {
					Varr.iJumlahSuami = 1;
				} else {
					Varr.iJumlahSuami = 0;
				}
			}
		});
		
		// -- Bapak
		textBapak = (TextView) findViewById(R.id.textBapak);
		checkBapak = (CheckBox) findViewById(R.id.checkBapak);
		checkBapak.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (checkBapak.isChecked()) {
					Varr.iJumlahBapak = 1;
				} else {
					Varr.iJumlahBapak = 0;
				}
			}
		});
		
		// -- Ibu
		textIbu = (TextView) findViewById(R.id.textIbu);
		checkIbu = (CheckBox) findViewById(R.id.checkIbu);
		checkIbu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (checkIbu.isChecked()) {
					Varr.iJumlahIbu = 1;
				} else {
					Varr.iJumlahIbu = 0;
				}
			}
		});
		
		buttonBack = (Button) findViewById(R.id.btn_back3);
		buttonBack.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
				overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
			}
		});

		buttonNext = (Button) findViewById(R.id.btn_next3);
		buttonNext.setEnabled(false);
		buttonNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//next
				nextStep();
			}
		});
		
		showFirst();
		trans_slide(t_s3, 1000);
		trans1();
		trans2();
		set();
	}
	
	public void setAnim () {
		anim_appear = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.appear);
		anim_slide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_from_right);
		anim_fade_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_and_scale_in);
	}
	
	public void set() {
		editAnakL.setText(String.valueOf(Varr.iJumlahAnakLaki));
		editAnakP.setText(String.valueOf(Varr.iJumlahAnakPerempuan));
		editIstri.setText(String.valueOf(Varr.iJumlahIstri));
		if (Varr.iJumlahSuami == 1) {
			checkSuami.setChecked(true);
		} else {
			checkSuami.setChecked(false);
		}
		
		if (Varr.iJumlahBapak == 1) {
			checkBapak.setChecked(true);
		} else {
			checkBapak.setChecked(false);
		}
		
		if (Varr.iJumlahIbu == 1) {
			checkIbu.setChecked(true);
		} else {
			checkIbu.setChecked(false);
		}
	}
	
	public void showFirst(){
		//--- set kelamin, hide or show anak and (istri or suami)
		if (nikah.equals("nikah")) {
			if (kelamin.equals("laki-laki")) {
				textIstriSuami.setText("Istri");
				checkSuami.setVisibility(View.GONE);
				editIstri.setVisibility(View.VISIBLE);
				//----
				Varr.iJumlahSuami = 0;
			} else if (kelamin.equals("perempuan")) {
				textIstriSuami.setText("Suami");
				checkSuami.setVisibility(View.VISIBLE);
				editIstri.setVisibility(View.GONE);
				//----
				Varr.iJumlahIstri = 0;
			}
		} else if (nikah.equals("cerai")) {
			textIstriSuami.setVisibility(View.GONE);
			checkSuami.setVisibility(View.GONE);
			editIstri.setVisibility(View.GONE);
			//----
			Varr.iJumlahIstri = 0;
			Varr.iJumlahSuami = 0;
		} else if (nikah.equals("tidak nikah")) {
			textIstriSuami.setVisibility(View.GONE);
			checkSuami.setVisibility(View.GONE);
			editIstri.setVisibility(View.GONE);
			//----
			Varr.iJumlahIstri = 0;
			Varr.iJumlahSuami = 0;
			Varr.iJumlahAnakLaki = 0;
			Varr.iJumlahAnakPerempuan = 0;
		}
		showAnak();
	}
	
	public void showAnak() {
		if (anak.equals("ya")) {
			textAnakL.setVisibility(View.VISIBLE);
			editAnakL.setVisibility(View.VISIBLE);
			textAnakP.setVisibility(View.VISIBLE);
			editAnakP.setVisibility(View.VISIBLE);
		} else if (anak.equals("tidak")) {
			textAnakL.setVisibility(View.GONE);
			editAnakL.setVisibility(View.GONE);
			textAnakP.setVisibility(View.GONE);
			editAnakP.setVisibility(View.GONE);
			Varr.iJumlahAnakLaki = 0;
			Varr.iJumlahAnakPerempuan = 0;
		}
	}
	
	public void trans_slide(final TextView a, int time) {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				a.setVisibility(View.VISIBLE);
				a.startAnimation(anim_slide);
			}
		}, time);
	}

	public void trans1() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				t_s3_desc.setVisibility(View.VISIBLE);
				t_s3_desc.startAnimation(anim_appear);
			}
		}, 2000);
	}
	
	public void trans2() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				linear1.setVisibility(View.VISIBLE);
				linear1.startAnimation(anim_appear);
				buttonNext.setEnabled(true);
			}
		}, 3000);
	}
	
	public void nextStep(){
		boolean anakL = false, anakP = false, istri = false;
		
		if (editAnakL.getText().toString().equals("")) {
			anakL = false;
		} else {
			Varr.iJumlahAnakLaki = Integer.parseInt(editAnakL.getText().toString());
			anakL = true;
		}
		
		if (editAnakP.getText().toString().equals("")) {
			anakP = false;
		} else {
			Varr.iJumlahAnakPerempuan = Integer.parseInt(editAnakP.getText().toString());
			anakP = true;
		}
		
		if (editIstri.getText().toString().equals("")) {
			istri = false;
		} else {
			Varr.iJumlahIstri = Integer.parseInt(editIstri.getText().toString());
			if (Varr.iJumlahIstri > 4) {
				editIstri.setError("Istri tidak boleh lebih dari 4");
				editIstri.setText("");
				editIstri.requestFocus();
			} else {
				istri = true;
				if (anakL == true && anakP == true && istri == true) {
					Intent i = new Intent(Hitung3.this, Hitung4.class);
					startActivity(i);
					overridePendingTransition(R.anim.hitung_appear, R.anim.hitung_disappear);
				} else {
					new AlertDialog.Builder(this)
					.setTitle(getResources().getString(R.string.error))
					.setMessage(getResources().getString(R.string.error_msg))
					.show();
				}
			}
		}
	}
	
	public void btn() {
		if (editAnakL.getText().toString().equals("") || editAnakP.getText().toString().equals("") || editIstri.getText().toString().equals("")) {
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
