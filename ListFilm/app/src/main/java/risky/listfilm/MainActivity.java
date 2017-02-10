package risky.listfilm;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Movie> movies = new ArrayList<>();

    ArrayAdapter<Movie> adapter;
    ListView listView;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<Movie>(this, android.R.layout.simple_list_item_1, movies);
        ListView listView = (ListView) findViewById(R.id.listFilm);
        listView.setAdapter(adapter);

        // membuat tulisan jika di klik
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,long id){
           Movie selectedMovie = movies.get(position);
            Intent intent = new Intent(getBaseContext(),DetailActivity.class);
            intent.putExtra("risky.listfilm", selectedMovie);
            startActivityForResult(intent,1);
        }
        });
    }

    public void formtambah (View view){
        Intent intent = new Intent(this,TambahList.class);
        startActivityForResult(intent,1);
    }
    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        if (requestCode ==1){
            if (resultCode == Activity.RESULT_OK){
                Movie newMovie = (Movie) data.getSerializableExtra("filmlist.result");
                movies.add(newMovie);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
