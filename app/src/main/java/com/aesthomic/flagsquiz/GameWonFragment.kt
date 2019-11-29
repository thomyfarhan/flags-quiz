package com.aesthomic.flagsquiz


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.aesthomic.flagsquiz.databinding.FragmentGameWonBinding

class GameWonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGameWonBinding>(inflater,
            R.layout.fragment_game_won, container, false)

        setHasOptionsMenu(true)

        binding.btnGameWonPlay.setOnClickListener { view:View ->
            view.findNavController().navigate(GameWonFragmentDirections.actionGameWonFragmentToGameFragment())
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_winner, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}
