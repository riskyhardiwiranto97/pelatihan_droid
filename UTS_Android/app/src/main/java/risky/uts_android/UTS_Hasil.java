package risky.uts_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UTS_Hasil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uts__hasil);

        TextView textView=(TextView) findViewById(R.id.hasilview);
        Intent intent=getIntent();
        textView.setText(intent.getStringExtra("risky.uts_android"));
    }

}
