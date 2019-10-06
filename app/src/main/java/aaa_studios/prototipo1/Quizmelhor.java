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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Quizmelhor extends Activity {

    private question aquestion = new question();
    private String resposta;
    private int scores = 0,contador = 0;
    private int questionlength = aquestion.iPerguntas.length;


Random r;

    private Button botao01,botao02,botao03,botao04;
    private TextView pergunta, pontos, quantquestao;
    final List<Integer> lista = Arrays.asList(0,1, 2, 3, 4,5,6,7,8);




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
        quantquestao = (TextView) findViewById(R.id.quantquestoesid);

        pontos.setText("Pontos: " + scores);
        quantquestao.setText("9/" + contador);

        Collections.shuffle(lista);






        updatepergunta(lista.get(0));



    botao01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (botao01.getText() == resposta) {
                    scores++;
                    contador++;
                    pontos.setText("Pontos: " + scores);
                    quantquestao.setText("9/" + contador);
                    game_acerto();


                } else {
                    contador++;
                    quantquestao.setText("9/" + contador);
                    game_erro();
                }
            }
        });

        botao02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(botao02.getText() == resposta){
                    scores ++;
                    contador++;
                    pontos.setText("Pontos: " + scores);
                    quantquestao.setText("9/" + contador);
                    game_acerto();


                } else {
                    contador++;
                    quantquestao.setText("9/" + contador);
                    game_erro();
                }
            }
        });
        botao03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(botao03.getText() == resposta){
                    scores ++;
                    contador++;
                    pontos.setText("Pontos: " + scores);
                    quantquestao.setText("9/" + contador);
                    game_acerto();


                } else {
                    contador++;
                    quantquestao.setText("9/" + contador);
                    game_erro();
                }
            }
        });
        botao04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(botao04.getText() == resposta){
                    scores ++;
                    contador++;
                    pontos.setText("Pontos: " + scores);
                    quantquestao.setText("9/" + contador);
                    game_acerto();


                } else {
                    contador++;
                    quantquestao.setText("9/" + contador);
                    game_erro();
                }
            }
        });}



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
                .setMessage("Sua pontuação é "+ scores + " Pontos")
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
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                        });
AlertDialog alertDialog = alertdialogbuilder.create();
        alertDialog.show();



    }
    public void game_acerto(){
AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(Quizmelhor.this);
        alertdialogbuilder.setMessage("Certa resposta -" + resposta);
        alertdialogbuilder.setTitle("Correto");
        alertdialogbuilder.setCancelable(false);
        alertdialogbuilder.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(contador == 9){game_over();}
                else{
                updatepergunta(lista.get(contador));
            }
            }
        });
AlertDialog alertdialog = alertdialogbuilder.create();
        alertdialog.show();
    }
    public void game_erro(){
        AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(Quizmelhor.this);
        alertdialogbuilder.setMessage("resposta errada");
        alertdialogbuilder.setCancelable(false);
        alertdialogbuilder.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(contador == 9){game_over();}
                else{
                    updatepergunta(lista.get(contador));
                }
            }
        });
        AlertDialog alertdialog = alertdialogbuilder.create();
        alertdialog.show();
    }

    public int selecionado(){
       /* int cont = 0;
        List<Integer> lista = new ArrayList();
        List<Integer> lis = new ArrayList();
        int tam = r.nextInt(aquestion.iPerguntas.length);
        while( cont < 5) {

             tam = r.nextInt(aquestion.iPerguntas.length);
            lis.add(tam);

            if(!lista.contains(tam)) {
                cont ++;
                lista.add(tam);
                }

            else{
                continue;
            }


        }*/
        /*List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Collections.shuffle(lista);
        System.out.println(lista.get(2));


        return lista.get();*/
        return 4;
    }

    public class question{

        String iPerguntas[] ={
            "O que é uma corretora de investimentos?","O que é Renda Fixa?","O que é Renda variável?","O que é Tesouro Direto?","O que é Taxa Selic?",
        "O que é CDB?","O que é LCI e LCA?","O que é debêntures?","O que são ações?"};

    private String iescolhas[][]={
            {"Certa","Errada","Errada","Errada"},
            {"Sim","Errada","Errada","Errada"},
            {"Errada","Errada","certo","WillyWonka"},
            {"Pena","Gordo","Obeso","correta"},
            {"Thanos","essa","Sua mae","gordo em obito"},
            {"Certinho","Errada","Errada","Errada"},
            {"Certinha","Errada","Errada","Errada"},
            {"aCerto","Errada","Errada","Errada"},
            {"que essa Certa","Errada","Errada","Errada"},


    };
        private String acerto[] = {"Certa","Sim","certo","correta","essa","Certinho","Certinha","aCerto","que essa Certa"};

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




