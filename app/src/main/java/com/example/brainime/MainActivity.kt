package com.example.brainime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.brainime.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(binding.root)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        binding.button.setOnClickListener {
            if(binding.input.text.toString().isEmpty()){
                Toast.makeText(this,"Enter your name",Toast.LENGTH_SHORT).show()
            }
            else{
                intent = Intent(this,questions::class.java)
                intent.putExtra("${SetData.name}",binding.input.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}