package com.example.yauheni_shcharbuk.asd.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.yauheni_shcharbuk.asd.Data.ImageData;
import com.example.yauheni_shcharbuk.asd.R;
import com.example.yauheni_shcharbuk.asd.TwoActivity;

public class RecyclerAdapterTwo extends RecyclerView.Adapter<RecyclerAdapterTwo.ViewHolder> {

    //    private List<Photo> photos;
//    private Listener listener;

//    public RecyclerAdapter(List<Photo> photos, Listener listener) {
//        this.photos = photos;
//        this.listener = listener;
//    }

    private Activity activity;

    public RecyclerAdapterTwo(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        final View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_two, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.text.setText(activity.getResources().getString(R.string.image_count, i+1, ImageData.IMAGE_DRAWABLES.length));

        Glide
                .with(viewHolder.image.getContext())
                .load(ImageData.IMAGE_DRAWABLES[i])
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable final GlideException e, final Object model, final Target<Drawable> target, final boolean isFirstResource) {
                        activity.startPostponedEnterTransition();

                        return false;
                    }

                    @Override
                    public boolean onResourceReady(final Drawable resource, final Object model, final Target<Drawable> target, final DataSource dataSource, final boolean isFirstResource) {
                        activity.startPostponedEnterTransition();

                        return false;
                    }
                })
                .into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return ImageData.IMAGE_DRAWABLES.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView text;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.text_two);
            image = itemView.findViewById(R.id.image_two);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {

                }
            });
        }
    }
}

