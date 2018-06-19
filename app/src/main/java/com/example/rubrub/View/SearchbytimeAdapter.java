package com.example.rubrub.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rubrub.EntityClass.ScheduleClass;
import com.example.rubrub.R;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SearchbytimeAdapter extends
        RecyclerView.Adapter<SearchbytimeAdapter.ViewHolder> {

    private ArrayList<ScheduleClass>mScheduleclass;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView coursename;

        public ViewHolder(View view){
            super(view);
            coursename=(TextView)view.findViewById(R.id.cname);

        }

    }

    public SearchbytimeAdapter(ArrayList<ScheduleClass>scheduleClass){
        mScheduleclass=scheduleClass;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ScheduleClass scheduleClass=mScheduleclass.get(position);
        holder.coursename.setText(scheduleClass.getCname());
    }

    @Override
    public int getItemCount() {
        return mScheduleclass.size();
    }

    public void setList(ArrayList<ScheduleClass> list) {
        mScheduleclass = list;
    }
    public ArrayList<ScheduleClass> getList() {
        return mScheduleclass;
    }
}
