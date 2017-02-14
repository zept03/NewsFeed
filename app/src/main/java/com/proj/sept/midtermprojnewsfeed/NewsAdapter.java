package com.proj.sept.midtermprojnewsfeed;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;



public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(Context context, ArrayList<News> stories) {
        super(context, 0, stories);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list, parent, false);
        }

        // Get the object located at this position in the list
        final News news = getItem(position);


        // Find the TextView in the list_item.xml layout
        TextView headlineTextView = (TextView) listItemView.findViewById(R.id.title);
        // Set the text on the TextView
        headlineTextView.setText(news.getTitle());

        TextView lastModifiedTextView = (TextView) listItemView.findViewById(R.id.date);
        lastModifiedTextView.setText(news.getLastModified());

        TextView sectionTextView = (TextView) listItemView.findViewById(R.id.section);
        sectionTextView.setText(news.getSection());

        LinearLayout listItemContainerView = (LinearLayout) listItemView.findViewById(R.id.news_item);
        listItemContainerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse
                        (news.getUrl())));
            }
        });

        return listItemView;
    }
}

