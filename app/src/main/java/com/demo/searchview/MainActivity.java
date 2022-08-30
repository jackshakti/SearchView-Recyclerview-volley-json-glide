package com.demo.searchview;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import com.demo.searchview.Online_Search.Country_A;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText Searchtext;
    private ExampleAdapter adapter;
    ImageButton bt_mic;
    private List<ExampleItem> exampleList;
    private List<ExampleItem> examples;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        fillExampleList();
        setUpRecyclerView();
        initToolbar();
        findViewById(R.id.filter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getApplicationContext(), Country_A.class);
                startActivity(intent);
            }
        });
        this.Searchtext = (EditText) findViewById(R.id.search_input);
        this.Searchtext.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void afterTextChanged(Editable editable) {
                MainActivity.this.filterQuery(editable.toString());
            }
        });
    }

    private void fillExampleList() {
        this.exampleList = new ArrayList();
        this.exampleList.add(new ExampleItem(R.drawable.ic_filter_list_black_24dp, "One", "https://www.google.co.in/"));
        this.exampleList.add(new ExampleItem(R.drawable.no_img, "Two", "https://www.google.co.in/"));
        this.exampleList.add(new ExampleItem(R.drawable.ic_baseline_3d_rotation_24, "Three", "https://www.google.co.in/"));
        this.exampleList.add(new ExampleItem(R.drawable.ic_filter_list_black_24dp, "Four", "https://www.google.co.in/"));
        this.exampleList.add(new ExampleItem(R.drawable.ic_filter_list_black_24dp, "Five", "https://www.google.co.in/"));
        this.exampleList.add(new ExampleItem(R.drawable.ic_filter_list_black_24dp, "Six", "https://www.google.co.in/"));
        this.exampleList.add(new ExampleItem(R.drawable.ic_filter_list_black_24dp, "Seven", "https://www.google.co.in/"));
        this.exampleList.add(new ExampleItem(R.drawable.ic_filter_list_black_24dp, "Eight", "https://www.google.co.in/"));
        this.exampleList.add(new ExampleItem(R.drawable.ic_filter_list_black_24dp, "Nine", "https://www.google.co.in/"));
        this.exampleList.add(new ExampleItem(R.drawable.ic_filter_list_black_24dp, "Ten", "https://www.google.co.in/"));

    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        LayoutManager layoutManager = new LinearLayoutManager(this);
        this.adapter = new ExampleAdapter(this.exampleList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(this.adapter);
    }

    private void initToolbar() {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "Anant");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /* access modifiers changed from: private */
    public void filterQuery(String text) {
        ArrayList<ExampleItem> filterdNames = new ArrayList<>();
        for (ExampleItem s : this.exampleList) {
            if (s.getText1().toLowerCase().contains(text) || s.getText2().toLowerCase().contains(text)) {
                filterdNames.add(s);
            }
        }
        this.adapter.setFilter(filterdNames);
    }
}