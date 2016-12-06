package edu.chapman.cpsc356.stockapplication.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ryanburns on 12/5/16.
 */

public class StockItem
{
    @SerializedName("Name")
    public String name;

    @SerializedName("Symbol")
    public String symbol;
}
