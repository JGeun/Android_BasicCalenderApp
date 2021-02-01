package com.example.basiccalendarapp.viewpager;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basiccalendarapp.R;
import com.example.basiccalendarapp.recyclerview.CalendarAdapter;

public class CalendarMonthFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_calendar_month, container, false);
        RecyclerView calendarDayView = rootView.findViewById(R.id.main_rv_calendarDay);
        int mNoOfColumns = Utility.calculateNoOfColumns(getContext(), 60);
        calendarDayView.setLayoutManager(new GridLayoutManager(getContext(), mNoOfColumns));
        CalendarAdapter calendarAdapter = new CalendarAdapter(getContext());
        calendarDayView.setAdapter(calendarAdapter);

        return rootView;
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