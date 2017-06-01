package com.example.student4.jsontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Comment;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    class Comment {
        String author;

        @Override
        public String toString() {
            return "Comment{" +
                    "author='" + author + '\'' +
                    ", text='" + text + '\'' +
                    '}';
        }

        String text;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // получить строку
        String j ="";
        j="[{\"author\":\"First\",\"text\":\"labudabudabdab\"},{\"author\":\"Second\",\"text\":\"whaaat\"}]";
        //вывести строку
        TextView json =(TextView) findViewById(R.id.json);
        json.setText(j);
        //преобразовать список объектов
        Gson  g =new Gson();

        List<Comment> comments =g.fromJson(j, new TypeToken<List<Comment>>(){}.getType());


        //вывести список объектов
        TextView objects =(TextView) findViewById(R.id.comment);
        objects.setText(comments.toString());
    }
}
