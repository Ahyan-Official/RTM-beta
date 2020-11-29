package com.webtos.plany.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import com.webtos.plany.R;

public class Task extends Fragment {

    private View view;
    private Toolbar toolbar;
    private CalendarView calendarView;
    private TextView textView;

    public Task() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_task, container, false);

            toolbar = view.findViewById(R.id.toolbar);

            toolbar.setTitle("Calender");
            calendarView = view.findViewById(R.id.calendarView);
            textView = view.findViewById(R.id.text_save);


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                String date = (year + 1) + "/"+month +"/"+dayOfMonth;


                textView.setText(date);
            }
        });

        return view;
    }
}