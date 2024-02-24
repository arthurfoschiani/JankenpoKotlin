package com.caiosilva.jankenpo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.caiosilva.jankenpo.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val options: List<String> = listOf("Papel", "Pedra", "Tesoura")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.imageViewPapel.setOnClickListener {
//            Toast.makeText(this, "Clicou no ${options[0]}", Toast.LENGTH_LONG).show()
            onOptionSelected(0)
        }

        binding.imageViewPedra.setOnClickListener {
//            Toast.makeText(this, "Clicou na ${options[1]}", Toast.LENGTH_LONG).show()
            onOptionSelected(1)
        }

        binding.imageViewTesoura.setOnClickListener {
//            Toast.makeText(this, "Clicou no ${options[2]}", Toast.LENGTH_LONG).show()
            onOptionSelected(2)
        }
    }

    private fun onOptionSelected(choice: Int) {
        val computerChoice: Int = Random.nextInt(3)

        val results = arrayOf(
            arrayOf(R.string.result_draw, R.string.result_app_loses, R.string.result_app_wins),
            arrayOf(R.string.result_app_wins, R.string.result_draw, R.string.result_app_loses),
            arrayOf(R.string.result_app_loses, R.string.result_app_wins, R.string.result_draw)
        )

        val images = arrayOf(R.drawable.papel, R.drawable.pedra, R.drawable.tesoura)

        binding.imageViewPadrao.setImageDrawable(getDrawable(images[computerChoice]))
        binding.resultTextView.text = getString(results[computerChoice][choice], options[computerChoice])
    }
}
