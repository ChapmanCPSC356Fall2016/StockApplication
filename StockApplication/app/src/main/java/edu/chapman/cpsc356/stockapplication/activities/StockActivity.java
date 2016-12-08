package edu.chapman.cpsc356.stockapplication.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import edu.chapman.cpsc356.stockapplication.R;
import edu.chapman.cpsc356.stockapplication.StockAPI;
import edu.chapman.cpsc356.stockapplication.models.StockDetailItem;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class StockActivity extends AppCompatActivity
{
    public static final String EXTRA_SYMBOL = "extra_symbol";

    private TextView nameTextView;
    private TextView symbolTextView;
    private TextView priceTextView;
    private TextView changeTextView;

    private LinearLayout detailLayout;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        this.nameTextView = (TextView) findViewById(R.id.tv_name);
        this.symbolTextView = (TextView) findViewById(R.id.tv_symbol);
        this.priceTextView = (TextView) findViewById(R.id.tv_price);
        this.changeTextView = (TextView) findViewById(R.id.tv_change_percent);

        this.detailLayout = (LinearLayout) findViewById(R.id.ll_stock);
        this.progressBar = (ProgressBar) findViewById(R.id.pb);

        final String symbol = getIntent().getStringExtra(EXTRA_SYMBOL);

        StockAPI.Quote(symbol, new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {
                Toast.makeText(StockActivity.this, "An error occurred", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException
            {
                String json = response.body().string();
                final StockDetailItem item = new Gson().fromJson(json, StockDetailItem.class);

                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        nameTextView.setText(item.name);
                        symbolTextView.setText(item.symbol);
                        priceTextView.setText(String.valueOf(item.price));
                        changeTextView.setText(String.valueOf(item.changePercent));

                        progressBar.setVisibility(View.INVISIBLE);
                        detailLayout.setVisibility(View.VISIBLE);
                    }
                });
            }
        });
    }
}
