package com.siskopsya.konjugasikatakerjabahasajepang.db;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.siskopsya.konjugasikatakerjabahasajepang.R;

import java.util.List;

public class KonjugasiAdapter extends RecyclerView.Adapter<KonjugasiAdapter.MyViewHolder> {

    private Context context;
    private List<Konjugasi> notesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtKanji;
        public TextView txtIndo;
        public LinearLayout ly_menu;

        public MyViewHolder(View view) {
            super(view);
            txtKanji = view.findViewById(R.id.card_kanji);
            txtIndo = view.findViewById(R.id.card_kata);
            ly_menu = view.findViewById(R.id.card_menu);
        }
    }


    public KonjugasiAdapter(Context context, List<Konjugasi> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.konjugasi_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Konjugasi student = notesList.get(position);

        holder.txtKanji.setText(student.getKanji());
        holder.txtIndo.setText(student.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, student.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }
}