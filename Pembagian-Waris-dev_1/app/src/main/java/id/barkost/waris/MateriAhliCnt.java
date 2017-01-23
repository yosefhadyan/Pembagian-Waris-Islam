package id.barkost.waris;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MateriAhliCnt extends Activity {

	public static int pos = 0;
	public TextView head, bag1, bag2, bag3, bag4, bag5, syr1, syr2, syr3, syr4, syr5;
	public RelativeLayout row2, row3, row4, row5;
	public String s_head, s_bag1, s_bag2, s_bag3, s_bag4, s_bag5, s_syr1, s_syr2, s_syr3, s_syr4, s_syr5;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.materi_ahli_cnt);
		
		row2 = (RelativeLayout) findViewById(R.id.row2);
		row3 = (RelativeLayout) findViewById(R.id.row3);
		row4 = (RelativeLayout) findViewById(R.id.row4);
		row5 = (RelativeLayout) findViewById(R.id.row5);
		
		head = (TextView) findViewById(R.id.head_ahli);
		bag1 = (TextView) findViewById(R.id.bag_r1);
		bag2 = (TextView) findViewById(R.id.bag_r2);
		bag3 = (TextView) findViewById(R.id.bag_r3);
		bag4 = (TextView) findViewById(R.id.bag_r4);
		bag5 = (TextView) findViewById(R.id.bag_r5);
		syr1 = (TextView) findViewById(R.id.syarat_r1);
		syr2 = (TextView) findViewById(R.id.syarat_r2);
		syr3 = (TextView) findViewById(R.id.syarat_r3);
		syr4 = (TextView) findViewById(R.id.syarat_r4);
		syr5 = (TextView) findViewById(R.id.syarat_r5);
		
		switch (pos) {
			case 0 :
				s_head = getResources().getString(R.string.str_anak_laki);
				s_bag1 = getResources().getString(R.string.bag_ashabah);
				s_syr1 = getResources().getString(R.string.al_sy1);
				s_bag2 = getResources().getString(R.string.bag_seluruh);
				s_syr2 = getResources().getString(R.string.al_sy2);
				s_bag3 = getResources().getString(R.string.bag_samarata);
				s_syr3 = getResources().getString(R.string.al_sy3);
				row4.setVisibility(View.GONE);
				row5.setVisibility(View.GONE);
				break;
			case 1 :
				s_head = getResources().getString(R.string.str_anak_perempuan);
				s_bag1 = getResources().getString(R.string.bag_setengah);
				s_syr1 = getResources().getString(R.string.ap_sy1);
				s_bag2 = getResources().getString(R.string.bag_duapertiga);
				s_syr2 = getResources().getString(R.string.ap_sy2);
				s_bag3 = getResources().getString(R.string.bag_ashabah);
				s_syr3 = getResources().getString(R.string.ap_sy3);
				row4.setVisibility(View.GONE);
				row5.setVisibility(View.GONE);
				break;
			case 2 :
				s_head = getResources().getString(R.string.str_istri);
				s_bag1 = getResources().getString(R.string.bag_seperempat);
				s_syr1 = getResources().getString(R.string.is_sy1);
				s_bag2 = getResources().getString(R.string.bag_seperdelapan);
				s_syr2 = getResources().getString(R.string.is_sy2);
				row3.setVisibility(View.GONE);
				row4.setVisibility(View.GONE);
				row5.setVisibility(View.GONE);
				break;
			case 3 :
				s_head = getResources().getString(R.string.str_suami);
				s_bag1 = getResources().getString(R.string.bag_seperempat);
				s_syr1 = getResources().getString(R.string.suam_sy1);
				s_bag2 = getResources().getString(R.string.bag_sepertiga);
				s_syr2 = getResources().getString(R.string.suam_sy2);
				row3.setVisibility(View.GONE);
				row4.setVisibility(View.GONE);
				row5.setVisibility(View.GONE);
				break;
			case 4 :
				s_head = getResources().getString(R.string.str_bapak);
				s_bag1 = getResources().getString(R.string.bag_seperenam);
				s_syr1 = getResources().getString(R.string.bp_sy1);
				s_bag2 = getResources().getString(R.string.bag_seperenamsisa);
				s_syr2 = getResources().getString(R.string.bp_sy2);
				s_bag3 = getResources().getString(R.string.bag_ashabah);
				s_syr3 = getResources().getString(R.string.bp_sy3);
				s_bag4 = getResources().getString(R.string.bag_seluruh);
				s_syr4 = getResources().getString(R.string.bp_sy4);
				row5.setVisibility(View.GONE);
				break;
			case 5 :
				s_head = getResources().getString(R.string.str_ibu);
				s_bag1 = getResources().getString(R.string.bag_seperenam);
				s_syr1 = getResources().getString(R.string.ibu_sy1);
				s_bag2 = getResources().getString(R.string.bag_sepertiga);
				s_syr2 = getResources().getString(R.string.ibu_sy2);
				s_bag3 = getResources().getString(R.string.bag_sepertiga);
				s_syr3 = getResources().getString(R.string.ibu_sy3);
				row4.setVisibility(View.GONE);
				row5.setVisibility(View.GONE);
				break;
			case 6 :
				s_head = getResources().getString(R.string.str_kakek);
				s_bag1 = getResources().getString(R.string.bag_seperenam);
				s_syr1 = getResources().getString(R.string.kakek_sy1);
				s_bag2 = getResources().getString(R.string.bag_seperenamsisa);
				s_syr2 = getResources().getString(R.string.kakek_sy2);
				s_bag3 = getResources().getString(R.string.bag_ashabah);
				s_syr3 = getResources().getString(R.string.kakek_sy3);
				s_bag4 = getResources().getString(R.string.bag_seluruh);
				s_syr4 = getResources().getString(R.string.kakek_sy4);
				s_bag5 = getResources().getString(R.string.bag_terhalang);
				s_syr5 = getResources().getString(R.string.kakek_sy5);
				break;
			case 7 :
				s_head = getResources().getString(R.string.str_nenek_bapak);
				s_bag1 = getResources().getString(R.string.bag_seperenam);
				s_syr1 = getResources().getString(R.string.nenekb_sy1);
				s_bag2 = getResources().getString(R.string.bag_terhalang);
				s_syr2 = getResources().getString(R.string.nenekb_sy2);
				row3.setVisibility(View.GONE);
				row4.setVisibility(View.GONE);
				row5.setVisibility(View.GONE);
				break;
			case 8 :
				s_head = getResources().getString(R.string.str_nenek_ibu);
				s_bag1 = getResources().getString(R.string.bag_seperenam);
				s_syr1 = getResources().getString(R.string.neneki_sy1);
				s_bag2 = getResources().getString(R.string.bag_terhalang);
				s_syr2 = getResources().getString(R.string.neneki_sy2);
				row3.setVisibility(View.GONE);
				row4.setVisibility(View.GONE);
				row5.setVisibility(View.GONE);
				break;
			case 9 :
				s_head = getResources().getString(R.string.str_cucu_laki);
				s_bag1 = getResources().getString(R.string.bag_ashabah);
				s_syr1 = getResources().getString(R.string.cl_sy1);
				s_bag2 = getResources().getString(R.string.bag_seluruh);
				s_syr2 = getResources().getString(R.string.cl_sy2);
				s_bag3 = getResources().getString(R.string.bag_terhalang);
				s_syr3 = getResources().getString(R.string.cl_sy3);
				row4.setVisibility(View.GONE);
				row5.setVisibility(View.GONE);
				break;
			case 10 :
				s_head = getResources().getString(R.string.str_cucu_perempuan);
				s_bag1 = getResources().getString(R.string.bag_setengah);
				s_syr1 = getResources().getString(R.string.cp_sy1);
				s_bag2 = getResources().getString(R.string.bag_seperenam);
				s_syr2 = getResources().getString(R.string.cp_sy2);
				s_bag3 = getResources().getString(R.string.bag_duapertiga);
				s_syr3 = getResources().getString(R.string.cp_sy3);
				s_bag4 = getResources().getString(R.string.bag_ashabah);
				s_syr4 = getResources().getString(R.string.cp_sy4);
				s_bag5 = getResources().getString(R.string.bag_terhalang);
				s_syr5 = getResources().getString(R.string.cp_sy5);
				break;
			case 11 :
				s_head = getResources().getString(R.string.str_saudara_kandung);
				s_bag1 = getResources().getString(R.string.bag_ashabah);
				s_syr1 = getResources().getString(R.string.sdk_sy1);
				s_bag2 = getResources().getString(R.string.bag_terhalang);
				s_syr2 = getResources().getString(R.string.sdk_sy2);
				row3.setVisibility(View.GONE);
				row4.setVisibility(View.GONE);
				row5.setVisibility(View.GONE);
				break;
			case 12 :
				s_head = getResources().getString(R.string.str_saudari_kandung);
				s_bag1 = getResources().getString(R.string.bag_seperenam);
				s_syr1 = getResources().getString(R.string.sdik_sy1);
				s_bag2 = getResources().getString(R.string.bag_sepertiga_);
				s_syr2 = getResources().getString(R.string.sdik_sy2);
				s_bag3 = getResources().getString(R.string.bag_terhalang);
				s_syr3 = getResources().getString(R.string.sdik_sy3);
				row4.setVisibility(View.GONE);
				row5.setVisibility(View.GONE);
				break;
			case 13 :
				s_head = getResources().getString(R.string.str_saudara_sebapak);
				s_bag1 = getResources().getString(R.string.bag_ashabah);
				s_syr1 = getResources().getString(R.string.sdb_sy1);
				row2.setVisibility(View.GONE);
				row3.setVisibility(View.GONE);
				row4.setVisibility(View.GONE);
				row5.setVisibility(View.GONE);
				break;
			case 14 :
				s_head = getResources().getString(R.string.str_saudari_sebapak);
				s_bag1 = getResources().getString(R.string.bag_setengah);
				s_syr1 = getResources().getString(R.string.sdib_sy1);
				s_bag2 = getResources().getString(R.string.bag_duapertiga);
				s_syr2 = getResources().getString(R.string.sdib_sy2);
				s_bag3 = getResources().getString(R.string.bag_ashabah);
				s_syr3 = getResources().getString(R.string.sdib_sy3);
				s_bag4 = getResources().getString(R.string.bag_terhalang);
				s_syr4 = getResources().getString(R.string.sdib_sy4);
				row5.setVisibility(View.GONE);
				break;
			case 15 :
				s_head = getResources().getString(R.string.str_saudara_seibu);
				s_bag1 = getResources().getString(R.string.bag_seperenam);
				s_syr1 = getResources().getString(R.string.sdi_sy1);
				s_bag2 = getResources().getString(R.string.bag_sepertiga);
				s_syr2 = getResources().getString(R.string.sdi_sy2);
				s_bag3 = getResources().getString(R.string.bag_terhalang);
				s_syr3 = getResources().getString(R.string.sdi_sy3);
				row4.setVisibility(View.GONE);
				row5.setVisibility(View.GONE);
				break;
			case 16 :
				s_head = getResources().getString(R.string.str_saudari_seibu);
				s_bag1 = getResources().getString(R.string.bag_seperenam);
				s_syr1 = getResources().getString(R.string.sdi_sy1);
				s_bag2 = getResources().getString(R.string.bag_sepertiga);
				s_syr2 = getResources().getString(R.string.sdi_sy2);
				s_bag3 = getResources().getString(R.string.bag_terhalang);
				s_syr3 = getResources().getString(R.string.sdi_sy3);
				row4.setVisibility(View.GONE);
				row5.setVisibility(View.GONE);
				break;
			case 17 :
				s_head = getResources().getString(R.string.str_keponakan_sekandung);
				s_bag1 = getResources().getString(R.string.bag_ashabah);
				s_syr1 = getResources().getString(R.string.kp_k_sy1);
				row2.setVisibility(View.GONE);
				row3.setVisibility(View.GONE);
				row4.setVisibility(View.GONE);
				row5.setVisibility(View.GONE);
				break;
			case 18 :
				s_head = getResources().getString(R.string.str_keponakan_sebapak);
				s_bag1 = getResources().getString(R.string.bag_ashabah);
				s_syr1 = getResources().getString(R.string.kp_b_sy1);
				row2.setVisibility(View.GONE);
				row3.setVisibility(View.GONE);
				row4.setVisibility(View.GONE);
				row5.setVisibility(View.GONE);
				break;
			case 19 :
				s_head = getResources().getString(R.string.str_paman_kandung);
				s_bag1 = getResources().getString(R.string.bag_ashabah);
				s_syr1 = getResources().getString(R.string.pk_sy1);
				row2.setVisibility(View.GONE);
				row3.setVisibility(View.GONE);
				row4.setVisibility(View.GONE);
				row5.setVisibility(View.GONE);
				break;
			case 20 :
				s_head = getResources().getString(R.string.str_paman_sebapak);
				s_bag1 = getResources().getString(R.string.bag_ashabah);
				s_syr1 = getResources().getString(R.string.pb_sy1);
				row2.setVisibility(View.GONE);
				row3.setVisibility(View.GONE);
				row4.setVisibility(View.GONE);
				row5.setVisibility(View.GONE);
				break;
			case 21 :
				s_head = getResources().getString(R.string.str_anak_paman_kandung);
				s_bag1 = getResources().getString(R.string.bag_ashabah);
				s_syr1 = getResources().getString(R.string.apk_sy1);
				row2.setVisibility(View.GONE);
				row3.setVisibility(View.GONE);
				row4.setVisibility(View.GONE);
				row5.setVisibility(View.GONE);
				break;
			case 22 :
				s_head = getResources().getString(R.string.str_anak_paman_sebapak);
				s_bag1 = getResources().getString(R.string.bag_ashabah);
				s_syr1 = getResources().getString(R.string.apb_sy1);
				row2.setVisibility(View.GONE);
				row3.setVisibility(View.GONE);
				row4.setVisibility(View.GONE);
				row5.setVisibility(View.GONE);
				break;
			default :
				finish();
				overridePendingTransition(R.anim.stand, R.anim.exit_to_bottom);
				break;	
		}
		
		head.setText(s_head);
		bag1.setText(s_bag1);
		bag2.setText(s_bag2);
		bag3.setText(s_bag3);
		bag4.setText(s_bag4);
		bag5.setText(s_bag5);
		syr1.setText(s_syr1);
		syr2.setText(s_syr2);
		syr3.setText(s_syr3);
		syr4.setText(s_syr4);
		syr5.setText(s_syr5);
	}
	
	public void onBackPressed() {
		finish();
		overridePendingTransition(R.anim.stand, R.anim.slide_to_right);
	}
}
