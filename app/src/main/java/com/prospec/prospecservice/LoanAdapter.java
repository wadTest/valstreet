package com.prospec.prospecservice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class LoanAdapter extends RecyclerView.Adapter<LoanAdapter.LoanViewHolder> {

    private Context context;
    private ArrayList<String> jobNoStringArrayList, jobEventStringArrayList, cusNameStringArrayList, MarketingStringArrayList, txtLoanStringArrayList,
            iconStringArrayList, phoneStringArrayList, emailStringArrayList, txtTidtoStringArrayLis;
    private OnClickItem onClickItem;
    private LayoutInflater layoutInflater;

    public LoanAdapter(Context context, ArrayList<String> jobNoStringArrayList,
                       ArrayList<String> jobEventStringArrayList,
                       ArrayList<String> cusNameStringArrayList,
                       ArrayList<String> MarketingStringArrayList,
                       ArrayList<String> txtLoanStringArrayList,
                       ArrayList<String> phoneStringArrayList,
                       ArrayList<String> emailStringArrayList,
                       ArrayList<String> iconStringArrayList,
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
        this.iconStringArrayList = iconStringArrayList;
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
        String loanString = txtLoanStringArrayList.get(position);
        String phoneString = phoneStringArrayList.get(position);
        String emailString = emailStringArrayList.get(position);
        String urlIconString = iconStringArrayList.get(position);
        String tidtoString = txtTidtoStringArrayLis.get(position);

//        โชว์ตัวอักษร
        holder.jobNoTextView.setText(jobNoString);
        holder.jobEventTextView.setText(jobEventstring);
        holder.cusNameTextView.setText(cusNameString);
        holder.marketingTextView.setText(marketingString);
        holder.loanTextView.setText(loanString);
        holder.txtPhone.setText(phoneString);
        holder.txtEmail.setText(emailString);
        holder.tidtoTextView.setText(tidtoString);

        //        โชว์รูปภาพ
        Picasso.get()
                .load(urlIconString)
                .resize(200, 200)
                .centerCrop()
                .into(holder.circleImageView);

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

        private TextView jobNoTextView, jobEventTextView, cusNameTextView, marketingTextView, loanTextView, txtPhone, txtEmail, tidtoTextView;
        private CircleImageView circleImageView;

        public LoanViewHolder(View itemView) {
            super(itemView);

            jobNoTextView = itemView.findViewById(R.id.txtJobNo);
            jobEventTextView = itemView.findViewById(R.id.txtJobEvent);
            cusNameTextView = itemView.findViewById(R.id.txtCusName);
            marketingTextView = itemView.findViewById(R.id.txtMarketing);
            loanTextView = itemView.findViewById(R.id.txtLoan);
            txtPhone = itemView.findViewById(R.id.txtPhone);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            tidtoTextView = itemView.findViewById(R.id.txtTidto);

            circleImageView = itemView.findViewById(R.id.circleImageView);
        }
    }    //Second Class

}   // Main Class