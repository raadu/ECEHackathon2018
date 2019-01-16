package com.example.sajid.srs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class Suggestions extends AppCompatActivity {

    private ImageView add;
    private Button calculate,okay;
    private RecyclerView course_list;
    private EditText addCourse;
    private CheckBox sug_one,sug_two,sug_three;
    private TextView sug_one_grade,sug_two_grade,sug_three_grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        addCourse = findViewById(R.id.et_add_course);

        add=findViewById(R.id.btn_add);

        calculate = findViewById(R.id.btn_calculate);

        course_list = findViewById(R.id.rv_course_list);

        okay=findViewById(R.id.btn_okay);
        sug_one = findViewById(R.id.sug_one);
        sug_one_grade = findViewById(R.id.sug_one_grade);
        sug_two=findViewById(R.id.sug_two);
        sug_two_grade =findViewById(R.id.sug_two_grade);
        sug_three = findViewById(R.id.sug_three);
        sug_three_grade = findViewById(R.id.sug_three_grade);



        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Suggestions.this,RequiredGrade.class));
            }
        });

    }
}
