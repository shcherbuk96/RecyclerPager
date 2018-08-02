package com.example.yauheni_shcharbuk.asd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;

import com.example.yauheni_shcharbuk.asd.Adapters.RecyclerAdapterTwo;

public class TwoActivity extends AppCompatActivity {

    static final String EXIT_POSITION = "EXIT_POSITION";
    RecyclerView recyclerView;
    RecyclerAdapterTwo recyclerAdapterTwo;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        supportPostponeEnterTransition();

        Bundle extras = getIntent().getExtras();
        int pos = extras.getInt(MainActivity.EXTRA_KEY);

        recyclerView = findViewById(R.id.recycler_view_two);
        linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.setLayoutManager(linearLayoutManager);
//        getResources().getString(R.string.image_count, pos, ImageData.IMAGE_DRAWABLES.length)

        recyclerAdapterTwo = new RecyclerAdapterTwo(this);

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        recyclerView.setAdapter(recyclerAdapterTwo);
        recyclerView.scrollToPosition(pos);
    }

    @Override
    public void onBackPressed() {
        setResult();
        finish();
    }

    public void setResult() {
        final Intent intent = new Intent();
        intent.putExtra(EXIT_POSITION, linearLayoutManager.findFirstCompletelyVisibleItemPosition());
        setResult(RESULT_OK, intent);
    }

}
