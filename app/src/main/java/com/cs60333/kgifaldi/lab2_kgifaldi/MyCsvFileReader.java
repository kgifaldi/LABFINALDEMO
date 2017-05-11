package com.cs60333.kgifaldi.lab2_kgifaldi;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Kyle on 3/1/2017.
 */

// random comment

public class MyCsvFileReader {

    Context context;
    public MyCsvFileReader(Context applicationContext) {
        this.context = applicationContext;
    }

    public ArrayList<Team> readCsvFile(int fileresource) {
        ArrayList<Team> games = new ArrayList<>();
        InputStream fin = null;
        InputStreamReader isr = null;
        BufferedReader reader = null;
        try {
            fin = context.getResources().openRawResource(fileresource);
            isr = new InputStreamReader(fin);
            reader = new BufferedReader(isr);
            String line = "";
            String dum = "";
            while ((line = reader.readLine()) != null) {
                String[] teamInfo = line.split(",");
                Team temp = new Team(teamInfo[0], teamInfo[1], teamInfo[2], teamInfo[3], teamInfo[4], teamInfo[5]);
                games.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null)
                    isr.close();
                if (fin != null)
                    fin.close();
                if (reader != null)
                    reader.close();
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
        return games;
    }
}