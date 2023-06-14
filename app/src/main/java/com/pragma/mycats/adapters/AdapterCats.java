package com.pragma.mycats.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.pragma.mycats.R;
import com.pragma.mycats.model.Cat;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterCats extends ArrayAdapter<Cat> {

    private Context context;
    int resource;


    public AdapterCats(@NonNull Context context, int resource, @NonNull ArrayList<Cat> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(resource,viewGroup,false);

        TextView tvRaza = view.findViewById(R.id.raza);
        TextView tvPaisOrigen = view.findViewById(R.id.paisOrigen);
        TextView tvInteligencia = view.findViewById(R.id.intelligence);
        ImageView imgCat = view.findViewById(R.id.imgCat);

        tvRaza.setText(tvRaza.getText().toString().concat(getItem(i).getName()));

        tvPaisOrigen.setText(tvPaisOrigen.getText().toString().concat(getItem(i).getOrigin()));

        int inte = getItem(i).getIntelligence();
        if(null != String.valueOf(inte)){
            tvInteligencia.setText(tvInteligencia.getText().toString().concat(String.valueOf(inte)));
        }

        Picasso.get().load("https://cdn2.thecatapi.com/images/" + getItem(i).getReference_image_id() + ".jpg").into(imgCat);

        return view;
    }

}
