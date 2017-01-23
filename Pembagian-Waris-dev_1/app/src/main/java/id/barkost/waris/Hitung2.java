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
import android.widget.ScrollView;
import android.widget.TextView;

public class Hitung2 extends Activity {

	public Button buttonNext, buttonBack;
	public TextView t_s2, t_s2_desc, t_tarikah, t_tarikah_rp;
	public TextView t_hak1, t_hak1_rp, t_hak2, t_hak2_rp, t_hak3, t_hak3_rp, t_hak4, t_hak4_rp;
	public EditText e_tarikah, e_hak1, e_hak2, e_hak3, e_hak4;
	public static boolean perempuan = false, nikah = false;
	public static int harta, tarikah, hak1, hak2, hak3, hak4;
	public static ScrollView scroll;
	Animation anim_fade_in, anim_slide, anim_appear;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hitung2);
		
		setAnim();
		
		scroll = (ScrollView) findViewById(R.id.sc_hitung2);
		
		// -- Deskdipsi step 2
		t_s2 = (TextView) findViewById(R.id.tx_s2_title);
		t_s2.setVisibility(View.GONE);
		t_s2_desc = (TextView) findViewById(R.id.tx_s2_desc);
		t_s2_desc.setVisibility(View.GONE);
		
		// -- Tarikah
		t_tarikah = (TextView) findViewById(R.id.tx_tarikah);
		t_tarikah_rp = (TextView) findViewById(R.id.tx_tarikah_rp);
		e_tarikah = (EditText) findViewById(R.id.edit_tarikah);
		onFocus(e_tarikah);
		listener(e_tarikah);
		hide(t_tarikah, t_tarikah_rp, e_tarikah);
		
		// -- Harta gonogini
		t_hak1 = (TextView) findViewById(R.id.tx_hak1);
		t_hak1_rp = (TextView) findViewById(R.id.tx_hak1_rp);
		e_hak1 = (EditText) findViewById(R.id.edit_hak1);
		e_hak1.setOnFocusChangeListener(new OnFocusChangeListener(){
		    @Override public void onFocusChange(View v, boolean hasFocus){
		        if (hasFocus) {
		        	if(e_hak1.getText().toString().equals("0")){
		        		e_hak1.setText("");
		        	}
		        }
		    }
		});
		e_hak1.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				btn();
			}
			public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
			public void onTextChanged(CharSequence s, int start, int before,int count) {}
		});
		hide(t_hak1, t_hak1_rp, e_hak1);
		
		// -- Hutang
		t_hak2 = (TextView) findViewById(R.id.tx_hak2);
		t_hak2_rp = (TextView) findViewById(R.id.tx_hak2_rp);
		e_hak2 = (EditText) findViewById(R.id.edit_hak2);
		e_hak2.setOnFocusChangeListener(new OnFocusChangeListener(){
		    @Override public void onFocusChange(View v, boolean hasFocus){
		        if (hasFocus) {
		        	if(e_hak2.getText().toString().equals("0")){
		        		e_hak2.setText("");
		        	}
		        }
		    }
		});
		e_hak2.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				btn();
			}
			public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
			public void onTextChanged(CharSequence s, int start, int before,int count) {}
		});
		hide(t_hak2, t_hak2_rp, e_hak2);
		
		// -- Pemakaman
		t_hak3 = (TextView) findViewById(R.id.tx_hak3);
		t_hak3_rp = (TextView) findViewById(R.id.tx_hak3_rp);
		e_hak3 = (EditText) findViewById(R.id.edit_hak3);
		e_hak3.setOnFocusChangeListener(new OnFocusChangeListener(){
		    @Override public void onFocusChange(View v, boolean hasFocus){
		        if (hasFocus) {
		        	if(e_hak3.getText().toString().equals("0")){
		        		e_hak3.setText("");
		        	}
		        }
		    }
		});
		e_hak3.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				btn();
			}
			public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
			public void onTextChanged(CharSequence s, int start, int before,int count) {}
		});
		hide(t_hak3, t_hak3_rp, e_hak3);
		
		// -- Wasiat
		t_hak4 = (TextView) findViewById(R.id.tx_hak4);
		t_hak4_rp = (TextView) findViewById(R.id.tx_hak4_rp);
		e_hak4 = (EditText) findViewById(R.id.edit_hak4);
		e_hak4.setOnFocusChangeListener(new OnFocusChangeListener(){
		    @Override public void onFocusChange(View v, boolean hasFocus){
		        if (hasFocus) {
		        	if(e_hak4.getText().toString().equals("0")){
		        		e_hak4.setText("");
		        	}
		        }
		    }
		});
		e_hak4.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				btn();
			}
			public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
			public void onTextChanged(CharSequence s, int start, int before,int count) {}
		});
		hide(t_hak4, t_hak4_rp, e_hak4);
		
		buttonBack = (Button) findViewById(R.id.btn_back_2);
		buttonBack.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
				overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
			}
		});
		
		buttonNext = (Button) findViewById(R.id.btn_next_2);
		buttonNext.setEnabled(false);
		buttonNext.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Varr.tarikah = Integer.parseInt(e_tarikah.getText().toString());
				
				if (e_hak1.getText().toString().equals("")){
					Varr.hak1 = 0;
					hak1 = 0;
				} else {
					Varr.hak1 = Integer.parseInt(e_hak1.getText().toString());
					hak1 = Integer.parseInt(e_hak1.getText().toString());
				}
				Varr.hak2 = Integer.parseInt(e_hak2.getText().toString());
				Varr.hak3 = Integer.parseInt(e_hak3.getText().toString());
				Varr.hak4 = Integer.parseInt(e_hak4.getText().toString());
				tarikah = Integer.parseInt(e_tarikah.getText().toString());
				hak2 = Integer.parseInt(e_hak2.getText().toString());
				hak3 = Integer.parseInt(e_hak3.getText().toString());
				hak4 = Integer.parseInt(e_hak4.getText().toString());
					
				if (hak4 > (tarikah/3)) {
					e_hak4.setError("Wasiat tidak boleh melebihi 1/3 dari tarikah");
					e_hak4.requestFocus();
				} else if ((tarikah - (hak1 + hak2 + hak3 + hak4)) <= 0) {
					e_tarikah.setError("Perhitungan tidak bisa dilanjutkan karena sisa harta habis oleh kewajiban yang harus ditunaikan");
					e_tarikah.requestFocus();
					e_tarikah.setText("");
				} else {
					Varr.iHarta = (tarikah - (hak1 + hak2 + hak3 + hak4));
					Intent i = new Intent(Hitung2.this, Hitung3.class);
					startActivity(i);
					overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
				}
			}
		});
			
		translasi();
				
//		e_tarikah.setText(String.valueOf(Varr.tarikah));
//		e_hak1.setText(String.valueOf(Varr.hak1));
//		e_hak2.setText(String.valueOf(Varr.hak2));
//		e_hak3.setText(String.valueOf(Varr.hak3));
//		e_hak4.setText(String.valueOf(Varr.hak4));
	}
	
	public void setAnim() {
		anim_appear = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.appear);
		anim_slide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_from_right);
		anim_fade_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_and_scale_in);
	}
	
	public void hide (TextView text1, TextView text2, EditText edit) {
		text1.setVisibility(View.GONE);
		text2.setVisibility(View.GONE);
		edit.setVisibility(View.GONE);
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
				t_s2_desc.setVisibility(View.VISIBLE);
				t_s2_desc.startAnimation(anim_appear);
			}
		}, 2000);
	}
	
	public void trans_fade_in(final TextView a, final EditText b, int time) {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				a.setVisibility(View.VISIBLE);
				b.setVisibility(View.VISIBLE);
				a.startAnimation(anim_fade_in);
				b.startAnimation(anim_fade_in);
			}
		}, time);
	}
	
	public void translasi() {
		trans_slide(t_s2, 1000);
		trans1();
		trans_slide(t_tarikah, 3000);
		if (perempuan == false && nikah == true) {
			trans_slide(t_hak1, 3000);
			trans_fade_in(t_hak1_rp, e_hak1, 4000);
		} else {
			e_hak1.setText(String.valueOf(0));
		}
		trans_slide(t_hak2, 3000);
		trans_slide(t_hak3, 3000);
		trans_slide(t_hak4, 3000);
		trans_fade_in(t_tarikah_rp, e_tarikah, 4000);
		trans_fade_in(t_hak2_rp, e_hak2, 4000);
		trans_fade_in(t_hak3_rp, e_hak3, 4000);
		trans_fade_in(t_hak4_rp, e_hak4, 4000);
		
		scroll.postDelayed(new Runnable() {
    	    @Override
    	    public void run() {
    	        scroll.fullScroll(ScrollView.FOCUS_DOWN);
    	    }
    	}, 4200);
	}
	
	public void btn() {
		if (e_tarikah.getText().toString().equals("") || e_hak1.getText().toString().equals("") || e_hak2.getText().toString().equals("") || e_hak3.getText().toString().equals("") || e_hak4.getText().toString().equals("")) {
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
	
	public void onBackPressed() {}
}
