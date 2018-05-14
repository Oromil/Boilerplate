package com.example.oromil.boilerppate.data.local;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.oromil.boilerppate.EatingTableEntity;
import com.example.oromil.boilerppate.data.Food;
import com.example.oromil.boilerppate.data.UserData;

public class Database {


    public static final String USER_DATA_TABLE_NAME = "user_data";
    public static final String FOOD_TABLE_NAME = "food_table";
    public static final String EATING_TABLE_NAME = "eating_table";

    public Database() {
    }

    public abstract static class UserDataTable {

        public static final String COLUMN_USER_NAME = "user_name";
        public static final String COLUMN_USER_SURNAME = "user_surname";
        public static final String COLUMN_USER_PATRONYMIC = "user_patronymic";
        public static final String COLUMN_USER_GENDER = "user_gender";
        public static final String COLUMN_USER_HEIGHT = "user_height";
        public static final String COLUMN_USER_WEIGHT = "user_weight";
        public static final String COLUMN_USER_DIAGNOSIS = "user_diagnosis";

        public static final String CREATE =
                "CREATE TABLE " + USER_DATA_TABLE_NAME + " ( " +
                        COLUMN_USER_SURNAME + " TEXT NOT NULL, " +
                        COLUMN_USER_NAME + " TEXT NOT NULL, " +
                        COLUMN_USER_PATRONYMIC + " TEXT NOT NULL, " +
                        COLUMN_USER_GENDER + " TEXT NOT NULL, " +
                        COLUMN_USER_HEIGHT + " TEXT NOT NULL, " +
                        COLUMN_USER_WEIGHT + " TEXT NOT NULL, " +
                        COLUMN_USER_DIAGNOSIS + " TEXT NOT NULL" + " ); ";

        public static ContentValues toContentValues(UserData data) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_USER_SURNAME, data.getSurname());
            values.put(COLUMN_USER_NAME, data.getName());
            values.put(COLUMN_USER_GENDER, data.getGender());
            values.put(COLUMN_USER_HEIGHT, data.getHeight());
            values.put(COLUMN_USER_WEIGHT, data.getWeight());
            values.put(COLUMN_USER_DIAGNOSIS, data.getDiagnosys());
            values.put(COLUMN_USER_PATRONYMIC, data.getPatronymic());
            return values;
        }

        public static UserData parseCursor(Cursor cursor) {
            return new UserData();
//            (cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_SPECIALITY_ID)),
//                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_SPECIALITY_NAME)));
        }
    }

    public abstract static class FoodTable {

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_CARBOHYDRATES = "carbohydrates";

        public static final String CREATE = "CREATE TABLE " + FOOD_TABLE_NAME +
                " ( " + COLUMN_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_NAME + " TEXT NOT NULL, " + COLUMN_CARBOHYDRATES + " TEXT NOT NULL" + " ); ";

        public static ContentValues toContentValues(Food food) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME, food.getName());
            values.put(COLUMN_CARBOHYDRATES, food.getCarbohydrates());
            return values;
        }

        public static Food parseCursor(Cursor cursor) {
            Food food = new Food(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CARBOHYDRATES)));
            food.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)));
            return food;
        }

    }

    public static class EatingTable {
//        public static final String COLUMN_ID = "id";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_TIME = "time";
        public static final String COLUMN_MASS = "mass";
        public static final String COLUMN_INDEX = "ind";

//        public static final String CREATE = "CREATE TABLE " + EATING_TABLE_NAME +
//                " ( " + COLUMN_ID + ", INTEGER PRIMARY KEY, " +
//                COLUMN_DATE + " TEXT NOT NULL, " + COLUMN_TIME + " TEXT NOT NULL, " +
//                COLUMN_FOOD_ID + " INTEGER NOT NULL" + " ); ";

        public static final String CREATE = "CREATE TABLE " + EATING_TABLE_NAME +
                " ( " + COLUMN_DATE + " TEXT NOT NULL, " + COLUMN_TIME + " TEXT NOT NULL, " +
                COLUMN_MASS + " TEXT NOT NULL, " + COLUMN_INDEX+ " TEXT NOT NULL"+" ); ";

        public static ContentValues toContentValues(EatingTableEntity entity) {
            ContentValues contentValues = new ContentValues();

            contentValues.put(COLUMN_DATE, entity.getDate());
            contentValues.put(COLUMN_TIME, entity.getTime());
            contentValues.put(COLUMN_MASS, entity.getMass());
            contentValues.put(COLUMN_INDEX, entity.getIndex());

            return contentValues;
        }

        public static EatingTableEntity parseCursor(Cursor cursor) {
            return new EatingTableEntity(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TIME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MASS)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_INDEX)));
        }
    }
}
