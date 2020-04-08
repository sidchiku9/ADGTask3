package com.sidchiku9.adgtask3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton floatingNote;
    private String upper,dipper;
    ArrayList<sampleItem> sampleItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sampleItems.add(new sampleItem("Note 1","Sample Note"));
        sampleItems.add(new sampleItem("Note 2","Sample Note 2"));

        mRecyclerView = findViewById(R.id.rw);

        floatingNote = findViewById(R.id.createNotesfloat);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(sampleItems);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        floatingNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),WriteNotes.class);
                startActivity(intent);
            }
        });
        loadData();
        updateViews();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(global_variables.SHARED_PREFS,MODE_PRIVATE);
        upper = sharedPreferences.getString(global_variables.heading,"Nothing to show");
        dipper = sharedPreferences.getString(global_variables.maal,"Nothing in content");
    }

    public void updateViews(){
            sampleItems.add(new sampleItem(upper,dipper));
        }

    }

