package com.pragma.mycats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.pragma.mycats.adapters.AdapterCats;
import com.pragma.mycats.api.ApiCatsService;
import com.pragma.mycats.api.ApiClient;
import com.pragma.mycats.model.Cat;
import com.pragma.mycats.model.CatImage;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cats);

        ListView listCats = findViewById(R.id.listCats);

        ApiCatsService catService = ApiClient.getClient().create(ApiCatsService.class);

        Call<ArrayList<Cat>> callCats = catService.getCats("bda53789-d59e-46cd-9bc4-2936630fde39");
        callCats.enqueue(new Callback<ArrayList<Cat>>() {
            @Override
            public void onResponse(Call<ArrayList<Cat>> call, Response<ArrayList<Cat>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<Cat> cats = response.body();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            AdapterCats adapter = new AdapterCats(getApplicationContext(), R.layout.item_list_cat , cats);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            listCats.setAdapter(adapter);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Cat>> call, Throwable t) {
                System.out.println("error");
            }
        });
    }
}
