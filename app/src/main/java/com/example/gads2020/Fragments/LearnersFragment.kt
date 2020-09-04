package com.example.gads2020.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.gads2020.Dao.LearningLeaders
import com.example.gads2020.Interface.GadsEndpoint
import com.example.gads2020.R
import com.example.gads2020.Retrofit.ServiceBuilder
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LearnersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LearnersFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val request = ServiceBuilder.buildService(GadsEndpoint::class.java)
        val call = request.gethours()

        call.enqueue(object : Callback<List<LearningLeaders>>{
            override fun onResponse(call: Call<List<LearningLeaders>>, response: Response<List<LearningLeaders>>) {
                if (response.isSuccessful) {
                    response
                   val listview = inflater.inflate(R.layout.fragment_learners, container, false)
                    val name = listview.findViewById<TextView>(R.id.nameTextView)
//                    recyclerAdapter = LeadersAdapter(activity)
//                    recyclerView.adapter = recyclerAdapter
////                    recyclerView.apply {
////                        setHasFixedSize(true)
////                        layoutManager = LinearLayoutManager(this@MainActivity)
//
                // val  adapter = LeadersAdapter(response.body()!!.)
                }
            }


            override fun onFailure(call: Call<List<LearningLeaders>>, t: Throwable) {
                Toast.makeText(activity, "${t.message}", Toast.LENGTH_LONG).show()
            }
        })
        // Inflate the layout for this fragment
        return view


    }

}
