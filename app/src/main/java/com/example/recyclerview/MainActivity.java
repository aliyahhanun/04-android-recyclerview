package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Word> dataList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setItemData(ItemData.itemData());

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        WordAdapter adapter = new WordAdapter(dataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void setItemData(String data){
        try {
            JSONArray jsonArray = new JSONArray(data);
            dataList = new ArrayList<>();
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Word word = new Word(jsonObject.getString("name"),
                        jsonObject.getString("year"));
                dataList.add(word);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}