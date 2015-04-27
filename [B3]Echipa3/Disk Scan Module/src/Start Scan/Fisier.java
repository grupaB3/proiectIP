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
public class Fisier {
    private String name;
    private String extension;
    private String path;
    private Integer size;
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
    
    public Integer getSize() {
    	return size;
    }
    
    public void setSize(Integer size) {
    	this.size = size;
    }
    
    public String getContent() {
    	return content;
    }
    
    public void setContent(String content) {
    	this.content = content;
    }
    
    public String getStatus() {
    	return status;
    }
    
    public void setStatus(String status) {
    	this.status = status;
    }
}
