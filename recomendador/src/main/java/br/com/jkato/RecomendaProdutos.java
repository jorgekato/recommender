/**
 * 
 */
package br.com.jkato;

import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

/** 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Classe principal que realiza uma recomendação com base nos dados. <br>
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 29 de set de 2018 - @author jorge - Primeira versão da classe. <br>
 *<br>
 *<br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

public class RecomendaProdutos {
    
    public static void main ( String[] args ) throws IOException, TasteException {
        
        DataModel produtos = new Recomendador().getModeloProdutos();
        
        Recommender recommender = new RecomendadorBuilder().buildRecommender( produtos );
        
        List < RecommendedItem > recommendations = recommender.recommend( 2 , 3 );
        for ( RecommendedItem recommendation : recommendations ) {
            System.out.println( recommendation );
        }
        
    }

}
