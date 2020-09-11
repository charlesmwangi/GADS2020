package com.example.gads2020.Activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.gads2020.Interface.GadsEndpoint
import com.example.gads2020.R
import com.example.gads2020.Retrofit.SubmitProjectService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubmitProject : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit_project)
        supportActionBar?.hide(); //hide the title bar
        val firstName: EditText = findViewById(R.id.firstName)
        val secondName: EditText = findViewById(R.id.secondName)
        val email: EditText = findViewById(R.id.email)
        val projectLink: EditText = findViewById(R.id.githubLink)
        val submitButton: Button = findViewById(R.id.submit_button)
        submitButton.setOnClickListener {
            if (firstName.text.isEmpty() ||
                secondName.text.isEmpty() ||
                email.text.isEmpty() ||
                projectLink.text.isEmpty()
            ) {
                Toast.makeText(this, getString(R.string.empty_fields), Toast.LENGTH_SHORT).show()

            } else {
                // build alert dialog
                val dialogBuilder = AlertDialog.Builder(this)
                // set message of alert dialog
                dialogBuilder.setMessage(getString(R.string.confirm_submission))
                    // if the dialog is cancelable
                    .setCancelable(true)
                    // positive button text and action
                    .setPositiveButton("Yes") { dialog, id ->
                        executeSubmitProject(
                            firstName.text.toString(),
                            secondName.text.toString(),
                            email.text.toString(),
                            projectLink.text.toString()
                        )
                    }
                // create dialog box
                val alert = dialogBuilder.create()
                // show alert dialog
                alert.show()
            }
        }
        val back: ImageButton = findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun executeSubmitProject(
        firstName: String,
        secondName: String,
        email: String,
        projectLink: String
    ) {
        val request = SubmitProjectService.buildService(GadsEndpoint::class.java)
        val post = request.submitProject(firstName, secondName, email, projectLink)
        post.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val alertDialog = AlertDialog.Builder(this@SubmitProject)
                val factory = LayoutInflater.from(this@SubmitProject)
                val view: View = factory.inflate(R.layout.alert_dialog, null)
                val image: ImageView = view.findViewById(R.id.dialog_imageview)
                image.setImageResource(R.drawable.ic_check_circle_black_24dp)
                val textView: TextView = view.findViewById(R.id.dialog_textView)
                textView.text = getString(R.string.success)
                alertDialog.setView(view)
                alertDialog.show()
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                val alertDialog = AlertDialog.Builder(this@SubmitProject)
                val factory = LayoutInflater.from(this@SubmitProject)
                val view: View = factory.inflate(R.layout.alert_dialog, null)
                val image: ImageView = view.findViewById(R.id.dialog_imageview)
                image.setImageResource(R.drawable.ic_warning_black_24dp)
                val textView: TextView = view.findViewById(R.id.dialog_textView)
                textView.text = getString(R.string.fail)
                alertDialog.setView(view)
                alertDialog.show()
            }

        })
    }
}
