package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
//            val resultTextView : TextView = findViewById(R.id.textView)
//            resultTextView.text ="6"
            rollDice()
        }
      rollDice()    // do  a dice roll  when app stars
    }

    // roll the dice and update screen with result
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

//        find img view in layut
        val diceImage :ImageView =findViewById(R.id.imageView)

//        determines which resource id to use
        when(diceRoll){
            1->diceImage.setImageResource(R.drawable.dice_1)
            2->diceImage.setImageResource(R.drawable.dice_2)
            3->diceImage.setImageResource(R.drawable.dice_3)
            4->diceImage.setImageResource(R.drawable.dice_4)
            5->diceImage.setImageResource(R.drawable.dice_5)
            6->diceImage.setImageResource(R.drawable.dice_6)
            }
        diceImage.contentDescription = diceRoll.toString()

    }
}
//create a dice and roll it random no give
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}