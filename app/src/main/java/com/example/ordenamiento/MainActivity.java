package com.example.ordenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tvTitulo;
    TextView tvInstrucciones;
    EditText etInsert;
    ImageView btnNext;
    TextView tvVeinte;
    TextView tvOrdenados;
    ImageView btnReset;

    public int contador=20;

    public static List<Integer> numeros = new ArrayList<>();
    public static List ordenados = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitulo = findViewById(R.id.tvTitulo);
        tvInstrucciones = findViewById(R.id.tvInstrucciones);
        etInsert = findViewById(R.id.etNumero);
        btnNext = findViewById(R.id.btnNext);
        tvVeinte = findViewById(R.id.tvVeinte);
        tvOrdenados = findViewById(R.id.tvOrdenados);
        btnReset = findViewById(R.id.btnReset);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = etInsert.getText().toString();
                if (number.equals("")){
                    etInsert.setError(getResources().getString(R.string.error));
                }else {
                    int number1 = Integer.parseInt(etInsert.getText().toString());
                    numeros.add(number1);
                    etInsert.setText("");
                    contador -= 1;
                    Toast.makeText(MainActivity.this, "" + numeros, Toast.LENGTH_LONG).show();
                    if (contador == 0) {
                       BubbleSort();
                       tvOrdenados.setText(""+ordenados);
                       contador=20;
                       numeros = new ArrayList<>();
                       ordenados = new ArrayList();
                    }
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador=20;
                numeros = new ArrayList<>();
                ordenados = new ArrayList();
                Toast.makeText(MainActivity.this,getResources().getString(R.string.reset1), Toast.LENGTH_LONG).show();
            }
        });
    }

    //El algoritmo de ordenamiento elegido es BubbleSort
    public void BubbleSort() {
        Integer[] array = new Integer[numeros.size()];
        numeros.toArray(array);

        int min;

        for (int i = 0; i < array.length - 1; i++){
            min = i;
            for (int  j = i + 1; j < array.length; j++){
                if (array[j] < array[min]){
                    min = j;
                }
            }
            if (i != min){
                int tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
            }
        }
        ordenados = Arrays.asList(array);
        //Toast.makeText(MainActivity.this, "" + ordenados, Toast.LENGTH_LONG).show();
    }

}
