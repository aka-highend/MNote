package com.rfachrur.mnote.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.rfachrur.mnote.DataModel.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rfachrur on 10/13/16.
 *
 */

public class DatabaseController {

    private DatabaseHelper DBHelper;
    private SQLiteDatabase database;

    public DatabaseController(Context context) {
        DBHelper = new DatabaseHelper(context);
    }

    public void close() {
        DBHelper.close();
    }

    public void addNote(Note note) {

        database = DBHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(com.rfachrur.mnote.DB.DatabaseHelper.COL_NOTE_TITLE, note.getTitle());
        values.put(com.rfachrur.mnote.DB.DatabaseHelper.COL_NOTE_DESC, note.getDescription());
        values.put(com.rfachrur.mnote.DB.DatabaseHelper.COL_NOTE_DATE, note.getDate());

        database.insert(com.rfachrur.mnote.DB.DatabaseHelper.TABLE_NAME, null, values);
        database.close();
    }

    // Getting All notes
    public List<Note> getAllNotes() {
        SQLiteDatabase db = DBHelper.getWritableDatabase();

        List<Note> noteList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + com.rfachrur.mnote.DB.DatabaseHelper.TABLE_NAME;

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Note note = new Note();
                note.setId(Integer.parseInt(cursor.getString(0)));
                note.setTitle(cursor.getString(1));
                note.setDescription(cursor.getString(2));
                note.setDate(cursor.getString(3));
                // Adding note to list
                noteList.add(note);
            } while (cursor.moveToNext());
        }
        cursor.close();

        // return note list
        return noteList;
    }

    // Updating single note
    public int updateNote(Note note) {
        SQLiteDatabase db = DBHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(com.rfachrur.mnote.DB.DatabaseHelper.COL_NOTE_TITLE, note.getTitle());
        values.put(com.rfachrur.mnote.DB.DatabaseHelper.COL_NOTE_DESC, note.getDescription());
        values.put(com.rfachrur.mnote.DB.DatabaseHelper.COL_NOTE_DATE, note.getDate());

        // updating row
        return db.update(com.rfachrur.mnote.DB.DatabaseHelper.TABLE_NAME, values, com.rfachrur.mnote.DB.DatabaseHelper.COL_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
    }

    // Deleting single note
    public void deleteNote(Note note) {
        SQLiteDatabase db = DBHelper.getWritableDatabase();

        db.delete(com.rfachrur.mnote.DB.DatabaseHelper.TABLE_NAME, com.rfachrur.mnote.DB.DatabaseHelper.COL_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
        db.close();
    }


    public void addNoteToTrash(Note note) {

        database = DBHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(com.rfachrur.mnote.DB.DatabaseHelper.COL_NOTE_TITLE_TRASH, note.getTitle());
        values.put(com.rfachrur.mnote.DB.DatabaseHelper.COL_NOTE_DESC_TRASH, note.getDescription());
        values.put(com.rfachrur.mnote.DB.DatabaseHelper.COL_NOTE_DATE_TRASH, note.getDate());

        database.insert(com.rfachrur.mnote.DB.DatabaseHelper.TABLE_NAME_TRASH, null, values);
        database.close();
    }


    // Getting All notes
    public List<Note> getAllNotesFromTrash() {
        SQLiteDatabase db = DBHelper.getWritableDatabase();

        List<Note> noteList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + com.rfachrur.mnote.DB.DatabaseHelper.TABLE_NAME_TRASH;

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Note note = new Note();
                note.setId(Integer.parseInt(cursor.getString(0)));
                note.setTitle(cursor.getString(1));
                note.setDescription(cursor.getString(2));
                note.setDate(cursor.getString(3));
                // Adding note to list
                noteList.add(note);
            } while (cursor.moveToNext());
        }
        cursor.close();

        // return note list
        return noteList;
    }

    // Deleting single note
    public void deleteNoteFromTrash(Note note) {
        SQLiteDatabase db = DBHelper.getWritableDatabase();

        db.delete(com.rfachrur.mnote.DB.DatabaseHelper.TABLE_NAME_TRASH, com.rfachrur.mnote.DB.DatabaseHelper.COL_ID_TRASH + " = ?",
                new String[]{String.valueOf(note.getId())});
        db.close();
    }

}
