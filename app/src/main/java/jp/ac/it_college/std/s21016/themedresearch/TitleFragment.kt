package jp.ac.it_college.std.s21016.themedresearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import jp.ac.it_college.std.s21016.themedresearch.databinding.FragmentTitleBinding
import java.io.File

class TitleFragment: Fragment() {
    private var _binding: FragmentTitleBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTitleBinding.inflate(inflater, container, false)

        val file = File(requireContext().filesDir, "sample.txt")

        binding.btStart.setOnClickListener {
            //existsが真偽値を返すのでそのままif文に組み込む
            if (file.exists()) {
                Navigation.findNavController(it).navigate(
                    TitleFragmentDirections.titleToMain()
                )
            }else {
                Navigation.findNavController(it).navigate(
                    TitleFragmentDirections.titleToInitial()
                )
            }
        }
        return binding.root
    }
}