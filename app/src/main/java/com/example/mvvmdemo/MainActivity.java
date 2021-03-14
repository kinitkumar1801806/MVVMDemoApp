package com.example.mvvmdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.mvvmdemo.Adapter.RecyclerAdapter;
import com.example.mvvmdemo.model.NicePlaces;
import com.example.mvvmdemo.viewModels.MainActivityModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    ProgressBar progressBar;
    ArrayList<NicePlaces> NicePlace;
    FloatingActionButton mfab;
    MainActivityModel mainActivityModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressBar);
        mfab=findViewById(R.id.fab);
        NicePlace=new ArrayList<>();
        mainActivityModel= ViewModelProviders.of(this).get(MainActivityModel.class);
        mainActivityModel.init();
        mainActivityModel.getNicePlaces().observe(this, new Observer<List<NicePlaces>>() {
            @Override
            public void onChanged(List<NicePlaces> nicePlaces) {
                recyclerAdapter.notifyDataSetChanged();
            }
        });
        mainActivityModel.getLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                {
                    showProgressBar();
                }
                else
                {
                    hideProgressBar();
                    recyclerView.smoothScrollToPosition(mainActivityModel.getNicePlaces().getValue().size()-1);
                }
            }
        });
        mfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityModel.addNewValue(
                        new NicePlaces(
                                "https://i.redd.it/qn7f9oqu7o501.jpg",
                          "Washington"
                        )
                );
            }
        });
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        intiRecyclerView();
    }

    private void intiRecyclerView() {
        recyclerAdapter=new RecyclerAdapter(this,mainActivityModel.getNicePlaces().getValue());
        recyclerView.setAdapter(recyclerAdapter);
    }
    public void showProgressBar()
    {
        progressBar.setVisibility(View.VISIBLE);
    }
    public void hideProgressBar()
    {
        progressBar.setVisibility(View.GONE);
    }
}