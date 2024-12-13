package com.example.memeshare

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    private lateinit var memeImageView: ImageView

    var currentImageURL: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        memeImageView = findViewById(R.id.memeimage)
        loadMeme()
    }

    private fun loadMeme() {
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.com/gimme"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                try {
                    val imageUrl = response.getString("url")
                    currentImageURL = imageUrl
                    Log.d("MainActivity", "Meme URL: $imageUrl")
                    Glide.with(this).load(imageUrl).into(memeImageView)
                } catch (e: Exception) {
                    Log.e("MainActivity", "Error parsing JSON response", e)
                    Toast.makeText(this, "Error parsing JSON response", Toast.LENGTH_LONG).show()
                }
            },
            { error ->
                Log.e("MainActivity", "Error fetching meme", error)
                Toast.makeText(this, "Error fetching meme", Toast.LENGTH_LONG).show()
            }
        )

        queue.add(jsonObjectRequest)
    }

    fun nextMeme(view: View) {
        loadMeme()
    }

    fun shareMeme(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, "Hey, check out this cool meme: $currentImageURL")
        // Create a chooser for the sharing intent
        val chooser = Intent.createChooser(intent, "Share this meme using...")
        // Start the activity with the chooser intent
        startActivity(chooser)
    }
}
