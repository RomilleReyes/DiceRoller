package com.example.diceroller;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        //QuestionDB();

        PlayIceBreakers();


    }
    private TextView RandomQuestionButton;
    static ArrayList<String> arlist = new ArrayList<>();


    public void PlayIceBreakers(){


        MainActivity ma = new MainActivity();
        int number = ma.randomNumGenerator();



        RandomQuestionButton = this.findViewById(R.id.RandQText);

        String randomQuestion = arlist.get(number);


        RandomQuestionButton.setText(randomQuestion);



    }

    public ArrayList<String> getList() {
        return arlist;
    }

    public void on_button_click(View view){
        PlayIceBreakers();
    }

    //when button "add your own question" is clicked
    public void on_button2_click(View view){
        Intent intent = new Intent ( Main2Activity.this, Main3Activity.class);
        startActivity(intent);
    }




    public void QuestionDB(){

        //ArrayList<String> arlist = new ArrayList<String>();

        arlist.add("If you could go anywhere in the world, where would you go?");
        arlist.add("If you were stranded on a desert island, what three things would you want to" +
                " take with you?");
        arlist.add("If you could eat only one food for the rest of your life, what would that be?");
        arlist.add("If you won a million dollars, what is the first thing you could buy?");
        arlist.add("If you could spend the day with one fictional character, who would it be?");
        arlist.add("If you found a magic lantern and a genie gave you three wishes, what would you" +
                " wish?");

    }

    public void addtoQuestionDB(String Addme){
        arlist.add(Addme);
    }


}
