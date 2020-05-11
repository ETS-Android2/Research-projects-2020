package com.example.androidfirebasetutorial;


import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.androidfirebasetutorial.adapters.CardAdapter;
import com.example.androidfirebasetutorial.models.UserModel;
import com.example.androidfirebasetutorial.repository.UserLoader;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.*;

import java.util.ArrayList;


public class RealtimeActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar mToolbar;

    private static final String TAG = "MyActivity";
    FloatingActionButton mFab;

    RecyclerView mRecyclerView;

    private CardAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realtime);
        mToolbar = findViewById(R.id.recycler_view_layour_toolbar);
        mFab = findViewById(R.id.recycler_view_layour_fab);
        mRecyclerView = findViewById(R.id.recycler_view_layour_recycler);
        subscribeToRealTimeData();
        setupView();
        setupRecycler();
    }

    private void setupView() {
        setSupportActionBar(mToolbar);
        mFab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        UserLoader
                .fetch()
                .subscribe(o -> {
                    mAdapter.updateList((UserModel) o);
                    pushDataToDatabase((UserModel) o);
                });
    }

    private void setupRecycler() {

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new CardAdapter(new ArrayList<>(0));
        mRecyclerView.setAdapter(mAdapter);
    }


    private void pushDataToDatabase(UserModel user) {

    }

    private void subscribeToRealTimeData() {

    }
}