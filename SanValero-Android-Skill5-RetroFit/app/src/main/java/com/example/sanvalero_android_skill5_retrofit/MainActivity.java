package com.example.sanvalero_android_skill5_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.sanvalero_android_skill5_retrofit.interfaces.JsonPlaceHolder;
import com.example.sanvalero_android_skill5_retrofit.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView jsonTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jsonTextView = findViewById(R.id.jsonText);
        getPost();
    }

    private void getPost() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
        Call<List<Post>> call = jsonPlaceHolder.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {
                    jsonTextView.setText("Error: " + response.code());
                    return;
                }

                List<Post> postList = response.body();

                for (Post post: postList ) {
                    String content = "";
                    content += "userId: " + post.getUserId() + "\n";
                    content += "id: " + post.getId() + "\n";
                    content += "title: " + post.getTitle() + "\n";
                    content += "body: " + post.getBody() + "\n\n";
                    jsonTextView.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                jsonTextView.setText(t.getMessage());
            }
        });

    }
}