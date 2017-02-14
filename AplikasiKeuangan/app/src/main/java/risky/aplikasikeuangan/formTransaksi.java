package risky.aplikasikeuangan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class formTransaksi extends AppCompatActivity {

    private String [] jenisStr = {"Pemasukan","Pengeluaran"};
    private EditText nama,jumlah,keterangan;
    private Spinner jenis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_transaksi);

        jenis = (Spinner) findViewById(R.id.inpjenis);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, jenisStr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jenis.setAdapter(adapter);

        nama = (EditText) findViewById(R.id.inpnama);
        jumlah = (EditText) findViewById(R.id.inpjumlah);
        keterangan = (EditText) findViewById(R.id.inpketerangan);
    }

    public void saveTransaksi(View view){
        TransaksiHelper dbHelper = new TransaksiHelper(this);
        String tnama = nama.getText().toString();
        int tjenis = jenis.getSelectedItemPosition()+1;
        int tjumlah = Integer.parseInt(jumlah.getText().toString());
        String tketerangan = keterangan.getText().toString();

        dbHelper.insertTransaksi(tnama,tjenis,tjumlah,tketerangan);

        Log.d("formTransaksi",tnama+" - "+Integer.toString(tjenis)+" - "+Integer.toString(tjumlah)
                                +" - "+tketerangan);
        Toast.makeText(this, "Transaksi "+tnama+"berhasil disimpan", Toast.LENGTH_SHORT).show();

    //    startActivity(new Intent(this, MainActivity.class));
    finish();
    }
}
