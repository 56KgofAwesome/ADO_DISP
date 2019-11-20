package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Ticket extends AppCompatActivity implements View.OnClickListener{
    Integer precioBoleto,counter,subTotal,total;
    String destino,origen,horarioSalida="",horarioRegreso="";
    Boolean roundtrip;
    LinearLayout layoutRegreso;

    Button payButton, printButton;
    TextView originTV, destinyTV,horarioSalidaTV,horarioRegresoTV,counterTV,subTotalTV,totalTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        //------------------------------------------------------------
        //DATOS RECIBIDOS
        Bundle datosRecibidos = new Bundle();
        datosRecibidos = getIntent().getExtras();

        precioBoleto = datosRecibidos.getInt("precioBoleto");
        roundtrip = datosRecibidos.getBoolean("roundtrip");
        origen = datosRecibidos.getString("origen");
        destino = datosRecibidos.getString("destino");
        horarioSalida = datosRecibidos.getString("horarioSalida");
        horarioRegreso = datosRecibidos.getString("horarioRegreso");
        counter = datosRecibidos.getInt("counter");
        //---------------------------------------------------------------
        payButton = findViewById(R.id.payButton);
        printButton = findViewById(R.id.printButton);

        payButton.setOnClickListener(this);
        printButton.setOnClickListener(this);
        //TEXT VIEWS
        originTV = findViewById(R.id.originTV);
        destinyTV = findViewById(R.id.destinyTV);
        horarioSalidaTV = findViewById(R.id.horarioSalidaTV);
        horarioRegresoTV = findViewById(R.id.horarioRegresoTV);
        counterTV = findViewById(R.id.counterTV);
        subTotalTV = findViewById(R.id.subTotalTV);
        totalTV = findViewById(R.id.totalTV);
        layoutRegreso = findViewById(R.id.layoutRegreso);
        //------------------
        if(roundtrip.equals(true)){
            layoutRegreso.setVisibility(View.VISIBLE);
        }else{
            layoutRegreso.setVisibility(View.INVISIBLE);
        }

        this.total();

    }

    @Override
    public void onClick(View v) {
        if(printButton.isPressed()){
            originTV.setText(origen);
            destinyTV.setText(destino);
            horarioSalidaTV.setText(horarioSalida);
            //
            if(roundtrip.equals(true)){
                horarioRegresoTV.setText(horarioRegreso);
            }else{
                horarioRegresoTV.setText("---");
            }
            //
            counterTV.setText(counter.toString());
            subTotalTV.setText("$"+subTotal.toString()+" MXN");
            totalTV.setText("$"+total.toString()+ " MXN");
        }else{}
    }

    public void total(){
        subTotal = counter * precioBoleto;
        total = subTotal + ((subTotal * 16) / 100);
    }
}
