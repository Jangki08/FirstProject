package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int jumlah = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtHW = findViewById(R.id.tv_hw);
        final TextView txtNama = findViewById(R.id.tv_nama);
        final TextView txtAlamat = findViewById(R.id.tv_alamat);
        Button btnMove = findViewById(R.id.btn_pindah);

        txtHW.setText("Selamat Datang");
        txtNama.setText("Ujang");
        txtAlamat.setText("Bandung");

        txtNama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Anda menekan tulisan"+txtNama.getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        txtAlamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Anda menekan tulisan alamat",
                        Toast.LENGTH_SHORT).show();
            }
        });

        txtHW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumlah++;
                Toast.makeText(MainActivity.this, "Anda menekan sebanyak " + jumlah + " Kali",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //intent @ perpindahan activity dan membantu memindah data
                Intent intent = new Intent(MainActivity.this, ActivityKedua.class);
                intent.putExtra("nama_key", txtNama.getText());
                intent.putExtra("alamat_key",txtAlamat.getText());
                startActivity(intent); //jika di close hanya kembali
//                finish(); //jika di tekan maka langsung pindah ke halaman kedua & di close maka akan keluar
//                onDestroy(); // jika di tekan maka gelap dlu baru pindah halaman kedua & di close akan keluar
            }
        });
    }
}