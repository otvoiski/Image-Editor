/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Dimension;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;

/**
 *
 * @author Otavio
 */
public class Histograma {

    public Boolean DEBUG = false;

    private CategoryDataset createDatasetBar(double[] dados) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < dados.length; i++) {
            dataset.addValue(dados[i], "Histograma", "" + dados[i]);            
        }

        if (DEBUG && dataset == null) {
            System.out.println("Dataset está vazio!");
        }

        return dataset;
    }
    private CategoryDataset createDatasetBar(ArrayList<Double> dados) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < dados.size(); i++) {
            dataset.addValue(dados.get(i), "1", "2");
            if (DEBUG) {
                System.out.println(dados.get(i));
            }
        }

        if (DEBUG && dataset == null) {
            System.out.println("Dataset está vazio!");
        }

        return dataset;
    }
    private JFreeChart criarBarChart(CategoryDataset dataset, String nome) {
        JFreeChart graficoBarras = ChartFactory.createBarChart("Histograma - " + nome, "Pixel", "Cinza", dataset, PlotOrientation.VERTICAL, false, false, false);
        if (DEBUG && graficoBarras == null) {
            System.out.println("graficoBarras está vazio!");
        }
        return graficoBarras;
    }
    public ChartPanel criarGraficoBarras(ArrayList<Double> dados, String nome) {
        CategoryDataset dataset = this.createDatasetBar(dados);
        
        JFreeChart grafico = this.criarBarChart(dataset, nome);
        
        ChartPanel painelGrafico = new ChartPanel(grafico);
        
        painelGrafico.setPreferredSize(new Dimension(400, 400));
        
        if (DEBUG && painelGrafico == null) {
            System.out.println("painelGrafico está vazio!");
        }
        
        return painelGrafico;
    }
    public ChartPanel criarGraficoBarras(double[] dados, String nome) {
        CategoryDataset dataset = this.createDatasetBar(dados);
        
        JFreeChart grafico = this.criarBarChart(dataset, nome);
        
        ChartPanel painelGrafico = new ChartPanel(grafico);
        
        painelGrafico.setPreferredSize(new Dimension(600, 400));
        
        if (DEBUG && painelGrafico == null) {
            System.out.println("painelGrafico está vazio!");
        }
        
        return painelGrafico;
    }

    private HistogramDataset createDatasetHistograma(double[] dados, int numero, int grey){        
        HistogramDataset dataset = new HistogramDataset();
        dataset.setType(HistogramType.FREQUENCY);
        
        dataset.addSeries("Histogram", dados, numero,0,grey);
        
        return dataset;
    }
    private HistogramDataset createDatasetHistograma(ArrayList<Double> dados, int numero,int grey){        
        HistogramDataset dataset = new HistogramDataset();
        dataset.setType(HistogramType.RELATIVE_FREQUENCY);
        
        double[] values = new double[dados.size()];
        for (int i = 0; i < dados.size(); i++) {
            values[i] = dados.get(i);
        }
        dataset.addSeries("Histogram", values, numero,0.0,(double)grey);
        
        return dataset;
    }
    private JFreeChart criarHistograma(HistogramDataset dataset, String nome) {
        String plotTitle = nome;
        String yaxis = "Cinza";
        String xaxis = "Píxel";
        PlotOrientation orientation = PlotOrientation.VERTICAL;
        
        boolean show = false;
        boolean toolTips = false;
        boolean urls = false;
        
        JFreeChart chart = ChartFactory.createHistogram(plotTitle, xaxis, yaxis,dataset, orientation, show, toolTips, urls);        
        return chart;
    }
    public ChartPanel criarGraficoHistorama(ArrayList<Double> dados, String nome, int numero,int grey) {
        HistogramDataset dataset = this.createDatasetHistograma(dados, numero, grey);
        
        JFreeChart grafico = this.criarHistograma(dataset, nome);
        
        ChartPanel painelGrafico = new ChartPanel(grafico);
        
        painelGrafico.setPreferredSize(new Dimension(600, 400));
        
        if (DEBUG && painelGrafico == null) {
            System.out.println("painelGrafico está vazio!");
        }
        
        return painelGrafico;
    }
    public ChartPanel criarGraficoHistorama(double[] dados, String nome, int numero, int grey) {
        HistogramDataset dataset = this.createDatasetHistograma(dados, numero, grey);
        
        JFreeChart grafico = this.criarHistograma(dataset, nome);
        
        ChartPanel painelGrafico = new ChartPanel(grafico);
        
        painelGrafico.setPreferredSize(new Dimension(600, 400));
        
        if (DEBUG && painelGrafico == null) {
            System.out.println("painelGrafico está vazio!");
        }
        
        return painelGrafico;
    }
}
