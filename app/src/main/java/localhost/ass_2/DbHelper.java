package localhost.ass_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by hbc on 1/05/2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final int db1Ver = 14;
    public static final String table1Name = "questions";
    public static final String t1column1 = "_id";
    public static final String t1column2 = "SECTION";
    public static final String t1column3 = "QUESTIONNUM";
    public static final String t1column4 = "QUESTIONTEXT";

    public static final String table2Name = "quizResults";
    public static final String t2column1 = "_id";
    public static final String t2column2 = "DATE";
    public static final String t2column3 = "TIME";
    public static final String t2column4 = "SECTION1";
    public static final String t2column5 = "SECTION2";
    public static final String t2column6 = "SECTION3";

    public static final String table3Name = "tasks";
    public static final String t3column1 = "_id";
    public static final String t3column2 = "DUEDATE";
    public static final String t3column3 = "UNITCODE";
    public static final String t3column4 = "TITLE";
    public static final String t3column5 = "PROVIDER";
    public static final String t3column6 = "ASSESSWEIGHT";
    public static final String t3column7 = "IMPORTANCE";
    public static final String t3column8 = "URGENCY";
    public static final String t3column9 = "COMMENTS";
    public static final String t3column10 = "STATUS";



    public DbHelper(Context context) {
        super(context, table1Name, null, db1Ver);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createDB;

        createDB = "create table " + table1Name + " ("
                + t1column1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + t1column2 + " INTEGER, "
                + t1column3 + " INTEGER, "
                + t1column4 + " STRING"
                + ")";
        db.execSQL(createDB);

        createDB = "create table " + table2Name + " ("
                + t2column1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + t2column2 + " INTEGER, "
                + t2column3 + " INTEGER, "
                + t2column4 + " INTEGER"
                + t2column5 + " INTEGER"
                + t2column6 + " INTEGER"
                + ")";
        db.execSQL(createDB);
    }

    public void insertData(){

        addQuestion(1,1,"Do you make a list of the things you have to do each day?");
        addQuestion(1,2,"Do you plan your day before you start it?");
        addQuestion(1,3,"Do you make a schedule of the activities you have to do on work days? ");
        addQuestion(1,4,"Do you write a set of goals for yourself for each day?");
        addQuestion(1,5,"Do you spend time each day planning?");
        addQuestion(1,6,"Do you have a clear idea of what you want to accomplish during the next week?");
        addQuestion(1,7,"Do you set and honor priorities?");
        addQuestion(2,1,"Do you often find yourself doing things which interfere with your schoolwork simply because you hate to say \"No\" to people?");
        addQuestion(2,2,"Do you feel you are in charge of your own time, by and large?");
        addQuestion(2,3,"On an average class day do you spend more time with personal grooming than doing schoolwork?");
        addQuestion(2,4,"Do you believe that there is room for improvement in the way you manage your time?");
        addQuestion(2,5,"Do you make constructive use of your time?");
        addQuestion(2,6,"Do you continue unprofitable routines or activities?");
        addQuestion(3,1,"Do you usually keep you desk clear of everything other than what you are currently working on?");
        addQuestion(3,2,"Do you have a set of goals for the entire quarter?");
        addQuestion(3,3,"The night before a major assignment is due, are you usually still working on it?");
        addQuestion(3,4,"When you have several things to do, do you think it is best to do a little bit of work on each one?");
        addQuestion(3,5,"Do you regularly review your class notes, even when a test is not imminent?");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table1Name);
        onCreate(db);
    }

    public long addQuestion(int sectionNum, int questionNum, String questionText){

        long insertResult = 0;
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put(t1column2, sectionNum);
        content.put(t1column3, questionNum);
        content.put(t1column4, questionText);

        insertResult = db.insert(table1Name, null, content);
        db.close();

        return (insertResult);
    }

    public String getQuestion(int sectionNum, int questionNum){
        String result;
        SQLiteDatabase db = this.getReadableDatabase();

        String[] queryColumns = {t1column1, t1column2, t1column3, t1column4};
        String queryParams = t1column2 + " = ? AND " + t1column3 + " = ?";
        String[] queryValues = {String.valueOf(sectionNum), String.valueOf(questionNum)};

        Cursor dbCursor = db.query(table1Name, queryColumns, queryParams, queryValues, null, null, null, null);

        if(dbCursor != null){
            dbCursor.moveToFirst();
        }
        Log.d("DBTest - row count is ", String.valueOf(dbCursor.getCount()));

        if(dbCursor.getCount()==0){
            return "no data retrieved";
        }
        else{
            result = dbCursor.getString(3);
            return result;
        }

    }

    public String getQuestionByIndex(int index){
        SQLiteDatabase db = this.getReadableDatabase();

        String[] queryColumns = {t1column1, t1column2, t1column3, t1column4};
        String queryParams = t1column1 + " = ?";
        String[] queryValues = {String.valueOf(index)};

        Cursor dbCursor = db.query(table1Name, queryColumns, queryParams, queryValues, null, null, null, null);

        Log.d("DBTest - row count is ", String.valueOf(dbCursor.getCount()));

        if(dbCursor != null){
            dbCursor.moveToFirst();
        }

        if(dbCursor.getCount()==0){
            return "no data retrieved";
        }
        else{
            return dbCursor.getString(3);
        }

    }

    public int getTableSize(){
        SQLiteDatabase db = this.getReadableDatabase();
        String countQuery = "SELECT  * FROM " + table1Name;

        Cursor dbCursor = db.rawQuery(countQuery, null);

        return dbCursor.getCount();
    }

    public int getQuestionSectionSize(int section){
        SQLiteDatabase db = this.getReadableDatabase();

        String[] queryColumns = {t1column1, t1column2, t1column3, t1column4};
        String queryParams = t1column2 + " = ?";
        String[] queryValues = {String.valueOf(section)};

        Cursor dbCursor = db.query(table1Name, queryColumns, queryParams, queryValues, null, null, null, null);

        return dbCursor.getCount();
    }

}
