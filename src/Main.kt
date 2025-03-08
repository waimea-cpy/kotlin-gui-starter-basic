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
    private lateinit var nameText: JTextField

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
        contentPane.preferredSize = Dimension(600, 500)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val defaultFont = Font(Font.SANS_SERIF, Font.PLAIN, 36)

        greetingLabel = JLabel("Click a button...")
        greetingLabel.horizontalAlignment = SwingConstants.CENTER
        greetingLabel.bounds = Rectangle(50, 50, 500, 100)
        greetingLabel.font = defaultFont
        add(greetingLabel)

        nameText = JTextField()
        nameText.bounds = Rectangle(50,200,500,100)
        nameText.font = defaultFont
        nameText.addActionListener(this)
        nameText.addKeyListener(this)
        add(nameText)

        helloButton = JButton("Hello!")
        helloButton.bounds = Rectangle(50,350,225,100)
        helloButton.font = defaultFont
        helloButton.addActionListener(this)
        add(helloButton)

        goodbyeButton = JButton("Goodbye!")
        goodbyeButton.bounds = Rectangle(325,350,225,100)
        goodbyeButton.font = defaultFont
        goodbyeButton.addActionListener(this)
        add(goodbyeButton)
    }


    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {

            nameText -> {
                println("Name text changed!")
            }

            helloButton -> {
                println("Hello Button Pressed")
                var name = "stranger"
                if (nameText.text.isNotBlank()) name = nameText.text
                greetingLabel.text = "Hello there, $name!"
                greetingLabel.foreground = Color.GREEN
            }

            goodbyeButton -> {
                println("Goodbye Button Pressed")
                var name = "stranger"
                if (nameText.text.isNotBlank()) name = nameText.text
                greetingLabel.text = "Goodbye, $name!"
                greetingLabel.foreground = Color.RED
            }
        }
    }

    /**
     * Handle characters typed
     */
    override fun keyTyped(e: KeyEvent?) {
        println("Key TYPED: ${e?.keyChar}")

        if (e?.keyCode in KeyEvent.VK_A .. KeyEvent.VK_Z) {
            println("Letter key!")
        }
    }

    /**
     * Handle key down events
     */
    override fun keyPressed(e: KeyEvent?) {
        println("Key PRESSED: ${e?.keyCode}")

        if (e?.keyCode in KeyEvent.VK_A .. KeyEvent.VK_Z) {
            println("Letter key!")
        }
    }

    /**
     * Handle key releases
     */
    override fun keyReleased(e: KeyEvent?) {
        println("Key RELEASED: ${e?.keyCode}")
    }
}

