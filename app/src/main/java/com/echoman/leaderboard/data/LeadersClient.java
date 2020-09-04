package com.echoman.leaderboard.data;

import com.echoman.leaderboard.pojo.IqLeaders;
import com.echoman.leaderboard.pojo.LearningLeaders;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LeadersClient {
    private static final String BASE_URL = "https://gadsapi.herokuapp.com/";
    private static final String BASE_URL2 = "https://docs.google.com/forms/d/e/";
    private LeadersInterface mLeadersInterface;
    private static LeadersClient INSTANCE,INSTANCE2;
    Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    public LeadersClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        mLeadersInterface = retrofit.create(LeadersInterface.class);
    }

    public static LeadersClient getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new LeadersClient();
        }
        return INSTANCE;
    }

    public Observable<List<LearningLeaders>> getLearners(){
        return mLeadersInterface.getLearner();
    }

    public Observable<List<IqLeaders>> getIq(){
        return mLeadersInterface.getIqLeaders();
    }

    public Observable<Response<ResponseBody>>sendData(String first, String second, String mail, String link)
    {
        return  mLeadersInterface.submit(
            "https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse",
            first,
            second,
            mail,
            link

    );
    }

}
