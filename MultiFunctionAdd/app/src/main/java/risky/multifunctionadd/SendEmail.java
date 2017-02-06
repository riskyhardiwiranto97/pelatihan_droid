package risky.multifunctionadd;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SendEmail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);
    }
    public void sendEmail(View view) {
        EditText tpenerima = (EditText) findViewById(R.id.penerima);
        EditText tjudul = (EditText) findViewById(R.id.judul);
        EditText tkonten = (EditText) findViewById(R.id.konten);

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto :" +tpenerima.getText().toString()));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, "riskyhardiwiranto221097@gmail.com");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, tjudul.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_TEXT, tkonten.getText().toString());

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail....."));
            finish();
        } catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(SendEmail.this,
                    "There is no Email Clien Installed.",Toast.LENGTH_SHORT).show();
        }
        startActivity(emailIntent);
    }
}
