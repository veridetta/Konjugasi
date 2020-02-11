package com.siskopsya.konjugasikatakerjabahasajepang.db;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.siskopsya.konjugasikatakerjabahasajepang.DetailActivity;
import com.siskopsya.konjugasikatakerjabahasajepang.R;

import java.util.ArrayList;
import java.util.List;

public class KonjugasiAdapter extends RecyclerView.Adapter<KonjugasiAdapter.MyViewHolder> {

    private Context context;
    List<DBModel> notesList, konjugasi;
    CustomFilter filter;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtKanji, txtId;
        public TextView txtIndo;
        public CardView ly_menu;

        public MyViewHolder(View view) {
            super(view);
            txtKanji = view.findViewById(R.id.card_kanji);
            txtIndo = view.findViewById(R.id.card_kata);
            txtId = view.findViewById(R.id.txt_id);
            ly_menu = view.findViewById(R.id.card_menu);
        }
    }


    public KonjugasiAdapter(Context context, List<DBModel> notesList) {
        this.context = context;
        this.notesList = notesList;
        this.konjugasi = notesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.konjugasi_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final DBModel student = notesList.get(position);
        holder.txtKanji.setText(student.getKanji());
        holder.txtIndo.setText(student.getName());
        holder.txtId.setText(student.getId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, student.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("id", student.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public Filter getFilter() {
        if(filter==null)
        {
            filter=new CustomFilter((ArrayList<DBModel>) konjugasi,this);
        }

        return filter;
    }
}