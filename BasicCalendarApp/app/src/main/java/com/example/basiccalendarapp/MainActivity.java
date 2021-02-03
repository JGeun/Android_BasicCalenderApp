package com.example.basiccalendarapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TextView;

import com.example.basiccalendarapp.recyclerview.CalendarAdapter;
import com.example.basiccalendarapp.viewpager.CalendarMonthAdapter;
import com.example.basiccalendarapp.viewpager.CalendarMonthFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager;
    CalendarMonthAdapter calendarAdapter;
    private ArrayList<ArrayList<Integer>> monthArray = new ArrayList<>();
    private int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView monthValue = findViewById(R.id.main_tv_month_value);

        calendarAdapter = new CalendarMonthAdapter(this);
        viewPager = findViewById(R.id.main_vp_calendar_month);
        viewPager.setAdapter(calendarAdapter);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Log.d("SelectedPosition", Integer.toString(position));
                monthValue.setText(Integer.toString(position+1));
            }
        });

        long now = System.currentTimeMillis();
        Date mDate = new Date(now);
        SimpleDateFormat simpleDate = new SimpleDateFormat("MM");
        int currentMonth = Integer.parseInt(simpleDate.format(mDate));
        viewPager.setCurrentItem(currentMonth-1);
    }

    void setMonth(){
    }
}