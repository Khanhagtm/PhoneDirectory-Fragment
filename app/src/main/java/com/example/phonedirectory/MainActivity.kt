package com.example.phonedirectory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity() : AppCompatActivity(), OnClickItem {
    lateinit var fragment: ListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment = ListFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView2, fragment, "MainFragment")
            .addToBackStack("MainFragment")
            .commit()

    }

    override fun ItemClicked(contact: Contacts) {
        val detailFragment: DetailFragment = DetailFragment()
        val bundle = Bundle().apply {
            putString("name", contact.name)
            putString("ID", contact.ID)
            putString("phone", contact.phone)
            putString("email", contact.email)
        }
        detailFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView2, detailFragment, "DetailContactFragment")
            .addToBackStack("DetailContactFragment")
            .commit()

    }


    override fun ButtonClicked() {
        val addContactFragment: AddContactFragment = AddContactFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView2, addContactFragment, "AddContactFragment")
            .addToBackStack("AddContactFragment")
            .commit()
    }

    override fun OnCliCkAddContact(contacts: Contacts) {
        val fragmentManager = supportFragmentManager
        fragmentManager.popBackStack()
        this.fragment.UpdateContent(contacts)
    }


}