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
import com.echoman.leaderboard.adapters.IqAdapter;
import com.echoman.leaderboard.databinding.FragmentTwoBinding;
import com.echoman.leaderboard.pojo.IqLeaders;

import java.util.List;


public class IqFragment extends Fragment {

    private LeadersViewModel mLearnerViewModel;
    private RecyclerView iq_list_view;
    public ProgressBar mProgressBar;
    private FragmentTwoBinding mBinding;

    public IqFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_two, container, false);
//        mProgressBar = view.findViewById(R.id.progressBar3);

        mBinding = FragmentTwoBinding.inflate(inflater, container, false);
        mLearnerViewModel = new ViewModelProvider(requireActivity()).get(LeadersViewModel.class);
        mLearnerViewModel.getIqLeaders();
        //     iq_list_view = view.findViewById(R.id.skil_recycler);
//        final IqAdapter iqAdapter = new IqAdapter();
//        iq_list_view.setLayoutManager(new LinearLayoutManager(getContext()));
//        iq_list_view.setAdapter(iqAdapter);


        mLearnerViewModel.iqsMutableLiveData.observe(getViewLifecycleOwner(), new Observer<List<IqLeaders>>() {
            @Override
            public void onChanged(List<IqLeaders> iqLeaders) {

                mBinding.setMyiqleaders(iqLeaders);
                mBinding.progressBar3.setVisibility(View.GONE);
            }
        });

        return mBinding.getRoot();
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