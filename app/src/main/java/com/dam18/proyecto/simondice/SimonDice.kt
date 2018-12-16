package com.dam18.proyecto.simondice

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.proyecto_simon_dice.*
import org.jetbrains.anko.toast
import java.util.*

class SimonDice : AppCompatActivity() {

    var numero:Int = 2
    var lista = ArrayList<String>()
    var probarSec:ArrayList<String> = ArrayList()
    var arrayList:ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.proyecto_simon_dice)
        Probar.setVisibility(View.INVISIBLE)

        Empezar.setOnClickListener {
            lista = crearSecuencia()
        }
        Probar.setOnClickListener {
            comprobarSecuencia()
        }

        Rojo.setOnClickListener {
            Rojo.setBackgroundColor(Color.parseColor("#FFEB5959"))
            Handler().postDelayed({
                Rojo.setBackgroundColor(Color.parseColor("#ce0e0e"))
            }, 300)
            probarSec.add("Rojo")
            Probar.setVisibility(View.VISIBLE)
        }
        Verde.setOnClickListener {
            Verde.setBackgroundColor(Color.parseColor("#FFBAEC77"))
            Handler().postDelayed({
                Verde.setBackgroundColor(Color.parseColor("#70bb0c"))
            }, 300)
            probarSec.add("Verde")
            Probar.setVisibility(View.VISIBLE)
        }
        Amarillo.setOnClickListener {
            Amarillo.setBackgroundColor(Color.parseColor("#E3F6EF94"))
            Handler().postDelayed({
                Amarillo.setBackgroundColor(Color.parseColor("#E3D5C700"))
            }, 300)
            probarSec.add("Amarillo")
            Probar.setVisibility(View.VISIBLE)
        }
        Azul.setOnClickListener {
            Azul.setBackgroundColor(Color.parseColor("#FF76C5EC"))
            Handler().postDelayed({
                Azul.setBackgroundColor(Color.parseColor("#158bc6"))
            }, 300)
            probarSec.add("Azul")
            Probar.setVisibility(View.VISIBLE)
        }

    }
    fun crearSecuencia():ArrayList<String>{

        deshabilitarBotones()
        var boton = ""
        var delayed: Long = 0;

            for (i in 0..numero) {

                delayed+=2000
                Handler().postDelayed({
                val random = Random().nextInt(4)
                when (random) {
                    0 -> boton = "Azul"
                    1 -> boton = "Amarillo"
                    2 -> boton = "Verde"
                    3 -> boton = "Rojo"
                }

                    if (boton.equals("Azul")) {
                        Azul.setBackgroundColor(Color.parseColor("#FF76C5EC"))
                        arrayList.add("Azul")
                        Handler().postDelayed({
                            Azul.setBackgroundColor(Color.parseColor("#158bc6"))
                        }, 1000)
                    }
                    if (boton.equals("Amarillo")) {
                        Amarillo.setBackgroundColor(Color.parseColor("#E3F6EF94"))
                        arrayList.add("Amarillo")
                        Handler().postDelayed({
                            Amarillo.setBackgroundColor(Color.parseColor("#E3D5C700"))
                        }, 1000)
                    }
                    if (boton.equals("Verde")) {
                        Verde.setBackgroundColor(Color.parseColor("#FFBAEC77"))
                        arrayList.add("Verde")
                         Handler().postDelayed({
                            Verde.setBackgroundColor(Color.parseColor("#70bb0c"))
                        }, 1000)
                    }
                    if (boton.equals("Rojo")) {
                        Rojo.setBackgroundColor(Color.parseColor("#FFEB5959"))
                        arrayList.add("Rojo")
                        Handler().postDelayed({
                            Rojo.setBackgroundColor(Color.parseColor("#ce0e0e"))
                        }, 1000)
                    }
                }, delayed)
            }
             numero ++
            habilitarBotones()
             return arrayList
    }


fun comprobarSecuencia(){

    if(probarSec.equals(lista)){
        toast("ACERTASTE!")
        crearSecuencia()
    }else{
        toast("Perdiste!Vuelve a empezar")
        numero = 2
        Empezar.setVisibility(View.VISIBLE)
        Empezar.isClickable = true
    }
    probarSec.clear()
    lista.clear()
    }
    fun deshabilitarBotones() {
        Rojo.isClickable = false
        Azul.isClickable = false
        Amarillo.isClickable = false
        Verde.isClickable = false
        Empezar.isClickable = false
        Probar.isClickable = false
        Empezar.setVisibility(View.INVISIBLE)
    }
    fun habilitarBotones() {
        Rojo.isClickable = true
        Azul.isClickable = true
        Amarillo.isClickable = true
        Verde.isClickable = true
        Probar.isClickable = true
    }
}

