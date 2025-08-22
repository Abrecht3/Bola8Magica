package com.albrecht3.bola8magica

import android.app.Dialog
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.albrecht3.bola8magica.databinding.ActivityMainBinding
import com.albrecht3.bola8magica.databinding.DialogPredictionBinding
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val predicciones=listOf<String>(
        "Como lo veo … Si",
        "Es Seguro",
        "Decididamente Si",
        "Sin Lugar a Dudas",
        "Positivamente",
        "Parece ser que Si",
        "Es lo mas Probable",
        "Si",
        "Puedes Confiar en eso",
        "Definitivamente",
        "No esttoy segura … Intenta de Nuevo",
        "Mejor Preguntame Despues",
        "Mejor no te Digo",
        "No puedo Predecirlo ahora",
        "Concentrate y vuelve a preguntar",
        "No cuentes con ello",
        "Mi respuesta es no",
        "Mis fuentes dicen que no",
        "No parece que pase",
        "lo dudo mucho",
        "No",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        magicBall8()
    }

    private fun magicBall8() {
        binding.apply {
            btnBola8.setOnClickListener {
                if (etPregunta.text.isNotEmpty()) {
                    it.animate().rotationBy(1800f).setDuration(1000).start()
                    showDialogCustom()
                    closeKeyboard()
                }

            }
        }
    }

    private fun closeKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.main.windowToken,0)
    }

    private fun predictions(): String {
        val respuesta = predicciones.random()
        return respuesta
    }

    private fun showDialog(){
        val message = predictions()
        AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton("Regresar") { _, _ ->
                resetText()
            }.setCancelable(false).show()
    }
    private fun showDialogCustom(){
        val dialog = Dialog(this)
        val dialogBinding = DialogPredictionBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)
        dialog.setCancelable(false)

        dialogBinding.tvResponse.text = predictions()
        dialogBinding.btnClose.setOnClickListener {
            dialog.hide()
            resetText()
        }

        dialog.show()
    }

    private fun resetText() {
        binding.etPregunta.setText("")
    }

}
