package com.example.android.menudemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        editText=(EditText)findViewById(R.id.editTextName_delete);
        button=(Button) findViewById(R.id.button_delete);
        delete();
    }
    public void delete()
    {
        {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"Sorry Sir! I am a failure", Toast.LENGTH_LONG).show();
                    finish();


                }
            });
        }

    }
}
