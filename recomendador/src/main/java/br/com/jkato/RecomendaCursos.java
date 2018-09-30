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
 * TODO Definir documentação da classe. <br>
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 30 de set de 2018 - @author jorge - Primeira versão da classe. <br>
 *<br>
 *<br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

public class RecomendaCursos {

    public static void main ( String[] args ) throws IOException, TasteException {
        
        DataModel cursos = new Recomendador().getModeloCursos();
        
        Recommender recommender = new RecomendadorBuilder().buildRecommender( cursos );
        
        List < RecommendedItem > recommendations = recommender.recommend( 15 , 10 );//(usuarioID, qtd de recomendações)
        for ( RecommendedItem recommendation : recommendations ) {
            System.out.println( recommendation );
        }
    }
}
