package com.pucmm.finalecommerce.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pucmm.finalecommerce.R;
import com.pucmm.finalecommerce.objects.Category;
import com.pucmm.finalecommerce.objects.Product;

import java.io.Serializable;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder>
        implements View.OnClickListener, Serializable {
    private View.OnClickListener listener;
    private List<Category> list;
    private Context context;

    public CategoryAdapter(List<Category> categories){
        this.list = categories;
    }
    @Override
    public void onClick(View view) {

    }

    @NonNull
    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(this.context)
                .inflate(R.layout.item_category, parent, false);

        return new CategoryAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.MyViewHolder holder, int position) {
        Category category = list.get(position);
        holder.name.setText(category.getName());
        Glide.with(this.context).load(category.getUrl())
                .into(holder.image);
    }


    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.title_txt);
            image = itemView.findViewById(R.id.imageView_category);
        }
    }
}
