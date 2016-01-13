package mayrarodriguez.pruebajson;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    // el throws JSONException permite indicar al sistema que este método se ejecutará mientras
    // no exista un error en los datos ingresados.

    public void generateJSON(View view) throws JSONException {

        // Asociamos los elementos a usar aquí con los archivos respectivos del XML
        // mediante el findViewById
        EditText etName = (EditText)findViewById(R.id.etName);
        EditText etAge = (EditText)findViewById(R.id.etAge);

        TextView tvJSON = (TextView)findViewById(R.id.tvJSON);

        // Pasamos los datos ingresados por el usuario a un String o Cadena
        String sName = etName.getText().toString();
        int iAge = Integer.parseInt(etAge.getText().toString());

        // Creamos los objetos JSON
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        // Insertamos los valores que queremos mostrar en el JSON
        jsonObject.put("Nombre", sName);
        jsonObject.put("Edad", iAge);

        // En el orden en que se insertan los valores en el Array, se ocuparán en el mismo
        jsonArray.put("Ejemplo"); //posición 0 del array
        jsonArray.put(23); //posición 1 del array
        jsonArray.put(-10); //posición 2 del array

        // Insertamos el valor resultante en un String
        String sResult = jsonObject.toString();
        String sResultArray = jsonArray.toString();

        // Introducimos el valor del String en un TextView para mostrar el resultado
        tvJSON.setText(sResult + sResultArray);
    }

}
