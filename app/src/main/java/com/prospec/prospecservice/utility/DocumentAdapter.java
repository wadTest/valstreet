package com.prospec.prospecservice.utility;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.prospec.prospecservice.OnClickItem;
import com.prospec.prospecservice.R;

import java.util.ArrayList;

public class DocumentAdapter {

    private Context context;
    private ArrayList<String> docStringArrayList, numberDocStringArrayList, AreaDocStringArrayList;
    private OnClickItem onClickItem;
    private LayoutInflater layoutInflater;

    public DocumentAdapter(Context context, ArrayList<String> docStringArrayList, ArrayList<String> numberDocStringArrayList, ArrayList<String> areaDocStringArrayList, OnClickItem onClickItem) {
        this.context = context;
        this.docStringArrayList = docStringArrayList;
        this.numberDocStringArrayList = numberDocStringArrayList;
        AreaDocStringArrayList = areaDocStringArrayList;
        this.onClickItem = onClickItem;
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


