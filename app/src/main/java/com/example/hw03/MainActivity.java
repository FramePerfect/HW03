package com.example.hw03;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DBHelper dbHelper;
    Button btn_addStudent;
    Button btn_search;
    ListView lv_students;
    StudentListAdapter adapter;
    ArrayList<Student> listOfStudents;
    Intent intent_search;
    Intent intent_addNewStudent;
    Intent intent_viewStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dbHelper = new DBHelper(this);
        btn_addStudent = findViewById(R.id.btn_addStudent);
        btn_search = findViewById(R.id.btn_search);
        lv_students = findViewById(R.id.lv_students);
        intent_search = new Intent(MainActivity.this,SearchStudents.class);
        intent_addNewStudent = new Intent(MainActivity.this,AddStudent.class);
        intent_viewStudent = new Intent(MainActivity.this,ViewStudent.class);


        dbHelper.addDummyData();


        getStudents();
        fillListView();
        addListeners();


        debugCode();
    }
    public void onResume()
    {
        super.onResume();
        repoplist();
    }
    public void debugCode()
    {
        Log.d("Num of Student records ", dbHelper.countRecordsFromTable(dbHelper.getStudentDbName())+"");
        Log.d("Num of Major Records ", dbHelper.countRecordsFromTable(dbHelper.getMajorsDbName()) + "");
        Log.d("list of students count:",Integer.toString(listOfStudents.size()));
    }
    public void fillListView()
    {
        adapter = new StudentListAdapter(this,listOfStudents);
        lv_students.setAdapter(adapter);
    }
    public void getStudents()
    {
        listOfStudents = dbHelper.getAllStudents();
    }
    public void addListeners()
    {
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_search);
            }
        });
        btn_addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_addNewStudent);
            }
        });
        lv_students.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent_viewStudent.putExtra("Username",listOfStudents.get(i).getUserName());
                startActivity(intent_viewStudent);

            }
        });
    }
    private void repoplist()
    {
        getStudents();
        fillListView();
    }
}