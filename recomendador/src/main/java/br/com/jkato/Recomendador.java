/**
 * 
 */
package br.com.jkato;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;

/**
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * TODO Definir documentação da classe. <br>
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 30 de set de 2018 - @author jorge - Primeira versão da classe. <br>
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

public class Recomendador {

    /**
     * TODO Construtor padrão/alternativo da classe
     */
    public Recomendador () {
        // TODO Auto-generated constructor stub
    }

    /*
     * Método que retorna o modelo de produtos
     */
    public DataModel getModeloProdutos () throws IOException {
        return getModelo( "dados.csv" );

    }

    /*
     * Método que retorna o modelo de cursos
     */
    public DataModel getModeloCursos () throws IOException {
        return getModelo( "cursos2.csv" );

    }

    /**
     * TODO Descrição do Método
     * 
     * @return
     * @throws IOException 
     */
    private FileDataModel getModelo ( String path ) throws IOException {
        File file = new File("src/main/resources/" + path);// cria arquivo
        return  new FileDataModel( file ); // le o modelo
    }

}
