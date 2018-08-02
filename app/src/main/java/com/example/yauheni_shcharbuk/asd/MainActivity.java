package com.example.yauheni_shcharbuk.asd;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.example.yauheni_shcharbuk.asd.Adapters.RecyclerAdapter;


public class MainActivity extends AppCompatActivity implements RecyclerAdapter.Listener {
    public static final String EXTRA_KEY = "Pos";
    public static final String TRANSITION = "Transition";
    public static final String EXTRA_VIEW = "View";
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recycler_view);

        recyclerAdapter = new RecyclerAdapter(this);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onItemClick(final int pos, ImageView imageView) {
        Intent intent = new Intent(this, TwoActivity.class);
        intent.putExtra(EXTRA_KEY, pos);
        intent.putExtra(EXTRA_VIEW, ViewCompat.getTransitionName(imageView));

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                imageView,
                ViewCompat.getTransitionName(imageView));

        startActivityForResult(intent, 999,options.toBundle());
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            int exitPos = data.getIntExtra(TwoActivity.EXIT_POSITION, 0);
            recyclerView.scrollToPosition(exitPos);
        }
    }
}
