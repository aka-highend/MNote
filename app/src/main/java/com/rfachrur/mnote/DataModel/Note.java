package com.rfachrur.mnote.DataModel;

import java.util.UUID;

/**
 * Created by rfachrur on 10/13/16.
 *
 */

public class Note {

    private int id;
    private String date;
    private String title;
    private String description;
    private String uid;

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Note(int id, String title, String description, String date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public Note() {  }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getUid() { return uid; }

    public void setUid(String uid) { this.uid = uid; }
}
