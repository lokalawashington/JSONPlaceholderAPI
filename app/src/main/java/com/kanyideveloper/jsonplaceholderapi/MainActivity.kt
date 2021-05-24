package com.kanyideveloper.jsonplaceholderapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kanyideveloper.jsonplaceholderapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private  val TAG = "MainActivity"
    private val adapter by lazy { PhotosAdapter() }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        PhotosApi.retrofitService.getPhotos().enqueue(object: Callback<JsonPlaceholder>{
            override fun onResponse(call: Call<JsonPlaceholder>, response: Response<JsonPlaceholder>) {
                Log.d(TAG, "onResponse: ${response.body()}")

                //Submitting data to the adapter
                adapter.submitList(response.body())

                //Adding adapter to the recyclerview
                binding.recyclerview.adapter = adapter
            }

            override fun onFailure(call: Call<JsonPlaceholder>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })
    }
}