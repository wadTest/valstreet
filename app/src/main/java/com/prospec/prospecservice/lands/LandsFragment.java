package com.prospec.prospecservice.lands;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.prospec.prospecservice.R;
import com.prospec.prospecservice.utility.MyAlert;

public class LandsFragment extends Fragment {

    //    Explicit
    private boolean spinnerABoolean = true; // true ==> โปรดเลือกประเภท
    private  String typeDocString;
    private String[] strings;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Crete Toolbar
        creteToolbar();

//        Create Spinner
        createSpinner();


    }//Main Method

    private void createSpinner() {
        final Spinner spinner = getView().findViewById(R.id.spinner1);
        MyConstant myConstant = new MyConstant();
        strings = myConstant.getSpinner1();

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);

        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {

                if (i == 0) {
                    spinnerABoolean = true;
                } else {
                    spinnerABoolean = false;
                }

                typeDocString = Integer.toString(i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.itemUpload) {

            checDataAndUpload();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void checDataAndUpload() {

//        Initial View
        EditText editText1 = getView().findViewById(R.id.editT1);
        EditText editText2 = getView().findViewById(R.id.editT2);
        EditText editText3 = getView().findViewById(R.id.editT3);
        EditText editText4 = getView().findViewById(R.id.editT4);
        EditText editText5 = getView().findViewById(R.id.editT5);
        EditText editText6 = getView().findViewById(R.id.editT6);
        EditText editText7 = getView().findViewById(R.id.editT7);
        EditText editText8 = getView().findViewById(R.id.editT8);
        EditText editText9 = getView().findViewById(R.id.editT9);
        EditText editText10 = getView().findViewById(R.id.editT10);

        String string1 = editText1.getText().toString().trim();
        String string2 = editText2.getText().toString().trim();
        String string3 = editText3.getText().toString().trim();
        String string4 = editText4.getText().toString().trim();
        String string5 = editText5.getText().toString().trim();
        String string6 = editText6.getText().toString().trim();
        String string7 = editText7.getText().toString().trim();
        String string8 = editText8.getText().toString().trim();
        String string9 = editText9.getText().toString().trim();
        String string10 = editText10.getText().toString().trim();

        if (string1.isEmpty() || string2.isEmpty() || string3.isEmpty() || string4.isEmpty() ||
                string5.isEmpty() || string6.isEmpty() || string7.isEmpty()) {

//            Have Space
            MyAlert myAlert = new MyAlert(getActivity());
            myAlert.normalDialog(getString(R.string.title_have_space),
                    getString(R.string.massage_have_space));

        }else if(spinnerABoolean) {
//            position ==> 0
            MyAlert myAlert = new MyAlert(getActivity());
            myAlert.normalDialog(getString(R.string.title_type_doc1),getString(R.string.message_type_doc1));

        }else {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setCancelable(false);
            builder.setIcon(R.drawable.ic_action_alert);
            builder.setTitle(R.string.title_comfirm);
            builder.setMessage(getString(R.string.number_land)+ "=" +string1+ "\n" +
                    getString(R.string.numbers)+ "=" +string2+ "\n" +
                    getString(R.string.area)+ "=" + strings [Integer.parseInt(typeDocString)] + "\n" +
                    getString(R.string.all)+ "=" +string3+ "\n" +
                    getString(R.string.road)+ "=" +string4+ "\n" +
                    getString(R.string.soi)+ "=" +string5+ "\n" +
                    getString(R.string.project)+ "=" +string7+ "\n" +
                    getString(R.string.nameniti)+ "=" +string8+ "\n" +
                    getString(R.string.address)+ "=" +string9+ "\n" +
                    getString(R.string.telephone)+ "=" +string10);
            builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.show();

        }//if

    }//checkData

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_tab,menu);
    }

    private void creteToolbar() {

        Toolbar toolbar = getView().findViewById(R.id.toolbar_land_tab1);
        ((FormActivity)getActivity()).setSupportActionBar(toolbar);
        ((FormActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.lands));
        ((FormActivity) getActivity()).getSupportActionBar().setSubtitle(getString(R.string.massage_have_space));

        ((FormActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((FormActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        setHasOptionsMenu(true);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lands, container, false);
        return view;
    }
}//Main Class