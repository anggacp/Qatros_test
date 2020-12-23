package com.project.qatros_logbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class AddActivity extends AppCompatActivity {

    //deklarasi firebase firestore
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference logBookRef = db.collection("LogBook");

    //deklarasi Edittext dan Button
    private EditText inputName;
    private EditText inputAmount;
    private EditText inputSupplier;
    private EditText inputDate;
    private EditText inputId;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        inputName = findViewById(R.id.input_name);
        inputAmount = findViewById(R.id.input_amount);
        inputSupplier = findViewById(R.id.input_supplier);
        inputDate = findViewById(R.id.input_date);
        inputId = findViewById(R.id.input_id);
        addButton = findViewById(R.id.add_item_button);

        //Memberi fungsi OnClick pada button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content_name = inputName.getText().toString();
                String content_amount = inputAmount.getText().toString();
                String content_supplier = inputSupplier.getText().toString();
                String content_date = inputDate.getText().toString();
                int content_id = Integer.parseInt(inputId.getText().toString());

                HashMap hashmap = new HashMap();
                hashmap.put("Item_name",content_name);
                hashmap.put("Item_amount",content_amount);
                hashmap.put("Item_supplier",content_supplier);
                hashmap.put("Item_date",content_date);
                hashmap.put("Item_id",content_id);

                //Karena ingin menambahkan document, maka gunakan fungsi add()
                logBookRef.add(hashmap)
                        .addOnSuccessListener(new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {
                                Toast.makeText(AddActivity.this, "Data Successfully Added!", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}