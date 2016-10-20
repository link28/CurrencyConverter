package edu.tecii.andrioid.currencyconverter;

import android.annotation.TargetApi;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

@TargetApi(Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {
Button btnConvert;
    Button btnClear;
    EditText txtUsDollars;
    EditText txtEuros;
    EditText txtColones;
    DecimalFormat usaDF = new DecimalFormat("###,###,###,##");





    private final double EURO2USD = 1.35;
    private  final char EUROSYM = '\u20AC';
    private final double COLON2USD = 0.0019;
    private final char COLONSYM = '\u20A1';


   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsDollars = (EditText) findViewById(R.id.txtUSCollars);
        txtEuros = (EditText) findViewById(R.id.txtEuros);
        txtEuros.setInputType(EditorInfo.TYPE_NULL);
        txtColones = (EditText) findViewById(R.id.txColones);

        btnClear = (Button) findViewById(R.id.btnclear);
        btnClear.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View V){
                txtColones.setText("");
                txtEuros.setText("");
                txtUsDollars.setText("");

            }

        });

        btnConvert = (Button) findViewById(R.id.btnconvert);
        btnConvert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View V){

                try {
                    String usdStr = txtUsDollars.getText().toString();
                    double usd = Double.parseDouble(usdStr);
                    String euros = EUROSYM + String.valueOf(usaDF.format(usd / EURO2USD));
                    String colones = COLONSYM + String.valueOf(usaDF.format(usd/COLON2USD));
                    txtEuros.setText(euros);
                    txtColones.setText(colones);

                } catch (NumberFormatException e){
            }
        }


        });


    }
}
