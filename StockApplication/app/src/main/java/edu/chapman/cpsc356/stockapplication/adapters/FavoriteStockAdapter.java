package edu.chapman.cpsc356.stockapplication.adapters;

import android.app.Activity;

import java.util.List;

public class FavoriteStockAdapter extends StockAdapter
{
    public FavoriteStockAdapter(List<String> stocks, Activity activity)
    {
        super(stocks, activity);
    }

    @Override
    protected void onClickItem(final String item)
    {
        // TODO: nothing yet
    }
}
