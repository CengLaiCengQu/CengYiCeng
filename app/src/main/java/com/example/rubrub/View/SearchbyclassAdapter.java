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

public class SearchbyclassAdapter extends
        RecyclerView.Adapter<SearchbyclassAdapter.ViewHolder> {

    private ArrayList<ScheduleClass>mScheduleclass;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView coursename,cousreteacher,coursetime,courseplace;

        public ViewHolder(View view){
            super(view);
            coursename=(TextView)view.findViewById(R.id.cname);
            cousreteacher=(TextView)view.findViewById(R.id.cteacher);
            coursetime=(TextView)view.findViewById(R.id.ctime);
            courseplace=(TextView)view.findViewById(R.id.cplace);

        }

    }

    public SearchbyclassAdapter(ArrayList<ScheduleClass>scheduleClass){
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
