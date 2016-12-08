package edu.chapman.cpsc356.stockapplication.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ryanburns on 12/7/16.
 */

public class StockDetailItem extends StockItem
{
    @SerializedName("LastPrice")
    public float price;

    @SerializedName("ChangePercent")
    public float changePercent;
}
