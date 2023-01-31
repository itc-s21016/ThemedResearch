package jp.ac.it_college.std.s21016.themedresearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import jp.ac.it_college.std.s21016.themedresearch.databinding.FragmentMainBinding

class MainFragment: Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.btSearch.setOnClickListener {
            Navigation.findNavController(it).navigate(
                MainFragmentDirections.actionMainFragmentToSearchFragment()
            )
        }
        binding.btEdit.setOnClickListener {
            Navigation.findNavController(it).navigate(
                MainFragmentDirections.actionMainFragmentToEdditFragment()
            )
        }
        binding.btAddition.setOnClickListener {
            Navigation.findNavController(it).navigate(
                MainFragmentDirections.actionMainFragmentToAdditionFragment()
            )
        }
        binding.btConfiguration.setOnClickListener {
            Navigation.findNavController(it).navigate(
                MainFragmentDirections.actionMainFragmentToOptionFragment()
            )
        }

        return binding.root
    }
}