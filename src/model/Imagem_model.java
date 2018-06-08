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
    private int quantPixels;
    private int Height;
    private int Width;
    private int greyScale;   
    private int pixelMax;
    private int pixelMin;
    private int[][] matriz; 
    private BufferedImage img;
    
    public Imagem_model(String Local, String Nome) throws FileNotFoundException, IOException {      
        DEBUG = true;
        nome = Nome;
        imagem = new File(Local);
        local = Local;
        Height = 0;
        greyScale = 0;    
               
        
        if(!abrirImagem())
            Error.show("Não foi possivel ler a imagem.");
        else {            
            getMaxMin();
            img = new BufferedImage(Width, Height, BufferedImage.TYPE_BYTE_GRAY); // Escala de cinza.                      
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
        return quantPixels;
    }

    public void setQuantidade(int quantidade) {
        this.quantPixels = quantidade;
    }
        
    public File getImagem() {
        return imagem;
    }

    public void setImagem(File imagem) {
        this.imagem = imagem;
    }

    public int getAltura() {
        return Height;
    }

    public void setAltura(int altura) {
        this.Height = altura;
    }

    public int getLargura() {
        return Width;
    }

    public void setLargura(int largura) {
        this.Width = largura;
    }

    public int getNiveisCinza() {
        return greyScale;
    }

    public void setNiveisCinza(int niveisCinza) {
        this.greyScale = niveisCinza;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }    

    
    
    /* PLUS */
    
    /**
     * Faz a contagem de quantidade de pixeis até o nivel de cinza        N^k
     * @return int[] N
     */
    private int[] N(){        
        int[] N = new int[greyScale];
        for (int k = 0; k < greyScale; k++) {
            N[k] = 0;
            for (int w = 0; w < Width; w++) {
                for (int h = 0; h < Height; h++) {                       
                    if(matriz[w][h] == k){                        
                        N[k]++;       
                    }                        
                }
            }
        } 
        return N;
    }
    
     /**
     * Divide pela Quantidade de Pixeis o Numero de pixels cujo nivel de cinza correspondem ao "k" Nivel
     * @param int[] N Contagem de pixeis por nivel de cinza.
     * @return double[] p
     */
    private double[] p(int[] N){
        double[] p = new double[greyScale];
        for (int i = 0; i < greyScale; i++) {              
            p[i] = ((double)N[i])/quantPixels;            
        }
        return p;
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
                System.out.println("Tamanha: "+Height+ " | " +Width);
                System.out.println("Cinza: " + greyScale);
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
            buffW.write(Height + " " + Width);
            buffW.newLine();
            buffW.write(String.valueOf(greyScale));
            buffW.newLine();

            for (int i = 0; i < Height; i++) {
                for (int j = 0; j < Width; j++) {
                    if (j < Width - 1) {
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
        
        double calc = (greyScale / (pixelMax - pixelMin));
        
        for (int i = 0; i < Height; i++) {
            for (int j = 0; j < Width; j++) {
                
                valor = calc * (matriz[i][j] + matriz_a_ser_somada[i][j]) - pixelMin;
                
                if(valor >= greyScale)
                    valor = greyScale;
                
                matriz[i][j] = (int) valor;  
            }
        }
    }
    
    public void Subtrair(int[][] matriz_a_ser_somada, int linhas2, int colunas2){
        double valor = 0;         
        boolean normalizacao = true;        
        double calc = 0;
        
        if(normalizacao)
            calc = (greyScale / (pixelMax - pixelMin));      
        
        
        for (int i = 0; i < Height; i++) {
            for (int j = 0; j < Width; j++) {
                
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
        
        
        setLargura(Width);
        setMatriz(nvmatriz);
        setAltura(Height);
        
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
       
        int temp[][] = new int[Height][Width];
        
        for (int i = Height-1; i >= 0; i--) {
            for (int j = Width-1; j >= 0; j--) {
                temp[Height-1-i][Width-1-j] = matriz[i][j];
            }
        }
        matriz = temp;
    }
    
    public void EspelharVertical() {        
        
        int temp[][] = new int[Height][Width];
        
        for (int i = Height-1; i >= 0; i--) {
            for (int j = Width-1; j >= 0; j--) {
                temp[i][Width-1-j] = matriz[i][j];
            }
        }
        matriz = temp;
    }
   
    public void Interpolacao() {
        int a,b,c,d,e;
        for (int y = 0; y < Height; y++) {
            for (int x = 0; x < Width; x++) {

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
        int[] N = N();        
        //Retorna a sequencia de valores para histograma
        return p(N);
    }
    
    public void FiltroExpansao() {
    
    }
    
    /**
     * <b>Limiarização</b> <i>é um processo de segmentação de imagens que se baseia na 
     * diferença dos níveis de cinza que compõe diferentes objetos de uma imagem.</i>
     * <br><br>
     * A partir de um limiar estabelecido de acordo com as características dos 
     * objetos que se quer isolar, a imagem pode ser segmentada em dois grupos: 
     * o grupo de pixels com níveis de cinza abaixo do limiar e o grupo de pixels 
     * com níveis de cinza acima do limiar. Em uma imagem limiarizada, atribui-se 
     * um valor fixo para todos os pixels de mesmo grupo.
     * <hr>
     * Esta função utiliza a <b> Método de Otsu </b>
     * @param T Limiar, ponto Chave
     */   
    public void Limiarizacao(int T){
        double[] P = new double[greyScale];
        double M = Double.MIN_VALUE; //Melhor Valor
                
        for (int i = T; i < greyScale; i++) {
            P[i] = Variancia(i);
        }
        
        for (int i = T; i < greyScale; i++) {
            if(P[i] > M){
                M = P[i];
            }
        }
        /* Faz a separação com base o melhor Valor! */
        for (int h = 0; h < Height; h++) {
            for (int w = 0; w < Width; w++) {
                if(matriz[h][w] > M){
                    matriz[h][w] = (int) M;
                    //matriz[h][w] = 1;
                } else matriz[h][w] = 0;
            }
        }
    }
    
    /**
     * C1 0 até T
     * C2 T+1 até L-1
     * p = Probabilidade
     * P = Soma
     * multiplaca i pela probalidade. (i* p[i])
     * Variancia(T) é variança.
     * @param T 
     */
    private double Variancia(int T) {
        
        int L = greyScale;  //Nivel de Cinza
        int[] N = N();
        double[] p = p(N);
        
        double P1 = 0;
        double P2 = 0;
        double M1 = 0;
        double M2 = 0;        
        double MG = 0;        
        
        
        //C1 [0,T]
        for (int i = 0; i <= T; i++) {
            P1 += p[i];
            //M1 += i * p[i];
        }   
        
        for (int i = 0; i <= T; i++) {            
            M1 += i * p[i];
        }   
        
        M1 = M1/P1;
        
        
        
        
        //C2[T+1,L-1]        
        for (int i = T+1; i <= L-1; i++) {
            P2 += p[i];
        }
        
        for (int i = T+1; i <= L-1; i++) {
            M2 += i * p[i];
        }
        
        M2 = M2/P2;
        
        
        
        
        //MG[0,L-1]
        for (int i = 0; i <= L-1; i++) {
            MG += i * p[i];
        }
        
        
        
        return (P1 * Math.pow((M1 - MG), 2)) + (P2 * Math.pow((M2 - MG), 2));
    }
}
