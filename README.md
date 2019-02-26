# veia
Jogo da veia desenvolvido na aula de Android na FATEC Indaiatuba.

Só subi no git por conta da lógica doida usando matriz.

Segue explicação da lógica:

```java
//Criando matriz 3x3 de valor inteiro e atribuindo zero como valor padrão. 
private int[][] velha = new int[][]{{0,0,0},
                                    {0,0,0},
                                    {0,0,0}};
/**
    Explicação da lógica:
    Temos a matriz abaixo representando o jogo da veia sem movimentos
    [0,0,0],
    [0,0,0],
    [0,0,0]
    
    foi atribuído o valor 1 para a O e 2 para X, ficando como no exemplo abaixo onde o O ganha
    [1,0,2],
    [0,1,2],
    [0,0,1]
    
    para saber se alguém ganhou, basta somar as diagonais, linhas e colunas.
    Se chegar no resultado correspondente a 3 o O ganha, caso 6 o X.
*/
...
//Método para validar se temos um ganhador
public void valida(){
    int coluna = 0, //soma da coluna  
        linha = 0, //soma da linha 
        diagonalPri = 0, //soma de uma das diagonais
        diagonalSec = 0;//soma de uma das diagonais
    
    for (int i =0; i <3;i++) {//repetição das linhas
        for (int j = 0; j < 3; j++) {//repetição das colunas 
            
            //caso a coluna seja diferente de 0 soma o valor da coluna
            // senão soma um valor alto, no caso 48  
            coluna += velha[i][j]!=0?velha[i][j]:48;
            linha += velha[j][i]!=0?velha[j][i]:48;
            //caso seja parte da diagonal principal realiza a somatória 
            if(i==j)diagonalPri += velha[i][j]!=0?velha[i][j]:48;
            //caso seja parte da diagonal secundaria realiza a somatória 
            if((i+j)==4)diagonalSec += velha[i][j]!=0?velha[i][j]:48;
            
        }
        
        //Validação das somatórias 
        if(coluna == 3 || linha == 3){
            Toast.makeText(this, "O Ganhou!", Toast.LENGTH_SHORT).show();
        }else if(coluna == 6 || linha == 6 ){
            Toast.makeText(this, "X Ganhou!", Toast.LENGTH_SHORT).show();
        }else{
            coluna =0;
            linha = 0;
        }
    }
    //Validação das somatórias 
    if(coluna == 3 || linha == 3 || diagonalPri == 3 || diagonalSec ==3){
        Toast.makeText(this, "O Ganhou!", Toast.LENGTH_SHORT).show();
    }else if(coluna == 6 || linha == 6 || diagonalPri == 6 || diagonalSec == 6){
        Toast.makeText(this, "X Ganhou!", Toast.LENGTH_SHORT).show();
    }
}
```

Existem enumeras melhorias possíveis, mas por enquanto abro mão delas.
