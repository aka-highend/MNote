package com.rfachrur.mnote;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;

import com.rfachrur.mnote.InterfaceView.MainView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
        , SearchView.OnQueryTextListener, MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
