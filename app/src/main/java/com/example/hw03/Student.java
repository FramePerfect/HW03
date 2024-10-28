package com.example.hw03;

public class Student {
    String userName;
    String firstName;
    String lastName;
    String email;
    int age;
    float gpa;
    String major;

    public Student(String uname, String fname, String lname, String em, int a, float g, String m)
    {
        userName = uname;
        firstName = fname;
        lastName = lname;
        email = em;
        age = a;
        gpa = g;
        major = m;
    }
    public String getUserName()
    {
        return userName;
    }
    public String getfirstName()
    {
        return firstName;
    }
    public String getlastName()
    {
        return lastName;
    }
    public String getEmail()
    {
        return email;
    }
    public int getAge(){
        return age;
    }
    public String getMajor(){
        return major;
    }
    public float getGpa(){
        return gpa;
    }
    public void setUserName(String u)
    {
        userName = u;
    }
    public void setFirstName(String f)
    {
        firstName = f;
    }
    public void setLastName(String l)
    {
        lastName = l;
    }
    public void  setEmail(String e)
    {
        email = e;
    }
    public void setAge(int a)
    {
        age = a;
    }
    public void setGpa(float g)
    {
        gpa = g;
    }
    public void setMajorId(String m)
    {
        major = m;
    }
}
