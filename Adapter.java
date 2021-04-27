package com.example.markattendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.viewholder> {
    Context context;
    List<ModelClass> ModelClassList  ;
    AttendListener attendListener;
    List<ModelClass> ModelClassList_0;
    View view;

    public View getview(){
        return view;
    }

    public Adapter(Context context,List ModelClassList,AttendListener attendListener) {
        this.context = context;
        this.ModelClassList = ModelClassList;
        this.attendListener = attendListener;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder viewholder, int position) {
        if(ModelClassList != null  && ModelClassList.size() >0){
            viewholder.checkBox.setText(ModelClassList.get(position));
            if(viewholder.checkBox.isChecked()){
                ModelClassList_0.add(ModelClassList.get(position));
            }
        }
        else{
            ModelClassList_0.remove(ModelClassList.get(position));
        }

        attendListener.onAttendChange(ModelClassList_0);

        int sno =ModelClassList.get(position).getSno();
        String name =ModelClassList.get(position).getName();
        int year =ModelClassList.get(position).getYear();
        String department =ModelClassList.get(position).getDepartment();
        viewholder.setData(sno,name,year,department);

    }

    @Override
    public int getItemCount() {
        return ModelClassList.size();
    }

    class viewholder extends RecyclerView.ViewHolder {

        private TextView sno;
        private TextView name;
        private TextView year;
        private TextView department;
        private CheckBox checkBox;


        public viewholder(@NonNull View itemView) {
            super(itemView);

            sno = (TextView) itemView.findViewById(R.id.sno);
            name= (TextView) itemView.findViewById(R.id.name);
            department= (TextView) itemView.findViewById(R.id.dept);
            year= (TextView) itemView.findViewById(R.id.yr);
            checkBox=(CheckBox) itemView.findViewById(R.id.mark);
        }

        private void setData(int snum, String sname, int yr, String dept)
        {
            sno.setText(String.valueOf(snum));
            name.setText(sname);
            year.setText(String.valueOf(yr));
            department.setText(dept);
        }

    }

}
