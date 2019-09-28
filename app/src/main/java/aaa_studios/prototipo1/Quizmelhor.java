package aaa_studios.prototipo1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class Quizmelhor extends Activity {

    private question aquestion = new question();
    private String resposta;
    private int scores = 0;
    private int questionlength = aquestion.iPerguntas.length;

Random r;

    private Button botao01,botao02,botao03,botao04;
    private TextView pergunta, pontos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizmelhor);

        r = new Random();



        botao01 = (Button) findViewById(R.id.altenativa1id);
        botao02 = (Button) findViewById(R.id.altenativa2id);
        botao03 = (Button) findViewById(R.id.altenativa3id);
        botao04 = (Button) findViewById(R.id.altenativa4id);
        pergunta = (TextView) findViewById(R.id.pergunta1);
        pontos = (TextView) findViewById(R.id.Pontosid);

        pontos.setText("Pontos: "+scores);

        updatepergunta(r.nextInt(questionlength));


        botao01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(botao01.getText() == resposta){
                  scores ++;
                  pontos.setText("Pontos: "+scores);
                  updatepergunta(r.nextInt(questionlength));
              }
                else{
                  game_over();
              }
            }
        });

        botao02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(botao02.getText() == resposta){
                    scores ++;
                    pontos.setText("Pontos: "+scores);
                    updatepergunta(r.nextInt(questionlength));
                }
                else{
                    game_over();
                }
            }
        });
        botao03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(botao03.getText() == resposta){
                    scores ++;
                    pontos.setText("Pontos: "+scores);
                    updatepergunta(r.nextInt(questionlength));
                }
                else{
                    game_over();
                }
            }
        });
        botao04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(botao04.getText() == resposta){
                    scores ++;
                    pontos.setText("Pontos: "+scores);
                    updatepergunta(r.nextInt(questionlength));
                }
                else{
                    game_over();
                }
            }
        });


    }
    private void updatepergunta(int num){
     pergunta.setText(aquestion.getpergunta(num));
     botao01.setText(aquestion.escolha1(num));
        botao02.setText(aquestion.escolha2(num));
        botao03.setText(aquestion.escolha3(num));
        botao04.setText(aquestion.escolha4(num));

        resposta = aquestion.getcorreta(num);

    }

    public void game_over(){
        AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(Quizmelhor.this);
        alertdialogbuilder
                .setMessage("ERROUU!!! seu ponto é "+ scores + " Pontos")
        .setCancelable(false)
        .setPositiveButton("Novo jogo",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(),Quizmelhor.class));
                    }
                })
                .setNegativeButton("Voltar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            }
                        });
AlertDialog alertDialog = alertdialogbuilder.create();
        alertDialog.show();


    }

    public class question{

        String iPerguntas[] ={
            "Qual é o maior?","Quem é o menor?","O que é mais letal?","O que faz cosegas?","O primeiro planeta é?"
        };

    private String iescolhas[][]={
            {"Cavalo","Baleia","Elefante","Monte Everest"},
            {"nano","micho","picho","pikachu"},
            {"Faca","Ak47","HarryPotter","WillyWonka"},
            {"Pena","Gordo","Obeso","mordida na orelha"},
            {"Thanos","Mercurio","Sua mae","gordo em obito"}


    };
        private String acerto[] = {"Monte Everest","nano","Ak47","Pena","Mercurio"};

     String getpergunta(int a){

       String pergunta = iPerguntas[a];
     return pergunta;
     }
 String escolha1(int a){
     String escolha = iescolhas[a][0];
     return escolha;
 }
        String escolha2(int a){
            String escolha = iescolhas[a][1];
            return escolha;
        }
        String escolha3(int a){
            String escolha = iescolhas[a][2];
            return escolha;
        }
        String escolha4(int a){
            String escolha = iescolhas[a][3];
            return escolha;
        }
        String getcorreta(int a){
            String correta = acerto[a];
            return correta;
        }
    }
}

