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
 * @version 13.09.2012
 */
public class ViewPhotoAlbumOverview extends JPanel {

	private static final long serialVersionUID = 1L;
	private ViewMain frmMain;
	private PhotoAlbumModel photoAlbumModel;
	private LinkedList<Photo> photoAlbum;
	private JPanel pnlPhotoArea;
	private JButton btnSwitchToDetails;

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
	}

	public ViewPhotoAlbumOverview(ViewMain viewMain) {
		this();
		this.frmMain = viewMain;
	}

	public ViewMain getParentFrame() {
		return frmMain;
	}

	public void populate() {
		photoAlbumModel = this.getParentFrame().getJourneyModel().getPhotoAlbumModel();

		// should never happen, just in case ...
		if (photoAlbumModel == null) {
			photoAlbumModel = new PhotoAlbumModel();
			getParentFrame().getJourneyModel().setPhotoAlbumModel(photoAlbumModel);
		}

		LinkedList<Photo> photoAlbum = photoAlbumModel.getPhotoAlbum();

		if (photoAlbum.size() > 0) {
			populatePhotoArea();
		}
	}

	public void populatePhotoArea() {
		photoAlbum = photoAlbumModel.getPhotoAlbum();

		pnlPhotoArea.removeAll();
		pnlPhotoArea.validate();
		pnlPhotoArea.repaint();

		for (Photo photo : photoAlbum) {
			JLabel lblTemp = new JLabel();

			ImageIcon photoIcon = new ImageIcon(photo.getPath(), photo.getPath());
			if (photoIcon.getIconHeight() > 185) {
				photoIcon = new ImageIcon(photoIcon.getImage().getScaledInstance(-1, 185, Image.SCALE_DEFAULT), photo.getPath());
			}
			lblTemp.setIcon(photoIcon);

			lblTemp.addMouseListener(new PhotoAlbumOverviewViewMouseListener(this));
			lblTemp.setVerticalAlignment(JLabel.TOP);
			pnlPhotoArea.add(lblTemp);
		}

		pnlPhotoArea.validate();
		pnlPhotoArea.repaint();
	}

	public JPanel getPnlPhotoArea() {
		return pnlPhotoArea;
	}

	public void adjustPhotoArea() {
		int numCols = (int) (Math.ceil(this.getWidth() / 250.0f));
		int numRows = (int) (Math.ceil(this.getHeight() / 180.0f));
		
		pnlPhotoArea.setLayout(new GridLayout(numRows, numCols, 2, 2));
	}

	public PhotoAlbumModel getPhotoAlbumModel() {
		return photoAlbumModel;
	}

}
