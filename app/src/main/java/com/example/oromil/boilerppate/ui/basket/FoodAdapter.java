package com.example.oromil.boilerppate.ui.basket;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.oromil.boilerppate.R;
import com.example.oromil.boilerppate.data.Food;
import com.example.oromil.boilerppate.ui.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<Food> food;
    private ItemClickListener mListener;


    public FoodAdapter(){
        food = new ArrayList<>();
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food item = food.get(position);
        holder.mName.setText(item.getName());
        holder.mCarbohydrates.setText(item.getCarbohydrates());

        holder.getView().setOnClickListener(v -> mListener.onClick(item));
    }

    @Override
    public int getItemCount() {
        return food.size();
    }

    public void setItemClickListenerCallback(ItemClickListener listener){
        mListener = listener;
    }

    public void update(List<Food> data){
        food = data;
        notifyDataSetChanged();
    }

    public List<Food> getFoodList(){
        return food;
    }

    protected static class FoodViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvName)
        TextView mName;
        @BindView(R.id.tvCarbohydrates)
        TextView mCarbohydrates;

        private View view;

        public FoodViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            view = itemView;
        }

        protected View getView(){
            return view;
        }
    }
}
