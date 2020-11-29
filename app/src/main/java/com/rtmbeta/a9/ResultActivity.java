package com.rtmbeta.a9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    Button btnRestart;
    ListView lv;
    String arrayList[];
    String questions[];

    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        arrayList = getIntent().getStringArrayExtra("arrayList");
        questions = getIntent().getStringArrayExtra("questions");

        btnRestart = (Button) findViewById(R.id.btnRestart);

        lv = (ListView) findViewById(R.id.list);

        list = new ArrayList<String>();

        for(int i = 0;i<arrayList.length;i++){

            list.add(questions[i]);
            list.add(arrayList[i]);


        }


        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + QuestionsActivity.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + QuestionsActivity.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + QuestionsActivity.correct + "\n");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1, list );

        lv.setAdapter(arrayAdapter);



        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
    }

}
