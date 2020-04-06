package com.example.sql_week10;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * This class serves as a helper class to ope and create a database. Constant variables are created for table columns,
 * a constructor is defined to create a table, an execute database SQL is executed in onCreate, and code is provided
 * to assist with upgrading the database
 *
 * @author Modified ahagmann on 4/5/2020
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_COMMENTS = "comments";     //The name of the table
    public static final String COLUMN_ID = "_id";               //The column name of the primary key
    public static final String COLUMN_COMMENT = "comment";      //The column name of the comment field
    public static final String COLUMN_RATING = "rating";          //The column name of the rating field
    private static final String DATABASE_NAME = "commments.db";
    private static final int DATABASE_VERSION = 2;

    // Database creation sql statement
    /* SQL table create-----------
    * CREATE TABLE comments (
    * COMMENT_ID string,
    * COMMENT string,
    * );
     */

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_COMMENTS + "( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_COMMENT
            + " text not null, " + COLUMN_RATING + " text not null);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
        onCreate(db);
    }

}