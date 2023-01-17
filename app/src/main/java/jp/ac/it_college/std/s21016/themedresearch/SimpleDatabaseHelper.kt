package jp.ac.it_college.std.s21016.themedresearch

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SimpleDatabaseHelper(context: Context?) :
 SQLiteOpenHelper(context, DBNAME , null, VERSION) {

    companion object{
        private const val DBNAME = "ha-book.sqlite"
        private const val VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.let {
            it.execSQL("CREATE TABLE Item_information (" +
                    "Item_id INTEGER PRIMARY KEY, Item_name TEXT)")
            it.execSQL("CREATE TABLE Household_account_book (" +
                    "date TEXT DEFAULT '1/1' NOT NULL, expense_item_id INTEGER DEFAULT '1' NOT NULL, Deposit_amount INTEGER, Withdrawal_amount INTEGER, FOREIGN KEY (expense_item_id) REFERENCES Item_information(Item_id))")
            it.execSQL("INSERT INTO Item_information(Item_id, Item_name)" +
                    " VALUES('1', '食費')")
            it.execSQL("INSERT INTO Item_information(Item_id, Item_name)" +
                    " VALUES('2', '日用品')")
            it.execSQL("INSERT INTO Item_information(Item_id, Item_name)" +
                    " VALUES('3', '光熱費')")
            it.execSQL("INSERT INTO Item_information(Item_id, Item_name)" +
                    " VALUES('4', '交通費')")
            it.execSQL("INSERT INTO Item_information(Item_id, Item_name)" +
                    " VALUES('5', '娯楽費')")
            it.execSQL("INSERT INTO Item_information(Item_id, Item_name)" +
                    " VALUES('6', '通信費')")
            it.execSQL("INSERT INTO Item_information(Item_id, Item_name)" +
                    " VALUES('7', '給料')")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.let {
            it.execSQL("DROP TABLE IF EXISTS Household_account_book")
            onCreate(it)
        }
    }

    override fun onOpen(db: SQLiteDatabase?) {
        super.onOpen(db)
    }

}