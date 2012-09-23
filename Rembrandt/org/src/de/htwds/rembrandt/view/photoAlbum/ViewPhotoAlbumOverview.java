package de.htwds.rembrandt.view.photoAlbum;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import de.htwds.rembrandt.controller.photoAlbumViewController.PhotoAlbumOverviewViewMouseListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.PhotoAlbumOverviewViewResizeListener;
import de.htwds.rembrandt.controller.photoAlbumViewController.ReturnToPhotoAlbumDetailsViewActionListener;
import de.htwds.rembrandt.model.Photo;
import de.htwds.rembrandt.model.PhotoAlbumModel;
import de.htwds.rembrandt.view.ViewMain;

/**
 * @author sFey
 * @version 17.09.2012
 */
public class ViewPhotoAlbumOverview extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private ViewMain frmMain;
	private JPanel pnlPhotoArea;
	private JButton btnSwitchToDetails;
	private LinkedList<JLabel> labelList;

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

		btnSwitchToDetails = new JButton("zurück");
		pnlHeaderNavigation.add(btnSwitchToDetails);

		JScrollPane scpPhotoArea = new JScrollPane();
		add(scpPhotoArea, BorderLayout.CENTER);

		pnlPhotoArea = new JPanel();
		pnlPhotoArea.setPreferredSize(new Dimension(440, 10));
		pnlPhotoArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scpPhotoArea.setViewportView(pnlPhotoArea);
		pnlPhotoArea.setLayout(new GridLayout(0, 1, 2, 2));

		this.addComponentListener(new PhotoAlbumOverviewViewResizeListener(this));
		btnSwitchToDetails.addActionListener(new ReturnToPhotoAlbumDetailsViewActionListener(this));
		
		// init labelList
		labelList = new LinkedList<JLabel>();
	}

	public ViewPhotoAlbumOverview(ViewMain viewMain) {
		this();
		this.frmMain = viewMain;
	}

	public ViewMain getParentFrame() {
		return frmMain;
	}

	public void populate() {
		PhotoAlbumModel photoAlbumModel = this.getParentFrame().getJourneyModel().getPhotoAlbumModel();

		// should never happen, just in case ...
		if (photoAlbumModel == null) {
			photoAlbumModel = new PhotoAlbumModel();
			getParentFrame().getJourneyModel().setPhotoAlbumModel(photoAlbumModel);
		}

		// add photo thumbnails to the overview
		if (photoAlbumModel.getPhotoAlbum().size() > 0) populatePhotoArea();
	}

	public void populatePhotoArea() {
		pnlPhotoArea.removeAll();
		pnlPhotoArea.validate();
		pnlPhotoArea.repaint();

		// add the photos to the panel
		LinkedList<Photo> photoAlbum = this.getParentFrame().getJourneyModel().getPhotoAlbumModel().getPhotoAlbum();
		JLabel lblTemp = null;
		ImageIcon currentIcon;
		
		for (Photo currentPhoto : photoAlbum ) {
			// create new icon
			currentIcon = new ImageIcon(currentPhoto.getPath(), currentPhoto.getPath());
			
			// create new label
			lblTemp = new JLabel();
			lblTemp.setIcon(currentIcon);
			lblTemp.addMouseListener(new PhotoAlbumOverviewViewMouseListener(this));
			lblTemp.setVerticalAlignment(JLabel.TOP);
			
			pnlPhotoArea.add(lblTemp);
			// add label to the list so we can iterate that list later to resize the icons
			labelList.add(lblTemp);
		}

		pnlPhotoArea.validate();
		pnlPhotoArea.repaint();
	}

	public void adjustPhotoArea() {
		// get number of cols and rows we need
		int numPhotos = this.getParentFrame().getJourneyModel().getPhotoAlbumModel().getPhotoAlbum().size();
		int numCols = (int) Math.ceil( Math.sqrt(numPhotos) );
		int numRows = (int) Math.ceil( (double)numPhotos / (double)numCols );
		
		// update the layout
		pnlPhotoArea.setLayout(new GridLayout(numRows, numCols, 2, 2));
		
		String currentPath;
		ImageIcon currentIcon;
		
		for (JLabel currentLabel : labelList) {
			// get path of current Label
			currentPath = ((ImageIcon) currentLabel.getIcon()).getDescription();

			// resize icon to fit the gridWidth
			int gridWidth = pnlPhotoArea.getWidth()/numCols;
			currentIcon = new ImageIcon(currentPath, currentPath);
			currentIcon = new ImageIcon( currentIcon.getImage().getScaledInstance(gridWidth, -1, Image.SCALE_DEFAULT), currentPath);

			// resize if the height of the grid is lower than the height of the icon
			int gridHeight = pnlPhotoArea.getHeight() / numRows;
			if( gridHeight < currentIcon.getIconHeight() ) {
				currentIcon = new ImageIcon( currentIcon.getImage().getScaledInstance(-1, gridHeight, Image.SCALE_DEFAULT), currentPath);
			}
			currentLabel.setIcon(currentIcon);
		}
	}
}