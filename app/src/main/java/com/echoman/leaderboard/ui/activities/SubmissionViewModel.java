package com.echoman.leaderboard.ui.activities;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.echoman.leaderboard.data.LeadersClient;
import com.echoman.leaderboard.pojo.IqLeaders;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmissionViewModel extends ViewModel {
    MutableLiveData<Integer> StatusMutableLiveData = new MutableLiveData<>();
    MutableLiveData<List<IqLeaders>> iqsMutableLiveData = new MutableLiveData<>();
    MutableLiveData<String> posts = new MutableLiveData<>();
    private static final String TAG = "submissionViewModel";


    public void Submit(String first, String second, String mail, String git) {

        Observable observable = LeadersClient.getINSTANCE().sendData(first, second, mail, git)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer observer=new Observer<Response<ResponseBody>>(){
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Response<ResponseBody> responseBodyResponse) {
                if (responseBodyResponse.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + responseBodyResponse.toString());
                    StatusMutableLiveData.setValue(1);
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                StatusMutableLiveData.setValue(-1);
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
