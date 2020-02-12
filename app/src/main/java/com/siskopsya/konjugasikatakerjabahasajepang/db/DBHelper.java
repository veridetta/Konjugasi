package com.siskopsya.konjugasikatakerjabahasajepang.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="konjugasi";
    private static final int DATABASE_VERSION = 1;
    private static final String STUDENT_TABLE = "konjugasi";
    private static final String STU_TABLE = "create table "+STUDENT_TABLE +"(id int primary key,kata TEXT ,kanji TEXT ,masu_positif TEXT" +
            " ,masu_negatif TEXT ,mashita_positif TEXT ,mashita_negatif TEXT ,te_positif TEXT ,te_negatif TEXT ,tai_positif TEXT ," +
            "tai_negatif TEXT ,mashou_positif TEXT ,mashou_negatif TEXT ,kamus_positif TEXT" +
            " ,kamus_negatif TEXT ,ta_positif TEXT ,ta_negatif TEXT ,tara_positif TEXT ,tara_negatif TEXT ," +
            "potensial_positif TEXT ,potensial_negatif TEXT ,ajakan_positif TEXT ,ajakan_negatif TEXT ," +
            "perintah_positif TEXT" + " ,perintah_negatif TEXT ,larangan_positif TEXT ,larangan_negatif TEXT ,ba_positif TEXT ," +
            "ba_negatif TEXT ,pasif_positif TEXT, pasif_negatif TEXT  )";
    public final static String DATABASE_PATH = "/data/data/com.siskopsya.konjugasikatakerjabahasajepang/databases/";

    Context context;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(STU_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);

        // Create tables again
        onCreate(db);
    }
    /* Insert into database*/
    public void insertIntoDB(int id, String kata, String kanji, String masu_positif, String masu_negatif,
                             String mashita_positif,
                             String mashita_negatif,String te_positif,String te_negatif,String tai_positif,
                             String tai_negatif,String mashou_positif,String mashou_negatif,String kamus_positif,
                             String kamus_negatif,String ta_positif,String ta_negatif,String tara_positif,String tara_negatif,
                             String potensial_positif,String potensial_negatif,String ajakan_positif,
                             String ajakan_negatif,String perintah_positif,String perintah_negatif,String larangan_positif,
                             String larangan_negatif,String ba_positif,String ba_negatif,String pasif_positif, String pasif_negatif){
        Log.d("insert", "before insert");

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("kata", kata);
        values.put("kanji", kanji);
        values.put("masu_positif", masu_positif);values.put("masu_negatif", masu_negatif);
        values.put("mashita_positif", mashita_positif);values.put("mashita_negatif", mashita_negatif);
        values.put("te_positif", te_positif);values.put("te_negatif", te_negatif);
        values.put("tai_positif", tai_positif);values.put("tai_negatif", tai_negatif);
        values.put("mashou_positif", mashou_positif);values.put("mashou_negatif", mashou_negatif);
        values.put("kamus_positif", kamus_positif);values.put("kamus_negatif", kamus_negatif);
        values.put("ta_positif", ta_positif);values.put("ta_negatif", ta_negatif);
        values.put("tara_positif", tara_positif);values.put("tara_negatif", tara_negatif);
        values.put("potensial_positif", potensial_positif);values.put("potensial_negatif", potensial_negatif);
        values.put("ajakan_positif", ajakan_positif);values.put("ajakan_negatif", ajakan_negatif);
        values.put("perintah_positif", perintah_positif);values.put("perintah_negatif", perintah_negatif);
        values.put("larangan_positif", larangan_positif);values.put("larangan_negatif", larangan_negatif);
        values.put("ba_positif", ba_positif);values.put("ba_negatif", ba_negatif);
        values.put("pasif_positif", pasif_positif);values.put("pasif_negatif", pasif_negatif);



        // 3. insert
        db.insert(STUDENT_TABLE, null, values);
        // 4. close
        db.close();
        Toast.makeText(context, "insert value", Toast.LENGTH_LONG);
        Log.i("insert into DB", "After insert");
    }
    /* Retrive  data from database */
    public List<DBModel> getDataFromDB(){
        List<DBModel> modelList = new ArrayList<DBModel>();
        String query = "select * from "+STUDENT_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                DBModel model = new DBModel();
                model.setId(cursor.getString(0));
                model.setName(cursor.getString(1));
                model.setKanji(cursor.getString(2));
                model.setGabungan(cursor.getString(1)+" "+cursor.getString(2));
                modelList.add(model);
            }while (cursor.moveToNext());
        }


        Log.d("student data", modelList.toString());


        return modelList;
    }


    /*delete a row from database*/

    public void deleteARow(String email){
        SQLiteDatabase db= this.getWritableDatabase();
        db.delete(STUDENT_TABLE, "email" + " = ?", new String[] { email });
        db.close();
    }

    public List<DBModel> getSingleData(String idnya){
        List<DBModel> modelList = new ArrayList<DBModel>();
        String query = "select * from "+STUDENT_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * FROM konjugasi where id=?",new String[]{idnya});

        if (cursor.moveToFirst()){
            do {
                DBModel model = new DBModel();
                model.setId(cursor.getString(0));
                model.setName(cursor.getString(1));
                model.setKanji(cursor.getString(2));
                model.setMasu_positif(cursor.getString(3));
                model.setMasu_negatif(cursor.getString(4));
                model.setMashita_positif(cursor.getString(5));
                model.setMashita_negatif(cursor.getString(6));
                model.setTe_positif(cursor.getString(7));
                model.setTe_negatif(cursor.getString(8));
                model.setTai_positif(cursor.getString(9));
                model.setTai_negatif(cursor.getString(10));
                model.setMashou_positif(cursor.getString(11));
                model.setMashou_negatif(cursor.getString(12));
                model.setKamus_positif(cursor.getString(13));
                model.setKamus_negatif(cursor.getString(14));
                model.setTa_positif(cursor.getString(15));
                model.setTa_negatif(cursor.getString(16));
                model.setTara_positif(cursor.getString(17));
                model.setTara_negatif(cursor.getString(18));
                model.setPotensial_positif(cursor.getString(19));
                model.setPotensial_negatif(cursor.getString(20));
                model.setAjakan_positif(cursor.getString(21));
                model.setAjakan_negatif(cursor.getString(22));
                model.setPerintah_positif(cursor.getString(23));
                model.setPerintah_negatif(cursor.getString(24));
                model.setLarangan_positif(cursor.getString(25));
                model.setLarangan_negatif(cursor.getString(26));
                model.setBa_positif(cursor.getString(27));
                model.setBa_negatif(cursor.getString(28));
                model.setPasif_positif(cursor.getString(29));
                model.setPasif_negatif(cursor.getString(30));
                modelList.add(model);
            }while (cursor.moveToNext());
        }


        Log.d("student data", modelList.toString());


        return modelList;
    }

}