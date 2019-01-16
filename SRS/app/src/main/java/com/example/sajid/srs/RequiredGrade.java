package com.example.sajid.srs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

public class RequiredGrade extends AppCompatActivity {

    private EditText target;
    private RecyclerView requiredRV;
    private Button update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_required_grade);

        target = findViewById(R.id.required_target_CGPA);
        requiredRV = findViewById(R.id.rv_required);
        update = findViewById(R.id.btn_update);

    }
}
