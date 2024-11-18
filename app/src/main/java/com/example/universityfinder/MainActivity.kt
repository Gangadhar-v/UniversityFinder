package com.example.universityfinder

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.universityfinder.model.Universities
import com.example.universityfinder.model.University
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val viewModel: UniversityViewModel by viewModels()
    lateinit var edittext :EditText
    lateinit var btn:ImageButton
    lateinit var pgBar: ProgressBar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        edittext = findViewById(R.id.edittext)
        btn = findViewById(R.id.searchbtn)
        pgBar = findViewById(R.id.progressbar)

        btn.setOnClickListener {


            val country = edittext.text.toString()

            if (!country.isNullOrEmpty()) {
                pgBar.visibility = View.VISIBLE
                viewModel.fetchUniversities(country)


                viewModel.universities.observe(this) { universities ->
                    recyclerView.layoutManager = LinearLayoutManager(this)
                    recyclerView.adapter = UniversityAdapter(universities) { url ->
                        val intent = Intent(this, WebviewActivity::class.java)
                        intent.putExtra("url", url)
                        startActivity(intent)
                    }
                    pgBar.visibility = View.GONE
                }

            }else{

                edittext.error = "please fill the field"
                Toast.makeText(this@MainActivity,"Please enter the country name",Toast.LENGTH_SHORT).show()
            }
        }


    }
}