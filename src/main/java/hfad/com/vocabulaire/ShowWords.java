package hfad.com.vocabulaire;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ShowWords extends Activity {



    public static final String TITLE_ID = "currtitle";
    private String title;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_words);

        Intent intent = getIntent();

        title = intent.getStringExtra(TITLE_ID);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_word, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){


        switch (item.getItemId()) {

            default:
                return true;


        }

    }




}
