package jp.ac.it_college.std.s21016.themedresearch

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import java.util.*

class MyDialogFragment : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val cal = Calendar.getInstance()
        val dialog = requireActivity().let {
            DatePickerDialog(
                it, { view, year, monthOfYear, dayOfMonth ->
                    val bundle = bundleOf("hoge" to year, "hogepiyo" to  monthOfYear, "hogehoge" to dayOfMonth)
                    setFragmentResult("Hoge", bundle)
                   ("${year}/${monthOfYear + 1}/${dayOfMonth}")
                },
                cal[Calendar.YEAR],
                cal[Calendar.MONTH],
                cal[Calendar.DAY_OF_MONTH]
            )
        }
        return dialog
    }
}