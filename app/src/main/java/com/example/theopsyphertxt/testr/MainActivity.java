package com.example.theopsyphertxt.testr;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected TextView lName;   //receives last name input
    protected TextView fName;   //receives first name input
    protected Button submit;    //submit button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fName = (TextView) findViewById(R.id.firstName);
        lName = (TextView) findViewById(R.id.lastName);
        submit = (Button) findViewById(R.id.button);

        //below what happens onclick of button submit
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //retrieve and store input in below
                String fname = fName.getText().toString().trim();
                String lname = lName.getText().toString().trim();

                //ensure inputs are not empty
                if (fname.isEmpty() && lname.isEmpty()) {
                    String msg = getString(R.string.error_msg1);
                    createDialogue(msg);
                }
                else if (fname.isEmpty()) {
                    String msg = getString(R.string.error_msg2);
                    createDialogue(msg);
                }
                else if (lname.isEmpty()) {
                    String msg = getString(R.string.error_msg3);
                    createDialogue(msg);
                }
                else
                    fullName(fname, lname, MainActivity.this);  //when details are correct
                //Toast.makeText(MainActivity.this,fullname,Toast.LENGTH_LONG).show();
            }
        });
    }

    private void createDialogue(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.input_error)
                .setMessage(msg)
                .setPositiveButton(android.R.string.ok, null);
        AlertDialog dialog = builder.create();
        builder.show();
    }

    private void fullName(String fn, String ln, Context context) {
        String fullname = fn + "  " + ln;
        Toast.makeText(context, fullname, Toast.LENGTH_LONG).show();
        //above function is generic so it can be called elsewhere easily
    }


}
