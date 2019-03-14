package com.example.taskrestapi;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.taskrestapi.HasilPojoPertandingan.EventsItem;

import java.util.List;

class PertandinganAdapter extends RecyclerView.Adapter<PertandinganAdapter.ViewHolderrr> {
    List<EventsItem> eventsItems;
    Context context;
    public PertandinganAdapter(Context context, List<EventsItem> eventsItems) {
        this.context = context;
        this.eventsItems = eventsItems;
    }

    @NonNull
    @Override
    public ViewHolderrr onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_layout_pertandingan, viewGroup, false);
        return new ViewHolderrr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderrr viewHolderrr, final int i) {
        viewHolderrr.tv1.setText(eventsItems.get(i).getStrEvent());
        viewHolderrr.tv2.setText(eventsItems.get(i).getStrFilename());
        viewHolderrr.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, detail_pertandingan.class);
                intent.putExtra("event", eventsItems.get(i).getStrEvent());
                intent.putExtra("filename", eventsItems.get(i).getStrFilename());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return eventsItems.size();
    }

    public class ViewHolderrr extends RecyclerView.ViewHolder {
        TextView tv1, tv2;
        public ViewHolderrr(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv_pertandingan);
            tv2 = itemView.findViewById(R.id.tv_pertandingan2);
        }
    }
}
