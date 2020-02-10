package com.siskopsya.konjugasikatakerjabahasajepang;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.siskopsya.konjugasikatakerjabahasajepang.db.KonjugasiDB;
import com.siskopsya.konjugasikatakerjabahasajepang.db.KonjugasiDBHelper;

public class MainActivity extends AppCompatActivity {

    RecyclerView konjugasi_list;
    KonjugasiDBHelper dbHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        dbHelper = new KonjugasiDBHelper(this);
        db = dbHelper.getReadableDatabase();
        konjugasi_list = (RecyclerView) findViewById(R.id.rc_hasil);


    }
    @Override
    protected void onDestroy() {
        db.close();
        super.onDestroy();
    }
}
