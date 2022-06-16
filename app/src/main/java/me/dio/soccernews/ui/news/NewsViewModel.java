package me.dio.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import me.dio.soccernews.diman.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        this.news = new MutableLiveData<>();

        List<News> news = new ArrayList<>();
        news.add(new News("top","dkjsdkskd"));
        news.add(new News("top","dkjsdkskd"));
        news.add(new News("top","dkjsdkskd"));
        news.add(new News("top","dkjsdkskd"));
        news.add(new News("top","dkjsdkskd"));
        this.news.setValue(news);
    }

    public LiveData<List<News>> getNews() {
        return this.news;
    }
}