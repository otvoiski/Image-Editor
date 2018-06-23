/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Otavio
 */
public class Imagem_modelTest {
    
    @Test
    public void testLimiarizacao() {
        String Local = "src/img/";
        //String Nome = "mona_lisa.ascii.pgm";
        //String Nome = "lena.ascii.pgm";
        String Nome = "8x8-8.pgm";
        //String Nome = "4x4-8.pgm";
        
        System.out.println("Limiarizacao");
        int T = 1;
        Imagem_model instance = null;
        try {
            instance = new Imagem_model(Local+Nome, Nome);
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        instance.Limiarizacao();
    }
    
}
