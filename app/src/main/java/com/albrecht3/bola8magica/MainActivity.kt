package com.albrecht3.bola8magica

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBola8.setOnClickListener(){
            it.animate().rotationBy(720F).setDuration(360).start()
            if(pregunta.text.isNotEmpty()){
                respuestas()
                closeKeyboard()
            }else{
                showAlert()
            }
        }
    }

    private fun closeKeyboard() {
        val view = this.currentFocus
        val imm: InputMethodManager =
            (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).also {
                if (view != null) {
                    it.hideSoftInputFromWindow(view.windowToken, 0)
                }
            }
    }

    private fun respuestas(){
        var respuesta = (0..20).random()
        when(respuesta){
            0 -> { txtResp.text = getString(R.string.a) }
            1 -> { txtResp.text = getString(R.string.b) }
            2 -> { txtResp.text = getString(R.string.c)}
            3 -> { txtResp.text = getString(R.string.d) }
            4 -> { txtResp.text = getString(R.string.e)}
            5 -> { txtResp.text = getString(R.string.f) }
            6 -> { txtResp.text = getString(R.string.g) }
            7 -> { txtResp.text = getString(R.string.h)}
            8 -> { txtResp.text = getString(R.string.i) }
            9 -> { txtResp.text = getString(R.string.j)}
            10 -> { txtResp.text = getString(R.string.k) }
            11 -> { txtResp.text = getString(R.string.l) }
            12 -> { txtResp.text = getString(R.string.m)}
            13 -> { txtResp.text = getString(R.string.n) }
            14 -> { txtResp.text = getString(R.string.o)}
            15 -> { txtResp.text = getString(R.string.p) }
            16 -> { txtResp.text = getString(R.string.q) }
            17 -> { txtResp.text = getString(R.string.r)}
            18 -> { txtResp.text = getString(R.string.s) }
            19 -> { txtResp.text = getString(R.string.t)}
            20 -> { txtResp.text = getString(R.string.u)}
        }
    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Debes ingresar una pregunta")
        builder.setPositiveButton("Aceptar",null)
        val dialog=builder.create()
        dialog.show()
    }

}


