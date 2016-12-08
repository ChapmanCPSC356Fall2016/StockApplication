package edu.chapman.cpsc356.stockapplication.adapters;

import android.app.Activity;
import android.content.Intent;

import java.util.List;

import edu.chapman.cpsc356.stockapplication.activities.StockActivity;

public class FavoriteStockAdapter extends StockAdapter
{
    public FavoriteStockAdapter(List<String> stocks, Activity activity)
    {
        super(stocks, activity);
    }

    @Override
    protected void onClickItem(final String item)
    {
        Intent stockIntent = new Intent(activity, StockActivity.class);
        stockIntent.putExtra(StockActivity.EXTRA_SYMBOL, item);

        activity.startActivity(stockIntent);
    }
}
