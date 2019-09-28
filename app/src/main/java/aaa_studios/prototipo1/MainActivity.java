package aaa_studios.prototipo1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends Activity {
private Button butao;
    private ImageButton botaoservico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoservico = (ImageButton) findViewById(R.id.servicoid);
butao = (Button) findViewById(R.id.buttonid);
        botaoservico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, textos.class);
                startActivity(intent);
            }
        });
butao.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, Quizmelhor.class);
        startActivity(intent);
    }
});
    }


}
