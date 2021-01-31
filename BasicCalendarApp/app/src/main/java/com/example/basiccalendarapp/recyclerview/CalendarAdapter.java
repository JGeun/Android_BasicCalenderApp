package com.example.basiccalendarapp.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basiccalendarapp.R;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {
    private Context context;
    private int checkIndex = -1;
    public CalendarAdapter(Context context){
        this.context = context;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout calendarBlock;
        public ViewHolder(View itemView) {
            super(itemView);
            calendarBlock = itemView.findViewById(R.id.item_ll_calendar_block);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_calendar_day, parent, false);
        int height = parent.getMeasuredHeight()/6;
        itemView.setMinimumHeight(height);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.calendarBlock.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkIndex = position;
                notifyDataSetChanged();
            }
        });

        if(checkIndex == position){
            holder.calendarBlock.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.item_calendar_day_click_after, null));
        }else{
            holder.calendarBlock.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.item_calendar_day_click_before, null));
        }
    }

    @Override
    public int getItemCount() {
        return 42;
    }


}
