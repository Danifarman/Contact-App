package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder>{

    Context context;
    int lastpos=-1;

    ArrayList<ContactModel> arrContacts;
    RecyclerContactAdapter(Context context,ArrayList<ContactModel> arrContacts){
        this.context=context;
        this.arrContacts=arrContacts;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {





        holder.img.setImageResource(arrContacts.get(position).img);
        holder.txtName.setText(arrContacts.get(position).name);
        holder.txtNumber.setText(arrContacts.get(position).number);
        holder.llRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_contact_dialog);
                EditText eName = dialog.findViewById(R.id.et_contact_name);
                EditText eNumber = dialog.findViewById(R.id.et_contact_number);
                Button bAdd = dialog.findViewById(R.id.btn_add);
                Button bCancel = dialog.findViewById(R.id.btn_cancel);
                TextView eTitle = dialog.findViewById(R.id.tv_add_contact);
                eTitle.setText("Update Contact");

                bAdd.setText("Update");
                eName.setText(arrContacts.get(position).name);
                eNumber.setText(arrContacts.get(position).number);

                bAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String Name = "", Number = "";
                        if (!eName.getText().toString().isEmpty()) {
                            Name = eName.getText().toString();
                        } else {
                            Toast.makeText(context, "Please enter Contact name", Toast.LENGTH_SHORT).show();
                            return; // Prevent adding incomplete contact
                        }
                        if (!eNumber.getText().toString().isEmpty()) {
                            Number = eNumber.getText().toString();
                        } else {
                            Toast.makeText(context, "Please enter Contact number", Toast.LENGTH_SHORT).show();
                            return; // Prevent adding incomplete contact
                        }
                        arrContacts.set(position, new ContactModel(R.drawable.simple,Name, Number));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });

                bCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
holder.llRow.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View view) {
        AlertDialog.Builder builder  = new AlertDialog.Builder(context)
                .setTitle("Delete Contact")
                .setMessage("Are you sure u want to delete")
                .setIcon(R.drawable.icon)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        arrContacts.remove(position);
                        notifyItemRemoved(position);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();

        return true;
    }
});
  setAnimation(holder.itemView,position);
    }



    @Override
    public int getItemCount() {
        return arrContacts.size();
    }
    private void setAnimation(View vOnWhichAnimationApply, int pos) {
        if(pos>lastpos) {
            Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            vOnWhichAnimationApply.startAnimation(slideIn);
            lastpos = pos;
        }

    }
        public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;TextView txtNumber;
        ImageView img;
        LinearLayout llRow;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            img = itemView.findViewById(R.id.img_contact);
            llRow = itemView.findViewById(R.id.llRow);
        }
    }
}
