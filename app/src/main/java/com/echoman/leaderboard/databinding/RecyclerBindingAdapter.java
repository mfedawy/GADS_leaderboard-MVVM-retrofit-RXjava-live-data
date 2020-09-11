package com.echoman.leaderboard.databinding;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.echoman.leaderboard.adapters.IqAdapter;
import com.echoman.leaderboard.adapters.LearnAdapter;
import com.echoman.leaderboard.pojo.IqLeaders;
import com.echoman.leaderboard.pojo.LearningLeaders;

import java.util.List;

class RecyclerBindingAdapter {

    @BindingAdapter("setLearners")
    public static void setLearnerList(RecyclerView recyclerView, List<LearningLeaders> learningLeadersList){

        if(learningLeadersList == null){
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if(layoutManager == null){
          recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));

           // recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 1));
        }
        LearnAdapter adapter = (LearnAdapter) recyclerView.getAdapter();
        if(adapter == null){
            adapter = new LearnAdapter(recyclerView.getContext(),learningLeadersList);
            recyclerView.setAdapter(adapter);
            adapter.setList(learningLeadersList);

        }

    }
    @BindingAdapter("setIqleaders")
    public static void setiqList(RecyclerView recyclerView, List<IqLeaders> iqLeadersList){

        if(iqLeadersList == null){
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if(layoutManager == null){
          recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));

           // recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 1));
        }
        IqAdapter adapter = (IqAdapter) recyclerView.getAdapter();

        if(adapter == null){
            adapter = new IqAdapter(recyclerView.getContext(),iqLeadersList);
            recyclerView.setAdapter(adapter);
            adapter.setList(iqLeadersList);

        }

    }

}
