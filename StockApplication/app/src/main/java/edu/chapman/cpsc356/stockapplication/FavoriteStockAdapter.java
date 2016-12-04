package edu.chapman.cpsc356.stockapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

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
