package com.echoman.leaderboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.echoman.leaderboard.R;
import com.echoman.leaderboard.databinding.IqListItemBinding;
import com.echoman.leaderboard.pojo.IqLeaders;

import java.util.ArrayList;
import java.util.List;

public class IqAdapter extends RecyclerView.Adapter<IqAdapter.PostViewHolder> {
    private List<IqLeaders> iqList = new ArrayList<>();
private Context mContext;
    public IqAdapter(Context context, List<IqLeaders> iqLeadersList) {
        this.iqList=iqLeadersList;
        this.mContext=context;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        IqListItemBinding binding=DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.iq_list_item
        ,parent,false);

        return new PostViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        final IqLeaders iqLeaders= iqList.get(position);
        holder.binding.setIqleader(iqLeaders);
        holder.binding.executePendingBindings();

//        holder.nameTV.setText(iqList.get(position).getName());
//        holder.hoursTV.setText(String.valueOf(iqList.get(position).getScore()));
//        holder.countryTV.setText(iqList.get(position).getCountry());
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

        IqListItemBinding binding;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

//        public PostViewHolder(@NonNull View itemView) {
//            super(itemView);
//            nameTV = itemView.findViewById(R.id.textView_myname);
//            hoursTV = itemView.findViewById(R.id.textview_hours);
//            countryTV = itemView.findViewById(R.id.textview_country);
//        }
    }
}
