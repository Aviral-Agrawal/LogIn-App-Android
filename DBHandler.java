package app.com.example.aviral.loginapp2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.view.View;
import android.content.Context;
import android.content.ContentValues;



public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    //Name of the database
    private static final String DATABASE_NAME = "dataDB.db";
    //Table name
    public static final String TABLE_DATA = "data";
    //Column fields
    public static final String COLUMN_ID="id";
    public static final String COLUMN_FIRST_NAME = "firstName";
    public static final String COLUMN_SECOND_NAME = "secondName";
    public static final String COLUMN_USERNAME="username";
    public static final String COLUMN_DOB="dob";
    public static final String COLUMN_ADDRESS="address";
    public static final String COLUMN_GENDER="gender";
    public static final String COLUMN_PASSWORD="pass";

    //We need to pass database information along to superclass
    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_DATA + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FIRST_NAME + " TEXT " +
                COLUMN_SECOND_NAME + " TEXT " +
                COLUMN_USERNAME + " TEXT " +
                COLUMN_DOB + " TEXT " +
                COLUMN_ADDRESS + " TEXT " +
                COLUMN_GENDER + " TEXT " +
                COLUMN_PASSWORD + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DATA);
        onCreate(db);
    }

    //Add a new row to the database
    public void addData(Data data){
        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRST_NAME, data.getFirstName());
        values.put(COLUMN_SECOND_NAME, data.getFirstName());
        values.put(COLUMN_USERNAME, data.getFirstName());
        values.put(COLUMN_DOB, data.getFirstName());
        values.put(COLUMN_ADDRESS, data.getFirstName());
        values.put(COLUMN_GENDER, data.getFirstName());
        values.put(COLUMN_PASSWORD, data.getFirstName());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_DATA, null, values);
        db.close();
    }

    //Ckeck database credentials
    public boolean checkCredentials(String username,String pass)
    {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_DATA + " WHERE 1";
        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();
        int flag=0;

        while (!c.isAfterLast()) {
            if(c.getString(c.getColumnIndex("COLUMN_USERNAME")).equals(username)&&
                    c.getString(c.getColumnIndex("COLUMN_PASSWORD")).equals(pass))
            {
                flag=1;
                break;
            }

        }
        if(flag==1)
            return true;
        else return false;
    }

    //Delete a product from the database
    public void deleteProduct(String id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_DATA + " WHERE " + COLUMN_ID + "=\"" + id + "\";");
    }

    public String databaseToString() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_DATA + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("COLUMN_ID")) != null) {
                dbString += c.getString(c.getColumnIndex("COLUMN_ID"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }
}
