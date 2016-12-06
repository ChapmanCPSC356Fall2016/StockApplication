package edu.chapman.cpsc356.stockapplication;

import com.google.gson.Gson;

import org.junit.Test;

import edu.chapman.cpsc356.stockapplication.models.StockItem;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest
{
    @Test
    public void addition_isCorrect() throws Exception
    {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testStockLookup() throws Exception
    {
        String baseUrl = "http://dev.markitondemand.com/MODApis/Api/v2";
        String method = "/Lookup/json";

        String lookupString = "GOOG";

        String queryParams = "?input="+lookupString;

        String fullUrl = baseUrl+method+queryParams;

        OkHttpClient client = new OkHttpClient();

        Request req = new Request.Builder()
                .url(fullUrl)
                .build();

        Response res = client.newCall(req).execute();

        String json = res.body().string();

        // stupid test stuff
        assertNotNull(json);
        assertNotEquals(json, "");
    }

    @Test
    public void testStockQuote() throws Exception
    {
        String baseUrl = "http://dev.markitondemand.com/MODApis/Api/v2";
        String method = "/Quote/json";

        String lookupString = "GOOG";

        String queryParams = "?symbol="+lookupString;

        String fullUrl = baseUrl+method+queryParams;

        OkHttpClient client = new OkHttpClient();

        Request req = new Request.Builder()
                .url(fullUrl)
                .build();

        Response res = client.newCall(req).execute();

        String json = res.body().string();

        StockItem item = new Gson().fromJson(json, StockItem.class);

        // stupid test stuff
        assertNotNull(item);
        assertNotEquals(item.name, "");
    }
}