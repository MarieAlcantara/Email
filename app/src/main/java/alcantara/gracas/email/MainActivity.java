package alcantara.gracas.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnEnviar = (Button) findViewById(R.id.btnEnviar); //obter o botao
        btnEnviar.setOnClickListener(new View.OnClickListener() { //cria um ouvidor de cliques do botao
            @Override
            public void onClick(View v) { //ao clicar no botao, esse metodo e acionado
                EditText etEmail = (EditText) findViewById(R.id.etEmail);//pega o objeto(editText)
                String email = etEmail.getText().toString();//pega o texto do objeto

                EditText etAssunto = (EditText) findViewById(R.id.etAssunto);//pega o objeto(editText)
                String assunto = etAssunto.getText().toString();//pega o texto do objeto

                EditText etTexto = (EditText) findViewById(R.id.etTexto);//pega o objeto(editText)
                String texto = etTexto.getText().toString();//pega o texto do objeto

                Intent i = new Intent(Intent.ACTION_SENDTO);//intencao de enviar

                i.setData(Uri.parse("mailto:"));//manda para quem pode receber o email

                //Informacoes(conteudo) do email que vai ser enviado
                String[] emails = new String[]{email};
                i.putExtra(Intent.EXTRA_EMAIL,emails);
                i.putExtra(Intent.EXTRA_SUBJECT, assunto);
                i.putExtra(Intent.EXTRA_TEXT, texto);

                try {
                    //executa a intencao
                    startActivity(Intent.createChooser(i,  "Escolha o APP"));//cria um menu para o usuario escolher onde abrir o email
                }
                catch (ActivityNotFoundException e) {
                    //caso nao tenha umaapp que resolva essa intencao mostra uma mensagem de erro
                    Toast.makeText(MainActivity.this, "Nao ha nenhum app que posso realizar essa operacao", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}