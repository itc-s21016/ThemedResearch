package jp.ac.it_college.std.s21016.themedresearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import jp.ac.it_college.std.s21016.themedresearch.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ヘルパーを準備
        val helper = SimpleDatabaseHelper(this)

        //データベースを取得   ※useを使うとclosedになったため使わないほうが良い
        /*helper.writableDatabase.use { db ->
            Toast.makeText(this, "接続しました",
            Toast.LENGTH_SHORT).show()
        }*/

        //ヘルパーでデータベースを呼び出した後に何かしら使えば取得できた
        helper.writableDatabase.let { db ->
            Toast.makeText(
                this, "接続しました",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}