/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.ListFisier;

/**
 *
 * @author user
 */
public class SendFisier {
    private ListFisier lista;
    
    public SendFisier(ListFisier listaFisier){
        lista = listaFisier;
        sendList();
    }
    
    public ListFisier sendList(){
        return lista;
    }
}
