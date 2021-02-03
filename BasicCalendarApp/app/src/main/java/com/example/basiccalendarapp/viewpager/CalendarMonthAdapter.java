package com.example.basiccalendarapp.viewpager;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.basiccalendarapp.MainActivity;
import com.example.basiccalendarapp.R;

public class CalendarMonthAdapter extends FragmentStateAdapter {
    private Context context;
    public CalendarMonthAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        context = fragmentActivity;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new CalendarMonthFragment(position+1);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 12;
    }
}
