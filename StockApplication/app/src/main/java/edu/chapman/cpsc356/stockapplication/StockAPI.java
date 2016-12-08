package edu.chapman.cpsc356.stockapplication;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ryanburns on 12/7/16.
 */

public class StockAPI
{
    public static void Lookup(String searchText, Callback onFinish)
    {
        // Make lookup request
        String baseUrl = "http://dev.markitondemand.com/MODApis/Api/v2";
        String method = "/Lookup/json";

        String queryParams = "?input=" + searchText;

        String fullUrl = baseUrl + method + queryParams;

        OkHttpClient client = new OkHttpClient();

        Request req = new Request.Builder()
                .url(fullUrl)
                .build();

        client.newCall(req).enqueue(onFinish);
    }

    public static void Quote(String symbol, Callback onFinish)
    {
        String baseUrl = "http://dev.markitondemand.com/MODApis/Api/v2";
        String method = "/Quote/json";

        String queryParams = "?symbol="+symbol;

        String fullUrl = baseUrl+method+queryParams;

        OkHttpClient client = new OkHttpClient();

        Request req = new Request.Builder()
                .url(fullUrl)
                .build();

        client.newCall(req).enqueue(onFinish);
    }
}
