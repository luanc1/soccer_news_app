package me.dio.soccernews.data;

import java.util.List;

import me.dio.soccernews.diman.News;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public interface SoccerNewsAPI {


    @GET("news.json")
    Call<List<News>> getNews();
    //region Constantes
    /*private static final String REMOTE_API_URL = "https://luanc1.github.io/soccer-news-api/";
    private static final String LOCAL_DB_NAME = "soccer-news";*/
    //endregion

    //region Atributos: encapsulam o acesso a nossa API (Retrofit) e banco de dados local (Room).
    /*private SoccerNewsApi remoteApi;
    */

    /*public SoccerNewsApi getRemoteApi() {
        return remoteApi;
    }*/

    /*public SoccerNewsDb getLocalDb() {
        return localDb;
    }*/
    //endregion

    //region Singleton: garante uma instância única dos atributos relacionados ao Retrofit e Room.
   /* private SoccerNewsRepository () {
        remoteApi = new Retrofit.Builder()
                .baseUrl(REMOTE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SoccerNewsApi.class);

        localDb = Room.databaseBuilder(App.getInstance(), SoccerNewsDb.class, LOCAL_DB_NAME).build();
    }

    /*public static SoccerNewsRepository getInstance() {
        return LazyHolder.INSTANCE;
    }*/

   /* private static class LazyHolder {
        private static final SoccerNewsRepository INSTANCE = new SoccerNewsRepository();
    }*/
    //endregion
}
