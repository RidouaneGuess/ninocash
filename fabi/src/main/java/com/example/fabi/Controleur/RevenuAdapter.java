package com.example.fabi.Controleur;


import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fabi.Model.Depense;
import com.example.fabi.Model.Revenu;
import com.example.fabi.R;

import java.util.List;

public class RevenuAdapter extends RecyclerView.Adapter<RevenuAdapter.MyViewHolder> {
    List<Revenu> mRevenuList;

    public int getPosition() {
        return mPosition;
    }

    public void setPosition(int position) {
        mPosition = position;
    }

    private int mPosition;
    public RevenuAdapter(List<Revenu> archivers) {
        mRevenuList = archivers;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.adapter_revenu,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Revenu item = mRevenuList.get(position);
        int i = position;
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mPosition = holder.getAdapterPosition();
                view.showContextMenu();
                return true;
            }
        });
        holder.display(mRevenuList.get(position));

    }
    @Override
    public int getItemCount() {
        return mRevenuList.size();
    }

    public Revenu getItem(int position) {
        return mRevenuList.get(position);
    }

    public void Remove(int position){
        mRevenuList.remove(position);
        notifyItemRemoved(position);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{

        private
        MyViewHolder(View itemView){
            super(itemView);
            mTextViewDate = itemView.findViewById(R.id.textview_date_revenu);
            mTextViewMontant = itemView.findViewById(R.id.textview_montant_revenu);
            mTextViewSource = itemView.findViewById(R.id.textview_source_revenu);
            mTextViewDescription = itemView.findViewById(R.id.textview_description_revenu);
            itemView.setOnCreateContextMenuListener(this);
        }
        @Override
        public void onCreateContextMenu(ContextMenu menu , View v , ContextMenu.ContextMenuInfo menuInfo){
        }
        void display(Revenu revenu){
            mTextViewDate.setText(revenu.getDate());
            mTextViewMontant.setText(String.valueOf(revenu.getMontant()));
            mTextViewSource.setText(revenu.getSource());
            mTextViewDescription.setText(revenu.getDescription());
        }
    }
    private TextView mTextViewMontant;
    private TextView mTextViewDate;
    private TextView mTextViewDescription;
    private TextView mTextViewSource;
}
