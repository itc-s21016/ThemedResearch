package jp.ac.it_college.std.s21016.themedresearch

import android.content.Context
import android.view.View
import android.widget.AdapterView

class ListItemClickListener(context: Context) : AdapterView.OnItemClickListener {

    val mycnt = context

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        val helper = SimpleDatabaseHelper(mycnt)
        val sql = "SELECT * FROM Household_account_book"
        val cursor = helper.readableDatabase.rawQuery(sql, null)
        cursor.use {
            while (it.moveToNext()) {
                with(it) {
                    val date = getString(0)
                    val expense_item_id = getString(1)
                    val Deposit_amount = getString(2)
                    val Withdrawal_amount = getString(3)
                    var result = "date: $date, expense_item_id: $expense_item_id, Deposit_amount: $Deposit_amount, Withdrawal_amount: $Withdrawal_amount"
                }
            }
        }
    }

}