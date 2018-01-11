package com.app.mgu.fragmentintercommunication;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener, CallBackInterface {

    FragmentManager fragmentManager1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        fragmentManager1 = getSupportFragmentManager();

        addCountriesFragment();

//        getSupportFragmentManager().beginTransaction().add(R.id.act, Fragment1.newInstance(), "HI").addToBackStack(null).commit();
//        getSupportFragmentManager().beginTransaction().replace(R.id.act, Fragment2.newInstance(), "HELLO").commit();

//        Button btn1 = (Button) findViewById(R.id.btn1);
//        btn1.setOnClickListener(this);

//        getSupportFragmentManager().beginTransaction().add(R.id.fragment2, Fragment2.newInstance(), "HI").commit();


    }

    FragmentTransaction ft ;

    void addCountriesFragment() {

        ft = fragmentManager1.beginTransaction();

        FragmentCountry fragmentCountry = new FragmentCountry();
        fragmentCountry.setCallbackInterface(this);
        ft.add(R.id.act, fragmentCountry);
        ft.commit();
    }

    void addCountryDesc() {

        ft = fragmentManager1.beginTransaction();

        FragmentCountryDescription fragmentCountry = new FragmentCountryDescription();
        ft.replace(R.id.act, fragmentCountry);
        ft.addToBackStack(null);
        ft.commit();


    }

//    @Override
//    public void respond(String data) {
////        FragmentManager fm = getSupportFragmentManager();
////        Fragment2 frag = (Fragment2) fm.findFragmentById(R.id.fragment2);
////        frag.changetext(data);
//    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void callBackMethod() {
        addCountryDesc();
    }
}
