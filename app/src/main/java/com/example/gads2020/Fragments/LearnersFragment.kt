package com.example.gads2020.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gads2020.Adapter.RecyclerAdapter
import com.example.gads2020.Dao.LearningLeaders
import com.example.gads2020.Interface.GadsEndpoint
import com.example.gads2020.R
import com.example.gads2020.Retrofit.ServiceBuilder
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class LearnersFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_learners_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val request = ServiceBuilder.buildService(GadsEndpoint::class.java)
        val call = request.gethours()
        call.enqueue(object : Callback<List<LearningLeaders>> {
            override fun onResponse(
                call: Call<List<LearningLeaders>>,
                response: Response<List<LearningLeaders>>
            ) {
                if (response.body() != null) {
                    recyclerView = view.findViewById(R.id.recyclerview) as RecyclerView
                    recyclerAdapter = RecyclerAdapter(response.body()!!)
                    recyclerView.layoutManager = LinearLayoutManager(activity)
                    recyclerView.adapter = recyclerAdapter
                    recyclerAdapter.setLeadersListItems(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<LearningLeaders>>, t: Throwable) {
                Toast.makeText(activity, "${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }

    companion object {
        fun newInstance(): LearnersFragment = LearnersFragment()
    }
}
