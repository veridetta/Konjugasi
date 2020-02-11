package com.siskopsya.konjugasikatakerjabahasajepang;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.siskopsya.konjugasikatakerjabahasajepang.db.DBHelper;
import com.siskopsya.konjugasikatakerjabahasajepang.db.DBModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {
    List<DBModel> dbList;
    String id;
    Intent intent;
    ImageView bunyi;
    private TextToSpeech textToSpeech;
    DBHelper db;
    TextView kanji, kata, masu_positif, masu_negatif,mashita_positif,mashita_negatif,
            te_positif,te_negatif,tai_positif,tai_negatif,mashou_positif,mashou_negatif,kamus_positif,
            kamus_negatif,ta_positif,ta_negatif,tara_positif,tara_negatif,potensial_positif,
            potensial_negatif,ajakan_positif,ajakan_negatif,perintah_positif,perintah_negatif,
            larangan_positif,larangan_negatif,ba_positif,ba_negatif,pasif_positif,pasif_negatif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        intent=getIntent();
        db = new DBHelper(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        bunyi=findViewById(R.id.bunyi);
        id = intent.getStringExtra("id");
        kanji = findViewById(R.id.txt_kanji);
        kata = findViewById(R.id.kata);
        masu_positif = findViewById(R.id.masu_positif);
        masu_negatif = findViewById(R.id.masu_negatif);
        mashita_positif = findViewById(R.id.mashita_positif);
        mashita_negatif = findViewById(R.id.mashita_negatif);
        te_positif = findViewById(R.id.te_positif);
        te_negatif = findViewById(R.id.te_negatif);
        tai_positif = findViewById(R.id.tai_positif);
        tai_negatif = findViewById(R.id.tai_negatif);
        mashou_positif = findViewById(R.id.mashou_positif);
        mashou_negatif = findViewById(R.id.mashou_negatif);
        kamus_positif = findViewById(R.id.kamus_positif);
        kamus_negatif = findViewById(R.id.kamus_negatif);
        ta_positif = findViewById(R.id.ta_positif);
        ta_negatif = findViewById(R.id.ta_negatif);
        tara_positif = findViewById(R.id.tara_positif);
        tara_negatif = findViewById(R.id.tara_negatif);
        potensial_positif = findViewById(R.id.potensial_positif);
        potensial_negatif = findViewById(R.id.potensial_negatif);
        ajakan_positif = findViewById(R.id.ajakan_positif);
        ajakan_negatif = findViewById(R.id.ajakan_negatif);
        perintah_positif = findViewById(R.id.perintah_positif);
        perintah_negatif = findViewById(R.id.perintah_negatif);
        larangan_positif = findViewById(R.id.larangan_positif);
        larangan_negatif = findViewById(R.id.larangan_negatif);
        ba_positif = findViewById(R.id.ba_positif);
        ba_negatif = findViewById(R.id.ba_negatif);
        pasif_positif = findViewById(R.id.pasif_positif);
        pasif_negatif = findViewById(R.id.pasif_negatif);

        dbList= new ArrayList<DBModel>();
        dbList = db.getSingleData(id);
        kanji.setText(dbList.get(0).getKanji());
        kata.setText(dbList.get(0).getName());
        masu_positif.setText(dbList.get(0).getMasu_positif());
        masu_negatif.setText(dbList.get(0).getMasu_negatif());
        mashita_positif.setText(dbList.get(0).getMashita_positif());
        mashita_negatif.setText(dbList.get(0).getMashita_negatif());
        te_positif.setText(dbList.get(0).getTe_positif());
        te_negatif.setText(dbList.get(0).getTe_negatif());
        tai_positif.setText(dbList.get(0).getTai_positif());
        tai_negatif.setText(dbList.get(0).getTai_negatif());
        mashou_positif.setText(dbList.get(0).getMashou_positif());
        mashou_negatif.setText(dbList.get(0).getMashou_negatif());
        kamus_positif.setText(dbList.get(0).getKamus_positif());
        kamus_negatif.setText(dbList.get(0).getKamus_negatif());
        ta_positif.setText(dbList.get(0).getTa_positif());
        ta_negatif.setText(dbList.get(0).getTa_negatif());
        tara_positif.setText(dbList.get(0).getTara_positif());
        tara_negatif.setText(dbList.get(0).getTara_negatif());
        potensial_positif.setText(dbList.get(0).getPotensial_positif());
        potensial_negatif.setText(dbList.get(0).getPotensial_negatif());
        ajakan_positif.setText(dbList.get(0).getAjakan_positif());
        ajakan_negatif.setText(dbList.get(0).getAjakan_negatif());
        perintah_positif.setText(dbList.get(0).getPerintah_positif());
        perintah_negatif.setText(dbList.get(0).getPerintah_negatif());
        larangan_positif.setText(dbList.get(0).getLarangan_positif());
        larangan_negatif.setText(dbList.get(0).getLarangan_negatif());
        ba_positif.setText(dbList.get(0).getBa_positif());
        ba_negatif.setText(dbList.get(0).getBa_negatif());
        pasif_positif.setText(dbList.get(0).getPasif_positif());
        pasif_negatif.setText(dbList.get(0).getPasif_negatif());

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int ttsLang = textToSpeech.setLanguage(Locale.JAPAN);

                    if (ttsLang == TextToSpeech.LANG_MISSING_DATA
                            || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "The Language is not supported!");
                    } else {
                        Log.i("TTS", "Language Supported.");
                    }
                    Log.i("TTS", "Initialization success.");
                } else {
                    Toast.makeText(getApplicationContext(), "TTS Initialization failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bunyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TTS", "button clicked: " + dbList.get(0).getKanji());
                int speechStatus = textToSpeech.speak(dbList.get(0).getKanji(), TextToSpeech.QUEUE_FLUSH, null);

                if (speechStatus == TextToSpeech.ERROR) {
                    Log.e("TTS", "Error in converting Text to Speech!");
                }
            }
        });
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }

}
