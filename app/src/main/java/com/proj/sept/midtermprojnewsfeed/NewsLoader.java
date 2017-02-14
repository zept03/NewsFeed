package com.proj.sept.midtermprojnewsfeed;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import com.proj.sept.midtermprojnewsfeed.News;
import com.proj.sept.midtermprojnewsfeed.QueryUtils;

import java.io.IOException;
import java.net.URL;
import java.util.List;



public class NewsLoader extends AsyncTaskLoader<List<News>> {
    private static final String LOG_TAG = NewsLoader.class.getName();

    private String mUrl;

    public NewsLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        List<News> stories = null;
        try {
            URL url = QueryUtils.createUrl();
            String jsonResponse = QueryUtils.makeHttpRequest(url);
            stories = QueryUtils.parseJson(jsonResponse);
        } catch (IOException e) {
            Log.e("Queryutils", "Error Loader LoadInBackground: ", e);
        }
        return stories;
    }
}


