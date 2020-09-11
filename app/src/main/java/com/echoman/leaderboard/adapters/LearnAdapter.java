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
import com.echoman.leaderboard.databinding.LearnerListItemBinding;
import com.echoman.leaderboard.pojo.LearningLeaders;

import java.util.ArrayList;
import java.util.List;

public class LearnAdapter extends RecyclerView.Adapter<LearnAdapter.PostViewHolder> {
    private List<LearningLeaders> learnerList = new ArrayList<>();
    private Context mContext;

    public LearnAdapter(Context context, List<LearningLeaders> learningLeadersList) {
        this.learnerList=learningLeadersList;
        this.mContext=context;
    }


    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LearnerListItemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(mContext),
                R.layout.learner_list_item,parent,false);
        return new PostViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        LearningLeaders learner= learnerList.get(position);
        holder.mBinding.setLearner(learner);
//        holder.nameTV.setText(learnerList.get(position).getName());
//        holder.hoursTV.setText(String.valueOf(learnerList.get(position).getHours()));
//        holder.countryTV.setText(learnerList.get(position).getCountry());
    }

    @Override
    public int getItemCount() {
        return learnerList.size();
    }

    public void setList(List<LearningLeaders> moviesList) {
        this.learnerList = moviesList;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView nameTV, hoursTV, countryTV;
        LearnerListItemBinding mBinding;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            mBinding= DataBindingUtil.bind(itemView);
//
//            nameTV = itemView.findViewById(R.id.textView_myname);
//            hoursTV = itemView.findViewById(R.id.textview_hours);
//            countryTV = itemView.findViewById(R.id.textview_country);
        }
    }
}
