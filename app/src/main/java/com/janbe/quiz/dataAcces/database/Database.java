package com.janbe.quiz.dataAcces.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JanBelterman on 06 April 2018
 */

public class Database extends SQLiteOpenHelper {

    public Database(Context context,
                    String name,
                    SQLiteDatabase.CursorFactory cursorFactory,
                    int version) {
        super(context, name, cursorFactory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
