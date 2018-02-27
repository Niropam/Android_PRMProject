package com.example.user.project;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context;

    Button personalBtn,ageBtn,systemBtn,exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personalBtn = (Button) findViewById(R.id.CreateProf);
        ageBtn = (Button) findViewById(R.id.AgeCalculator);
        systemBtn = (Button) findViewById(R.id.smile_ratingBar);
        exitBtn = (Button) findViewById(R.id.exit);

        //AlertDialog
//        exitBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder alertButton = new AlertDialog.Builder(context);
//
//                // set title
//                alertButton.setTitle("Want to Exit !!!");
//
//                // set dialog message
//                alertButton
//                        .setMessage("Click 'yes' to exit and 'no' for stay")
//                        .setCancelable(false)
//                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                // if this button is clicked, close
//                                // current activity
//                                Toast.makeText(context, "Thanks for Using app.", Toast.LENGTH_SHORT).show();
//                                MainActivity.this.finish();
//                            }
//                        })
//                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                // if this button is clicked, just close
//                                // the dialog box and do nothing
//                                Toast.makeText(context, "Thanks for Staying in app.", Toast.LENGTH_SHORT).show();
//                                dialog.cancel();
//                            }
//                        });
//
//                // create alert dialog
//                AlertDialog alertDialog = alertButton.create();
//
//                // show it
//                alertDialog.show();
//            }
//
//
//        });


    }
    public void personal(View view) {
        Intent i = new Intent(MainActivity.this,CreateProfile.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    public void calculator(View view) {
        Intent i = new Intent(MainActivity.this,CalenderActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    public void Rating(View view) {
        Intent i = new Intent(MainActivity.this,RatingApp.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }


    public void close(View view) {
        finish();
    }
}
