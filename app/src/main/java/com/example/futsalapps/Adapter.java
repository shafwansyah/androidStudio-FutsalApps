package com.example.futsalapps;

import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

    private Context context;
    private ArrayList<Model> arrayList;

    public Adapter(Context context, ArrayList<Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.row, viewGroup, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {

        Model model =arrayList.get(i);

        String id = model.getId();
        String name = model.getName();
        String time = model.getTime();
        String date = model.getDate();

        holder.showname.setText(name);
        holder.showdate.setText(date);
        holder.showtime.setText(time);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        TextView showname, showtime, showdate;

        public Holder(@NonNull View itemView) {
            super(itemView);

            showname = itemView.findViewById(R.id.showname);
            showtime = itemView.findViewById(R.id.showtime);
            showdate = itemView.findViewById(R.id.showdate);
        }
    }
}
