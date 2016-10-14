package com.rfachrur.mnote.DBackup;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Created by rfachrur on 10/13/16.
 *
 */

public class SaveDatabase {

    public static boolean save(){
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String currentDBPath = "//data//" + "com.rfachrur.mnote"
                        + "//databases//" + "mnote.db";
                String backupDBPath = "/MNoteBackup.db";
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                FileChannel src = new FileInputStream(currentDB).getChannel();
                FileChannel dst = new FileOutputStream(backupDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
            }
            return true;
        } catch (Exception e){
            Log.e("TAG SAVE DB",e.getLocalizedMessage());
            return false;
        }
    }

}
