package edu.chapman.cpsc356.stockapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import edu.chapman.cpsc356.stockapplication.adapters.FavoriteStockAdapter;
import edu.chapman.cpsc356.stockapplication.FavoriteStockCollection;
import edu.chapman.cpsc356.stockapplication.R;

public class FavoritesActivity extends AppCompatActivity
{
    private RecyclerView favoriteStockListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        this.favoriteStockListView = (RecyclerView) findViewById(R.id.rv_fav_stocks);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(FavoritesActivity.this, SearchActivity.class));
            }
        });
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        if (this.favoriteStockListView.getAdapter() == null)
        {
            List<String> favoritesList = FavoriteStockCollection.Get().getFavoriteStocks();
            this.favoriteStockListView.setAdapter(new FavoriteStockAdapter(favoritesList, this));

            this.favoriteStockListView.setLayoutManager(new LinearLayoutManager(this));
        }
        else
        {
            this.favoriteStockListView.getAdapter().notifyDataSetChanged();
        }
    }
}
