package com.rtmbeta.a9;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton,backbutton;
    EditText radio_g;


    String questions[] = {
            "List any food allergies you may have (nuts, gluten, etc)",
            "What is your spice level tolerance (from 1 lowest to 5 highest)",
            "What are you favorite cuisines (e.g. Italian, Chinese, Sushi)",
            "What are your disliked cuisines?",
            "Are you a vegetarian, vegan, pescetarian? (Please specify which and if there are any exceptions)",
            "If you do eat meat, are there any exceptions (e.g. no pork, no beef)",
            "If you eat steak, how do you like it cooked?",
            "Do you eat sushi?",
            "Do you have any favorite vegetables? (if so, list them please)",
            "Do you dislike any particular vegetables? (if so, list them please)",
            "Do you have any favorite fruits? (if so, list them please)",
            "Do you dislike any particular fruits? (if so, list them please)",
            "DO you usually order appetizers?",
            "DO you usually order desserts?",
            "Do you require your food to be organic?",
            "How many drinks, if any, do you usually have with your meal?"
    };
    String arrayList[] =new String[16];

    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

//        if (name.trim().equals(""))
//            //textView.setText("Hello User");
//        else
//        //textView.setText("Hello " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        backbutton=(Button)findViewById(R.id.button2);

        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(EditText) findViewById(R.id.answersgrp);

        tv.setText(questions[flag]);

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Please Answer", Toast.LENGTH_SHORT).show();

                }else{



                    arrayList[flag]=radio_g.getText().toString();
                    radio_g.setText(arrayList[flag]);
                   // Log.e("ar", String.valueOf(arrayList.size()));
                    //arrayList.set(flag,radio_g.getText().toString());

                    //arrayList.add(radio_g.getText().toString());
                    Log.e("Flagnextans1", String.valueOf(arrayList[flag]));

                    flag++;


                    Log.e("Flagnext", String.valueOf(flag));

                    if(flag<questions.length)
                    {
                        tv.setText(questions[flag]);
                        radio_g.setText(arrayList[flag]);

                        Log.e("Flagnextans2", String.valueOf(arrayList[flag]));


                    }
                    else
                    {
                        Intent in = new Intent(getApplicationContext(), ResultActivity.class);
                        in.putExtra("arrayList", arrayList);
                        in.putExtra("questions", questions);

                        startActivity(in);
                    }
                }



            }
        });

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag--;

                if(flag<questions.length)
                {


                    Log.e("Flagback", String.valueOf(flag));
                    Log.e("Flagbackans", String.valueOf(arrayList[flag]));

                    tv.setText(questions[flag]);
                    radio_g.setText(arrayList[flag]);


                }
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList=new String[16];
                Intent intent=new Intent(getApplicationContext(), ResultActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        arrayList=new String[16];

    }
}