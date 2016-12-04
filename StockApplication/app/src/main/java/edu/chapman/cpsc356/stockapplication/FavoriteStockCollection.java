package edu.chapman.cpsc356.stockapplication;

import java.util.ArrayList;
import java.util.List;

public class FavoriteStockCollection
{
    private static FavoriteStockCollection stockCollection;

    private List<String> favoriteStocks;

    private FavoriteStockCollection()
    {
        this.favoriteStocks = new ArrayList<>();
    }

    public static FavoriteStockCollection Get()
    {
        if (stockCollection == null)
        {
            stockCollection = new FavoriteStockCollection();
        }

        return stockCollection;
    }

    public List<String> getFavoriteStocks()
    {
        return this.favoriteStocks;
    }

    public void addFavoriteStock(String stock)
    {
        if (!this.favoriteStocks.contains(stock))
        {
            this.favoriteStocks.add(stock);
        }
    }
}
