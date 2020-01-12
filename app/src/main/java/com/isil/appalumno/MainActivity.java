package com.isil.appalumno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //delaracion
    TextView txtresultado;
    TextView txtnombre;
    TextView txtapellido;
    EditText n_1;
    EditText n_2;
    EditText n_3;
    DecimalFormat df=new DecimalFormat("0.00");
    String mensaje="",nom, apell,promedio,n_mayor;
    double n1,n2,n3,prom,mayor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //extraccion de datos por id

        txtnombre=findViewById(R.id.nombre);
        txtapellido=findViewById(R.id.apellido);
        n_1=findViewById(R.id.n1);
        n_2=findViewById(R.id.n2);
        n_3=findViewById(R.id.n3);
        txtresultado=findViewById(R.id.resultado);
    }

    public void calcular(View view) {
        // conversion a String
        if (!txtnombre.getText().toString().isEmpty())
            nom = txtnombre.getText().toString();
            if (!txtapellido.getText().toString().isEmpty())
                apell = txtapellido.getText().toString();
                if (!n_1.getText().toString().isEmpty())
                    n1 = Double.parseDouble(n_1.getText().toString());
                    if (!n_2.getText().toString().isEmpty())
                        n2 = Double.parseDouble(n_2.getText().toString());
                        if (!n_3.getText().toString().isEmpty())
                            n3 = Double.parseDouble(n_3.getText().toString());

        else{
            nom="----";
            apell="----";
            mensaje="(DATOS INCOMPLETOS)";
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();

        }

        if (!mensaje.isEmpty()){
            mayor = n1;
            if (n2 > mayor) {
                mayor = n2;
            }
            if (n3 > mayor) {
                mayor = n3;
            }
            prom = (n1 + n2 + n3) / 3;

            String msg = "PROMEDIO DE ALUMNO : " + "\n" +
                    "--------------------------------------" + "\n" +
                    "NOMBRE : " + nom + "\n" +
                    "--------------------------------------" + "\n" +
                    "APELLIDO : " + apell + "\n" +
                    "--------------------------------------" + "\n" +
                    "PROMEDIO : " + df.format(prom) + "\n" +
                    "--------------------------------------" + "\n" +
                    "MAYOR : " + mayor + "\n" +
                    "--------------------------------------";
            txtresultado.setText(mensaje+ "\n" +msg);

        }
    }

}

