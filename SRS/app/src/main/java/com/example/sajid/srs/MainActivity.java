package com.example.sajid.srs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private RadioButton r_retake, r_retake_new, r_new;
    private EditText currentCG, targetCG;
    private Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r_new = findViewById(R.id.rb_new);
        r_retake = findViewById(R.id.rb_retake);
        r_retake_new = findViewById(R.id.rb_retake_new);

        currentCG = findViewById(R.id.et_current_cgpa);
        targetCG = findViewById(R.id.et_target_cgpa);

        next = findViewById(R.id.btn_next);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentCG.getText().toString().isEmpty() && targetCG.getText().toString().isEmpty()) {
                    currentCG.setError("Current CGPA field cannot be empty");
                    targetCG.setError("Target CGPA field cannot be empty");
                } else if (currentCG.getText().toString().isEmpty()) {
                    currentCG.setError("Current CGPA field cannot be empty");
                } else if (targetCG.getText().toString().isEmpty()) {
                    targetCG.setError("Target CGPA field cannot be empty");

                } else {


                    startActivity(new Intent(MainActivity.this, Suggestions.class));
                }
            }
        });


    }
}
