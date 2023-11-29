package com.example.phonedirectory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment: Fragment() {
    lateinit var recyclerView: RecyclerView
    var listData: ArrayList<Contacts> = dataList()
    lateinit var myAdapter: ContactAdapter
    lateinit var addContact: ImageButton
    private lateinit var onClickItem: OnClickItem
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.content_main, container, false)

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.onClickItem = activity as OnClickItem
        addContact = view.findViewById<ImageButton>(R.id.addContact)
        recyclerView = view.findViewById(R.id.recyclerView)
        //listData = dataList()
        myAdapter = ContactAdapter(listData, view.context)
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(
            view.context,
            LinearLayoutManager.VERTICAL,
            false
        )
        this.addContact.setOnClickListener{
            onClickItem.ButtonClicked()
        }
        this.myAdapter.setOnClickListener(
            object :
                ContactAdapter.OnClickListener {
                override fun onClick(position: Int, model: Contacts) {
                    onClickItem.ItemClicked(model)
                }
            }
        )
    }


    fun UpdateContent(item: Contacts) {
        this.listData.add(item)
        this.myAdapter.notifyItemInserted(listData.size -1 )
    }
    fun dataList() : ArrayList<Contacts>{
        var list: ArrayList<Contacts> = ArrayList<Contacts>()
        list.add(Contacts("David Beckham", "0123456", "Beckham@gmail.com", "0912345678"))
        list.add(Contacts("Cristiano Ronaldo", "9876543", "Ronaldo@gmail.com", "0987654321"))
        list.add(Contacts("Lozanro Martines", "1122334", "Martines@gmail.com", "0909090909"))
        list.add(Contacts("Khahim Benzema", "4455667", "Benzema@gmail.com", "0876543210"))
        list.add(Contacts("Thomas Muller", "7788990", "Thomas@gmail.com", "0912345678"))
        list.add(Contacts("Lional Messi", "3344556", "Lional@gmail.com", "0923456789"))
        list.add(Contacts("Macus Rasfort", "6677889", "Macus@gmail.com", "0911111111"))
        list.add(Contacts("Ronaldo Delima", "1122334", "Ronaldo@gmail.com", "0944444444"))
        list.add(Contacts("Oliver Gildur", "5566778", "Oliver@gmail.com", "0966666666"))
        list.add(Contacts("Harry Kane", "8899001", "Harry@gmail.com", "0988888888"))
        return list
    }
}