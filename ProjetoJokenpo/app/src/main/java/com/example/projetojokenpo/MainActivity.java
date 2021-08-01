package com.example.projetojokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void escolhaPedra(View view){
        this.escolhaUsuario("pedra");
    }

    public void escolhaPapel(View view){
        this.escolhaUsuario("papel");
    }

    public void escolhaTesoura(View view){
        this.escolhaUsuario("tesoura");
    }

    public void escolhaUsuario(String escolhaUsuario){

        int x = new Random().nextInt(3); // 0 1 2
        String[] escolha = {"pedra", "papel", "tesoura"};
        String jogadaApp = escolha[x];

        ImageView imageViewEscolhaApp = findViewById(R.id.imageViewEscolhaApp);
        TextView textResultado = findViewById(R.id.textResultado);

        switch (jogadaApp){

            case "pedra":
                imageViewEscolhaApp.setImageResource(R.drawable.stone);
                break;

            case "papel":
                imageViewEscolhaApp.setImageResource(R.drawable.paper);
                break;

            case "tesoura":
                imageViewEscolhaApp.setImageResource(R.drawable.cut);
                break;
        }

        if(
                (jogadaApp == "tesoura" && escolhaUsuario == "papel") ||
                (jogadaApp == "papel" && escolhaUsuario == "pedra") ||
                (jogadaApp == "pedra" && escolhaUsuario == "tesoura")
        ){ //App ganhador
            textResultado.setText("VOCÊ PERDEU!");
        }
        else if(
                (escolhaUsuario == "tesoura" && jogadaApp == "papel") ||
                (escolhaUsuario == "papel" && jogadaApp == "pedra") ||
                (escolhaUsuario == "pedra" && jogadaApp == "tesoura")
        ){  //Usuario ganhador
            textResultado.setText("VOCÊ GANHOU!");
        }
        else{ //empate
            textResultado.setText("EMPATE!");
        }

    }
}