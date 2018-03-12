package hfad.com.vocabulaire;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    public static List<String> wordBankTitles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button create = (Button) findViewById(R.id.create_list);
        create.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showPopup();

            }

        });

        EditText editText = (EditText) findViewById(R.id.search_word);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                if (i == EditorInfo.IME_NULL
                        && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {


                    Intent intent = new Intent(MainActivity.this, ShowWords.class);
                    startActivity(intent);

                    return true;

                }
                return true;
            }});




    }



    private void showPopup() {
        try {

            LayoutInflater inflater = (LayoutInflater) MainActivity.this.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View layout = inflater.inflate(R.layout.pop_up, null);
            int density= (int) MainActivity.this.getResources().getDisplayMetrics().density;

           final PopupWindow pw = new PopupWindow(layout, (int) 300*density,(int) 150* density, true);
            pw.showAtLocation(layout, Gravity.CENTER, 0, 0);
            pw.setFocusable(true);
            pw.update();
            Button Close = (Button) layout.findViewById(R.id.close_popup);
            Close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pw.dismiss();

                }

            });





            Button create_list = (Button) layout.findViewById(R.id.ok);
            EditText text = (EditText) layout.findViewById(R.id.set_title);

            create_list.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    pw.dismiss();

                    EditText text = (EditText) layout.findViewById(R.id.set_title);
                    String title =text.getText().toString();
                    wordBankTitles.add(title);

                    Intent intent = new Intent(MainActivity.this, ShowWords.class);

                   intent.putExtra(ShowWords.TITLE_ID, title);

                    startActivity(intent);

                }

            });




        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    private void createList(String title){


        Intent intent = new Intent(this, ShowWords.class);

        intent.putExtra(ShowWords.TITLE_ID, title);

        startActivity(intent);

    }





}