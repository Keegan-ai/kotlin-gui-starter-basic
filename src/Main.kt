/**
 * ===============================================================
 * Kotlin GUI Basic Starter
 * ===============================================================
 *
 * This is a starter project for a simple Kotlin GUI application.
 * The Java Swing library is used, plus the FlatLAF look-and-feel
 * for a reasonably modern look.
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    MainWindow()            // Create and show the UI
}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow : JFrame(), ActionListener, KeyListener {

    // Fields to hold the UI elements
    private lateinit var greetingLabel: JLabel
    private lateinit var helloButton: JButton
    private lateinit var goodbyeButton: JButton
    private lateinit var typeBox: JTextField

    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Demo"
        contentPane.preferredSize = Dimension(500, 350)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val defaultFont = Font(Font.SERIF, Font.PLAIN, 26)

        greetingLabel = JLabel("Hello, World!")
        greetingLabel.horizontalAlignment = SwingConstants.CENTER
        greetingLabel.bounds = Rectangle(50, 25, 500, 100)
        greetingLabel.font = defaultFont
        add(greetingLabel)

        typeBox = JTextField("")
        typeBox.bounds = Rectangle(50, 100, 500, 125)
        typeBox.font = defaultFont
        typeBox.addActionListener(this)
        typeBox.addKeyListener(this)// Handle any clicks
        add(typeBox)

        helloButton = JButton("Click Me!")
        helloButton.bounds = Rectangle(50,250,220,75)
        helloButton.foreground = Color.BLACK
        helloButton.background = Color(100,99,44)
        helloButton.font = defaultFont
        helloButton.addActionListener(this)     // Handle any clicks
        add(helloButton)

        goodbyeButton = JButton("Goodbye")
        goodbyeButton.bounds = Rectangle(300,250,225,75)
        goodbyeButton.foreground = Color.BLACK
        goodbyeButton.background = Color(100,99,44)
        goodbyeButton.font = defaultFont
        goodbyeButton.addActionListener(this)
        add(goodbyeButton)
    }


    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {
        var sName = if (typeBox.text.isBlank()) "Stranger" else typeBox.text

        when (e?.source) {
            typeBox -> {
                println("NAme text changed!!")
            }

                helloButton -> {
                println("Hello Button Pressed!!")
                greetingLabel.text = "Hello there,${sName}!"
                greetingLabel.foreground = Color.GREEN

            }
            goodbyeButton -> {
                println("Goodbye Button Pressed!!")
                greetingLabel.text = "Goodbye,${sName}!"
                greetingLabel.foreground = Color.RED

            }
        }
    }

    override fun keyTyped(e: KeyEvent?) {
        println("Key Typed: ${e?.keyChar}")
    }

    override fun keyPressed(e: KeyEvent?) {
        println("Key Pressed: ${e?.keyCode}")
        if (e?.keyCode in KeyEvent.VK_A..KeyEvent.VK_Z)
            println("Letter key")
        else {
            e?.consume()
        }

    }

    override fun keyReleased(e: KeyEvent?) {
        println("Key released: ${e?.keyCode} ")
    }

}

