package me.dio.soccernews.ui.favorites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import me.dio.soccernews.MainActivity;
import me.dio.soccernews.databinding.FragmentFavoritesBinding;
import me.dio.soccernews.diman.News;
import me.dio.soccernews.ui.news.adapter.MeusAdapter;


public class FavoritesFragment extends Fragment {

    private FragmentFavoritesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FavoritesViewModel dashboardViewModel =
                new ViewModelProvider(this).get(FavoritesViewModel.class);

        binding = FragmentFavoritesBinding.inflate(inflater, container, false);
       // View root = binding.getRoot();

        loadfindFavoritesNews();

        // final TextView textView = binding.textFavorites;
        //dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return binding.getRoot();
    }

    private void loadfindFavoritesNews() {
        MainActivity activity = (MainActivity) getActivity();

        if (activity != null) {
            List<News>  favoriteNews = activity.getDb().newsDao().loadFavoriteNews();
            binding.rvnews.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.rvnews.setAdapter(new MeusAdapter(favoriteNews, updatedNews ->{
                activity.getDb().newsDao().save(updatedNews);
                loadfindFavoritesNews();

            }));
            }



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}