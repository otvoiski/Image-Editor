/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.glass.events.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.DirectDrawDemo;
import model.Histograma;
import model.Imagem_model;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author Administrador
 */
public class Main_view extends javax.swing.JFrame {
    Imagem_model img;
    File arquivo_original;
    File arquivo_somarremover_File;
    JFrame frame;
    DirectDrawDemo panel;
    boolean DEBUG = true;
    
    /**
     * Creates new form main
     */
    public Main_view() {
        initComponents();        
        img = null;
        start();
        
    }
    
    
      
    private void start() {
        RelacionamentoComImagem(false);   
        
        String Local = "src/img/";
        //String Nome = "mona_lisa.ascii.pgm";
        //String Nome = "lena.ascii.pgm";
        //String Nome = "8x8-8.pgm";
        String Nome = "4x4-8.pgm";
        
        jtext_opcao_local.setText(Local);
        jtext_option_nome.setText(Nome);        
    }
    
             
    private void SaveFile(){
        JFrame parentFrame = new JFrame();
 
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Escolha o lugar para salvar");   
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                ".pgm", "pgm");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            fileToSave.setWritable(true);
            
            String Path = fileToSave.getAbsolutePath() + ".pgm";
                
            img.salvarImagem(Path);
            
            System.out.println("Save as file: " + Path);
        }

    }
    
    private void OpenFile(String local, String nome){
        
        try {
            //auto select
                img = new Imagem_model(local,nome);     

                atualizarImagemView();                    

                RelacionamentoComImagem(true);        
                            
               
        } catch (IOException ex) {
            Logger.getLogger(Main_view.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    private File OpenFile(){
        JFileChooser file = new JFileChooser(); 
        File arquivo = null;
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
                
        int i= file.showOpenDialog(null);
        
        if (i == 1){ 
            RelacionamentoComImagem(false); 
            return null;
        } else {
            arquivo = file.getSelectedFile(); 
            RelacionamentoComImagem(true);         
            return arquivo;              
        }

    }
    
    private void atualizarPropriedades(){
        jlabel_descricao_nome.setText(img.getNome());
        jlabel_descricao_local.setText(img.getLocal());
        jlabel_descricao_altura.setText(String.valueOf(img.getHeight()));
        jlabel_descricao_largura.setText(String.valueOf(img.getWidth()));
        jlabel_descricao_cinza.setText(String.valueOf(img.getGreyScale()));
        jlabel_descricao_quant.setText(String.valueOf(img.getQuantidade()));
        jlabel_descricao_max.setText(String.valueOf(img.getPixelMax()));
        jlabel_descricao_min.setText(String.valueOf(img.getPixelMin()));
    }
    
    private void atualizarImagemView() {
        if(frame == null) {
            frame = new JFrame();
            panel = new DirectDrawDemo(img.getWidth(), img.getHeight(),img.getGreyScale(), img.getMatriz());
        
            frame.add(panel);
            frame.pack(); 
            //frame.setVisible(true);
            frame.setTitle(img.getNome());
            
            
                Imagem.setVisible(rootPaneCheckingEnabled);
                Imagem.setTitle(img.getNome());                        
                Imagem.setSize(img.getWidth(),img.getHeight());   
            

            //aloca o frame com a imagem ao imagem_loaded
            imagem_loaded.setSize(img.getWidth(),img.getHeight());
            imagem_loaded.add(panel); 
            
            atualizarPropriedades();
            
            
        } else {
            imagem_loaded.removeAll();
            frame = null;
            atualizarImagemView();
        }
        
        
    }
    
    
    private void RelacionamentoComImagem(boolean possui_img) { 
        
        //Arquivos
            jmenu_salvar.setEnabled(possui_img);
            jmenu_salvarcomo.setEnabled(possui_img);
            jmenu_propriedades.setEnabled(possui_img);
            
        //Ferramentas
            jmenu_ferramentas.setEnabled(possui_img);
            
        //Melhorias
            jmenu_melhorias.setEnabled(possui_img);
            
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Imagem = new javax.swing.JInternalFrame();
        imagem_loaded = new javax.swing.JLabel();
        SalvarComo = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jtext_nome_arquivo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Sobre = new javax.swing.JInternalFrame();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Opcao = new javax.swing.JInternalFrame();
        jLabel2 = new javax.swing.JLabel();
        jtext_opcao_local = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jtext_option_nome = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        Adicionar_Remover = new javax.swing.JInternalFrame();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jlabel_addremove_nome = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        ImagemEditada = new javax.swing.JInternalFrame();
        jlabel_imagemeditada_imagem = new javax.swing.JLabel();
        Quantizacao = new javax.swing.JInternalFrame();
        jLabel9 = new javax.swing.JLabel();
        jtext_quatizacao_nivel = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        Propriedades = new javax.swing.JInternalFrame();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jlabel_descricao_nome = new javax.swing.JLabel();
        jlabel_descricao_local = new javax.swing.JLabel();
        jlabel_descricao_altura = new javax.swing.JLabel();
        jlabel_descricao_largura = new javax.swing.JLabel();
        jlabel_descricao_cinza = new javax.swing.JLabel();
        jlabel_descricao_quant = new javax.swing.JLabel();
        jlabel_descricao_max = new javax.swing.JLabel();
        jlabel_descricao_min = new javax.swing.JLabel();
        grafico = new javax.swing.JInternalFrame();
        Filtro = new javax.swing.JInternalFrame();
        jLabel18 = new javax.swing.JLabel();
        jfiltro_selecao = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        jfiltro_loading = new javax.swing.JProgressBar();
        Operadores = new javax.swing.JInternalFrame();
        jLabel19 = new javax.swing.JLabel();
        joperadores_selecao = new javax.swing.JComboBox<>();
        jButton10 = new javax.swing.JButton();
        joperadores_loading = new javax.swing.JProgressBar();
        Realce = new javax.swing.JInternalFrame();
        jLabel20 = new javax.swing.JLabel();
        jrealce_selecao = new javax.swing.JComboBox<>();
        jButton11 = new javax.swing.JButton();
        jrealce_loading = new javax.swing.JProgressBar();
        Limiarizacao = new javax.swing.JInternalFrame();
        jLabel21 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jlimia_loading = new javax.swing.JProgressBar();
        jlimia_T = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmenu_abrir = new javax.swing.JMenuItem();
        jmenu_salvar = new javax.swing.JMenuItem();
        jmenu_salvarcomo = new javax.swing.JMenuItem();
        jmenu_propriedades = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jmenu_ferramentas = new javax.swing.JMenu();
        jmenu_rotacionar_hor = new javax.swing.JMenuItem();
        jmenu_rotacionar_anthor = new javax.swing.JMenuItem();
        jmenu_espelhar_hori = new javax.swing.JMenuItem();
        jmenu_espelhar_vert = new javax.swing.JMenuItem();
        jmenu_interpolar = new javax.swing.JMenuItem();
        jmenu_addRemove = new javax.swing.JMenuItem();
        jmenu_quatizacao = new javax.swing.JMenuItem();
        jmenu_amostragem = new javax.swing.JMenuItem();
        jmenu_melhorias = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmenu_opcao = new javax.swing.JMenuItem();
        jmenu_sobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manipulação de Imagens - PDI");
        setPreferredSize(new java.awt.Dimension(800, 600));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        Imagem.setClosable(true);
        Imagem.setIconifiable(true);
        Imagem.setMaximizable(true);
        Imagem.setResizable(true);
        Imagem.setTitle("Nome da imagem");
        Imagem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Imagem.setVisible(false);
        Imagem.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                ImagemInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        imagem_loaded.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ImagemLayout = new javax.swing.GroupLayout(Imagem.getContentPane());
        Imagem.getContentPane().setLayout(ImagemLayout);
        ImagemLayout.setHorizontalGroup(
            ImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagem_loaded, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ImagemLayout.setVerticalGroup(
            ImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagem_loaded, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(Imagem);
        Imagem.setBounds(0, 0, 440, 290);

        SalvarComo.setClosable(true);
        SalvarComo.setTitle("Salvar Como");
        SalvarComo.setVisible(false);

        jLabel1.setText("Nome do arquivo");

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SalvarComoLayout = new javax.swing.GroupLayout(SalvarComo.getContentPane());
        SalvarComo.getContentPane().setLayout(SalvarComoLayout);
        SalvarComoLayout.setHorizontalGroup(
            SalvarComoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalvarComoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SalvarComoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtext_nome_arquivo)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SalvarComoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(SalvarComoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        SalvarComoLayout.setVerticalGroup(
            SalvarComoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SalvarComoLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtext_nome_arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SalvarComoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(SalvarComo);
        SalvarComo.setBounds(160, 80, 520, 130);

        Sobre.setClosable(true);
        Sobre.setTitle("Sobre");
        Sobre.setVisible(false);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Otávio Voiski");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Software focado em PDI");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText(" Prof. Ana Amelia. ");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Desenvolvido por");

        javax.swing.GroupLayout SobreLayout = new javax.swing.GroupLayout(Sobre.getContentPane());
        Sobre.getContentPane().setLayout(SobreLayout);
        SobreLayout.setHorizontalGroup(
            SobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SobreLayout.setVerticalGroup(
            SobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SobreLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Sobre);
        Sobre.setBounds(280, 90, 290, 160);

        Opcao.setClosable(true);
        Opcao.setTitle("Opções");
        Opcao.setPreferredSize(new java.awt.Dimension(380, 250));
        Opcao.setVisible(false);
        Opcao.getContentPane().setLayout(null);

        jLabel2.setText("Local padrão de abertura / salvamanto de imagens");
        Opcao.getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 11, 340, 14);
        Opcao.getContentPane().add(jtext_opcao_local);
        jtext_opcao_local.setBounds(10, 31, 344, 20);

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Opcao.getContentPane().add(jButton3);
        jButton3.setBounds(260, 130, 90, 23);

        jButton4.setText("Salvar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        Opcao.getContentPane().add(jButton4);
        jButton4.setBounds(170, 130, 80, 23);

        jLabel7.setText("Nome padrão da imagem");
        Opcao.getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 62, 340, 14);
        Opcao.getContentPane().add(jtext_option_nome);
        jtext_option_nome.setBounds(10, 82, 344, 20);

        jLabel26.setForeground(new java.awt.Color(255, 0, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("A abertura automatica está desativada");
        Opcao.getContentPane().add(jLabel26);
        jLabel26.setBounds(30, 110, 300, 14);

        getContentPane().add(Opcao);
        Opcao.setBounds(640, 40, 380, 190);

        Adicionar_Remover.setTitle("Adicionar ou remover");
        Adicionar_Remover.setVisible(false);

        jLabel8.setText("Nome da imagem a ser adicionada ou removida");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Adicionar");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Remover");

        jButton5.setText("Executar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Cancelar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jlabel_addremove_nome.setText("Caminho...");

        jButton7.setText("Procurar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Adicionar_RemoverLayout = new javax.swing.GroupLayout(Adicionar_Remover.getContentPane());
        Adicionar_Remover.getContentPane().setLayout(Adicionar_RemoverLayout);
        Adicionar_RemoverLayout.setHorizontalGroup(
            Adicionar_RemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Adicionar_RemoverLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Adicionar_RemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Adicionar_RemoverLayout.createSequentialGroup()
                        .addComponent(jlabel_addremove_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7))
                    .addGroup(Adicionar_RemoverLayout.createSequentialGroup()
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addGroup(Adicionar_RemoverLayout.createSequentialGroup()
                        .addGroup(Adicionar_RemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jRadioButton1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Adicionar_RemoverLayout.setVerticalGroup(
            Adicionar_RemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Adicionar_RemoverLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Adicionar_RemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel_addremove_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Adicionar_RemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Adicionar_RemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jButton6))
                    .addComponent(jRadioButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Adicionar_Remover);
        Adicionar_Remover.setBounds(350, 70, 360, 170);

        ImagemEditada.setClosable(true);
        ImagemEditada.setIconifiable(true);
        ImagemEditada.setMaximizable(true);
        ImagemEditada.setResizable(true);
        ImagemEditada.setTitle("Imagem editada...");
        ImagemEditada.setVisible(false);

        jlabel_imagemeditada_imagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ImagemEditadaLayout = new javax.swing.GroupLayout(ImagemEditada.getContentPane());
        ImagemEditada.getContentPane().setLayout(ImagemEditadaLayout);
        ImagemEditadaLayout.setHorizontalGroup(
            ImagemEditadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImagemEditadaLayout.createSequentialGroup()
                .addComponent(jlabel_imagemeditada_imagem)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ImagemEditadaLayout.setVerticalGroup(
            ImagemEditadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImagemEditadaLayout.createSequentialGroup()
                .addComponent(jlabel_imagemeditada_imagem)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(ImagemEditada);
        ImagemEditada.setBounds(720, 0, 100, 30);

        Quantizacao.setClosable(true);
        Quantizacao.setTitle("Quantização");
        Quantizacao.setVisible(false);

        jLabel9.setText("Nivel");

        jtext_quatizacao_nivel.setText("2");

        jButton8.setText("Aplicar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout QuantizacaoLayout = new javax.swing.GroupLayout(Quantizacao.getContentPane());
        Quantizacao.getContentPane().setLayout(QuantizacaoLayout);
        QuantizacaoLayout.setHorizontalGroup(
            QuantizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuantizacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtext_quatizacao_nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        QuantizacaoLayout.setVerticalGroup(
            QuantizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuantizacaoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(QuantizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtext_quatizacao_nivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(Quantizacao);
        Quantizacao.setBounds(720, 100, 230, 100);

        Propriedades.setClosable(true);
        Propriedades.setTitle("Propriedades da Imagem");
        Propriedades.setVisible(false);

        jLabel10.setText("Nome:");

        jLabel11.setText("Local:");

        jLabel12.setText("Altura:");

        jLabel13.setText("Largura:");

        jLabel14.setText("Niveis de cinza:");

        jLabel15.setText("Quantidade de Pixels:");

        jLabel16.setText("Pixel Maximo:");

        jLabel17.setText("Pixel Minimo:");

        javax.swing.GroupLayout PropriedadesLayout = new javax.swing.GroupLayout(Propriedades.getContentPane());
        Propriedades.getContentPane().setLayout(PropriedadesLayout);
        PropriedadesLayout.setHorizontalGroup(
            PropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PropriedadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PropriedadesLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlabel_descricao_nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PropriedadesLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlabel_descricao_local, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PropriedadesLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlabel_descricao_altura, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
                    .addGroup(PropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(PropriedadesLayout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jlabel_descricao_cinza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(PropriedadesLayout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jlabel_descricao_quant, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                        .addGroup(PropriedadesLayout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jlabel_descricao_max, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(PropriedadesLayout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jlabel_descricao_min, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(PropriedadesLayout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jlabel_descricao_largura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        PropriedadesLayout.setVerticalGroup(
            PropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PropriedadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jlabel_descricao_nome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jlabel_descricao_local))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jlabel_descricao_altura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jlabel_descricao_largura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jlabel_descricao_cinza))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jlabel_descricao_quant))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jlabel_descricao_max))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jlabel_descricao_min))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Propriedades);
        Propriedades.setBounds(650, 50, 330, 240);

        grafico.setClosable(true);
        grafico.setResizable(true);
        grafico.setMinimumSize(new java.awt.Dimension(400, 400));
        grafico.setNormalBounds(new java.awt.Rectangle(620, 80, 600, 400));
        grafico.setPreferredSize(new java.awt.Dimension(600, 400));
        grafico.setVisible(false);

        javax.swing.GroupLayout graficoLayout = new javax.swing.GroupLayout(grafico.getContentPane());
        grafico.getContentPane().setLayout(graficoLayout);
        graficoLayout.setHorizontalGroup(
            graficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );
        graficoLayout.setVerticalGroup(
            graficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(grafico);
        grafico.setBounds(610, 0, 600, 400);

        Filtro.setClosable(true);
        Filtro.setTitle("Filtros");
        Filtro.setVisible(false);

        jLabel18.setText("Selecione um Filtro");

        jfiltro_selecao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton9.setText("Aplicar");

        javax.swing.GroupLayout FiltroLayout = new javax.swing.GroupLayout(Filtro.getContentPane());
        Filtro.getContentPane().setLayout(FiltroLayout);
        FiltroLayout.setHorizontalGroup(
            FiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FiltroLayout.createSequentialGroup()
                        .addComponent(jfiltro_selecao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9))
                    .addGroup(FiltroLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jfiltro_loading, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
                .addContainerGap())
        );
        FiltroLayout.setVerticalGroup(
            FiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jfiltro_selecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addGap(18, 18, 18)
                .addComponent(jfiltro_loading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(Filtro);
        Filtro.setBounds(870, 0, 330, 130);

        Operadores.setClosable(true);
        Operadores.setTitle("Operadores");
        Operadores.setVisible(false);

        jLabel19.setText("Selecione um Operador");

        joperadores_selecao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sobel", "Prewitt" }));
        joperadores_selecao.setToolTipText("");

        jButton10.setText("Aplicar");

        javax.swing.GroupLayout OperadoresLayout = new javax.swing.GroupLayout(Operadores.getContentPane());
        Operadores.getContentPane().setLayout(OperadoresLayout);
        OperadoresLayout.setHorizontalGroup(
            OperadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OperadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OperadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OperadoresLayout.createSequentialGroup()
                        .addComponent(joperadores_selecao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10))
                    .addGroup(OperadoresLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(joperadores_loading, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
                .addContainerGap())
        );
        OperadoresLayout.setVerticalGroup(
            OperadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OperadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OperadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(joperadores_selecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10))
                .addGap(18, 18, 18)
                .addComponent(joperadores_loading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Operadores);
        Operadores.setBounds(870, 0, 330, 130);

        Realce.setClosable(true);
        Realce.setTitle("Realce");
        Realce.setVisible(false);

        jLabel20.setText("Selecione um Realce");

        jrealce_selecao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Raiz Quadrada", "Logarítmico" }));
        jrealce_selecao.setToolTipText("");

        jButton11.setText("Aplicar");

        javax.swing.GroupLayout RealceLayout = new javax.swing.GroupLayout(Realce.getContentPane());
        Realce.getContentPane().setLayout(RealceLayout);
        RealceLayout.setHorizontalGroup(
            RealceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RealceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RealceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RealceLayout.createSequentialGroup()
                        .addComponent(jrealce_selecao, 0, 223, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11))
                    .addGroup(RealceLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jrealce_loading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        RealceLayout.setVerticalGroup(
            RealceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RealceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RealceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrealce_selecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11))
                .addGap(18, 18, 18)
                .addComponent(jrealce_loading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Realce);
        Realce.setBounds(870, 0, 330, 130);

        Limiarizacao.setClosable(true);
        Limiarizacao.setTitle("Limiarização");
        Limiarizacao.setToolTipText("");
        Limiarizacao.setVisible(false);

        jLabel21.setText("Informe o valor de T");

        jButton12.setText("Aplicar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jlimia_T.setText("1");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("T (");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText(")");

        javax.swing.GroupLayout LimiarizacaoLayout = new javax.swing.GroupLayout(Limiarizacao.getContentPane());
        Limiarizacao.getContentPane().setLayout(LimiarizacaoLayout);
        LimiarizacaoLayout.setHorizontalGroup(
            LimiarizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LimiarizacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LimiarizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LimiarizacaoLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlimia_T)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton12))
                    .addGroup(LimiarizacaoLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jlimia_loading, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
                .addContainerGap())
        );
        LimiarizacaoLayout.setVerticalGroup(
            LimiarizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LimiarizacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LimiarizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jlimia_T, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addComponent(jlimia_loading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(Limiarizacao);
        Limiarizacao.setBounds(870, 0, 330, 130);

        jMenu1.setText("Arquivo");

        jmenu_abrir.setText("Abrir");
        jmenu_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenu_abrirActionPerformed(evt);
            }
        });
        jMenu1.add(jmenu_abrir);
        jmenu_abrir.getAccessibleContext().setAccessibleDescription("");

        jmenu_salvar.setText("Salvar");
        jmenu_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenu_salvarActionPerformed(evt);
            }
        });
        jMenu1.add(jmenu_salvar);

        jmenu_salvarcomo.setText("Salvar Como");
        jmenu_salvarcomo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenu_salvarcomoActionPerformed(evt);
            }
        });
        jMenu1.add(jmenu_salvarcomo);

        jmenu_propriedades.setText("Propriedades");
        jmenu_propriedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenu_propriedadesActionPerformed(evt);
            }
        });
        jMenu1.add(jmenu_propriedades);

        jMenuItem2.setText("Sair");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jmenu_ferramentas.setText("Ferramentas");

        jmenu_rotacionar_hor.setText("Rotacionar 90º (Direita)");
        jmenu_rotacionar_hor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenu_rotacionar_horActionPerformed(evt);
            }
        });
        jmenu_ferramentas.add(jmenu_rotacionar_hor);

        jmenu_rotacionar_anthor.setText("Rotacionar -90º (Esquerda)");
        jmenu_rotacionar_anthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenu_rotacionar_anthorActionPerformed(evt);
            }
        });
        jmenu_ferramentas.add(jmenu_rotacionar_anthor);

        jmenu_espelhar_hori.setText("Espelhar Horizontal");
        jmenu_espelhar_hori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenu_espelhar_horiActionPerformed(evt);
            }
        });
        jmenu_ferramentas.add(jmenu_espelhar_hori);

        jmenu_espelhar_vert.setText("Espelhar Vertical");
        jmenu_espelhar_vert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenu_espelhar_vertActionPerformed(evt);
            }
        });
        jmenu_ferramentas.add(jmenu_espelhar_vert);

        jmenu_interpolar.setText("Interpolar");
        jmenu_interpolar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenu_interpolarActionPerformed(evt);
            }
        });
        jmenu_ferramentas.add(jmenu_interpolar);

        jmenu_addRemove.setText("Adicionar / Remover");
        jmenu_addRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenu_addRemoveActionPerformed(evt);
            }
        });
        jmenu_ferramentas.add(jmenu_addRemove);

        jmenu_quatizacao.setText("Quantização");
        jmenu_quatizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenu_quatizacaoActionPerformed(evt);
            }
        });
        jmenu_ferramentas.add(jmenu_quatizacao);

        jmenu_amostragem.setText("Amostragem");
        jmenu_amostragem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenu_amostragemActionPerformed(evt);
            }
        });
        jmenu_ferramentas.add(jmenu_amostragem);

        jMenuBar1.add(jmenu_ferramentas);

        jmenu_melhorias.setText("Melhorias");

        jMenuItem1.setText("Histograma");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmenu_melhorias.add(jMenuItem1);

        jMenuItem3.setText("Filtros");
        jmenu_melhorias.add(jMenuItem3);

        jMenuItem4.setText("* Realce");
        jmenu_melhorias.add(jMenuItem4);

        jMenuItem5.setText("* Operadores");
        jmenu_melhorias.add(jMenuItem5);

        jMenuItem6.setText("* Limiarização");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jmenu_melhorias.add(jMenuItem6);

        jMenuBar1.add(jmenu_melhorias);

        jMenu3.setText("Outros");

        jmenu_opcao.setText("Opções");
        jmenu_opcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenu_opcaoActionPerformed(evt);
            }
        });
        jMenu3.add(jmenu_opcao);

        jmenu_sobre.setText("Sobre");
        jmenu_sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenu_sobreActionPerformed(evt);
            }
        });
        jMenu3.add(jmenu_sobre);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        getAccessibleContext().setAccessibleDescription("");

        setSize(new java.awt.Dimension(1223, 753));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    
    
    
    
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jmenu_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenu_abrirActionPerformed
        // TODO add your handling code here:        
                
        try {
            //auto select
                //img = new Imagem_model(jtext_opcao_local.getText() + jtext_option_nome.getText(),jtext_option_nome.getText());     
                arquivo_original = OpenFile();
                if(arquivo_original != null){
                    img = new Imagem_model(arquivo_original.getPath(), arquivo_original.getName());

                    atualizarImagemView();                    

                    RelacionamentoComImagem(true);        
                }                
               
        } catch (IOException ex) {
            Logger.getLogger(Main_view.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
    }//GEN-LAST:event_jmenu_abrirActionPerformed

    private void jmenu_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenu_salvarActionPerformed
        // TODO add your handling code here:
        if(img != null)
            img.salvarImagem(img.getLocal());        
    }//GEN-LAST:event_jmenu_salvarActionPerformed

    private void jmenu_salvarcomoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenu_salvarcomoActionPerformed
        // TODO add your handling code here:
        if(img != null) {
            SaveFile();
            //SalvarComo.setVisible(rootPaneCheckingEnabled);
        }
    }//GEN-LAST:event_jmenu_salvarcomoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ImagemInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_ImagemInternalFrameClosed
        // TODO add your handling code here:
        img = null;
        RelacionamentoComImagem(false);
    }//GEN-LAST:event_ImagemInternalFrameClosed

    private void jmenu_sobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenu_sobreActionPerformed
        // TODO add your handling code here:
        Sobre.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jmenu_sobreActionPerformed

    private void jmenu_opcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenu_opcaoActionPerformed
        // TODO add your handling code here:
        Opcao.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jmenu_opcaoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jtext_opcao_local.setText(jtext_opcao_local.getText());
        jtext_option_nome.setText(jtext_option_nome.getText());
        Opcao.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Opcao.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jmenu_addRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenu_addRemoveActionPerformed
        // TODO add your handling code here:
        Adicionar_Remover.setVisible(rootPaneCheckingEnabled);
        jRadioButton1.setSelected(true);
    }//GEN-LAST:event_jmenu_addRemoveActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(arquivo_somarremover_File != null){
            Imagem_model imagem_for_use; 
            try {
                imagem_for_use = new Imagem_model(arquivo_somarremover_File.getPath(),arquivo_somarremover_File.getName());                 
                
                if(jRadioButton1.isSelected()){ //adicionar
                    img.Somar(imagem_for_use.getMatriz(),imagem_for_use.getHeight(),imagem_for_use.getWidth());                    
                                      
                    atualizarImagemView();                    
                }
                
                if(jRadioButton2.isSelected()){ //subtrair
                    img.Subtrair(imagem_for_use.getMatriz(),imagem_for_use.getHeight(),imagem_for_use.getWidth());                    
                                      
                    atualizarImagemView();                    
                }
                
                
                Adicionar_Remover.dispose();

            } catch (IOException ex) {
                Logger.getLogger(Main_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            model.Error.show("Deve selecionar o caminho primeiramente.");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        arquivo_somarremover_File = OpenFile();
        
        jlabel_addremove_nome.setText(arquivo_somarremover_File.getPath());
        atualizarImagemView();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Adicionar_Remover.dispose();
        atualizarImagemView();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jmenu_rotacionar_horActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenu_rotacionar_horActionPerformed
        // TODO add your handling code here:
        img.RotacaoHorario();
        atualizarImagemView();
    }//GEN-LAST:event_jmenu_rotacionar_horActionPerformed

    private void jmenu_rotacionar_anthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenu_rotacionar_anthorActionPerformed
        // TODO add your handling code here:
        img.RotacaoAntiHorario();
        atualizarImagemView();
    }//GEN-LAST:event_jmenu_rotacionar_anthorActionPerformed

    private void jmenu_espelhar_horiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenu_espelhar_horiActionPerformed
        // TODO add your handling code here:
        img.EspelharHorizontal();
        atualizarImagemView();
    }//GEN-LAST:event_jmenu_espelhar_horiActionPerformed

    private void jmenu_espelhar_vertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenu_espelhar_vertActionPerformed
        // TODO add your handling code here:
        img.EspelharVertical();
        atualizarImagemView();
    }//GEN-LAST:event_jmenu_espelhar_vertActionPerformed

    private void jmenu_interpolarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenu_interpolarActionPerformed
        // TODO add your handling code here:
        img.Interpolacao();
        atualizarImagemView();
    }//GEN-LAST:event_jmenu_interpolarActionPerformed

    private void jmenu_quatizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenu_quatizacaoActionPerformed
        // TODO add your handling code here:
        
        Quantizacao.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jmenu_quatizacaoActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Quantizacao.dispose();
        // TODO add your handling code here:
        if(!jtext_quatizacao_nivel.getText().isEmpty()){
            try {                
                img.Quantizacao(Integer.valueOf(jtext_quatizacao_nivel.getText()));
                atualizarImagemView();
            } catch (Exception e) {
                model.Error.show("É aceitavel somente numeros");
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jmenu_propriedadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenu_propriedadesActionPerformed
        // TODO add your handling code here:
        Propriedades.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jmenu_propriedadesActionPerformed

    private void jmenu_amostragemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenu_amostragemActionPerformed
        
    }//GEN-LAST:event_jmenu_amostragemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
                
        Histograma G = new Histograma();   
                
        grafico.setVisible(rootPaneCheckingEnabled);
        grafico.setLayout(new BorderLayout());
        grafico.setSize(new Dimension(600, 400));
        
        /* Grafico de Barras */
        grafico.add(G.criarGraficoBarras(img.Histograma(), img.getNome()));
        
        
        /* Grafico de Histograma */ 
        //grafico.add(G.criarGraficoHistorama(img.Histograma(), img.getNome(), 50, img.getPixelMin(), img.getNiveisCinza()));      

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_O)
            OpenFile(jtext_opcao_local.getText() + jtext_option_nome.getText() , jtext_option_nome.getText());
    }//GEN-LAST:event_formKeyPressed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        Limiarizacao.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        
        jlimia_loading.setValue(0);
        if(!jlimia_T.getText().isEmpty()){
            try {                
                
                img.Limiarizacao(Integer.parseInt(jlimia_T.getText()));
                atualizarImagemView();
                
                jlimia_loading.setValue(100);
            } catch (Exception e) {
                model.Error.show("Falha! favor inserir somente números.");
                
                jlimia_loading.setValue(30);
            }
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame Adicionar_Remover;
    private javax.swing.JInternalFrame Filtro;
    private javax.swing.JInternalFrame Imagem;
    private javax.swing.JInternalFrame ImagemEditada;
    private javax.swing.JInternalFrame Limiarizacao;
    private javax.swing.JInternalFrame Opcao;
    private javax.swing.JInternalFrame Operadores;
    private javax.swing.JInternalFrame Propriedades;
    private javax.swing.JInternalFrame Quantizacao;
    private javax.swing.JInternalFrame Realce;
    private javax.swing.JInternalFrame SalvarComo;
    private javax.swing.JInternalFrame Sobre;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JInternalFrame grafico;
    private javax.swing.JLabel imagem_loaded;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JProgressBar jfiltro_loading;
    private javax.swing.JComboBox<String> jfiltro_selecao;
    private javax.swing.JLabel jlabel_addremove_nome;
    private javax.swing.JLabel jlabel_descricao_altura;
    private javax.swing.JLabel jlabel_descricao_cinza;
    private javax.swing.JLabel jlabel_descricao_largura;
    private javax.swing.JLabel jlabel_descricao_local;
    private javax.swing.JLabel jlabel_descricao_max;
    private javax.swing.JLabel jlabel_descricao_min;
    private javax.swing.JLabel jlabel_descricao_nome;
    private javax.swing.JLabel jlabel_descricao_quant;
    private javax.swing.JLabel jlabel_imagemeditada_imagem;
    private javax.swing.JTextField jlimia_T;
    private javax.swing.JProgressBar jlimia_loading;
    private javax.swing.JMenuItem jmenu_abrir;
    private javax.swing.JMenuItem jmenu_addRemove;
    private javax.swing.JMenuItem jmenu_amostragem;
    private javax.swing.JMenuItem jmenu_espelhar_hori;
    private javax.swing.JMenuItem jmenu_espelhar_vert;
    private javax.swing.JMenu jmenu_ferramentas;
    private javax.swing.JMenuItem jmenu_interpolar;
    private javax.swing.JMenu jmenu_melhorias;
    private javax.swing.JMenuItem jmenu_opcao;
    private javax.swing.JMenuItem jmenu_propriedades;
    private javax.swing.JMenuItem jmenu_quatizacao;
    private javax.swing.JMenuItem jmenu_rotacionar_anthor;
    private javax.swing.JMenuItem jmenu_rotacionar_hor;
    private javax.swing.JMenuItem jmenu_salvar;
    private javax.swing.JMenuItem jmenu_salvarcomo;
    private javax.swing.JMenuItem jmenu_sobre;
    private javax.swing.JProgressBar joperadores_loading;
    private javax.swing.JComboBox<String> joperadores_selecao;
    private javax.swing.JProgressBar jrealce_loading;
    private javax.swing.JComboBox<String> jrealce_selecao;
    private javax.swing.JTextField jtext_nome_arquivo;
    private javax.swing.JTextField jtext_opcao_local;
    private javax.swing.JTextField jtext_option_nome;
    private javax.swing.JTextField jtext_quatizacao_nivel;
    // End of variables declaration//GEN-END:variables

}
