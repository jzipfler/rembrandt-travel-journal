package de.htwds.rembrandt.model;

import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Photo {

    private String name;
    private Date date;
    private ImageIcon icon;
    private String comment;
    
    public Photo( String name, Date date, String path, String comment ) {
        // TODO: check if empty/null -> throw Exception
        this.name = name;
        this.date = date;
        this.icon = new ImageIcon(path);
        this.comment = comment;
    }
    
    // GETTER
    
    public String getName() {
        return name;
    }
    
    public Date getDate() {
        return date;
    }
    
    public Icon getIcon() {
        return icon;
    }
    
    public String getComment() {
        return comment;
    }
    
}
