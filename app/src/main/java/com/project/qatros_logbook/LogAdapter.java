package com.project.qatros_logbook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class LogAdapter extends FirestoreRecyclerAdapter<LogBook, LogAdapter.LogHolder> {

    public LogAdapter(@NonNull FirestoreRecyclerOptions<LogBook> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull LogHolder holder, int position, @NonNull LogBook model) {
        holder.item_name.setText(model.getItem_name());
        holder.item_amount.setText(model.getItem_amount());
        holder.item_supplier.setText(model.getItem_supplier());
        holder.item_date.setText(model.getItem_date());
        holder.item_id.setText(String.valueOf(model.getItem_id()));
    }

    @NonNull
    @Override
    public LogHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.log_item,
                parent,false);
        return new LogHolder(view);
    }

    class LogHolder extends RecyclerView.ViewHolder {

        TextView item_name;
        TextView item_amount;
        TextView item_supplier;
        TextView item_date;
        TextView item_id;

        public LogHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.name_item);
            item_amount = itemView.findViewById(R.id.amount_item);
            item_supplier = itemView.findViewById(R.id.supplier_item);
            item_date = itemView.findViewById(R.id.date_item);
            item_id = itemView.findViewById(R.id.id_item);
        }
    }
}
