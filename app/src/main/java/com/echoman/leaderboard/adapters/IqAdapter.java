package com.echoman.leaderboard.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.echoman.leaderboard.R;
import com.echoman.leaderboard.pojo.IqLeaders;

import java.util.ArrayList;
import java.util.List;

public class IqAdapter extends RecyclerView.Adapter<IqAdapter.PostViewHolder> {
    private List<IqLeaders> iqList = new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.iq_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.nameTV.setText(iqList.get(position).getName());
        holder.hoursTV.setText(String.valueOf(iqList.get(position).getScore()));
        holder.countryTV.setText(iqList.get(position).getCountry());
    }

    @Override
    public int getItemCount() {
        return iqList.size();
    }

    public void setList(List<IqLeaders> moviesList) {
        this.iqList = moviesList;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView nameTV, hoursTV, countryTV;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.textView_myname);
            hoursTV = itemView.findViewById(R.id.textview_hours);
            countryTV = itemView.findViewById(R.id.textview_country);
        }
    }
}
