package com.example.rubrub.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rubrub.EntityClass.ScheduleClass;
import com.example.rubrub.R;

import java.util.ArrayList;

public class SearchbyteacherAdapter extends
        RecyclerView.Adapter<SearchbyclassAdapter.ViewHolder> {
    private ArrayList<ScheduleClass> mScheduleclass;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView coursename,courseteacher,coursetime,courseplace;

        public ViewHolder(View view){
            super(view);
            coursename=(TextView)view.findViewById(R.id.cname);
            courseteacher=(TextView)view.findViewById(R.id.cteacher);
            coursetime=(TextView)view.findViewById(R.id.ctime);
            courseplace=(TextView)view.findViewById(R.id.cplace);
        }

    }

    public SearchbyteacherAdapter(ArrayList<ScheduleClass>scheduleClass){
        mScheduleclass=scheduleClass;
    }

    @Override
    public SearchbyclassAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item,parent,false);
        SearchbyclassAdapter.ViewHolder holder=new SearchbyclassAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchbyclassAdapter.ViewHolder holder, int position) {
        ScheduleClass scheduleClass=mScheduleclass.get(position);
        holder.coursename.setText(scheduleClass.getCname());
        holder.cousreteacher.setText(scheduleClass.getCteacher());
        holder.coursetime.setText(scheduleClass.getCtime());
        holder.courseplace.setText(scheduleClass.getCplace());

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
