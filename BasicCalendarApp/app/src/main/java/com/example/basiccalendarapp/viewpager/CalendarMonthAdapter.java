package com.example.basiccalendarapp.viewpager;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CalendarMonthAdapter extends FragmentStateAdapter {
    private Context context;
    public CalendarMonthAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        context = fragmentActivity;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new CalendarMonthFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
