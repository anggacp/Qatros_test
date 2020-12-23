package com.project.qatros_logbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.core.OrderBy;

public class MainActivity extends AppCompatActivity {

    //deklarasi database, adapter, dan floating button
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference logBookRef = db.collection("LogBook");
    private LogAdapter adapter;
    FloatingActionButton add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mendefinisikan id yang telah dideklarasikan di awal
        setUpRecyclerview();
        add_button = findViewById(R.id.add_button);

        //Memberi fungsi OnClick
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
    }

    //Setup recyclerview dari firestore
    private void setUpRecyclerview() {

        Query query = logBookRef.orderBy("Item_id", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<LogBook> options = new FirestoreRecyclerOptions.Builder<LogBook>()
                .setQuery(query, LogBook.class)
                .build();

        adapter = new LogAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.log_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    //Memberi fungsi onStart dan onStop untuk Recyclerviewnya
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}