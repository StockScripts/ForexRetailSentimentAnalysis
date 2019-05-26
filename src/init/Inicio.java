package init;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JSeparator;

public class Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setForeground(Color.DARK_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/resources/favicon.png")));
		setTitle("Forex Retail Sentiment Analysis (FRSA) - SAGAQUANT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEURUSD = new JLabel("EURUSD:    ");
		lblEURUSD.setBounds(30, 110, 213, 14);
		contentPane.add(lblEURUSD);
		
		JLabel lblGBPUSD = new JLabel("GBPUSD:   ");
		lblGBPUSD.setBounds(30, 140, 213, 14);
		contentPane.add(lblGBPUSD);
		
		JLabel lblAUDUSD = new JLabel("AUDUSD:  ");
		lblAUDUSD.setBounds(30, 170, 213, 14);
		contentPane.add(lblAUDUSD);

		JLabel lblNZDUSD = new JLabel("NZDUSD:  ");
		lblNZDUSD.setBounds(30, 200, 213, 14);
		contentPane.add(lblNZDUSD);
		
		JLabel lblUSDJPY = new JLabel("USDJPY:  ");
		lblUSDJPY.setBounds(30, 230, 213, 14);
		contentPane.add(lblUSDJPY);
		
		JLabel lblUSDCAD = new JLabel("USDCAD:  ");
		lblUSDCAD.setBounds(30, 260, 213, 14);
		contentPane.add(lblUSDCAD);	
		
		JLabel lblDAX = new JLabel("DAX30:  ");
		lblDAX.setBounds(30, 290, 213, 14);
		contentPane.add(lblDAX);
		
		JLabel lblSP = new JLabel("SP500:  ");
		lblSP.setBounds(30, 320, 213, 14);
		contentPane.add(lblSP);
		
		JLabel lblOIL = new JLabel("CRUDE OIL:  ");
		lblOIL.setBounds(30, 350, 213, 14);
		contentPane.add(lblOIL);
		
		JLabel lblGOLD = new JLabel("GOLD:  ");
		lblGOLD.setBounds(30, 380, 213, 14);
		contentPane.add(lblGOLD);
		
		JLabel lblForexSentiment = new JLabel("Forex Retail Sentiment Analysis - SAGAQUANT");
		lblForexSentiment.setBounds(20, 11, 368, 14);
		contentPane.add(lblForexSentiment);
		
		JLabel lblUSD = new JLabel("US Dollar:  ");
		lblUSD.setBounds(30, 450, 206, 14);
		contentPane.add(lblUSD);
		
		JLabel lblEuro = new JLabel("Euro:");
		lblEuro.setBounds(260, 450, 214, 14);
		contentPane.add(lblEuro);
				
		JButton btnLoadRefresh = new JButton("Load - Refresh");
		btnLoadRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Data data = new Data();
				boolean set = data.data();
				if(set==true) {
					
					lblEURUSD.setText("EURUSD - Long: " + String.valueOf(data.getEURUSD()) 
					+ "% Short: " + String.valueOf(100-data.getEURUSD())+"%" );
					lblGBPUSD.setText("GBPUSD - Long: " + String.valueOf(data.getGBPUSD()) 
					+ "% Short: " + String.valueOf(100-data.getGBPUSD())+"%" );
					lblAUDUSD.setText("AUDUSD - Long: " + String.valueOf(data.getAUDUSD()) 
					+ "% Short: " + String.valueOf(100-data.getAUDUSD())+"%" );
					lblNZDUSD.setText("NZDUSD - Long: " + String.valueOf(data.getNZDUSD()) 
					+ "% Short: " + String.valueOf(100-data.getNZDUSD())+"%" );
					lblUSDJPY.setText("USDJPY - Long: " + String.valueOf(data.getUSDJPY()) 
					+ "% Short: " + String.valueOf(100-data.getUSDJPY())+"%" );
					lblDAX.setText("DAX30 - Long: " + String.valueOf(data.getDAX()) 
					+ "% Short: " + String.valueOf(100-data.getDAX())+"%" );
					lblSP.setText("SP500 - Long: " + String.valueOf(data.getSP()) 
					+ "% Short: " + String.valueOf(100-data.getSP())+"%" );
					lblOIL.setText("CRUDE OIL - Long: " + String.valueOf(data.getOIL()) 
					+ "% Short: " + String.valueOf(100-data.getOIL())+"%" );
					lblGOLD.setText("GOLD - Long: " + String.valueOf(data.getGOLD()) 
					+ "% Short: " + String.valueOf(100-data.getGOLD())+"%" );
					lblUSDCAD.setText("USDCAD - Long: " + String.valueOf(data.getUSDCAD()) 
					+ "% Short: " + String.valueOf(100-data.getUSDCAD())+"%" );
					int USDShort = (data.getEURUSD() + data.getAUDUSD() + data.getGBPUSD() + data.getNZDUSD()
					+ (100-data.getUSDJPY()) + (100-data.getUSDCAD()))/6;
					lblUSD.setText("US Dollar - Long: " + String.valueOf(USDShort) 
					+ "% Short: " + String.valueOf(100-USDShort)+"%" );
					int EURShort = ( data.getEURUSD() + data.getEURAUD() + data.getEURCHF() + data.getEURGBP() ) / 4;
					lblEuro.setText("Euro - Long: " + String.valueOf(EURShort) 
					+ "% Short: " + String.valueOf(100-EURShort)+"%" );
				}
			}
		});
		btnLoadRefresh.setBounds(20, 36, 122, 23);
		contentPane.add(btnLoadRefresh);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
				
			}
		});
		btnNewButton.setBounds(154, 36, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblFxPairs = new JLabel("FX Pairs:");
		lblFxPairs.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFxPairs.setBounds(20, 82, 89, 14);
		contentPane.add(lblFxPairs);
		
		JLabel lblCurrency = new JLabel("Currencies:");
		lblCurrency.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCurrency.setBounds(20, 420, 122, 14);
		contentPane.add(lblCurrency);
		
		JLabel lblOnceYouClick = new JLabel("Once you click on \"Load - Refresh\" wait a few seconds until data appears");
		lblOnceYouClick.setBounds(20, 500, 454, 14);
		contentPane.add(lblOnceYouClick);
		
		JLabel lblAllDataIs = new JLabel("All data is scraped from Myfxbook's Web and provided \"as is\" for educational purposes");
		lblAllDataIs.setBounds(20, 525, 525, 14);
		contentPane.add(lblAllDataIs);
		
		JLabel lblDevelopedBySagaquant = new JLabel("Developed by SAGAQUANT - 2019 - sagaquant.com");
		lblDevelopedBySagaquant.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblDevelopedBySagaquant.setBounds(20, 550, 380, 14);
		contentPane.add(lblDevelopedBySagaquant);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 69, 564, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 477, 564, 2);
		contentPane.add(separator_1);
		


		


	}
}
