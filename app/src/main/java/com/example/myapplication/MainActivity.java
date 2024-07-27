package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerContactAdapter Adapter;
    ArrayList<ContactModel> arrContacts = new ArrayList<>();
    FloatingActionButton btn_process;
    RecyclerView recyclerView; // Make recyclerView accessible throughout the class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolBar);
        //step1 setup toolbar
       setSupportActionBar(toolbar);

      //ste2
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Contact App");
        }


        //backbutton not shown in first activity/home screen
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

//menu



        recyclerView = findViewById(R.id.recyclerContact);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize btn_process
        btn_process = findViewById(R.id.btn_process);

        arrContacts.add(new ContactModel(R.drawable.boy, "Dani", "03165066734"));
        arrContacts.add(new ContactModel(R.drawable.woman, "Mani", "03475066734"));
        arrContacts.add(new ContactModel(R.drawable.simple, "Ahmi", "03995066734"));
        arrContacts.add(new ContactModel(R.drawable.boy, "Sadoi", "03415066734"));
        arrContacts.add(new ContactModel(R.drawable.woman, "Kami", "03477066734"));
        arrContacts.add(new ContactModel(R.drawable.boy, "Rani", "03134066734"));
        arrContacts.add(new ContactModel(R.drawable.woman, "Jani", "03105066734"));
        arrContacts.add(new ContactModel(R.drawable.boy, "Sani", "03115066734"));
        arrContacts.add(new ContactModel(R.drawable.woman, "Toni", "031145066734"));
        arrContacts.add(new ContactModel(R.drawable.simple, "Moni", "03156066734"));
        arrContacts.add(new ContactModel(R.drawable.boy, "Joni", "03165066734"));
        arrContacts.add(new ContactModel(R.drawable.boy, "Roni", "03178066734"));
        arrContacts.add(new ContactModel(R.drawable.simple, "Koni", "03185066734"));
        arrContacts.add(new ContactModel(R.drawable.woman, "Soni", "03195066734"));
        arrContacts.add(new ContactModel(R.drawable.boy, "Qasim", "032065066734"));
        arrContacts.add(new ContactModel(R.drawable.boy, "Dani", "03165066734"));
        arrContacts.add(new ContactModel(R.drawable.woman, "Mani", "03475066734"));
        arrContacts.add(new ContactModel(R.drawable.simple, "Ahmi", "03995066734"));
        arrContacts.add(new ContactModel(R.drawable.boy, "Sadoi", "03415066734"));
        arrContacts.add(new ContactModel(R.drawable.woman, "Kami", "03477066734"));
        arrContacts.add(new ContactModel(R.drawable.boy, "Rani", "03134066734"));
        arrContacts.add(new ContactModel(R.drawable.woman, "Jani", "03105066734"));
        arrContacts.add(new ContactModel(R.drawable.boy, "Sani", "03115066734"));
        arrContacts.add(new ContactModel(R.drawable.woman, "Toni", "031145066734"));
        arrContacts.add(new ContactModel(R.drawable.boy, "Sadoi", "03415066734"));
        arrContacts.add(new ContactModel(R.drawable.woman, "Kami", "03477066734"));
        arrContacts.add(new ContactModel(R.drawable.boy, "Rani", "03134066734"));
        arrContacts.add(new ContactModel(R.drawable.woman, "Jani", "03105066734"));
        arrContacts.add(new ContactModel(R.drawable.boy, "Sani", "03115066734"));
        arrContacts.add(new ContactModel(R.drawable.woman, "Toni", "031145066734"));
        arrContacts.add(new ContactModel(R.drawable.simple, "Moni", "03156066734"));
        arrContacts.add(new ContactModel(R.drawable.boy, "Joni", "03165066734"));
        arrContacts.add(new ContactModel(R.drawable.boy, "Roni", "03178066734"));
        arrContacts.add(new ContactModel(R.drawable.simple, "Koni", "03185066734"));
        arrContacts.add(new ContactModel(R.drawable.woman, "Soni", "03195066734"));
        arrContacts.add(new ContactModel(R.drawable.boy, "Qasim", "032065066734"));
        arrContacts.add(new ContactModel(R.drawable.boy, "Dani", "03165066734"));
        arrContacts.add(new ContactModel(R.drawable.woman, "Mani", "03475066734"));
        arrContacts.add(new ContactModel(R.drawable.simple, "Ahmi", "03995066734"));
        arrContacts.add(new ContactModel(R.drawable.boy, "Sadoi", "03415066734"));
        arrContacts.add(new ContactModel(R.drawable.woman, "Kami", "03477066734"));
        arrContacts.add(new ContactModel(R.drawable.boy, "Rani", "03134066734"));
        arrContacts.add(new ContactModel(R.drawable.woman, "Jani", "03105066734"));
        arrContacts.add(new ContactModel(R.drawable.boy, "Sani", "03115066734"));
        arrContacts.add(new ContactModel(R.drawable.woman, "Toni", "031145066734"));


        btn_process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_contact_dialog);

                EditText eName = dialog.findViewById(R.id.et_contact_name);
                EditText eNumber = dialog.findViewById(R.id.et_contact_number);
                Button bAdd = dialog.findViewById(R.id.btn_add);
                Button bCancel = dialog.findViewById(R.id.btn_cancel);

                bAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String Name = "", Number = "";
                        if (!eName.getText().toString().isEmpty()) {
                            Name = eName.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter Contact name", Toast.LENGTH_SHORT).show();
                            return; // Prevent adding incomplete contact
                        }
                        if (!eNumber.getText().toString().isEmpty()) {
                            Number = eNumber.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter Contact number", Toast.LENGTH_SHORT).show();
                            return; // Prevent adding incomplete contact
                        }
                        arrContacts.add(new ContactModel(R.drawable.simple,Name, Number));
                        Adapter.notifyItemInserted(arrContacts.size() - 1);
                        recyclerView.scrollToPosition(arrContacts.size() - 1);
                        dialog.dismiss(); // Dismiss the dialog after adding the contact
                    }
                });

                bCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss(); // Dismiss the dialog on cancel
                    }
                });

                dialog.show();
            }
        });

        Adapter = new RecyclerContactAdapter(this, arrContacts); // Initialize Adapter correctly
        recyclerView.setAdapter(Adapter);
    }
@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu,menu);
    MenuItem item1 = menu.findItem(R.id.option_new);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId==R.id.option_new){
            Toast.makeText(this, "Create new file", Toast.LENGTH_SHORT).show();
        } else if (itemId==R.id.opt_save) {
            Toast.makeText(this, "File saved !", Toast.LENGTH_SHORT).show();

        } else if (itemId==R.id.opt_open) {
            Toast.makeText(this, "file open", Toast.LENGTH_SHORT).show();

        } else if (itemId==android.R.id.home) {
            super.onBackPressed();

        }
        {

        }
        return super.onOptionsItemSelected(item);
    }
}
