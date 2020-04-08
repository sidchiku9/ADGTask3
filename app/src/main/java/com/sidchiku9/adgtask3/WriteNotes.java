package com.sidchiku9.adgtask3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WriteNotes extends AppCompatActivity {
    private EditText title,content;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_notes);

        title = findViewById(R.id.writeHead);
        content = findViewById(R.id.writeContent);
        save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                global_variables.titlee = title.getText().toString();
                global_variables.contentt = content.getText().toString();

                Intent backTo = new Intent(v.getContext(),MainActivity.class);
                startActivity(backTo);

                saveData();
            }
        });

    }

    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(global_variables.SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(global_variables.heading,global_variables.titlee);
        editor.putString(global_variables.maal,global_variables.contentt);

        editor.apply();

        Toast.makeText(this,"Note saved" , Toast.LENGTH_SHORT).show();


    }

}
