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
import com.pucmm.finalecommerce.objects.Product;

import java.io.Serializable;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyviewHolder>
    implements View.OnClickListener, Serializable {
    private View.OnClickListener listener;
    private List<Product> list;
    private Context context;
    public ProductAdapter(List<Product> list){
        this.list = list;
    }
    @Override
    public void onClick(View view) {

    }

    @NonNull
    @Override
    public ProductAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);

        return new MyviewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.MyviewHolder holder, int position) {
        Product element = list.get(position);
        holder._id.setText(String.valueOf(element.getUid()));
        holder.name.setText(element.getPrice());
        holder.description.setText(element.getDescription());
        Glide.with(context).load(element.getImage())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
    public class MyviewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView _id;
        TextView name;
        TextView description;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_product);
            _id = itemView.findViewById(R.id.id_txt);
            name = itemView.findViewById(R.id.price_txt);
            description = itemView.findViewById(R.id.description_txt);
        }
    }
}
