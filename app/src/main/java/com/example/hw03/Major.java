package com.example.hw03;

public class Major {
    int majorId;
    String major;
    String prefix;

    public Major(int i,String m, String p)
    {
        majorId = i;
        major = m;
        prefix = p;
    }

    public String getMajor()
    {
        return major;
    }
    public String getPrefix()
    {
        return prefix;
    }
    public int getMajorId() {
        return majorId;
    }
    public void setMajor(String m)
    {
        major = m;
    }
    public void setPrefix(String p)
    {
        prefix = p;
    }
    public void setMajorId(int i)
    {
        majorId = i;
    }
}
