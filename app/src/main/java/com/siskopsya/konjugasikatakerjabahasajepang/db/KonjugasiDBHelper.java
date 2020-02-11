package com.siskopsya.konjugasikatakerjabahasajepang.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import static com.siskopsya.konjugasikatakerjabahasajepang.db.KonjugasiDB.KonjugasiDatabase.pasif_negatif;


public class KonjugasiDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Konjugasi.db";
    Context context;
    public KonjugasiDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
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
            KonjugasiDB.KonjugasiDatabase.masu_negatif + " text," +
            KonjugasiDB.KonjugasiDatabase.mashita_positif + " text," +
            KonjugasiDB.KonjugasiDatabase.mashita_negatif + " text," +
            KonjugasiDB.KonjugasiDatabase.te_positif + " text," +
            KonjugasiDB.KonjugasiDatabase.te_negatif + " text," +
            KonjugasiDB.KonjugasiDatabase.tai_positif + " text," +
            KonjugasiDB.KonjugasiDatabase.tai_negatif + " text," +
            KonjugasiDB.KonjugasiDatabase.mashou_positif + " text," +
            KonjugasiDB.KonjugasiDatabase.mashou_negatif + " text," +
            KonjugasiDB.KonjugasiDatabase.kamus_positif + " text," +
            KonjugasiDB.KonjugasiDatabase.kamus_negatif + " text," +
            KonjugasiDB.KonjugasiDatabase.ta_positif + " text," +
            KonjugasiDB.KonjugasiDatabase.ta_negatif + " text," +
            KonjugasiDB.KonjugasiDatabase.tara_positif + " text," +
            KonjugasiDB.KonjugasiDatabase.tara_negatif + " text," +
            KonjugasiDB.KonjugasiDatabase.potensial_positif + " text," +
            KonjugasiDB.KonjugasiDatabase.potensial_negatif + " text," +
            KonjugasiDB.KonjugasiDatabase.ajakan_positif + " text," +
            KonjugasiDB.KonjugasiDatabase.ajakan_negatif + " text," +
            KonjugasiDB.KonjugasiDatabase.perintah_positif + " text," +
            KonjugasiDB.KonjugasiDatabase.perintah_negatif + " text," +
            KonjugasiDB.KonjugasiDatabase.larangan_positif + " text," +
            KonjugasiDB.KonjugasiDatabase.larangan_negatif + " text," +
            KonjugasiDB.KonjugasiDatabase.ba_positif + " text," +
            KonjugasiDB.KonjugasiDatabase.ba_negatif + " text," +
            KonjugasiDB.KonjugasiDatabase.pasif_positif + " text," +
    pasif_negatif + " text)";
    private static final String DELETE_USER_TABLE = "DROP TABLE IF EXISTS " + KonjugasiDB.KonjugasiDatabase.TABLE_NAME;
    public List<Konjugasi> allPlayers() {
        List<Konjugasi> students = new ArrayList<>();
        String selectQuery = "SELECT  * FROM Konjugasi";
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
    private void populateGrocery(SQLiteDatabase db) {
        ArrayList<Konjugasi> groceryArrayList;
        groceryArrayList = buildGroceryArrayList();
        String insertStmt = null;
        for (int i = 0; i < groceryArrayList.size(); i++) {
            insertStmt = "INSERT INTO " + "Konjugasi" + " ("
                    + KonjugasiDB.KonjugasiDatabase.id  + ", "+ KonjugasiDB.KonjugasiDatabase.kata +", "
                    + KonjugasiDB.KonjugasiDatabase.kanji +", "
                    + KonjugasiDB.KonjugasiDatabase.masu_positif +", "+ KonjugasiDB.KonjugasiDatabase.masu_negatif +", "
                    + KonjugasiDB.KonjugasiDatabase.mashita_positif +", "+ KonjugasiDB.KonjugasiDatabase.mashita_negatif +", "
                    + KonjugasiDB.KonjugasiDatabase.te_positif +", "+ KonjugasiDB.KonjugasiDatabase.te_negatif +", "
                    + KonjugasiDB.KonjugasiDatabase.tai_positif +", "+ KonjugasiDB.KonjugasiDatabase.tai_negatif +", "
                    + KonjugasiDB.KonjugasiDatabase.mashou_positif +", "+ KonjugasiDB.KonjugasiDatabase.mashou_negatif +", "
                    + KonjugasiDB.KonjugasiDatabase.kamus_positif +", "+ KonjugasiDB.KonjugasiDatabase.kamus_negatif +", "
                    + KonjugasiDB.KonjugasiDatabase.ta_positif +", "+ KonjugasiDB.KonjugasiDatabase.ta_negatif +", "
                    + KonjugasiDB.KonjugasiDatabase.tara_positif +", "+ KonjugasiDB.KonjugasiDatabase.tara_negatif +", "
                    + KonjugasiDB.KonjugasiDatabase.potensial_positif +", "+ KonjugasiDB.KonjugasiDatabase.potensial_negatif +", "
                    + KonjugasiDB.KonjugasiDatabase.ajakan_positif +", "+ KonjugasiDB.KonjugasiDatabase.ajakan_negatif +", "
                    + KonjugasiDB.KonjugasiDatabase.perintah_positif +", "+ KonjugasiDB.KonjugasiDatabase.perintah_negatif +", "
                    + KonjugasiDB.KonjugasiDatabase.larangan_positif +", "+ KonjugasiDB.KonjugasiDatabase.larangan_negatif +", "
                    + KonjugasiDB.KonjugasiDatabase.ba_positif +", "+ KonjugasiDB.KonjugasiDatabase.ba_negatif +", "
                    + KonjugasiDB.KonjugasiDatabase.pasif_positif +", "
                    + pasif_negatif + ") "
                    + "VALUES (\""
                    + groceryArrayList.get(i).getId()
                    + "\", \"" + groceryArrayList.get(i).getName() +  "\", \"" + groceryArrayList.get(i).getKanji() +
                    "\", \"" + groceryArrayList.get(i).getMasu_positif() + "\", \"" + groceryArrayList.get(i).getMasu_negatif() +
                    "\", \"" + groceryArrayList.get(i).getMashita_positif() + "\", \"" + groceryArrayList.get(i).getMashita_negatif() +
                    "\", \"" + groceryArrayList.get(i).getTe_positif() + "\", \"" + groceryArrayList.get(i).getTe_negatif() +
                    "\", \"" + groceryArrayList.get(i).getTai_positif() + "\", \"" + groceryArrayList.get(i).getTai_negatif() +
                    "\", \"" + groceryArrayList.get(i).getMashou_positif() + "\", \"" + groceryArrayList.get(i).getMashou_negatif() +
                    "\", \"" + groceryArrayList.get(i).getKamus_positif() + "\", \"" + groceryArrayList.get(i).getKamus_negatif() +
                    "\", \"" + groceryArrayList.get(i).getTa_positif() + "\", \"" + groceryArrayList.get(i).getTa_negatif() +
                    "\", \"" + groceryArrayList.get(i).getTara_positif() + "\", \"" + groceryArrayList.get(i).getTara_negatif() +
                    "\", \"" + groceryArrayList.get(i).getPotensial_positif() + "\", \"" + groceryArrayList.get(i).getPotensial_negatif() +
                    "\", \"" + groceryArrayList.get(i).getAjakan_positif() + "\", \"" + groceryArrayList.get(i).getAjakan_negatif() +
                    "\", \"" + groceryArrayList.get(i).getPerintah_positif() + "\", \"" + groceryArrayList.get(i).getPerintah_negatif() +
                    "\", \"" + groceryArrayList.get(i).getLarangan_positif() + "\", \"" + groceryArrayList.get(i).getLarangan_negatif() +
                    "\", \"" + groceryArrayList.get(i).getBa_positif() + "\", \"" + groceryArrayList.get(i).getBa_negatif() +
                    "\", \"" + groceryArrayList.get(i).getPasif_positif() + "\", \"" + groceryArrayList.get(i).getPasif_negatif() +"\");";
            db.execSQL(insertStmt);
        }
    }
    public ArrayList<Konjugasi> buildGroceryArrayList() {
        ArrayList<Konjugasi> aL = new ArrayList<Konjugasi>();
        DocumentBuilderFactory factory = DocumentBuilderFactory
                .newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputStream raw = context.getAssets().open(
                    "default_grocerys.xml");
            Document dom = builder.parse(raw);
            Element root = dom.getDocumentElement();
            NodeList groceryItems = root.getElementsByTagName("grocery");
            for (int i = 0; i < groceryItems.getLength(); i++) {
                Integer id= null;
                String position=null;
                String kata= null, kanji=null, masu_positif=null, masu_negatif=null,
                        mashita_positif=null, mashita_negatif=null,
                        te_positif=null, te_negatif=null,
                        tai_positif=null, tai_negatif=null,
                        mashou_positif=null, mashou_negatif=null,
                        kamus_positif=null, kamus_negatif=null,
                        ta_positif=null, ta_negatif=null,
                        tara_positif=null, tara_negatif=null,
                        potensial_positif=null, potensial_negatif=null,
                        ajakan_positif=null, ajakan_negatif=null,
                        perintah_positif=null, perintah_negatif=null,
                        larangan_positif=null, larangan_negatif=null,
                        ba_positif=null, ba_negatif=null,
                        pasif_positif=null, pasif_negatif=null;
                Node item = groceryItems.item(i);
                NodeList groceryItem = item.getChildNodes();
                for (int j = 0; j < groceryItem.getLength(); j++) {
                    Node nodeItem= groceryItem.item(j);
                    String nodeName= nodeItem.getNodeName();
                    if (nodeName.equalsIgnoreCase("kata")) {
                        position=nodeItem.getFirstChild().getNodeValue();
                        id= Integer.valueOf(nodeItem.getFirstChild().getNodeValue());
                    } else if (nodeName.equalsIgnoreCase("kata")) {
                        kata= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("kanji")) {
                        kanji= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("masu_positif")) {
                        masu_positif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("masu_negatif")) {
                        masu_negatif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("mashita_positif")) {
                        mashita_positif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("mashita_negatif")) {
                        mashita_negatif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("te_positif")) {
                        te_positif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("te_negatif")) {
                        te_negatif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("tai_positif")) {
                        tai_positif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("tai_negatif")) {
                        tai_negatif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("mashou_positif")) {
                        mashou_positif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("mashou_negatif")) {
                        mashou_negatif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("kamus_positif")) {
                        kamus_positif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("kamus_negatif")) {
                        kamus_negatif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("ta_positif")) {
                        ta_positif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("ta_negatif")) {
                        ta_negatif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("tara_positif")) {
                        tara_positif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("tara_negatif")) {
                        tara_negatif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("potensial_positif")) {
                        potensial_positif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("potensial_negatif")) {
                        potensial_negatif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("ajakan_positif")) {
                        ajakan_positif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("ajakan_negatif")) {
                        ajakan_negatif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("perintah_positif")) {
                        perintah_positif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("perintah_negatif")) {
                        perintah_negatif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("larangan_positif")) {
                        larangan_positif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("larangan_negatif")) {
                        larangan_negatif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("ba_positif")) {
                        ba_positif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("ba_negatif")) {
                        ba_negatif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("pasif_positif")) {
                        pasif_positif= nodeItem.getFirstChild().getNodeValue();
                    } else if (nodeName.equalsIgnoreCase("pasif_negatif")) {
                        pasif_negatif= nodeItem.getFirstChild().getNodeValue();
                    }
                }
                aL.add(new Konjugasi(id,kata,kanji,masu_positif,masu_negatif,
                        mashita_positif,mashita_negatif,te_positif,te_negatif,
                        tai_positif,tai_negatif,mashou_positif,mashou_negatif,
                        kamus_positif,
                        kamus_negatif,ta_positif,ta_negatif,tara_positif,tara_negatif,
                        potensial_positif,potensial_negatif,ajakan_positif,
                        ajakan_negatif,perintah_positif,perintah_negatif,larangan_positif,
                        larangan_negatif,ba_positif,ba_negatif,
                        pasif_positif,pasif_negatif,position,2));
                Log.d("No","Berhasil"+groceryItems.getLength());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aL;
    }

}