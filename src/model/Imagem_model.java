/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class Imagem_model {    
    public boolean DEBUG;
    private File imagem;
    private String nome;
    private String local;
    private int quantidade;
    private int altura;
    private int largura;
    private int niveisCinza;   
    private int pixelMax;
    private int pixelMin;
    private int[][] matriz; 
    private BufferedImage img;
    
    public Imagem_model(String Local, String Nome) throws FileNotFoundException, IOException {      
        DEBUG = true;
        nome = Nome;
        imagem = new File(Local);
        local = Local;
        altura = 0;
        niveisCinza = 0;    
               
        
        if(!abrirImagem())
            Error.show("Não foi possivel ler a imagem.");
        else {            
            getMaxMin();
            img = new BufferedImage(largura, altura, BufferedImage.TYPE_BYTE_GRAY); // Escala de cinza.                      
        }
        
    } 

    public int getPixelMax() {
        return pixelMax;
    }

    public int getPixelMin() {
        return pixelMin;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
        
    public File getImagem() {
        return imagem;
    }

    public void setImagem(File imagem) {
        this.imagem = imagem;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getNiveisCinza() {
        return niveisCinza;
    }

    public void setNiveisCinza(int niveisCinza) {
        this.niveisCinza = niveisCinza;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }    

    /* INICIO FERRAMENTAS */
    private boolean abrirImagem() throws IOException {
        
        if (getImagem() != null) {
            
            Scanner scan = new Scanner(imagem);     
            
            scan.nextLine(); //discarta P2
            scan.nextLine(); //discarta # COMENTARIO
            
            setAltura(scan.nextInt());  // Linhas
            setLargura(scan.nextInt()); // Colunas
            setNiveisCinza(scan.nextInt()); //Cinza                         
                        
            this.matriz = new int[getAltura()][getLargura()];
            
            int quantidade = 1;
            for (int i = 0; i < getAltura(); i++) {
                for (int j = 0; j < getLargura(); j++) {
                    this.matriz[i][j] = scan.nextInt();
                    setQuantidade(quantidade);
                    quantidade++ ;
                }
            }
            
            if(DEBUG){
                System.out.println("Tamanha: "+altura+ " | " +largura);
                System.out.println("Cinza: " + niveisCinza);
                System.out.println("Quantidade Lida: " + getQuantidade());
            }
            return true;        
        }
        
        return false;
    }

    public boolean salvarImagem(String Path) {
        File arq = new File(Path);        
        try {
            arq.createNewFile();

            FileWriter fileW = new FileWriter(arq);//arquivo para escrita
            BufferedWriter buffW = new BufferedWriter(fileW);
            buffW.write("P2");
            buffW.newLine();
            buffW.write("#Criado por Otavio Voiski.");
            buffW.newLine();
            buffW.write(altura + " " + largura);
            buffW.newLine();
            buffW.write(String.valueOf(niveisCinza));
            buffW.newLine();

            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < largura; j++) {
                    if (j < largura - 1) {
                        buffW.write(String.valueOf(matriz[i][j]) + "  ");
                    } else {
                        buffW.write(String.valueOf(matriz[i][j]) + " ");
                        buffW.newLine();
                    }

                    buffW.flush();
                }

            }
            buffW.newLine();
            
            if(DEBUG){
                System.out.println("Arquivo " + Path + " criado com sucesso!!!");            
                Error.show("Arquivo " + Path + " criado com sucesso!");
            }
                
                
            return true;
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());            
            return false;
        }
    }
        
    /*FERRAMENTAS*/
    private void getMaxMin(){ //Maior valor da imamge
        int max = 0;
        int min = 0;
        for (int i = 0; i < getAltura(); i++) {
            for (int j = 0; j < getLargura(); j++) {               
            
                if(matriz[i][j] > max)
                    max = matriz[i][j];
                
                if(min == 0)
                    min = matriz[i][j];
                
                
                if(matriz[i][j] < min)
                    min = matriz[i][j];
                
            }
                
        }
        
        pixelMax = max;
        pixelMin = min;
    }    
    
    public void Somar(int[][] matriz_a_ser_somada, int linhas2, int colunas2){
         double valor = 0;
        
        double calc = (niveisCinza / (pixelMax - pixelMin));
        
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                
                valor = calc * (matriz[i][j] + matriz_a_ser_somada[i][j]) - pixelMin;
                
                if(valor >= niveisCinza)
                    valor = niveisCinza;
                
                matriz[i][j] = (int) valor;  
            }
        }
    }
    
    public void Subtrair(int[][] matriz_a_ser_somada, int linhas2, int colunas2){
        double valor = 0;         
        boolean normalizacao = true;        
        double calc = 0;
        
        if(normalizacao)
            calc = (niveisCinza / (pixelMax - pixelMin));      
        
        
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                
                if(normalizacao)
                    valor = calc * ((matriz[i][j] - matriz_a_ser_somada[i][j]) - pixelMin);                
                else {
                    
                    valor = (matriz[i][j] - matriz_a_ser_somada[i][j]);
                
                }
                
                
                if(valor < 0)
                    valor = 0;
                
                
                matriz[i][j] = (int) valor;  
            }
        }
    }
    
    public void RotacaoHorario(){
        
        int larg = matriz.length;
        int alt = matriz[0].length;
        
        int[][] nvmatriz = new int[alt][larg];
        
        for (int i = 0; i < alt; i++) {
            for (int j = 0; j < larg; j++) {
                nvmatriz[i][j] = matriz[larg - 1 - j][i];
            }
        }        
        
        
        setLargura(largura);
        setMatriz(nvmatriz);
        setAltura(altura);
        
    }
    
    public void RotacaoAntiHorario(){
        int largura = matriz.length;
        int altura = matriz[0].length;   
        
        int[][] nvmatriz = new int[altura][largura];
        
        for (int i=0; i < altura; i++) {
            for (int j=0; j < largura; j++) {
                nvmatriz[i][j] = matriz[j][altura - 1 - i];
            }
        }        
        
        setLargura(largura);
        setMatriz(nvmatriz);
        setAltura(altura);
         
     }
        
    public void EspelharHorizontal() {
       
        int temp[][] = new int[altura][largura];
        
        for (int i = altura-1; i >= 0; i--) {
            for (int j = largura-1; j >= 0; j--) {
                temp[altura-1-i][largura-1-j] = matriz[i][j];
            }
        }
        matriz = temp;
    }
    
    public void EspelharVertical() {        
        
        int temp[][] = new int[altura][largura];
        
        for (int i = altura-1; i >= 0; i--) {
            for (int j = largura-1; j >= 0; j--) {
                temp[i][largura-1-j] = matriz[i][j];
            }
        }
        matriz = temp;
    }
   
    public void Interpolacao() {
        int a,b,c,d,e;
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {

                a = (matriz[x][y] + matriz[x+1][y]) /2;
                b = (matriz[x][y+1] + matriz[x+1][y+1]) /2;
                c = (matriz[x][y] + matriz[x][y+1]) /2;
                d = (matriz[x+1][y] + matriz[x+1][y+1]) /2;
                e = (matriz[x][y] + matriz[x+1][y] + matriz[x][y+1] + matriz[x+1][y+1]) /4;

            }
        }
    }
    
    public void Quantizacao(int nivel){
        
        int[][] matrizAux = new int[this.getAltura()][this.getLargura()];

        for(int k = 0 ; k < getAltura() / nivel ; k++){
            for(int l = 0 ; l< getLargura() / nivel ; l++){
                for(int i = k * nivel ; i < ((k+1) * nivel);i++){
                    for(int j = l * nivel ; j < ((l+1)* nivel) ; j++){
                        matrizAux[k][l] += matriz[i][j];
                    }
                }
                matrizAux[k][l] = matrizAux[k][l] / (nivel * nivel);
            }
        }


        for(int k = 0 ; k < getAltura()/ nivel ; k++){
            for(int l = 0 ; l < getLargura() / nivel ; l++){
                for(int i = k * nivel ; i < ((k+1) * nivel) ; i++){
                    for(int j = l * nivel; j < ((l+1) * nivel) ; j++){
                        matriz[i][j] = matrizAux[k][l];

                    }
                }
            }
        }
    }
    
    
    
    
    /* INICIO MELHORIAS */    
    public double[] Histograma() {
        double[] replay = new double[niveisCinza];
        double[] dados = new double[niveisCinza];
        
        //Faz a contagem de quantidade de pixeis até o nivel de cinza        
        for (int k = 0; k < niveisCinza; k++) {
            replay[k] = -1;
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < largura; j++) {      
                    if(matriz[i][j] == k){
                        if(replay[k] == -1)
                            replay[k] = 0;
                        
                        replay[k]++;       
                    }
                        
                }
            }
        }      
        
        //Divide pela Quantidade de Pixeis o Numero de pixels cujo nivel de cinza correspondem ao "k" Nivel
        for (int i = 0; i < niveisCinza; i++) {  
            if(replay[i] > -1)
                dados[i] = replay[i]/quantidade;
        }
        
        //Retorna a sequencia de valores para histograma
        return dados;
    }
    
    public void FiltroExpansao() {
    
    }
    
    
}
