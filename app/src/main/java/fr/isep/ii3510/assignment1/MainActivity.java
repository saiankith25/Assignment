package fr.isep.ii3510.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText created_text;
    private EditText font_size;
    private EditText color_code;

    private Button submit;
    private Button text_size;
    private Button select_color;

    private TextView submitted_text;

    private View color;

    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        created_text = (EditText) findViewById(R.id.created_text);
        font_size = (EditText) findViewById(R.id.text_size);
        color_code = (EditText) findViewById(R.id.color_code);

        submitted_text = (TextView) findViewById(R.id.submitted_text);
        color = (View) findViewById(R.id.color);

        submit = (Button) findViewById(R.id.submit);
        text_size = (Button) findViewById(R.id.text_sze);
        select_color = (Button) findViewById(R.id.select_color);

        setClickListeners();

    }

    private void toaster(View view){
        Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();
    }

    private void setClickListeners(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = created_text.getText().toString();
                if(!text.equalsIgnoreCase("")){
                    submitted_text.setText(text);
                }
                else{
                    Toast.makeText(getApplicationContext(),"TEXT BOX EMPTY..!!!!  Please enter some text in the above text box.!!!",Toast.LENGTH_LONG).show();
                }
            }
        });
        text_size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String text = created_text.getText().toString();

                if(!submitted_text.getText().toString().equalsIgnoreCase("") &&
                        !font_size.getText().toString().equals("")){
                    submitted_text.setTextSize(Integer.parseInt(font_size.getText().toString()));
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please enter a font size in numbers ..!!!! EX: 30 !!!!",Toast.LENGTH_LONG).show();
                }
            }
        });

        select_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String text = created_text.getText().toString();
                if(!submitted_text.getText().toString().equalsIgnoreCase("") &&
                        !color_code.getText().toString().equals("")){
                    try{
                        color.setBackgroundColor(Color.parseColor(color_code.getText().toString()));
                        submitted_text.setTextColor(Color.parseColor(color_code.getText().toString()));}
                    catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Invalid Color Code..!!!!  Please enter a valid color code for EX: #000000(BLACK color) [or]  #ff0000 (RED color).!!!",Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please enter a color code ..!!!!  Please enter a valid color code for EX: #000000(BLACK color) [or]  #ff0000 (RED color).!!!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}