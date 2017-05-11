package com.cs60333.kgifaldi.lab2_kgifaldi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.content.Context;
// TODO why wont these import???
import android.support.design.widget.Snackbar;

import android.support.design.widget.CoordinatorLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static com.cs60333.kgifaldi.lab2_kgifaldi.R.styleable.CoordinatorLayout;

public class MainActivity extends AppCompatActivity {
    ArrayList<Team> al = new ArrayList<>();

    int num = 0;
    DBHelper dbhelper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyCsvFileReader cr = new MyCsvFileReader(this.getApplicationContext());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar...

        android.support.v7.widget.Toolbar t = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(t);
        t.setTitle("ND Athletics");

        //Team teams = new String[]{"Ohio State", "Florida State", "Wake Forest", "Boston College", "North Carolina State", "Georgia Tech", "North Virginia", "Chicago State"};
/*
        Team temp = new Team("fs", "Florida State", "Feb 11", "Osceola and Renegade", "(5-20)", "55-99");
        Team temp1 = new Team("bc", "Boston College", "Feb 14", "The Eagles", "(19-9)", "76 - 84");
        Team temp2 = new Team("ncs", "North Carolina State", "Feb 18", "Rameses", "(5-24)", "59 - 69");
        Team temp3 = new Team("gt", "Georgia Tech", "Feb 26", "The Buzz", "(15-15)", "77 - 85");
        Team temp4 = new Team("bc", "Boston College", "March 1", "The Eagles", "(19-9)", "TBD");
        Team temp5 = new Team("l", "Louisville", "March 4", "Cardinal Bird", "(15-20)", "TBD");
        Team temp6 = new Team("t", "ACC Tournament", "March 7", "ACC", "(NA-NA)", "TBD");
        Team temp7 = new Team("t", "NCAA Tournament", "March 16", "NCAA", "(NA-NA)", "TBD");
*/
        al = cr.readCsvFile(R.raw.schedule);
/*
        al.add(temp);
        al.add(temp1);
        al.add(temp2);
        al.add(temp3);
        al.add(temp4);
        al.add(temp5);
        al.add(temp6);
        al.add(temp7);
*/

        ScheduleAdapter<ArrayList<Team>> scheduleAdapter = new ScheduleAdapter<ArrayList<Team>>(this, android.R.layout.simple_list_item_1, al);
        ListView scheduleListView = (ListView) findViewById(R.id.scheduleListView);



        scheduleListView.setAdapter(scheduleAdapter);



        final AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView parent, View view, int position, long id) {

//Write code here to open the activity that will show details of the game event,i.e. if //you click on Florida State, you should see details of the match between Florida State //and Notre Dame. You need to do the following three steps.

//create the intent to start DetailActivity

                Intent gameIntent = new Intent(getApplicationContext(), DetailActivity.class);
//create a bundle object using the following:

                gameIntent.putExtra("team", al.get(position)); //where al is your ArrayList holding team information.

//start the activity using the intent with the bundle you just created.

                startActivity(gameIntent);
                //finish();

            }

        };

// this will automatically attach the listener to each item of the listview.

        scheduleListView.setOnItemClickListener (clickListener);


    }



    public void fn_insert(View view){

        TextView date = (TextView) findViewById(R.id.date);
        TextView teamName = (TextView) findViewById(R.id.rightTeamName);
        //TextView teamLogo = (TextView) findViewById(R.id.rightTeamLogo);
        TextView teamMascot = (TextView) findViewById(R.id.rightTeamMascot);
        TextView teamRecord = (TextView) findViewById(R.id.rightTeamRecord);
        TextView finalScore = (TextView) findViewById(R.id.finalScore);
        String ds = String.valueOf(date.getText());
        String dn = String.valueOf(teamName.getText());
        String dm = String.valueOf(teamMascot.getText());
        String dr = String.valueOf(teamRecord.getText());
        String df = String.valueOf(finalScore.getText());
        String tmpLogo = "temp"; // TODO
        int teamid = num++;
        //idbhelper.insertData(new Team(tmpLogo, dn, ds, dm, dr, df));
       }




    // TODO: below
    public String gameSchedule(){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < al.size(); i++) {
            str.append((al.get(i).getTeamName()));
            str.append((al.get(i).getGameDate()));
        }
        return str.toString();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int item_id = item.getItemId();

        if (item_id == R.id.woman) {
            // to be implemented later
        }
        else if (item_id == R.id.men){
            // to be implemented later
        }
        else if (item_id == R.id.on){
            // to be implemented later
        }
        else if (item_id == R.id.off){
            // to be implemented later
        }
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){

        super.onCreateContextMenu(menu, v, menuInfo);
        registerForContextMenu((View) findViewById(R.id.settings));

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.floating_contextual_menu, menu);
    }
    // TODO: above



    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();

        if (res_id == R.id.share) {
            Intent shareIntent = new Intent();
            shareIntent.setAction(android.content.Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra("android.content.Intent.EXTRA_SUBJECT", "BasketBall Matches");
            shareIntent.putExtra("android.content.Intent.EXTRA_TEXT", gameSchedule());
            startActivity(Intent.createChooser(shareIntent, "Share via"));
        }

        else if (res_id == R.id.sync) {
// Snackbar with Try Again action
            final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorlayout);

            Snackbar snackbar = Snackbar.make(coordinatorLayout, "Sync is not yet implemented", Snackbar.LENGTH_LONG);

            snackbar.setAction("Try Again", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(coordinatorLayout, "Wait for the next few labs. Thank you for your patience", Snackbar.LENGTH_LONG).show();
                }

            });

            snackbar.show();

        }

        else if (res_id == R.id.settings) {
            registerForContextMenu((View) findViewById(R.id.settings));
            //    TODO:below    ???                                ???
            onCreateContextMenu(null, findViewById(R.id.settings), null);

        }
        return true;
    }

}
