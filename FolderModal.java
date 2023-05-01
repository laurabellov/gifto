package com.example.giftoo;

public class FolderModal {
    private String foldereName;

    private int id;

    // creating getter and setter methods
    public String getCourseName() { return foldereName; }



    public void setCourseName(String courseName)
    {
        this.foldereName = courseName;
    }



    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public FolderModal(int id, String courseName)
    {
        this.foldereName = foldereName;
        this.id = id;

    }
}

