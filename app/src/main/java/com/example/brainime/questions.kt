package com.example.brainime

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.brainime.databinding.ActivityMainBinding
import com.example.brainime.databinding.ActivityQuestionsBinding
class questions : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionsBinding

    private var Name:String?=null
    private var score:Int=0

    private var currentPosition:Int=1
    private var questionList:ArrayList<QuestionData>?=null
    private var selectOption:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Name = intent.getStringExtra(SetData.name)

        questionList = SetData.getQuestion()
        getQuestion()

        binding.opt1.setOnClickListener {

            selectedOptionStyle(binding.opt1, 1)
        }
        binding.opt2.setOnClickListener {

            selectedOptionStyle(binding.opt2, 2)
        }
        binding.opt3.setOnClickListener {

            selectedOptionStyle(binding.opt3, 3)
        }
        binding.opt4.setOnClickListener {

            selectedOptionStyle(binding.opt4, 4)
        }

        binding.submit.setOnClickListener{

            if(selectOption!=0){
                val question = questionList!![currentPosition-1]
                if(selectOption!=question.ans){
                    setColor(selectOption,R.drawable.wrong_question_option)
                }
                else{
                    score++
                }
                setColor(question.ans,R.drawable.correct_question_option)
                if (currentPosition==questionList!!.size)
                    binding.submit.text= "Finish"
                else
                    binding.submit.text= "Go to Next"
            }
            else{
                currentPosition++
                when{
                    currentPosition<=questionList!!.size->{
                        getQuestion()
                    }
                    else->{
                        var intent = Intent(this,result::class.java)
                        intent.putExtra(SetData.name,Name.toString())
                        intent.putExtra(SetData.score,score.toString())
                        intent.putExtra("total questions",questionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }
            selectOption=0
        }



    }

    fun setColor(opt:Int,color:Int){
        when(opt){
            1->{
                binding.opt1.background=ContextCompat.getDrawable(this,color)
            }
            2->{
                binding.opt2.background=ContextCompat.getDrawable(this,color)
            }
            3->{
                binding.opt3.background=ContextCompat.getDrawable(this,color)
            }
            4->{
                binding.opt4.background=ContextCompat.getDrawable(this,color)
            }
        }
    }

    fun getQuestion(){
        val question = questionList!![currentPosition-1]
        setOptionStyle()

        binding.progressBar.progress=currentPosition
        binding.progressBar.max=questionList!!.size
        binding.progressText.text="${currentPosition}"+"/"+"${questionList!!.size}"
        binding.quesText.text=question.question
        binding.opt1.text=question.option_one
        binding.opt2.text=question.option_two
        binding.opt3.text=question.option_three
        binding.opt4.text=question.option_four

    }

    fun setOptionStyle(){
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,binding.opt1)
        optionList.add(1,binding.opt2)
        optionList.add(2,binding.opt3)
        optionList.add(3,binding.opt4)

        for(op in optionList){
            op.setTextColor(Color.parseColor("#555151"))
            op.background= ContextCompat.getDrawable(this,R.drawable.question_option)
            op.typeface = Typeface.DEFAULT
        }
    }

    fun selectedOptionStyle(view: TextView,opt:Int){
        setOptionStyle()
        selectOption=opt
        view.background = ContextCompat.getDrawable(this,R.drawable.selector_question_option)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }
}