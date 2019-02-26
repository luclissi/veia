package com.enois.android.veia;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private boolean player = true;
    private int[][] velha = new int[][]{{0,0,0},{0,0,0},{0,0,0}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void meClicou(View v){
        TextView txt = (TextView)findViewById(v.getId());
        Log.d("WARN","PASSOU AQUI "+txt.getText());
        if(txt.getText().toString().equals("")){
            if(player){
                txt.setText("X");
            }else{
                txt.setText("O");
            }
            player = !player;
        }
        char[] charArray = txt.getTag().toString().toCharArray();
        int x = Integer.parseInt(""+charArray[0]),
            y = Integer.parseInt(""+charArray[1]);
        velha[x-1][y-1] = (player)?1:2;
        valida();
    }

    public void valida(){
        int coluna = 0, linha = 0, diagonal = 0, diagonal2 = 0;
        String matriz = "";
        for (int i =0; i <3;i++) {
            for (int j = 0; j < 3; j++) {
                coluna += velha[i][j]!=0?velha[i][j]:48;
                linha += velha[j][i]!=0?velha[j][i]:48;
                if(i==j)diagonal += velha[i][j]!=0?velha[i][j]:48;
                if((i+j)==4)diagonal2 += velha[i][j]!=0?velha[i][j]:48;
                matriz += velha[i][j]+" ";
            }
            matriz += "\n";
            Log.d("WARN","coluna "+coluna);
            if(coluna == 3 || linha == 3){
                Toast.makeText(this, "O Ganhou!", Toast.LENGTH_SHORT).show();
            }else if(coluna == 6 || linha == 6 ){
                Toast.makeText(this, "X Ganhou!", Toast.LENGTH_SHORT).show();
            }else{
                coluna =0;
                linha = 0;
            }
        }
        Log.d("WARN","coluna "+coluna);
        Log.d("WARN","linha "+linha);
        Log.d("WARN","diagonal "+diagonal);
        Log.d("WARN","diagonal2 "+diagonal2);
        Log.d("WARN","matriz "+matriz);
        if(coluna == 3 || linha == 3 || diagonal == 3 || diagonal2 ==3){
            Toast.makeText(this, "O Ganhou!", Toast.LENGTH_SHORT).show();
        }else if(coluna == 6 || linha == 6 || diagonal == 6 || diagonal2 == 6){
            Toast.makeText(this, "X Ganhou!", Toast.LENGTH_SHORT).show();
        }
    }
}
