package com.poetic.FluentCantonese;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.IconViewHolder> {
    private List<IconItem> iconList;
    private Context context;

    public IconAdapter(Context context, List<IconItem> iconList) {
        this.context = context;
        this.iconList = iconList;
    }

    @Override
    public IconViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_icon, parent, false);
        return new IconViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IconViewHolder holder, int position) {
        IconItem iconItem = iconList.get(position);
        holder.iconImageView.setImageResource(iconItem.getIconResId());

        // Imposta il nome e la descrizione qui
        holder.nameTextView.setText(iconItem.getName());
    }

    @Override
    public int getItemCount() {
        return iconList.size();
    }

    public class IconViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImageView;
        TextView nameTextView;
        public IconViewHolder(View itemView) {
            super(itemView);
            iconImageView = itemView.findViewById(R.id.iconImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
        }
    }
}
