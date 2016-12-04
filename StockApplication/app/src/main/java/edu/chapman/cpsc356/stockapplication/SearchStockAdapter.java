package edu.chapman.cpsc356.stockapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import java.util.List;

public class SearchStockAdapter extends StockAdapter
{
    public SearchStockAdapter(List<String> stocks, Activity activity)
    {
        super(stocks, activity);
    }

    @Override
    protected void onClickItem(final String item)
    {
        String message = activity.getString(R.string.are_you_sure_message, item);
        new AlertDialog.Builder(activity)
                .setTitle(R.string.are_you_sure)
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        FavoriteStockCollection.Get().addFavoriteStock(item);
                        activity.finish();
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .create()
                .show();
    }
}
