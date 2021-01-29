package com.example.basiccalendarapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.example.basiccalendarapp.recyclerview.CalendarAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView calendarDayView = findViewById(R.id.main_rv_calendarDay);
        int mNoOfColumns = Utility.calculateNoOfColumns(getApplicationContext(), 150);
        calendarDayView.setLayoutManager(new GridLayoutManager(this, mNoOfColumns));
        CalendarAdapter calendarAdapter = new CalendarAdapter();
        calendarDayView.setAdapter(calendarAdapter);
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