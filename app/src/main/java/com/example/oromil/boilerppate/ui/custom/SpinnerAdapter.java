package com.example.oromil.boilerppate.ui.custom;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.oromil.boilerppate.R;
import com.example.oromil.boilerppate.data.Food;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpinnerAdapter extends RecyclerView.Adapter<SpinnerAdapter.SpinnerViewHolder> {

    ArrayList<Food> items;

    public SpinnerAdapter(){
        items = new ArrayList<>();
    }


    @NonNull
    @Override
    public SpinnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_basket, parent, false);
        return new SpinnerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SpinnerViewHolder holder, int position) {
        holder.textView.setText(items.get(position).getName());
        holder.mRemove.setOnClickListener(v -> removeItem(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public  void update(ArrayList<Food> items){
        this.items = items;
        notifyDataSetChanged();
    }

    public void addItem(Food item){
        items.add(item);
        notifyDataSetChanged();
    }

    public void removeItem(int position){
        items.remove(position);
        notifyDataSetChanged();
    }

    protected static class SpinnerViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tvName)
        TextView textView;
        @BindView(R.id.imgRemove)
        AppCompatImageView mRemove;

        public SpinnerViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
//            textView = itemView.findViewById(R.id.tvName);
        }
    }
}
