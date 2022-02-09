package com.marianunez.marvelapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marianunez.marvelapp.databinding.FragmentCharacterListBinding
import com.marianunez.marvelapp.ui.adapter.CharacterListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterListFragment : Fragment() {

    private var _binding: FragmentCharacterListBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    private val viewModel: CharacterListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI(){

        recyclerView = binding.characterList
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = CharacterListAdapter()

        viewModel.getCharactersList()

        viewModel.characterList.observe(viewLifecycleOwner) { list ->
                 (recyclerView.adapter as CharacterListAdapter).setData(list)
        }

    }

}