package com.tecdias.crudapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText editTextID, editTextName;
    Button buttonAdd, buttonViewAll, buttonUpdate, buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        editTextID = findViewById(R.id.editTextID);
        editTextName = findViewById(R.id.editTextName);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonViewAll = findViewById(R.id.buttonViewAll);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonDelete = findViewById(R.id.buttonDelete);

        addData();
        viewAll();
        updateData();
        deleteData();
    }

    public void addData() {
        buttonAdd.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            if (name.isEmpty()) {
                Toast.makeText(MainActivity.this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }
            boolean isInserted = db.insertData(name);
            if (isInserted)
                Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
        });
    }

    public void viewAll() {
        buttonViewAll.setOnClickListener(v -> {
            Cursor res = db.getAllData();
            if (res.getCount() == 0) {
                showMessage("Error", "No data found");
                return;
            }
            StringBuilder buffer = new StringBuilder();
            while (res.moveToNext()) {
                buffer.append("ID: ").append(res.getString(0)).append("\n");
                buffer.append("Name: ").append(res.getString(1)).append("\n\n");
            }
            showMessage("Data", buffer.toString());
        });
    }

    public void updateData() {
        buttonUpdate.setOnClickListener(v -> {
            String id = editTextID.getText().toString();
            String newName = editTextName.getText().toString();
            if (id.isEmpty() || newName.isEmpty()) {
                Toast.makeText(MainActivity.this, "ID and Name cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }
            boolean isUpdated = db.updateData(id, newName);
            if (isUpdated)
                Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this, "Data Not Updated", Toast.LENGTH_SHORT).show();
        });
    }

    public void deleteData() {
        buttonDelete.setOnClickListener(v -> {
            String id = editTextID.getText().toString();
            if (id.isEmpty()) {
                Toast.makeText(MainActivity.this, "ID cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }
            int deletedRows = db.deleteData(id);
            if (deletedRows > 0)
                Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
        });
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
