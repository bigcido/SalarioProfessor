/*
@author - Alvaro Dias
RA - 1110482223004
 */
package br.edu.fateczl.salarioprofessor;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText Nome;
    private EditText Matricula;
    private EditText Idade;
    private EditText AnosInstituicao;  // Para professor titular
    private EditText HorasAula;  // Para professor horista
    private EditText ValorHoraAula;  // Para professor horista
    private Spinner spnProfessor;
    private TextView txtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nome = findViewById(R.id.Nome);
        Matricula = findViewById(R.id.Matricula);
        Idade = findViewById(R.id.Idade);
        AnosInstituicao = findViewById(R.id.AnoInstituicao);
        HorasAula = findViewById(R.id.HorasAula);
        ValorHoraAula = findViewById(R.id.ValorHoraAula);
        spnProfessor = findViewById(R.id.spnProfessor);
        txtRes = findViewById(R.id.txtRes);

        Button btnCalc = findViewById(R.id.btnCalc);
        preencherSpinner();

        spnProfessor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tipoProfessor = spnProfessor.getSelectedItem().toString();
                if (tipoProfessor.equals("Professor Titular")) {

                    AnosInstituicao.setVisibility(View.VISIBLE);
                    HorasAula.setVisibility(View.GONE);
                    ValorHoraAula.setVisibility(View.GONE);
                } else if (tipoProfessor.equals("Professor Horista")) {

                    AnosInstituicao.setVisibility(View.GONE);
                    HorasAula.setVisibility(View.VISIBLE);
                    ValorHoraAula.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnCalc.setOnClickListener(op -> calc());
    }

    private void calc() {
        String nomeProfessor = Nome.getText().toString();
        String matriculaProfessor = Matricula.getText().toString();
        int idadeProfessor = Integer.parseInt(Idade.getText().toString());
        String tipoProfessor = spnProfessor.getSelectedItem().toString();


        if (tipoProfessor.equals("Professor Titular")) {
            int anos = Integer.parseInt(AnosInstituicao.getText().toString());
            double salarioBase = 5000;  // Exemplo de salário base
            double salarioFinal = salarioBase * (1 + (anos / 5) * 0.05);  // Incremento de 5% a cada 5 anos
            txtRes.setText(String.format("Salário do %s (Titular): R$ %.2f", nomeProfessor, salarioFinal));

        } else if (tipoProfessor.equals("Professor Horista")) {
            int horas = Integer.parseInt(HorasAula.getText().toString());
            double valorHora = Double.parseDouble(ValorHoraAula.getText().toString());
            double salarioFinal = horas * valorHora;
            txtRes.setText(String.format("Salário do %s (Horista): R$ %.2f", nomeProfessor, salarioFinal));
        }
    }

    private void preencherSpinner() {
        String[] opc = {"Professor Titular", "Professor Horista"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opc);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnProfessor.setAdapter(adapter);  // Vincula o adapter ao spinner
    }
}
