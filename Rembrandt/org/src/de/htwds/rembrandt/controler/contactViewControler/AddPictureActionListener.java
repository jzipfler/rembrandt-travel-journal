package de.htwds.rembrandt.controler.contactViewControler;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import de.htwds.rembrandt.components.ImageFileView;
import de.htwds.rembrandt.components.ImageFilter;
import de.htwds.rembrandt.components.ImagePreview;
import de.htwds.rembrandt.view.ViewContactDetails;

public class AddPictureActionListener implements ActionListener {

	private ViewContactDetails viewContactDetails;
	
	public AddPictureActionListener( ViewContactDetails viewContactDetails ) {
		this.viewContactDetails = viewContactDetails;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		JFileChooser fileChooser = new JFileChooser();
		
		/*
		 * Enables the fileChooser to display only photo files
		 * and disables the "Show all files" option.
		 */
		fileChooser.setFileFilter( new ImageFilter() );
//		fileChooser.addChoosableFileFilter(new ImageFilter());
		fileChooser.setAcceptAllFileFilterUsed(false);
		
		/*
		 * Set the icon of image files in fileChooser to the specified
		 * images in the ImageFileView class.
		 */
		fileChooser.setFileView(new ImageFileView());
		
		/*
		 * Enables the fileChooser to show an preview of the current selected
		 * image in the fileChooser.
		 */
		fileChooser.setAccessory(new ImagePreview(fileChooser));
		
		int selection = fileChooser.showDialog(viewContactDetails, "Als Kontaktbild setzen");
		
		if ( selection == fileChooser.APPROVE_OPTION ) {
			
//			DEBUG OUTPUT
//			System.out.println(fileChooser.getSelectedFile().getName());
		
			ImageIcon tmpIcon = new ImageIcon( fileChooser.getSelectedFile().getPath() );
	        if (tmpIcon != null) {
	            if (tmpIcon.getIconWidth() > 80) {
	            	ImageIcon btnIcon = new ImageIcon( tmpIcon.getImage().
      													getScaledInstance( 80, -1,
														Image.SCALE_DEFAULT ) );
	                viewContactDetails.getBtnPicture().setIcon( btnIcon );
	            	viewContactDetails.getBtnPicture().setDisabledIcon( btnIcon );
	                viewContactDetails.getBtnPicture().setText(null);
	            } else { //no need to miniaturize
	            	viewContactDetails.getBtnPicture().setIcon( tmpIcon );
	            }
	        }
		}
	}

}