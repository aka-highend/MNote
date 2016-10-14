package com.rfachrur.mnote.Utils;

import android.content.Context;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rfachrur on 10/13/16.
 *
 */

public class FormatDateTime {

    private Context context;

    public FormatDateTime(Context context) { this.context = context; }

    public String formatDate(Date date) {
        java.text.DateFormat finalDataFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        java.text.DateFormat finalTimeFormat;

        if (android.text.format.DateFormat.is24HourFormat(context)) {
            finalTimeFormat = new SimpleDateFormat("HH:mm");
        } else {
            finalTimeFormat = new SimpleDateFormat("hh:mm a");
        }

        String finalData = finalDataFormat.format(date);
        String finalTime = finalTimeFormat.format(date);
        return finalData + " " + finalTime;
    }
}
