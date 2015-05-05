package Controller;

import Model.Scan;
import java.util.Vector;

public class StopScan  extends Scan{

    public Scan scanare;
    public String results;
    public Vector  myListFisier;
    public Vector  myScan;
    private boolean status;

  public void updateScan(boolean status) {
      if(status==true){
          this.status=false;
      }
  }

  public Scan send_information() {
      return scanare;
  }

}