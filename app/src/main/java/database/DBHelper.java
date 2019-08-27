package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "UserInfo.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_ENTRIES = "CREATE TABLE "+
                UserMaster.Users.TABLE_NAME+" ("+UserMaster.Users._ID+" INTEGER PRIMARY KEY, "+
                UserMaster.Users.COLUMN_NAME_USERNAME+" TEXT,"+
                UserMaster.Users.COLUMN_NAME_PASSWORD+" TEXT)";

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long addInfo(String username, String password) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserMaster.Users.COLUMN_NAME_USERNAME,username);
        values.put(UserMaster.Users.COLUMN_NAME_PASSWORD,password);

        long rownum = db.insert(UserMaster.Users.TABLE_NAME,null,values);

        if(rownum > 0){
            Log.d("Insert", "Data added Successsfully");
        }

        else{
            Log.d("Insert", "Error");
        }

        return rownum;
    }

//    public List readAllInfo(){
//        SQLiteDatabase db = getReadableDatabase();
//
//        //define a projection  that
//        //
//        String[] projection = {
//
//                UserMaster.Users._ID;
//
//
//        }
//
//        List UserNames = new ArrayList<>();
//
//        return UserNames;
//    }

}
