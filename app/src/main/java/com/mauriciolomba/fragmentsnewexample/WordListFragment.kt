package com.mauriciolomba.fragmentsnewexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mauriciolomba.fragmentsnewexample.databinding.FragmentLetterListBinding
import com.mauriciolomba.fragmentsnewexample.databinding.FragmentWordListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WordListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WordListFragment : Fragment() {
    companion object{
        val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    private val args : WordListFragmentArgs by navArgs() //pega os argumentos automaticamente
    private lateinit var binding : FragmentWordListBinding
    private lateinit var letterId : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        letterId = args.letter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWordListBinding.inflate(inflater, container,false)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = WordAdapter(letterId, requireContext())

        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(context,DividerItemDecoration.VERTICAL)
        )

        return binding.root
    }

}