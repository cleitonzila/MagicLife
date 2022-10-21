package com.example.magiclife

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var lifePlayer1 = 20
    private var lifePlayer2 = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT < 16) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        setContentView(R.layout.activity_main)

        val damageButtonPlayer1: Button = findViewById(R.id.damage1)
        val damageButtonPlayer2: Button = findViewById(R.id.damage2)
        val healButtonPlayer1: Button = findViewById(R.id.heal1)
        val healButtonPlayer2: Button = findViewById(R.id.heal2)
        val resetButton: ImageButton = findViewById(R.id.resetButton)

        damageButtonPlayer1.setOnClickListener { damagePlayer1() }
        damageButtonPlayer2.setOnClickListener { damagePlayer2() }
        healButtonPlayer1.setOnClickListener { healPlayer1() }
        healButtonPlayer2.setOnClickListener { healPlayer2() }
        resetButton.setOnClickListener { reset() }
        initialDisplay()

    }

    fun initialDisplay(){
        val life1: TextView = findViewById(R.id.life1)
        val life2: TextView = findViewById(R.id.life2)
        life1.text = lifePlayer1.toString()
        life2.text = lifePlayer2.toString()
    }

    fun reset(){
        lifePlayer1 = 20
        lifePlayer2 = 20
        val life1: TextView = findViewById(R.id.life1)
        val life2: TextView = findViewById(R.id.life2)
        life1.text = lifePlayer1.toString()
        life2.text = lifePlayer2.toString()
    }

    fun damagePlayer1(){
        lifePlayer1--
        val life1: TextView = findViewById(R.id.life1)
        life1.text = lifePlayer1.toString()
    }

    fun damagePlayer2(){
        lifePlayer2--
        val life2: TextView = findViewById(R.id.life2)
        life2.text = lifePlayer2.toString()
    }

    fun healPlayer1(){
        lifePlayer1++
        val life1: TextView = findViewById(R.id.life1)
        life1.text = lifePlayer1.toString()
    }

    fun healPlayer2(){
        lifePlayer2++
        val life2: TextView = findViewById(R.id.life2)
        life2.text = lifePlayer2.toString()
    }
}
