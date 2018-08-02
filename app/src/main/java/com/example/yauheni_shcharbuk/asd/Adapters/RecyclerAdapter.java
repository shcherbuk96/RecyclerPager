package com.example.yauheni_shcharbuk.asd.Adapters;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.yauheni_shcharbuk.asd.Data.ImageData;
import com.example.yauheni_shcharbuk.asd.MainActivity;
import com.example.yauheni_shcharbuk.asd.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    //    private List<Photo> photos;
    private Listener listener;

//    public RecyclerAdapter(List<Photo> photos, Listener listener) {
//        this.photos = photos;
//        this.listener = listener;
//    }


    public RecyclerAdapter(final Listener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        final View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_card, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        Glide
                .with(viewHolder.image.getContext())
                .load(ImageData.IMAGE_DRAWABLES[i])
                .into(viewHolder.image);

        ViewCompat.setTransitionName(viewHolder.image, MainActivity.TRANSITION + i);
    }

    @Override
    public int getItemCount() {
        return ImageData.IMAGE_DRAWABLES.length;
    }

//    public void updateAdapter(final List<Photo> photos) {
//        if (photos != null && photos.size() != 0) {
//            this.photos.clear();
//            this.photos.addAll(photos);
//            notifyDataSetChanged();
//        }
//
//    }
//
//    public void updateList(final List<Photo> photos) {
//        if (photos != null) {
//            this.photos.addAll(photos);
//            notifyDataSetChanged();
//        }
//
//    }

    public interface Listener {
        void onItemClick(int pos, ImageView imageView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image_one);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    Log.e("Click", "click");

                    if (listener != null) {
                        listener.onItemClick(getAdapterPosition(), image);
                    }
                }
            });
        }
    }
}
