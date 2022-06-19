package me.dio.soccernews.ui.news;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import java.util.List;

import me.dio.soccernews.data.SoccerNewsAPI;
import me.dio.soccernews.data.local.AppDatabase;
import me.dio.soccernews.diman.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

public class NewsViewModel extends ViewModel {
    public enum State {
        DOING, DONE, ERROR;
    }
    private final MutableLiveData<List<News>> news = new MutableLiveData<>();
    private final MutableLiveData<State> state = new MutableLiveData<>();
    private final SoccerNewsAPI api;
    //private final  AppDatabase db;
    public NewsViewModel() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://luanc1.github.io/soccer-news-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(SoccerNewsAPI.class);

      //  db = Room.databaseBuilder(app, AppDatabase.class, "database-name").build();


        this.findViews();

    }

    private void findViews() {
        state.setValue(State.DOING);
        api.getNews().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if (response.isSuccessful()) {
                    news.setValue(response.body());
                    state.setValue(State.DONE);
                } else {
                    state.setValue(State.ERROR);
                }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                t.printStackTrace();
                state.setValue(State.ERROR);
            }
        });
    }

    public LiveData<List<News>> getNews() {

        return this.news;
    }
    public LiveData<State> getState() {
        return this.state;
    }
}