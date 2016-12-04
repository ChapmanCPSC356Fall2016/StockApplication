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

public class StockAdapter extends RecyclerView.Adapter<StockAdapter.StockViewHolder>
{
    private Activity activity;
    private List<String> items;
    private boolean clickable;

    public StockAdapter(List<String> stocks, boolean clickable, Activity activity)
    {
        this.items = stocks;
        this.activity = activity;
        this.clickable = true;
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
        holder.initialize(item, clickable);
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
        }

        public void initialize(String text, boolean clickable)
        {
            this.stockText = text;
            this.textView.setText(text);

            if (clickable)
            {
                this.textView.setOnClickListener(this);
            }
        }

        @Override
        public void onClick(View view)
        {
            String message = activity.getString(R.string.are_you_sure_message, this.stockText);
            new AlertDialog.Builder(activity)
                    .setTitle(R.string.are_you_sure)
                    .setMessage(message)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {
                            FavoriteStockCollection.Get().addFavoriteStock(stockText);
                            activity.finish();
                        }
                    })
                    .setNegativeButton(android.R.string.no, null)
                    .create()
                    .show();
        }
    }
}
