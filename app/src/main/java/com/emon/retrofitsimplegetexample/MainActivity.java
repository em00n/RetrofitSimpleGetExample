package com.emon.retrofitsimplegetexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.emon.retrofitsimplegetexample.adapter.MyAdapter;
import com.emon.retrofitsimplegetexample.model.Model;
import com.emon.retrofitsimplegetexample.model.Post;
import com.emon.retrofitsimplegetexample.retrofit.ApiClient;
import com.emon.retrofitsimplegetexample.retrofit.JsonPlaceHolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
TextView textView;
private RecyclerView recyclerView;
private MyAdapter mAdapter;
//private List<Post>postList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
       // recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // postList=new ArrayList<>();


       getData();
    }

    private void getData() {
        Map<String,String> peramiters=new HashMap<>();
        peramiters.put("albumId","1");
        peramiters.put("sort","id");
        peramiters.put("order","desc");
        JsonPlaceHolder jsonPlaceHolder= ApiClient.getClient().create(JsonPlaceHolder.class);
        Call<List<Model>>call = jsonPlaceHolder.getModel(new Integer[]{1,3},"id",null);

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if (!response.isSuccessful()){
                    //  textView.setText("Code: "+response.code());
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                // int statusCode=response.code();
                List<Model>postList=response.body();
                // mAdapter=new MyAdapter(MainActivity.this,postList);
                recyclerView.setAdapter(new MyAdapter(getApplicationContext(),postList));

            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                // textView.setText(t.getMessage());
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
