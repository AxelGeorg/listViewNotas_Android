package br.ifsc.edu.projectbd;

import android.content.Context;

import java.util.ArrayList;

public class NotasController {

    Context mContext;

    NotasDAO notasdao;

    public NotasController(Context context) {
        mContext = context;
        notasdao = new NotasDAO(mContext);
    }

    public ArrayList<Nota> getNotas() {
        return notasdao.getNotas();
    }


    public ArrayList<String> getTitulosNotas() {

        ArrayList<String> arrayAdapterResultado = new ArrayList<String>();

        for (Nota n : notasdao.getNotas()) {
            arrayAdapterResultado.add(n.getTitulo());
        }
        return arrayAdapterResultado;
    }


}
