package com.echoman.leaderboard.ui.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.echoman.leaderboard.R;
import com.echoman.leaderboard.adapters.LearnAdapter;
import com.echoman.leaderboard.databinding.FragmentOneBinding;
import com.echoman.leaderboard.pojo.LearningLeaders;

import java.util.List;


public class LearnerFragment extends Fragment {

    private List<LearningLeaders> learner_list;

    private LeadersViewModel mLearnerViewModel;
    private RecyclerView learner_list_view;
    public ProgressBar mProgressBar;
private FragmentOneBinding mBinding;

    public LearnerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        mBinding = FragmentOneBinding.inflate(inflater,container,false);

        final View view = inflater.inflate(R.layout.fragment_one, container, false);

        //mProgressBar = view.findViewById(R.id.progressBar2);
        mLearnerViewModel = new ViewModelProvider(requireActivity()).get(LeadersViewModel.class);
        mLearnerViewModel.getAllLearners();


//        learner_list_view = view.findViewById(R.id.learning_recycler);
//        final LearnAdapter learnAdapter = new LearnAdapter();
//        learner_list_view.setLayoutManager(new LinearLayoutManager(getContext()));
//        learner_list_view.setAdapter(learnAdapter);

        mLearnerViewModel.learnersMutableLiveData.observe(getViewLifecycleOwner(), new Observer<List<LearningLeaders>>() {
            @Override
            public void onChanged(List<LearningLeaders> learningLeaders) {
                //learnAdapter.setList(learningLeaders);
               mBinding.learnersprogressBar2.setVisibility(View.GONE);

                mBinding.setMylearnerslist(learningLeaders);

            }
        });

        return mBinding.getRoot();
    }


    @Override
    public void onPause() {
        super.onPause();


    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
    }


}
