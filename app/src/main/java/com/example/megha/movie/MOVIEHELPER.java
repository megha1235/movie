package com.example.megha.movie;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 1/30/2019.
 */
public class MOVIEHELPER extends SQLiteOpenHelper {
    public static final String dbname="dbms.db";
    public static final String tablename="movie";
    public static final String col1="id";
    public static final String col2="name";
    public static final String col3="actor";
    public static final String col4="actress";
    public static final String col5="releaseyear";
    public static final String col6="director";
    public static final String col7="producer";
    public static final String col8="cameraman";
    public static final String col9 ="totalcollection";

    public MOVIEHELPER(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Querry = "create table "+tablename+"("+col1+" integer primary key autoincrement,"+col2+" text,"+col3+" text,"+col4 +" text,"+col5 +" text,"+col6+" text,"+col7+" text,"+col8+" text,"+col9+" text )";
        Log.d("querry",Querry);


        sqLiteDatabase.execSQL(Querry);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String Querry = "drop table if exists " + tablename;
        sqLiteDatabase.execSQL(Querry);
        onCreate(sqLiteDatabase);

    }
    public boolean insertdata(String name,String actor,String actress,String releaseyr,String director,String producer,String cameraman,String totalcollection)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,name);
        contentValues.put(col3,actor);
        contentValues.put(col4,actress);
        contentValues.put(col5,releaseyr);
        contentValues.put(col6,director);
        contentValues.put(col7,producer);
        contentValues.put(col8,cameraman);
        contentValues.put(col9,totalcollection);
        long status=sqLiteDatabase.insert(tablename,null,contentValues);
        if (status==-1)
        {
            return false;
        }
        else
        {
            return true;

        }
    }
    public Cursor searchdata(String name)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cur=sqLiteDatabase.rawQuery("SELECT * FROM "+tablename+" WHERE "+col2+"='"+name+"'",null);
        return cur;
    }
    public boolean update(String id,String actor,String actress,String releaseyr,String director,String producer,String cameraman,String totalcollection)
       {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
           contentValues.put(col3, actor);
           contentValues.put(col4,actress);
           contentValues.put(col5,releaseyr);
           contentValues.put(col6,director);
           contentValues.put(col7,producer);
           contentValues.put(col8,cameraman);
           contentValues.put(col9,totalcollection);
        long status = sqLiteDatabase.update(tablename, contentValues, col1 + "=" + id, null);
        if (status == -1)
        {

            return false;
        }
        else
        {
            return true;

        }

    }
    public boolean dlt(String id)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        long status=sqLiteDatabase.delete(tablename,col1+"="+id,null);

        if (status==-1)
        {
            return  false;
        }
        else
        {
            return  true;
        }
    }


}
