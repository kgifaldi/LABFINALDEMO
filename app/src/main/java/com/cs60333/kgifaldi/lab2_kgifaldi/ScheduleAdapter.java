package com.cs60333.kgifaldi.lab2_kgifaldi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kyle on 2/8/2017.
 */
class ScheduleAdapter<T> extends ArrayAdapter<Team> {
    ScheduleAdapter(Context context, int simple_list_item_1, ArrayList<Team> schedule) {
        super(context, R.layout.schedule_item, schedule);
    }

    public View getView (int position, View convertView, ViewGroup parent) {
        LayoutInflater scheduleInflater = LayoutInflater.from(getContext());
        View scheduleView = scheduleInflater.inflate(R.layout.schedule_item, parent, false);

        Team matchItem = getItem(position);
        TextView teamName = (TextView) scheduleView.findViewById(R.id.textView3);
        TextView gameDate = (TextView) scheduleView.findViewById(R.id.textView4);
        teamName.setText(matchItem.getTeamName());
        gameDate.setText(matchItem.getGameDate());
        ImageView teamLogo = (ImageView) scheduleView.findViewById(R.id.imageView2);
        String mDrawableName = matchItem.getTeamLogo();
        int resID = getContext().getResources().getIdentifier(mDrawableName, "drawable", getContext().getPackageName());
        teamLogo.setImageResource(resID);


        return scheduleView;
    }

}