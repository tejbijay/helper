package com.example.lite.helper;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyHelper extends SQLiteOpenHelper {

    private static final String databaseName = "DisctionaryDB.db";
    private static final int dbVersion = 1;
    //tblWord Fields
    private static final String tblWord = "tblWord";
    private static final String WordID = "WordID";
    private static final String Word = "Word";
    private static final String  Meaning = "Meaning";

    //Constructor
    public MyHelper(Context context){
        super(context,databaseName,null,dbVersion);
        //context, databaseName, cursorFactory, databaseVersion

    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE" + tblWord +
                "("
                + WordID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Word + "TEXT,"
                + Meaning + "TEXT" +
                ")";
        db.execSQL(query);
    }

    public boolean InsertData(String word, String meaning, SQLiteDatabase db){
        try {
            String query = "insert into Words (Word, Meaning) values('" + word +"','" + meaning + "')";
            db.execSQL(query);
            return true;
        } catch (Exception e){
            Log.d("Error:", e.toString());
            return false;
        }
    }

    public long InsertData (String word, String meaning, SQLiteDatabase db){
        long id;;
        ContentValues contentValues = new ContentValues();
        contentValues.put(Word,word);
        contentValues.put(Meaning, meaning);
    }


}
