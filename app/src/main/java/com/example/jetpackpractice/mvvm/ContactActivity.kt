package com.example.jetpackpractice.mvvm

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpackpractice.R
import com.example.jetpackpractice.databinding.ActivityContactBinding
import com.example.jetpackpractice.mvvm.room.Contact

class ContactActivity : AppCompatActivity() {

    private val contactViewModel : ContactViewModel by viewModels{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>): T =
                ContactViewModel(application) as T
        }
    }

    private lateinit var binding: ActivityContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_contact)

        val aContactAdapter = ContactAdapter({ contact ->
            val intent = Intent(this, AddActivity::class.java)
            intent.putExtra(AddActivity.EXTRA_CONTACT_NAME, contact.name)
            intent.putExtra(AddActivity.EXTRA_CONTACT_NUMBER, contact.number)
            intent.putExtra(AddActivity.EXTRA_CONTACT_ID, contact.id)
            startActivity(intent)
        }, { contact ->
            deleteDialog(contact)
        })

        val layoutManger = LinearLayoutManager(this)
        binding.mainRecyclerview.adapter = aContactAdapter
        binding.mainRecyclerview.layoutManager = layoutManger
        binding.mainRecyclerview.setHasFixedSize(true)

        binding.mainButton.setOnClickListener {
            startActivity(Intent(this,AddActivity::class.java))
        }

        contactViewModel.getAll().observe(this, { contacts ->
            aContactAdapter.setContacts(contacts!!)
        })
    }

    private fun deleteDialog(contact: Contact) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Delete selected contact?")
            .setNegativeButton("NO") { _, _ -> }
            .setPositiveButton("YES") { _, _ ->
                contactViewModel.delete(contact)
            }
        builder.show()
    }
}
