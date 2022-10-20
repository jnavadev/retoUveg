package com.example.restaurant;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapterRest extends RecyclerView.Adapter<ListAdapterRest.ViewHolder> {
    private List<ListElementRestaurante> Data;
    private LayoutInflater mInflater;
    private Context context;
    final ListAdapterRest.OnItemClickListener listener;

    public ListAdapterRest(List<ListElementRestaurante> itemListR, Context context, ListAdapterRest.OnItemClickListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.Data = itemListR;
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void onItemClick(ListElementRestaurante item);
    }


    @Override
    public int getItemCount(){return Data.size(); }

    @Override
    public ListAdapterRest.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.from(parent.getContext()).inflate(R.layout.list_element_restaurante, parent, false);
        return new ListAdapterRest.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapterRest.ViewHolder holder, final int position) {
        holder.cv.setAnimation(AnimationUtils.loadAnimation(context, R.anim.slide));
        holder.bindData(Data.get(position));
    }


    public void setItems(List<ListElementRestaurante> items){ Data = items;}

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImage;
        TextView name;
        CardView cv;

        ViewHolder(View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconImageView);
            name = itemView.findViewById(R.id.nameTextView);
            cv = itemView.findViewById(R.id.cv);
        }

        void bindData(final ListElementRestaurante item) {
            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            name.setText(item.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
