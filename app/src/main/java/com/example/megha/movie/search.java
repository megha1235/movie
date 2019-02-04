package com.example.megha.movie;

import android.content.DialogInterface;
import android.database.Cursor;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class search extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7,e8;
    Button b1,b2,b3;
    MOVIEHELPER m2;
    String s1,s2,s3,s4,s5,s6,s7,s8,update1,id,a1,a2,a3,a4,a5,a6;
    TextView a,b,c,d,e,f,g;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        e1=(EditText)findViewById(R.id.nm);
        b1=(Button)findViewById(R.id.search);
        b2=(Button)findViewById(R.id.up);
        b3=(Button)findViewById(R.id.dlt);
        e2=(EditText)findViewById(R.id.a1);
        e3=(EditText)findViewById(R.id.a2);
        e4=(EditText)findViewById(R.id.a3);
        e5=(EditText)findViewById(R.id.a4);
        e6=(EditText)findViewById(R.id.a5);
        e7=(EditText)findViewById(R.id.a6);
        e8=(EditText)findViewById(R.id.a7);
        a=(TextView)findViewById(R.id.a);
        b=(TextView)findViewById(R.id.b);
        c=(TextView)findViewById(R.id.c);
        d=(TextView)findViewById(R.id.d);
        e=(TextView)findViewById(R.id.e);
        f=(TextView)findViewById(R.id.f);
        g=(TextView)findViewById(R.id.g);
        builder=new AlertDialog.Builder(this);
        builder.setTitle("confirm");
        builder.setMessage("Are you sure Want to dlt");
       builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {


               boolean status=m2.dlt(id);
               Toast.makeText(getApplicationContext(),String.valueOf(status),Toast.LENGTH_LONG).show();
               Log.d("status",String.valueOf(status));
//               if (status==true)
//               {
//                   Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_LONG).show();
//               }
//               else
//               {
//                   Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();
//               }

               dialogInterface.dismiss();

           }

       });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"no clicked",Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();

            }
        });
        final MOVIEHELPER m2;
        m2=new MOVIEHELPER(this);
        m2.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                Cursor cur=m2.searchdata(s1);
                if (cur.getCount()==0)
                {
                   Toast.makeText(getApplicationContext(),"no result",Toast.LENGTH_LONG).show();
                }
                else
                {
                    while (cur.moveToNext()) {
                        id=cur.getString(0);
                        s2 = cur.getString(2);
                        s3 = cur.getString(3);
                        s4 = cur.getString(4);
                        s5 = cur.getString(5);
                        s6 = cur.getString(6);
                        s7 = cur.getString(7);
                        s8= cur.getString(8);

                        Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
                        //Toast.makeText(getApplicationContext(), s3, Toast.LENGTH_LONG).show();
                        //Toast.makeText(getApplicationContext(), s4, Toast.LENGTH_LONG).show();
                        //Toast.makeText(getApplicationContext(), s5, Toast.LENGTH_LONG).show();
                        //Toast.makeText(getApplicationContext(), s6, Toast.LENGTH_LONG).show();
                        //Toast.makeText(getApplicationContext(), s7, Toast.LENGTH_LONG).show();
                    }
                    e2.setVisibility(View.VISIBLE);
                    e2.setText(s2);
                    e3.setVisibility(View.VISIBLE);
                    e3.setText(s3);
                    e4.setVisibility(View.VISIBLE);
                    e4.setText(s4);
                    e5.setVisibility(View.VISIBLE);
                    e5.setText(s5);
                    e6.setVisibility(View.VISIBLE);
                    e6.setText(s6);
                    e7.setVisibility(View.VISIBLE);
                    e7.setText(s7);
                    e8.setVisibility(View.VISIBLE);
                    e8.setText(s8);

                    a.setVisibility(View.VISIBLE);

                    b.setVisibility(View.VISIBLE);

                    c.setVisibility(View.VISIBLE);

                    d.setVisibility(View.VISIBLE);

                    e.setVisibility(View.VISIBLE);

                    f.setVisibility(View.VISIBLE);
                    g.setVisibility(View.VISIBLE);
                    b2.setVisibility(View.VISIBLE);
                    b3.setVisibility(View.VISIBLE);



                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update1=e2.getText().toString();
                a1=e3.getText().toString();
                a2=e4.getText().toString();
                a3=e5.getText().toString();
                a4=e6.getText().toString();
                a5=e7.getText().toString();
                a6=e8.getText().toString();

              //  Toast.makeText(getApplicationContext(),update1,Toast.LENGTH_LONG).show();
                boolean status=m2.update(id,update1,a1,a2,a3,a4,a5,a6);
                if (status==true)
                {
                    Toast.makeText(getApplicationContext(),"update",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();
                }



            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
            //    boolean status=m2.dlt(id);
            //    if (status==true)
             //   {
             //       Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_LONG).show();
               // }
               // else
               //{
                    //Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();
               // }
               AlertDialog alert=builder.create();
               alert.show();

           }
        });
    }
    }
