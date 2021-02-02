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

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager;
    CalendarMonthAdapter calendarAdapter;
    int selectedPos = 0;
    int scrollPos = 0;

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

       /* RecyclerView calendarDayView = findViewById(R.id.main_rv_calendarDay);
        int mNoOfColumns = Utility.calculateNoOfColumns(getApplicationContext(), 60);
        calendarDayView.setLayoutManager(new GridLayoutManager(this, mNoOfColumns));
        CalendarAdapter calendarAdapter = new CalendarAdapter(this);
        calendarDayView.setAdapter(calendarAdapter);*/
    }
}

class Utility {
    public static int calculateNoOfColumns(Context context, float columnWidthDp) { // For example columnWidthdp=180
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5); // +0.5 for correct rounding to int.
        return noOfColumns;
    }
}