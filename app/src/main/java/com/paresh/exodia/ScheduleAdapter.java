package com.paresh.exodia;

/**
 * Created by paresh on 11/12/17.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.MyViewHolder> {

    private List<ScheduleList> scheduleLists;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView event_name, event_time, event_venue;

        public MyViewHolder(View view) {
            super(view);
            event_name = (TextView) view.findViewById(R.id.event_title);
            event_venue = (TextView) view.findViewById(R.id.event_venue);
            event_time = (TextView) view.findViewById(R.id.event_time);
        }
    }


    public ScheduleAdapter(List<ScheduleList> scheduleLists) {
        this.scheduleLists = scheduleLists;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedule_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ScheduleList scheduleList = scheduleLists.get(position);
        holder.event_name.setText(scheduleList.getEvent_title());
        holder.event_venue.setText(scheduleList.getEvent_venue());
        holder.event_time.setText(scheduleList.getEvent_time());
    }

    @Override
    public int getItemCount() {
        return scheduleLists.size();
    }
}
