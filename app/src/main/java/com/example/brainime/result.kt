package com.example.brainime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.brainime.databinding.ActivityResultBinding

class result : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN


        val usurname = intent.getStringExtra(SetData.name)
        val score = intent.getStringExtra(SetData.score)
        val totalSize = intent.getStringExtra("total question")

        binding.congo.text="Congratulations ${usurname} !!"
        binding.Score.text="${score} / 5"
        binding.button.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}