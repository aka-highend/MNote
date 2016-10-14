package com.rfachrur.mnote.ViewAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rfachrur.mnote.R;

/**
 * Created by rfachrur on 10/13/16.
 *
 */

class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    TextView title;
    ImageView imageView;
    TextView dateView;

    MainViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        imageView = (ImageView) itemView.findViewById(R.id.letter_head);
        dateView = (TextView) itemView.findViewById(R.id.dateView);

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}
