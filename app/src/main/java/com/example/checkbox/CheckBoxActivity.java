package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckBoxActivity extends AppCompatActivity {

    Button apply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);


        ArrayList<String> name = new ArrayList<>();
        name.add("Soumo");
        name.add("Soumo");
        name.add("Soumo");
        name.add("Soumo");
        name.add("Soumo");

        int array_Count = name.size();

        LinearLayout my_layout = (LinearLayout) findViewById(R.id.my_layout);
        final HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < array_Count; i++) {
            TableRow row = new TableRow(this);
            row.setId(i);
            row.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            final CheckBox checkBox = new CheckBox(this);
            checkBox.setId(i);
            checkBox.setText(name.get(i));
            row.addView(checkBox);
            my_layout.addView(row);

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        map.put(buttonView.getId() + "", buttonView.getId() + "");
                        //Toast.makeText(CheckBoxAcitivty.this, buttonView.getId() + "", Toast.LENGTH_LONG).show();
                    } else {
                        map.remove(buttonView.getId() + "");
                    }
                }
            });

        }

        apply = findViewById(R.id.apply);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CheckBoxActivity.this, map + "", Toast.LENGTH_LONG).show();
            }
        });

    }
}