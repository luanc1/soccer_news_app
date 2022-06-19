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

import me.dio.soccernews.MainActivity;
import me.dio.soccernews.data.local.AppDatabase;
import me.dio.soccernews.databinding.FragmentNewsBinding;
import me.dio.soccernews.ui.news.adapter.MeusAdapter;

public class NewsFragment extends Fragment {

    private FragmentNewsBinding binding;
    private  AppDatabase db;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NewsViewModel homeViewModel =
                new ViewModelProvider(this).get(NewsViewModel.class);

        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        binding.rvnews.setLayoutManager(new LinearLayoutManager(getContext()));

       // final TextView textView = binding.textNews;
        homeViewModel.getNews().observe(getViewLifecycleOwner(), news ->{
            binding.rvnews.setAdapter(new MeusAdapter(news, updatedNews ->{
                MainActivity activity = (MainActivity) getActivity();
                if (activity != null) {
                    activity.getDb().newsDao().save(updatedNews);
                }

            }));

        });

        homeViewModel.getState().observe(getViewLifecycleOwner(), state -> {
            switch (state) {
                case DOING:
                    //TODO: Iniciar SwipeRefreshLayout (loading).
                    break;
                case DONE:
                    //TODO: Finalizar SwipeRefreshLayout (loading).
                    break;
                case ERROR:
                    //TODO: Finalizar SwipeRefreshLayout (loading).
                    //TODO: Mostrar um erro genérico.
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