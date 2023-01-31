package jp.ac.it_college.std.s21016.themedresearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import jp.ac.it_college.std.s21016.themedresearch.databinding.FragmentInitialSettingBinding

class InitialSettingFragment: Fragment() {
    private var _binding: FragmentInitialSettingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInitialSettingBinding.inflate(inflater, container, false)

        binding.btNext.setOnClickListener {
            Navigation.findNavController(it).navigate(
                InitialSettingFragmentDirections.actionInitialSettingFragmentToMainFragment()
            )
        }
        return binding.root

    }
}