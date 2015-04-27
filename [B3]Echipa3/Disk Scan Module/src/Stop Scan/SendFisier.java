package ip.stop.scan;

import java.util.Vector;

public class SendFisier {

    public ListFisier lista;


  public ListFisier sendList() {
    return lista;
  }
  public SendFisier(ListFisier listaFisier){
        lista = listaFisier;
        sendList();
    }

}