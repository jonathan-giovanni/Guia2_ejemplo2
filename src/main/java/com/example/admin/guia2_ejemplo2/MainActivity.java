package com.example.admin.guia2_ejemplo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView lblTexto;
    Button btnProceso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializar
        lblTexto = findViewById(R.id.lblTexto);
        btnProceso = findViewById(R.id.btnProceso);

        btnProceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador();
            }
        });
    }


    private void contador(){
        new Hilo(this,lblTexto,btnProceso).execute(10,500);
    }
}
