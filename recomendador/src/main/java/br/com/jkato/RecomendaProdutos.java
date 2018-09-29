/**
 * 
 */
package br.com.jkato;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

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
        
        File file = new File("dados.csv");//cria arquivo
        
        DataModel model = new FileDataModel( file );//le o modelo
        
        UserSimilarity similarity =  new PearsonCorrelationSimilarity( model );
        
        UserNeighborhood neighborhood = new ThresholdUserNeighborhood( 0.1 ,similarity, model );
        
        UserBasedRecommender recommender = new GenericUserBasedRecommender( model , neighborhood , similarity );
        
        List < RecommendedItem > recommendations = recommender.recommend( 2 , 3 );
        for ( RecommendedItem recommendation : recommendations ) {
            System.out.println( recommendation );
        }
        
    }

}
