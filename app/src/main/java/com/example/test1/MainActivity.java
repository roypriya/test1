package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> parent;
    Map<String,List<String>> map;
    ExpandableListAdapter expandableListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView=findViewById(R.id.expandableListView);

        fillData();
        expandableListAdapter=new MyExListAdapter(this,parent,map);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                
                return false;
            }
        });
    }

    private void fillData() {
        parent=new ArrayList<>();
        map=new HashMap<>();
        parent.add("School");
        parent.add("Daily Life");

        map.put(parent.get(0),new ArrayList<>(Arrays.asList("Go to School","Ask a question")));
        map.put(parent.get(1),new ArrayList<>(Arrays.asList("Wake up","Go to bed")));

    }
}
