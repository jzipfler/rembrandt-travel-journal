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
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;
import de.htwds.rembrandt.controller.photoAlbumViewController.PhotoAlbumDetailsViewAddPhotoActionListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.LoadPhotoAlbumOverviewPanelActionListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.PhotoAlbumDetailsViewResizeListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.PhotoAlbumDetailsViewThumbnailMouseListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.PhotoAlbumDetailsViewRemovePhotoActionListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.PhotoAlbumDetailsViewSetCurrentPhotoActionListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.PhotoAlbumDetailsEditCommentStatusToggleListener;
import de.htwds.rembrandt.model.Photo;
import de.htwds.rembrandt.model.PhotoAlbumModel;
import de.htwds.rembrandt.view.ViewMain;

/**
 * @author sFey
 * @version 16.09.2012
 */
public class ViewPhotoAlbumDetails extends JPanel {

	// constants
	private static final long serialVersionUID = 1L;

	// colors
	private Color COLOR_DISABLED = (Color) UIManager.get("TextField.inactiveBackground");
	private Color COLOR_ENABLED = (Color) UIManager.get("TextField.background");

	// texts
	public static final String COMMENT_BUTTON_EDIT = "bearbeiten";
	public static final String COMMENT_BUTTON_SAVE = "speichern";

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

	public ViewPhotoAlbumDetails(ViewMain viewMain, Photo photo) {
		this(viewMain);
		populatePhotoArea(photo);
		populateThumbnailArea(viewMain.getJourneyModel().getPhotoAlbumModel().getPhotoAlbum());
		viewMain.getJourneyModel().getPhotoAlbumModel().setCurrentPhoto(photo);
	}

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
		setFont(new Font("Arial", Font.PLAIN, 13));
		setPreferredSize(new Dimension(440, 440));
		setMinimumSize(new Dimension(440, 440));
		setLayout(new BorderLayout(0, 0));

		tpPhotoArea = new JTabbedPane(JTabbedPane.TOP);
		add(tpPhotoArea, BorderLayout.CENTER);

		pnlPhotoPreview = new JPanel();
		tpPhotoArea.addTab("Foto", null, pnlPhotoPreview, null);
		pnlPhotoPreview.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlPhotoPreview.setBorder(new LineBorder(Color.GRAY));
		pnlPhotoPreview.setPreferredSize(new Dimension(10, 200));
		pnlPhotoPreview.setMinimumSize(new Dimension(10, 200));
		pnlPhotoPreview.setLayout(new BorderLayout(0, 0));

		btnPhotoBack = new JButton("<");
		btnPhotoBack.addActionListener(new PhotoAlbumDetailsViewSetCurrentPhotoActionListener(this, false));
		btnPhotoBack.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlPhotoPreview.add(btnPhotoBack, BorderLayout.WEST);

		btnPhotoForward = new JButton(">");
		btnPhotoForward.addActionListener(new PhotoAlbumDetailsViewSetCurrentPhotoActionListener(this, true));
		btnPhotoForward.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlPhotoPreview.add(btnPhotoForward, BorderLayout.EAST);

		pnlCurrentPhoto = new JPanel();
		pnlCurrentPhoto.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlPhotoPreview.add(pnlCurrentPhoto, BorderLayout.CENTER);

		lblCurrentPhoto = new JLabel("");
		lblCurrentPhoto.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlCurrentPhoto.add(lblCurrentPhoto);

		pnlPhotoInformation = new JPanel();
		tpPhotoArea.addTab("Informationen", null, pnlPhotoInformation, null);
		pnlPhotoInformation.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlPhotoInformation.setBorder(new LineBorder(Color.GRAY));
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
		btnPhotoCommentEditToggle.addActionListener(new PhotoAlbumDetailsEditCommentStatusToggleListener(this));
		pnlPhotoComment.add(btnPhotoCommentEditToggle, "cell 0 2");

		scpThumbnailArea = new JScrollPane();
		scpThumbnailArea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scpThumbnailArea.setFont(new Font("Arial", Font.PLAIN, 13));
		scpThumbnailArea.setBorder(new LineBorder(Color.GRAY));
		scpThumbnailArea.setPreferredSize(new Dimension(2, 100));
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
		btnAddPhoto.addActionListener(new PhotoAlbumDetailsViewAddPhotoActionListener(this));
		pnlHeaderNavigation.add(btnAddPhoto);
		btnAddPhoto.setFont(new Font("Arial", Font.PLAIN, 13));

		btnRemovePhoto = new JButton("-");
		btnRemovePhoto.addActionListener(new PhotoAlbumDetailsViewRemovePhotoActionListener(this));
		pnlHeaderNavigation.add(btnRemovePhoto);
		btnRemovePhoto.setFont(new Font("Arial", Font.PLAIN, 13));

		btnSwitchToOverview = new JButton("Übersicht");
		pnlHeaderNavigation.add(btnSwitchToOverview);
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

		if (photoAlbumModel == null) {
			photoAlbumModel = new PhotoAlbumModel();
			getParentFrame().getJourneyModel().setPhotoAlbumModel(photoAlbumModel);
		}

		LinkedList<Photo> photoAlbum = photoAlbumModel.getPhotoAlbum();

		if (photoAlbum.size() > 0) {
			populatePhotoArea(photoAlbumModel.getCurrentPhoto());
			populateThumbnailArea(photoAlbum);
		}
	}

	public void clearPhotoArea() {
		lblCurrentPhoto.setIcon(null);
		txtPhotoFileName.setText("");
		txtPhotoDate.setText("");
		epnPhotoComment.setText("");
	}

	public void populatePhotoArea(Photo photo) {

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
	}

	/**
	 * populates the scrollpane
	 */
	public void populateThumbnailArea(LinkedList<Photo> photoAlbum) {
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
		ImageIcon photoIcon = new ImageIcon(currentPhoto.getPath(), currentPhoto.getPath());

		int photoPreviewPanelHeight = (int) pnlCurrentPhoto.getBounds().getSize().getHeight() - 10;

		if (photoIcon.getIconHeight() > photoPreviewPanelHeight && photoPreviewPanelHeight != 0) {
			photoIcon = new ImageIcon(photoIcon.getImage().getScaledInstance(-1, photoPreviewPanelHeight, Image.SCALE_DEFAULT), currentPhoto.getPath());
		}

		lblCurrentPhoto.setIcon(photoIcon);
	}
}