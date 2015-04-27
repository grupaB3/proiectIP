package ip.stop.scan;
import java.util.Vector;

public class File {

  public String name;
  public String extension;
  public String path;
  public Integer size;
  public String content;
  public String status;

  public void setName( String name) {
      this.name=name;
  }

  public String getName() {
  return name;
  }

  public void setExtension( String extension) {
      this.extension = extension;
  }

  public String getExtension() {
      return extension;
  }

  public void setPath( String path) {
      this.path=path;
  }

  public void setSize( Integer size) {
      this.size=size;
  }

  public int getSize() {
      return size;
  }

  public void setContent( String content) {
      this.content=content;
  }

  public String getContent() {
      return content;
  }

  public void setStatus( String status) {
      this.status=status;
  }

  public String getStatus() {
     return status;
  }

}