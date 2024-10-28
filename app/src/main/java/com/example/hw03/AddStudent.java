package com.example.hw03;

import android.annotation.SuppressLint;
import android.hardware.biometrics.BiometricManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddStudent extends AppCompatActivity {
    EditText username;
    EditText firstname;
    EditText lastname;
    EditText email;
    EditText age;
    EditText gpa;
    Spinner major;
    Button btn_back;
    Button btn_add;
    DBHelper dbHelper;
    ArrayList<Major> listOfMajors;
    ArrayList<String> majorsasarray;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.add_new_student);
        username = findViewById(R.id.et_VAS_username);
        firstname = findViewById(R.id.et_VAS_fname);
        lastname = findViewById(R.id.et_VAS_lname);
        email = findViewById(R.id.et_VAS_email);
        age = findViewById(R.id.et_VAS_age);
        gpa = findViewById(R.id.et_VAS_gpa);
        major = findViewById(R.id.sp_VAS_major);
        btn_add = findViewById(R.id.btn_VAS_addStudent);
        btn_back = findViewById(R.id.btn_VAS_back);
        dbHelper = new DBHelper(this);
        listOfMajors = dbHelper.getAllMajors();
        majorsasarray = new ArrayList<String>();
        for (Major i :listOfMajors
        ) {
            majorsasarray.add(i.getMajor());
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,majorsasarray); //could use a spinner with the list of major objects but that would require more time and work than i currently have
        major.setAdapter(adapter);

        addListeners();
    }
    public void addListeners()
    {
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!username.getText().toString().equals("") && !firstname.getText().toString().equals("") && !lastname.getText().toString().equals("") && !email.getText().toString().equals("") && !age.getText().toString().equals("") && !gpa.getText().toString().equals(""))
                {
                    int tempnum = (int) major.getSelectedItemId()+1;
                    Student temp = new Student(username.getText().toString(),firstname.getText().toString(),lastname.getText().toString(),email.getText().toString(),Integer.parseInt(age.getText().toString()),Float.parseFloat(gpa.getText().toString()),dbHelper.getMajorFromId(tempnum));
                    dbHelper.addNewStudent(temp);

                    finish();
                }
            }
        });
    }
}

