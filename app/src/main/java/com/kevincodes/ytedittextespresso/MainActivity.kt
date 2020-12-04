package com.kevincodes.ytedittextespresso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

/**
 * In this example, MainActivity contains an [TextInputEditText],
 * a [Button] and a [TextView].
 * When the button is clicked, the content of the TextView changes
 * to "Hello Espresso!".
 * */
class MainActivity : AppCompatActivity() {

    private lateinit var stringToBeTyped: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Specify a valid string.
        stringToBeTyped = "Hello Espresso!"

        val mTextToBeChanged = findViewById<TextView>(R.id.textToBeChanged)
        val mTextInput = findViewById<TextInputEditText>(R.id.textInput)
        val mClickMeButton = findViewById<Button>(R.id.clickMeButton)

        mClickMeButton.setOnClickListener {
            if (mTextInput.text.toString().isNotEmpty()) {
                if (mTextInput.text.toString() == stringToBeTyped) {
                    // The TextView will now change to mTextInput value
                    mTextToBeChanged.text = mTextInput.text.toString()
                    mTextInput.setText("")
                } else {
                    mTextInput.error = "Enter the text: Hello Espresso!"
                }
            } else {
                mTextInput.error = "This field should not be empty"
            }
        }

    }
}