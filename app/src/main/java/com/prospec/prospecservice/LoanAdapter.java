package com.prospec.prospecservice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LoanAdapter extends RecyclerView.Adapter<LoanAdapter.LoanViewHolder> {

    private Context context;
    private ArrayList<String> jobNoStringArrayList, jobEventStringArrayList, cusNameStringArrayList, MarketingStringArrayList, txtLoanStringArrayList,
            imageStringArrayList, phoneStringArrayList, emailStringArrayList, txtTidtoStringArrayLis;
    private OnClickItem onClickItem;
    private LayoutInflater layoutInflater;


    public LoanAdapter(Context context, ArrayList<String> jobNoStringArrayList,
                       ArrayList<String> jobEventStringArrayList,
                       ArrayList<String> cusNameStringArrayList,
                       ArrayList<String> MarketingStringArrayList,
                       ArrayList<String> txtLoanStringArrayList,
                       ArrayList<String> phoneStringArrayList,
                       ArrayList<String> emailStringArrayList,
                       ArrayList<String> imageStringArrayList,
                       ArrayList<String> txtTidtoStringArrayLis,
                       OnClickItem onClickItem) {

        this.layoutInflater = LayoutInflater.from(context);
        this.jobNoStringArrayList = jobNoStringArrayList;
        this.jobEventStringArrayList = jobEventStringArrayList;
        this.cusNameStringArrayList = cusNameStringArrayList;
        this.MarketingStringArrayList = MarketingStringArrayList;
        this.txtLoanStringArrayList = txtLoanStringArrayList;
        this.phoneStringArrayList = phoneStringArrayList;
        this.emailStringArrayList = emailStringArrayList;
        this.imageStringArrayList = imageStringArrayList;
        this.txtTidtoStringArrayLis = txtTidtoStringArrayLis;
        this.onClickItem = onClickItem;
    }

    @NonNull
    @Override
    public LoanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.recyclerview_loan, parent, false);
        LoanViewHolder loanViewHolder = new LoanViewHolder(view);

        return loanViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final LoanViewHolder holder, int position) {

        String jobNoString = jobNoStringArrayList.get(position);
        String jobEventstring = jobEventStringArrayList.get(position);
        String cusNameString = cusNameStringArrayList.get(position);
        String marketingString = MarketingStringArrayList.get(position);
        String loanString = MarketingStringArrayList.get(position);
        String phoneString = phoneStringArrayList.get(position);
        String emailString = emailStringArrayList.get(position);
        String imageString = imageStringArrayList.get(position);
        String tidtoString = txtTidtoStringArrayLis.get(position);

        holder.jobNoTextView.setText(jobNoString);
        holder.jobEventTextView.setText(jobEventstring);
        holder.cusNameTextView.setText(cusNameString);
        holder.marketingTextView.setText(marketingString);
        holder.loanTextView.setText(loanString);
        holder.txtPhone.setText(phoneString);
        holder.txtEmail.setText(emailString);
        holder.Image.setText(imageString);
        holder.tidtoTextView.setText(tidtoString);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItem.onClickItem(v, holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return jobNoStringArrayList.size();
    }

    public class LoanViewHolder extends RecyclerView.ViewHolder {

        private TextView jobNoTextView, jobEventTextView, cusNameTextView, marketingTextView, loanTextView, Image, txtPhone, txtEmail, tidtoTextView;

        public LoanViewHolder(View itemView) {
            super(itemView);

            jobNoTextView = itemView.findViewById(R.id.txtJobNo);
            jobEventTextView = itemView.findViewById(R.id.txtJobEvent);
            cusNameTextView = itemView.findViewById(R.id.txtCusName);
            marketingTextView = itemView.findViewById(R.id.txtMarketing);
            loanTextView = itemView.findViewById(R.id.txtLoan);
            txtPhone = itemView.findViewById(R.id.txtPhone);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            Image = itemView.findViewById(R.id.txtImage);
            tidtoTextView = itemView.findViewById(R.id.txtTidto);

        }
    }    //Second Class

}   // Main Class