package com.mirea.kt.ribo.practica2_10;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextN, editTextA,editTextS1,editTextC1,editTextS2,editTextC2;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.dbManager=new DBManager(new MyAppSQLiteHelper(this,"my_database2.db",null,2));
        editTextN=findViewById(R.id.name);
        editTextA=findViewById(R.id.address);
        editTextS1=findViewById(R.id.start1);
        editTextS2=findViewById(R.id.start2);
        editTextC1=findViewById(R.id.close1);
        editTextC2=findViewById(R.id.close2);
        Button btnNext=findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnNext){
            if(this.dbManager!=null && Integer.parseInt(editTextS2.getText().toString())<60 && Integer.parseInt(editTextC2.getText().toString())<60
                    && Integer.parseInt(editTextS1.getText().toString())<24 && Integer.parseInt(editTextC1.getText().toString())<24){
                String name=editTextN.getText().toString();
                String address=editTextA.getText().toString();
                String start="Работает с " + editTextS1.getText().toString()+":"+editTextS2.getText().toString();
                String close="Закрыт после "+ editTextC1.getText().toString()+":"+editTextC2.getText().toString();
                Log.d("ПРОВЕРКА",name+address);
                if(!name.isEmpty() && !address.isEmpty()){
                    boolean result=dbManager.saveShopToDatabase(new Shop(name,address,start,close));
                    if(result){
                        Toast.makeText(this,R.string.insert_success,Toast.LENGTH_LONG).show();
                        startActivity(new Intent(this,ShopActivity.class));
                    }else{
                        Toast.makeText(this,R.string.insert_error,Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(this, R.string.incorrect_value, Toast.LENGTH_LONG).show();
                }
            }else {
                Toast.makeText(this, R.string.incorrect_value, Toast.LENGTH_LONG).show();
            }
        }
    }
}