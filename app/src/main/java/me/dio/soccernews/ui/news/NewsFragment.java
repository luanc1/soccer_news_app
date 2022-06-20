package me.dio.soccernews.ui.news;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import com.google.android.material.snackbar.Snackbar;

import me.dio.soccernews.MainActivity;
import me.dio.soccernews.R;
import me.dio.soccernews.data.local.AppDatabase;
import me.dio.soccernews.databinding.FragmentNewsBinding;
import me.dio.soccernews.ui.news.adapter.MeusAdapter;

public class NewsFragment extends Fragment {

    private FragmentNewsBinding binding;
    private NewsViewModel newsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NewsViewModel homeViewModel =
                new ViewModelProvider(this).get(NewsViewModel.class);

        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        binding.rvnews.setLayoutManager(new LinearLayoutManager(getContext()));

       // final TextView textView = binding.textNews;
        homeViewModel.getNews().observe(getViewLifecycleOwner(), news ->{
            binding.rvnews.setAdapter(new MeusAdapter(news, NewsViewModel::saveNews));
        });

        homeViewModel.getState().observe(getViewLifecycleOwner(), state -> {
            switch (state) {
                case DOING:
                    binding.srlNews.setRefreshing(true);
                    break;
                case DONE:
                    binding.srlNews.setRefreshing(false);
                    break;
                case ERROR:
                    binding.srlNews.setRefreshing(false);
                    Snackbar.make(binding.srlNews, R.string.error_network, Snackbar.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}