package de.htwds.rembrandt.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sFey
 * @version 13.09.2012
 */
public class Photo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
    private Date date;
    private String comment;
    private String path;

//    private ImageIcon thumbnail;
//	private ImageIcon image;
    
    public Photo( String name, Date date, String path, String comment ) {
        // TODO: check if empty/null -> throw Exception
//    	this.image = image;
//    	this.thumbnail = thumbnail;
    	this.name = name;
        this.date = date;
        this.path = path;
        this.comment = comment;
    }
    
    // GETTER
    
    public String getName() {
        return name;
    }
    
    public Date getDate() {
        return date;
    }
    
//    public Icon getImage() {
//        return image;
//    }
//    
//    public Icon getThumbnail() {
//        return thumbnail;
//    }    
    
    public String getComment() {
        return comment;
    }
    
    public String getPath() { return path; }
    
    // FUNCTIONS

    public boolean equals(Object other) {
    	
    	if( other == this ) return true;

    	if( !( other instanceof Photo ) ) return false;
    	   
    	Photo photo = (Photo) other;
    	
    	return this.path.equals( photo.getPath() ); 
    }

	public void setComment(String comment) {
		this.comment = comment;
	}
}
