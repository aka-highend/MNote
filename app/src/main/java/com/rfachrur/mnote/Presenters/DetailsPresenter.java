package com.rfachrur.mnote.Presenters;

import android.content.Intent;

import com.rfachrur.mnote.DataModel.Note;
import com.rfachrur.mnote.Activity.DetailsActivity;
import com.rfachrur.mnote.InterfaceView.DetailsView;

/**
 * Created by rfachrur on 10/13/16.
 *
 */

public class DetailsPresenter {

    private DetailsView detailsView;

    public DetailsPresenter(DetailsView detailsView) { this.detailsView = detailsView; }

    public void shareNote(Note note) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, note.getTitle() + "\n\n" + note.getDescription());
        detailsView.getContext().startActivity(Intent.createChooser(share, "Share via"));
    }

    public void update(Note note, int position) {
        if (!note.getTitle().trim().equals("")) {
            Intent intent = new Intent();
            intent.putExtra("title", note.getTitle());
            intent.putExtra("desc", note.getDescription());
            intent.putExtra("position",position);
            detailsView.finishIntent(intent);
        } else
            detailsView.showSnackBar();
    }

    public void updateTexts(Intent intent) {
        detailsView.setNoteTitle(intent.getStringExtra("title"));
        detailsView.setNoteDetail(intent.getStringExtra("description"));
        DetailsActivity.position = intent.getIntExtra("position",-1);
    }
}
