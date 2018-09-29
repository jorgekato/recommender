/**
 * 
 */
package br.com.jkato;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.common.RandomUtils;

/** 
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * TODO Definir documentação da classe. <br>
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 29 de set de 2018 - @author jorge - Primeira versão da classe. <br>
 *<br>
 *<br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

public class Avaliador {

    public static void main ( String[] args ) throws TasteException, IOException {
File file = new File("dados.csv");//cria arquivo
        
        RandomUtils.useTestSeed();

        DataModel model = new FileDataModel( file );//le o modelo
        
        RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
        
        RecommenderBuilder builder = new RecomendadorDeProdutosBuilder();
        double error = evaluator.evaluate( builder , null , model , 0.9 , 1.0 );
        System.out.println( error );
    }

}
