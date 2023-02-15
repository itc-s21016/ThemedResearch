package jp.ac.it_college.std.s21016.themedresearch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.Navigation
import jp.ac.it_college.std.s21016.themedresearch.databinding.FragmentSearchBinding

class SearchFragment:Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    //val dbHelper = SimpleDatabaseHelper(context)

    //val db = dbHelper.readableDatabase

    val spinnerItems = arrayOf(
        "hoge",
        "hogepiyo",
        "hogehogepudding"
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.setFragmentResultListener(
            "Hoge",
            viewLifecycleOwner
        ){ request, result ->
            if (request == "Hoge") {
                val hoge = result.getInt("hoge")
                val hogepiyo = result.getInt("hogepiyo")
                val hogehoge = result.getInt("hogehoge")
                binding.showDate.setText(getString(
                    R.string.date_format,
                    hoge, hogepiyo, hogehoge
                ))
            }
        }
        binding.showDate.setOnClickListener {
            Navigation.findNavController(it).navigate(
                SearchFragmentDirections.actionSearchFragmentToMyDialogFragment()
            )
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        // ArrayAdapter
        val adapter = ArrayAdapter(requireContext(),
            android.R.layout.simple_spinner_item, spinnerItems)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // spinner に adapter をセット
        // View Binding
        binding.spinner.adapter = adapter

        // リスナーを登録
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //　アイテムが選択された時
            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
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