package com.itbank.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 연지점204강사 on 2017-06-24.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String TAG = "DBHelper";

    //SQLiteOpenHelper를 상속받기 위해서는 아래의 정보들이 필요하다
    //context       소속
    //name          DB이름
    //factory        커서 제조기(커서는 Iterator와 유사한 개념)
    //version       이 데이터베이스의 버전(관리버전)
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //최초의 DB가 생성될 때 실행
        Log.d(TAG, "onCreate 실행");
        createTable(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //생성자에서 version이 업그레이드 되었을 때 호출
        Log.d(TAG, "onUpgrade 실행");
        createTable(sqLiteDatabase);
    }

    private void createTable(SQLiteDatabase database){
        /*
                    name(TEXT) │    price(INTEGER)
                ───────────┼─────────────       이런 형태의 테이블을 생성하려고 할 때의 코드
         */

        //[1] 데이터베이스는 매개변수로 전달받아서 사용(최초에는 내가 만드는 것이 아니라 자동생성된 것을 이용)
        //[2] 명령 준비
        StringBuffer buffer = new StringBuffer();
        buffer.append("create table if not exists cafe(");
        buffer.append("name TEXT,");
        buffer.append("price INTEGER");
        buffer.append(");");

        //[3] 명령 전송(실행)
        database.execSQL(buffer.toString());

    }

    public void drop(){
        //생성된 이후에는 작업의 필요성에 따라 쓰기용 DB , 읽기용 DB를 불러와서 사용한다
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("drop table cafe");
        database.close();
    }

    //DB와 관련된 기능을 하나씩 구현할 때마다 메소드 단위로 구현
    public void insert(String name, int price){
        SQLiteDatabase db = getWritableDatabase();
        //추가 명령 형식 : insert into cafe values('메뉴이름', 메뉴가격);
        String sql = String.format("insert into cafe values('%s', %d)", name, price);
        db.execSQL(sql);
    }

    //목록 조회 메소드 : 명령을 통해 DB table 데이터를 받아서 String으로 조합한 뒤 반환
    public String getList(){
        //String sql = "select 항목 from 테이블 [조건] [정렬]";
        String sql = "select * from cafe";

        SQLiteDatabase db = getReadableDatabase();
        //db.execSQL(sql);//명령을 DB에 전송하고 끝
        Cursor cursor = db.rawQuery(sql, null);//결과를 가져오는 전송명령

        //cursor를 잘 조절하여 우리가 원하는 데이터 형태로 조합한 뒤 반환
        StringBuffer buffer = new StringBuffer();
        while(cursor.moveToNext()){
            //1줄에 접근한 상황. cursor를 이용하여 세부 데이터를 추출
            String n = cursor.getString(0);
            int p = cursor.getInt(1);
            buffer.append("이름 = "+n+", 가격 = "+p+"원\n");
        }
        return buffer.toString();
    }

    public void delete(String name){
        SQLiteDatabase db = getWritableDatabase();
        String sql = String.format("delete from cafe where name='%s';", name);
        db.execSQL(sql);
    }

    public void update(String name, int price){
        SQLiteDatabase db = getWritableDatabase();
        String sql = String.format("update cafe set price=%d where name='%s';", price, name);
        db.execSQL(sql);
    }
}










