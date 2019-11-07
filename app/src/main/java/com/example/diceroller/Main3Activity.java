package com.example.diceroller;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
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



    }


    public void on_cancelbutton_click(View view){

        //brings user back to icebreakers game
        Intent intent = new Intent ( Main3Activity.this, Main2Activity.class);
        startActivity(intent);
    }

    public void on_savebutton_click(View view){


        EditText mEdit2 = findViewById(R.id.enterQButton);

        Editable qnEntered = mEdit2.getText();


        //adds Qn entered to the arraylist
        Main2Activity ma2 = new Main2Activity();
        ma2.addtoQuestionDB(qnEntered.toString());

        MainActivity ma1 = new MainActivity();
        ma1.increasearlistSize();


        //brings user back to icebreakers game
        Intent intent = new Intent ( Main3Activity.this, Main2Activity.class);
        startActivity(intent);


    }

}
