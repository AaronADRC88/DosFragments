package com.example.android.rssreader;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by aferreiradominguez on 11/18/15.
 */
public class MyListFragment extends Fragment {

    private Onfrag2Listener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rsslist_overview,
                container, false);
        Button button = (Button) view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail("lololololololololololololo");
            }
        });
        Button button2 = (Button) view.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clean();
            }
        });
        return view;

    }

    public interface Onfrag2Listener {
        public void onItemSelected(String link);
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        if (context instanceof Onfrag2Listener) {
            listener = (Onfrag2Listener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    // triggers update of the details fragment
    public void updateDetail(String uri) {
        // create fake data
        String newTime = String.valueOf(System.currentTimeMillis());
        // send data to activity
        listener.onItemSelected(newTime);
    }

    public void clean() {
        listener.onItemSelected("");
    }

    public void setText(String url) {
        TextView view = (TextView) getView().findViewById(R.id.readyText);
        view.setText(url);
    }


}

