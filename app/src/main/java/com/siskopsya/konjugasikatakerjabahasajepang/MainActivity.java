package com.siskopsya.konjugasikatakerjabahasajepang;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import com.siskopsya.konjugasikatakerjabahasajepang.db.DBHelper;
import com.siskopsya.konjugasikatakerjabahasajepang.db.DBModel;
import com.siskopsya.konjugasikatakerjabahasajepang.db.Konjugasi;
import com.siskopsya.konjugasikatakerjabahasajepang.db.KonjugasiAdapter;
import com.siskopsya.konjugasikatakerjabahasajepang.db.KonjugasiDBHelper;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView konjugasi_list;
    KonjugasiDBHelper dbHelper;
    DBHelper db;
    int sukses=0;
    List<DBModel> dbList;
    private List<Konjugasi> listKonjugasi = new ArrayList<Konjugasi>();
    private KonjugasiAdapter adapter;
    SharedPreferences sharedpreferences;
    Boolean db_insert;
    SearchView cari;
    Button aboutUs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //db = dbHelper.getReadableDatabase();
        db = new DBHelper(this);
        sharedpreferences = getSharedPreferences("konjugasikatakerjabahasajepang", Context.MODE_PRIVATE);
        db_insert = sharedpreferences.getBoolean("db_insert", false);
        System.out.println("Main jumlah data "+ db_insert);
        if(db_insert){

        }else{
            try {
                InputStream is = getAssets().open("konjugasi_data.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(is);
                Element element=doc.getDocumentElement();
                element.normalize();

                NodeList nList = doc.getElementsByTagName("konjugasi");
                System.out.println("Main jumlah data "+ nList.getLength());
                for (int i=0; i<nList.getLength(); i++) {
                    Node node = nList.item(i);
                    System.out.println(node.getNodeType() +" sa,a "+ Node.ELEMENT_NODE);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element2 = (Element) nList.item(i);
                        int id= Integer.parseInt(getValue("id",element2));
                        String kata = getValue("kata",element2);
                        String kanji = getValue("kanji",element2);
                        String masu_positif=getValue("masu_positif",element2);
                        String masu_negatif=getValue("masu_negatif",element2);
                        String mashita_positif=getValue("mashita_positif",element2);
                        String mashita_negatif=getValue("mashita_negatif",element2);
                        String te_positif=getValue("te_positif",element2);
                        String te_negatif=getValue("te_negatif",element2);
                        String tai_positif=getValue("tai_positif",element2);
                        String tai_negatif=getValue("tai_negatif",element2);
                        String mashou_positif=getValue("mashou_positif",element2);
                        String mashou_negatif=getValue("mashou_negatif",element2);
                        String kamus_positif=getValue("kamus_positif",element2);
                        String kamus_negatif=getValue("kamus_negatif",element2);
                        String ta_positif=getValue("ta_positif",element2);
                        String ta_negatif=getValue("ta_negatif",element2);
                        String tara_positif=getValue("tara_positif",element2);
                        String tara_negatif=getValue("tara_negatif",element2);
                        String potensial_positif=getValue("potensial_positif",element2);
                        String potensial_negatif=getValue("potensial_negatif",element2);
                        String ajakan_positif=getValue("ajakan_positif",element2);
                        String ajakan_negatif=getValue("ajakan_negatif",element2);
                        String perintah_positif=getValue("perintah_positif",element2);
                        String perintah_negatif=getValue("perintah_negatif",element2);
                        String  larangan_positif=getValue("larangan_positif",element2);
                        String  larangan_negatif=getValue("larangan_negatif",element2);
                        String ba_positif=getValue("ba_positif",element2);
                        String ba_negatif=getValue("ba_negatif",element2);
                        String pasif_positif=getValue("pasif_positif",element2);
                        String pasif_negatif=getValue("pasif_negatif",element2);
                        db.insertIntoDB(id,kata,kanji,masu_positif,masu_negatif,mashita_positif,
                                mashita_negatif,te_positif,te_negatif,tai_positif,tai_negatif,mashou_positif,mashou_negatif,kamus_positif,
                                kamus_negatif,ta_positif,ta_negatif,tara_positif,tara_negatif,potensial_positif,
                                potensial_negatif,ajakan_positif,ajakan_negatif,perintah_positif,perintah_negatif,
                                larangan_positif,larangan_negatif,ba_positif,ba_negatif,pasif_positif,pasif_negatif);
                        sukses++;
                    }
                }
            } catch (Exception e) {e.printStackTrace();}
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean("db_insert", true);
            editor.commit();
        }
        /*Konjugasi student1 = new Konjugasi(1, "Ahmad", "Haha","",""
                ,"","","","","","","",""
                ,"","","","","","","",""
                ,"","","","","","","",""
                ,"","","",2);
        db.addPlayer(student1);

        konjugasi_list = (RecyclerView) findViewById(R.id.rc_hasil);
        //listKonjugasi.addAll(db.allPlayers());
        adapter = new KonjugasiAdapter(this, listKonjugasi);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        konjugasi_list.setLayoutManager(mLayoutManager);
        //konjugasi_list.setItemAnimator(new DefaultItemAnimator());
        //DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), VERTICAL);
        //konjugasi_list.addItemDecoration(decoration);
        konjugasi_list.setAdapter(adapter);*/
        dbList= new ArrayList<DBModel>();
        System.out.println("jeje "+ sukses);
        dbList = db.getDataFromDB();
        konjugasi_list =  findViewById(R.id.rc_hasil);
        adapter = new KonjugasiAdapter(this, dbList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        konjugasi_list.setLayoutManager(mLayoutManager);
        //konjugasi_list.setItemAnimator(new DefaultItemAnimator());
        //DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), VERTICAL);
        //konjugasi_list.addItemDecoration(decoration);
        konjugasi_list.setAdapter(adapter);
        ///////////////////////////
        cari = findViewById(R.id.cari_input);
        cari.setQueryHint("Cari Konjugasi");
        cari.onActionViewExpanded();
        cari.setIconified(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                cari.clearFocus();
            }
        }, 300);
        cari.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        aboutUs = findViewById(R.id.btn_about);
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AboutUs.class);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onDestroy() {
        db.close();
        super.onDestroy();
    }
    private static String getValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}
