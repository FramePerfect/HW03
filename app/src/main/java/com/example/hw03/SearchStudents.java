package com.example.hw03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SearchStudents extends AppCompatActivity {

    Button btn_query;
    Spinner sp_filterBy;
    Spinner sp_majorFilter;
    DBHelper dbHelper;
    EditText et_filter;
    ArrayList<Major> listOfMajors;
    ArrayList<String> majorsasarray;
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;
    ArrayList<String> filteroptions;
    ListView lv_filtered;
    StudentListAdapter listAdapter;
    ArrayList<Student> listOfStudents;
    Intent intent_viewStudent;
    Button btn_back;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.search_students);
        filteroptions = new ArrayList<>();
        filteroptions.add("username");
        filteroptions.add("First Name");
        filteroptions.add("Last Name");
        filteroptions.add("Email");
        filteroptions.add("Age");
        filteroptions.add("GPA");
        filteroptions.add("major");
        dbHelper = new DBHelper(this);
        btn_query = findViewById(R.id.btn_query);
        sp_filterBy = findViewById(R.id.sp_filterBy);
        sp_majorFilter = findViewById(R.id.sp_majorFilter);
        et_filter = findViewById(R.id.et_Filter);
        lv_filtered = findViewById(R.id.lv_filtered);
        intent_viewStudent = new Intent(SearchStudents.this,ViewStudent.class);
        btn_back = findViewById(R.id.btn_VSS_Back);
        listOfMajors = dbHelper.getAllMajors();
        majorsasarray = new ArrayList<String>();
        for (Major i :listOfMajors
        ) {
            majorsasarray.add(i.getMajor());
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,majorsasarray); //could use a spinner with the list of major objects but that would require more time and work than i currently have
        sp_majorFilter.setAdapter(adapter);
        adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,filteroptions);
        sp_filterBy.setAdapter(adapter2);



        addListeners();

    }
    public void onResume()
    {
        super.onResume();
        repopList();
    }
    public void addListeners()
    {
        btn_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repopList();
            }
        });
        lv_filtered.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent_viewStudent.putExtra("Username",listOfStudents.get(i).getUserName());
                startActivity(intent_viewStudent);
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void getStudents()
    {
        listOfStudents = dbHelper.queryByFilter((int)sp_filterBy.getSelectedItemId(),et_filter.getText().toString(),(int)sp_majorFilter.getSelectedItemId()+1);
    }
    public void fillListView()
    {
        listAdapter = new StudentListAdapter(this,listOfStudents);
        lv_filtered.setAdapter(listAdapter);
    }
    public void repopList()
    {
        getStudents();
        fillListView();
    }
}
