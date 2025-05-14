package com.example.wasteposal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class signup extends AppCompatActivity {
    private TextView alreadyHaveAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.signup);

        // Fix window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Spinner: City
        Spinner spinnerCity = findViewById(R.id.spinnerCity);
        ArrayAdapter<CharSequence> adapterCity = ArrayAdapter.createFromResource(
                this,
                R.array.city_array,
                android.R.layout.simple_spinner_item
        );
        adapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(adapterCity);

        // Spinner: Barangay
        Spinner spinnerBarangay = findViewById(R.id.spinnerBarangay);
        ArrayAdapter<CharSequence> adapterBarangay = ArrayAdapter.createFromResource(
                this,
                R.array.barangay_array,
                android.R.layout.simple_spinner_item
        );
        adapterBarangay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBarangay.setAdapter(adapterBarangay);

        // Already have an account link
        alreadyHaveAccount = findViewById(R.id.alreadyHaveAccount);
        alreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this, login.class);
                startActivity(intent);
            }
        });
    }
}
