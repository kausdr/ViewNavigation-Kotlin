package myapp.TwoActivitiesAndroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CreateUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_user)


        val name = findViewById<TextView>(R.id.userCreateName)
        val password = findViewById<TextView>(R.id.userCreatePassword)

        val passwordConfirmation = findViewById<TextView>(R.id.userCreatePasswordConfirmation)

        val saveAccount = findViewById<Button>(R.id.saveButton)
        val cancel = findViewById<Button>(R.id.cancelCreationButton)

        var canSave = false

        saveAccount.setOnClickListener {
            if (password.text.toString() == passwordConfirmation.text.toString()) {
                canSave = true
            }

            if (canSave) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("USER_NAME", name.text.toString())
                startActivity(intent)

            } else {
                Toast.makeText(this, "AS SENHAS NÃO COINCIDEM", Toast.LENGTH_SHORT).show()
            }

        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}