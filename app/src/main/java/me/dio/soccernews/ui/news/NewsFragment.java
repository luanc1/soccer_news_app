package me.dio.soccernews.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import me.dio.soccernews.databinding.FragmentNewsBinding;
import me.dio.soccernews.ui.news.adapter.MeusAdapter;

public class NewsFragment extends Fragment {

    private FragmentNewsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NewsViewModel homeViewModel =
                new ViewModelProvider(this).get(NewsViewModel.class);

        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.rvnews.setLayoutManager(new LinearLayoutManager(getContext()));

       // final TextView textView = binding.textNews;
        homeViewModel.getNews().observe(getViewLifecycleOwner(), news ->{
            binding.rvnews.setAdapter(new MeusAdapter(news));

        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}