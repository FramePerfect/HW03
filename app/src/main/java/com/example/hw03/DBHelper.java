package com.example.hw03;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String db_name = "Students.db";
    private static final String username_table_name = "Username";
    private static final String majors_table_name = "Major";

    public DBHelper(Context c)
    {
        super(c,db_name,null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + majors_table_name + " (majorId integer primary key autoincrement not null, major varchar(50), prefix varchar(50))");
        db.execSQL("CREATE TABLE " + username_table_name + " (username varchar(50) primary key not null, fname varchar(50), lname varchar(50), email varchar(50), age integer, gpa float, majorId integer, foreign key (majorId) references " + majors_table_name + " (majorId));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + username_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + majors_table_name + ";");

        onCreate(db);
    }
    public String getStudentDbName(){return username_table_name;}
    public String getMajorsDbName(){return majors_table_name;}
    public void studentDummyData()
    {
        if(countRecordsFromTable(username_table_name) == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('TestUser','Bob','Harris','bob@harris.com','20','3.0','1')");
            db.execSQL("INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('vrulf0','Vannie','Rulf','vrulf0@theguardian.com','28','2.26','4')");
            db.execSQL("INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('droseburgh1','Danny','Roseburgh','droseburgh1@utexas.edu','26','2.31','4')");
            db.execSQL("INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('chussell2','Cleve','Hussell','chussell2@imdb.com','25','2.6','4')");
            db.execSQL("INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('bgallafant3','Bary','Gallafant','bgallafant3@nasa.gov','27','0.79','3')");
            db.execSQL("INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('dmccurlye4','Davine','Mc Curlye','dmccurlye4@adobe.com','25','0.7','5')");
            db.execSQL("INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('bdeleon5','Brita','de Leon','bdeleon5@fastcompany.com','22','1.55','3')");
            db.execSQL("INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('efaust6','Ev','Faust','efaust6@mashable.com','24','2.69','2')");
            db.execSQL("INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('kcrosson7','Krispin','Crosson','kcrosson7@newsvine.com','28','3.0','1')");
            db.execSQL("INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('vthoumas8','Violet','Thoumas','vthoumas8@jigsy.com','23','2.17','1')");
            db.execSQL("INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('bblazdell9','Brandon','Blazdell','bblazdell9@pinterest.com','29','3.96','4')");
            db.execSQL("INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('fnealea','Fonzie','Neale','fnealea@noaa.gov','24','3.51','4')");
            db.execSQL("INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('lelverstoneb','Lyndsie','Elverstone','lelverstoneb@cbc.ca','19','1.97','4')");
            db.execSQL("INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('mjothamc','Madalena','Jotham','mjothamc@dailymail.co.uk','25','1.02','2')");
            db.execSQL("INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('sbassinghamd','Shem','Bassingham','sbassinghamd@ftc.gov','21','1.54','4')");
            db.execSQL("INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('abeldhame','Agnesse','Beldham','abeldhame@homestead.com','30','0.38','1')");
            db.execSQL("INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('nnellf','Nikolas','Nell','nnellf@statcounter.com','27','1.51','1')");
            db.execSQL("INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('nbroyg','Noemi','Broy','nbroyg@paginegialle.it','26','2.3','5')");
            db.execSQL("INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('laseefh','Lyndsay','Aseef','laseefh@plala.or.jp','25','0.22','4')");
            db.execSQL("INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('mlacottei','Martie','Lacotte','mlacottei@slate.com','24','3.79','2')");
            db.execSQL("INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('eleborgnej','Ellswerth','Leborgne','eleborgnej@instagram.com','25','3.49','4')");
            if(db.isOpen()){db.close();}
        }
    }
    public void majorsDummyData()
    {
        if(countRecordsFromTable(majors_table_name) == 0) {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + majors_table_name + "(major,prefix) VALUES ('Computer Science','CIS')");
            db.execSQL("INSERT INTO " + majors_table_name + "(major,prefix) VALUES ('Biology','BIO')");
            db.execSQL("INSERT INTO " + majors_table_name + "(major,prefix) VALUES ('Business','BUS')");
            db.execSQL("INSERT INTO " + majors_table_name + "(major,prefix) VALUES ('History','HIS')");
            db.execSQL("INSERT INTO " + majors_table_name + "(major,prefix) VALUES ('Chemistry','CHE')");
            if(db.isOpen()){db.close();}
        }
    }
    public void addDummyData(){
        majorsDummyData();
        studentDummyData();
    }
    public int countRecordsFromTable(String tableName)
    {
        //get an instance of a readable database
        //we only need readable because we are not adding anything to the database with this action
        SQLiteDatabase db = this.getReadableDatabase();

        //count the number of entries in the table that was passed to the function
        //this is a built-in function1
        int numRows = (int) DatabaseUtils.queryNumEntries(db, tableName);

        //whenever we open the database we need to close it.
        if(db.isOpen()){db.close();}

        return numRows;
    }
    public void addNewStudent(Student s)
    {
        boolean temp = checkForUniqueUsername(s.getUserName());
        if(temp) {

            String insertQuery ="INSERT INTO " + username_table_name + "(username, fname, lname, email, age, gpa, majorId) VALUES ('"+ s.getUserName()+"','"+ s.getfirstName()+"','"+ s.getlastName()+"','"+ s.getEmail()+"','"+ s.getAge()+"','"+ s.getGpa()+"','"+ getIdFromMajor(s.getMajor())+"');";
            Log.d("Update query :", insertQuery);
            SQLiteDatabase database = this.getWritableDatabase(); //had to be moved here to avoid an odd bug
            database.execSQL(insertQuery);
            if(database.isOpen()){database.close();}
        }

    }
    public Boolean majorExists(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String checkId = "SELECT count(majorId) FROM " + majors_table_name + " WHERE majorId = '" + id + "';";
        Cursor cursor = db.rawQuery(checkId,null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        if(db.isOpen()){db.close();}
        cursor.close();
        if (count != 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public Boolean majorExists(String s)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String checkId = "SELECT count(majorId) FROM " + majors_table_name + " WHERE major = '" + s + "';";
        Cursor cursor = db.rawQuery(checkId,null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        if(db.isOpen()){db.close();}
        cursor.close();
        if (count != 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public String getMajorFromId(int id)
    {
        if (majorExists(id)) {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectStatement = "SELECT major FROM " + majors_table_name + " WHERE majorId = '" + id + "';";
            Cursor cursor = db.rawQuery(selectStatement, null);
            String major = null;
            if (cursor != null) {
                cursor.moveToFirst();
                major = cursor.getString(0).toString();
            }

            if(db.isOpen()){db.close();}
            if(cursor != null ){cursor.close();}
            return major;
        }
        else {
            Log.d("ERROR ", "MajorId not found");
        }
        return null;
    }
    public int getIdFromMajor(String m)
    {
        if (majorExists(m)) {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectStatement = "SELECT majorId FROM " + majors_table_name + " WHERE major = '" + m + "';";
            Cursor cursor = db.rawQuery(selectStatement, null);
            int major = 0;
            if (cursor != null) {
                cursor.moveToFirst();
                major = cursor.getInt(0);
            }

            if(db.isOpen()){db.close();}
            if(cursor != null ){cursor.close();}
            return major;
        }
        else {
            Log.d("ERROR ", "Major not found");
        }
        return -1;
    }
    public ArrayList<Student> queryByFilter(int filter, String filterString, int majorSelected)
    {
        switch (filter){
            case 0: //username
                return filterquery("username",filterString);
            case 1: //first name
                return filterquery("fname",filterString);
            case 2: //last name
                return filterquery("lname",filterString);
            case 3: //email
                return filterquery("email",filterString);
            case 4: //age
                return filterquery("age",filterString);
            case 5: //gpa
                return filterquery("gpa",filterString);
            case 6: //Major
                return filterquery("majorId",majorSelected);
            default:
                Log.d("ERROR: ", "Filter is somehow greater than 6");
                return null;
        }
    }
    public ArrayList<Student> filterquery(String whatToFilterBy,String filter)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectStatement = "SELECT username,fname,lname,email,age,gpa,"+ majors_table_name +".major FROM " + username_table_name + " INNER JOIN "+ majors_table_name + " ON "+ username_table_name +".majorId="+majors_table_name+".majorId WHERE "+ username_table_name + "."+ whatToFilterBy + " = '" + filter + "';";
        Cursor cursor = db.rawQuery(selectStatement, null);
        ArrayList<Student> listOfStudents = new ArrayList<Student>();
        if(cursor != null)
        {
            try{
                while (cursor.moveToNext())
                {
                    Student temp = new Student(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getInt(4),cursor.getFloat(5),cursor.getString(6));
                    listOfStudents.add(temp);
                }
            }
            finally {
                cursor.close();

            }
            return listOfStudents;
        }
        if(db.isOpen()){db.close();}
        return listOfStudents;
    }
    public ArrayList<Student> filterquery(String whatToFilterBy,int filter)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectStatement = "SELECT username,fname,lname,email,age,gpa,"+ majors_table_name +".major FROM " + username_table_name + " INNER JOIN "+ majors_table_name + " ON "+ username_table_name +".majorId="+majors_table_name+".majorId WHERE "+ username_table_name + "." + whatToFilterBy + " = '" + filter + "';";
        Cursor cursor = db.rawQuery(selectStatement, null);
        ArrayList<Student> listOfStudents = new ArrayList<Student>();
        if(cursor != null)
        {
            try{
                while (cursor.moveToNext())
                {
                    Student temp = new Student(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getInt(4),cursor.getFloat(5),cursor.getString(6));
                    listOfStudents.add(temp);
                }
            }
            finally {
                cursor.close();

            }
            return listOfStudents;
        }
        if(db.isOpen()){db.close();}
        return listOfStudents;
    }
    public Boolean checkForUniqueUsername(String s)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String checkId = "SELECT count(username) FROM " + username_table_name + " WHERE username = '" + s + "';";
        Cursor cursor = db.rawQuery(checkId,null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        cursor.close();
        if(db.isOpen()){db.close();}
        if (count != 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public ArrayList<Student> getAllStudents()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectStatement = "SELECT username,fname,lname,email,age,gpa,"+ majors_table_name +".major FROM " + username_table_name + " INNER JOIN "+ majors_table_name + " ON "+ username_table_name +".majorId="+majors_table_name+".majorId;";
        Cursor cursor = db.rawQuery(selectStatement, null);
        ArrayList<Student> listOfStudents = new ArrayList<Student>();
        if(cursor != null)
        {
            try{
                while (cursor.moveToNext())
                {
                    Student temp = new Student(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getInt(4),cursor.getFloat(5),cursor.getString(6));
                    listOfStudents.add(temp);
                }
            }
            finally {
                cursor.close();

            }
        }
        if(db.isOpen()){db.close();}
        return listOfStudents;
    }
    public ArrayList<Major> getAllMajors()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectStatement = "SELECT * FROM " + majors_table_name + ";";
        Cursor cursor = db.rawQuery(selectStatement, null);
        ArrayList<Major> listOfMajors = new ArrayList<Major>();
        if(cursor != null)
        {
            try{
                while (cursor.moveToNext())
                {
                    Major temp = new Major(cursor.getInt(0),cursor.getString(1),cursor.getString(2));
                    listOfMajors.add(temp);
                }
            }
            finally {
                cursor.close();

            }
        }
        db.close();
        return listOfMajors;
    }
    public Student getStudentByUsername(String u) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectStatement = "SELECT username,fname,lname,email,age,gpa," + majors_table_name + ".major FROM " + username_table_name + " INNER JOIN " + majors_table_name + " ON " + username_table_name + ".majorId=" + majors_table_name + ".majorId WHERE username = '" + u +"';";
        Cursor cursor = db.rawQuery(selectStatement, null);
        Student student = null;
        if (cursor != null)
        {
            cursor.moveToNext();
            student = new Student(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getInt(4),cursor.getFloat(5),cursor.getString(6));

        }
        db.close();
        return student;
    }
    public void updateStudent(String oldUName,Student s,int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String updateQuery ="UPDATE " + username_table_name +
                " SET username ='" +s.getUserName() +"'" + ", fname ='" +s.getfirstName() +"'" +", lname ='" +s.getlastName() +"'" +", email ='" +s.getEmail() +"'" +", age ='" +s.getAge() +"'" +", gpa ='" +s.getGpa() +"'" +", majorId ='"+ id +"'" +
                " WHERE username = '"+ oldUName + "';";
        db.execSQL(updateQuery);
        db.close();
    }
    public void deleteStudent(Student s)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String deleteQuery = "DELETE FROM " + username_table_name + " WHERE username = '" + s.getUserName() +"';";
        db.execSQL(deleteQuery);
        db.close();
    }


}
