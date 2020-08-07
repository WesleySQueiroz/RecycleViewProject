package com.example.recycleviewproject;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewproject.model.Email;

import java.util.ArrayList;
import java.util.List;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.EmailViewHolder>{

    private EmailAdapterListner listner;

    private final List<Email> emails;

    final SparseBooleanArray selectedItens = new SparseBooleanArray();

    private int currentSelectedPos;

    public EmailAdapter(ArrayList<Email> emails) {

        this.emails = emails;

    }

    public void setListner(EmailAdapterListner listner) {
        this.listner = listner;
    }

    public List<Email> getEmails(){
        return emails;
    }

    @NonNull
    @Override
    public EmailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.email_icon, parent, false);

        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmailViewHolder holder, final int position) {

        Email email = emails.get(position);
        holder.bind(email);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedItens.size() > 0 && listner != null){
                    listner.onItemClick(position);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(listner != null){
                    listner.onItemLongClick(position);

                }


                return false;
            }
        });

        if(currentSelectedPos == position) currentSelectedPos = -1;


    }

    @Override
    public int getItemCount() {
        return emails.size();
    }

    void deleteEmails() {



    }

    void toggleSelection(int position) {

        currentSelectedPos = position;

        if(selectedItens.get(position)){
            selectedItens.delete(position);
            emails.get(position).setSelected(false);
        }
        else{
            selectedItens.put(position, true);
            emails.get(position).setSelected(true);
        }

        notifyItemChanged(position);
    }

    class EmailViewHolder extends RecyclerView.ViewHolder{

        TextView txt_user;
        TextView txt_icon;
        TextView txt_subject;
        TextView txt_preview;
        TextView txt_Date;
        ImageView img_star;

        public EmailViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_user = itemView.findViewById(R.id.txt_user);
            txt_icon = itemView.findViewById(R.id.txt_icon);
            txt_subject = itemView.findViewById(R.id.txt_subject);
            txt_preview = itemView.findViewById(R.id.txt_preview);
            txt_Date = itemView.findViewById(R.id.txt_data);
            img_star = itemView.findViewById(R.id.star);

        }

        public void bind(Email email){

            int rash = email.getUser().hashCode();

            txt_user.setText(email.getUser());
            txt_icon.setText(String.valueOf(email.getUser().charAt(0)));
            txt_icon.setBackground(oval(Color.rgb(rash, rash / 2, 0), txt_icon));

            txt_subject.setText(email.getSubject());
            txt_preview.setText(email.getPreview());
            txt_Date.setText(email.getDate());

            //mudar fonte
            txt_user.setTypeface(Typeface.DEFAULT, email.isUnread() ? Typeface.BOLD : Typeface.NORMAL);
            txt_Date.setTypeface(Typeface.DEFAULT, email.isUnread() ? Typeface.BOLD : Typeface.NORMAL);
            txt_subject.setTypeface(Typeface.DEFAULT, email.isUnread() ? Typeface.BOLD : Typeface.NORMAL);


            img_star.setImageResource(email.isStarted() ? R.drawable.star : R.drawable.no_star);
        }

    }

    private static ShapeDrawable oval (@ColorInt int color, View view){

        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(view.getHeight());
        shapeDrawable.setIntrinsicWidth(view.getWidth());
        shapeDrawable.getPaint().setColor(color);
        return shapeDrawable;

    }

    interface EmailAdapterListner{

        void onItemClick(int position);

        void onItemLongClick(int position);


    }





}
