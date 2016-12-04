package edu.chapman.cpsc356.stockapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ryanburns on 12/4/16.
 */

public abstract class StockAdapter extends RecyclerView.Adapter<StockAdapter.StockViewHolder>
{
    protected Activity activity;
    private List<String> items;

    protected abstract void onClickItem(String item);

    public StockAdapter(List<String> stocks, Activity activity)
    {
        this.items = stocks;
        this.activity = activity;
    }

    @Override
    public StockViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View itemView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new StockViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StockViewHolder holder, int position)
    {
        String item = this.items.get(position);
        holder.initialize(item);
    }

    @Override
    public int getItemCount()
    {
        return this.items.size();
    }

    public class StockViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private String stockText;
        private TextView textView;

        public StockViewHolder(View itemView)
        {
            super(itemView);

            this.textView = (TextView) itemView;
            this.textView.setOnClickListener(this);
        }

        public void initialize(String text)
        {
            this.stockText = text;
            this.textView.setText(text);
        }

        @Override
        public void onClick(View view)
        {
            onClickItem(this.stockText);
        }
    }
}
