package com.minhle.may17;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {

    public  interface DataPasser{
        public void onPassingData(String data);
    }

    DataPasser dataPasser;

    public static int count;

    private String data;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        dataPasser = (DataPasser) context;
    }

    @Override
    public void onCreate(@Nullable Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        assert this.getArguments() != null;
        this.data = this.getArguments().getString("hello");
//        Button sendDataButton = (Button) getActivity().findViewById(R.id.sendDataButton);
//        sendDataButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
          assert this.getArguments() != null;
          String test = data;
        Log.i("MIRMOHAMMAD",test);
//        User user = new User();
//        Random rand = new Random();
//        user.setFirstName(String.valueOf(rand.nextBoolean()));
//        user.setLastName(String.valueOf(rand.nextBoolean()));
        count++;
        return inflater.inflate(R.layout.my_fragment, container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((MainActivity)getActivity()).mir("Hello!!!");
        dataPasser.onPassingData("Hello!!!");
    }
}

