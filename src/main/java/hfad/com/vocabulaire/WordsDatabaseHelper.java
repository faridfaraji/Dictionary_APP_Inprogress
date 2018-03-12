package hfad.com.vocabulaire;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;

/**
 * Created by Farid on 2018-02-24.
 */
public class WordsDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "wordBank";
    private static final int DB_VERSION = 1;


    public WordsDatabaseHelper(Context context) {
        super(context, DB_NAME,  null,  DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        updateMyDatabase(sqLiteDatabase, 1, DB_VERSION);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {


        updateMyDatabase(sqLiteDatabase,  oldVersion,  newVersion);

    }


    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){


        updateMyDatabase(sqLiteDatabase,  oldVersion,  newVersion);



    }




    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion){

        if(oldVersion <2){
            db.execSQL("CREATE TABLE WORDS ("+
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + " NAME TEXT,"
                    +" DESCRIPTION TEXT, "
                    +" SEARCHDWORD INTEGER);");

            insertDrink(db, "Bonjure", "Hello" );
            insertDrink(db, "surtout", "most of all");

        }


    }


    private static void insertDrink(SQLiteDatabase db,String name, String description){

        ContentValues words = new ContentValues();

        words.put("NAME", name);
        words.put("DESCRIPTION", description);
        words.put("SEARCHDWORD", 0);
        db.insert("WORDS",null, words);

    }



    private class UpdateWordsTas extends AsyncTask<Integer, Void, Boolean>{


        @Override
        protected void onPreExecute(){
        }


        @Override
        protected Boolean doInBackground(Integer... integers) {
            return null;
        }

        @Override
        protected void onPostExecute(Boolean success){


        }



    }

}
