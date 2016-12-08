package edu.chapman.cpsc356.stockapplication.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.chapman.cpsc356.stockapplication.R;
import edu.chapman.cpsc356.stockapplication.StockAPI;
import edu.chapman.cpsc356.stockapplication.adapters.SearchStockAdapter;
import edu.chapman.cpsc356.stockapplication.models.StockItem;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SearchActivity extends AppCompatActivity
{

    private RecyclerView stockSearchListView;
    private List<String> stockSearchResults = new ArrayList<>();
    private EditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        this.searchEditText = (EditText) findViewById(R.id.et_search);

        this.stockSearchListView = (RecyclerView) findViewById(R.id.rv_search);

        this.stockSearchListView.setAdapter(new SearchStockAdapter(stockSearchResults, this));

        this.stockSearchListView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void searchClicked(View view)
    {
        String lookupString = this.searchEditText.getText().toString();
        StockAPI.Lookup(lookupString, new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {
                Toast.makeText(SearchActivity.this, "Something bad happened", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException
            {
                String json = response.body().string();

                List<StockItem> items = new Gson().fromJson(json, new TypeToken<List<StockItem>>()
                {
                }.getType());

                for (StockItem item : items)
                {
                    stockSearchResults.add(item.symbol);
                }

                // Run any UI code on the UI thread
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        stockSearchListView.getAdapter().notifyDataSetChanged();
                    }
                });
            }
        });
    }
}
