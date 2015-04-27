package RestoreFilePackage;

/**
 * Created by lenovo on 4/27/2015.
 */
public class File {

    private String name;
    private String extension;
    private String path;
    private int size;
    private String content;
    private String status;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public File(File f)
    {
        this.name = f.name;
        this.extension = f.extension;
        this.path = f.path;
        this.size = f.size;
        this.content = f.content;
        this.status = f.status;
    }


}
