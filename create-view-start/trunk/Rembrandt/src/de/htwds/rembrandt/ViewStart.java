package de.htwds.rembrandt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import swing2swt.layout.BoxLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;

public class ViewStart {

	protected Shell shlViewstart;
	private Text txtName;
	private Text txtDestination;
	private Text txtStart;
	private Text txtEnd;
	private Text txtInfo5;
	private Text txtInfo6;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ViewStart window = new ViewStart();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlViewstart.open();
		shlViewstart.layout();
		while (!shlViewstart.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlViewstart = new Shell();
		shlViewstart.setMinimumSize(new Point(440, 440));
		shlViewstart.setSize(450, 300);
		shlViewstart.setText("ViewStart");
		shlViewstart.setLayout(new BorderLayout(0, 0));
		
		Composite cmpLinks = new Composite(shlViewstart, SWT.NONE);
		cmpLinks.setLayoutData(BorderLayout.WEST);
		
		Button btnNewReise = new Button(cmpLinks, SWT.NONE);
		btnNewReise.setBounds(0, 0, 100, 30);
		btnNewReise.setText("Neue Reise");
		
		Button btnShow = new Button(cmpLinks, SWT.NONE);
		btnShow.setBounds(0, 36, 100, 30);
		btnShow.setText("Anzeigen");
		
		Button btnSearch = new Button(cmpLinks, SWT.NONE);
		btnSearch.setBounds(0, 72, 100, 30);
		btnSearch.setText("Suchen");
		
		Composite cmpRechts = new Composite(shlViewstart, SWT.NONE);
		cmpRechts.setLayoutData(BorderLayout.CENTER);
		cmpRechts.setLayout(new FillLayout(SWT.VERTICAL));
		
		List lstReisen = new List(cmpRechts, SWT.BORDER);
		
		Group grpGrpinfo = new Group(cmpRechts, SWT.NONE);
		grpGrpinfo.setText("Reisedetails");
		GridLayout gl_grpGrpinfo = new GridLayout(2, false);
		gl_grpGrpinfo.verticalSpacing = 12;
		grpGrpinfo.setLayout(gl_grpGrpinfo);
		
		CLabel lblName = new CLabel(grpGrpinfo, SWT.NONE);
		GridData gd_lblName = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblName.widthHint = 96;
		lblName.setLayoutData(gd_lblName);
		lblName.setText("Name:");
		
		txtName = new Text(grpGrpinfo, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		CLabel lblDestination = new CLabel(grpGrpinfo, SWT.NONE);
		lblDestination.setText("Ziel:");
		
		txtDestination = new Text(grpGrpinfo, SWT.BORDER);
		txtDestination.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		CLabel lblStart = new CLabel(grpGrpinfo, SWT.NONE);
		lblStart.setText("Beginn:");
		
		txtStart = new Text(grpGrpinfo, SWT.BORDER);
		txtStart.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		CLabel lblEnd = new CLabel(grpGrpinfo, SWT.NONE);
		lblEnd.setText("Ende:");
		
		txtEnd = new Text(grpGrpinfo, SWT.BORDER);
		txtEnd.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		CLabel lblInfo5 = new CLabel(grpGrpinfo, SWT.NONE);
		lblInfo5.setText("Info 5:");
		
		txtInfo5 = new Text(grpGrpinfo, SWT.BORDER);
		txtInfo5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		CLabel lblInfo6 = new CLabel(grpGrpinfo, SWT.NONE);
		lblInfo6.setText("Info 6:");
		
		txtInfo6 = new Text(grpGrpinfo, SWT.BORDER);
		txtInfo6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

	}
}
