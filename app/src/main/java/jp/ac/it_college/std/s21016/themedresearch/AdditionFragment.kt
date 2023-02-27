package jp.ac.it_college.std.s21016.themedresearch

import android.content.ContentValues
import android.database.Cursor
import android.icu.text.Transliterator.Position
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.CursorAdapter
import android.widget.SimpleCursorAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.navigation.Navigation
import jp.ac.it_college.std.s21016.themedresearch.databinding.FragmentAdditionBinding

class AdditionFragment : Fragment() {
    private var _binding: FragmentAdditionBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.setFragmentResultListener(
            "Hoge",
            viewLifecycleOwner
        ) { request, result ->
            if (request == "Hoge") {
                val hoge = result.getInt("hoge")
                val hogepiyo = result.getInt("hogepiyo")
                val hogehoge = result.getInt("hogehoge")
                binding.showDate.setText(
                    getString(
                        R.string.date_format,
                        hoge, hogepiyo, hogehoge
                    )
                )
            }
        }
        binding.showDate.setOnClickListener {
            Navigation.findNavController(it).navigate(
                AdditionFragmentDirections.actionAdditionFragmentToMyDialogFragment()
            )
        }
        val helper = SimpleDatabaseHelper(requireContext())

        binding.btAddition.setOnClickListener {
            helper.writableDatabase.let { db ->
                val cv = ContentValues().apply {
                    put("date", binding.showDate.text.toString())
                    //spinner からとってきた値をany型からcursor型に変えて渡している
                    //any -> cursor? -> cursor
                    val citem: Cursor? = binding.spinner2.adapter.getItem(binding.spinner2.selectedItemPosition) as Cursor?
                    with(citem!!) {
                        val expense_item_id = getInt(0)
                        put("expense_item_id",expense_item_id.toString())
                    }
                put("Deposit_amount", binding.showDate5.text.toString())
            }
            db.insert("Household_account_book", null, cv)
            Toast.makeText(
                requireContext(), "データの登録に成功しました。",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}


override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    _binding = FragmentAdditionBinding.inflate(inflater, container, false)

    val helper = SimpleDatabaseHelper(requireContext())
    val sql = "SELECT Item_id as _id, Item_name FROM Item_information"
    val cursor = helper.readableDatabase.rawQuery(sql, null)


    // spinner に adapter をセット
    // View Binding
    binding.spinner2.adapter = SimpleCursorAdapter(
        requireContext(),
        android.R.layout.simple_spinner_dropdown_item,
        cursor,
        arrayOf("Item_name"),
        intArrayOf(android.R.id.text1),
        CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
    )

    // リスナーを登録
    binding.spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        //　アイテムが選択された時
        override fun onItemSelected(
            parent: AdapterView<*>?,
            view: View?, position: Int, id: Long
        ) {
            val spinnerParent = parent as Spinner
            //val item = spinnerParent.selectedItem as String
            // View Binding
            // binding.spinner.text = item
        }

        //　アイテムが選択されなかった
        override fun onNothingSelected(parent: AdapterView<*>?) {
            //
        }
    }

    return binding.root
}
}