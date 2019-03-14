package com.example.taskrestapi.adapterMatch;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taskrestapi.HasilPojoMatch.TeamsItem;
import com.example.taskrestapi.R;
import com.squareup.picasso.Picasso;

import java.util.List;

class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {
    Context context;
    List<TeamsItem> datalist;
    public MatchAdapter(Context context, List<TeamsItem> data) {
        this.context = context;
        this.datalist = data;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_match_fragment, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.tvNamaClub.setText(datalist.get(i).getStrTeam());
        Picasso.get().load(datalist.get(i).getStrTeamLogo ()).into(viewHolder.imgGambar);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailTeams.class);
                intent.putExtra("detail", datalist.get(i).getStrDescriptionEN());
                intent.putExtra("namaClub", datalist.get(i).getStrTeam());
                intent.putExtra("gambar", datalist.get(i).getStrTeamBadge());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgGambar;
        TextView tvNamaClub;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgGambar = itemView.findViewById(R.id.img_club);
            tvNamaClub = itemView.findViewById(R.id.tv_club);
        }
    }
}
