package edu.chapman.cpsc356.stockapplication;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.Test;

import java.util.List;

import edu.chapman.cpsc356.stockapplication.models.StockDetailItem;
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

        List<StockItem> items = new Gson().fromJson(json, new TypeToken<List<StockItem>>(){}.getType());

        // stupid test stuff
        assertNotNull(items);
        assertNotEquals(items.size(), 0);

        System.out.println(json);
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

        StockDetailItem item = new Gson().fromJson(json, StockDetailItem.class);

        // stupid test stuff
        assertNotNull(item);
        assertNotEquals(item.name, "");

        System.out.println(json);
    }
}