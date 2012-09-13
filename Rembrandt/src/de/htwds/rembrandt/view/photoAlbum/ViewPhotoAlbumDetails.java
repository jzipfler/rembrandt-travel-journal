package de.htwds.rembrandt.view.photoAlbum;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;
import de.htwds.rembrandt.controller.photoAlbumViewController.AddPhotoActionListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.LoadPhotoAlbumOverviewPanelActionListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.PhotoAlbumIOController;
import de.htwds.rembrandt.controller.photoAlbumViewController.RemovePhotoActionListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.SetCurrentPhotoActionListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.ThumbnailMouseListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.toggleEditCommentStatusListener;
import de.htwds.rembrandt.model.Photo;
import de.htwds.rembrandt.model.PhotoAlbumModel;
import de.htwds.rembrandt.view.ViewMain;

/**
 * @author sFey
 * @version 13.09.2012
 */
public class ViewPhotoAlbumDetails extends JPanel {

    // constants
    private static final long serialVersionUID = 1L;
    
        // colors
        private Color COLOR_DISABLED = (Color) UIManager.get("TextField.inactiveBackground");
        private Color COLOR_ENABLED  = (Color) UIManager.get("TextField.background");
        
        // texts
        public static final String COMMENT_BUTTON_EDIT = "bearbeiten";
        public static final String COMMENT_BUTTON_SAVE = "speichern";
    
    // fields
    private PhotoAlbumModel photoAlbumModel;
    private boolean    commentEditable = false;
    private JTextField txtPhotoFileName;
    private JTextField txtPhotoDate;
    private JButton btnPhotoCommentEditToggle;
    private JEditorPane epnPhotoComment;
    private JScrollPane scpThumbnailArea;
    private JScrollPane scpPhotoComment;
    private JLabel lblPhotoComment;
    private JPanel pnlPhotoComment;
    private JLabel lblPhotoDate;
    private JLabel lblPhotoFileName;
    private JPanel pnlPhotoFileNameDate;
    private JPanel pnlPhotoInformation;
    private JLabel lblCurrentPhoto;
    private JPanel pnlCurrentPhoto;
    private JButton btnPhotoForward;
    private JButton btnPhotoBack;
    private JPanel pnlPhotoPreview;
    private JPanel pnlPhotoArea;
    private JLabel lblPhotoAlbumHeader;
    private JPanel pnlHeaderArea;
    private JButton btnAddPhoto;
    private JButton btnRemovePhoto;
    private JPanel pnlHeader;
    private JPanel pnlHeaderNavigation;

	private Container pnlThumbnailArea;
	private JButton btnSwitchToOverview;

	private ViewMain frmMain;
    
	public ViewPhotoAlbumDetails( ViewMain viewMain, Photo photo ) {
		 this( viewMain );
		 populatePhotoArea(photo);
		 photoAlbumModel.setCurrentPhoto(photo);
	 }
	 
	 public ViewPhotoAlbumDetails(ViewMain viewMain) {
		 this();
		 this.frmMain = viewMain; 
		 btnSwitchToOverview.addActionListener(new LoadPhotoAlbumOverviewPanelActionListener( getParentFrame() ));
	 }
	 
	 public ViewMain getParentFrame() {
		 return frmMain;
	 }
	
    // constructor
    public ViewPhotoAlbumDetails() {
        setFont(new Font("Arial", Font.PLAIN, 13));
        setPreferredSize(new Dimension(440, 440));
        setMinimumSize(new Dimension(440, 440));
        setLayout(new BorderLayout(0, 0));
        
        pnlPhotoArea = new JPanel();
        pnlPhotoArea.setFont(new Font("Arial", Font.PLAIN, 13));
        add(pnlPhotoArea, BorderLayout.CENTER);
        pnlPhotoArea.setLayout(new BorderLayout(0, 0));
        
        pnlPhotoPreview = new JPanel();
        pnlPhotoPreview.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlPhotoPreview.setBorder(new LineBorder(Color.GRAY));
        pnlPhotoPreview.setPreferredSize(new Dimension(10, 200));
        pnlPhotoPreview.setMinimumSize(new Dimension(10, 200));
        pnlPhotoArea.add(pnlPhotoPreview, BorderLayout.NORTH);
        pnlPhotoPreview.setLayout(new BorderLayout(0, 0));
        
        btnPhotoBack = new JButton("<");
        btnPhotoBack.addActionListener( new SetCurrentPhotoActionListener( this, false ) );
        btnPhotoBack.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlPhotoPreview.add(btnPhotoBack, BorderLayout.WEST);
        
        btnPhotoForward = new JButton(">");
        btnPhotoForward.addActionListener( new SetCurrentPhotoActionListener( this, true ) );
        btnPhotoForward.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlPhotoPreview.add(btnPhotoForward, BorderLayout.EAST);
        
        pnlCurrentPhoto = new JPanel();
        pnlCurrentPhoto.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlPhotoPreview.add(pnlCurrentPhoto, BorderLayout.CENTER);
        
        lblCurrentPhoto = new JLabel("");
        lblCurrentPhoto.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlCurrentPhoto.add(lblCurrentPhoto);
        
        pnlPhotoInformation = new JPanel();
        pnlPhotoInformation.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlPhotoInformation.setBorder(new LineBorder(Color.GRAY));
        pnlPhotoArea.add(pnlPhotoInformation, BorderLayout.CENTER);
        pnlPhotoInformation.setLayout(new BorderLayout(0, 0));
        
        pnlPhotoFileNameDate = new JPanel();
        pnlPhotoFileNameDate.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlPhotoInformation.add(pnlPhotoFileNameDate, BorderLayout.NORTH);
        pnlPhotoFileNameDate.setLayout(new MigLayout("", "[46px][grow]", "[14px][]"));
        
        lblPhotoFileName = new JLabel("Name");
        lblPhotoFileName.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlPhotoFileNameDate.add(lblPhotoFileName, "cell 0 0,alignx left,aligny top");
        
        txtPhotoFileName = new JTextField();
        txtPhotoFileName.setFont(new Font("Arial", Font.PLAIN, 13));
        txtPhotoFileName.setEditable(false);
        pnlPhotoFileNameDate.add(txtPhotoFileName, "cell 1 0,growx");
        txtPhotoFileName.setColumns(10);
        
        lblPhotoDate = new JLabel("Datum");
        lblPhotoDate.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlPhotoFileNameDate.add(lblPhotoDate, "cell 0 1,alignx left,aligny baseline");
        
        txtPhotoDate = new JTextField();
        txtPhotoDate.setFont(new Font("Arial", Font.PLAIN, 13));
        txtPhotoDate.setEditable(false);
        pnlPhotoFileNameDate.add(txtPhotoDate, "cell 1 1,growx");
        txtPhotoDate.setColumns(10);
        
        pnlPhotoComment = new JPanel();
        pnlPhotoComment.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlPhotoInformation.add(pnlPhotoComment, BorderLayout.CENTER);
        pnlPhotoComment.setLayout(new MigLayout("", "[grow]", "[][grow][]"));
        
        lblPhotoComment = new JLabel("Kommentar");
        lblPhotoComment.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlPhotoComment.add(lblPhotoComment, "cell 0 0");
        
        scpPhotoComment = new JScrollPane();
        scpPhotoComment.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scpPhotoComment.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlPhotoComment.add(scpPhotoComment, "cell 0 1,grow");
        
        epnPhotoComment = new JEditorPane();
        epnPhotoComment.setFont(new Font("Arial", Font.PLAIN, 13));
        epnPhotoComment.setEditable(false);
        epnPhotoComment.setBackground(COLOR_DISABLED);
        scpPhotoComment.setViewportView(epnPhotoComment);
        
        btnPhotoCommentEditToggle = new JButton(COMMENT_BUTTON_EDIT);
        btnPhotoCommentEditToggle.setFont(new Font("Arial", Font.PLAIN, 13));
        btnPhotoCommentEditToggle.addActionListener(new toggleEditCommentStatusListener(this));
        pnlPhotoComment.add(btnPhotoCommentEditToggle, "cell 0 2");
        
        scpThumbnailArea = new JScrollPane();
        scpThumbnailArea.setFont(new Font("Arial", Font.PLAIN, 13));
        scpThumbnailArea.setBorder(new LineBorder(Color.GRAY));
        scpThumbnailArea.setPreferredSize(new Dimension(2, 65));
        add(scpThumbnailArea, BorderLayout.SOUTH);
        
        pnlThumbnailArea = new JPanel();
        pnlThumbnailArea.setFont(new Font("Arial", Font.PLAIN, 13));
        scpThumbnailArea.setViewportView(pnlThumbnailArea);
        
        pnlHeaderArea = new JPanel();
        add(pnlHeaderArea, BorderLayout.NORTH);
        pnlHeaderArea.setLayout(new BorderLayout(0, 0));
        
        pnlHeader = new JPanel();
        FlowLayout fl_pnlHeader = (FlowLayout) pnlHeader.getLayout();
        fl_pnlHeader.setAlignment(FlowLayout.LEFT);
        pnlHeaderArea.add(pnlHeader, BorderLayout.CENTER);
        
        lblPhotoAlbumHeader = new JLabel("Fotoalbum");
        pnlHeader.add(lblPhotoAlbumHeader);
        lblPhotoAlbumHeader.setFont(new Font("Arial", Font.BOLD, 15));
        
        pnlHeaderNavigation = new JPanel();
        pnlHeaderArea.add(pnlHeaderNavigation, BorderLayout.EAST);
        
        btnAddPhoto = new JButton("+");
        btnAddPhoto.addActionListener(new AddPhotoActionListener(this));
        pnlHeaderNavigation.add(btnAddPhoto);
        btnAddPhoto.setFont(new Font("Arial", Font.PLAIN, 13));
        
        btnRemovePhoto = new JButton("-");
        btnRemovePhoto.addActionListener(new RemovePhotoActionListener(this));
        pnlHeaderNavigation.add(btnRemovePhoto);
        btnRemovePhoto.setFont(new Font("Arial", Font.PLAIN, 13));
        
        btnSwitchToOverview = new JButton("Übersicht");
        pnlHeaderNavigation.add(btnSwitchToOverview);
        
    	// init model
    	photoAlbumModel = new PhotoAlbumIOController().load();
    	
    	if(photoAlbumModel != null ) {
    		populatePhotoArea(photoAlbumModel.getPhotoAlbum().getFirst());
    		photoAlbumModel.setCurrentPhoto(photoAlbumModel.getPhotoAlbum().getFirst());
    		populateThumbnailArea(photoAlbumModel.getPhotoAlbum());
    	} else {
    		photoAlbumModel = new PhotoAlbumModel();
    	}        
    }
    
    // # GETTER #
    
    public JLabel getLblCurrentPhoto() {
    	return lblCurrentPhoto;
    }
    
    public PhotoAlbumModel getPhotoAlbumModel() {
    	return photoAlbumModel;
    }
    
    public JTextField getTxtPhotoFileName() {
    	return txtPhotoFileName;
    }
    
    public JTextField getTxtPhotoDate() {
    	return txtPhotoDate;
    }    
    
    public JButton getBtnPhotoCommentEditToggle() {
    	return btnPhotoCommentEditToggle;
    }
    
    public JEditorPane getEpnPhotoComment() {
    	return epnPhotoComment;
    }
    
    
    // # FUNCTIONS #
    
    /**
     * toggles the edit status of the comment textarea
     */
    public void toggleCommmentEditStatus() {
        commentEditable = !commentEditable;
        epnPhotoComment.setEditable(commentEditable);
        
        // toggle color
        if(commentEditable == false) {
        	epnPhotoComment.setBackground(COLOR_DISABLED);
        	btnPhotoCommentEditToggle.setText(COMMENT_BUTTON_EDIT);        	
        } else {
        	epnPhotoComment.setBackground(COLOR_ENABLED);
        	btnPhotoCommentEditToggle.setText(COMMENT_BUTTON_SAVE);
        }
    }
       
    public void clearPhotoArea() {
    	lblCurrentPhoto.setIcon( null );
    	txtPhotoFileName.setText( "" );
    	txtPhotoDate.setText( "" );
    	epnPhotoComment.setText( "" );
    }
    
	public void populatePhotoArea(Photo photo) {
    	lblCurrentPhoto.setIcon( photo.getImage() );

		// determine file name and last modified date
    	File file = new File( photo.getPath() );
    	Date fileDate = new Date( file.lastModified() );
    	String fileName = file.getName();	
    	
    	txtPhotoFileName.setText( fileName );
    	txtPhotoDate.setText( String.valueOf(fileDate) );
    	epnPhotoComment.setText( photo.getComment() );
    }
    
    /**
     * populates the scrollpane
     */
    public void populateThumbnailArea( LinkedList<Photo> photoAlbum ) {
    	pnlThumbnailArea.removeAll();
    	pnlThumbnailArea.validate();
    	pnlThumbnailArea.repaint();

    	for(Photo photo : photoAlbum ) {
    		JLabel lblTemp = new JLabel();
    		lblTemp.setIcon(photo.getThumbnail());
    		lblTemp.addMouseListener( new ThumbnailMouseListener(this) );
    		pnlThumbnailArea.add(lblTemp);
    	}
    	
    	pnlThumbnailArea.validate();
    	pnlThumbnailArea.repaint();    	
    }

}
