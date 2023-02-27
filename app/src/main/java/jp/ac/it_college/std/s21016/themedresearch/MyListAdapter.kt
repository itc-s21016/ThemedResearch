package jp.ac.it_college.std.s21016.themedresearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.ac.it_college.std.s21016.themedresearch.databinding.TableBinding

class MyListAdapter(private val data: List<ListItem>):
RecyclerView.Adapter<MyViewHolder>(){

    // ビューホルダーを作成
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(TableBinding.inflate(inflater, parent, false))
    }

    // ビューにデータを割り当て、リスト項目を生成
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.date.text = data[position].date // p206
        holder.binding.ExpenseItem.text = data[position].ExpenseItem
        holder.binding.AmountOfMoney.text = data[position].AmountOfMoney
        holder.binding.income.text = data[position].income
        //holder.Balance.text = data[position].Balance
    }

    // データの項目数を取得
    override fun getItemCount(): Int {
        return data.size
    }
}