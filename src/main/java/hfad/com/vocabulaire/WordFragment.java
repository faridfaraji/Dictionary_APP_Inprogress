package hfad.com.vocabulaire;


import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class WordFragment extends Fragment {

    private Cursor cursor;
    private SQLiteDatabase db;



    public WordFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_word, container, false);



        try{

            SQLiteOpenHelper wordsDatabaseHelper = new WordsDatabaseHelper(getActivity());
            db = wordsDatabaseHelper.getReadableDatabase();

            cursor = db.query("WORDS",new String[]{"_id, NAME","DESCRIPTION"}, null,null,
                    null,null,null);

            if (cursor.moveToFirst()){

                String word = cursor.getString(1);
                String definition = cursor.getString(2);



                TextView defView = (TextView)view.findViewById(R.id.definition);

                TextView wordView = (TextView)view.findViewById(R.id.the_word);
                defView.setText(definition);
                wordView.setText(word);

            }
        }

        catch (SQLiteException e){

            Toast toast =Toast.makeText(getActivity(), "DataBase not Available", Toast.LENGTH_SHORT);
            toast.show();

        }

        return view;
    }


    @Override
    public void onDestroy(){
        super.onDestroy();
        cursor.close();
        db.close();


    }


}
