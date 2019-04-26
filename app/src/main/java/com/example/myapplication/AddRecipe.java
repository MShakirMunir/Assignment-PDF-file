package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.OpenableColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.File;

public class AddRecipe extends AppCompatActivity {
    EditText txtTitle, txtDesc, txtPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        setTitle("Add Recipe");

        txtTitle = (EditText) findViewById(R.id.txtTitle);
        txtDesc = (EditText) findViewById(R.id.txtDesc);
        txtPath = (EditText) findViewById(R.id.txtPath);
    }

    public void browse(View view) {
        Intent fileExplorer = new Intent();
        fileExplorer.setAction(Intent.ACTION_GET_CONTENT);
        fileExplorer.setType("application/pdf");
        startActivityForResult(fileExplorer,1212);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 1212) {
            // Get the Uri of the selected file
            Uri uri = data.getData();
            String uriString = uri.toString();
            File myFile = new File(uriString);
            String path = myFile.getAbsolutePath();
            txtPath.setText(path);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
