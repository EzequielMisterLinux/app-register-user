package com.example.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

class Inicio : AppCompatActivity() {
    private lateinit var txtNombre: EditText
    private lateinit var txtEdad: EditText
    private lateinit var txtContrasenia: EditText
    private lateinit var btnEnviar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_inicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtNombre = findViewById(R.id.txtNombre)
        txtEdad = findViewById(R.id.txtEdad)
        txtContrasenia = findViewById(R.id.txtContrasenia)
        btnEnviar = findViewById(R.id.btnEnviar)

        btnEnviar.setOnClickListener {
            envio()
        }
    }

    private fun envio() {
        val user = txtNombre.text.toString()
        val edad = txtEdad.text.toString()
        val contra = txtContrasenia.text.toString()

        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("user", user)
        intent.putExtra("age", edad)
        intent.putExtra("pass", contra)
        startActivity(intent)
    }
}