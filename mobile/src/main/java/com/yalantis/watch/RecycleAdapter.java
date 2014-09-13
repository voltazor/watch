package com.yalantis.watch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Dmitriy Dovbnya on 08.09.2014.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    private Context context;
    private List<Model> models;
    private OnItemClickListener itemClickListener;
    private OnItemLongClickListener itemLongClickListener;

    public RecycleAdapter(Context context, List<Model> models) {
        this.models = models;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        final Model model = models.get(position);
        viewHolder.model = model;
        viewHolder.image.setBackgroundColor(model.getColor());
        viewHolder.title.setText(model.getName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(v, viewHolder.model, viewHolder.getPosition());
                }
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return itemLongClickListener != null && itemLongClickListener.onItemLongClick(v, viewHolder.model, viewHolder.getPosition());
            }
        });
    }

    public void addItem(Model model) {
        addItem(models.size(), model);
    }

    public void addItem(int position, Model model) {
        models.add(model);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        models.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setItemLongClickListener(OnItemLongClickListener itemLongClickListener) {
        this.itemLongClickListener = itemLongClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private Model model;
        private TextView title;
        private ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
        }

        public void setModel(Model model) {
            this.model = model;
        }
    }

    public static interface OnItemClickListener {

        public void onItemClick(View view, Model model, int position);

    }

    public static interface OnItemLongClickListener {

        public boolean onItemLongClick(View view, Model model, int position);

    }

}
