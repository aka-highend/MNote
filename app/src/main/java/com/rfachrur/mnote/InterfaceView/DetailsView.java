package com.rfachrur.mnote.InterfaceView;

import android.content.Context;
import android.content.Intent;

/**
 * Created by rfachrur on 10/13/16.
 *
 */

public interface DetailsView {

    Context getContext();

    void setNoteTitle(String string);

    void setNoteDetail(String string);

    void finishIntent(Intent intent);

    void showSnackBar();

}
