package com.minhle.may17;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements MyFragment.DataPasser {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttons();
    }

    private void buttons(){
        Button button = (Button) findViewById(R.id.addFragment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("hello","hi");
                MyFragment myFragment = new MyFragment();
                myFragment.setArguments(bundle);
                if(MyFragment.count %2 ==0) {
                    fragmentTransaction.add(R.id.fragmentContainer, myFragment);
                }
                else {
                    fragmentTransaction.add(R.id.fragmentContainer2, myFragment);
                }
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    public void mir(String data){
        Log.i("MIR", data);
    }

    @Override
    public void onPassingData(String data) {
        Log.i("DATAPASSER", data);
    }
}
