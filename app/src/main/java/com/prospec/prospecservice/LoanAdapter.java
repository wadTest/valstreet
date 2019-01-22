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
    private ArrayList<String> jobNoStringArrayList, jobEventStringArrayList, cusNameStringArrayList, MarketingStringArrayList;
    private OnClickItem onClickItem;
    private LayoutInflater layoutInflater;


    public LoanAdapter(Context context, ArrayList<String> jobNoStringArrayList,
                       ArrayList<String> jobEventStringArrayList,
                       ArrayList<String> cusNameStringArrayList,
                       ArrayList<String> MarketingStringArrayList,

                       OnClickItem onClickItem) {

        this.layoutInflater = LayoutInflater.from(context);
        this.jobNoStringArrayList = jobNoStringArrayList;
        this.jobEventStringArrayList = jobEventStringArrayList;
        this.cusNameStringArrayList = cusNameStringArrayList;
        this.MarketingStringArrayList = MarketingStringArrayList;
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

        holder.jobNoTextView.setText(jobNoString);
        holder.jobEventTextView.setText(jobEventstring);
        holder.cusNameTextView.setText(cusNameString);
        holder.marketingTextView.setText(marketingString);

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

        private TextView jobNoTextView, jobEventTextView, cusNameTextView, marketingTextView;

        public LoanViewHolder(View itemView) {
            super(itemView);

            jobNoTextView = itemView.findViewById(R.id.txtJobNo);
            jobEventTextView = itemView.findViewById(R.id.txtJobEvent);
            cusNameTextView = itemView.findViewById(R.id.txtCusName);
            marketingTextView = itemView.findViewById(R.id.txtMarketing);


        }
    }    //Second Class

}   // Main Class