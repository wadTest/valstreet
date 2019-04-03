package com.prospec.prospecservice.utility;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.prospec.prospecservice.OnClickItem;
import com.prospec.prospecservice.R;

import java.util.ArrayList;

public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.DocumentViewHolder>{

    private Context context;
    private ArrayList<String> docStringArrayList, numberDocStringArrayList, areaDocStringArrayList;
    private OnClickItem onClickItem;
    private LayoutInflater layoutInflater;

    public DocumentAdapter(Context context, ArrayList<String> docStringArrayList, ArrayList<String> numberDocStringArrayList, ArrayList<String> areaDocStringArrayList, OnClickItem onClickItem) {
        this.layoutInflater = LayoutInflater.from(context);
        this.docStringArrayList = docStringArrayList;
        this.numberDocStringArrayList = numberDocStringArrayList;
        this.areaDocStringArrayList = areaDocStringArrayList;
        this.onClickItem = onClickItem;
    }

    @NonNull
    @Override
    public DocumentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.recycler_document,parent,false);
        DocumentViewHolder documentViewHolder = new DocumentViewHolder(view);

        return documentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final DocumentViewHolder holder, int position) {

        String document = docStringArrayList.get(position);
        String number = numberDocStringArrayList.get(position);
        String area = areaDocStringArrayList.get(position);

        holder.item1TextView.setText(document);
        holder.item2TextView.setText(number);
        holder.item3TextView.setText(area);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItem.onClickItem(v, holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return docStringArrayList.size();
    }

    public class DocumentViewHolder extends RecyclerView.ViewHolder {

        private TextView item1TextView, item2TextView, item3TextView;

        public DocumentViewHolder(View itemView) {
            super(itemView);

            item1TextView = itemView.findViewById(R.id.txtItem1);
            item2TextView = itemView.findViewById(R.id.txtItem2);
            item3TextView = itemView.findViewById(R.id.txtItem3);
        }
    }
}


