package com.mehedi.androidflexbox

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        
        // Generate some sample data
        val items = generateTextItems()
        
        // Set up the RecyclerView
        val layoutManager = FlexboxLayoutManager(this).apply {
            flexDirection = FlexDirection.ROW
            flexWrap = FlexWrap.WRAP
            justifyContent = JustifyContent.FLEX_START
            
        }
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = TextAdapter(items)
    }
    
    // Function to generate list items with random text length and color
    private fun generateTextItems(): List<TextItem> {
        val items = mutableListOf<TextItem>()
        
        val baseWords = listOf(
            "Alpha",
            "Beta",
            "Gamma",
            "Delta",
            "Echo",
            "Foxtrot",
            "Golf",
            "Hotel",
            "India",
            "Juliet",
            "Kilo",
            "Lima",
            "Mike",
            "November",
            "Oscar",
            "Papa",
            "Quebec",
            "Romeo",
            "Sierra",
            "Tango",
            "Uniform",
            "Victor",
            "Whiskey",
            "X-ray",
            "Yankee",
            "Zulu",
            "Air",
            "Ball",
            "Cat",
            "Dog",
            "Egg",
            "Fish",
            "Green",
            "Hat",
            "Ice",
            "Jam",
            "Key",
            "Lamp",
            "Moon",
            "Night",
            "Orange",
            "Pen",
            "Queen",
            "Red",
            "Sun",
            "Tree",
            "Umbrella",
            "Van",
            "Water",
            "Xylophone",
            "Hey",
            "No",
            "Awesome",
            "Nice",
            "Great"
        )
        
        
        val sampleTexts = mutableListOf<String>()
        // Generate 1000 single words by repeating and randomizing the baseWords
        for (i in 1..1000) {
            sampleTexts.add(baseWords.random())  // Randomly pick from baseWords
        }
        
        
        
        
        sampleTexts.forEach { text ->
            // Randomly assign a color to each text item
            val color = getRandomColor()
            items.add(TextItem(text, color))
        }
        return items
    }
    
    // Function to generate random colors
    private fun getRandomColor(): Int {
        return Color.argb(
            255,
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
    }
}
