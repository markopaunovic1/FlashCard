package com.example.flashcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var wordView : TextView
    val wordDeck = WordPairDeck()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wordView = findViewById(R.id.wordTextView)

        wordView.setOnClickListener() {
            revealTranslation()
        }
        showNewWord()
    }

    fun showNewWord() {
      val  word = wordDeck.getNewWord()
        wordView.text = word.english
    }


    fun revealTranslation() {
        val word = wordDeck.currentWord
        wordView.text = word.swedish


    }



    override fun onTouchEvent(event: MotionEvent?): Boolean {

        if (event?.action == MotionEvent.ACTION_UP) {
            showNewWord()
        }
        return true
    }

}