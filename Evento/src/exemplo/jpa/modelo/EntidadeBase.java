/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.jpa.modelo;

/**
 *
 * Interface apenas com o intuito de ter o método getId que será usado no DAO Genérico
 * 
 * @author samuel
 */


public interface EntidadeBase {
    public Long getId();
//    public Serializable getId();
}
