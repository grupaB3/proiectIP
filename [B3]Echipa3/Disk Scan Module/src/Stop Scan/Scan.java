package ip.stop.scan;
import java.util.Vector;

public class Scan {

    private DiskDetails detaliiDisk;
    private ScanDetails detaliiScan;
    public Boolean status;
    public Vector  myStopScan;
    public StopScan Scan ;
    public short notify=0;

  public void beginScan() {
      this.status=true;
  }

  public void endScan() {
      this.status=false;
  }

  public void setDiskDetails( DiskDetails detaliiDisk) {
      this.detaliiDisk=detaliiDisk;
  }

  public DiskDetails getDiskDetails( DiskDetails detaliiDisk) {
      return detaliiDisk;
  }

  public void setScanDetails( ScanDetails detaliiScan) {
      this.detaliiScan=detaliiScan;
  }

  public ScanDetails getScanDetails( ScanDetails detaliiScan) {
      return detaliiScan;
  }

  public void notifyStartScan(short notify) {
      this.notify=1;
  }

  public void notifyEndScan(short notify) {
      this.notify=0;
  }

}