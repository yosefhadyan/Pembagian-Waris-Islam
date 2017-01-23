package id.barkost.waris;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class HitungHasil extends Activity {

    public int iHarta = Varr.iHarta;
    public int iJumlahBapak = Varr.iJumlahBapak, iJumlahIbu = Varr.iJumlahIbu,
            iJumlahSuami = Varr.iJumlahSuami, iJumlahIstri = Varr.iJumlahIstri,
            iJumlahAnakLaki = Varr.iJumlahAnakLaki,
            iJumlahAnakPerempuan = Varr.iJumlahAnakPerempuan,
            iJumlahCucuLaki = Varr.iJumlahCucuLaki,
            iJumlahCucuPerempuan = Varr.iJumlahCucuPerempuan,
            iJumlahKakek = Varr.iJumlahKakek,
            iJumlahNenekBapak = Varr.iJumlahNenekBapak,
            iJumlahNenekIbu = Varr.iJumlahNenekIbu,
            iJumlahNenekKakek = Varr.iJumlahNenekKakek,
            iJumlahSaudaraKandung = Varr.iJumlahSaudaraKandung,
            iJumlahSaudariKandung = Varr.iJumlahSaudariKandung,
            iJumlahSaudaraSebapak = Varr.iJumlahSaudaraSebapak,
            iJumlahSaudariSebapak = Varr.iJumlahSaudariSebapak,
            iJumlahSaudaraSeibu = Varr.iJumlahSaudaraSeibu,
            iJumlahSaudariSeibu = Varr.iJumlahSaudariSeibu,
            iJumlahPutraSaudaraKandung = Varr.iJumlahPutraSaudaraKandung,
            iJumlahPutraSaudaraSebapak = Varr.iJumlahPutraSaudaraSebapak,
            iJumlahPamanKandung = Varr.iJumlahPamanKandung,
            iJumlahPamanSebapak = Varr.iJumlahPamanSebapak,
            iJumlahPutraPamanKandung = Varr.iJumlahPutraPamanKandung,
            iJumlahPutraPamanSebapak = Varr.iJumlahPutraPamanSebapak,
            iJumlahPriaMerdekakan = Varr.iJumlahPriaMerdekakan,
            iJumlahWanitaMerdekakan = Varr.iJumlahWanitaMerdekakan;

    public long iJthSuami = 0, iJthIstri = 0, iJthBapak = 0, iJthIbu = 0,
            iJthAnakLaki = 0, iJthAnakPerempuan = 0, iJthCucuLaki = 0,
            iJthCucuPerempuan = 0, iJthKakek = 0, iJthNenekBapak = 0,
            iJthNenekIbu = 0, iJthNenekKakek = 0, iJthSaudaraKandung = 0,
            iJthSaudariKandung = 0, iJthSaudaraSebapak = 0,
            iJthSaudaraSeibu = 0, iJthSaudariSebapak = 0, iJthSaudariSeibu = 0,
            iJthPutraSaudaraKandung = 0, iJthPutraSaudaraSebapak = 0,
            iJthPamanKandung = 0, iJthPamanSebapak = 0,
            iJthPutraPamanKandung = 0, iJthPutraPamanSebapak = 0,
            iJthPriaMerdekakan = 0, iJthWanitaMerdekakan = 0, iSisa;
    public String resultToPrint = "Harta yang Siap Dibagikan (Irst) : "
            + ConvertToRupiah(iHarta)  + "\n\n\n";
    public Button back, reset, home;
    public TextView tx_hasil;
    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hitung_hasil);

        anim = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_from_right);
        tx_hasil = (TextView) findViewById(R.id.tx_hasil);
        tx_hasil.setVisibility(View.GONE);

        back = (Button) findViewById(R.id.btn_hasil_back);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_from_left,
                        R.anim.slide_to_right);
            }
        });

        reset = (Button) findViewById(R.id.btn_hasil_reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HitungHasil.this, Hitung1.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
                reset();
                overridePendingTransition(R.anim.slide_from_left,
                        R.anim.slide_to_right);
            }
        });

        home = (Button) findViewById(R.id.btn_hasil_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HitungHasil.this, AdsActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
                reset();
                //overridePendingTransition(R.anim.stand, R.anim.exit_to_bottom);
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tx_hasil.setVisibility(View.VISIBLE);
                tx_hasil.startAnimation(anim);
            }
        }, 1000);

        show();
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

    public void show() {
        if ((iJumlahBapak == 0) && (iJumlahIbu == 0) && (iJumlahSuami == 0)
                && (iJumlahIstri == 0) && (iJumlahAnakLaki == 0)
                && (iJumlahAnakPerempuan == 0) && (iJumlahCucuLaki == 0)
                && (iJumlahCucuPerempuan == 0) && (iJumlahKakek == 0)
                && (iJumlahNenekBapak == 0) && (iJumlahNenekIbu == 0)
                && (iJumlahSaudaraKandung == 0) && (iJumlahSaudariKandung == 0)
                && (iJumlahSaudaraSebapak == 0) && (iJumlahSaudaraSeibu == 0)
                && (iJumlahSaudariSebapak == 0) && (iJumlahSaudariSeibu == 0)
                && (iJumlahPutraSaudaraKandung == 0)
                && (iJumlahPutraSaudaraSebapak == 0)
                && (iJumlahPamanKandung == 0) && (iJumlahPamanSebapak == 0)
                && (iJumlahPutraPamanKandung == 0)
                && (iJumlahPutraPamanSebapak == 0)
                && (iJumlahPriaMerdekakan == 0)
                && (iJumlahWanitaMerdekakan == 0)) {
            String a = "ahli waris masih kosong, silahkan diisi";
            tx_hasil.setText(a);
        } else {
            hitung();
        }
    }

    public void hitung() {
        if (iJumlahAnakLaki == 0 && iJumlahAnakPerempuan == 0) {
            if (iJumlahCucuLaki == 0 && iJumlahCucuPerempuan == 0) {
                if (iJumlahSuami == 1) {
                    iJthSuami = Math.round(iHarta / 2);
                    if (iJumlahIbu == 1) {
                        iJthIbu = Math.round(iHarta / 6) * iJumlahIbu;
                    }
                    if (iJumlahIbu == 0) {
                        if (iJumlahNenekBapak == 1 && iJumlahNenekIbu == 0) {
                            iJthNenekBapak = Math.round(iHarta / 6)
                                    * iJumlahNenekBapak;
                        }
                        if (iJumlahNenekBapak == 0 && iJumlahNenekIbu == 1) {
                            iJthNenekIbu = Math.round(iHarta / 6)
                                    * iJumlahNenekIbu;
                        }
                        if (iJumlahNenekBapak == 1 && iJumlahNenekIbu == 1) {
                            iJthNenekBapak = Math.round(iHarta / 12)
                                    * iJumlahNenekBapak;
                            iJthNenekIbu = Math.round(iHarta / 12)
                                    * iJumlahNenekIbu;
                        }
                        if (iJumlahNenekBapak == 0 && iJumlahNenekIbu == 0) {
                            iJthNenekKakek = Math.round(iHarta / 6)
                                    * iJumlahNenekKakek;
                        }
                    }
                    if (iJumlahBapak > 0) {
                        iJthBapak = Math.round(iHarta / 3);
                        iSisa = iHarta
                                - (iJthSuami + iJthIbu + iJthBapak
                                + iJthNenekBapak * iJumlahNenekBapak
                                + iJthNenekIbu * iJumlahNenekIbu + iJthNenekKakek
                                * iJumlahNenekKakek);
                        iJthBapak = iJthBapak + iSisa * iJumlahBapak;
                        iSisa = iHarta
                                - (iJthSuami + iJthIbu + iJthBapak
                                + iJthNenekBapak * iJumlahNenekBapak
                                + iJthNenekIbu * iJumlahNenekIbu + iJthNenekKakek
                                * iJumlahNenekKakek);
                        if (iJumlahSaudaraSeibu > 0)
                            resultToPrint += "Jatah tiap Saudara Seibu : 0 (karena dihalangi oleh Bapak)\n";
                        if (iJumlahSaudaraKandung > 0)
                            resultToPrint += "Jatah tiap Saudara Kandung : 0 (karena dihalangi oleh Bapak)\n";
                        if (iJumlahSaudariKandung > 0)
                            resultToPrint += "Jatah tiap Saudari Kandung : 0 (karena dihalangi oleh Bapak)\n";
                        if (iJumlahSaudariSeibu > 0)
                            resultToPrint += "Jatah tiap Saudari Seibu : 0 (karena dihalangi oleh Bapak)\n";
                        if (iJumlahSaudaraSebapak > 0)
                            resultToPrint += "Jatah tiap Saudara Sebapak : 0 (karena dihalangi oleh Bapak)\n";
                        if (iJumlahSaudariSebapak > 0)
                            resultToPrint += "Jatah tiap Saudari Sebapak : 0 (karena dihalangi oleh Bapak)\n";
                        if (iJumlahPutraSaudaraKandung > 0)
                            resultToPrint += "Jatah tiap Putra Saudara Kandung : 0 (karena dihalangi oleh Bapak)\n";
                        if (iJumlahPutraSaudaraSebapak > 0)
                            resultToPrint += "Jatah tiap Putra Saudara Sebapak : 0 (karena dihalangi oleh Bapak)\n";
                        if (iJumlahPamanKandung > 0)
                            resultToPrint += "Jatah tiap Paman Kandung : 0 (karena dihalangi oleh Bapak)\n";
                        if (iJumlahPamanSebapak > 0)
                            resultToPrint += "Jatah tiap Paman Sebapak : 0 (karena dihalangi oleh Bapak)\n";
                        if (iJumlahPutraPamanKandung > 0)
                            resultToPrint += "Jatah tiap Putra Paman Kandung : 0 (karena dihalangi oleh Bapak)\n";
                        if (iJumlahPutraPamanSebapak > 0)
                            resultToPrint += "Jatah tiap Putra Paman Sebapak : 0 (karena dihalangi oleh Bapak)\n";
                        if (iJumlahPriaMerdekakan > 0)
                            resultToPrint += "Jatah Pria yang Memerdekakan Budak : 0 (karena dihalangi oleh Bapak)\n";
                        if (iJumlahWanitaMerdekakan > 0)
                            resultToPrint += "Jatah Wanita yang Memerdekakan Budak : 0 (karena dihalangi oleh Bapak)\n";
                    }
                    if (iJumlahBapak == 0) {
                        if (iJumlahKakek == 1) {
                            iJthKakek = Math.round(iHarta / 3) * iJumlahKakek;
                            iSisa = iHarta
                                    - (iJthSuami + iJthIbu + iJthKakek
                                    + iJthNenekBapak
                                    * iJumlahNenekBapak + iJthNenekIbu
                                    * iJumlahNenekIbu + iJthNenekKakek
                                    * iJumlahNenekKakek);
                            iJthKakek = iJthKakek + iSisa * iJumlahKakek;
                            iSisa = iHarta
                                    - (iJthSuami + iJthIbu + iJthKakek
                                    + iJthNenekBapak
                                    * iJumlahNenekBapak + iJthNenekIbu
                                    * iJumlahNenekIbu + iJthNenekKakek
                                    * iJumlahNenekKakek);
                            if (iJumlahSaudaraSeibu > 0)
                                resultToPrint += "Jatah tiap Saudara Seibu : 0 (karena dihalangi oleh Kakek)\n";
                            if (iJumlahSaudaraKandung > 0)
                                resultToPrint += "Jatah tiap Saudara Kandung : 0 (karena dihalangi oleh Kakek)\n";
                            if (iJumlahSaudariKandung > 0)
                                resultToPrint += "Jatah tiap Saudari Kandung : 0 (karena dihalangi oleh Kakek)\n";
                            if (iJumlahSaudariSeibu > 0)
                                resultToPrint += "Jatah tiap Saudari Seibu : 0 (karena dihalangi oleh Kakek)\n";
                            if (iJumlahSaudaraSebapak > 0)
                                resultToPrint += "Jatah tiap Saudara Sebapak : 0 (karena dihalangi oleh Kakek)\n";
                            if (iJumlahSaudariSebapak > 0)
                                resultToPrint += "Jatah tiap Saudari Sebapak : 0 (karena dihalangi oleh Kakek)\n";
                            if (iJumlahPutraSaudaraKandung > 0)
                                resultToPrint += "Jatah tiap Putra Saudara Kandung : 0 (karena dihalangi oleh Kakek)\n";
                            if (iJumlahPutraSaudaraSebapak > 0)
                                resultToPrint += "Jatah tiap Putra Saudara Sebapak : 0 (karena dihalangi oleh Kakek)\n";
                            if (iJumlahPamanKandung > 0)
                                resultToPrint += "Jatah tiap Paman Kandung : 0 (karena dihalangi oleh Kakek)\n";
                            if (iJumlahPamanSebapak > 0)
                                resultToPrint += "Jatah tiap Paman Sebapak : 0 (karena dihalangi oleh Kakek)\n";
                            if (iJumlahPutraPamanKandung > 0)
                                resultToPrint += "Jatah tiap Putra Paman Kandung : 0 (karena dihalangi oleh Kakek)\n";
                            if (iJumlahPutraPamanSebapak > 0)
                                resultToPrint += "Jatah tiap Putra Paman Sebapak : 0 (karena dihalangi oleh Kakek)\n";
                            if (iJumlahPriaMerdekakan > 0)
                                resultToPrint += "Jatah Pria yang Memerdekakan Budak : 0 (karena dihalangi oleh Kakek)\n";
                            if (iJumlahWanitaMerdekakan > 0)
                                resultToPrint += "Jatah Wanita yang Memerdekakan Budak : 0 (karena dihalangi oleh Kakek)\n";
                        }
                        if (iJumlahKakek == 0) {
                            if (iJumlahSaudaraSeibu == 1) {
                                iJthSaudaraSeibu = Math.round(iHarta / 6);
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek + iJthSaudaraSeibu);
                                resultToPrint += "Jatah tiap Saudara Seibu (1/6) : "
                                        + ConvertToRupiah(iJthSaudaraSeibu) + "\n";
                            }
                            if (iJumlahSaudaraSeibu > 1) {
                                iJthSaudaraSeibu = Math.round(iHarta / 3);
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek + iJthSaudaraSeibu);
                                resultToPrint += "Jatah tiap Saudara Seibu (1/3) : "
                                        + ConvertToRupiah((iJthSaudaraSeibu / iJumlahSaudaraSeibu))
                                        + "\n";
                            }
                            if (iJumlahSaudaraKandung > 0) {
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek + iJthSaudaraSeibu);
                                if (iJumlahSaudariKandung == 0) {
                                    iJthSaudaraKandung = Math.round(iSisa
                                            / iJumlahSaudaraKandung);
                                }
                                if (iJumlahSaudariKandung > 0) {
                                    iJthSaudaraKandung = Math
                                            .round(iSisa
                                                    / (iJumlahSaudaraKandung + iJumlahSaudariKandung));
                                    iJthSaudariKandung = iJthSaudaraKandung;
                                    resultToPrint += "Jatah tiap Saudari Kandung (Sisa) : "
                                            + ConvertToRupiah((iJthSaudariKandung)) + "\n";
                                }
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek
                                        + iJthSaudaraSeibu
                                        + iJthSaudaraKandung
                                        * iJumlahSaudaraKandung + iJthSaudariKandung
                                        * iJumlahSaudariKandung);
                                resultToPrint += "Jatah tiap Saudara Kandung (Sisa) : "
                                        + ConvertToRupiah((iJthSaudaraKandung)) + "\n";
                                if (iJumlahSaudaraSebapak > 0)
                                    resultToPrint += "Jatah tiap Saudara Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahPutraSaudaraKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahPutraSaudaraSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahPriaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahWanitaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahSaudariSebapak > 0)
                                    resultToPrint += "Jatah tiap Saudari Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                            }
                            if (iJumlahSaudaraKandung == 0) {
                                if (iJumlahSaudariKandung > 1) {
                                    iJthSaudariKandung = Math
                                            .round((2 * iHarta / 3)
                                                    / iJumlahSaudariKandung);
                                    iSisa = iHarta
                                            - (iJthSuami + iJthIbu
                                            + iJthNenekBapak
                                            * iJumlahNenekBapak
                                            + iJthNenekIbu
                                            * iJumlahNenekIbu
                                            + iJthNenekKakek
                                            * iJumlahNenekKakek
                                            + iJthSaudaraSeibu + iJthSaudariKandung
                                            * iJumlahSaudariKandung);
                                    resultToPrint += "Jatah tiap Saudari Kandung (2/3) : "
                                            + ConvertToRupiah((iJthSaudariKandung)) + "\n";
                                    if (iJumlahSaudariSebapak > 0
                                            && iJumlahSaudaraSebapak == 0) {
                                        resultToPrint += "Jatah tiap Saudari Sebapak : 0(Karena dihalangi 2 Saudari Kandung atau lebih)"
                                                + "\n";
                                    }
                                }
                                if (iJumlahSaudariKandung == 1
                                        || iJumlahSaudariKandung == 0) {
                                    iJthSaudariKandung = Math.round(iHarta / 2);
                                    if (iJumlahSaudaraSebapak == 0
                                            && iJumlahSaudariSebapak == 1) {
                                        iJthSaudariSebapak = Math
                                                .round(iHarta / 2);
                                        resultToPrint += "Jatah tiap Saudari Sebapak (1/2) : "
                                                + ConvertToRupiah((iJthSaudariSebapak / iJumlahSaudariSebapak))
                                                + "\n";
                                    }
                                    if (iJumlahSaudaraSebapak == 0
                                            && iJumlahSaudariSebapak > 1) {
                                        iJthSaudariSebapak = Math
                                                .round((2 * iHarta / 3)
                                                        / iJumlahSaudariSebapak);
                                        resultToPrint += "Jatah tiap Saudari Sebapak (2/3) : "
                                                + ConvertToRupiah((iJthSaudariSebapak)) + "\n";
                                    }
                                    iSisa = iHarta
                                            - (iJthSuami + iJthIbu
                                            + iJthNenekBapak
                                            * iJumlahNenekBapak
                                            + iJthNenekIbu
                                            * iJumlahNenekIbu
                                            + iJthNenekKakek
                                            * iJumlahNenekKakek
                                            + iJthSaudaraSeibu
                                            + iJthSaudariKandung
                                            * iJumlahSaudariKandung + iJthSaudariSebapak
                                            * iJumlahSaudariSebapak);
                                    if (iJumlahSaudariKandung == 1)
                                        resultToPrint += "Jatah tiap Saudari Kandung (1/2) : "
                                                + ConvertToRupiah((iJthSaudariKandung / iJumlahSaudariKandung))
                                                + "\n";
                                }
                                if (iJumlahSaudaraSebapak > 0) {
                                    iSisa = iHarta
                                            - (iJthSuami + iJthIbu
                                            + iJthNenekBapak
                                            * iJumlahNenekBapak
                                            + iJthNenekIbu
                                            * iJumlahNenekIbu
                                            + iJthNenekKakek
                                            * iJumlahNenekKakek + iJthSaudaraSeibu);
                                    iJthSaudaraSebapak = Math
                                            .round(iSisa
                                                    / (iJumlahSaudaraSebapak + iJumlahSaudariSebapak));
                                    iJthSaudariSebapak = iJthSaudaraSebapak;
                                    iSisa = iHarta
                                            - (iJthSuami + iJthIbu
                                            + iJthNenekBapak
                                            * iJumlahNenekBapak
                                            + iJthNenekIbu
                                            * iJumlahNenekIbu
                                            + iJthNenekKakek
                                            * iJumlahNenekKakek
                                            + iJthSaudaraSeibu
                                            + iJthSaudaraSebapak
                                            * iJumlahSaudaraSebapak + iJthSaudariSebapak
                                            * iJumlahSaudariSebapak);
                                    resultToPrint += "Jatah tiap Saudara Sebapak (Sisa) : "
                                            + ConvertToRupiah((iJthSaudaraSebapak)) + "\n";
                                    if (iJumlahSaudariSebapak > 0)
                                        resultToPrint += "Jatah tiap Saudari Sebapak (Sisa) : "
                                                + ConvertToRupiah((iJthSaudariSebapak)) + "\n";
                                    if (iJumlahPutraSaudaraKandung > 0)
                                        resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                    if (iJumlahPutraSaudaraSebapak > 0)
                                        resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                    if (iJumlahPamanKandung > 0)
                                        resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                    if (iJumlahPamanSebapak > 0)
                                        resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                    if (iJumlahPutraPamanKandung > 0)
                                        resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                    if (iJumlahPutraPamanSebapak > 0)
                                        resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                    if (iJumlahPriaMerdekakan > 0)
                                        resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                    if (iJumlahWanitaMerdekakan > 0)
                                        resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                }
                                if (iJumlahSaudaraSebapak == 0) {
                                    iSisa = iHarta
                                            - (iJthSuami + iJthIbu
                                            + iJthNenekBapak
                                            * iJumlahNenekBapak
                                            + iJthNenekIbu
                                            * iJumlahNenekIbu
                                            + iJthNenekKakek
                                            * iJumlahNenekKakek
                                            + iJthSaudaraSeibu
                                            * iJumlahSaudaraSeibu
                                            + iJthSaudariKandung
                                            * iJumlahSaudariKandung + iJthSaudariSebapak
                                            * iJumlahSaudariSebapak);
                                    if (iJumlahPutraSaudaraKandung > 0) {
                                        iJthPutraSaudaraKandung = Math
                                                .round(iSisa
                                                        / iJumlahPutraSaudaraKandung);
                                        iSisa = iHarta
                                                - (iJthSuami + iJthIbu
                                                + iJthNenekBapak
                                                * iJumlahNenekBapak
                                                + iJthNenekIbu
                                                * iJumlahNenekIbu
                                                + iJthNenekKakek
                                                * iJumlahNenekKakek
                                                + iJthSaudaraSeibu
                                                * iJumlahSaudaraSeibu
                                                + iJthSaudariKandung
                                                * iJumlahSaudariKandung
                                                + iJthSaudariSebapak
                                                * iJumlahSaudariSebapak + iJthPutraSaudaraKandung
                                                * iJumlahPutraSaudaraKandung);
                                        resultToPrint += "Jatah tiap Putra dari Saudara Sekandung (Sisa) : "
                                                + ConvertToRupiah((iJthPutraSaudaraKandung))
                                                + "\n";
                                        if (iJumlahPutraSaudaraSebapak > 0)
                                            resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Putra dari Saudara Sekandung)"
                                                    + "\n";
                                        if (iJumlahPamanKandung > 0)
                                            resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Putra dari Saudara Sekandung)"
                                                    + "\n";
                                        if (iJumlahPamanSebapak > 0)
                                            resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Putra dari Saudara Sekandung)"
                                                    + "\n";
                                        if (iJumlahPutraPamanKandung > 0)
                                            resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Putra dari Saudara Sekandung)"
                                                    + "\n";
                                        if (iJumlahPutraPamanSebapak > 0)
                                            resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Putra dari Saudara Sekandung)"
                                                    + "\n";
                                        if (iJumlahPriaMerdekakan > 0)
                                            resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Saudara Sekandung)"
                                                    + "\n";
                                        if (iJumlahWanitaMerdekakan > 0)
                                            resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Saudara Sekandung)"
                                                    + "\n";
                                    }
                                    if (iJumlahPutraSaudaraKandung == 0) {
                                        iJthPutraSaudaraSebapak = Math
                                                .round(iSisa
                                                        / iJumlahPutraSaudaraSebapak);
                                        if (iJumlahPutraSaudaraSebapak > 0) {
                                            iSisa = iHarta
                                                    - (iJthSuami
                                                    + iJthIbu
                                                    + iJthNenekBapak
                                                    * iJumlahNenekBapak
                                                    + iJthNenekIbu
                                                    * iJumlahNenekIbu
                                                    + iJthNenekKakek
                                                    * iJumlahNenekKakek
                                                    + iJthSaudaraSeibu
                                                    * iJumlahSaudaraSeibu
                                                    + iJthSaudariKandung
                                                    * iJumlahSaudariKandung
                                                    + iJthSaudariSebapak
                                                    * iJumlahSaudariSebapak + iJthPutraSaudaraSebapak
                                                    * iJumlahPutraSaudaraSebapak);
                                            resultToPrint += "Jatah tiap Putra dari Saudara Sebapak (Sisa) : "
                                                    + ConvertToRupiah((iJthPutraSaudaraSebapak))
                                                    + "\n";
                                            if (iJumlahPamanKandung > 0)
                                                resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Putra dari Saudara Sebapak)"
                                                        + "\n";
                                            if (iJumlahPamanSebapak > 0)
                                                resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Putra dari Saudara Sebapak)"
                                                        + "\n";
                                            if (iJumlahPutraPamanKandung > 0)
                                                resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Putra dari Saudara Sebapak)"
                                                        + "\n";
                                            if (iJumlahPutraPamanSebapak > 0)
                                                resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Putra dari Saudara Sebapak)"
                                                        + "\n";
                                            if (iJumlahPriaMerdekakan > 0)
                                                resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Saudara Sebapak)"
                                                        + "\n";
                                            if (iJumlahWanitaMerdekakan > 0)
                                                resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Saudara Sebapak)"
                                                        + "\n";
                                        }
                                        if (iJumlahPutraSaudaraSebapak == 0) {
                                            iJthPamanKandung = Math.round(iSisa
                                                    / iJumlahPamanKandung);
                                            if (iJumlahPamanKandung > 0) {
                                                iSisa = iHarta
                                                        - (iJthSuami
                                                        + iJthIbu
                                                        + iJthNenekBapak
                                                        * iJumlahNenekBapak
                                                        + iJthNenekIbu
                                                        * iJumlahNenekIbu
                                                        + iJthNenekKakek
                                                        * iJumlahNenekKakek
                                                        + iJthSaudaraSeibu
                                                        * iJumlahSaudaraSeibu
                                                        + iJthSaudariKandung
                                                        * iJumlahSaudariKandung
                                                        + iJthSaudariSebapak
                                                        * iJumlahSaudariSebapak + iJthPamanKandung
                                                        * iJumlahPamanKandung);
                                                resultToPrint += "Jatah tiap Paman Sekandung (Sisa) : "
                                                        + ConvertToRupiah((iJthPamanKandung))
                                                        + "\n";
                                                if (iJumlahPamanSebapak > 0)
                                                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Paman Sekandung)"
                                                            + "\n";
                                                if (iJumlahPutraPamanKandung > 0)
                                                    resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Paman Sekandung)"
                                                            + "\n";
                                                if (iJumlahPutraPamanSebapak > 0)
                                                    resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Paman Sekandung)"
                                                            + "\n";
                                                if (iJumlahPriaMerdekakan > 0)
                                                    resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Paman Sekandung)"
                                                            + "\n";
                                                if (iJumlahWanitaMerdekakan > 0)
                                                    resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Paman Sekandung)"
                                                            + "\n";
                                            }
                                            if (iJumlahPamanKandung == 0) {
                                                iJthPamanSebapak = Math
                                                        .round(iSisa
                                                                / iJumlahPamanSebapak);
                                                if (iJumlahPamanSebapak > 0) {
                                                    iSisa = iHarta
                                                            - (iJthSuami
                                                            + iJthIbu
                                                            + iJthNenekBapak
                                                            * iJumlahNenekBapak
                                                            + iJthNenekIbu
                                                            * iJumlahNenekIbu
                                                            + iJthNenekKakek
                                                            * iJumlahNenekKakek
                                                            + iJthSaudaraSeibu
                                                            * iJumlahSaudaraSeibu
                                                            + iJthSaudariKandung
                                                            * iJumlahSaudariKandung
                                                            + iJthSaudariSebapak
                                                            * iJumlahSaudariSebapak + iJthPamanSebapak
                                                            * iJumlahPamanSebapak);
                                                    resultToPrint += "Jatah tiap Paman Sebapak (Sisa) : "
                                                            + ConvertToRupiah((iJthPamanSebapak))
                                                            + "\n";
                                                    if (iJumlahPutraPamanKandung > 0)
                                                        resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Paman Sebapak)"
                                                                + "\n";
                                                    if (iJumlahPutraPamanSebapak > 0)
                                                        resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Paman Sebapak)"
                                                                + "\n";
                                                    if (iJumlahPriaMerdekakan > 0)
                                                        resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Paman Sebapak)"
                                                                + "\n";
                                                    if (iJumlahWanitaMerdekakan > 0)
                                                        resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Paman Sebapak)"
                                                                + "\n";
                                                }
                                                if (iJumlahPamanSebapak == 0) {
                                                    iJthPutraPamanKandung = Math
                                                            .round(iSisa
                                                                    / iJumlahPutraPamanKandung);
                                                    if (iJumlahPutraPamanKandung > 0) {
                                                        iSisa = iHarta
                                                                - (iJthSuami
                                                                + iJthIbu
                                                                + iJthNenekBapak
                                                                * iJumlahNenekBapak
                                                                + iJthNenekIbu
                                                                * iJumlahNenekIbu
                                                                + iJthNenekKakek
                                                                * iJumlahNenekKakek
                                                                + iJthSaudaraSeibu
                                                                * iJumlahSaudaraSeibu
                                                                + iJthSaudariKandung
                                                                * iJumlahSaudariKandung
                                                                + iJthSaudariSebapak
                                                                * iJumlahSaudariSebapak + iJthPutraPamanKandung
                                                                * iJumlahPutraPamanKandung);
                                                        resultToPrint += "Jatah tiap Putra dari Paman Sekandung (Sisa) : "
                                                                + ConvertToRupiah((iJthPutraPamanKandung))
                                                                + "\n";
                                                        if (iJumlahPutraPamanSebapak > 0)
                                                            resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Putra dari Paman Sekandung)"
                                                                    + "\n";
                                                        if (iJumlahPriaMerdekakan > 0)
                                                            resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Paman Sekandung)"
                                                                    + "\n";
                                                        if (iJumlahWanitaMerdekakan > 0)
                                                            resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Paman Sekandung)"
                                                                    + "\n";
                                                    }
                                                    if (iJumlahPutraPamanKandung == 0) {
                                                        iJthPutraPamanSebapak = Math
                                                                .round(iSisa
                                                                        / iJumlahPutraPamanSebapak);
                                                        if (iJumlahPutraPamanSebapak > 0) {
                                                            iSisa = iHarta
                                                                    - (iJthSuami
                                                                    + iJthIbu
                                                                    + iJthNenekBapak
                                                                    * iJumlahNenekBapak
                                                                    + iJthNenekIbu
                                                                    * iJumlahNenekIbu
                                                                    + iJthNenekKakek
                                                                    * iJumlahNenekKakek
                                                                    + iJthSaudaraSeibu
                                                                    * iJumlahSaudaraSeibu
                                                                    + iJthSaudariKandung
                                                                    * iJumlahSaudariKandung
                                                                    + iJthSaudariSebapak
                                                                    * iJumlahSaudariSebapak + iJthPutraPamanSebapak
                                                                    * iJumlahPutraPamanSebapak);
                                                            resultToPrint += "Jatah tiap Putra dari Paman Sebapak (Sisa) : "
                                                                    + ConvertToRupiah(iJthPutraPamanSebapak)
                                                                    + "\n";
                                                            if (iJumlahPriaMerdekakan > 0)
                                                                resultToPrint += "Jatah Pria yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Paman Sebapak)"
                                                                        + "\n";
                                                            if (iJumlahWanitaMerdekakan > 0)
                                                                resultToPrint += "Jatah Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Paman Sebapak)"
                                                                        + "\n";
                                                        }
                                                        if (iJumlahPutraPamanSebapak == 0) {
                                                            iJthPriaMerdekakan = Math
                                                                    .round(iSisa
                                                                            / (iJumlahPriaMerdekakan + iJumlahWanitaMerdekakan));
                                                            iJthWanitaMerdekakan = iJthPriaMerdekakan;
                                                            if (iJumlahPriaMerdekakan > 0) {
                                                                iSisa = iHarta
                                                                        - (iJthSuami
                                                                        + iJthIbu
                                                                        + iJthNenekBapak
                                                                        * iJumlahNenekBapak
                                                                        + iJthNenekIbu
                                                                        * iJumlahNenekIbu
                                                                        + iJthNenekKakek
                                                                        * iJumlahNenekKakek
                                                                        + iJthSaudaraSeibu
                                                                        * iJumlahSaudaraSeibu
                                                                        + iJthSaudariKandung
                                                                        * iJumlahSaudariKandung
                                                                        + iJthSaudariSebapak
                                                                        * iJumlahSaudariSebapak + iJthPriaMerdekakan
                                                                        * iJumlahPriaMerdekakan);
                                                                resultToPrint += "Jatah Pria yang Memerdekakan Budak (Sisa) : "
                                                                        + ConvertToRupiah((iJthPriaMerdekakan))
                                                                        + "\n";
                                                            }
                                                            if (iJumlahWanitaMerdekakan > 0) {
                                                                iSisa = iHarta
                                                                        - (iJthSuami
                                                                        + iJthIbu
                                                                        + iJthNenekBapak
                                                                        * iJumlahNenekBapak
                                                                        + iJthNenekIbu
                                                                        * iJumlahNenekIbu
                                                                        + iJthNenekKakek
                                                                        * iJumlahNenekKakek
                                                                        + iJthSaudaraSeibu
                                                                        * iJumlahSaudaraSeibu
                                                                        + iJthSaudariKandung
                                                                        * iJumlahSaudariKandung
                                                                        + iJthSaudariSebapak
                                                                        * iJumlahSaudariSebapak + iJthWanitaMerdekakan
                                                                        * iJumlahWanitaMerdekakan);
                                                                resultToPrint += "Jatah Wanita yang Memerdekakan Budak (Sisa) : "
                                                                        + ConvertToRupiah((iJthWanitaMerdekakan))
                                                                        + "\n";
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (iJumlahSaudariSeibu == 1) {
                                    iJthSaudariSeibu = Math.round(iHarta / 6);
                                    resultToPrint += "Jatah tiap Saudari Seibu (1/6) :"
                                            + ConvertToRupiah((iJthSaudariSeibu)) + "\n";
                                }
                                if (iJumlahSaudariSeibu > 1) {
                                    iJthSaudariSeibu = Math.round(iHarta / 3);
                                    resultToPrint += "Jatah tiap Saudari Seibu (1/3) :"
                                            + ConvertToRupiah((iJthSaudariSeibu / iJumlahSaudariSeibu))
                                            + "\n";
                                }
                            }
                        }
                    }
                    // iSisa = iHarta -
                    // (iJthSuami+iJthIbu+iJthBapak+iJthKakek+iJthNenekBapak*iJumlahNenekBapak+iJthNenekIbu*iJumlahNenekIbu+iJthNenekKakek*iJumlahNenekKakek+iJthSaudaraSeibu+iJthSaudaraKandung*iJumlahSaudaraKandung+iJthSaudariKandung*iJumlahSaudariKandung+iJthSaudaraSebapak*iJumlahSaudaraSebapak+iJthSaudariSebapak*iJumlahSaudariSebapak+iJthSaudariSeibu+iJthPutraSaudaraKandung*iJumlahPutraSaudaraKandung+iJthPutraSaudaraSebapak*iJumlahPutraSaudaraSebapak+iJthPamanKandung*iJumlahPamanKandung+iJthPamanSebapak*iJumlahPamanSebapak+iJthPutraPamanKandung*iJumlahPutraPamanKandung+iJthPutraPamanSebapak*iJumlahPutraPamanSebapak+iJthWanitaMerdekakan*iJumlahWanitaMerdekakan+iJthPriaMerdekakan*iJumlahPriaMerdekakan);alert(iSisa);
                }
                if (iJumlahSuami == 0 && iJumlahIstri == 0) {
                    if (iJumlahIbu == 1) {
                        iJthIbu = Math.round(iHarta / 3) * iJumlahIbu;
                    }
                    if (iJumlahIbu == 0) {
                        if (iJumlahNenekBapak == 1 && iJumlahNenekIbu == 0) {
                            iJthNenekBapak = Math.round(iHarta / 6)
                                    * iJumlahNenekBapak;
                        }
                        if (iJumlahNenekBapak == 0 && iJumlahNenekIbu == 1) {
                            iJthNenekIbu = Math.round(iHarta / 6)
                                    * iJumlahNenekIbu;
                        }
                        if (iJumlahNenekBapak == 1 && iJumlahNenekIbu == 1) {
                            iJthNenekBapak = Math.round(iHarta / 12)
                                    * iJumlahNenekBapak;
                            iJthNenekIbu = Math.round(iHarta / 12)
                                    * iJumlahNenekIbu;
                        }
                        if (iJumlahNenekBapak == 0 && iJumlahNenekIbu == 0) {
                            iJthNenekKakek = Math.round(iHarta / 6)
                                    * iJumlahNenekKakek;
                        }
                    }
                    if (iJumlahBapak > 0) {
                        iJthBapak = Math.round(iHarta / 3);
                        iSisa = iHarta
                                - (iJthIbu + iJthBapak + iJthNenekBapak
                                * iJumlahNenekBapak + iJthNenekIbu
                                * iJumlahNenekIbu + iJthNenekKakek
                                * iJumlahNenekKakek);
                        iJthBapak = iJthBapak + iSisa * iJumlahBapak;
                        iSisa = iHarta
                                - (iJthIbu + iJthBapak + iJthNenekBapak
                                * iJumlahNenekBapak + iJthNenekIbu
                                * iJumlahNenekIbu + iJthNenekKakek
                                * iJumlahNenekKakek);
                        if (iJumlahSaudaraSeibu > 0)
                            resultToPrint += "Jatah tiap Saudara Seibu : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahSaudaraKandung > 0)
                            resultToPrint += "Jatah tiap Saudara Kandung : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahSaudariKandung > 0)
                            resultToPrint += "Jatah tiap Saudari Kandung : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahSaudariSeibu > 0)
                            resultToPrint += "Jatah tiap Saudari Seibu : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahSaudaraSebapak > 0)
                            resultToPrint += "Jatah tiap Saudara Sebapak : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahSaudariSebapak > 0)
                            resultToPrint += "Jatah tiap Saudari Sebapak : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahPutraSaudaraKandung > 0)
                            resultToPrint += "Jatah tiap Putra Saudara Kandung : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahPutraSaudaraSebapak > 0)
                            resultToPrint += "Jatah tiap Putra Saudara Sebapak : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahPamanKandung > 0)
                            resultToPrint += "Jatah tiap Paman Kandung : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahPamanSebapak > 0)
                            resultToPrint += "Jatah tiap Paman Sebapak : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahPutraPamanKandung > 0)
                            resultToPrint += "Jatah tiap Putra Paman Kandung : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahPutraPamanSebapak > 0)
                            resultToPrint += "Jatah tiap Putra Paman Sebapak : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahPriaMerdekakan > 0)
                            resultToPrint += "Jatah Pria yang Memerdekakan Budak : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahWanitaMerdekakan > 0)
                            resultToPrint += "Jatah Wanita yang Memerdekakan Budak : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                    }
                    if (iJumlahBapak == 0) {
                        if (iJumlahKakek == 1) {
                            iJthKakek = Math.round(iHarta / 3) * iJumlahKakek;
                            iSisa = iHarta
                                    - (iJthIbu + iJthKakek + iJthNenekBapak
                                    * iJumlahNenekBapak + iJthNenekIbu
                                    * iJumlahNenekIbu + iJthNenekKakek
                                    * iJumlahNenekKakek);
                            iJthKakek = iJthKakek + iSisa * iJumlahKakek;
                            iSisa = iHarta
                                    - (iJthIbu + iJthKakek + iJthNenekBapak
                                    * iJumlahNenekBapak + iJthNenekIbu
                                    * iJumlahNenekIbu + iJthNenekKakek
                                    * iJumlahNenekKakek);
                            if (iJumlahSaudaraSeibu > 0)
                                resultToPrint += "Jatah tiap Saudara Seibu : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahSaudaraKandung > 0)
                                resultToPrint += "Jatah tiap Saudara Kandung : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahSaudariKandung > 0)
                                resultToPrint += "Jatah tiap Saudari Kandung : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahSaudariSeibu > 0)
                                resultToPrint += "Jatah tiap Saudari Seibu : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahSaudaraSebapak > 0)
                                resultToPrint += "Jatah tiap Saudara Sebapak : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahSaudariSebapak > 0)
                                resultToPrint += "Jatah tiap Saudari Sebapak : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahPutraSaudaraKandung > 0)
                                resultToPrint += "Jatah tiap Putra Saudara Kandung : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahPutraSaudaraSebapak > 0)
                                resultToPrint += "Jatah tiap Putra Saudara Sebapak : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahPamanKandung > 0)
                                resultToPrint += "Jatah tiap Paman Kandung : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahPamanSebapak > 0)
                                resultToPrint += "Jatah tiap Paman Sebapak : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahPutraPamanKandung > 0)
                                resultToPrint += "Jatah tiap Putra Paman Kandung : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahPutraPamanSebapak > 0)
                                resultToPrint += "Jatah tiap Putra Paman Sebapak : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahPriaMerdekakan > 0)
                                resultToPrint += "Jatah Pria yang Memerdekakan Budak : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahWanitaMerdekakan > 0)
                                resultToPrint += "Jatah Wanita yang Memerdekakan Budak : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                        }
                        if (iJumlahKakek == 0) {
                            if (iJumlahSaudaraSeibu == 1) {
                                iJthSaudaraSeibu = Math.round(iHarta / 6);
                                iSisa = iHarta
                                        - (iJthIbu + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek + iJthSaudaraSeibu);
                                resultToPrint += "Jatah tiap Saudara Seibu (1/6) : "
                                        + ConvertToRupiah((iJthSaudaraSeibu)) + "\n";
                            }
                            if (iJumlahSaudaraSeibu > 1) {
                                iJthSaudaraSeibu = Math.round(iHarta / 3);
                                iSisa = iHarta
                                        - (iJthIbu + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek + iJthSaudaraSeibu);
                                resultToPrint += "Jatah tiap Saudara Seibu (1/3) : "
                                        + ConvertToRupiah((iJthSaudaraSeibu / iJumlahSaudaraSeibu))
                                        + "\n";
                            }
                            if (iJumlahSaudaraKandung > 0) {
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek + iJthSaudaraSeibu);
                                if (iJumlahSaudariKandung == 0) {
                                    iJthSaudaraKandung = Math.round(iSisa
                                            / iJumlahSaudaraKandung);
                                }
                                if (iJumlahSaudariKandung > 0) {
                                    iJthSaudaraKandung = Math
                                            .round(iSisa
                                                    / (iJumlahSaudaraKandung + iJumlahSaudariKandung));
                                    iJthSaudariKandung = iJthSaudaraKandung;
                                    resultToPrint += "Jatah tiap Saudari Kandung (Sisa) : "
                                            + ConvertToRupiah((iJthSaudariKandung)) + "\n";
                                }
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek
                                        + iJthSaudaraSeibu
                                        + iJthSaudaraKandung
                                        * iJumlahSaudaraKandung + iJthSaudariKandung
                                        * iJumlahSaudariKandung);
                                resultToPrint += "Jatah tiap Saudara Kandung (Sisa) : "
                                        + ConvertToRupiah((iJthSaudaraKandung)) + "\n";
                                if (iJumlahSaudaraSebapak > 0)
                                    resultToPrint += "Jatah tiap Saudara Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahSaudaraSebapak > 0)
                                    resultToPrint += "Jatah tiap Saudara Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahPutraSaudaraKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahPutraSaudaraSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahPriaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahWanitaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahSaudariSebapak > 0)
                                    resultToPrint += "Jatah tiap Saudari Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                            }
                            if (iJumlahSaudaraKandung == 0) {
                                if (iJumlahSaudariKandung > 1) {
                                    iJthSaudariKandung = Math
                                            .round((2 * iHarta / 3)
                                                    / iJumlahSaudariKandung);
                                    iSisa = iHarta
                                            - (iJthSuami + iJthIbu
                                            + iJthNenekBapak
                                            * iJumlahNenekBapak
                                            + iJthNenekIbu
                                            * iJumlahNenekIbu
                                            + iJthNenekKakek
                                            * iJumlahNenekKakek
                                            + iJthSaudaraSeibu + iJthSaudariKandung
                                            * iJumlahSaudariKandung);
                                    resultToPrint += "Jatah tiap Saudari Kandung (2/3) : "
                                            + ConvertToRupiah((iJthSaudariKandung)) + "\n";
                                    if (iJumlahSaudariSebapak > 0
                                            && iJumlahSaudaraSebapak == 0) {
                                        resultToPrint += "Jatah tiap Saudari Sebapak : 0(Karena dihalangi 2 Saudari Kandung atau lebih)"
                                                + "\n";
                                    }
                                }
                                if (iJumlahSaudariKandung == 1
                                        || iJumlahSaudariKandung == 0) {
                                    iJthSaudariKandung = Math.round(iHarta / 2);
                                    if (iJumlahSaudaraSebapak == 0
                                            && iJumlahSaudariSebapak == 1) {
                                        iJthSaudariSebapak = Math
                                                .round(iHarta / 2);
                                        resultToPrint += "Jatah tiap Saudari Sebapak (1/2) : "
                                                + ConvertToRupiah((iJthSaudariSebapak / iJumlahSaudariSebapak))
                                                + "\n";
                                    }
                                    if (iJumlahSaudaraSebapak == 0
                                            && iJumlahSaudariSebapak > 1) {
                                        iJthSaudariSebapak = Math
                                                .round((2 * iHarta / 3)
                                                        / iJumlahSaudariSebapak);
                                        resultToPrint += "Jatah tiap Saudari Sebapak (2/3) : "
                                                + ConvertToRupiah((iJthSaudariSebapak)) + "\n";
                                    }
                                    iSisa = iHarta
                                            - (iJthSuami + iJthIbu
                                            + iJthNenekBapak
                                            * iJumlahNenekBapak
                                            + iJthNenekIbu
                                            * iJumlahNenekIbu
                                            + iJthNenekKakek
                                            * iJumlahNenekKakek
                                            + iJthSaudaraSeibu
                                            + iJthSaudariKandung
                                            * iJumlahSaudariKandung + iJthSaudariSebapak
                                            * iJumlahSaudariSebapak);
                                    if (iJumlahSaudariKandung == 1)
                                        resultToPrint += "Jatah tiap Saudari Kandung (1/2) : "
                                                + ConvertToRupiah((iJthSaudariKandung / iJumlahSaudariKandung))
                                                + "\n";
                                }
                                if (iJumlahSaudaraSebapak > 0) {
                                    iSisa = iHarta
                                            - (iJthIbu + iJthNenekBapak
                                            * iJumlahNenekBapak
                                            + iJthNenekIbu
                                            * iJumlahNenekIbu
                                            + iJthNenekKakek
                                            * iJumlahNenekKakek + iJthSaudaraSeibu);
                                    iJthSaudaraSebapak = Math
                                            .round(iSisa
                                                    / (iJumlahSaudaraSebapak + iJumlahSaudariSebapak));
                                    iJthSaudariSebapak = iJthSaudaraSebapak;
                                    iSisa = iHarta
                                            - (iJthIbu + iJthNenekBapak
                                            * iJumlahNenekBapak
                                            + iJthNenekIbu
                                            * iJumlahNenekIbu
                                            + iJthNenekKakek
                                            * iJumlahNenekKakek
                                            + iJthSaudaraSeibu
                                            + iJthSaudaraSebapak
                                            * iJumlahSaudaraSebapak + iJthSaudariSebapak
                                            * iJumlahSaudariSebapak);
                                    resultToPrint += "Jatah tiap Saudara Sebapak (Sisa) : "
                                            + ConvertToRupiah((iJthSaudaraSebapak)) + "\n";
                                    if (iJumlahSaudariSebapak > 0)
                                        resultToPrint += "Jatah tiap Saudari Sebapak : "
                                                + ConvertToRupiah((iJthSaudariSebapak)) + "\n";
                                    if (iJumlahPutraSaudaraKandung > 0)
                                        resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                    if (iJumlahPutraSaudaraSebapak > 0)
                                        resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                    if (iJumlahPamanKandung > 0)
                                        resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                    if (iJumlahPamanSebapak > 0)
                                        resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                    if (iJumlahPutraPamanKandung > 0)
                                        resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                    if (iJumlahPutraPamanSebapak > 0)
                                        resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                    if (iJumlahPriaMerdekakan > 0)
                                        resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                    if (iJumlahWanitaMerdekakan > 0)
                                        resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                }
                                if (iJumlahSaudaraSebapak == 0) {
                                    iSisa = iHarta
                                            - (iJthIbu + iJthNenekBapak
                                            * iJumlahNenekBapak
                                            + iJthNenekIbu
                                            * iJumlahNenekIbu
                                            + iJthNenekKakek
                                            * iJumlahNenekKakek
                                            + iJthSaudaraSeibu
                                            * iJumlahSaudaraSeibu
                                            + iJthSaudariKandung
                                            * iJumlahSaudariKandung + iJthSaudariSebapak
                                            * iJumlahSaudariSebapak);
                                    if (iJumlahPutraSaudaraKandung > 0) {
                                        iJthPutraSaudaraKandung = Math
                                                .round(iSisa
                                                        / iJumlahPutraSaudaraKandung);
                                        iSisa = iHarta
                                                - (iJthIbu + iJthNenekBapak
                                                * iJumlahNenekBapak
                                                + iJthNenekIbu
                                                * iJumlahNenekIbu
                                                + iJthNenekKakek
                                                * iJumlahNenekKakek
                                                + iJthSaudaraSeibu
                                                * iJumlahSaudaraSeibu
                                                + iJthSaudariKandung
                                                * iJumlahSaudariKandung
                                                + iJthSaudariSebapak
                                                * iJumlahSaudariSebapak + iJthPutraSaudaraKandung
                                                * iJumlahPutraSaudaraKandung);
                                        resultToPrint += "Jatah tiap Putra dari Saudara Sekandung (Sisa) : "
                                                + ConvertToRupiah((iJthPutraSaudaraKandung))
                                                + "\n";
                                        if (iJumlahPutraSaudaraSebapak > 0)
                                            resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Putra dari Saudara Sekandung)"
                                                    + "\n";
                                        if (iJumlahPamanKandung > 0)
                                            resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Putra dari Saudara Sekandung)"
                                                    + "\n";
                                        if (iJumlahPamanSebapak > 0)
                                            resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Putra dari Saudara Sekandung)"
                                                    + "\n";
                                        if (iJumlahPutraPamanKandung > 0)
                                            resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Putra dari Saudara Sekandung)"
                                                    + "\n";
                                        if (iJumlahPutraPamanSebapak > 0)
                                            resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Putra dari Saudara Sekandung)"
                                                    + "\n";
                                        if (iJumlahPriaMerdekakan > 0)
                                            resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Saudara Sekandung)"
                                                    + "\n";
                                        if (iJumlahWanitaMerdekakan > 0)
                                            resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Saudara Sekandung)"
                                                    + "\n";
                                    }
                                    if (iJumlahPutraSaudaraKandung == 0) {
                                        iJthPutraSaudaraSebapak = Math
                                                .round(iSisa
                                                        / iJumlahPutraSaudaraSebapak);
                                        if (iJumlahPutraSaudaraSebapak > 0) {
                                            iSisa = iHarta
                                                    - (iJthIbu
                                                    + iJthNenekBapak
                                                    * iJumlahNenekBapak
                                                    + iJthNenekIbu
                                                    * iJumlahNenekIbu
                                                    + iJthNenekKakek
                                                    * iJumlahNenekKakek
                                                    + iJthSaudaraSeibu
                                                    * iJumlahSaudaraSeibu
                                                    + iJthSaudariKandung
                                                    * iJumlahSaudariKandung
                                                    + iJthSaudariSebapak
                                                    * iJumlahSaudariSebapak + iJthPutraSaudaraSebapak
                                                    * iJumlahPutraSaudaraSebapak);
                                            resultToPrint += "Jatah tiap Putra dari Saudara Sebapak (Sisa) : "
                                                    + ConvertToRupiah((iJthPutraSaudaraSebapak))
                                                    + "\n";
                                            if (iJumlahPamanKandung > 0)
                                                resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Putra dari Saudara Sebapak)"
                                                        + "\n";
                                            if (iJumlahPamanSebapak > 0)
                                                resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Putra dari Saudara Sebapak)"
                                                        + "\n";
                                            if (iJumlahPutraPamanKandung > 0)
                                                resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Putra dari Saudara Sebapak)"
                                                        + "\n";
                                            if (iJumlahPutraPamanSebapak > 0)
                                                resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Putra dari Saudara Sebapak)"
                                                        + "\n";
                                            if (iJumlahPriaMerdekakan > 0)
                                                resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Saudara Sebapak)"
                                                        + "\n";
                                            if (iJumlahWanitaMerdekakan > 0)
                                                resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Saudara Sebapak)"
                                                        + "\n";
                                        }
                                        if (iJumlahPutraSaudaraSebapak == 0) {
                                            iJthPamanKandung = Math.round(iSisa
                                                    / iJumlahPamanKandung);
                                            if (iJumlahPamanKandung > 0) {
                                                iSisa = iHarta
                                                        - (iJthIbu
                                                        + iJthNenekBapak
                                                        * iJumlahNenekBapak
                                                        + iJthNenekIbu
                                                        * iJumlahNenekIbu
                                                        + iJthNenekKakek
                                                        * iJumlahNenekKakek
                                                        + iJthSaudaraSeibu
                                                        * iJumlahSaudaraSeibu
                                                        + iJthSaudariKandung
                                                        * iJumlahSaudariKandung
                                                        + iJthSaudariSebapak
                                                        * iJumlahSaudariSebapak + iJthPamanKandung
                                                        * iJumlahPamanKandung);
                                                resultToPrint += "Jatah tiap Paman Sekandung (Sisa) : "
                                                        + ConvertToRupiah((iJthPamanKandung))
                                                        + "\n";
                                                if (iJumlahPamanSebapak > 0)
                                                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Paman Sekandung)"
                                                            + "\n";
                                                if (iJumlahPutraPamanKandung > 0)
                                                    resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Paman Sekandung)"
                                                            + "\n";
                                                if (iJumlahPutraPamanSebapak > 0)
                                                    resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Paman Sekandung)"
                                                            + "\n";
                                                if (iJumlahPriaMerdekakan > 0)
                                                    resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Paman Sekandung)"
                                                            + "\n";
                                                if (iJumlahWanitaMerdekakan > 0)
                                                    resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Paman Sekandung)"
                                                            + "\n";
                                            }
                                            if (iJumlahPamanKandung == 0) {
                                                iJthPamanSebapak = Math
                                                        .round(iSisa
                                                                / iJumlahPamanSebapak);
                                                if (iJumlahPamanSebapak > 0) {
                                                    iSisa = iHarta
                                                            - (iJthIbu
                                                            + iJthNenekBapak
                                                            * iJumlahNenekBapak
                                                            + iJthNenekIbu
                                                            * iJumlahNenekIbu
                                                            + iJthNenekKakek
                                                            * iJumlahNenekKakek
                                                            + iJthSaudaraSeibu
                                                            * iJumlahSaudaraSeibu
                                                            + iJthSaudariKandung
                                                            * iJumlahSaudariKandung
                                                            + iJthSaudariSebapak
                                                            * iJumlahSaudariSebapak + iJthPamanSebapak
                                                            * iJumlahPamanSebapak);
                                                    resultToPrint += "Jatah tiap Paman Sebapak (Sisa) : "
                                                            + ConvertToRupiah((iJthPamanSebapak))
                                                            + "\n";
                                                    if (iJumlahPutraPamanKandung > 0)
                                                        resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Paman Sebapak)"
                                                                + "\n";
                                                    if (iJumlahPutraPamanSebapak > 0)
                                                        resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Paman Sebapak)"
                                                                + "\n";
                                                    if (iJumlahPriaMerdekakan > 0)
                                                        resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Paman Sebapak)"
                                                                + "\n";
                                                    if (iJumlahWanitaMerdekakan > 0)
                                                        resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Paman Sebapak)"
                                                                + "\n";
                                                }
                                                if (iJumlahPamanSebapak == 0) {
                                                    iJthPutraPamanKandung = Math
                                                            .round(iSisa
                                                                    / iJumlahPutraPamanKandung);
                                                    if (iJumlahPutraPamanKandung > 0) {
                                                        iSisa = iHarta
                                                                - (iJthIbu
                                                                + iJthNenekBapak
                                                                * iJumlahNenekBapak
                                                                + iJthNenekIbu
                                                                * iJumlahNenekIbu
                                                                + iJthNenekKakek
                                                                * iJumlahNenekKakek
                                                                + iJthSaudaraSeibu
                                                                * iJumlahSaudaraSeibu
                                                                + iJthSaudariKandung
                                                                * iJumlahSaudariKandung
                                                                + iJthSaudariSebapak
                                                                * iJumlahSaudariSebapak + iJthPutraPamanKandung
                                                                * iJumlahPutraPamanKandung);
                                                        resultToPrint += "Jatah tiap Putra dari Paman Sekandung (Sisa) : "
                                                                + ConvertToRupiah((iJthPutraPamanKandung))
                                                                + "\n";
                                                        if (iJumlahPutraPamanSebapak > 0)
                                                            resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Putra dari Paman Sekandung)"
                                                                    + "\n";
                                                        if (iJumlahPriaMerdekakan > 0)
                                                            resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Paman Sekandung)"
                                                                    + "\n";
                                                        if (iJumlahWanitaMerdekakan > 0)
                                                            resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Paman Sekandung)"
                                                                    + "\n";
                                                    }
                                                    if (iJumlahPutraPamanKandung == 0) {
                                                        iJthPutraPamanSebapak = Math
                                                                .round(iSisa
                                                                        / iJumlahPutraPamanSebapak);
                                                        if (iJumlahPutraPamanSebapak > 0) {
                                                            iSisa = iHarta
                                                                    - (iJthIbu
                                                                    + iJthNenekBapak
                                                                    * iJumlahNenekBapak
                                                                    + iJthNenekIbu
                                                                    * iJumlahNenekIbu
                                                                    + iJthNenekKakek
                                                                    * iJumlahNenekKakek
                                                                    + iJthSaudaraSeibu
                                                                    * iJumlahSaudaraSeibu
                                                                    + iJthSaudariKandung
                                                                    * iJumlahSaudariKandung
                                                                    + iJthSaudariSebapak
                                                                    * iJumlahSaudariSebapak + iJthPutraPamanSebapak
                                                                    * iJumlahPutraPamanSebapak);
                                                            resultToPrint += "Jatah tiap Putra dari Paman Sebapak (Sisa) : "
                                                                    + ConvertToRupiah((iJthPutraPamanSebapak))
                                                                    + "\n";
                                                            if (iJumlahPriaMerdekakan > 0)
                                                                resultToPrint += "Jatah Pria yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Paman Sebapak)"
                                                                        + "\n";
                                                            if (iJumlahWanitaMerdekakan > 0)
                                                                resultToPrint += "Jatah Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Paman Sebapak)"
                                                                        + "\n";
                                                        }
                                                        if (iJumlahPutraPamanSebapak == 0) {
                                                            iJthPriaMerdekakan = Math
                                                                    .round(iSisa
                                                                            / (iJumlahPriaMerdekakan + iJumlahWanitaMerdekakan));
                                                            iJthWanitaMerdekakan = iJthPriaMerdekakan;
                                                            if (iJumlahPriaMerdekakan > 0) {
                                                                iSisa = iHarta
                                                                        - (iJthIbu
                                                                        + iJthNenekBapak
                                                                        * iJumlahNenekBapak
                                                                        + iJthNenekIbu
                                                                        * iJumlahNenekIbu
                                                                        + iJthNenekKakek
                                                                        * iJumlahNenekKakek
                                                                        + iJthSaudaraSeibu
                                                                        * iJumlahSaudaraSeibu
                                                                        + iJthSaudariKandung
                                                                        * iJumlahSaudariKandung
                                                                        + iJthSaudariSebapak
                                                                        * iJumlahSaudariSebapak + iJthPriaMerdekakan
                                                                        * iJumlahPriaMerdekakan);
                                                                resultToPrint += "Jatah Pria yang Memerdekakan Budak (Sisa) : "
                                                                        + ConvertToRupiah((iJthPriaMerdekakan))
                                                                        + "\n";
                                                            }
                                                            if (iJumlahWanitaMerdekakan > 0) {
                                                                iSisa = iHarta
                                                                        - (iJthIbu
                                                                        + iJthNenekBapak
                                                                        * iJumlahNenekBapak
                                                                        + iJthNenekIbu
                                                                        * iJumlahNenekIbu
                                                                        + iJthNenekKakek
                                                                        * iJumlahNenekKakek
                                                                        + iJthSaudaraSeibu
                                                                        * iJumlahSaudaraSeibu
                                                                        + iJthSaudariKandung
                                                                        * iJumlahSaudariKandung
                                                                        + iJthSaudariSebapak
                                                                        * iJumlahSaudariSebapak + iJthWanitaMerdekakan
                                                                        * iJumlahWanitaMerdekakan);
                                                                resultToPrint += "Jatah Wanita yang Memerdekakan Budak (Sisa) : "
                                                                        + ConvertToRupiah((iJthWanitaMerdekakan))
                                                                        + "\n";
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (iJumlahSaudariSeibu == 1) {
                                    iJthSaudariSeibu = Math.round(iHarta / 6);
                                    resultToPrint += "Jatah tiap Saudari Seibu (1/6) :"
                                            + ConvertToRupiah((iJthSaudariSeibu)) + "\n";
                                }
                                if (iJumlahSaudariSeibu > 1) {
                                    iJthSaudariSeibu = Math.round(iHarta / 3);
                                    resultToPrint += "Jatah tiap Saudari Seibu (1/3) :"
                                            + ConvertToRupiah((iJthSaudariSeibu / iJumlahSaudariSeibu))
                                            + "\n";
                                }
                            }
                        }
                    }
                    // iSisa = iHarta -
                    // (iJthSuami+iJthIbu+iJthBapak+iJthKakek+iJthNenekBapak*iJumlahNenekBapak+iJthNenekIbu*iJumlahNenekIbu+iJthNenekKakek*iJumlahNenekKakek+iJthSaudaraSeibu+iJthSaudaraKandung*iJumlahSaudaraKandung+iJthSaudariKandung*iJumlahSaudariKandung+iJthSaudaraSebapak*iJumlahSaudaraSebapak+iJthSaudariSebapak+iJthSaudariSeibu);
                }
                if (iJumlahIstri > 0) {
                    iJthIstri = Math.round((iHarta / 4) / iJumlahIstri);
                    if (iJumlahIbu == 1) {
                        iJthIbu = Math.round(iHarta / 4) * iJumlahIbu;
                    }
                    if (iJumlahIbu == 0) {
                        if (iJumlahNenekBapak == 1 && iJumlahNenekIbu == 0) {
                            iJthNenekBapak = Math.round(iHarta / 6)
                                    * iJumlahNenekBapak;
                        }
                        if (iJumlahNenekBapak == 0 && iJumlahNenekIbu == 1) {
                            iJthNenekIbu = Math.round(iHarta / 6)
                                    * iJumlahNenekIbu;
                        }
                        if (iJumlahNenekBapak == 1 && iJumlahNenekIbu == 1) {
                            iJthNenekBapak = Math.round(iHarta / 12)
                                    * iJumlahNenekBapak;
                            iJthNenekIbu = Math.round(iHarta / 12)
                                    * iJumlahNenekIbu;
                        }
                        if (iJumlahNenekBapak == 0 && iJumlahNenekIbu == 0) {
                            iJthNenekKakek = Math.round(iHarta / 6)
                                    * iJumlahNenekKakek;
                        }
                    }
                    if (iJumlahBapak > 0) {
                        iJthBapak = Math.round(iHarta / 2);
                        iSisa = iHarta
                                - (iJthIstri * iJumlahIstri + iJthIbu
                                + iJthBapak + iJthNenekBapak
                                * iJumlahNenekBapak + iJthNenekIbu
                                * iJumlahNenekIbu + iJthNenekKakek
                                * iJumlahNenekKakek);
                        iJthBapak = iJthBapak + iSisa * iJumlahBapak;
                        iSisa = iHarta
                                - (iJthIstri * iJumlahIstri + iJthIbu
                                + iJthBapak + iJthNenekBapak
                                * iJumlahNenekBapak + iJthNenekIbu
                                * iJumlahNenekIbu + iJthNenekKakek
                                * iJumlahNenekKakek);
                        if (iJumlahSaudaraSeibu > 0)
                            resultToPrint += "Jatah tiap Saudara Seibu : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahSaudaraKandung > 0)
                            resultToPrint += "Jatah tiap Saudara Kandung : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahSaudariKandung > 0)
                            resultToPrint += "Jatah tiap Saudari Kandung : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahSaudariSeibu > 0)
                            resultToPrint += "Jatah tiap Saudari Seibu : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahSaudaraSebapak > 0)
                            resultToPrint += "Jatah tiap Saudara Sebapak : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahSaudariSebapak > 0)
                            resultToPrint += "Jatah tiap Saudari Sebapak : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahPutraSaudaraKandung > 0)
                            resultToPrint += "Jatah tiap Putra Saudara Kandung : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahPutraSaudaraSebapak > 0)
                            resultToPrint += "Jatah tiap Putra Saudara Sebapak : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahPamanKandung > 0)
                            resultToPrint += "Jatah tiap Paman Kandung : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahPamanSebapak > 0)
                            resultToPrint += "Jatah tiap Paman Sebapak : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahPutraPamanKandung > 0)
                            resultToPrint += "Jatah tiap Putra Paman Kandung : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahPutraPamanSebapak > 0)
                            resultToPrint += "Jatah tiap Putra Paman Sebapak : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahPriaMerdekakan > 0)
                            resultToPrint += "Jatah Pria yang Memerdekakan Budak : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                        if (iJumlahWanitaMerdekakan > 0)
                            resultToPrint += "Jatah Wanita yang Memerdekakan Budak : 0 (karena dihalangi oleh Bapak)"
                                    + "\n";
                    }
                    if (iJumlahBapak == 0) {
                        if (iJumlahKakek == 1) {
                            iJthKakek = Math.round(iHarta / 2) * iJumlahKakek;
                            iSisa = iHarta
                                    - (iJthIstri * iJumlahIstri + iJthIbu
                                    + iJthKakek + iJthNenekBapak
                                    * iJumlahNenekBapak + iJthNenekIbu
                                    * iJumlahNenekIbu + iJthNenekKakek
                                    * iJumlahNenekKakek);
                            iJthKakek = iJthKakek + iSisa * iJumlahKakek;
                            iSisa = iHarta
                                    - (iJthIstri * iJumlahIstri + iJthIbu
                                    + iJthKakek + iJthNenekBapak
                                    * iJumlahNenekBapak + iJthNenekIbu
                                    * iJumlahNenekIbu + iJthNenekKakek
                                    * iJumlahNenekKakek);
                            if (iJumlahSaudaraSeibu > 0)
                                resultToPrint += "Jatah tiap Saudara Seibu : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahSaudaraKandung > 0)
                                resultToPrint += "Jatah tiap Saudara Kandung : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahSaudariKandung > 0)
                                resultToPrint += "Jatah tiap Saudari Kandung : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahSaudariSeibu > 0)
                                resultToPrint += "Jatah tiap Saudari Seibu : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahSaudaraSebapak > 0)
                                resultToPrint += "Jatah tiap Saudara Sebapak : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahSaudariSebapak > 0)
                                resultToPrint += "Jatah tiap Saudari Sebapak : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahPutraSaudaraKandung > 0)
                                resultToPrint += "Jatah tiap Putra Saudara Kandung : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahPutraSaudaraSebapak > 0)
                                resultToPrint += "Jatah tiap Putra Saudara Sebapak : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahPamanKandung > 0)
                                resultToPrint += "Jatah tiap Paman Kandung : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahPamanSebapak > 0)
                                resultToPrint += "Jatah tiap Paman Sebapak : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahPutraPamanKandung > 0)
                                resultToPrint += "Jatah tiap Putra Paman Kandung : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahPutraPamanSebapak > 0)
                                resultToPrint += "Jatah tiap Putra Paman Sebapak : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahPriaMerdekakan > 0)
                                resultToPrint += "Jatah Pria yang Memerdekakan Budak : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                            if (iJumlahWanitaMerdekakan > 0)
                                resultToPrint += "Jatah Wanita yang Memerdekakan Budak : 0 (karena dihalangi oleh Kakek)"
                                        + "\n";
                        }
                        if (iJumlahKakek == 0) {
                            if (iJumlahSaudaraSeibu == 1) {
                                iJthSaudaraSeibu = Math.round(iHarta / 6);
                                iSisa = iHarta
                                        - (iJthIstri * iJumlahIstri + iJthIbu
                                        + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek + iJthSaudaraSeibu);
                                resultToPrint += "Jatah tiap Saudara Seibu (1/6) : "
                                        + ConvertToRupiah((iJthSaudaraSeibu)) + "\n";
                            }
                            if (iJumlahSaudaraSeibu > 1) {
                                iJthSaudaraSeibu = Math.round(iHarta / 3);
                                iSisa = iHarta
                                        - (iJthIstri * iJumlahIstri + iJthIbu
                                        + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek + iJthSaudaraSeibu);
                                resultToPrint += "Jatah tiap Saudara Seibu (1/3) : "
                                        + ConvertToRupiah((iJthSaudaraSeibu / iJumlahSaudaraSeibu))
                                        + "\n";
                            }
                            if (iJumlahSaudaraKandung > 0) {
                                iSisa = iHarta
                                        - (iJthIstri * iJumlahIstri + iJthIbu
                                        + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek + iJthSaudaraSeibu);
                                if (iJumlahSaudariKandung == 0) {
                                    iJthSaudaraKandung = Math.round(iSisa
                                            / iJumlahSaudaraKandung);
                                }
                                if (iJumlahSaudariKandung > 0) {
                                    iJthSaudaraKandung = Math
                                            .round(iSisa
                                                    / (iJumlahSaudaraKandung + iJumlahSaudariKandung));
                                    iJthSaudariKandung = iJthSaudaraKandung;
                                    resultToPrint += "Jatah tiap Saudari Kandung (Sisa) : "
                                            + ConvertToRupiah((iJthSaudariKandung)) + "\n";
                                }
                                iSisa = iHarta
                                        - (iJthIstri * iJumlahIstri + iJthIbu
                                        + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek
                                        + iJthSaudaraSeibu
                                        + iJthSaudaraKandung
                                        * iJumlahSaudaraKandung + iJthSaudariKandung
                                        * iJumlahSaudariKandung);
                                resultToPrint += "Jatah tiap Saudara Kandung : "
                                        + ConvertToRupiah((iJthSaudaraKandung)) + "\n";
                                if (iJumlahSaudaraSebapak > 0)
                                    resultToPrint += "Jatah tiap Saudara Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahSaudaraSebapak > 0)
                                    resultToPrint += "Jatah tiap Saudara Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahPutraSaudaraKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahPutraSaudaraSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahPriaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahWanitaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                                if (iJumlahSaudariSebapak > 0)
                                    resultToPrint += "Jatah tiap Saudari Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                            + "\n";
                            }
                            if (iJumlahSaudaraKandung == 0) {
                                if (iJumlahSaudariKandung > 1) {
                                    iJthSaudariKandung = Math
                                            .round((2 * iHarta / 3)
                                                    / iJumlahSaudariKandung);
                                    iSisa = iHarta
                                            - (iJthIstri * iJumlahIstri
                                            + iJthIbu + iJthNenekBapak
                                            * iJumlahNenekBapak
                                            + iJthNenekIbu
                                            * iJumlahNenekIbu
                                            + iJthNenekKakek
                                            * iJumlahNenekKakek
                                            + iJthSaudaraSeibu + iJthSaudariKandung
                                            * iJumlahSaudariKandung);
                                    resultToPrint += "Jatah tiap Saudari Kandung (2/3) : "
                                            + ConvertToRupiah((iJthSaudariKandung)) + "\n";
                                    if (iJumlahSaudariSebapak > 0
                                            && iJumlahSaudaraSebapak == 0) {
                                        resultToPrint += "Jatah tiap Saudari Sebapak : 0(Karena dihalangi 2 Saudari Kandung atau lebih)"
                                                + "\n";
                                    }
                                }
                                if (iJumlahSaudariKandung == 1
                                        || iJumlahSaudariKandung == 0) {
                                    iJthSaudariKandung = Math.round(iHarta / 2);
                                    if (iJumlahSaudaraSebapak == 0
                                            && iJumlahSaudariSebapak == 1) {
                                        iJthSaudariSebapak = Math
                                                .round(iHarta / 2);
                                        resultToPrint += "Jatah tiap Saudari Sebapak (1/2) : "
                                                + ConvertToRupiah((iJthSaudariSebapak / iJumlahSaudariSebapak))
                                                + "\n";
                                    }
                                    if (iJumlahSaudaraSebapak == 0
                                            && iJumlahSaudariSebapak > 1) {
                                        iJthSaudariSebapak = Math
                                                .round((2 * iHarta / 3)
                                                        / iJumlahSaudariSebapak);
                                        resultToPrint += "Jatah tiap Saudari Sebapak (2/3) : "
                                                + ConvertToRupiah((iJthSaudariSebapak)) + "\n";
                                    }
                                    iSisa = iHarta
                                            - (iJthIstri * iJumlahIstri
                                            + iJthIbu + iJthNenekBapak
                                            * iJumlahNenekBapak
                                            + iJthNenekIbu
                                            * iJumlahNenekIbu
                                            + iJthNenekKakek
                                            * iJumlahNenekKakek
                                            + iJthSaudaraSeibu
                                            + iJthSaudariKandung
                                            * iJumlahSaudariKandung + iJthSaudariSebapak
                                            * iJumlahSaudariSebapak);
                                    if (iJumlahSaudariKandung == 1)
                                        resultToPrint += "Jatah tiap Saudari Kandung (1/2) : "
                                                + ConvertToRupiah((iJthSaudariKandung / iJumlahSaudariKandung))
                                                + "\n";
                                }
                                if (iJumlahSaudaraSebapak > 0) {
                                    iSisa = iHarta
                                            - (iJthIstri * iJumlahIstri
                                            + iJthIbu + iJthNenekBapak
                                            * iJumlahNenekBapak
                                            + iJthNenekIbu
                                            * iJumlahNenekIbu
                                            + iJthNenekKakek
                                            * iJumlahNenekKakek + iJthSaudaraSeibu);
                                    iJthSaudaraSebapak = Math
                                            .round(iSisa
                                                    / (iJumlahSaudaraSebapak + iJumlahSaudariSebapak));
                                    iJthSaudariSebapak = iJthSaudaraSebapak;
                                    iSisa = iHarta
                                            - (iJthIstri * iJumlahIstri
                                            + iJthIbu + iJthNenekBapak
                                            * iJumlahNenekBapak
                                            + iJthNenekIbu
                                            * iJumlahNenekIbu
                                            + iJthNenekKakek
                                            * iJumlahNenekKakek
                                            + iJthSaudaraSeibu
                                            + iJthSaudaraSebapak
                                            * iJumlahSaudaraSebapak + iJthSaudariSebapak
                                            * iJumlahSaudariSebapak);
                                    resultToPrint += "Jatah tiap Saudara Sebapak (Sisa) : "
                                            + ConvertToRupiah((iJthSaudaraSebapak)) + "\n";
                                    if (iJumlahSaudariSebapak > 0)
                                        resultToPrint += "Jatah tiap Saudari Sebapak (Sisa) : "
                                                + ConvertToRupiah((iJthSaudariSebapak)) + "\n";
                                    if (iJumlahPutraSaudaraKandung > 0)
                                        resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                    if (iJumlahPutraSaudaraSebapak > 0)
                                        resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                    if (iJumlahPamanKandung > 0)
                                        resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                    if (iJumlahPamanSebapak > 0)
                                        resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                    if (iJumlahPutraPamanKandung > 0)
                                        resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                    if (iJumlahPutraPamanSebapak > 0)
                                        resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                    if (iJumlahPriaMerdekakan > 0)
                                        resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                    if (iJumlahWanitaMerdekakan > 0)
                                        resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sebapak)"
                                                + "\n";
                                }
                                if (iJumlahSaudaraSebapak == 0) {
                                    iSisa = iHarta
                                            - (iJthIstri * iJumlahIstri
                                            + iJthIbu + iJthNenekBapak
                                            * iJumlahNenekBapak
                                            + iJthNenekIbu
                                            * iJumlahNenekIbu
                                            + iJthNenekKakek
                                            * iJumlahNenekKakek
                                            + iJthSaudaraSeibu
                                            * iJumlahSaudaraSeibu
                                            + iJthSaudariKandung
                                            * iJumlahSaudariKandung + iJthSaudariSebapak
                                            * iJumlahSaudariSebapak);
                                    if (iJumlahPutraSaudaraKandung > 0) {
                                        iJthPutraSaudaraKandung = Math
                                                .round(iSisa
                                                        / iJumlahPutraSaudaraKandung);
                                        iSisa = iHarta
                                                - (iJthIstri * iJumlahIstri
                                                + iJthIbu
                                                + iJthNenekBapak
                                                * iJumlahNenekBapak
                                                + iJthNenekIbu
                                                * iJumlahNenekIbu
                                                + iJthNenekKakek
                                                * iJumlahNenekKakek
                                                + iJthSaudaraSeibu
                                                * iJumlahSaudaraSeibu
                                                + iJthSaudariKandung
                                                * iJumlahSaudariKandung
                                                + iJthSaudariSebapak
                                                * iJumlahSaudariSebapak + iJthPutraSaudaraKandung
                                                * iJumlahPutraSaudaraKandung);
                                        resultToPrint += "Jatah tiap Putra dari Saudara Sekandung (Sisa) : "
                                                + ConvertToRupiah((iJthPutraSaudaraKandung))
                                                + "\n";
                                        if (iJumlahPutraSaudaraSebapak > 0)
                                            resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Putra dari Saudara Sekandung)"
                                                    + "\n";
                                        if (iJumlahPamanKandung > 0)
                                            resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Putra dari Saudara Sekandung)"
                                                    + "\n";
                                        if (iJumlahPamanSebapak > 0)
                                            resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Putra dari Saudara Sekandung)"
                                                    + "\n";
                                        if (iJumlahPutraPamanKandung > 0)
                                            resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Putra dari Saudara Sekandung)"
                                                    + "\n";
                                        if (iJumlahPutraPamanSebapak > 0)
                                            resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Putra dari Saudara Sekandung)"
                                                    + "\n";
                                        if (iJumlahPriaMerdekakan > 0)
                                            resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Saudara Sekandung)"
                                                    + "\n";
                                        if (iJumlahWanitaMerdekakan > 0)
                                            resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Saudara Sekandung)"
                                                    + "\n";
                                    }
                                    if (iJumlahPutraSaudaraKandung == 0) {
                                        iJthPutraSaudaraSebapak = Math
                                                .round(iSisa
                                                        / iJumlahPutraSaudaraSebapak);
                                        if (iJumlahPutraSaudaraSebapak > 0) {
                                            iSisa = iHarta
                                                    - (iJthIstri
                                                    * iJumlahIstri
                                                    + iJthIbu
                                                    + iJthNenekBapak
                                                    * iJumlahNenekBapak
                                                    + iJthNenekIbu
                                                    * iJumlahNenekIbu
                                                    + iJthNenekKakek
                                                    * iJumlahNenekKakek
                                                    + iJthSaudaraSeibu
                                                    * iJumlahSaudaraSeibu
                                                    + iJthSaudariKandung
                                                    * iJumlahSaudariKandung
                                                    + iJthSaudariSebapak
                                                    * iJumlahSaudariSebapak + iJthPutraSaudaraSebapak
                                                    * iJumlahPutraSaudaraSebapak);
                                            resultToPrint += "Jatah tiap Putra dari Saudara Sebapak (Sisa) : "
                                                    + ConvertToRupiah((iJthPutraSaudaraSebapak))
                                                    + "\n";
                                            if (iJumlahPamanKandung > 0)
                                                resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Putra dari Saudara Sebapak)"
                                                        + "\n";
                                            if (iJumlahPamanSebapak > 0)
                                                resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Putra dari Saudara Sebapak)"
                                                        + "\n";
                                            if (iJumlahPutraPamanKandung > 0)
                                                resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Putra dari Saudara Sebapak)"
                                                        + "\n";
                                            if (iJumlahPutraPamanSebapak > 0)
                                                resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Putra dari Saudara Sebapak)"
                                                        + "\n";
                                            if (iJumlahPriaMerdekakan > 0)
                                                resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Saudara Sebapak)"
                                                        + "\n";
                                            if (iJumlahWanitaMerdekakan > 0)
                                                resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Saudara Sebapak)"
                                                        + "\n";
                                        }
                                        if (iJumlahPutraSaudaraSebapak == 0) {
                                            iJthPamanKandung = Math.round(iSisa
                                                    / iJumlahPamanKandung);
                                            if (iJumlahPamanKandung > 0) {
                                                iSisa = iHarta
                                                        - (iJthIstri
                                                        * iJumlahIstri
                                                        + iJthIbu
                                                        + iJthNenekBapak
                                                        * iJumlahNenekBapak
                                                        + iJthNenekIbu
                                                        * iJumlahNenekIbu
                                                        + iJthNenekKakek
                                                        * iJumlahNenekKakek
                                                        + iJthSaudaraSeibu
                                                        * iJumlahSaudaraSeibu
                                                        + iJthSaudariKandung
                                                        * iJumlahSaudariKandung
                                                        + iJthSaudariSebapak
                                                        * iJumlahSaudariSebapak + iJthPamanKandung
                                                        * iJumlahPamanKandung);
                                                resultToPrint += "Jatah tiap Paman Sekandung (Sisa) : "
                                                        + ConvertToRupiah((iJthPamanKandung))
                                                        + "\n";
                                                if (iJumlahPamanSebapak > 0)
                                                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Paman Sekandung)"
                                                            + "\n";
                                                if (iJumlahPutraPamanKandung > 0)
                                                    resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Paman Sekandung)"
                                                            + "\n";
                                                if (iJumlahPutraPamanSebapak > 0)
                                                    resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Paman Sekandung)"
                                                            + "\n";
                                                if (iJumlahPriaMerdekakan > 0)
                                                    resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Paman Sekandung)"
                                                            + "\n";
                                                if (iJumlahWanitaMerdekakan > 0)
                                                    resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Paman Sekandung)"
                                                            + "\n";
                                            }
                                            if (iJumlahPamanKandung == 0) {
                                                iJthPamanSebapak = Math
                                                        .round(iSisa
                                                                / iJumlahPamanSebapak);
                                                if (iJumlahPamanSebapak > 0) {
                                                    iSisa = iHarta
                                                            - (iJthIstri
                                                            * iJumlahIstri
                                                            + iJthIbu
                                                            + iJthNenekBapak
                                                            * iJumlahNenekBapak
                                                            + iJthNenekIbu
                                                            * iJumlahNenekIbu
                                                            + iJthNenekKakek
                                                            * iJumlahNenekKakek
                                                            + iJthSaudaraSeibu
                                                            * iJumlahSaudaraSeibu
                                                            + iJthSaudariKandung
                                                            * iJumlahSaudariKandung
                                                            + iJthSaudariSebapak
                                                            * iJumlahSaudariSebapak + iJthPamanSebapak
                                                            * iJumlahPamanSebapak);
                                                    resultToPrint += "Jatah tiap Paman Sebapak (Sisa) : "
                                                            + ConvertToRupiah((iJthPamanSebapak))
                                                            + "\n";
                                                    if (iJumlahPutraPamanKandung > 0)
                                                        resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Paman Sebapak)"
                                                                + "\n";
                                                    if (iJumlahPutraPamanSebapak > 0)
                                                        resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Paman Sebapak)"
                                                                + "\n";
                                                    if (iJumlahPriaMerdekakan > 0)
                                                        resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Paman Sebapak)"
                                                                + "\n";
                                                    if (iJumlahWanitaMerdekakan > 0)
                                                        resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Paman Sebapak)"
                                                                + "\n";
                                                }
                                                if (iJumlahPamanSebapak == 0) {
                                                    iJthPutraPamanKandung = Math
                                                            .round(iSisa
                                                                    / iJumlahPutraPamanKandung);
                                                    if (iJumlahPutraPamanKandung > 0) {
                                                        iSisa = iHarta
                                                                - (iJthIstri
                                                                * iJumlahIstri
                                                                + iJthIbu
                                                                + iJthNenekBapak
                                                                * iJumlahNenekBapak
                                                                + iJthNenekIbu
                                                                * iJumlahNenekIbu
                                                                + iJthNenekKakek
                                                                * iJumlahNenekKakek
                                                                + iJthSaudaraSeibu
                                                                * iJumlahSaudaraSeibu
                                                                + iJthSaudariKandung
                                                                * iJumlahSaudariKandung
                                                                + iJthSaudariSebapak
                                                                * iJumlahSaudariSebapak + iJthPutraPamanKandung
                                                                * iJumlahPutraPamanKandung);
                                                        resultToPrint += "Jatah tiap Putra dari Paman Sekandung (Sisa) : "
                                                                + ConvertToRupiah((iJthPutraPamanKandung))
                                                                + "\n";
                                                        if (iJumlahPutraPamanSebapak > 0)
                                                            resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Putra dari Paman Sekandung)"
                                                                    + "\n";
                                                        if (iJumlahPriaMerdekakan > 0)
                                                            resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Paman Sekandung)"
                                                                    + "\n";
                                                        if (iJumlahWanitaMerdekakan > 0)
                                                            resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Paman Sekandung)"
                                                                    + "\n";
                                                    }
                                                    if (iJumlahPutraPamanKandung == 0) {
                                                        iJthPutraPamanSebapak = Math
                                                                .round(iSisa
                                                                        / iJumlahPutraPamanSebapak);
                                                        if (iJumlahPutraPamanSebapak > 0) {
                                                            iSisa = iHarta
                                                                    - (iJthIstri
                                                                    * iJumlahIstri
                                                                    + iJthIbu
                                                                    + iJthNenekBapak
                                                                    * iJumlahNenekBapak
                                                                    + iJthNenekIbu
                                                                    * iJumlahNenekIbu
                                                                    + iJthNenekKakek
                                                                    * iJumlahNenekKakek
                                                                    + iJthSaudaraSeibu
                                                                    * iJumlahSaudaraSeibu
                                                                    + iJthSaudariKandung
                                                                    * iJumlahSaudariKandung
                                                                    + iJthSaudariSebapak
                                                                    * iJumlahSaudariSebapak + iJthPutraPamanSebapak
                                                                    * iJumlahPutraPamanSebapak);
                                                            resultToPrint += "Jatah tiap Putra dari Paman Sebapak (Sisa) : "
                                                                    + ConvertToRupiah((iJthPutraPamanSebapak))
                                                                    + "\n";
                                                            if (iJumlahPriaMerdekakan > 0)
                                                                resultToPrint += "Jatah Pria yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Paman Sebapak)"
                                                                        + "\n";
                                                            if (iJumlahWanitaMerdekakan > 0)
                                                                resultToPrint += "Jatah Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Putra dari Paman Sebapak)"
                                                                        + "\n";
                                                        }
                                                        if (iJumlahPutraPamanSebapak == 0) {
                                                            iJthPriaMerdekakan = Math
                                                                    .round(iSisa
                                                                            / (iJumlahPriaMerdekakan + iJumlahWanitaMerdekakan));
                                                            iJthWanitaMerdekakan = iJthPriaMerdekakan;
                                                            if (iJumlahPriaMerdekakan > 0) {
                                                                iSisa = iHarta
                                                                        - (iJthIstri
                                                                        * iJumlahIstri
                                                                        + iJthIbu
                                                                        + iJthNenekBapak
                                                                        * iJumlahNenekBapak
                                                                        + iJthNenekIbu
                                                                        * iJumlahNenekIbu
                                                                        + iJthNenekKakek
                                                                        * iJumlahNenekKakek
                                                                        + iJthSaudaraSeibu
                                                                        * iJumlahSaudaraSeibu
                                                                        + iJthSaudariKandung
                                                                        * iJumlahSaudariKandung
                                                                        + iJthSaudariSebapak
                                                                        * iJumlahSaudariSebapak + iJthPriaMerdekakan
                                                                        * iJumlahPriaMerdekakan);
                                                                resultToPrint += "Jatah Pria yang Memerdekakan Budak (Sisa) : "
                                                                        + ConvertToRupiah((iJthPriaMerdekakan))
                                                                        + "\n";
                                                            }
                                                            if (iJumlahWanitaMerdekakan > 0) {
                                                                iSisa = iHarta
                                                                        - (iJthIstri
                                                                        * iJumlahIstri
                                                                        + iJthIbu
                                                                        + iJthNenekBapak
                                                                        * iJumlahNenekBapak
                                                                        + iJthNenekIbu
                                                                        * iJumlahNenekIbu
                                                                        + iJthNenekKakek
                                                                        * iJumlahNenekKakek
                                                                        + iJthSaudaraSeibu
                                                                        * iJumlahSaudaraSeibu
                                                                        + iJthSaudariKandung
                                                                        * iJumlahSaudariKandung
                                                                        + iJthSaudariSebapak
                                                                        * iJumlahSaudariSebapak + iJthWanitaMerdekakan
                                                                        * iJumlahWanitaMerdekakan);
                                                                resultToPrint += "Jatah Wanita yang Memerdekakan Budak (Sisa) : "
                                                                        + ConvertToRupiah((iJthWanitaMerdekakan))
                                                                        + "\n";
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (iJumlahSaudariSeibu == 1) {
                                    iJthSaudariSeibu = Math.round(iHarta / 6);
                                    resultToPrint += "Jatah tiap Saudari Seibu (1/6) :"
                                            + ConvertToRupiah ((iJthSaudariSeibu)) + "\n";
                                }
                                if (iJumlahSaudariSeibu > 1) {
                                    iJthSaudariSeibu = Math.round(iHarta / 3);
                                    resultToPrint += "Jatah tiap Saudari Seibu (1/3) :"
                                            + ConvertToRupiah ((iJthSaudariSeibu / iJumlahSaudariSeibu))
                                            + "\n";
                                }
                            }
                        }
                    }
                    // iSisa = iHarta -
                    // (iJthIstri+iJthIbu+iJthBapak+iJthKakek+iJthNenekBapak*iJumlahNenekBapak+iJthNenekIbu*iJumlahNenekIbu+iJthNenekKakek*iJumlahNenekKakek+iJthSaudaraSeibu*iJumlahSaudaraSeibu+iJthSaudaraKandung*iJumlahSaudaraKandung+iJthSaudariKandung*iJumlahSaudariKandung+iJthSaudaraSebapak*iJumlahSaudaraSebapak+iJthSaudariSebapak+iJthSaudariSeibu);
                }
            }
            if (iJumlahCucuLaki > 0 && iJumlahCucuPerempuan > 0) {
                if (iJumlahSuami == 1) {
                    iJthSuami = Math.round(iHarta / 4);
                }
                if (iJumlahIstri > 0) {
                    iJthIstri = Math.round(iHarta / 8);
                }
                if (iJumlahIbu == 1) {
                    iJthIbu = Math.round(iHarta / 6);
                }
                if (iJumlahIbu == 0) {
                    if (iJumlahNenekBapak == 1 && iJumlahNenekIbu == 0) {
                        iJthNenekBapak = Math.round(iHarta / 6)
                                * iJumlahNenekBapak;
                    }
                    if (iJumlahNenekBapak == 0 && iJumlahNenekIbu == 1) {
                        iJthNenekIbu = Math.round(iHarta / 6) * iJumlahNenekIbu;
                    }
                    if (iJumlahNenekBapak == 1 && iJumlahNenekIbu == 1) {
                        iJthNenekBapak = Math.round(iHarta / 12)
                                * iJumlahNenekBapak;
                        iJthNenekIbu = Math.round(iHarta / 12)
                                * iJumlahNenekIbu;
                    }
                    if (iJumlahNenekBapak == 0 && iJumlahNenekIbu == 0) {
                        iJthNenekKakek = Math.round(iHarta / 6)
                                * iJumlahNenekKakek;
                    }
                }
                if (iJumlahBapak == 1) {
                    iJthBapak = Math.round(iHarta / 6);
                }
                if (iJumlahBapak == 0) {
                    iJthKakek = Math.round(iHarta / 6) * iJumlahKakek;
                }
                iSisa = iHarta
                        - (iJthSuami * iJumlahSuami + iJthIstri * iJumlahIstri
                        + iJthIbu * iJumlahIbu + iJthBapak
                        * iJumlahBapak + iJthKakek * iJumlahKakek
                        + iJthNenekBapak * iJumlahNenekBapak
                        + iJthNenekIbu * iJumlahNenekIbu + iJthNenekKakek
                        * iJumlahNenekKakek);
                iJthCucuLaki = Math.round((2 * iSisa)
                        / (2 * iJumlahCucuLaki + iJumlahCucuPerempuan));
                iJthCucuPerempuan = Math.round((iSisa)
                        / (2 * iJumlahCucuLaki + iJumlahCucuPerempuan));
                iSisa = iHarta
                        - (iJthSuami * iJumlahSuami + iJthIstri * iJumlahIstri
                        + iJthIbu * iJumlahIbu + iJthBapak
                        * iJumlahBapak + iJthKakek * iJumlahKakek
                        + iJthNenekBapak * iJumlahNenekBapak
                        + iJthNenekIbu * iJumlahNenekIbu
                        + iJthNenekKakek * iJumlahNenekKakek
                        + iJthCucuLaki * iJumlahCucuLaki + iJthCucuPerempuan
                        * iJumlahCucuPerempuan);
                resultToPrint += "Jatah tiap Cucu Laki-laki (Sisa) : "
                        + ConvertToRupiah ((iJthCucuLaki)) + "\n";
                resultToPrint += "Jatah tiap Cucu Perempuan (Sisa) : "
                        + ConvertToRupiah ((iJthCucuPerempuan)) + "\n";
                if (iJumlahSaudaraKandung > 0)
                    resultToPrint += "Jatah tiap Saudara Kandung : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahSaudariKandung > 0)
                    resultToPrint += "Jatah tiap Saudari kandung : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahSaudaraSebapak > 0)
                    resultToPrint += "Jatah tiap Saudara Sebapak : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahSaudaraSeibu > 0)
                    resultToPrint += "Jatah tiap Saudara Seibu : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahSaudariSebapak > 0)
                    resultToPrint += "Jatah tiap Saudari Sebapak : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahSaudariSeibu > 0)
                    resultToPrint += "Jatah tiap Saudari Seibu : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahPutraSaudaraKandung > 0)
                    resultToPrint += "Jatah tiap Putra Saudara Kandung : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahPutraSaudaraSebapak > 0)
                    resultToPrint += "Jatah tiap Putra Saudara Sebapak : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahPamanKandung > 0)
                    resultToPrint += "Jatah tiap Paman Kandung : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahPamanSebapak > 0)
                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahPutraPamanKandung > 0)
                    resultToPrint += "Jatah tiap Putra Paman Kandung : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahPutraPamanSebapak > 0)
                    resultToPrint += "Jatah tiap Putra Paman Sebapak : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahPriaMerdekakan > 0)
                    resultToPrint += "Jatah Pria yang Memerdekakan Budak : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahWanitaMerdekakan > 0)
                    resultToPrint += "Jatah Wanita yang Memerdekakan Budak : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
            }
            if (iJumlahCucuLaki > 0 && iJumlahCucuPerempuan == 0) {
                if (iJumlahSuami == 1) {
                    iJthSuami = Math.round(iHarta / 4);
                }
                if (iJumlahIstri > 0) {
                    iJthIstri = Math.round((iHarta / 8) / iJumlahIstri);
                }
                if (iJumlahIbu == 1) {
                    iJthIbu = Math.round(iHarta / 6);
                }
                if (iJumlahIbu == 0) {
                    if (iJumlahNenekBapak == 1 && iJumlahNenekIbu == 0) {
                        iJthNenekBapak = Math.round(iHarta / 6)
                                * iJumlahNenekBapak;
                    }
                    if (iJumlahNenekBapak == 0 && iJumlahNenekIbu == 1) {
                        iJthNenekIbu = Math.round(iHarta / 6) * iJumlahNenekIbu;
                    }
                    if (iJumlahNenekBapak == 1 && iJumlahNenekIbu == 1) {
                        iJthNenekBapak = Math.round(iHarta / 12)
                                * iJumlahNenekBapak;
                        iJthNenekIbu = Math.round(iHarta / 12)
                                * iJumlahNenekIbu;
                    }
                    if (iJumlahNenekBapak == 0 && iJumlahNenekIbu == 0) {
                        iJthNenekKakek = Math.round(iHarta / 6)
                                * iJumlahNenekKakek;
                    }
                }
                if (iJumlahBapak == 1) {
                    iJthBapak = Math.round(iHarta / 6);
                }
                if (iJumlahBapak == 0) {
                    iJthKakek = Math.round(iHarta / 6) * iJumlahKakek;
                }
                iSisa = iHarta
                        - (iJthSuami * iJumlahSuami + iJthIstri * iJumlahIstri
                        + iJthIbu * iJumlahIbu + iJthBapak
                        * iJumlahBapak + iJthKakek * iJumlahKakek
                        + iJthNenekBapak * iJumlahNenekBapak
                        + iJthNenekIbu * iJumlahNenekIbu + iJthNenekKakek
                        * iJumlahNenekKakek);
                iJthCucuLaki = iSisa / iJumlahCucuLaki;
                iSisa = iHarta
                        - (iJthSuami * iJumlahSuami + iJthIstri * iJumlahIstri
                        + iJthIbu * iJumlahIbu + iJthBapak
                        * iJumlahBapak + iJthKakek * iJumlahKakek
                        + iJthNenekBapak * iJumlahNenekBapak
                        + iJthNenekIbu * iJumlahNenekIbu
                        + iJthNenekKakek * iJumlahNenekKakek + iJthCucuLaki
                        * iJumlahCucuLaki);
                resultToPrint += "Jatah tiap Cucu Laki-laki (Sisa) : "
                        + ConvertToRupiah ((iJthCucuLaki)) + "\n";
                if (iJumlahSaudaraKandung > 0)
                    resultToPrint += "Jatah tiap Saudara Kandung : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahSaudariKandung > 0)
                    resultToPrint += "Jatah tiap Saudari kandung : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahSaudaraSebapak > 0)
                    resultToPrint += "Jatah tiap Saudara Sebapak : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahSaudaraSeibu > 0)
                    resultToPrint += "Jatah tiap Saudara Seibu : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahSaudariSebapak > 0)
                    resultToPrint += "Jatah tiap Saudari Sebapak : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahSaudariSeibu > 0)
                    resultToPrint += "Jatah tiap Saudari Seibu : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahPutraSaudaraKandung > 0)
                    resultToPrint += "Jatah tiap Putra Saudara Kandung : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahPutraSaudaraSebapak > 0)
                    resultToPrint += "Jatah tiap Putra Saudara Sebapak : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahPamanKandung > 0)
                    resultToPrint += "Jatah tiap Paman Kandung : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahPamanSebapak > 0)
                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahPutraPamanKandung > 0)
                    resultToPrint += "Jatah tiap Putra Paman Kandung : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahPutraPamanSebapak > 0)
                    resultToPrint += "Jatah tiap Putra Paman Sebapak : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahPriaMerdekakan > 0)
                    resultToPrint += "Jatah Pria yang Memerdekakan Budak : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
                if (iJumlahWanitaMerdekakan > 0)
                    resultToPrint += "Jatah Wanita yang Memerdekakan Budak : 0 (karena dihalangi oleh Cucu Laki-Laki)"
                            + "\n";
            }
            if (iJumlahCucuLaki == 0 && iJumlahCucuPerempuan > 0) {
                if (iJumlahSuami == 1) {
                    iJthSuami = Math.round(iHarta / 4);
                }
                if (iJumlahIstri > 0) {
                    iJthIstri = Math.round((iHarta / 8) / iJumlahIstri);
                }
                if (iJumlahIbu == 1) {
                    iJthIbu = Math.round(iHarta / 6);
                }
                if (iJumlahIbu == 0) {
                    if (iJumlahNenekBapak == 1 && iJumlahNenekIbu == 0) {
                        iJthNenekBapak = Math.round(iHarta / 6)
                                * iJumlahNenekBapak;
                    }
                    if (iJumlahNenekBapak == 0 && iJumlahNenekIbu == 1) {
                        iJthNenekIbu = Math.round(iHarta / 6) * iJumlahNenekIbu;
                    }
                    if (iJumlahNenekBapak == 1 && iJumlahNenekIbu == 1) {
                        iJthNenekBapak = Math.round(iHarta / 12)
                                * iJumlahNenekBapak;
                        iJthNenekIbu = Math.round(iHarta / 12)
                                * iJumlahNenekIbu;
                    }
                    if (iJumlahNenekBapak == 0 && iJumlahNenekIbu == 0) {
                        iJthNenekKakek = Math.round(iHarta / 6)
                                * iJumlahNenekKakek;
                    }
                }
                if (iJumlahBapak == 1) {
                    iJthBapak = Math.round(iHarta / 6);
                    if (iJumlahSaudaraSeibu > 0)
                        resultToPrint += "Jatah tiap Saudara Seibu : 0 (karena dihalangi oleh Bapak)"
                                + "\n";
                    if (iJumlahSaudaraKandung > 0)
                        resultToPrint += "Jatah tiap Saudara Kandung : 0 (karena dihalangi oleh Bapak)"
                                + "\n";
                    if (iJumlahSaudariKandung > 0)
                        resultToPrint += "Jatah tiap Saudari Kandung : 0 (karena dihalangi oleh Bapak)"
                                + "\n";
                    if (iJumlahSaudariSeibu > 0)
                        resultToPrint += "Jatah tiap Saudari Seibu : 0 (karena dihalangi oleh Bapak)"
                                + "\n";
                    if (iJumlahSaudaraSebapak > 0)
                        resultToPrint += "Jatah tiap Saudara Sebapak : 0 (karena dihalangi oleh Bapak)"
                                + "\n";
                    if (iJumlahSaudariSebapak > 0)
                        resultToPrint += "Jatah tiap Saudari Sebapak : 0 (karena dihalangi oleh Bapak)"
                                + "\n";
                    if (iJumlahPutraSaudaraKandung > 0)
                        resultToPrint += "Jatah tiap Putra Saudara Kandung : 0 (karena dihalangi oleh Bapak)"
                                + "\n";
                    if (iJumlahPutraSaudaraSebapak > 0)
                        resultToPrint += "Jatah tiap Putra Saudara Sebapak : 0 (karena dihalangi oleh Bapak)"
                                + "\n";
                    if (iJumlahPamanKandung > 0)
                        resultToPrint += "Jatah tiap Paman Kandung : 0 (karena dihalangi oleh Bapak)"
                                + "\n";
                    if (iJumlahPamanSebapak > 0)
                        resultToPrint += "Jatah tiap Paman Sebapak : 0 (karena dihalangi oleh Bapak)"
                                + "\n";
                    if (iJumlahPutraPamanKandung > 0)
                        resultToPrint += "Jatah tiap Putra Paman Kandung : 0 (karena dihalangi oleh Bapak)"
                                + "\n";
                    if (iJumlahPutraPamanSebapak > 0)
                        resultToPrint += "Jatah tiap Putra Paman Sebapak : 0 (karena dihalangi oleh Bapak)"
                                + "\n";
                    if (iJumlahPriaMerdekakan > 0)
                        resultToPrint += "Jatah Pria yang Memerdekakan Budak : 0 (karena dihalangi oleh Bapak)"
                                + "\n";
                    if (iJumlahWanitaMerdekakan > 0)
                        resultToPrint += "Jatah Wanita yang Memerdekakan Budak : 0 (karena dihalangi oleh Bapak)"
                                + "\n";
                }
                if (iJumlahBapak == 0) {
                    iJthKakek = Math.round(iHarta / 6) * iJumlahKakek;
                }
                if (iJumlahCucuPerempuan == 1) {
                    iJthCucuPerempuan = Math.round(iHarta / 2);
                    resultToPrint += "Jatah tiap Cucu Perempuan (1/2) : "
                            + ConvertToRupiah ((iJthCucuPerempuan)) + "\n";
                } else {
                    iJthCucuPerempuan = Math.round((2 * iHarta)
                            / (3 * iJumlahCucuPerempuan));
                    resultToPrint += "Jatah tiap Cucu Perempuan (2/3) : "
                            + ConvertToRupiah ((iJthCucuPerempuan)) + "\n";
                }
                iSisa = iHarta
                        - (iJthSuami * iJumlahSuami + iJthIstri * iJumlahIstri
                        + iJthIbu * iJumlahIbu + iJthBapak
                        * iJumlahBapak + iJthKakek * iJumlahKakek
                        + iJthNenekBapak * iJumlahNenekBapak
                        + iJthNenekIbu * iJumlahNenekIbu
                        + iJthNenekKakek * iJumlahNenekKakek + (iJthCucuPerempuan * iJumlahCucuPerempuan));
                if (iJumlahBapak == 1) {
                    iJthBapak = Math.round(iHarta / 6);
                    iJthBapak = iJthBapak + iSisa * iJumlahBapak;
                }
                if (iJumlahBapak == 0) {
                    if (iJumlahKakek == 1) {
                        iJthKakek = Math.round(iHarta / 6);
                        iJthKakek = iJthKakek + iSisa * iJumlahKakek;
                        if (iJumlahSaudaraSeibu > 0)
                            resultToPrint += "Jatah tiap Saudara Seibu : 0 (karena dihalangi oleh Kakek)"
                                    + "\n";
                        if (iJumlahSaudaraKandung > 0)
                            resultToPrint += "Jatah tiap Saudara Kandung : 0 (karena dihalangi oleh Kakek)"
                                    + "\n";
                        if (iJumlahSaudariKandung > 0)
                            resultToPrint += "Jatah tiap Saudari Kandung : 0 (karena dihalangi oleh Kakek)"
                                    + "\n";
                        if (iJumlahSaudariSeibu > 0)
                            resultToPrint += "Jatah tiap Saudari Seibu : 0 (karena dihalangi oleh Kakek)"
                                    + "\n";
                        if (iJumlahSaudaraSebapak > 0)
                            resultToPrint += "Jatah tiap Saudara Sebapak : 0 (karena dihalangi oleh Kakek)"
                                    + "\n";
                        if (iJumlahSaudariSebapak > 0)
                            resultToPrint += "Jatah tiap Saudari Sebapak : 0 (karena dihalangi oleh Kakek)"
                                    + "\n";
                        if (iJumlahPutraSaudaraKandung > 0)
                            resultToPrint += "Jatah tiap Putra Saudara Kandung : 0 (karena dihalangi oleh Kakek)"
                                    + "\n";
                        if (iJumlahPutraSaudaraSebapak > 0)
                            resultToPrint += "Jatah tiap Putra Saudara Sebapak : 0 (karena dihalangi oleh Kakek)"
                                    + "\n";
                        if (iJumlahPamanKandung > 0)
                            resultToPrint += "Jatah tiap Paman Kandung : 0 (karena dihalangi oleh Kakek)"
                                    + "\n";
                        if (iJumlahPamanSebapak > 0)
                            resultToPrint += "Jatah tiap Paman Sebapak : 0 (karena dihalangi oleh Kakek)"
                                    + "\n";
                        if (iJumlahPutraPamanKandung > 0)
                            resultToPrint += "Jatah tiap Putra Paman Kandung : 0 (karena dihalangi oleh Kakek)"
                                    + "\n";
                        if (iJumlahPutraPamanSebapak > 0)
                            resultToPrint += "Jatah tiap Putra Paman Sebapak : 0 (karena dihalangi oleh Kakek)"
                                    + "\n";
                        if (iJumlahPriaMerdekakan > 0)
                            resultToPrint += "Jatah Pria yang Memerdekakan Budak : 0 (karena dihalangi oleh Kakek)"
                                    + "\n";
                        if (iJumlahWanitaMerdekakan > 0)
                            resultToPrint += "Jatah Wanita yang Memerdekakan Budak : 0 (karena dihalangi oleh Kakek)"
                                    + "\n";
                    }
                    if (iJumlahKakek == 0) {
                        if (iJumlahSaudaraKandung > 0) {
                            iSisa = iHarta
                                    - (iJthSuami + iJthIbu + iJthCucuPerempuan
                                    + iJthNenekBapak
                                    * iJumlahNenekBapak + iJthNenekIbu
                                    * iJumlahNenekIbu + iJthNenekKakek
                                    * iJumlahNenekKakek + iJthSaudaraSeibu);
                            if (iJumlahSaudariKandung == 0) {
                                iJthSaudaraKandung = Math.round(iSisa
                                        / iJumlahSaudaraKandung);
                            }
                            if (iJumlahSaudariKandung > 0) {
                                iJthSaudaraKandung = Math
                                        .round(iSisa
                                                / (iJumlahSaudaraKandung + iJumlahSaudariKandung));
                                iJthSaudariKandung = iJthSaudaraKandung;
                                resultToPrint += "Jatah tiap Saudari Kandung (Sisa) : "
                                        + ConvertToRupiah ((iJthSaudariKandung)) + "\n";
                                if (iJumlahPutraSaudaraKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraSaudaraSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPriaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahWanitaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                            }
                            iSisa = iHarta
                                    - (iJthSuami + iJthIbu + iJthNenekBapak
                                    * iJumlahNenekBapak + iJthNenekIbu
                                    * iJumlahNenekIbu + iJthNenekKakek
                                    * iJumlahNenekKakek
                                    + iJthSaudaraSeibu
                                    + iJthSaudaraKandung
                                    * iJumlahSaudaraKandung + iJthSaudariKandung
                                    * iJumlahSaudariKandung);
                            resultToPrint += "Jatah tiap Saudara Kandung (Sisa) : "
                                    + ConvertToRupiah ((iJthSaudaraKandung)) + "\n";
                            if (iJumlahSaudaraSebapak > 0)
                                resultToPrint += "Jatah tiap Saudara Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPutraSaudaraKandung > 0)
                                resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPutraSaudaraSebapak > 0)
                                resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPamanKandung > 0)
                                resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPamanSebapak > 0)
                                resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPutraPamanKandung > 0)
                                resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPutraPamanSebapak > 0)
                                resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPriaMerdekakan > 0)
                                resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahWanitaMerdekakan > 0)
                                resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahSaudariSebapak > 0)
                                resultToPrint += "Jatah tiap Saudari Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                        }
                        if (iJumlahSaudaraKandung == 0) {
                            if (iJumlahSaudariKandung > 0
                                    && iJumlahCucuPerempuan > 0) {
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu
                                        + iJthCucuPerempuan
                                        + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek + iJthSaudaraSeibu);
                                iJthSaudariKandung = Math.round(iSisa
                                        / iJumlahSaudariKandung);
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu
                                        + iJthCucuPerempuan
                                        + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek
                                        + iJthSaudaraSeibu + iJthSaudariKandung
                                        * iJumlahSaudariKandung);
                                resultToPrint += "Jatah tiap Saudari Kandung (Sisa) : "
                                        + ConvertToRupiah ((iJthSaudariKandung / iJumlahSaudariKandung))
                                        + "\n";
                                if (iJumlahSaudariSebapak > 0) {
                                    resultToPrint += "Jatah tiap Saudari Sebapak : 0(Karena dihalangi 2 Saudari Kandung atau lebih)"
                                            + "\n";
                                }
                                if (iJumlahPutraSaudaraKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraSaudaraSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPriaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahWanitaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                            }
                            if (iJumlahSaudaraSebapak > 0) {
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu
                                        + iJthCucuPerempuan
                                        + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek + iJthSaudaraSeibu);
                                iJthSaudaraSebapak = Math.round(iSisa
                                        / iJumlahSaudaraSebapak);
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu
                                        + iJthCucuPerempuan
                                        + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek
                                        + iJthSaudaraSeibu + iJthSaudaraSebapak
                                        * iJumlahSaudaraSebapak);
                                resultToPrint += "Jatah tiap Saudara Sebapak (Sisa) : "
                                        + ConvertToRupiah ((iJthSaudaraSebapak)) + "\n";
                                if (iJumlahPutraSaudaraKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudara Sebapak)"
                                            + "\n";
                                if (iJumlahPutraSaudaraSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudara Sebapak)"
                                            + "\n";
                                if (iJumlahPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudara Sebapak)"
                                            + "\n";
                                if (iJumlahPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudara Sebapak)"
                                            + "\n";
                                if (iJumlahPutraPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudara Sebapak)"
                                            + "\n";
                                if (iJumlahPutraPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudara Sebapak)"
                                            + "\n";
                                if (iJumlahPriaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sebapak)"
                                            + "\n";
                                if (iJumlahWanitaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sebapak)"
                                            + "\n";
                            }
                            if (iJumlahSaudariSebapak > 0
                                    && iJumlahSaudariKandung == 0) {
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu
                                        + iJthCucuPerempuan
                                        + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek
                                        + iJthSaudaraSeibu
                                        + iJthSaudariKandung
                                        * iJumlahSaudariKandung + iJthSaudaraSebapak
                                        * iJumlahSaudaraSebapak);
                                iJthSaudariSebapak = Math.round(iSisa
                                        / iJumlahSaudariSebapak);
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu
                                        + iJthCucuPerempuan
                                        + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek
                                        + iJthSaudaraSeibu
                                        + iJthSaudariKandung
                                        * iJumlahSaudariKandung
                                        + iJthSaudaraSebapak
                                        * iJumlahSaudaraSebapak + iJthSaudariSebapak
                                        * iJumlahSaudariSebapak);
                                resultToPrint += "Jatah tiap Saudari Sebapak (Sisa) : "
                                        + ConvertToRupiah ((iJthSaudariSebapak / iJumlahSaudariSebapak))
                                        + "\n";
                                if (iJumlahPutraSaudaraKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudari Sebapak)"
                                            + "\n";
                                if (iJumlahPutraSaudaraSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudari Sebapak)"
                                            + "\n";
                                if (iJumlahPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudari Sebapak)"
                                            + "\n";
                                if (iJumlahPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudari Sebapak)"
                                            + "\n";
                                if (iJumlahPutraPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudari Sebapak)"
                                            + "\n";
                                if (iJumlahPutraPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudari Sebapak)"
                                            + "\n";
                                if (iJumlahPriaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sebapak)"
                                            + "\n";
                                if (iJumlahWanitaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sebapak)"
                                            + "\n";
                            }
                        }
                    }
                }
                iSisa = iHarta
                        - (iJthSuami + iJthIbu + iJthBapak + iJthKakek
                        + iJthCucuPerempuan + iJthNenekBapak
                        * iJumlahNenekBapak + iJthNenekIbu
                        * iJumlahNenekIbu + iJthNenekKakek
                        * iJumlahNenekKakek + iJthSaudaraSeibu
                        + iJthSaudaraKandung * iJumlahSaudaraKandung
                        + iJthSaudariKandung + iJthSaudaraSebapak
                        * iJumlahSaudaraSebapak);
                if (iJumlahSaudaraSeibu > 0)
                    resultToPrint += "Jatah tiap Saudara Seibu : 0 (karena dihalangi oleh Cucu Perempuan)"
                            + "\n";
                if (iJumlahSaudariSeibu > 0)
                    resultToPrint += "Jatah tiap Saudari Seibu : 0 (karena dihalangi oleh Cucu Perempuan)"
                            + "\n";
            }
        } else if (iJumlahAnakLaki > 0 && iJumlahAnakPerempuan > 0) {
            if (iJumlahSuami == 1) {
                iJthSuami = Math.round(iHarta / 4);
            }
            if (iJumlahIstri > 0) {
                iJthIstri = Math.round(iHarta / 8);
            }
            if (iJumlahIbu == 1) {
                iJthIbu = Math.round(iHarta / 6);
            }
            if (iJumlahIbu == 0) {
                if (iJumlahNenekBapak == 1 && iJumlahNenekIbu == 0) {
                    iJthNenekBapak = Math.round(iHarta / 6) * iJumlahNenekBapak;
                }
                if (iJumlahNenekBapak == 0 && iJumlahNenekIbu == 1) {
                    iJthNenekIbu = Math.round(iHarta / 6) * iJumlahNenekIbu;
                }
                if (iJumlahNenekBapak == 1 && iJumlahNenekIbu == 1) {
                    iJthNenekBapak = Math.round(iHarta / 12)
                            * iJumlahNenekBapak;
                    iJthNenekIbu = Math.round(iHarta / 12) * iJumlahNenekIbu;
                }
                if (iJumlahNenekBapak == 0 && iJumlahNenekIbu == 0) {
                    iJthNenekKakek = Math.round(iHarta / 6) * iJumlahNenekKakek;
                }
            }
            if (iJumlahBapak == 1) {
                iJthBapak = Math.round(iHarta / 6);
            }
            if (iJumlahBapak == 0) {
                iJthKakek = Math.round(iHarta / 6) * iJumlahKakek;
            }
            iSisa = iHarta
                    - (iJthSuami * iJumlahSuami + iJthIstri * iJumlahIstri
                    + iJthIbu * iJumlahIbu + iJthBapak * iJumlahBapak
                    + iJthKakek * iJumlahKakek + iJthNenekBapak
                    * iJumlahNenekBapak + iJthNenekIbu
                    * iJumlahNenekIbu + iJthNenekKakek
                    * iJumlahNenekKakek);
            iJthAnakLaki = Math.round((2 * iSisa)
                    / (2 * iJumlahAnakLaki + 1 * iJumlahAnakPerempuan));
            iJthAnakPerempuan = Math.round((iSisa)
                    / (2 * iJumlahAnakLaki + 1 * iJumlahAnakPerempuan));
            iSisa = iHarta
                    - (iJthSuami * iJumlahSuami + iJthIstri * iJumlahIstri
                    + iJthIbu * iJumlahIbu + iJthBapak * iJumlahBapak
                    + iJthKakek * iJumlahKakek + iJthNenekBapak
                    * iJumlahNenekBapak + iJthNenekIbu
                    * iJumlahNenekIbu + iJthNenekKakek
                    * iJumlahNenekKakek + iJthAnakLaki
                    * iJumlahAnakLaki + iJthAnakPerempuan
                    * iJumlahAnakPerempuan);
            if (iJumlahCucuLaki > 0)
                resultToPrint += "Jatah tiap Cucu Laki-laki : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahCucuPerempuan > 0 && iJumlahAnakPerempuan < 2)
                resultToPrint += "Jatah tiap Cucu Perempuan : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahCucuPerempuan > 0 && iJumlahAnakPerempuan >= 2)
                resultToPrint += "Jatah tiap Cucu Perempuan : 0 (karena dihalangi oleh Anak Laki-Laki dan 2 Anak Perempuan atau lebih)"
                        + "\n";
            if (iJumlahSaudaraKandung > 0)
                resultToPrint += "Jatah tiap Saudara Kandung : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahSaudariKandung > 0)
                resultToPrint += "Jatah tiap Saudari kandung : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahSaudaraSebapak > 0)
                resultToPrint += "Jatah tiap Saudara Sebapak : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahSaudaraSeibu > 0)
                resultToPrint += "Jatah tiap Saudara Seibu : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahSaudariSebapak > 0)
                resultToPrint += "Jatah tiap Saudari Sebapak : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahSaudariSeibu > 0)
                resultToPrint += "Jatah tiap Saudari Seibu : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahPutraSaudaraKandung > 0)
                resultToPrint += "Jatah tiap Putra Saudara Kandung : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahPutraSaudaraSebapak > 0)
                resultToPrint += "Jatah tiap Putra Saudara Sebapak : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahPamanKandung > 0)
                resultToPrint += "Jatah tiap Paman Kandung : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahPamanSebapak > 0)
                resultToPrint += "Jatah tiap Paman Sebapak : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahPutraPamanKandung > 0)
                resultToPrint += "Jatah tiap Putra Paman Kandung : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahPutraPamanSebapak > 0)
                resultToPrint += "Jatah tiap Putra Paman Sebapak : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahPriaMerdekakan > 0)
                resultToPrint += "Jatah Pria yang Memerdekakan Budak : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahWanitaMerdekakan > 0)
                resultToPrint += "Jatah Wanita yang Memerdekakan Budak : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
        } else if (iJumlahAnakLaki > 0 && iJumlahAnakPerempuan == 0) {
            if (iJumlahSuami == 1) {
                iJthSuami = Math.round(iHarta / 4);
            }
            if (iJumlahIstri > 0) {
                iJthIstri = Math.round((iHarta / 8) / iJumlahIstri);
            }
            if (iJumlahIbu == 1) {
                iJthIbu = Math.round(iHarta / 6);
            }
            if (iJumlahIbu == 0) {
                if (iJumlahNenekBapak == 1 && iJumlahNenekIbu == 0) {
                    iJthNenekBapak = Math.round(iHarta / 6) * iJumlahNenekBapak;
                }
                if (iJumlahNenekBapak == 0 && iJumlahNenekIbu == 1) {
                    iJthNenekIbu = Math.round(iHarta / 6) * iJumlahNenekIbu;
                }
                if (iJumlahNenekBapak == 1 && iJumlahNenekIbu == 1) {
                    iJthNenekBapak = Math.round(iHarta / 12)
                            * iJumlahNenekBapak;
                    iJthNenekIbu = Math.round(iHarta / 12) * iJumlahNenekIbu;
                }
                if (iJumlahNenekBapak == 0 && iJumlahNenekIbu == 0) {
                    iJthNenekKakek = Math.round(iHarta / 6) * iJumlahNenekKakek;
                }
            }
            if (iJumlahBapak == 1) {
                iJthBapak = Math.round(iHarta / 6);
            }
            if (iJumlahBapak == 0) {
                iJthKakek = Math.round(iHarta / 6) * iJumlahKakek;
            }
            iSisa = iHarta
                    - (iJthSuami * iJumlahSuami + iJthIstri * iJumlahIstri
                    + iJthIbu * iJumlahIbu + iJthBapak * iJumlahBapak
                    + iJthKakek * iJumlahKakek + iJthNenekBapak
                    * iJumlahNenekBapak + iJthNenekIbu
                    * iJumlahNenekIbu + iJthNenekKakek
                    * iJumlahNenekKakek);
            iJthAnakLaki = iSisa / iJumlahAnakLaki;
            iSisa = iHarta
                    - (iJthSuami * iJumlahSuami + iJthIstri * iJumlahIstri
                    + iJthIbu * iJumlahIbu + iJthBapak * iJumlahBapak
                    + iJthKakek * iJumlahKakek + iJthNenekBapak
                    * iJumlahNenekBapak + iJthNenekIbu
                    * iJumlahNenekIbu + iJthNenekKakek
                    * iJumlahNenekKakek + iJthAnakLaki
                    * iJumlahAnakLaki);
            if (iJumlahCucuLaki > 0)
                resultToPrint += "Jatah tiap Cucu Laki-laki : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahCucuPerempuan > 0)
                resultToPrint += "Jatah tiap Cucu Perempuan : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahSaudaraKandung > 0)
                resultToPrint += "Jatah tiap Saudara Kandung : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahSaudariKandung > 0)
                resultToPrint += "Jatah tiap Saudari kandung : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahSaudaraSebapak > 0)
                resultToPrint += "Jatah tiap Saudara Sebapak : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahSaudaraSeibu > 0)
                resultToPrint += "Jatah tiap Saudara Seibu : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahSaudariSebapak > 0)
                resultToPrint += "Jatah tiap Saudari Sebapak : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahSaudariSeibu > 0)
                resultToPrint += "Jatah tiap Saudari Seibu : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahPutraSaudaraKandung > 0)
                resultToPrint += "Jatah tiap Putra Saudara Kandung : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahPutraSaudaraSebapak > 0)
                resultToPrint += "Jatah tiap Putra Saudara Sebapak : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahPamanKandung > 0)
                resultToPrint += "Jatah tiap Paman Kandung : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahPamanSebapak > 0)
                resultToPrint += "Jatah tiap Paman Sebapak : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahPutraPamanKandung > 0)
                resultToPrint += "Jatah tiap Putra Paman Kandung : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahPutraPamanSebapak > 0)
                resultToPrint += "Jatah tiap Putra Paman Sebapak : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
            if (iJumlahPriaMerdekakan > 0)
                resultToPrint += "Jatah Pria yang Memerdekakan Budak : 0"
                        + " (karena dihalangi oleh Anak Laki-Laki)" + "\n";
            if (iJumlahWanitaMerdekakan > 0)
                resultToPrint += "Jatah Wanita yang Memerdekakan Budak : 0 (karena dihalangi oleh Anak Laki-Laki)"
                        + "\n";
        } else if (iJumlahAnakLaki == 0 && iJumlahAnakPerempuan > 0) {
            if (iJumlahSuami == 1) {
                iJthSuami = Math.round(iHarta / 4);
            }
            if (iJumlahIstri > 0) {
                iJthIstri = Math.round((iHarta / 8) / iJumlahIstri);
            }
            if (iJumlahIbu == 1) {
                iJthIbu = Math.round(iHarta / 6);
            }
            if (iJumlahIbu == 0) {
                if (iJumlahNenekBapak == 1 && iJumlahNenekIbu == 0) {
                    iJthNenekBapak = Math.round(iHarta / 6) * iJumlahNenekBapak;
                }
                if (iJumlahNenekBapak == 0 && iJumlahNenekIbu == 1) {
                    iJthNenekIbu = Math.round(iHarta / 6) * iJumlahNenekIbu;
                }
                if (iJumlahNenekBapak == 1 && iJumlahNenekIbu == 1) {
                    iJthNenekBapak = Math.round(iHarta / 12)
                            * iJumlahNenekBapak;
                    iJthNenekIbu = Math.round(iHarta / 12) * iJumlahNenekIbu;
                }
                if (iJumlahNenekBapak == 0 && iJumlahNenekIbu == 0) {
                    iJthNenekKakek = Math.round(iHarta / 6) * iJumlahNenekKakek;
                }
            }
            if (iJumlahBapak == 1) {
                iJthBapak = Math.round(iHarta / 6);
                if (iJumlahSaudaraKandung > 0)
                    resultToPrint += "Jatah tiap Saudara Kandung : 0 (karena dihalangi oleh Bapak)"
                            + "\n";
                if (iJumlahSaudariKandung > 0)
                    resultToPrint += "Jatah tiap Saudari Kandung : 0 (karena dihalangi oleh Bapak)"
                            + "\n";
                if (iJumlahSaudaraSebapak > 0)
                    resultToPrint += "Jatah tiap Saudara Sebapak : 0 (karena dihalangi oleh Bapak)"
                            + "\n";
                if (iJumlahSaudariSebapak > 0)
                    resultToPrint += "Jatah tiap Saudari Sebapak : 0 (karena dihalangi oleh Bapak)"
                            + "\n";
                if (iJumlahPutraSaudaraKandung > 0)
                    resultToPrint += "Jatah tiap Putra Saudara Kandung : 0 (karena dihalangi oleh Bapak)"
                            + "\n";
                if (iJumlahPutraSaudaraSebapak > 0)
                    resultToPrint += "Jatah tiap Putra Saudara Sebapak : 0 (karena dihalangi oleh Bapak)"
                            + "\n";
                if (iJumlahPamanKandung > 0)
                    resultToPrint += "Jatah tiap Paman Kandung : 0 (karena dihalangi oleh Bapak)"
                            + "\n";
                if (iJumlahPamanSebapak > 0)
                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (karena dihalangi oleh Bapak)"
                            + "\n";
                if (iJumlahPutraPamanKandung > 0)
                    resultToPrint += "Jatah tiap Putra Paman Kandung : 0 (karena dihalangi oleh Bapak)"
                            + "\n";
                if (iJumlahPutraPamanSebapak > 0)
                    resultToPrint += "Jatah tiap Putra Paman Sebapak : 0 (karena dihalangi oleh Bapak)"
                            + "\n";
                if (iJumlahPriaMerdekakan > 0)
                    resultToPrint += "Jatah Pria yang Memerdekakan Budak : 0 (karena dihalangi oleh Bapak)"
                            + "\n";
                if (iJumlahWanitaMerdekakan > 0)
                    resultToPrint += "Jatah Wanita yang Memerdekakan Budak : 0 (karena dihalangi oleh Bapak)"
                            + "\n";
            }
            if (iJumlahBapak == 0) {
                if (iJumlahKakek == 1) {
                    iJthKakek = Math.round(iHarta / 6) * iJumlahKakek;
                    if (iJumlahSaudaraKandung > 0)
                        resultToPrint += "Jatah tiap Saudara Kandung : 0 (karena dihalangi oleh Kakek)"
                                + "\n";
                    if (iJumlahSaudariKandung > 0)
                        resultToPrint += "Jatah tiap Saudari Kandung : 0 (karena dihalangi oleh Kakek)"
                                + "\n";
                    if (iJumlahSaudaraSebapak > 0)
                        resultToPrint += "Jatah tiap Saudara Sebapak : 0 (karena dihalangi oleh Kakek)"
                                + "\n";
                    if (iJumlahSaudariSebapak > 0)
                        resultToPrint += "Jatah tiap Saudari Sebapak : 0 (karena dihalangi oleh Kakek)"
                                + "\n";
                    if (iJumlahPutraSaudaraKandung > 0)
                        resultToPrint += "Jatah tiap Putra Saudara Kandung : 0 (karena dihalangi oleh Kakek)"
                                + "\n";
                    if (iJumlahPutraSaudaraSebapak > 0)
                        resultToPrint += "Jatah tiap Putra Saudara Sebapak : 0 (karena dihalangi oleh Kakek)"
                                + "\n";
                    if (iJumlahPamanKandung > 0)
                        resultToPrint += "Jatah tiap Paman Kandung : 0 (karena dihalangi oleh Kakek)"
                                + "\n";
                    if (iJumlahPamanSebapak > 0)
                        resultToPrint += "Jatah tiap Paman Sebapak : 0 (karena dihalangi oleh Kakek)"
                                + "\n";
                    if (iJumlahPutraPamanKandung > 0)
                        resultToPrint += "Jatah tiap Putra Paman Kandung : 0 (karena dihalangi oleh Kakek)"
                                + "\n";
                    if (iJumlahPutraPamanSebapak > 0)
                        resultToPrint += "Jatah tiap Putra Paman Sebapak : 0 (karena dihalangi oleh Kakek)"
                                + "\n";
                    if (iJumlahPriaMerdekakan > 0)
                        resultToPrint += "Jatah Pria yang Memerdekakan Budak : 0 (karena dihalangi oleh Kakek)"
                                + "\n";
                    if (iJumlahWanitaMerdekakan > 0)
                        resultToPrint += "Jatah Wanita yang Memerdekakan Budak : 0 (karena dihalangi oleh Kakek)"
                                + "\n";
                }
            }
            if (iJumlahAnakPerempuan == 1) {
                iJthAnakPerempuan = Math.round(iHarta / 2);
                if (iJumlahCucuPerempuan > 0 && iJumlahCucuLaki == 0) {
                    iJthCucuPerempuan = Math.round(iHarta
                            / (6 * iJumlahCucuPerempuan));
                    resultToPrint += "Jatah tiap Cucu Perempuan : "
                            + ConvertToRupiah  ((iJthCucuPerempuan)) + "\n";
                    iSisa = iHarta
                            - (iJthSuami * iJumlahSuami + iJthIstri
                            * iJumlahIstri + iJthIbu * iJumlahIbu
                            + iJthBapak * iJumlahBapak + iJthKakek
                            * iJumlahKakek + iJthNenekBapak
                            * iJumlahNenekBapak + iJthNenekIbu
                            * iJumlahNenekIbu + iJthNenekKakek
                            * iJumlahNenekKakek + iJthAnakPerempuan + iJthCucuPerempuan
                            * iJumlahCucuPerempuan);
                    iJthBapak = iJthBapak + iSisa * iJumlahBapak;
                    iJthKakek = iJthKakek + iSisa * iJumlahKakek;
                    if (iJumlahBapak == 0 && iJumlahKakek == 0) {
                        if (iJumlahSaudaraKandung > 0) {
                            iSisa = iHarta
                                    - (iJthSuami * iJumlahSuami + iJthIstri
                                    * iJumlahIstri + iJthIbu
                                    * iJumlahIbu + iJthBapak
                                    * iJumlahBapak + iJthKakek
                                    * iJumlahKakek + iJthNenekBapak
                                    * iJumlahNenekBapak + iJthNenekIbu
                                    * iJumlahNenekIbu + iJthNenekKakek
                                    * iJumlahNenekKakek
                                    + iJthAnakPerempuan
                                    * iJumlahAnakPerempuan
                                    + iJthCucuPerempuan
                                    * iJumlahCucuPerempuan + iJthCucuLaki
                                    * iJumlahCucuLaki);
                            if (iJumlahSaudariKandung == 0) {
                                iJthSaudaraKandung = Math.round(iSisa
                                        / iJumlahSaudaraKandung);
                            }
                            if (iJumlahSaudariKandung > 0) {
                                iJthSaudaraKandung = Math
                                        .round(iSisa
                                                / (iJumlahSaudaraKandung + iJumlahSaudariKandung));
                                iJthSaudariKandung = iJthSaudaraKandung;
                                resultToPrint += "Jatah tiap Saudari Kandung (Sisa) : "
                                        + ConvertToRupiah ((iJthSaudariKandung)) + "\n";
                                if (iJumlahPutraSaudaraKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraSaudaraSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPriaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahWanitaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                            }
                            iSisa = iHarta
                                    - (iJthSuami + iJthIbu + iJthNenekBapak
                                    * iJumlahNenekBapak + iJthNenekIbu
                                    * iJumlahNenekIbu + iJthNenekKakek
                                    * iJumlahNenekKakek
                                    + iJthSaudaraSeibu
                                    + iJthSaudaraKandung
                                    * iJumlahSaudaraKandung + iJthSaudariKandung
                                    * iJumlahSaudariKandung);
                            resultToPrint += "Jatah tiap Saudara Kandung (Sisa) : "
                                    + ConvertToRupiah ((iJthSaudaraKandung)) + "\n";
                            if (iJumlahSaudaraSebapak > 0)
                                resultToPrint += "Jatah tiap Saudara Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahSaudaraSebapak > 0)
                                resultToPrint += "Jatah tiap Saudara Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPutraSaudaraKandung > 0)
                                resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPutraSaudaraSebapak > 0)
                                resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPamanKandung > 0)
                                resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPamanSebapak > 0)
                                resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPutraPamanKandung > 0)
                                resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPutraPamanSebapak > 0)
                                resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPriaMerdekakan > 0)
                                resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahWanitaMerdekakan > 0)
                                resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahSaudariSebapak > 0)
                                resultToPrint += "Jatah tiap Saudari Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                        }
                        if (iJumlahSaudaraKandung == 0) {
                            if (iJumlahSaudariKandung > 1) {
                                iJthSaudariKandung = Math.round(2 * iHarta / 3);
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek
                                        + iJthSaudaraSeibu + iJthSaudariKandung
                                        * iJumlahSaudariKandung);
                                resultToPrint += "Jatah tiap Saudari Kandung (2/3) : "
                                        + ConvertToRupiah ((iJthSaudariKandung / iJumlahSaudariKandung))
                                        + "\n";
                                if (iJumlahSaudariSebapak > 0) {
                                    resultToPrint += "Jatah tiap Saudari Sebapak : 0(Karena dihalangi 2 Saudari Kandung atau lebih)"
                                            + "\n";
                                }
                                if (iJumlahPutraSaudaraKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraSaudaraSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPriaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahWanitaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                            }
                            if (iJumlahSaudariKandung == 1) {
                                iJthSaudariKandung = Math.round(iHarta / 2);
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek
                                        + iJthSaudaraSeibu + iJthSaudariKandung
                                        * iJumlahSaudariKandung);
                                resultToPrint += "Jatah tiap Saudari Kandung (1/2) : "
                                        + ConvertToRupiah ((iJthSaudariKandung / iJumlahSaudariKandung))
                                        + "\n";
                                if (iJumlahSaudariSebapak > 0) {
                                    resultToPrint += "Jatah tiap Saudari Sebapak : 0(Karena dihalangi Saudari Kandung)"
                                            + "\n";
                                }
                                if (iJumlahPutraSaudaraKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraSaudaraSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPriaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahWanitaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                            }
                            if (iJumlahSaudaraSebapak > 0) {
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek + iJthSaudaraSeibu);
                                iJthSaudaraSebapak = Math.round(iSisa
                                        / iJumlahSaudaraSebapak);
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek
                                        + iJthSaudaraSeibu + iJthSaudaraSebapak
                                        * iJumlahSaudaraSebapak);
                                resultToPrint += "Jatah tiap Saudara Sebapak (Sisa) : "
                                        + ConvertToRupiah ((iJthSaudaraSebapak)) + "\n";
                                if (iJumlahPutraSaudaraKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudara Sebapak)"
                                            + "\n";
                                if (iJumlahPutraSaudaraSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudara Sebapak)"
                                            + "\n";
                                if (iJumlahPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudara Sebapak)"
                                            + "\n";
                                if (iJumlahPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudara Sebapak)"
                                            + "\n";
                                if (iJumlahPutraPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudara Sebapak)"
                                            + "\n";
                                if (iJumlahPutraPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudara Sebapak)"
                                            + "\n";
                                if (iJumlahPriaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sebapak)"
                                            + "\n";
                                if (iJumlahWanitaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sebapak)"
                                            + "\n";
                            }
                        }
                    }
                }
                if (iJumlahCucuPerempuan > 0 && iJumlahCucuLaki > 0) {
                    iSisa = iHarta
                            - (iJthSuami * iJumlahSuami + iJthIstri
                            * iJumlahIstri + iJthIbu * iJumlahIbu
                            + iJthBapak * iJumlahBapak + iJthKakek
                            * iJumlahKakek + iJthNenekBapak
                            * iJumlahNenekBapak + iJthNenekIbu
                            * iJumlahNenekIbu + iJthNenekKakek
                            * iJumlahNenekKakek + iJthAnakPerempuan);
                    iJthCucuPerempuan = Math.round(iSisa
                            / (2 * iJumlahCucuLaki + iJumlahCucuPerempuan));
                    iJthCucuLaki = Math.round(2 * iSisa
                            / (2 * iJumlahCucuLaki + iJumlahCucuPerempuan));
                    resultToPrint += "Jatah tiap Cucu Perempuan (Sisa) : "
                            + ConvertToRupiah ((iJthCucuPerempuan)) + "\n";
                    resultToPrint += "Jatah tiap Cucu Laki-Laki (Sisa) : "
                            + ConvertToRupiah ((iJthCucuLaki)) + "\n";
                }
                if (iJumlahCucuLaki > 0 && iJumlahCucuPerempuan == 0) {
                    iSisa = iHarta
                            - (iJthSuami * iJumlahSuami + iJthIstri
                            * iJumlahIstri + iJthIbu * iJumlahIbu
                            + iJthBapak * iJumlahBapak + iJthKakek
                            * iJumlahKakek + iJthNenekBapak
                            * iJumlahNenekBapak + iJthNenekIbu
                            * iJumlahNenekIbu + iJthNenekKakek
                            * iJumlahNenekKakek + iJthAnakPerempuan);
                    iJthCucuLaki = iSisa / iJumlahCucuLaki;
                    resultToPrint += "Jatah tiap Cucu Laki-laki (Sisa) : "
                            + ConvertToRupiah ((iJthCucuLaki)) + "\n";
                }
                if (iJumlahCucuLaki == 0 && iJumlahCucuPerempuan == 0) {
                    iSisa = iHarta
                            - (iJthSuami * iJumlahSuami + iJthIstri
                            * iJumlahIstri + iJthIbu * iJumlahIbu
                            + iJthBapak * iJumlahBapak + iJthKakek
                            * iJumlahKakek + iJthNenekBapak
                            * iJumlahNenekBapak + iJthNenekIbu
                            * iJumlahNenekIbu + iJthNenekKakek
                            * iJumlahNenekKakek + iJthAnakPerempuan);
                    iJthBapak = iJthBapak + iSisa * iJumlahBapak;
                    iJthKakek = iJthKakek + iSisa * iJumlahKakek;
                    if (iJumlahBapak == 0 && iJumlahKakek == 0) {
                        if (iJumlahSaudaraKandung > 0) {
                            iSisa = iHarta
                                    - (iJthSuami * iJumlahSuami + iJthIstri
                                    * iJumlahIstri + iJthIbu
                                    * iJumlahIbu + iJthBapak
                                    * iJumlahBapak + iJthKakek
                                    * iJumlahKakek + iJthNenekBapak
                                    * iJumlahNenekBapak + iJthNenekIbu
                                    * iJumlahNenekIbu + iJthNenekKakek
                                    * iJumlahNenekKakek
                                    + iJthAnakPerempuan
                                    * iJumlahAnakPerempuan
                                    + iJthCucuPerempuan
                                    * iJumlahCucuPerempuan + iJthCucuLaki
                                    * iJumlahCucuLaki);
                            if (iJumlahSaudariKandung == 0) {
                                iJthSaudaraKandung = Math.round(iSisa
                                        / iJumlahSaudaraKandung);
                            }
                            if (iJumlahSaudariKandung > 0) {
                                iJthSaudaraKandung = Math
                                        .round(iSisa
                                                / (iJumlahSaudaraKandung + iJumlahSaudariKandung));
                                iJthSaudariKandung = iJthSaudaraKandung;
                                resultToPrint += "Jatah tiap Saudari Kandung (Sisa) : "
                                        + ConvertToRupiah ((iJthSaudariKandung)) + "\n";
                                if (iJumlahPutraSaudaraKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraSaudaraSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPriaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahWanitaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                            }
                            iSisa = iHarta
                                    - (iJthSuami + iJthIbu + iJthNenekBapak
                                    * iJumlahNenekBapak + iJthNenekIbu
                                    * iJumlahNenekIbu + iJthNenekKakek
                                    * iJumlahNenekKakek
                                    + iJthSaudaraSeibu
                                    + iJthSaudaraKandung
                                    * iJumlahSaudaraKandung + iJthSaudariKandung
                                    * iJumlahSaudariKandung);
                            resultToPrint += "Jatah tiap Saudara Kandung (Sisa) : "
                                    + ConvertToRupiah ((iJthSaudaraKandung)) + "\n";
                            if (iJumlahSaudaraSebapak > 0)
                                resultToPrint += "Jatah tiap Saudara Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahSaudaraSebapak > 0)
                                resultToPrint += "Jatah tiap Saudara Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPutraSaudaraKandung > 0)
                                resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPutraSaudaraSebapak > 0)
                                resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPamanKandung > 0)
                                resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPamanSebapak > 0)
                                resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPutraPamanKandung > 0)
                                resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPutraPamanSebapak > 0)
                                resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPriaMerdekakan > 0)
                                resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahWanitaMerdekakan > 0)
                                resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahSaudariSebapak > 0)
                                resultToPrint += "Jatah tiap Saudari Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                        }
                        if (iJumlahSaudaraKandung == 0) {
                            if (iJumlahSaudariKandung > 1) {
                                iJthSaudariKandung = Math.round(2 * iHarta / 3);
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek
                                        + iJthSaudaraSeibu + iJthSaudariKandung
                                        * iJumlahSaudariKandung);
                                resultToPrint += "Jatah tiap Saudari Kandung (2/3) : "
                                        + ConvertToRupiah ((iJthSaudariKandung / iJumlahSaudariKandung))
                                        + "\n";
                                if (iJumlahSaudariSebapak > 0) {
                                    resultToPrint += "Jatah tiap Saudari Sebapak : 0(Karena dihalangi 2 Saudari Kandung atau lebih)"
                                            + "\n";
                                }
                                if (iJumlahPutraSaudaraKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraSaudaraSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPriaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahWanitaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                            }
                            if (iJumlahSaudariKandung == 1) {
                                iJthSaudariKandung = Math.round(iHarta / 2);
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek
                                        + iJthSaudaraSeibu + iJthSaudariKandung
                                        * iJumlahSaudariKandung);
                                resultToPrint += "Jatah tiap Saudari Kandung (1/2) : "
                                        + ConvertToRupiah ((iJthSaudariKandung / iJumlahSaudariKandung))
                                        + "\n";
                                if (iJumlahSaudariSebapak > 0) {
                                    resultToPrint += "Jatah tiap Saudari Sebapak : 0(Karena dihalangi Saudari Kandung)"
                                            + "\n";
                                }
                                if (iJumlahPutraSaudaraKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraSaudaraSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPriaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahWanitaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                            }
                            if (iJumlahSaudaraSebapak > 0) {
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek + iJthSaudaraSeibu);
                                iJthSaudaraSebapak = Math.round(iSisa
                                        / iJumlahSaudaraSebapak);
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek
                                        + iJthSaudaraSeibu + iJthSaudaraSebapak
                                        * iJumlahSaudaraSebapak);
                                resultToPrint += "Jatah tiap Saudara Sebapak (Sisa) : "
                                        + ConvertToRupiah ((iJthSaudaraSebapak)) + "\n";
                            }
                        }
                    }
                }
                iSisa = iHarta
                        - (iJthSuami * iJumlahSuami + iJthIstri * iJumlahIstri
                        + iJthIbu * iJumlahIbu + iJthBapak
                        * iJumlahBapak + iJthKakek * iJumlahKakek
                        + iJthNenekBapak * iJumlahNenekBapak
                        + iJthNenekIbu * iJumlahNenekIbu
                        + iJthNenekKakek * iJumlahNenekKakek
                        + iJthAnakPerempuan * iJumlahAnakPerempuan
                        + iJthCucuPerempuan * iJumlahCucuPerempuan
                        + iJthCucuLaki * iJumlahCucuLaki + iJthSaudaraKandung
                        * iJumlahSaudaraKandung);
            }
            if (iJumlahAnakPerempuan >= 2) {
                iJthAnakPerempuan = Math.round((2 * iHarta)
                        / (3 * iJumlahAnakPerempuan));
                iSisa = iHarta
                        - (iJthSuami * iJumlahSuami + iJthIstri * iJumlahIstri
                        + iJthIbu * iJumlahIbu + iJthBapak
                        * iJumlahBapak + iJthKakek * iJumlahKakek
                        + iJthNenekBapak * iJumlahNenekBapak
                        + iJthNenekIbu * iJumlahNenekIbu
                        + iJthNenekKakek * iJumlahNenekKakek + iJthAnakPerempuan
                        * iJumlahAnakPerempuan);
                if (iJumlahCucuPerempuan > 0)
                    resultToPrint += "Jatah tiap Cucu Perempuan : 0 (karena dihalangi oleh >= 2 Anak Perempuan)"
                            + "\n";
                if (iJumlahCucuLaki > 0) {
                    iJthCucuLaki = iSisa / iJumlahCucuLaki;
                    resultToPrint += "Jatah tiap Cucu Laki-Laki (Sisa) : "
                            + ConvertToRupiah ((iJthCucuLaki)) + "\n";
                }
                iJthBapak = iJthBapak + iSisa * iJumlahBapak;
                if (iJumlahBapak == 0) {
                    if (iJumlahKakek > 0) {
                        iJthKakek = iJthKakek + iSisa * iJumlahKakek;
                    }
                    if (iJumlahKakek == 0) {
                        if (iJumlahSaudaraKandung > 0) {
                            iSisa = iHarta
                                    - (iJthSuami * iJumlahSuami + iJthIstri
                                    * iJumlahIstri + iJthIbu
                                    * iJumlahIbu + iJthBapak
                                    * iJumlahBapak + iJthKakek
                                    * iJumlahKakek + iJthNenekBapak
                                    * iJumlahNenekBapak + iJthNenekIbu
                                    * iJumlahNenekIbu + iJthNenekKakek
                                    * iJumlahNenekKakek
                                    + iJthAnakPerempuan
                                    * iJumlahAnakPerempuan
                                    + iJthCucuPerempuan
                                    * iJumlahCucuPerempuan + iJthCucuLaki
                                    * iJumlahCucuLaki);
                            iJthSaudaraKandung = Math.round(iSisa
                                    / iJumlahSaudaraKandung);
                            iSisa = iHarta
                                    - (iJthSuami * iJumlahSuami + iJthIstri
                                    * iJumlahIstri + iJthIbu
                                    * iJumlahIbu + iJthBapak
                                    * iJumlahBapak + iJthKakek
                                    * iJumlahKakek + iJthNenekBapak
                                    * iJumlahNenekBapak + iJthNenekIbu
                                    * iJumlahNenekIbu + iJthNenekKakek
                                    * iJumlahNenekKakek
                                    + iJthAnakPerempuan
                                    * iJumlahAnakPerempuan
                                    + iJthCucuPerempuan
                                    * iJumlahCucuPerempuan
                                    + iJthCucuLaki * iJumlahCucuLaki + iJthSaudaraKandung
                                    * iJumlahSaudaraKandung);
                            resultToPrint += "Jatah tiap Saudara Kandung (Sisa) : "
                                    + ConvertToRupiah ((iJthSaudaraKandung)) + "\n";
                            if (iJumlahSaudaraSebapak > 0)
                                resultToPrint += "Jatah tiap Saudara Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahSaudaraSebapak > 0)
                                resultToPrint += "Jatah tiap Saudara Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPutraSaudaraKandung > 0)
                                resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPutraSaudaraSebapak > 0)
                                resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPamanKandung > 0)
                                resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPamanSebapak > 0)
                                resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPutraPamanKandung > 0)
                                resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPutraPamanSebapak > 0)
                                resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahPriaMerdekakan > 0)
                                resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahWanitaMerdekakan > 0)
                                resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                            if (iJumlahSaudariSebapak > 0)
                                resultToPrint += "Jatah tiap Saudari Sebapak : 0 (Karena dihalangi Saudara Sekandung)"
                                        + "\n";
                        }
                        if (iJumlahSaudaraKandung == 0) {
                            if (iJumlahSaudariKandung > 1) {
                                iJthSaudariKandung = Math.round(2 * iHarta / 3);
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek
                                        + iJthSaudaraSeibu + iJthSaudariKandung
                                        * iJumlahSaudariKandung);
                                resultToPrint += "Jatah tiap Saudari Kandung (2/3) : "
                                        + ConvertToRupiah ((iJthSaudariKandung / iJumlahSaudariKandung))
                                        + "\n";
                                if (iJumlahSaudariSebapak > 0) {
                                    resultToPrint += "Jatah tiap Saudari Sebapak : 0(Karena dihalangi 2 Saudari Kandung atau lebih)"
                                            + "\n";
                                }
                                if (iJumlahPutraSaudaraKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraSaudaraSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPriaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahWanitaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                            }
                            if (iJumlahSaudariKandung == 1) {
                                iJthSaudariKandung = Math.round(iHarta / 2);
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek
                                        + iJthSaudaraSeibu + iJthSaudariKandung
                                        * iJumlahSaudariKandung);
                                resultToPrint += "Jatah tiap Saudari Kandung (1/2) : "
                                        + ConvertToRupiah ((iJthSaudariKandung / iJumlahSaudariKandung))
                                        + "\n";
                                if (iJumlahSaudariSebapak > 0) {
                                    resultToPrint += "Jatah tiap Saudari Sebapak : 0(Karena dihalangi Saudari Kandung)"
                                            + "\n";
                                }
                                if (iJumlahPutraSaudaraKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraSaudaraSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanKandung > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPutraPamanSebapak > 0)
                                    resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahPriaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                                if (iJumlahWanitaMerdekakan > 0)
                                    resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sekandung)"
                                            + "\n";
                            }
                            if (iJumlahSaudaraSebapak > 0) {
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek + iJthSaudaraSeibu);
                                iJthSaudaraSebapak = Math.round(iSisa
                                        / iJumlahSaudaraSebapak);
                                iSisa = iHarta
                                        - (iJthSuami + iJthIbu + iJthNenekBapak
                                        * iJumlahNenekBapak
                                        + iJthNenekIbu
                                        * iJumlahNenekIbu
                                        + iJthNenekKakek
                                        * iJumlahNenekKakek
                                        + iJthSaudaraSeibu + iJthSaudaraSebapak
                                        * iJumlahSaudaraSebapak);
                                resultToPrint += "Jatah tiap Saudara Sebapak (Sisa) : "
                                        + ConvertToRupiah ((iJthSaudaraSebapak)) + "\n";
                            }
                        }
                    }
                }
            }
            if (iJumlahSaudaraSeibu > 0)
                resultToPrint += "Jatah tiap Saudara Seibu : 0 (karena dihalangi oleh Anak Perempuan)"
                        + "\n";
            if (iJumlahSaudariSeibu > 0) {
                resultToPrint += "Jatah tiap Saudari Seibu : 0 (karena dihalangi oleh Anak Perempuan)"
                        + "\n";
            }
            if (iJumlahSaudariSebapak > 0 && iJumlahSaudariKandung == 0) {
                iSisa = iHarta
                        - (iJthSuami + iJthIbu + iJthCucuPerempuan
                        + iJthNenekBapak * iJumlahNenekBapak
                        + iJthNenekIbu * iJumlahNenekIbu
                        + iJthNenekKakek * iJumlahNenekKakek
                        + iJthSaudaraSeibu + iJthSaudariKandung
                        * iJumlahSaudariKandung + iJthSaudaraSebapak
                        * iJumlahSaudaraSebapak);
                iJthSaudariSebapak = Math.round(iSisa / iJumlahSaudariSebapak);
                iSisa = iHarta
                        - (iJthSuami + iJthIbu + iJthCucuPerempuan
                        + iJthNenekBapak * iJumlahNenekBapak
                        + iJthNenekIbu * iJumlahNenekIbu
                        + iJthNenekKakek * iJumlahNenekKakek
                        + iJthSaudaraSeibu + iJthSaudariKandung
                        * iJumlahSaudariKandung + iJthSaudaraSebapak
                        * iJumlahSaudaraSebapak + iJthSaudariSebapak
                        * iJumlahSaudariSebapak);
                resultToPrint += "Jatah tiap Saudari Sebapak (Sisa) : "
                        + ConvertToRupiah ((iJthSaudariSebapak / iJumlahSaudariSebapak)) + "\n";
                if (iJumlahPutraSaudaraKandung > 0)
                    resultToPrint += "Jatah tiap Putra dari Saudara Kandung : 0 (Karena dihalangi Saudari Sebapak)"
                            + "\n";
                if (iJumlahPutraSaudaraSebapak > 0)
                    resultToPrint += "Jatah tiap Putra dari Saudara Sebapak : 0 (Karena dihalangi Saudari Sebapak)"
                            + "\n";
                if (iJumlahPamanKandung > 0)
                    resultToPrint += "Jatah tiap Paman Sekandung : 0 (Karena dihalangi Saudari Sebapak)"
                            + "\n";
                if (iJumlahPamanSebapak > 0)
                    resultToPrint += "Jatah tiap Paman Sebapak : 0 (Karena dihalangi Saudari Sebapak)"
                            + "\n";
                if (iJumlahPutraPamanKandung > 0)
                    resultToPrint += "Jatah tiap Putra dari Paman Kandung : 0 (Karena dihalangi Saudari Sebapak)"
                            + "\n";
                if (iJumlahPutraPamanSebapak > 0)
                    resultToPrint += "Jatah tiap Putra dari Paman Sebapak : 0 (Karena dihalangi Saudari Sebapak)"
                            + "\n";
                if (iJumlahPriaMerdekakan > 0)
                    resultToPrint += "Jatah tiap Pria yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sebapak)"
                            + "\n";
                if (iJumlahWanitaMerdekakan > 0)
                    resultToPrint += "Jatah tiap Wanita yang Memerdekakan Budak : 0 (Karena dihalangi Saudari Sebapak)"
                            + "\n";
            }
            iSisa = iHarta
                    - (iJthSuami * iJumlahSuami + iJthIstri * iJumlahIstri
                    + iJthIbu * iJumlahIbu + iJthBapak * iJumlahBapak
                    + iJthKakek * iJumlahKakek + iJthNenekBapak
                    * iJumlahNenekBapak + iJthNenekIbu
                    * iJumlahNenekIbu + iJthNenekKakek
                    * iJumlahNenekKakek + iJthAnakLaki
                    * iJumlahAnakLaki + iJthAnakPerempuan
                    * iJumlahAnakPerempuan + iJthCucuPerempuan
                    * iJumlahCucuPerempuan + iJthCucuLaki
                    * iJumlahCucuLaki + iJthSaudaraKandung
                    * iJumlahSaudaraKandung);
        }

        if (iJumlahBapak == 0) {
            if (iJumlahKakek > 0) {
                if (iJumlahAnakLaki > 0) {
                    resultToPrint += "Jatah Kakek (1" + "/"
                            + Math.round(iHarta / iJthKakek) + "): "
                            + ConvertToRupiah ((iJthKakek)) + "\n";
                }
                if (iJumlahAnakLaki == 0 && iJumlahAnakPerempuan > 0) {
                    resultToPrint += "Jatah Kakek (1/6+Sisa): " + ConvertToRupiah ((iJthKakek))
                            + "\n";
                }
                if (iJumlahAnakLaki == 0 && iJumlahAnakPerempuan == 0) {
                    resultToPrint += "Jatah Kakek (Sisa): " + ConvertToRupiah ((iJthKakek))
                            + "\n";
                }
            }
        }
        if (iJumlahSuami > 0)
            resultToPrint += "Jatah Suami (1" + "/"
                    + Math.round(iHarta / iJthSuami) + "): " + ConvertToRupiah ((iJthSuami))
                    + "\n";
        if (iJumlahIstri > 0)
            resultToPrint += "Jatah tiap Istri (1" + "/"
                    + Math.round((iHarta) / (iJthIstri * iJumlahIstri)) + "): "
                    + ConvertToRupiah ((iJthIstri)) + "\n";
        if (iJumlahAnakLaki > 0)
            resultToPrint += "Jatah tiap Anak Laki-laki (Sisa) : "
                    + ConvertToRupiah ((iJthAnakLaki)) + "\n";
        if (iJumlahAnakPerempuan > 0 && iJumlahAnakLaki > 0)
            resultToPrint += "Jatah tiap Anak Perempuan (Sisa): "
                    + ConvertToRupiah((iJthAnakPerempuan)) + "\n";
        if (iJumlahAnakPerempuan == 1 && iJumlahAnakLaki == 0)
            resultToPrint += "Jatah tiap Anak Perempuan (1/2): "
                    + ConvertToRupiah((iJthAnakPerempuan)) + "\n";
        if (iJumlahAnakPerempuan > 1 && iJumlahAnakLaki == 0)
            resultToPrint += "Jatah tiap Anak Perempuan (2/3): "
                    + ConvertToRupiah((iJthAnakPerempuan)) + "\n";
        if (iJumlahBapak > 0) {
            if (iJumlahAnakLaki > 0) {
                resultToPrint += "Jatah Bapak (1" + "/"
                        + Math.round(iHarta / iJthBapak) + "): "
                        + ConvertToRupiah((iJthBapak)) + "\n";
            }
            if (iJumlahAnakLaki == 0 && iJumlahAnakPerempuan > 0) {
                resultToPrint += "Jatah Bapak (1/6+Sisa): " + ConvertToRupiah ((iJthBapak))
                        + "\n";
            }
            if (iJumlahAnakLaki == 0 && iJumlahAnakPerempuan == 0) {
                resultToPrint += "Jatah Bapak (Sisa): " + ConvertToRupiah ((iJthBapak)) + "\n";
            }
            if (iJumlahKakek > 0)
                resultToPrint += "Jatah Kakek : 0 (karena dihalangi oleh Bapak)"
                        + "\n";
        }
        if (iJumlahIbu > 0) {
            resultToPrint += "Jatah Ibu (1" + "/"
                    + Math.round(iHarta / iJthIbu) + "): " + ConvertToRupiah ((iJthIbu)) + "\n";
            if (iJumlahNenekBapak > 0)
                resultToPrint += "Jatah Nenek (Ibunya Bapak) : 0 (karena dihalangi oleh Ibu)"
                        + "\n";
            if (iJumlahNenekIbu > 0)
                resultToPrint += "Jatah Nenek (Ibunya Ibu) : 0 (karena dihalangi oleh Ibu)"
                        + "\n";
            if (iJumlahNenekKakek > 0)
                resultToPrint += "Jatah Nenek (Ibunya Kakek) : 0 (karena dihalangi oleh Ibu)"
                        + "\n";
        }
        if (iJumlahIbu == 0) {
            if (iJumlahNenekIbu > 0 && iJumlahNenekBapak > 0) {
                resultToPrint += "Jatah Nenek (Ibunya Bapak) (1/6) : "
                        + ConvertToRupiah ((iJthNenekBapak)) + "\n";
                resultToPrint += "Jatah Nenek (Ibunya Ibu) (1/6) : "
                        + ConvertToRupiah ((iJthNenekIbu)) + "\n";
                if (iJumlahNenekKakek > 0)
                    resultToPrint += "Jatah Nenek (Ibunya Kakek) : 0 (karena dihalangi oleh Ibunya Bapak dan Ibunya Ibu)"
                            + "\n";
            }
            if (iJumlahNenekBapak > 0 && iJumlahNenekIbu == 0) {
                resultToPrint += "Jatah Nenek (Ibunya Bapak) (1/6) : "
                        + ConvertToRupiah(iJthNenekBapak) + "\n";
                if (iJumlahNenekKakek > 0)
                    resultToPrint += "Jatah Nenek (Ibunya Kakek) : 0 (karena dihalangi oleh Nenek (Ibunya Bapak))"
                            + "\n";
            }
            if (iJumlahNenekIbu > 0 && iJumlahNenekBapak == 0) {
                resultToPrint += "Jatah Nenek (Ibunya Ibu) (1/6) : "
                        + ConvertToRupiah (iJthNenekIbu) + "\n";
                if (iJumlahNenekKakek > 0)
                    resultToPrint += "Jatah Nenek (Ibunya Kakek) : 0 (karena dihalangi oleh Nenek (Ibunya Ibu))"
                            + "\n";
            }
            if (iJumlahNenekBapak == 0 && iJumlahNenekIbu == 0) {
                if (iJumlahNenekKakek > 0)
                    resultToPrint += "Jatah Nenek (Ibunya Kakek) (1/6) : "
                            + ConvertToRupiah(iJthNenekKakek) + "\n";
            }
        }
        if (iSisa > 0)
            resultToPrint += "\nSisa untuk kerabat terdekat : " + ConvertToRupiah(iSisa);
        if ((iHarta + 1) < (iJthSuami + iJthSaudariKandung + iJthSaudariSebapak - 1)) {
            alert("Perhatian",
                    "Hasil perhitungan berikut termasuk masalah 'Aul (jumlah keseluruhan bagian ditambah hingga penyebutnya sama dengan pembilangnya). Contoh: suami =1/2 dan 2 org saudari kandung 2/3. Jika dijumlahkan hasilnya menjadi 7/6. Maka penyebutnya menjadi 7. suami dapat 3/7 dan 2 saudari kandung 4/7.");
        }
        tx_hasil.setText(resultToPrint);
    }

    private String ConvertToRupiah(int value){
        String curr = "Rp. ";
        NumberFormat currFormat = NumberFormat.getInstance(Locale.GERMANY);
        String endCurr = ",00";

        String rupiah = curr + currFormat.format(value) + endCurr;
        return  rupiah;
    }

    private String ConvertToRupiah(long value){
        String curr = "Rp. ";
        NumberFormat currFormat = NumberFormat.getInstance(Locale.GERMANY);
        String endCurr = ",00";

        String rupiah = curr + currFormat.format(value) + endCurr;
        return  rupiah;
    }

    public void alert(String dialog, String content) {
        AlertDialog alertDialog = new AlertDialog.Builder(HitungHasil.this).create();
        alertDialog.setTitle(dialog);
        alertDialog.setMessage(content);
        alertDialog.show();
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}