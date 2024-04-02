package alcantara.gracas.email;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnEnviar = (Button) findViewById(R.id.btnEnviar); //definir o botao
        btnEnviar.setOnClickListener(new View.OnClickListener() { //cria um ouvidor do botao
            @Override
            public void onClick(View v) { //ao clicar no botao, esse metodo e acionado
                EditText etEmail = (EditText) findViewById(R.id.etEmail);//pega o objeto(editText)
                String email = etEmail.getText().toString();//pega o texto do objeto

                EditText etAssunto = (EditText) findViewById(R.id.etAssunto);//pega o objeto(editText)
                String assunto = etAssunto.getText().toString();//pega o texto do objeto

                EditText etTexto = (EditText) findViewById(R.id.etTexto);//pega o objeto(editText)
                String texto = etTexto.getText().toString();//pega o texto do objeto

            }
        });
    }
}