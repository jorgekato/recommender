/**
 * 
 */
package br.com.jkato;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

/**
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * TODO Definir documentação da classe. <br>
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 29 de set de 2018 - @author jorge - Primeira versão da classe. <br>
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

public class RecomendadorDeProdutosBuilder implements RecommenderBuilder {

    /**
     * TODO Descrição do Método
     * 
     * @param dataModel
     * @return
     * @throws TasteException
     * @see org.apache.mahout.cf.taste.eval.RecommenderBuilder#buildRecommender(org.apache.mahout.cf.taste.model.DataModel)
     */
    public Recommender buildRecommender ( DataModel model ) throws TasteException {
        
        UserSimilarity similarity = new PearsonCorrelationSimilarity( model );

        UserNeighborhood neighborhood = new ThresholdUserNeighborhood( 0.1 , similarity , model );

        UserBasedRecommender recommender = new GenericUserBasedRecommender( model , neighborhood , similarity );
        return recommender;
    }

}
