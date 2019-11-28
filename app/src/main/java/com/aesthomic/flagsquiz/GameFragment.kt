package com.aesthomic.flagsquiz


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.aesthomic.flagsquiz.databinding.FragmentGameBinding
import kotlin.math.min

class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding
    private lateinit var questions: MutableList<Question>
    private lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex: Int = 0
    private var numQuestions: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_game, container, false)

        binding.game = this

        shuffleQuestions()

        binding.btnGameSubmit.setOnClickListener { view: View ->
            val checkId = binding.rgGameAnswer.checkedRadioButtonId

            if (checkId != 1) {
                val answerIndex = when(checkId) {
                    R.id.rbGameFirstAnswer -> 0
                    R.id.rbGameSecondAnswer -> 1
                    else -> 2
                }

                if (answers[answerIndex] == currentQuestion.answer[0]) {
                    questionIndex++
                    if (questionIndex < numQuestions) {
                        setQuestion()
                        binding.invalidateAll()
                    } else {
                        view.findNavController().navigate(R.id.action_gameFragment_to_gameWonFragment)
                    }
                } else {
                    view.findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment)
                }
            }
        }

        return binding.root
    }

    private fun shuffleQuestions() {
        questions = mutableListOf()
        questions.addAll(QuestionData.listQuestion)
        numQuestions = min((questions.size+1)/2, 3)

        questions.shuffle()
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        binding.ivGameImage.setImageResource(resources.getIdentifier(currentQuestion.image,
            "drawable", (activity as AppCompatActivity).packageName))

        answers = currentQuestion.answer.toMutableList()
        answers.shuffle()

        (activity as AppCompatActivity).supportActionBar?.title = "Question ${questionIndex+1}/${numQuestions}"
    }
}
