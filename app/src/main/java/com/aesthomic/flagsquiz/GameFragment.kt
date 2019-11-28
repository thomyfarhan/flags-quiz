package com.aesthomic.flagsquiz


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.aesthomic.flagsquiz.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding
    private lateinit var questions: MutableList<Question>
    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_game, container, false)

        binding.game = this

        shuffleQuestions()

        return binding.root
    }

    private fun shuffleQuestions() {
        questions = mutableListOf()
        questions.addAll(QuestionData.listQuestion)

        questions.shuffle()
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        binding.ivGameImage.setImageResource(resources.getIdentifier(currentQuestion.image,
            "drawable",requireActivity().packageName))

        answers = currentQuestion.answer.toMutableList()
        answers.shuffle()
    }
}
