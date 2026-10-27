package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2474802010194

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Ánh xạ bằng findViewById
        tvEmail = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)

        // Nhận email do LoginActivity gửi sang
        val email = intent.getStringExtra("EXTRA_EMAIL") ?: ""
        tvEmail.text = "Email: $email"

        // Đăng xuất: đóng màn hình hiện tại, quay lại LoginActivity
        btnLogout.setOnClickListener {
            finish()
        }
    }
}