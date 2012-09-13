package de.htwds.rembrandt.view.photoAlbum;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import de.htwds.rembrandt.controller.photoAlbumViewController.PhotoAlbumIOController;
import de.htwds.rembrandt.controller.photoAlbumViewController.PhotoAlbumResizeListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.PhotoMouseListener;
import de.htwds.rembrandt.model.Photo;
import de.htwds.rembrandt.model.PhotoAlbumModel;
import de.htwds.rembrandt.view.ViewMain;

/**
 * @author sFey
 * @version 13.09.2012
 */
public class ViewPhotoAlbumOverview extends JPanel {

    private static final long serialVersionUID = 1L;
	private ViewMain frmMain;
	private PhotoAlbumModel photoAlbumModel;
	private LinkedList<Photo> photoAlbum;
	private JPanel pnlPhotoArea;

    public ViewPhotoAlbumOverview() {
        setLayout(new BorderLayout(0, 0));
        
        JPanel pnlHeaderArea = new JPanel();
        add(pnlHeaderArea, BorderLayout.NORTH);
        pnlHeaderArea.setLayout(new BorderLayout(0, 0));
        
        JPanel pnlHeader = new JPanel();
        FlowLayout fl_pnlHeader = (FlowLayout) pnlHeader.getLayout();
        fl_pnlHeader.setAlignment(FlowLayout.LEFT);
        pnlHeaderArea.add(pnlHeader, BorderLayout.CENTER);
        
        JLabel lblPhotoAlbumHeader = new JLabel("Fotoalbum");
        pnlHeader.add(lblPhotoAlbumHeader);
        lblPhotoAlbumHeader.setFont(new Font("Arial", Font.BOLD, 15));
        
        JPanel pnlHeaderNavigation = new JPanel();
        pnlHeaderArea.add(pnlHeaderNavigation, BorderLayout.EAST);
        
        JScrollPane scpPhotoArea = new JScrollPane();
        add(scpPhotoArea, BorderLayout.CENTER);
        
        pnlPhotoArea = new JPanel();
        pnlPhotoArea.setPreferredSize(new Dimension(440, 10));
        pnlPhotoArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        scpPhotoArea.setViewportView(pnlPhotoArea);
        pnlPhotoArea.setLayout(new GridLayout(0, 1, 2, 2));
      
    	// init model
    	photoAlbumModel = new PhotoAlbumIOController().load();
    	
    	if(photoAlbumModel != null ) {
    		populatePhotoArea();
    	} else {
    		photoAlbumModel = new PhotoAlbumModel();
    	}   
    	
    	this.addComponentListener(new PhotoAlbumResizeListener(this));
    }

	public ViewPhotoAlbumOverview(ViewMain viewMain) {
		this();
		this.frmMain = viewMain;
	}

	public ViewMain getParentFrame() {
		return frmMain;
	}
	
	
	public void populatePhotoArea() {
		photoAlbum = photoAlbumModel.getPhotoAlbum();
		
		pnlPhotoArea.removeAll();
		pnlPhotoArea.validate();
		pnlPhotoArea.repaint();

    	for(Photo photo : photoAlbum ) {
    		JLabel lblTemp = new JLabel();
    		lblTemp.setIcon(photo.getImage());
    		lblTemp.addMouseListener( new PhotoMouseListener(this) );
    		pnlPhotoArea.add(lblTemp);
    	}
    	
    	pnlPhotoArea.validate();
    	pnlPhotoArea.repaint();   
	}
	
	public JPanel getPnlPhotoArea() {
		return pnlPhotoArea;
	}
	
	public void adjustPhotoArea() {
		int numCols = (int)(Math.ceil( this.getWidth() / 250.0f ));
		pnlPhotoArea.setLayout(new GridLayout(0, numCols, 2, 2));
	}

	public PhotoAlbumModel getPhotoAlbumModel() {
		return photoAlbumModel;
	}
	
	
}
