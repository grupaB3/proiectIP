package ip.stop.scan;

import java.util.Vector;

public class StopScan  extends Scan implements Interface{

    public Scan scanare;
    public String results;
    public Vector  myListFisier;
    public Vector  myScan;
    public Interface myInterface;
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