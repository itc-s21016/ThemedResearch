package jp.ac.it_college.std.s21016.themedresearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import jp.ac.it_college.std.s21016.themedresearch.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        val db = SimpleDatabaseHelper(requireContext())
        val sql = "SELECT * FROM Household_account_book"
        val cursor = db.readableDatabase.rawQuery(sql, null)
        val result = mutableListOf<ListItem>()
        cursor.use {
            while (it.moveToNext()) {
                with(it) {
                    val date = getString(0)
                    val expense_item_id = getString(1)
                    val Deposit_amount = getString(2)
                    val Withdrawal_amount = getString(3)
                    result.add(ListItem( date, expense_item_id, Deposit_amount, Withdrawal_amount))
                    binding.recycler.setHasFixedSize(true)
                    binding.recycler.layoutManager = LinearLayoutManager(requireContext()).apply {
                        orientation = LinearLayoutManager.VERTICAL
                    }

                }
            }

            binding.recycler.adapter = MyListAdapter(result)
        }

        binding.btSearchMove.setOnClickListener {
            Navigation.findNavController(it).navigate(
                MainFragmentDirections.actionMainFragmentToSearchFragment()
            )
        }
        binding.btEditMove.setOnClickListener {
            Navigation.findNavController(it).navigate(
                MainFragmentDirections.actionMainFragmentToEdditFragment()
            )
        }
        binding.btAdditionMove.setOnClickListener {
            Navigation.findNavController(it).navigate(
                MainFragmentDirections.actionMainFragmentToAdditionFragment()
            )
        }
        binding.btConfigurationMove.setOnClickListener {
            Navigation.findNavController(it).navigate(
                MainFragmentDirections.actionMainFragmentToOptionFragment()
            )
        }

        return binding.root
    }
}