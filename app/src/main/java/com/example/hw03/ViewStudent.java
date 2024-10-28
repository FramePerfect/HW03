package com.example.hw03;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewStudent extends AppCompatActivity {

    EditText username;
    EditText firstname;
    EditText lastname;
    EditText email;
    EditText age;
    EditText gpa;
    Spinner major;
    DBHelper dbHelper;
    Student student;
    ArrayList<Major> listOfMajors;
    ArrayList<String> majorsasarray;
    ArrayAdapter<String> adapter;
    Button btn_update;
    Button btn_back;
    Button btn_delete;
    String uname;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.view_student_info);
        btn_update = findViewById(R.id.btn_update);
        btn_back = findViewById(R.id.btn_back);
        btn_delete = findViewById(R.id.btn_delete);
        username = findViewById(R.id.et_username);
        firstname = findViewById(R.id.et_fname);
        lastname = findViewById(R.id.et_lname);
        email = findViewById(R.id.et_email);
        age = findViewById(R.id.et_age);
        gpa = findViewById(R.id.et_gpa);
        major = findViewById(R.id.sp_major);
        majorsasarray = new ArrayList<String>();
        Intent camefrom = getIntent();
        Bundle data = camefrom.getExtras();
        uname = data.getString("Username");
        dbHelper = new DBHelper(this);
        student = dbHelper.getStudentByUsername(uname);
        listOfMajors = dbHelper.getAllMajors();
        for (Major i :listOfMajors
             ) {
            majorsasarray.add(i.getMajor());
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,majorsasarray); //could use a spinner with the list of major objects but that would require more time and work than i currently have
        major.setAdapter(adapter);

        username.setText(student.getUserName());
        firstname.setText(student.getfirstName());
        lastname.setText(student.getlastName());
        email.setText(student.getEmail());
        age.setText(Integer.toString(student.getAge()));
        gpa.setText(Float.toString(student.getGpa()));
        major.setSelection(dbHelper.getIdFromMajor(student.getMajor())-1);


        addlisteners();
    }

    public void addlisteners()
    {
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals(uname) || dbHelper.checkForUniqueUsername(username.getText().toString()))
                {
                    int tempnum = (int) major.getSelectedItemId()+1;
                    Student temp = new Student(username.getText().toString(),firstname.getText().toString(),lastname.getText().toString(),email.getText().toString(),Integer.parseInt(age.getText().toString()),Float.parseFloat(gpa.getText().toString()),dbHelper.getMajorFromId(tempnum));


                    dbHelper.updateStudent(uname,temp,tempnum);
                }
                else
                {
                    Log.d("ERROR: ","Username not unique");
                }
                finish();
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.deleteStudent(student);
                finish();

            }
        });
    }


}
