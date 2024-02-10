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
import com.example.fabi.R;

import java.util.List;

public class DepenseAdapter extends RecyclerView.Adapter<DepenseAdapter.MyViewHolder> {
    List<Depense> mDepenseList;

    public int getPosition() {
        return mPosition;
    }

    public void setPosition(int position) {
        mPosition = position;
    }

    private int mPosition;
    public DepenseAdapter(List<Depense> archivers) {
        mDepenseList = archivers;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.adapter_depense,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Depense item = mDepenseList.get(position);
        int i = position;
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mPosition = holder.getAdapterPosition();
                view.showContextMenu();
                return true;
            }
        });
        holder.display(mDepenseList.get(position));

    }
    @Override
    public int getItemCount() {
        return mDepenseList.size();
    }

    public Depense getItem(int position) {
        return mDepenseList.get(position);
    }

    public void Remove(int position){
        mDepenseList.remove(position);
        notifyItemRemoved(position);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{

        private
        MyViewHolder(View itemView){
            super(itemView);
            mTextViewDate = itemView.findViewById(R.id.textview_date_depence);
            mTextViewMontant = itemView.findViewById(R.id.textview_montant_depence);
            mTextViewCategorie = itemView.findViewById(R.id.textview_categorie_depence);
            mTextViewDescription = itemView.findViewById(R.id.textview_description_depence);
            itemView.setOnCreateContextMenuListener(this);
        }
        @Override
        public void onCreateContextMenu(ContextMenu menu , View v , ContextMenu.ContextMenuInfo menuInfo){
        }
        void display(Depense depense){
            mTextViewDate.setText(depense.getDate());
            mTextViewMontant.setText(String.valueOf(depense.getMontant()));
            mTextViewCategorie.setText(depense.getCategorie());
            mTextViewDescription.setText(depense.getDescription());
        }
    }
    private TextView mTextViewMontant;
    private TextView mTextViewDate;
    private TextView mTextViewDescription;
    private TextView mTextViewCategorie;
}
