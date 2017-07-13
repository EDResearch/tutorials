package com.example.choi.memo_homework;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Button save;
    EditText Et;
    TextView T;
    ListView lv;
    lv_adapter adapter;
    ArrayList<data> items = new ArrayList<>();
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        Et = (EditText)findViewById(R.id.Et);
        T = (TextView)findViewById(R.id.It);
        save = (Button)findViewById(R.id.B);
        lv = (ListView)findViewById(R.id.Lv);

        adapter = new lv_adapter(this,items);
        lv.setAdapter(adapter);

        loadNowData();
        adapter.notifyDataSetChanged();


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.add(new data(Et.getText().toString()));
                Et.setText("");
                saveNowData();
                adapter.notifyDataSetChanged();
            }
        });
    }

    void saveNowData(){ //items 안의 내용이 저장됨
        String json = new Gson().toJson(items);
        prefs.edit().putString("save", json).apply();
    }

    void loadNowData() {
        String json = prefs.getString("save", "");
        Type listType = new TypeToken<ArrayList<data>>(){}.getType();
        ArrayList<data> list = new Gson().fromJson(json, listType);

        if(list != null) items.addAll(list);
    }
}

