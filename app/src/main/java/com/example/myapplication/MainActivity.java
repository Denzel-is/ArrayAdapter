package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> namesList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextName = findViewById(R.id.editTextName);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        ListView listViewNames = findViewById(R.id.listViewNames);
        namesList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, namesList);

        listViewNames.setAdapter(adapter);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                if (!name.isEmpty()) {
                    // Добавляем новое имя в список и обновляем адаптер
                    namesList.add(name);
                    adapter.notifyDataSetChanged(); // Обновление данных в ListView
                    editTextName.setText(""); // Очищаем текстовое поле
                }
            }
        });
    }
}
