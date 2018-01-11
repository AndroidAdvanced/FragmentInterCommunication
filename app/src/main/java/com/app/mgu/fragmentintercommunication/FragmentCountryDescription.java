package com.app.mgu.fragmentintercommunication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Created by 123 on 1/6/2018.
 */
public class FragmentCountryDescription extends Fragment implements View.OnClickListener {

    String TAG = "AB";

    public static FragmentCountryDescription fragmentTest;

    public static FragmentCountryDescription newInstance() {
        if(fragmentTest == null) {
            fragmentTest = new FragmentCountryDescription();
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

    View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        System.out.println(TAG + "onCreateView");

        rootView = inflater.inflate(R.layout.fragment_country_description, container);
        context = container.getContext();

        Toast.makeText(context,"CreateView Fragment Desc", Toast.LENGTH_LONG).show();

        initUi();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    TextView txtCountryDescription;

    public void initUi() {
        txtCountryDescription = (TextView) rootView.findViewById(R.id.txtCountryDesc);
        txtCountryDescription.setText("Text Is Set");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println(TAG + "onViewCreated");
    }

   // Fragment2.Comminicator comminicator;

    String countryName, countryDesc;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println(TAG + "onActivityCreated");

       // comminicator = (Fragment2.Comminicator) getActivity();


        Bundle bundle = getArguments();
        //countryName = bundle.getString("CountrySelected", "India");
        //countryDesc = getString()
    }

    public int getStringId(String countryName) {

        return 1;
//        if(countryName.equals("India")) {
//                return "dsf";
//        } else if(countryName.equals("Indonesia")) {
//            return "dsf";
//        } else if(countryName.equals("Russia")) {
//            return "dsf";
//        } else if(countryName.equals("China")) {
//            return "dsf";
//        } else {
//            return "dsf";
//        }
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
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println(TAG + "onPause");
        Toast.makeText(context,"onPause FDesc", Toast.LENGTH_LONG).show();
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
        Toast.makeText(context,"onDestroyView FDesc", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println(TAG + "onDestroy");
        Toast.makeText(context,"onDestroy FDesc", Toast.LENGTH_LONG).show();
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
//            comminicator.respond("This Button Was Clicked" + counter + "times");
//        } else {
//            Toast.makeText(context,"Is Null", Toast.LENGTH_LONG).show();
//        }
    }
}
