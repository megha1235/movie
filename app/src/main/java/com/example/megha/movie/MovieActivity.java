package com.example.megha.movie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MovieActivity extends AppCompatActivity {
EditText e1,e2,e3,e4,e5,e6,e7,e8;
    Button b1,b2;
    String s1,s2,s3,s4,s5,s6,s7,s8;
    MOVIEHELPER m1;
    Spinner s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        e1=(EditText)findViewById(R.id.nm);
        e2=(EditText)findViewById(R.id.ano);
        e3=(EditText)findViewById(R.id.clg);
        e4=(EditText)findViewById(R.id.ln);
        e5=(EditText)findViewById(R.id.DS);
        e6=(EditText)findViewById(R.id.pd);
        e7=(EditText)findViewById(R.id.SAL);
        e8=(EditText)findViewById(R.id.CMP);
        b1=(Button)findViewById(R.id.subm);
        s=(Spinner)findViewById(R.id.language);
        b2=(Button)findViewById(R.id.search);

        m1=new MOVIEHELPER(this);
        m1.getWritableDatabase();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                s5=e5.getText().toString();
                s6=e6.getText().toString();
                s7=e7.getText().toString();
                s8=e8.getText().toString();

                Log.d("name",s1);
                Log.d("nam",s2);
                Log.d("namI",s3);
                Log.d("na",s4);
                Log.d("n",s5);
                Log.d("ame",s6);
                Log.d("me",s7);
               boolean status=m1.insertdata(s1,s2,s3,s4,s5,s6,s7,s8);
                if (status==true)
                {
                    Toast.makeText(getApplicationContext(),"insert",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent g=new Intent(getApplicationContext(),search.class);
                startActivity(g);
            }
        });
    }
}
