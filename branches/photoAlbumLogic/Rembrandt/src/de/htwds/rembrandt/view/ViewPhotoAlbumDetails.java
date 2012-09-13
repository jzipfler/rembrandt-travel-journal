package de.htwds.rembrandt.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

import net.miginfocom.swing.MigLayout;
import de.htwds.rembrandt.controller.photoAlbumViewController.toggleEditCommentStatusListener;

/**
 * Photo Album View
 * Details
 * 
 * @author sFey
 */
public class ViewPhotoAlbumDetails extends JPanel {

    // constants
    private static final long serialVersionUID = 1L;
    
        // colors
        private Color COLOR_DISABLED = (Color) UIManager.get("TextField.inactiveBackground");
        private Color COLOR_ENABLED  = (Color) UIManager.get("TextField.background");
    
    // fields
    private boolean    commentEditable = false;
    private JTextField txtPhotoFileName;
    private JTextField txtPhotoDate;
    private JButton btnPhotoCommentEditToggle;
    private JTextComponent epnPhotoComment;
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
    
    // constructor
    public ViewPhotoAlbumDetails() {
        setFont(new Font("Arial", Font.PLAIN, 13));
        setPreferredSize(new Dimension(440, 440));
        setMinimumSize(new Dimension(440, 440));
        setLayout(new BorderLayout(0, 0));
        
        lblPhotoAlbumHeader = new JLabel("Fotoalbum");
        lblPhotoAlbumHeader.setFont(new Font("Arial", Font.BOLD, 15));
        add(lblPhotoAlbumHeader, BorderLayout.NORTH);
        
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
        btnPhotoBack.setFont(new Font("Arial", Font.PLAIN, 13));
        pnlPhotoPreview.add(btnPhotoBack, BorderLayout.WEST);
        
        btnPhotoForward = new JButton(">");
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
        
        btnPhotoCommentEditToggle = new JButton("bearbeiten");
        btnPhotoCommentEditToggle.setFont(new Font("Arial", Font.PLAIN, 13));
        btnPhotoCommentEditToggle.addActionListener(new toggleEditCommentStatusListener(this));
        pnlPhotoComment.add(btnPhotoCommentEditToggle, "cell 0 2");
        
        scpThumbnailArea = new JScrollPane();
        scpThumbnailArea.setFont(new Font("Arial", Font.PLAIN, 13));
        scpThumbnailArea.setBorder(new LineBorder(Color.GRAY));
        scpThumbnailArea.setPreferredSize(new Dimension(2, 65));
        add(scpThumbnailArea, BorderLayout.SOUTH);
        
        JPanel pnlThumbnailArea = new JPanel();
        pnlThumbnailArea.setFont(new Font("Arial", Font.PLAIN, 13));
        scpThumbnailArea.setViewportView(pnlThumbnailArea);
    }
    
    /**
     * toggles the edit status of the comment textarea
     */
    public void toggleCommmentEditStatus() {
        commentEditable = !commentEditable;
        epnPhotoComment.setEditable(commentEditable);
        
        // toggle color
        if(commentEditable == false) epnPhotoComment.setBackground(COLOR_DISABLED);
        else epnPhotoComment.setBackground(COLOR_ENABLED);
    }
}
