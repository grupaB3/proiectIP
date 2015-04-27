/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ip5;

/**
 *
 * @author user
 */
public class Scan {
    private DiskDetails detaliiDisk;
    private ScanDetails detaliiScan;
    private ListFisier listaFisier;
    private SendFisier sendLista;
    private int status;
    
    public void beginScan(String path){
        setDiskDetails(path);
        setScanDetails();
        listaFisier = new ListFisier();
        changeState();
        notifyStartScan();
        //functionalitatea pentru scanare in care adaug in lista de fisiere cate un fisier nou, alcatuiesc detaliile despre disk cat si cele despre scanare
        sendLista = new SendFisier(listaFisier);
        notifyEndScan();
    }
    
    public void changeState(){
        switch(status){
            case 0:
                this.status = 1;
                break;
            case 1:
                this.status = 0;
                break;
        }
    }
    
    public void endScan(){
        
    }
    
    public void setDiskDetails(String path){
        detaliiDisk = new DiskDetails(path);
    }
    
    public DiskDetails getDiskDetails(){
        return this.detaliiDisk;
    }
    
    public void setScanDetails(){
        detaliiScan = new ScanDetails();
    }
    
    public ScanDetails getScanDetails(){
        return this.detaliiScan;
    }
    
    public int notifyStartScan(){
        return status;
    }
    
    public int notifyEndScan(){
        return status;
    }
}
