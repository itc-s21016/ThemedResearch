package jp.ac.it_college.std.s21016.themedresearch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.ac.it_college.std.s21016.themedresearch.databinding.FragmentAdditionBinding
import jp.ac.it_college.std.s21016.themedresearch.databinding.FragmentMainBinding

class AdditionFragment : Fragment() {
    private var _binding: FragmentAdditionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAdditionBinding.inflate(inflater, container, false)

        //途中
        binding

        return binding.root
    }
}