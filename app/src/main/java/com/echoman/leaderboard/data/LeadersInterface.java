package com.echoman.leaderboard.data;

import com.echoman.leaderboard.pojo.IqLeaders;
import com.echoman.leaderboard.pojo.LearningLeaders;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface LeadersInterface {
    @GET("api/hours")
    public Observable<List<LearningLeaders>> getLearner();

    @GET("/api/skilliq")
    public Observable<List<IqLeaders>> getIqLeaders();

    @Headers("Accept: text/html")
    @FormUrlEncoded
    @POST()
    public Observable<Response<ResponseBody>>submit(
            @Url String url,
            @Field("entry.1877115667") String firstName,
            @Field("entry.2006916086") String lastName,
            @Field("entry.1824927963") String email,
            @Field("entry.284483984") String gitLink


    );
}
