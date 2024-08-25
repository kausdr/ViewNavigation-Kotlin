package myapp.TwoActivitiesAndroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val userName = intent.getStringExtra("USER_NAME")
        val name = findViewById<TextView>(R.id.userName)

        if (userName != null) {
            name.text = userName
        }

        val password = findViewById<TextView>(R.id.userPassword)

        val login = findViewById<Button>(R.id.loginButton)

        val createAccount = findViewById<Button>(R.id.createAccountButton)

        var canLogin = false

        login.setOnClickListener {
            if ((name.text.toString() != null ) && (password.text.toString() != null)) {
                canLogin = true
            }

            if (canLogin) {
                Toast.makeText(this, "BOAS VINDAS ${name.text.toString()}", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this, "CREDENCIAIS INCORRETAS", Toast.LENGTH_SHORT).show()
            }

        }

        createAccount.setOnClickListener {
            val intent = Intent(this, CreateUser::class.java)
            startActivity(intent)
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}