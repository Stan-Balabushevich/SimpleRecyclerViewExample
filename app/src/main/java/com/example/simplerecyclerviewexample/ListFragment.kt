package com.example.simplerecyclerviewexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.simplerecyclerviewexample.databinding.ListFragmentBinding

class ListFragment: Fragment() {

    private var binding: ListFragmentBinding? = null
    private lateinit var testList: List<ListItem>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListFragmentBinding.inflate(inflater, container,false)

        loadList()

        val adapter = MyListAdapter(testList){
            adapterOnClick(it)
        }

        if (binding != null){
            binding!!.recyclerList.adapter = adapter
        }

        return binding?.root
    }

    private fun loadList() {
        testList = listOf(
            ListItem("dgjhdrjtye"),
            ListItem("dgjhdrjtye"),
            ListItem("dgjhdrjtye"),
            ListItem("dgjhdrjtye"),
            ListItem("dgjhdrjtye"),
            ListItem("dgjhdrjtye"),)
    }

    private fun adapterOnClick(listItem: ListItem){
        this.findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(listItem))
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}