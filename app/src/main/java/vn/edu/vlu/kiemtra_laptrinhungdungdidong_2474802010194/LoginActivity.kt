package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2474802010194

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class LoginActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Ánh xạ bằng findViewById (không dùng ViewBinding)
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvStatus = findViewById(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString()

            when {
                email.isEmpty() ->
                    tvStatus.text = "Lỗi: Email không được để trống!"
                password.isEmpty() ->
                    tvStatus.text = "Lỗi: Mật khẩu không được để trống!"
                !Patterns.EMAIL_ADDRESS.matcher(email).matches() ->
                    tvStatus.text = "Lỗi: Email không đúng định dạng!"
                password.length < 6 ->
                    tvStatus.text = "Lỗi: Mật khẩu phải có ít nhất 6 ký tự!"
                else -> {
                    tvStatus.text = "Validation Successful!"
                    val intent = Intent(this@LoginActivity, ProfileActivity::class.java)
                    intent.putExtra("EXTRA_EMAIL", email)
                    startActivity(intent)
                }
            }
        }
    }
}