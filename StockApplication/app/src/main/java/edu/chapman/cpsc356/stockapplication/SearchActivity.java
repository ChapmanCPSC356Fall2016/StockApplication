package edu.chapman.cpsc356.stockapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity
{

    private RecyclerView stockSearchListView;
    private List<String> stockSearchResults = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        this.stockSearchListView = (RecyclerView) findViewById(R.id.rv_search);

        this.stockSearchListView.setAdapter(new StockAdapter(stockSearchResults, true, this));

        this.stockSearchListView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void searchClicked(View view)
    {
        this.stockSearchResults.add("GOOGL");
        this.stockSearchResults.add("GOOG");

        this.stockSearchListView.getAdapter().notifyDataSetChanged();
    }
}
