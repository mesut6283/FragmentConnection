package com.masoud.example.fragmentconnection;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by MASOUD on 5/22/2016.
 */
public class FragmentA extends Fragment implements View.OnClickListener {
    Button button;
    int counter;
    Communicator comm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null )
        {counter=0;

        }else {
        counter=savedInstanceState.getInt("counter",0);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_a,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button= (Button) getActivity().findViewById(R.id.button);
        comm = (Communicator) getActivity();
        button.setOnClickListener(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter",counter);
    }

    @Override
    public void onClick(View v) {

        counter++;
        comm.respond("the Button was clicked "+counter+"time");
    }
}
