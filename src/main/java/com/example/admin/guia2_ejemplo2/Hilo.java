package com.example.admin.guia2_ejemplo2;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by admin on 1/9/18.
 */

public class Hilo extends AsyncTask<Integer,Integer,String> {
    Context context;
    //controles que quiero actualizar en segundo plano
    TextView lblTexto;
    Button btnHilo;

    public Hilo(Context context, TextView lblTexto,Button btn) {
        this.context = context;
        this.lblTexto = lblTexto;
        btnHilo = btn;
    }


    @Override
    protected void onPreExecute() {
        btnHilo.setEnabled(false);
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Integer... integers) {
        for(int i=0;i<integers[0];i++  ){
            try {
                publishProgress(i);
                Thread.sleep(integers[1]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Finalizado";
    }
    @Override
    protected void onProgressUpdate(Integer... values) {
        lblTexto.setText("Valor "+values[0]);
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        lblTexto.setText(s);
        btnHilo.setEnabled(true);
        super.onPostExecute(s);
    }
}
