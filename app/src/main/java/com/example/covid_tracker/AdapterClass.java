package com.example.covid_tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterClass extends ArrayAdapter<ModalClass> {

    private Context context;

    List<ModalClass>list;


    public AdapterClass(@NonNull Context context, List<ModalClass>list) {
        super(context, R.layout.testing,list);
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.testing,null,false);
       TextView state=v.findViewById(R.id.state);
       TextView city= v.findViewById(R.id.city);
       TextView active= v.findViewById(R.id.active_case);
       TextView recover=v.findViewById(R.id.recover_case);
       TextView confirm= v.findViewById(R.id.confirm_case);

       state.setText(list.get(position).getState());
       city.setText(list.get(position).getCity());
       active.setText(list.get(position).getActive());
       recover.setText(list.get(position).getRecover());
       confirm.setText(list.get(position).getConfirm());
       return v;
    }
}
