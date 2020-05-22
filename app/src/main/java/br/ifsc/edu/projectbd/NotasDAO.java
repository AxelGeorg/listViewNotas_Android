package br.ifsc.edu.projectbd;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotasDAO {

    SQLiteDatabase bd;


    public NotasDAO(Context context) {

        bd = context.openOrCreateDatabase("meubd", context.MODE_PRIVATE, null);

        bd.execSQL("CREATE TABLE IF NOT EXISTS notas(" +
                "id integer primary key autoincrement," +
                "titulo varchar not null," +
                "texto varchar);");

    }

    public ArrayList<Nota> getNotas(){

        ArrayList<Nota> ArraylistadeNotas = new ArrayList<Nota>();

        Cursor cursor;// o cursor é uma tabelona
        cursor = bd.rawQuery("SELECT * FROM notas", null,null);
        //o cursor começa na primeira linha e vai vendo uma por uma
        cursor.moveToFirst();//volta para a primeira linha

        //Log.d("TabelaNotas", cursor.getString(0)+cursor.getString(1));//so a primeira linha
        String titulo, texto;
        int id;

        while(!cursor.isAfterLast()) {//recupera todos os registros, enquanto o proximo nao for o ultimo

            id = cursor.getInt(cursor.getColumnIndex("id"));
            titulo = cursor.getString(cursor.getColumnIndex("titulo"));
            texto = cursor.getString(cursor.getColumnIndex("texto"));

            ArraylistadeNotas.add(new Nota(id,titulo,texto));
            //Log.d("TabelaNotas", id + titulo + texto);

            cursor.moveToNext();
        }

        return ArraylistadeNotas;
    }
}
