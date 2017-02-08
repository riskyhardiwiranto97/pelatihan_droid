package risky.uts_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void hasil(View view) {
        EditText inp1=(EditText) findViewById(R.id.inp1);
        EditText inp2=(EditText) findViewById(R.id.inp2);
        EditText inp3=(EditText) findViewById(R.id.inp3);
        EditText inp4=(EditText) findViewById(R.id.inp4);
        EditText inp5=(EditText) findViewById(R.id.inp5);

        double input1,input2,input3,input4,input5;
        input1 = Double.parseDouble(inp1.getText().toString());
        input2 = Double.parseDouble(inp2.getText().toString());
        input3 = Double.parseDouble(inp3.getText().toString());
        input4 = Double.parseDouble(inp4.getText().toString());
        input5 = Double.parseDouble(inp5.getText().toString());
        String result = "";

        result = "Kanlpot                 "+(input1)+"\t"+"\t"+"\t"+"\t"+"\t"+(input1*250000)  + "\n";
        result += "Velg                       "+(input2)+"\t"+"\t"+"\t"+"\t"+"\t"+(input2*500000)  + "\n";
        result += "Oli Enduro            "+(input3)+"\t"+"\t"+"\t"+"\t"+"\t"+(input3*40000)  + "\n";
        result += "Kabel Rem           "+(input4)+"\t"+"\t"+"\t"+"\t"+"\t"+(input4*60000)  + "\n";
        result += "Spedometer        "+(input5)+"\t"+"\t"+"\t"+"\t"+"\t"+(input5*360000)  + "\n";
        result += "_________________________________"+"\n";
        result += "Total        "+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+":"+((input1*250000)+(input2*500000)+(input3*40000)+(input4*60000)+(input5*360000));

        Intent intent=new Intent(getApplicationContext(),UTS_Hasil.class);
        intent.putExtra("risky.uts_android",result);
        startActivity(intent);
    }
}
