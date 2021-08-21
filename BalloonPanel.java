package balloon;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import java.awt.Color;
import java.awt.Font;

public class BalloonPanel extends JPanel
{
	private Balloon balloon;  // CREATED A PRIVATE BALLOON    WE NOW initialize it IN THE CONSTRUCTOR 
	private JLabel lblBalloon;
	private JLabel lblType;
	/**
	 * Creates a panel that displays an image corresponsing to the size of the balloon
	 * and a label that displays whether the balloon is filled with helium or air. 
	 */
	public BalloonPanel(Balloon balloon)
	{
		this.balloon = balloon;		// initialized here 
		
		setLayout(new BorderLayout(0, 0));
		
		lblBalloon = createLabelBalloon();
		add(lblBalloon, BorderLayout.CENTER);
		
		lblType = createLabelType();
		add(lblType, BorderLayout.SOUTH);
	}
	
	/**
	 * @return the balloon
	 */
	public Balloon getBalloon()        /// added this so we could get a new balloon, randomly. 
	{
		return balloon;
	}
	
	public void updateBalloon(Balloon balloon)
	{
		this.balloon = balloon;    // every time we update balloon. 
		lblBalloon.setIcon(getBalloonIcon());      // here want to create a field lblBalloon 
		
		lblType.setText(balloon.getType().toString());			//ALSO MADE THIS A FIELD	/that way can access it and update it every time. 
	}


	private JLabel createLabelType()
	{
		JLabel lblType = new JLabel(balloon.getType().toString()); // here we sent in the type of balloon, helium or air as the toString method we created. 
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		return lblType;
	}

	private JLabel createLabelBalloon()
	{
		JLabel lblBalloon = new JLabel("");
		lblBalloon.setBackground(Color.WHITE);
		lblBalloon.setOpaque(true);
		lblBalloon.setIcon(getBalloonIcon());    // remember we did this. 
		lblBalloon.setHorizontalAlignment(SwingConstants.CENTER);
		return lblBalloon;
	}

	private Icon getBalloonIcon()
	{
		String imagePath;
		switch(balloon.getSize())
		{
		case XS:
			imagePath = "/balloon/Images/balloon20.jpg"; 
			break; 
		case S: 
			imagePath = "/balloon/Images/balloon40.jpg"; 
			break;
		case M: 
			imagePath = "/balloon/Images/balloon60.jpg"; 
			break;
		case L: 
			imagePath = "/balloon/Images/balloon80.jpg"; 
			break;
		case XL: 
			imagePath = "/balloon/Images/balloon100.jpg"; 
			break;
		default:
			imagePath = null; 
			break;
		}
		
		return new ImageIcon(BalloonPanel.class.getResource(imagePath)); 
		
	}

}
