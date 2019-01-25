package Indir;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;


public class Design extends Prices {

	///Labels
	private JLabel title;
	private JLabel staropramenLabel;
	private JLabel heinekenLabel;
	private JLabel tuborgLabel;
	private JLabel budweiserLabel;
	private JLabel draftBeeLabel;
	
	private JLabel coffeeLabel;
	private JLabel hotChocLabel;
	private JLabel teaLabel;
	private JLabel JackLabel;
	private JLabel Brandy1Label;
	
	
	private JLabel Brandy2Label;
	private JLabel Brandy3Label;
	private JLabel WineGLabel;
	private JLabel WineBLabel;
	private JLabel CocaColaLabel;
	
	
	private JLabel taxLabel;
	
	private JLabel totalabel;
	
	private JLabel dateTime;
	
	private JLabel onlyTime;
	
	
	
	///text fields
	private JTextField staropramenTxt;
	private JTextField heinekenTxt;
	private JTextField tuborgTxt;
	private JTextField budweiserTxt;
	private JTextField draftBeerTxt;
	
	private JTextField coffeeTxt;
	private JTextField ChocoTxt;
	private JTextField teaTxt;
	private JTextField Brandy1Txt;
	private JTextField JackTxt;
	
	private JTextField Brandy2Txt;
	private JTextField Brandy3Txt;
	private JTextField WineBTxt;
	private JTextField WineGTxt;
	private JTextField CocaColaTxt;
	private JTextField totalTxt;
	private JTextField taxTxt;
	
	
	private JButton calculate;
	private JButton clear;
	private JButton getDateCurrentTime;
	private JButton save;
	private JButton view;
	
	
	
	
	Connection connection=null;
	
	public void SaveData(JButton save)
	{
		save.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					
					connection=sqliteConnection.dbConnector();
					
					String query="insert into D (Staropramen,Heineken,Tuborg,Budweiser,DraftBeer,Coffe,HotC,Tea,Jack,BrandyApple,BrandyPlum,BrandyPear,WineG,WineB,Cola,Total,Tax,Date,Time) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";  
					PreparedStatement pst=connection.prepareStatement(query);  
					
					pst.setString(1, staropramenTxt.getText());
					pst.setString(2, heinekenTxt.getText());
					pst.setString(3, tuborgTxt.getText());
					pst.setString(4, budweiserTxt.getText());
					pst.setString(5, draftBeerTxt.getText());
					pst.setString(6, coffeeTxt.getText());
					pst.setString(7, ChocoTxt.getText());
					pst.setString(8, teaTxt.getText());
					pst.setString(9, JackTxt.getText());
					pst.setString(10, Brandy1Txt.getText());
					pst.setString(11, Brandy2Txt.getText());
					pst.setString(12, Brandy3Txt.getText());
					pst.setString(13, WineGTxt.getText());
					pst.setString(14,WineBTxt.getText());
					pst.setString(15, CocaColaTxt.getText());
					pst.setString(16, totalTxt.getText());
					pst.setString(17, taxTxt.getText());
					pst.setString(18,dateTime.getText());
					pst.setString(19, onlyTime.getText());
					
					
					
					pst.execute();  
					
					JOptionPane.showMessageDialog(null, "Data saved");  
					pst.close();  
	
					
				}catch(Exception o) {
					o.printStackTrace();
				}
				
				
			}
			
		});
		
	}
	
	
	

					
			
	
	
	
	
	
	public void closeWindow(JButton view,JFrame frame)
	{
		view.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				SecondWindow ob = new SecondWindow();
				
				
			}
			
		});
	}
	
	
	
	
	
	/*Function that allows only integer data type */
	public void notAllowChar(JTextField field )
	{
	
		field.addKeyListener(new KeyListener()
				{

					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyTyped(KeyEvent e) {
					
						char vchar=e.getKeyChar();
						if(!(Character.isDigit(vchar))
								||vchar==KeyEvent.VK_DELETE
								|| vchar==KeyEvent.VK_BACK_SPACE)
						{
							e.consume();
						}
							
							
						
					}
			
				}
				
				
				
				
				);
			
			
		
		
	}
	
	public void CalculateSumAndTax(
			JButton calc,
			 JTextField staropramenTxt,
			 JTextField heinekenTxt,
			 JTextField tuborgTxt,
			 JTextField budweiserTxt,
			 JTextField draftBeerTxt,
			
			JTextField coffeeTxt,
			 JTextField ChocoTxt,
			 JTextField teaTxt,
			JTextField Brandy1Txt,
			 JTextField JackTxt,
			
			 JTextField Brandy2Txt,
			 JTextField Brandy3Txt,
			 JTextField WineBTxt,
			 JTextField WineGTxt,
			 JTextField CocaColaTxt,
			 JTextField totalTxt,
			 JTextField taxTxt
			)
	{
		calc.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						/*Get quantity for a drink*/
						String getHeineken = heinekenTxt.getText();
						qtyHeineken = Integer.parseInt(getHeineken);
						
						String getStaropramen = staropramenTxt.getText();
						qtyStaropramen = Integer.parseInt(getStaropramen);
						
						String getTuborg = tuborgTxt.getText();
						qtyTuborg = Integer.parseInt(getTuborg);
						
						String getBudweiser = budweiserTxt.getText();
						qtyBudweiser = Integer.parseInt(getBudweiser);
						
						String getBeer = draftBeerTxt.getText();
						qtyBeer = Integer.parseInt(getBeer);
						
						String getCoffe = coffeeTxt.getText();
						qtyCoffee = Integer.parseInt(getCoffe);
						
						String getChoco = ChocoTxt.getText();
						qtyChocholate = Integer.parseInt(getChoco);
						
						String getTea = teaTxt.getText();
						qtyTea = Integer.parseInt(getTea);
						
						String getBrandy1 = Brandy1Txt.getText();
						qtyBrandyA = Integer.parseInt(getBrandy1);
						
						String getJack = JackTxt.getText();
						qtyJdaniels = Integer.parseInt(getJack);
						
						String getBrandy2 = Brandy2Txt.getText();
						qtyBrandyPe = Integer.parseInt(getBrandy2);
						
						String getBrandy3 = Brandy3Txt.getText();
						qtyBrandyPl = Integer.parseInt(getBrandy3);
						
						String getGlass = WineGTxt.getText();
						qtyWineG = Integer.parseInt(getGlass);
						
						String getBottle = WineBTxt.getText();
						qtyBottle = Integer.parseInt(getBottle);
						
						String getCola = CocaColaTxt.getText();
						qtyCola = Integer.parseInt(getCola);
						
						sum =  (qtyStaropramen*staropramen)+(qtyHeineken*heineken)+(qtyTuborg*tuborg)+(qtyBudweiser*budweiser)+(qtyBeer*DraftBeer)
					               +(qtyCoffee*coffee)+(qtyChocholate* hChocholate)+(qtyTea*tea)+(qtyJdaniels*JDaniels)+(qtyBrandyA*BrandyApple)
					               +(qtyBrandyPe*BrandyPear) +(BrandyPlum*qtyBrandyPl)+(qtyWineG*WingeG)+(qtyBottle*WineBottle)+(Cola*qtyCola);
						
					tax = sum*0.17;
					DecimalFormat dc = new DecimalFormat("0.00");
					String SUM = String.valueOf(sum);
					
					totalTxt.setText(SUM+ " KM");
					String TAX = String.valueOf(dc.format(tax));
					taxTxt.setText(TAX+" KM");
					
					
					
					
					}
			
				}
				
				
				
				);
	}
	
	
	public void ClearFields(JButton clear)
	{
		
		clear.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				staropramenTxt.setText("0");
				 heinekenTxt.setText("0");
				 tuborgTxt.setText("0");
				 budweiserTxt.setText("0");
				 draftBeerTxt.setText("0");
				
				 coffeeTxt.setText("0");
				 ChocoTxt.setText("0");
				 teaTxt.setText("0");
				 Brandy1Txt.setText("0");
				 JackTxt.setText("0");
				
				 Brandy2Txt.setText("0");
				 Brandy3Txt.setText("0");
				 WineBTxt.setText("0");
				 WineGTxt.setText("0");
				 CocaColaTxt.setText("0");
				 totalTxt.setText("0");
				 taxTxt.setText("0");
				
			}
			
		}
		
				
				);
	}
	
	
	
	public void setDateTime(JButton getDateCurrentTime)
	{
		getDateCurrentTime.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Date dt = new Date();
				SimpleDateFormat f = new SimpleDateFormat("MM/dd/YY");
				String toString = String.valueOf(f.format(dt));
				dateTime.setText(toString);
				
				SimpleDateFormat f2 = new SimpleDateFormat("hh:mm");
				toString = String.valueOf(f2.format(dt));
				onlyTime.setText(toString);
						
				
				
			}
			
		}
		);
	}
	
	
	
	public Design()
	{
		
		
		
		JFrame frame = new JFrame("Caffe Management System");
		frame.getContentPane().setLayout(null);
		frame.setSize(1000,700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new java.awt.Color(51,153,255));
		
		title = new JLabel();
		title.setText("Caffe Management System");
		title.setSize(310, 310);
		title.setLocation(360, 0);
		title.setFont(title.getFont().deriveFont(20.0f));
		title.setVisible(true);
		
		staropramenLabel = new JLabel("Staropramen");
		staropramenLabel.setSize(100,100);
		staropramenLabel.setLocation(20, 180);
		staropramenLabel.setFont(staropramenLabel.getFont().deriveFont(15.0f));
		
		coffeeLabel = new JLabel("Coffee");
		coffeeLabel.setSize(100,100);
		coffeeLabel.setLocation(300, 180);
		coffeeLabel.setFont(coffeeLabel.getFont().deriveFont(15.0f));
		
		hotChocLabel = new JLabel("Hot Chocholate");
		hotChocLabel.setSize(120,100);
		hotChocLabel.setLocation(300, 220);
		hotChocLabel.setFont(hotChocLabel.getFont().deriveFont(15.0f));
		
		teaLabel = new JLabel("Tea");
		teaLabel.setSize(100,100);
		teaLabel.setLocation(300,260);
		teaLabel.setFont(teaLabel.getFont().deriveFont(15.0f));
		
		JackLabel = new JLabel("Jack Daniels");
		JackLabel.setSize(100,100);
		JackLabel.setLocation(300,300);
		JackLabel.setFont(JackLabel.getFont().deriveFont(15.0f));
		
		Brandy1Label = new JLabel("Brandy(Apple)");
		Brandy1Label.setSize(100,100);
		Brandy1Label.setLocation(300, 340);
		Brandy1Label.setFont(Brandy1Label.getFont().deriveFont(15.0f));
		
		Brandy2Label = new JLabel("Brandy(Plum)");
		Brandy2Label.setSize(100,100);
		Brandy2Label.setLocation(560, 180);
		Brandy2Label.setFont(Brandy2Label.getFont().deriveFont(15.0f));
		
		Brandy3Label = new JLabel("Brandy(Pear)");
		Brandy3Label.setSize(100,100);
		Brandy3Label.setLocation(560, 220);
		Brandy3Label.setFont(Brandy3Label.getFont().deriveFont(15.0f));
		
		 WineGLabel = new JLabel("Wine(Bottle)");
		 WineGLabel.setSize(100,100);
		 WineGLabel.setLocation(560, 260);
		 WineGLabel.setFont( WineGLabel.getFont().deriveFont(15.0f));
		 
		 WineBLabel = new JLabel("Wine(Glass)");
		 WineBLabel.setSize(100,100);
		 WineBLabel.setLocation(560, 300);
		 WineBLabel.setFont( WineBLabel.getFont().deriveFont(15.0f));
		 
		 CocaColaLabel = new JLabel("Coca Cola");
		 CocaColaLabel.setSize(100,100);
		 CocaColaLabel.setLocation(560, 340);
		 CocaColaLabel.setFont( CocaColaLabel.getFont().deriveFont(15.0f));
		
		
		
		
		
		
		
		
		
		
		heinekenLabel = new JLabel("Heineken");
		heinekenLabel.setSize(100,100);
		heinekenLabel.setLocation(20, 220);
		heinekenLabel.setFont(heinekenLabel.getFont().deriveFont(15.0f));
		
		
		tuborgLabel = new JLabel("Tuborg");
		tuborgLabel.setSize(100,100);
		tuborgLabel.setLocation(20, 260);
		tuborgLabel.setFont(tuborgLabel.getFont().deriveFont(15.0f));
		
		budweiserLabel = new JLabel("Budweiser");
		budweiserLabel.setSize(100,100);
		budweiserLabel.setLocation(20, 300);
		budweiserLabel.setFont(budweiserLabel.getFont().deriveFont(15.0f));
		
		draftBeeLabel = new JLabel("Draft beer");
		draftBeeLabel.setSize(100,100);
		draftBeeLabel.setLocation(20, 340);
		draftBeeLabel.setFont(draftBeeLabel.getFont().deriveFont(15.0f));
		
		
		staropramenTxt = new JTextField();
		staropramenTxt.setSize(100,20);
		staropramenTxt.setLocation(160,220);
		
		heinekenTxt = new JTextField();
		heinekenTxt.setSize(100,20);
		heinekenTxt.setLocation(160,260);
		
		tuborgTxt = new JTextField();
		tuborgTxt.setSize(100,20);
		tuborgTxt.setLocation(160,300);
		
		budweiserTxt = new JTextField();
		budweiserTxt.setSize(100,20);
		budweiserTxt.setLocation(160,340);
		
		draftBeerTxt = new JTextField();
		draftBeerTxt.setSize(100,20);
		draftBeerTxt.setLocation(160,380);
		
		coffeeTxt = new JTextField();
		coffeeTxt.setSize(100,20);
		coffeeTxt.setLocation(426,220);
		
		ChocoTxt = new JTextField();
		ChocoTxt.setSize(100,20);
		ChocoTxt.setLocation(426,260);
		
		teaTxt = new JTextField();
		teaTxt.setSize(100,20);
		teaTxt.setLocation(426, 300);
		
		Brandy1Txt = new JTextField();
		Brandy1Txt.setSize(100,20);
		Brandy1Txt.setLocation(426, 380);
		
		Brandy2Txt = new JTextField();
		Brandy2Txt.setSize(100,20);
		Brandy2Txt.setLocation(690, 220);
		
		Brandy3Txt = new JTextField();
		Brandy3Txt.setSize(100,20);
		Brandy3Txt.setLocation(690,260);
		
		
		WineBTxt = new JTextField();
		WineBTxt.setSize(100,20);
		WineBTxt.setLocation(690,300);
		
		WineGTxt = new JTextField();
		WineGTxt.setSize(100,20);
		WineGTxt.setLocation(690,340);
		
		CocaColaTxt = new JTextField();
		CocaColaTxt.setSize(100,20);
		CocaColaTxt.setLocation(690,380);
		
		JackTxt = new JTextField();
		JackTxt.setSize(100,20);
		JackTxt.setLocation(426, 340);
		
		totalabel = new JLabel("Total");
		totalabel.setSize(100,100);
		totalabel.setLocation(850, 180);
		totalabel.setFont(totalabel.getFont().deriveFont(15.0f));
		
		totalTxt = new JTextField();
		totalTxt.setSize(100,20);
		totalTxt.setLocation(850,260);
		
		taxLabel = new JLabel("Tax");
		taxLabel.setSize(100,100);
		taxLabel.setLocation(850, 260);
		taxLabel.setFont(taxLabel.getFont().deriveFont(15.0f));
		
		taxTxt = new JTextField();
		taxTxt.setSize(100,20);
		taxTxt.setLocation(850,340);
		

		
		calculate = new JButton("Calculate");
		calculate.setSize(100,20);
		calculate.setLocation(850, 380);
		
		
		clear = new JButton("Clear");
		clear.setSize(100,20);
		clear.setLocation(850,420);
		
		
		
		
		
		
		getDateCurrentTime = new JButton("Date/Time");
		getDateCurrentTime.setSize(100,20);
		getDateCurrentTime.setLocation(850, 460);
		
		save = new JButton("Save");
		save.setSize(100,20);
		save.setLocation(850,500);
		
		view = new JButton("View table");
		view.setSize(100,20);
		view.setLocation(850,540);
		
		
		dateTime = new JLabel("");
		dateTime.setSize(200,100);
		dateTime.setLocation(860,560);
		dateTime.setFont(dateTime.getFont().deriveFont(15.0f));
		
		onlyTime = new JLabel("");
		onlyTime.setSize(200,100);
		onlyTime.setLocation(870,580);
		onlyTime.setFont(dateTime.getFont().deriveFont(15.0f));
		
		
				
		notAllowChar(staropramenTxt);
		notAllowChar(heinekenTxt);
		notAllowChar(tuborgTxt);
		notAllowChar(budweiserTxt);
		notAllowChar(draftBeerTxt);
		notAllowChar(coffeeTxt);
		notAllowChar(ChocoTxt);
		notAllowChar(teaTxt);
		notAllowChar(Brandy1Txt);
		notAllowChar(JackTxt);
		notAllowChar(Brandy2Txt);
		notAllowChar(Brandy3Txt);
		notAllowChar(WineBTxt);
		notAllowChar(WineGTxt);
		notAllowChar(CocaColaTxt);
		notAllowChar(totalTxt);
		notAllowChar(taxTxt);
		
		
		CalculateSumAndTax(
				calculate,
				 staropramenTxt,
				  heinekenTxt,
				  tuborgTxt,
				budweiserTxt,
				 draftBeerTxt,
				
				 coffeeTxt,
				  ChocoTxt,
				  teaTxt,
				 Brandy1Txt,
				  JackTxt,
				
				 Brandy2Txt,
				 Brandy3Txt,
				  WineBTxt,
				 WineGTxt,
				  CocaColaTxt,
				  totalTxt,
				  taxTxt
				);
		
		
		setDateTime(getDateCurrentTime); /*function with action listener*/
		
		SaveData(save);
		
		ClearFields(clear);
		
		
		closeWindow(view, frame);
		
		
		
		
		
		/*Adding items to frame*/
		frame.getContentPane().add(title);
		frame.getContentPane().add(staropramenLabel);
		frame.getContentPane().add(heinekenLabel);
		frame.getContentPane().add(tuborgLabel);
		frame.getContentPane().add(budweiserLabel);
		frame.getContentPane().add(draftBeeLabel);
		frame.getContentPane().add(staropramenTxt);
        frame.getContentPane().add(heinekenTxt);
        frame.getContentPane().add(tuborgTxt);
        frame.getContentPane().add(budweiserTxt);
        frame.getContentPane().add(draftBeerTxt);
        frame.getContentPane().add(coffeeLabel);
        frame.getContentPane().add(hotChocLabel);
        frame.getContentPane().add(teaLabel);
        frame.getContentPane().add(JackLabel);
        frame.getContentPane().add(Brandy1Label);
        frame.getContentPane().add(coffeeTxt);
        frame.getContentPane().add(ChocoTxt);
        frame.getContentPane().add(teaTxt);
        frame.getContentPane().add(Brandy1Txt);
        frame.getContentPane().add(JackTxt);
        frame.getContentPane().add(Brandy2Label);
        frame.getContentPane().add(Brandy3Label);
        frame.getContentPane().add(WineGLabel);
        frame.getContentPane().add(WineBLabel);
        frame.getContentPane().add(CocaColaLabel);
        frame.getContentPane().add(Brandy2Txt);
        frame.getContentPane().add(Brandy3Txt);
		frame.getContentPane().add(WineBTxt);
		frame.getContentPane().add(WineGTxt);
		frame.getContentPane().add(CocaColaTxt);
		frame.getContentPane().add(totalabel);
		frame.getContentPane().add(totalTxt);
		frame.getContentPane().add(taxLabel);
		frame.getContentPane().add(taxTxt);
		frame.getContentPane().add(clear);
		frame.getContentPane().add(calculate);
		frame.getContentPane().add(getDateCurrentTime);
		frame.getContentPane().add(dateTime);
		frame.getContentPane().add(onlyTime);
		frame.getContentPane().add(save);
		frame.getContentPane().add(view);
		
		frame.setVisible(true);
	}


	
	
	
}
