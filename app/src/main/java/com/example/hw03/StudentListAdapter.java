package com.example.hw03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentListAdapter extends BaseAdapter {
    Context context;
    ArrayList<Student> listOfStudents;


    public StudentListAdapter(Context c, ArrayList<Student> ls)
    {
        context = c;
        listOfStudents = ls;
    }
    @Override
    public int getCount() {
        return listOfStudents.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfStudents.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.custom_cell, null);
        }
        TextView fname = view.findViewById(R.id.tv_fname);
        TextView lname = view.findViewById(R.id.tv_lname);
        TextView username = view.findViewById(R.id.tv_username);
        TextView email = view.findViewById(R.id.tv_email);
        TextView age = view.findViewById(R.id.tv_age);
        TextView major = view.findViewById(R.id.tv_major);
        TextView gpa = view.findViewById(R.id.tv_gpa);

        Student student = listOfStudents.get(i);
        fname.setText(student.getfirstName());
        lname.setText(student.getlastName());
        username.setText(student.getUserName());
        email.setText(student.getEmail());
        age.setText(Integer.toString(student.getAge()));
        gpa.setText(Float.toString(student.getGpa()));
        major.setText(student.getMajor());

        return view;
    }
}
