// app/src/main/java/com.example.radio/MainActivity.kt
package com.example.radio // Asegúrate que coincida con tu paquete

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button // Ejemplo de botón
import androidx.appcompat.app.AppCompatActivity
// Importa otras clases necesarias como RecyclerView, tu Adapter, etc.

class MainActivity : AppCompatActivity() {

    // Ejemplo: Supongamos que tienes un botón para una emisora
    private lateinit var playStationButton: Button
    private lateinit var pauseStationButton: Button // Podría ser el mismo botón que cambia de estado

    // Datos de ejemplo para una emisora
    private val sampleStationUrl = "URL_REAL_DEL_STREAM_DE_RADIO" // ¡REEMPLAZA ESTO!
    private val sampleStationName = "Mi Emisora Favorita"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Asume que tienes este layout

        // Inicializa tus vistas (RecyclerView, botones, etc.)
        // playStationButton = findViewById(R.id.playButton) // Reemplaza con tu ID real
        // pauseStationButton = findViewById(R.id.pauseButton)

        // Configura los listeners para los botones
        // playStationButton.setOnClickListener {
        //     startRadioService(sampleStationUrl, sampleStationName)
        // }

        // pauseStationButton.setOnClickListener {
        //     pauseRadioInService(sampleStationName) // O podrías tener un solo botón
        // }

        // Aquí inicializarías tu RecyclerView con la lista de emisoras
    }

    private fun startRadioService(streamUrl: String, stationName: String) {
        val serviceIntent = Intent(this, RadioPlayerService::class.java).apply {
            action = RadioPlayerService.ACTION_PLAY
            putExtra(RadioPlayerService.EXTRA_STREAM_URL, streamUrl)
            putExtra(RadioPlayerService.EXTRA_STATION_NAME, stationName)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(serviceIntent)
        } else {
            startService(serviceIntent)
        }
    }

    private fun pauseRadioInService(stationName: String) {
        val serviceIntent = Intent(this, RadioPlayerService::class.java).apply {
            action = RadioPlayerService.ACTION_PAUSE
            putExtra(RadioPlayerService.EXTRA_STATION_NAME, stationName)
        }
        startService(serviceIntent) // No necesitas startForegroundService para solo pausar si ya está en primer plano
    }

    private fun stopRadioService() {
        val serviceIntent = Intent(this, RadioPlayerService::class.java)
        stopService(serviceIntent)
    }

    // Podrías necesitar liberar recursos o detener el servicio en onDestroy
    override fun onDestroy() {
        super.onDestroy()
        // Si quieres que la radio se detenga al cerrar la app completamente (no solo en background)
        // stopRadioService() // Descomenta si este es el comportamiento deseado
    }
}
