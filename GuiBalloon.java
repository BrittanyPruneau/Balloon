package balloon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GuiBalloon extends JFrame
{

	private JPanel contentPane;
	private BalloonPanel leftBalloonPanel;
	private BalloonPanel rightBalloonPanel;
	private JLabel lblEqual;
	private final Random rand = new Random();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					GuiBalloon frame = new GuiBalloon();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiBalloon()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 450);   // THIS IS WHERE YOU CHANGE THE SIZE OF THE WINDOW 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = createLblTitle();
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel displayPanel = createDisplayPanel();
		contentPane.add(displayPanel, BorderLayout.CENTER);   // NEEDED TO CHANGE ORDER BECAUSE WE NEED TO CREATE DISPLAY PANEL FIRST
		
		JPanel controlPanel = createControlPanel();
		contentPane.add(controlPanel, BorderLayout.SOUTH);
		

	}

	private JPanel createDisplayPanel()
	{
		JPanel displayPanel = new JPanel();
		displayPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		displayPanel.setLayout(new GridLayout(1, 0, 10, 0));
		
		leftBalloonPanel = new BalloonPanel(getRandomBalloon());
															// next added baloon properties thorugh the constructor. 
		displayPanel.add(leftBalloonPanel);
		
		rightBalloonPanel = new BalloonPanel(getRandomBalloon());     //here 
		displayPanel.add(rightBalloonPanel);
		return displayPanel;
	}

	private Balloon getRandomBalloon()
	{
		BalloonSize[] allSizes = BalloonSize.values(); 
		int randomIndex = rand.nextInt(allSizes.length);
		BalloonSize randomSize = allSizes[randomIndex];
		BalloonType[] allTypes = BalloonType.values(); 
		randomIndex = rand.nextInt(allTypes.length);
		BalloonType randomType = allTypes[randomIndex];
		return new Balloon(randomSize, randomType);
	}

	private JPanel createControlPanel()
	{
		JPanel controlPanel = new JPanel();
		
		JButton btnNewButton = new JButton("Compare");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				leftBalloonPanel.updateBalloon(getRandomBalloon());
				rightBalloonPanel.updateBalloon(getRandomBalloon());
				
				updateLblEqual();
			}
		});
		controlPanel.add(btnNewButton);
		
		lblEqual = new JLabel();
		updateLblEqual();   /// here its going to set the text based on the values from left and right balloon handle. 
		controlPanel.add(lblEqual);
		return controlPanel;
	}

	private JLabel createLblTitle()
	{
		JLabel lblNewLabel = new JLabel("Balloon Demo");
		lblNewLabel.setBorder(new EmptyBorder(8, 0, 8, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		return lblNewLabel;
	}

	private void updateLblEqual()
	{
		Balloon leftBalloon = leftBalloonPanel.getBalloon();     // once we created the local variable leftBalloonPanel we could then use it her ein the actionPerformed.
		Balloon rightBalloon = rightBalloonPanel.getBalloon();
		if(leftBalloon.equals(rightBalloon))
		{
			lblEqual.setText("EQUAL");
		}
		else
			lblEqual.setText("Not Equal");
	}

}
