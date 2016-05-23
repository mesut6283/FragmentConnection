package com.masoud.example.fragmentconnection;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void respond(String data) {
        FragmentManager manager=getFragmentManager();
        FragmentB f2= (FragmentB) manager.findFragmentById(R.id.fragment2);
        f2.changeText(data);
    }
}
