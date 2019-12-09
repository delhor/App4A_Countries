package com.example.daoud.app_3aufa_elhor.controllers.activities.controllers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daoud.app_3aufa_elhor.R;
import com.example.daoud.app_3aufa_elhor.controllers.activities.retrofitgerrit.Country;
import com.example.daoud.app_3aufa_elhor.controllers.activities.retrofitgerrit.OnItemClickListener;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Country> values;
    private final OnItemClickListener listener;

    public final Context context;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView imageView;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader =  v.findViewById(R.id.firstLine);
            txtFooter =  v.findViewById(R.id.secondLine);
            imageView = v.findViewById(R.id.icon);
        }

        public void bind(final Country item, final OnItemClickListener listener) {
            txtHeader.setText(item.getName());
            txtFooter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });

            //Picasso.with(context).load(item.getFlag()).into(imageView);
            if(item.getFlag() != null && !item.getFlag().isEmpty()){
                Utils.fetchSvg(context, item.getFlag(), imageView);
            }
        }
    }


    public void add(int position, Country item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Country> myDataset, Context context, OnItemClickListener listener) {
        values = myDataset;
        this.context = context;
        this.listener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.bind(values.get(position), listener);

    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}