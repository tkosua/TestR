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

    protected TextView lName;
    protected TextView fName;
    protected Button submit;
    Context contexts;
    String fname;
    String lname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fName = (TextView) findViewById(R.id.firstName);
        lName = (TextView) findViewById(R.id.lastName);
        submit = (Button) findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fname = fName.getText().toString().trim();
                lname = lName.getText().toString().trim();

                //String fullname = fname + "  " + lname;

                if (fname.isEmpty() || lname.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle(R.string.input_error)
                            .setMessage(R.string.error_message)
                            .setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    builder.show();
                } else
                    fullName(fname, lname, MainActivity.this);
                //Toast.makeText(MainActivity.this,fullname,Toast.LENGTH_LONG).show();
            }
        });
    }
    private void fullName(String fn, String ln, Context context) {

        String fullname = fn + "  " + ln;
        Toast.makeText(context, fullname, Toast.LENGTH_LONG).show();
    }

}
