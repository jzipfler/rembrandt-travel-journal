package de.htwds.rembrandt.view.photoAlbum;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;
import de.htwds.rembrandt.controller.photoAlbumViewController.LoadPhotoAlbumOverviewPanelActionListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.PhotoAlbumDetailsEditCommentStatusToggleListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.PhotoAlbumDetailsViewAddPhotoActionListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.PhotoAlbumDetailsViewRemovePhotoActionListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.PhotoAlbumDetailsViewResizeListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.PhotoAlbumDetailsViewSetCurrentPhotoActionListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.PhotoAlbumDetailsViewSlideShowTimerListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.PhotoAlbumDetailsViewThumbnailMouseListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.PhotoAlbumDetailsViewToggleSlideShowListener;
import de.htwds.rembrandt.model.Photo;
import de.htwds.rembrandt.model.PhotoAlbumModel;
import de.htwds.rembrandt.view.ViewMain;

/**
 * @author sFey
 * @version 17.09.2012
 */
public class ViewPhotoAlbumDetails extends JPanel {

	// constants
	private static final long serialVersionUID = 1L;
	
	private static final int SLIDE_SHOW_TIMER_INTERVAL = 2000;

	// colors
	private Color COLOR_DISABLED = (Color) UIManager.get(Messages.getString("ViewPhotoAlbumDetails.0")); //$NON-NLS-1$
	private Color COLOR_ENABLED = (Color) UIManager.get(Messages.getString("ViewPhotoAlbumDetails.1")); //$NON-NLS-1$

	// texts
	public static final String COMMENT_BUTTON_EDIT = Messages.getString("ViewPhotoAlbumDetails.2"); //$NON-NLS-1$
	public static final String COMMENT_BUTTON_SAVE = Messages.getString("ViewPhotoAlbumDetails.3"); //$NON-NLS-1$

	// fields
	private boolean commentEditable = false;
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
	private JLabel lblPhotoAlbumHeader;
	private JPanel pnlHeaderArea;
	private JButton btnAddPhoto;
	private JButton btnRemovePhoto;
	private JPanel pnlHeader;
	private JPanel pnlHeaderNavigation;

	private Container pnlThumbnailArea;
	private JButton btnSwitchToOverview;

	private ViewMain frmMain;
	private JTabbedPane tpPhotoArea;
	private JCheckBox chckbxSlideShow;

	private Timer timer;

	public ViewPhotoAlbumDetails(ViewMain viewMain) {
		this();
		this.frmMain = viewMain;
		btnSwitchToOverview.addActionListener(new LoadPhotoAlbumOverviewPanelActionListener(getParentFrame()));
		pnlPhotoPreview.addComponentListener(new PhotoAlbumDetailsViewResizeListener(this));
	}

	public ViewMain getParentFrame() {
		return frmMain;
	}

	// constructor
	public ViewPhotoAlbumDetails() {
		setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.4"), Font.PLAIN, 13)); //$NON-NLS-1$
		setPreferredSize(new Dimension(440, 440));
		setMinimumSize(new Dimension(440, 440));
		setLayout(new BorderLayout(0, 0));

		tpPhotoArea = new JTabbedPane(SwingConstants.TOP);
		add(tpPhotoArea, BorderLayout.CENTER);

		pnlPhotoPreview = new JPanel();
		tpPhotoArea.addTab(Messages.getString("ViewPhotoAlbumDetails.5"), null, pnlPhotoPreview, null); //$NON-NLS-1$
		pnlPhotoPreview.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.6"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlPhotoPreview.setBorder(new LineBorder(Color.GRAY));
		pnlPhotoPreview.setPreferredSize(new Dimension(10, 200));
		pnlPhotoPreview.setMinimumSize(new Dimension(10, 200));
		pnlPhotoPreview.setLayout(new BorderLayout(0, 0));

		btnPhotoBack = new JButton(Messages.getString("ViewPhotoAlbumDetails.7")); //$NON-NLS-1$
		btnPhotoBack.addActionListener(new PhotoAlbumDetailsViewSetCurrentPhotoActionListener(this, false));
		btnPhotoBack.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.8"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlPhotoPreview.add(btnPhotoBack, BorderLayout.WEST);

		btnPhotoForward = new JButton(Messages.getString("ViewPhotoAlbumDetails.9")); //$NON-NLS-1$
		btnPhotoForward.addActionListener(new PhotoAlbumDetailsViewSetCurrentPhotoActionListener(this, true));
		btnPhotoForward.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.10"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlPhotoPreview.add(btnPhotoForward, BorderLayout.EAST);

		pnlCurrentPhoto = new JPanel();
		pnlCurrentPhoto.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.11"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlPhotoPreview.add(pnlCurrentPhoto, BorderLayout.CENTER);

		lblCurrentPhoto = new JLabel(Messages.getString("ViewPhotoAlbumDetails.12")); //$NON-NLS-1$
		lblCurrentPhoto.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.13"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlCurrentPhoto.add(lblCurrentPhoto);

		pnlPhotoInformation = new JPanel();
		tpPhotoArea.addTab(Messages.getString("ViewPhotoAlbumDetails.14"), null, pnlPhotoInformation, null); //$NON-NLS-1$
		pnlPhotoInformation.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.15"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlPhotoInformation.setBorder(new LineBorder(Color.GRAY));
		pnlPhotoInformation.setLayout(new BorderLayout(0, 0));

		pnlPhotoFileNameDate = new JPanel();
		pnlPhotoFileNameDate.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.16"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlPhotoInformation.add(pnlPhotoFileNameDate, BorderLayout.NORTH);
		pnlPhotoFileNameDate.setLayout(new MigLayout(Messages.getString("ViewPhotoAlbumDetails.17"), Messages.getString("ViewPhotoAlbumDetails.18"), Messages.getString("ViewPhotoAlbumDetails.19"))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		lblPhotoFileName = new JLabel(Messages.getString("ViewPhotoAlbumDetails.20")); //$NON-NLS-1$
		lblPhotoFileName.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.21"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlPhotoFileNameDate.add(lblPhotoFileName, Messages.getString("ViewPhotoAlbumDetails.22")); //$NON-NLS-1$

		txtPhotoFileName = new JTextField();
		txtPhotoFileName.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.23"), Font.PLAIN, 13)); //$NON-NLS-1$
		txtPhotoFileName.setEditable(false);
		pnlPhotoFileNameDate.add(txtPhotoFileName, Messages.getString("ViewPhotoAlbumDetails.24")); //$NON-NLS-1$
		txtPhotoFileName.setColumns(10);

		lblPhotoDate = new JLabel(Messages.getString("ViewPhotoAlbumDetails.25")); //$NON-NLS-1$
		lblPhotoDate.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.26"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlPhotoFileNameDate.add(lblPhotoDate, Messages.getString("ViewPhotoAlbumDetails.27")); //$NON-NLS-1$

		txtPhotoDate = new JTextField();
		txtPhotoDate.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.28"), Font.PLAIN, 13)); //$NON-NLS-1$
		txtPhotoDate.setEditable(false);
		pnlPhotoFileNameDate.add(txtPhotoDate, Messages.getString("ViewPhotoAlbumDetails.29")); //$NON-NLS-1$
		txtPhotoDate.setColumns(10);

		pnlPhotoComment = new JPanel();
		pnlPhotoComment.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.30"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlPhotoInformation.add(pnlPhotoComment, BorderLayout.CENTER);
		pnlPhotoComment.setLayout(new MigLayout(Messages.getString("ViewPhotoAlbumDetails.31"), Messages.getString("ViewPhotoAlbumDetails.32"), Messages.getString("ViewPhotoAlbumDetails.33"))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		lblPhotoComment = new JLabel(Messages.getString("ViewPhotoAlbumDetails.34")); //$NON-NLS-1$
		lblPhotoComment.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.35"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlPhotoComment.add(lblPhotoComment, Messages.getString("ViewPhotoAlbumDetails.36")); //$NON-NLS-1$

		scpPhotoComment = new JScrollPane();
		scpPhotoComment.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scpPhotoComment.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.37"), Font.PLAIN, 13)); //$NON-NLS-1$
		pnlPhotoComment.add(scpPhotoComment, Messages.getString("ViewPhotoAlbumDetails.38")); //$NON-NLS-1$

		epnPhotoComment = new JEditorPane();
		epnPhotoComment.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.39"), Font.PLAIN, 13)); //$NON-NLS-1$
		epnPhotoComment.setEditable(false);
		epnPhotoComment.setBackground(COLOR_DISABLED);
		scpPhotoComment.setViewportView(epnPhotoComment);

		btnPhotoCommentEditToggle = new JButton(COMMENT_BUTTON_EDIT);
		btnPhotoCommentEditToggle.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.40"), Font.PLAIN, 13)); //$NON-NLS-1$
		btnPhotoCommentEditToggle.addActionListener(new PhotoAlbumDetailsEditCommentStatusToggleListener(this));
		pnlPhotoComment.add(btnPhotoCommentEditToggle, Messages.getString("ViewPhotoAlbumDetails.41")); //$NON-NLS-1$

		scpThumbnailArea = new JScrollPane();
		scpThumbnailArea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scpThumbnailArea.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.42"), Font.PLAIN, 13)); //$NON-NLS-1$
		scpThumbnailArea.setBorder(new LineBorder(Color.GRAY));
		scpThumbnailArea.setPreferredSize(new Dimension(2, 100));
		add(scpThumbnailArea, BorderLayout.SOUTH);

		pnlThumbnailArea = new JPanel();
		pnlThumbnailArea.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.43"), Font.PLAIN, 13)); //$NON-NLS-1$
		scpThumbnailArea.setViewportView(pnlThumbnailArea);

		pnlHeaderArea = new JPanel();
		add(pnlHeaderArea, BorderLayout.NORTH);
		pnlHeaderArea.setLayout(new BorderLayout(0, 0));

		pnlHeader = new JPanel();
		FlowLayout fl_pnlHeader = (FlowLayout) pnlHeader.getLayout();
		fl_pnlHeader.setAlignment(FlowLayout.LEFT);
		pnlHeaderArea.add(pnlHeader, BorderLayout.CENTER);

		lblPhotoAlbumHeader = new JLabel(Messages.getString("ViewPhotoAlbumDetails.44")); //$NON-NLS-1$
		pnlHeader.add(lblPhotoAlbumHeader);
		lblPhotoAlbumHeader.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.45"), Font.BOLD, 15)); //$NON-NLS-1$

		pnlHeaderNavigation = new JPanel();
		pnlHeaderArea.add(pnlHeaderNavigation, BorderLayout.EAST);

		btnAddPhoto = new JButton(Messages.getString("ViewPhotoAlbumDetails.46")); //$NON-NLS-1$
		btnAddPhoto.addActionListener(new PhotoAlbumDetailsViewAddPhotoActionListener(this));
		
		chckbxSlideShow = new JCheckBox(Messages.getString("ViewPhotoAlbumDetails.47")); //$NON-NLS-1$
		chckbxSlideShow.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.48"), Font.PLAIN, 13)); //$NON-NLS-1$
		chckbxSlideShow.addActionListener(new PhotoAlbumDetailsViewToggleSlideShowListener(this));
		
		
		pnlHeaderNavigation.add(chckbxSlideShow);
		pnlHeaderNavigation.add(btnAddPhoto);
		btnAddPhoto.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.49"), Font.PLAIN, 13)); //$NON-NLS-1$

		btnRemovePhoto = new JButton(Messages.getString("ViewPhotoAlbumDetails.50")); //$NON-NLS-1$
		btnRemovePhoto.addActionListener(new PhotoAlbumDetailsViewRemovePhotoActionListener(this));
		pnlHeaderNavigation.add(btnRemovePhoto);
		btnRemovePhoto.setFont(new Font(Messages.getString("ViewPhotoAlbumDetails.51"), Font.PLAIN, 13)); //$NON-NLS-1$

		btnSwitchToOverview = new JButton(Messages.getString("ViewPhotoAlbumDetails.52")); //$NON-NLS-1$
		pnlHeaderNavigation.add(btnSwitchToOverview);
		
		this.timer = new Timer(SLIDE_SHOW_TIMER_INTERVAL, new PhotoAlbumDetailsViewSlideShowTimerListener(this));
	}

	// # GETTER #

	public JLabel getLblCurrentPhoto() {
		return lblCurrentPhoto;
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
		if (commentEditable == false) {
			epnPhotoComment.setBackground(COLOR_DISABLED);
			btnPhotoCommentEditToggle.setText(COMMENT_BUTTON_EDIT);
		} else {
			epnPhotoComment.setBackground(COLOR_ENABLED);
			btnPhotoCommentEditToggle.setText(COMMENT_BUTTON_SAVE);
		}
	}

	public void populate() {
		PhotoAlbumModel photoAlbumModel = this.getParentFrame().getJourneyModel().getPhotoAlbumModel();

		// if there is not yet a photoAlbumModel create and set one
		if (photoAlbumModel == null) {
			photoAlbumModel = new PhotoAlbumModel();
			getParentFrame().getJourneyModel().setPhotoAlbumModel(photoAlbumModel);
		}

		populatePhotoArea();
		populateThumbnailArea();
	}

	public void populatePhotoArea() {

		Photo photo = this.getParentFrame().getJourneyModel().getPhotoAlbumModel().getCurrentPhoto();
		
		if( photo == null ) {
			lblCurrentPhoto.setIcon(null);
			txtPhotoFileName.setText(Messages.getString("ViewPhotoAlbumDetails.53")); //$NON-NLS-1$
			txtPhotoDate.setText(Messages.getString("ViewPhotoAlbumDetails.54")); //$NON-NLS-1$
			epnPhotoComment.setText(Messages.getString("ViewPhotoAlbumDetails.55")); //$NON-NLS-1$
		} else {
			ImageIcon photoIcon = new ImageIcon(photo.getPath(), photo.getPath());
			lblCurrentPhoto.setIcon(photoIcon);
			adjustPhotoArea();
	
			// determine file name and last modified date
			File file = new File(photo.getPath());
			Date fileDate = new Date(file.lastModified());
			String fileName = file.getName();
	
			txtPhotoFileName.setText(fileName);
			txtPhotoDate.setText(String.valueOf(fileDate));
			epnPhotoComment.setText(photo.getComment());
			
			// activate first tab
			this.tpPhotoArea.setSelectedIndex(0);		
		}
		
		toggleUIElementsEnabledState();
	}
	
	public void toggleUIElementsEnabledState() {
		
		Photo photo = this.getParentFrame().getJourneyModel().getPhotoAlbumModel().getCurrentPhoto();
		LinkedList<Photo> photoAlbum = this.getParentFrame().getJourneyModel().getPhotoAlbumModel().getPhotoAlbum();

		if( photoAlbum.size() == 0 ) {
			// photoAlbum is empty disable some of the UI elements
			this.btnPhotoBack.setEnabled(false);
			this.btnPhotoForward.setEnabled(false);
			this.btnSwitchToOverview.setEnabled(false);
			this.btnRemovePhoto.setEnabled(false);
			this.chckbxSlideShow.setEnabled(false);
		} else {
			// slide show with only 1 photo does not make sense
			if( photoAlbum.size() == 1 ) this.chckbxSlideShow.setEnabled(false);
			if( photoAlbum.size() > 1 )  this.chckbxSlideShow.setEnabled(true);
			
			// photoAlbum is not empty reenable the UI elements
			this.btnSwitchToOverview.setEnabled(true);
			this.btnRemovePhoto.setEnabled(true);
			this.btnPhotoBack.setEnabled(true);
			this.btnPhotoForward.setEnabled(true);
			
			
			// first photo in the list disable the back-button
			if( photoAlbum.getFirst().equals(photo) ) this.btnPhotoBack.setEnabled(false);
			
			// last photo in the list disable the forward-button
			if( photoAlbum.getLast().equals(photo) ) this.btnPhotoForward.setEnabled(false);
		}
	}

	public void populateThumbnailArea() {
		LinkedList<Photo> photoAlbum = this.getParentFrame().getJourneyModel().getPhotoAlbumModel().getPhotoAlbum();
		
		pnlThumbnailArea.removeAll();
		pnlThumbnailArea.validate();
		pnlThumbnailArea.repaint();

		for (Photo photo : photoAlbum) {
			JLabel lblTemp = new JLabel();

			// create thumbnailIcon
			ImageIcon thumbnailIcon = new ImageIcon(photo.getPath(), photo.getPath());
			thumbnailIcon = new ImageIcon(thumbnailIcon.getImage().getScaledInstance(-1, 70, Image.SCALE_DEFAULT), photo.getPath());
			lblTemp.setIcon(thumbnailIcon);

			lblTemp.addMouseListener(new PhotoAlbumDetailsViewThumbnailMouseListener(this));
			pnlThumbnailArea.add(lblTemp);
		}

		pnlThumbnailArea.validate();
		pnlThumbnailArea.repaint();
	}

	public void adjustPhotoArea() {
		Photo currentPhoto = getParentFrame().getJourneyModel().getPhotoAlbumModel().getCurrentPhoto();
		
		// photoAlbum not empty?
		if( currentPhoto != null ) {
			ImageIcon photoIcon = new ImageIcon(currentPhoto.getPath(), currentPhoto.getPath());
	
			// resize if icon height is bigger than the panel height
			int photoPreviewPanelHeight = (int) pnlCurrentPhoto.getBounds().getSize().getHeight() - 10;
				if (photoIcon.getIconHeight() > photoPreviewPanelHeight && photoPreviewPanelHeight != 0) {
				photoIcon = new ImageIcon(photoIcon.getImage().getScaledInstance(-1, photoPreviewPanelHeight, Image.SCALE_DEFAULT), currentPhoto.getPath());
			}
	
			// resize if the icon width is bigger than the lanel width
			int photoPreviewPanelWidth = (int) pnlCurrentPhoto.getBounds().getSize().getWidth();
			if( photoIcon.getIconWidth() >  photoPreviewPanelWidth && photoPreviewPanelWidth != 0)  {
				photoIcon = new ImageIcon(photoIcon.getImage().getScaledInstance(photoPreviewPanelWidth, -1, Image.SCALE_DEFAULT), currentPhoto.getPath());
			}
			
			lblCurrentPhoto.setIcon(photoIcon);
		}
	}

	public void toggleSlideShow() {
		if( this.chckbxSlideShow.isSelected() ) {
			timer.start();
		} else {
			timer.stop();
		}
	}
}