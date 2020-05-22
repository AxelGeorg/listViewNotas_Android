package br.ifsc.edu.projectbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase bd;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotasController notasController = new NotasController(getApplicationContext());
        //bd.execSQL("INSERT INTO notas (id, titulo, texto) VALUES (null, \"Felicidade\", \" \");");
        //ou para algo melhor
//        ContentValues contentValues = new ContentValues();
//        // o put empilha os dados
//        contentValues.put("titulo","Agora eu estou mais feliz");
//        contentValues.put("texto","Hoje eu acordei feliz para poder ir programar");

        //bd.insert("notas", null, contentValues);
        //bd.execSQL("DELETE FROM notas WHERE titulo=\"Felicidade\";");
        //bd.execSQL("UPDATE notas SET titulo=\"Axel\" WHERE titulo=\"Felicidade\";");


        listView = findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>( //set o listview
                getApplicationContext(),
                android.R.layout.simple_list_item_1, //xml  é um resere, R.layout.OQUEEUTENHO
                android.R.id.text1,
                notasController.getTitulosNotas());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {//intanciar é criar um objeto de uma class, atraves do new pedindo memoria do sistema
            @Override //class anonima
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
