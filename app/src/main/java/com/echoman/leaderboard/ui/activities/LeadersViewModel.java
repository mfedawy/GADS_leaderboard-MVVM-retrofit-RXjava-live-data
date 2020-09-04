package com.echoman.leaderboard.ui.activities;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.echoman.leaderboard.data.LeadersClient;
import com.echoman.leaderboard.pojo.IqLeaders;
import com.echoman.leaderboard.pojo.LearningLeaders;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LeadersViewModel extends ViewModel {
    MutableLiveData<List<LearningLeaders>> learnersMutableLiveData = new MutableLiveData<>();
    MutableLiveData<List<IqLeaders>> iqsMutableLiveData = new MutableLiveData<>();
    private static final String TAG = "LeadersViewModel";

    public void getAllLearners() {
        Observable observable = LeadersClient.getINSTANCE().getLearners()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer observer = new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(Object o) {

                learnersMutableLiveData.setValue((List<LearningLeaders>) o);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "errror: " + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);


    }

    public void getIqLeaders() {
        Observable observable = LeadersClient.getINSTANCE().getIq()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer observer = new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(Object o) {

                iqsMutableLiveData.setValue((List<IqLeaders>) o);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "errror: " + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);


    }

    @Override
    protected void onCleared() {
        super.onCleared();

    }
}
