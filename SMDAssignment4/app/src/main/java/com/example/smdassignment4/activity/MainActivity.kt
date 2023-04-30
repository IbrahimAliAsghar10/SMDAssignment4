package com.example.smdassignment4.activity

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smdassignment4.R
import com.example.smdassignment4.adapter.CategoryAdapter
import com.example.smdassignment4.adapter.PopularAdapter
import com.example.smdassignment4.api.API
import com.example.smdassignment4.api.ApiInterface
import com.example.smdassignment4.model.ApiResponse
import com.example.smdassignment4.model.Category
import com.example.smdassignment4.model.Popular
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val api = API();
    private var apiService: ApiInterface?=null
    private var categoryAdapter: CategoryAdapter?=null
    private var popularAdapter: PopularAdapter?=null
    private var categories:MutableList<Category> = ArrayList()
    private var populars:MutableList<Popular> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiService = api.getClient();

        val categoryListRecyclerView:RecyclerView= findViewById<RecyclerView>(R.id.catlist)
        categoryListRecyclerView!!.layoutManager = LinearLayoutManager(this)
        categoryAdapter = CategoryAdapter(this, categories, R.layout.category)
        categoryListRecyclerView.adapter = categoryAdapter

        val popularListRecyclerView:RecyclerView= findViewById<RecyclerView>(R.id.popularlist)
        categoryListRecyclerView!!.layoutManager = LinearLayoutManager(this)
        popularAdapter = PopularAdapter(this, populars, R.layout.popular)
        popularListRecyclerView.adapter = popularAdapter
        val call = apiService!!.getCategoriesAndPopularsList();
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                Log.d(ContentValues.TAG, "Total Categories: " + response.body()!!.categoryData.size)
                Log.d(ContentValues.TAG, "Total Populars: " + response.body()!!.popularData.size)
                val response = response.body()
                if (response != null) {
                    categories.addAll(response.categoryData!!)
                    categoryAdapter!!.notifyDataSetChanged()

                    populars.addAll(response.popularData!!)
                    popularAdapter!!.notifyDataSetChanged()
                }

            }
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e(ContentValues.TAG, "Got error : " + t.localizedMessage)

            }
        });
    }
}