package com.cs60333.kgifaldi.lab2_kgifaldi;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.database.sqlite.SQLiteDatabase.CursorFactory;
        import android.view.View;
        import android.widget.TextView;

public class DBHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "teams.db";
    public static int DATABASE_VERSION = 1;
    public static String TABLE_TEAM = "Team";
    public static String COL_NAME = "team_name";
    public static String COL_DATE = "team_date";
    public static String COL_MASCOT = "team_mascot";
    public static String COL_RECORD = "team_record";
    public static String COL_SCORE = "team_score";
    public static String COL_ID = "_id";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, (CursorFactory)null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_TEAM + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_NAME + " String," + COL_DATE + " String," + COL_MASCOT + " String," +COL_RECORD + "String " + COL_SCORE + "String);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP if exists TABLE " + TABLE_TEAM);
        this.onCreate(db);
    }




}
