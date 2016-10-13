package com.rfachrur.mnote.InterfaceView;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.rfachrur.mnote.DataModel.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rfachrur on 10/13/16.
 *
 */

public interface MainView {

    void showEmptyTitleError(int redId);

    Context getContext();

    void showNotes(List<Note> noteList);

    void showAddedNote(Note note);

    void showFilteredNotes(ArrayList<Note> arrayList);

    FrameLayout getFrame();

    FloatingActionButton getFAB();

    void resetEditTexts();

    String getNoteTitle();

    String getNoteDescription();

    View getFocus();

    RelativeLayout getFirstLayout();

    LinearLayout getSecondLayout();

    android.support.v7.widget.SearchView getSearchView();

    void showRestoredNotes();

    void showSnackBar(Note note, int position);

    void updateNotesAfterDeletion(Note note);

    interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

}
