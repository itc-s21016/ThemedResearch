package jp.ac.it_college.std.s21016.themedresearch

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.sql.SQLException

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
            it.execSQL("INSERT INTO Household_account_book(date, expense_item_id, Deposit_amount, Withdrawal_amount)" +
                    " VALUES('1/1', '7', '50000', '')")
            it.execSQL("INSERT INTO Household_account_book(date, expense_item_id, Deposit_amount, Withdrawal_amount)" +
                    " VALUES('1/2', '1', '', '540')")
            it.execSQL("INSERT INTO Household_account_book(date, expense_item_id, Deposit_amount, Withdrawal_amount)" +
                    " VALUES('1/1', '5', '', '1000')")

            // データベースに登録する値を準備
            val data = listOf(
                mapOf("date" to "02/15", "expense_item_id" to "1", "Deposit_amount" to "10000", "Withdrawal_amount" to "1000" )
            )

            // トランザクションを開始
            it.beginTransaction()
            try {
                //SQL命令を準備
                val sql = it.compileStatement(
                    "INSERT INTO Household_account_book(date, expense_item_id, Deposit_amount, Withdrawal_amount) VALUES(?, ?, ?)"
                )
                // 値を順に代入しながら、SQL命令を実行
                data.forEach {
                    sql.bindString(1, it["date"])
                    sql.bindString(1, it["expense_item_id"])
                    sql.bindString(1, it["Deposit_amount"])
                    sql.bindString(1, it["Withdrawal_amount"])
                    sql.executeInsert()
                }
                it.setTransactionSuccessful()
            }catch (e: SQLException) {
                e.printStackTrace()
            } finally {
                it.endTransaction()
            }
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