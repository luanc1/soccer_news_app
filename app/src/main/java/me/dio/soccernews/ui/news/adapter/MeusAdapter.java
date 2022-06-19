package me.dio.soccernews.ui.news.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import me.dio.soccernews.R;
import me.dio.soccernews.databinding.NewsItemBinding;
import me.dio.soccernews.diman.News;

public class MeusAdapter extends RecyclerView.Adapter<MeusAdapter.ViewHolder>{

    private List<News> news;
    private  final NewsListener favoritesListener;
//Pega  a lista de noticias
    public  MeusAdapter(List<News> news, NewsListener favoritesListener){

        this.news = news;
        this.favoritesListener = favoritesListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NewsItemBinding binding = NewsItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        News  news = this.news.get(position);
          holder.binding.tvTitle.setText(news.title);
          holder.binding.tvDescription.setText(news.descritption);

        holder.binding.btOpenLink.setOnClickListener(view ->{
              Intent i = new Intent(Intent.ACTION_VIEW);
              i.setData(Uri.parse(news.link));
              context.startActivity(i);
          });
          //implementando a funcionalidade do compartilhamento
        holder.binding.ivShare.setOnClickListener(view ->{
            //Share text:
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, news.title);
            i.putExtra(Intent.EXTRA_TEXT,news.link);
            context.startActivity(Intent.createChooser(i, "Share via"));
        });
        //implementando o botão favoritos
        holder.binding.ivFavorite.setOnClickListener(view ->{
            news.favorites = !news.favorites;
            this.favoritesListener.onFavorites(news);
            notifyItemChanged(position);
        });
         if(news.favorites){
             holder.binding.ivFavorite.setColorFilter(context.getResources().getColor(R.color.favorite));
         }else{
             holder.binding.ivFavorite.setColorFilter(context.getResources().getColor(R.color.inative));
         }


          Picasso.get().load(news.image)
                  .fit()
                  .into(holder.binding.ivThumbnail);
    }

    @Override
    public int getItemCount() {
        return this.news.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        private final NewsItemBinding binding;

        public ViewHolder(NewsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


    }
    public interface NewsListener {
       void onFavorites(News news);
    }
}
