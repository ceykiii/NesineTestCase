package service;

import dto.PopulerBet;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestClient class for making HTTP requests and processing the response.
 * This class is developed by Cem AÇAR.
 * Last updated on 11.11.23
 */
public class RestClient {

    /**
    * Makes a POST request to the specified URL with the provided JSON data and retrieves the response as a JSONObject.
    * @return The JSONObject representing the response.
     */
    public JSONObject getResponse() {
        String url = "https://www.nesine.com/Iddaa/PopularBetsModal";
        String cookieValue = "nsnid=xgoniggv2tvjkn4ghr1kkp4m";

        OkHttpClient client = new OkHttpClient();
        String json = "{\"eventType\":1,\"date\":null}";
        RequestBody requestBody = RequestBody.create(json, MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", cookieValue)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String jsonResponse = response.body().string();
            return new JSONObject(jsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Retrieves a list of popular bets from the response JSONObject.
     * @return The list of PopulerBet objects representing popular bets.
     */
    public List<PopulerBet> getPopularBet() {
        JSONArray popularBetListArray = this.getResponse().getJSONArray("PopularBetList");
        List<PopulerBet> betInfoList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            JSONObject jsonObjectX = popularBetListArray.getJSONObject(i);
            Integer playedCount = jsonObjectX.getInt("PlayedCount");
            Integer marketNo = jsonObjectX.getInt("MarketNo");
            PopulerBet populerBet = new PopulerBet(playedCount, marketNo);
            betInfoList.add(populerBet);
        }
        return betInfoList;
    }
}
