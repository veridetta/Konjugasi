package com.siskopsya.konjugasikatakerjabahasajepang.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class KonjugasiDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Konjugasi.db";
    public KonjugasiDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersio, int newVersion) {

        db.execSQL(DELETE_USER_TABLE);
        onCreate(db);

    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String CREATE_USER_TABLE = "CREATE TABLE " + KonjugasiDB.KonjugasiDatabase.TABLE_NAME +
            "( " + KonjugasiDB.KonjugasiDatabase.id + " INTEGER PRIMARY KEY," +
            KonjugasiDB.KonjugasiDatabase.kata + " text," +
    KonjugasiDB.KonjugasiDatabase.kanji + " text," +
    KonjugasiDB.KonjugasiDatabase.masu_positif + " text," +
    KonjugasiDB.KonjugasiDatabase.masu_negatif + " text)";
    private static final String DELETE_USER_TABLE = "DROP TABLE IF EXISTS " + KonjugasiDB.KonjugasiDatabase.TABLE_NAME;
    public List<Konjugasi> allPlayers() {
        List<Konjugasi> students = new ArrayList<>();
        String selectQuery = "SELECT  * FROM STUDENT";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Konjugasi student = new Konjugasi(1,"","","","",
                        "","","","","","",
                        "","","","","",
                        "","","","","",
                        "","","","","",
                        "","","","","","",
                        2);
                student.setId(cursor.getInt(0));
                student.setName(cursor.getString(1));
                student.setKanji(cursor.getString(2));
                students.add(student);
            } while (cursor.moveToNext());
        }

        db.close();
        return students;
    }
}