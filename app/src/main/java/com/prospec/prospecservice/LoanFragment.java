package com.prospec.prospecservice;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoanFragment extends Fragment {


    public LoanFragment() {
        // Required empty public constructor
    }

    public static LoanFragment loanInstance(String jsonString) {

        LoanFragment loanFragment = new LoanFragment();
        Bundle bundle = new Bundle();
        bundle.putString("json", jsonString);
        loanFragment.setArguments(bundle);
        return loanFragment;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create RecyclerView
        RecyclerView recyclerView = getView().findViewById(R.id.recyclerLoan);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        try {

            JSONArray jsonArray = new JSONArray(getArguments().getString("json"));

            final ArrayList<String> jobNoStringArrayList = new ArrayList<>();
            final ArrayList<String> jobEventStringArrayList = new ArrayList<>();
            final ArrayList<String> cutNameStringArrayList = new ArrayList<>();
            final ArrayList<String> marketingStringArrayList = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i += 1) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                jobNoStringArrayList.add(jsonObject.getString("job_no")+"\n");
                jobEventStringArrayList.add(jsonObject.getString("job_event")+"\n");
                cutNameStringArrayList.add(jsonObject.getString("customer_name")+"\n");
                marketingStringArrayList.add(jsonObject.getString("marketing")+"\n");

            }

            LoanAdapter loanAdapter = new LoanAdapter(getActivity(), jobNoStringArrayList, jobEventStringArrayList, cutNameStringArrayList, marketingStringArrayList, new OnClickItem() {
                @Override
                public void onClickItem(View view, int position) {
                    showAlert(jobNoStringArrayList.get(position), jobEventStringArrayList.get(position), cutNameStringArrayList.get(position), marketingStringArrayList.get(position));
                }
            });
            recyclerView.setAdapter(loanAdapter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String jobNo, String jobEvent, String cusName, String marketing) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle("รายละเอียดงาน").setMessage("รหัสงาน : " + jobNo + "\n" + "ชื่อลูกค้า : " + cusName + "\n" + "สถานะงาน : " + jobEvent + "\n"+ "เจ้าหน้าที่การตลาด : " + marketing)
                .setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loan, container, false);
    }
}