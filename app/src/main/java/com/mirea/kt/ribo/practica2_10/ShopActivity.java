package com.mirea.kt.ribo.practica2_10;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ShopAdapter adapter;
    private ArrayList<Shop> shopList;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Toolbar tb=findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        ActionBar ab=getSupportActionBar();
        if (ab!=null){
            ab.setHomeButtonEnabled(true);
            ab.setDisplayHomeAsUpEnabled(true);
        }
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database2.db", null, 2));
        shopList = dbManager.loadAllShopsFromDatabase();

        adapter = new ShopAdapter(shopList);
        recyclerView.setAdapter(adapter);


        adapter = new ShopAdapter(shopList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.simple_menu,menu);
        return true;
    }

    @Override

    public boolean onOptionsItemSelected(@NonNull MenuItem item ){
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}


