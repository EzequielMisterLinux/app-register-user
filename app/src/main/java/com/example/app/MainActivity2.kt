package com.example.app

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private lateinit var btnRevelar: Button
    private lateinit var lbMensaje: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnRevelar = findViewById(R.id.btnRevelar)
        lbMensaje = findViewById(R.id.lbMensaje)

        btnRevelar.setOnClickListener {
            val nombre = intent.getStringExtra("user")
            val edad = intent.getStringExtra("age")
            val contrasenia = intent.getStringExtra("pass")

            val mensaje = "Hola que tal $nombre dicen que tienes $edad años de edad y que tu contraseña es $contrasenia"
            lbMensaje.text = mensaje
        }
    }
}