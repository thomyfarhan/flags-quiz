package com.aesthomic.flagsquiz


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

        val args = GameWonFragmentArgs.fromBundle(arguments!!)
        Toast.makeText(context, "NumQuestions: ${args.numQuestions}, NumCorrect: ${args.numCorrect}", Toast.LENGTH_LONG).show()

        binding.btnGameWonPlay.setOnClickListener { view:View ->
            view.findNavController().navigate(GameWonFragmentDirections.actionGameWonFragmentToGameFragment())
        }

        return binding.root
    }
    
}
