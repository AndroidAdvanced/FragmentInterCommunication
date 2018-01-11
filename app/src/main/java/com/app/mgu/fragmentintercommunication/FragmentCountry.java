package com.app.mgu.fragmentintercommunication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by 123 on 1/6/2018.
 */
public class FragmentCountry extends Fragment implements View.OnClickListener {

    String TAG = "AB";

    public static FragmentCountry fragmentTest;

    String[] strCountry;

    ListView listView;

    public static FragmentCountry newInstance() {
        if(fragmentTest == null) {
            fragmentTest = new FragmentCountry();
        }
        return fragmentTest;
    }

    public void onAttachF(Activity a) {
        System.out.println(TAG + "onAttAch");
    }

    Context context;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println(TAG + "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println(TAG + "onCreateView");
        View v = inflater.inflate(R.layout.fragment_country, container);
        context = container.getContext();
        initUi();

        Toast.makeText(context,"CreateView FragmentCountry", Toast.LENGTH_LONG).show();

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println(TAG + "onViewCreated");
    }

    //Fragment2.Comminicator comminicator;

    ArrayAdapter<String> countryNameAdapter;

    CallBackInterface callBackInterface;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        System.out.println(TAG + "onActivityCreated");

       // comminicator = (Fragment2.Comminicator) getActivity();
    }

    public void setCallbackInterface(CallBackInterface callBackInterface) {
        this.callBackInterface = callBackInterface;
    }

    public void initUi() {

        Toast.makeText(context,"CreateView FragmentCountry Called initUI", Toast.LENGTH_LONG).show();

        listView = (ListView) getActivity().findViewById(R.id.listView);
        strCountry = getResources().getStringArray(R.array.countries);

        countryNameAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, strCountry);
        listView.setAdapter(countryNameAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(callBackInterface != null) {
                    callBackInterface.callBackMethod();
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println(TAG + "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();

        System.out.println(TAG + "onResume");

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Please Select Country");
    }

    @Override
    public void onPause() {
        super.onPause();

        System.out.println(TAG + "onPause");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Please Select Country");
        Toast.makeText(context,"onPause FCountry", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println(TAG + "onSavedInstanceState");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println(TAG + "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println(TAG + "onDestroyView");
        Toast.makeText(context,"onDestroyView FCountry", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println(TAG + "onDestroy");
        Toast.makeText(context,"onDestroy FCountry", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println(TAG + "onDetach");
    }

    int counter = 0;
    @Override
    public void onClick(View v) {
        counter++;
//        if(comminicator != null) {
//          //  comminicator.respond("This Button Was Clicked" + counter + "times");
//        } else {
//            Toast.makeText(context,"Is Null", Toast.LENGTH_LONG).show();
//        }
    }
}
