package com.prospec.prospecservice.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.prospec.prospecservice.R;

public class LandsFragment extends Fragment {

    //    ประกาศตัวแปร

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Crete Toolbar
        creteToolbar();

    }// Method

    private void creteToolbar() {

        Toolbar toolbar = getView().findViewById(R.id.toolbar_land_tab1);
        ((FormActivity) getActivity()).setSupportActionBar(toolbar);
        ((FormActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.lands));
        ((FormActivity) getActivity()).getSupportActionBar().setSubtitle(getString(R.string.massage_alert));
        ((FormActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((FormActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        setHasOptionsMenu(true);
    }//end creteToolbar

}//Main Class
