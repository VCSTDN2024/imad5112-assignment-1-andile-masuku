 package vcmsa.ci.lunasspecialdeluxemealapp
/*URL=http://www.youtube.com/@cadekin
* kincade's generation app
* kincade's calculator app
* www.youtube.com/@LEARNINGLIFE
* How to create a new activity | New Screen In Android Studio by learning life's
* if statement in kotlin android studio from google
* How to Make a Button Open a New Activity | Android App Development ForTutorial by learning life's*/
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.handleCoroutineException

import kotlin.system.exitProcess
class Mainscreen : AppCompatActivity() {
// unknown variables for the input and output text
    // input = EditText /n output = TextText
    private var timeText : EditText? = null
    private var outputText : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mainscreen)

        //input your UI element
        timeText = findViewById(R.id.timeText)
        outputText = findViewById(R.id.outputText)

        // constant buttons ... identifying them by finding them by Id
        val clearBtn = findViewById<Button>(R.id.clearBtn)
        val exitBtn = findViewById<Button>(R.id.exitBtn)
        val genBtn = findViewById<Button>(R.id.genBtn)


        clearBtn.setOnClickListener{       // function for the clear button
            timeText?.text?.clear()        // clear function
            outputText?.text = ""           // output when the button does its function

            exitBtn.setOnClickListener {         // function for the exit button
                moveTaskToBack(true)
                android.os.Process.killProcess(android.os.Process.myPid())
                exitProcess(1)
            }
               genBtn.setOnClickListener{      // function for the generate button
                   handletimeGenerate()              // to link the button to its function
               }

        }

    }
    private fun handletimeGenerate() {      // declaring the component into a function

        // declaring the Variables
        val times = timeText?.text.toString().trim().uppercase() // constant value does not change
        var mealSuggestions = "" // the outcome can change anytime because the variable is not constant

        // times to be input in the edit
        // midnight snack for Midnight
        // breakfast for EarlyMorning
        // morning snack for Mid-Morning
        // lunchtime for Afternoon
        // afternoon snack for Mid-Afternoon
        // teatime for Evening
        // dinner for Night


        if(times =="midnight snack"){
            mealSuggestions == "Oatmeal, Choco Chip Cookies, Avocado Toast, Popcorn,Fudge "
        }
        if(times == "breakfast"){
            mealSuggestions == "Oatmeal,French Toast with Coffee, Waffles/Pancakes, Egg Muffins"
        }
        if (times == "morning snack"){
            mealSuggestions == "Yogurt with Berries, Fruit Salad, Whole Wheat Crackers, Jungle Oats Energy Bar"
        }
        if(times == "lunchtime"){
            mealSuggestions == "Crispy Ramen, Grilled Chicken Mayo sandwich, Shawarma, Tofu/Chicken Nugget"
        }
        if(times == "afternoon snack"){
            mealSuggestions == "Fruit Slashie, Carrot Dips, Zucchini Chips, Choc Chip Yogurt, Apple Pie"
        }
        if (times == "teatime"){
            mealSuggestions == "Scones with Tea, Cinnamon Babka/Buns, Swiss Roll, Espresso Cake"
        }
        if (times == "dinner"){
            mealSuggestions =="Shrimp Pasta, Butter Chickpeas, Bunny Chow, Italian Meatloaf"
        }
        else{ // what outcome is expected if none of the above is been input

            mealSuggestions = "Time Does not Exist??? Please Input Correct Time" // if nothing listed above appears


            outputText?.text = mealSuggestions      // show the meal suggestions


        }
        }
    }

