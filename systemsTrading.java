import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JApplet;
import javax.swing.JOptionPane;

import java.io.*;
import java.util.StringTokenizer;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.lang.Math;

/*Parth Patil
 * Copyright Parth Patil don't * with me
 * IGP ENTERPRISES
 *
 * Up to date till December 2010
 *
 * add xyaxis for percentage change graph
 *
 * add histogram for trade consistency
 *
 * balance run a portfolio for historical data
 * subtract transaction costs/minimize transactions you're not rich
 */
public class systemsTrading extends JApplet implements
KeyListener,MouseListener, MouseMotionListener{

	private static final long serialVersionUID = 1L;
	Graphics bufferGraphics;
	Image offscreen;
	boolean flag = false;
	public int gOX = 100, gOY = 100, gLength = 700, gHeight = 500;
	int mX,mY;
	int screenWidth = 1280, screenHeight = 720;
	graphInfo globalTmpGraphInfo;
	GETTINPAID b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
	ArrayList <GETTINPAID> testPortfolio = new ArrayList <GETTINPAID>();
	int graphStart = 0;
	DecimalFormat twoDForm = new DecimalFormat("#.##");
	double averageReturn;
	ArrayList <Double> equity = new ArrayList<Double>();
	//ArrayList <transaction> individualTransactions = newArrayList<transaction>();

	public void init(){
		addKeyListener(this);
		addMouseMotionListener(this);

		/*
               GETTINPAID b1 = new GETTINPAID("2010-01-03","2000-01-10",100000,"ibm",4,15,5,10);

               System.out.println(b1.percentage());
               //arraylist of equity
               equity = b1.getCash();
               graphInfo b1g = new graphInfo(equity);
               globalTmpGraphInfo = b1g;

               for(int i = 0;i < equity.size();i++){
                       //System.out.println(equity.get(i));
               }
               System.out.println(b1.getTransactions().size());
		 */
				
			
               double tmpPercentage = 0.0,percentage = -101.0;
               /*
				for(int b = 2; b <100;b++){
					for(int a = 1; a < b;a++){
						for(int d = 2; d < 100;d++){
							for(int c = 1; c < d;c++){
								b0 = new GETTINPAID(10000,"cdns",a,b,c,d);
								//System.out.println(b0.percentage());
								if(b0.percentage() > percentage){
		                    		   percentage = b0.percentage();
		                    		   System.out.println(" "+a+" "+b+" "+" "+c+" "+d+" "+percentage+"% profit");
								}		
							}
						}
					}
				}*/
               /*
               double[] annual = new double [10];
               for(int i = 10; i < 150; i++){
                       for(int j = 1; j < i; j++){ 
                    	   
                    	   /*
                    	   b0 = new GETTINPAID("2001-01-02","2000-01-03",100000,"cdns",25,27,j,i);
                    	   b1 = new GETTINPAID("2002-01-02","2001-01-02",100000,"cdns",25,27,j,i);
                    	   b2 = new GETTINPAID("2003-01-02","2002-01-02",100000,"cdns",25,27,j,i);
                    	   b3 = new GETTINPAID("2004-01-02","2003-01-02",100000,"cdns",25,27,j,i);
                    	   b4 = new GETTINPAID("2005-01-03","2004-01-02",100000,"cdns",25,27,j,i);
                    	   b5 = new GETTINPAID("2006-01-03","2005-01-03",100000,"cdns",25,27,j,i);
                    	   b6 = new GETTINPAID("2007-01-03","2006-01-03",100000,"cdns",25,27,j,i);
                    	   b7 = new GETTINPAID("2008-01-02","2007-01-03",100000,"cdns",25,27,j,i);
                    	   b8 = new GETTINPAID("2009-01-02","2008-01-02",100000,"cdns",25,27,j,i);
                    	   b9 = new GETTINPAID("2010-01-01","2009-01-02",100000,"cdns",25,27,j,i);
                    	    */
				/*
                    	   b0 = new GETTINPAID("2010-01-01","2000-01-03",10000,"cost",j,i,15,16);
                    	   b1 = new GETTINPAID("2010-01-01","2000-01-03",10000,"cdns",j,i,15,16);
                    	   b2 = new GETTINPAID("2010-01-01","2000-01-03",10000,"orcl",j,i,15,16);
                    	   b3 = new GETTINPAID("2010-01-01","2000-01-03",10000,"affx",j,i,15,16);
                    	   b4 = new GETTINPAID("2010-01-01","2000-01-03",10000,"ibm",j,i,15,16);
                    	   b5 = new GETTINPAID("2010-01-01","2000-01-03",10000,"msft",j,i,15,16);
                    	   b6 = new GETTINPAID("2010-01-01","2000-01-03",10000,"yhoo",j,i,15,16);
                    	   b7 = new GETTINPAID("2010-01-01","2000-01-03",10000,"cdns",j,i,15,16);
                    	   b8 = new GETTINPAID("2010-01-01","2000-01-03",10000,"lmt",j,i,15,16);
                    	   b9 = new GETTINPAID("2010-01-01","2000-01-03",10000,"amat",j,i,15,16);

                      	   tmpPercentage = b0.percentage()+b1.percentage()+b2.percentage()+b3.percentage()+b4.percentage()+b5.percentage()+b6.percentage()+b7.percentage()+b8.percentage()+b9.percentage();
                    	   tmpPercentage /= 10;
                    	   if(tmpPercentage > percentage){
                    		   percentage = tmpPercentage;
                    		   System.out.println(j+" "+i+" "+percentage+"% profit");
                    	   }
                       }
               }*/
               //System.out.println("Maximum return was achieved through using the "+a + " and "+ b +" day moving averages and returned " +percentage+"%");
		 	
               //ArrayList of algos
               
               ArrayList <GETTINPAID> gettinPaidList1 = new ArrayList <GETTINPAID>();
               String takeTicker, takeDateEnd, takeDateStart;
               String temporary;
                             
               
               /*
               b0 = new GETTINPAID("2010-01-01","2000-01-03",100000,"cost",3,7,29,30);
               b1 = new GETTINPAID("2010-01-01","2000-01-03",100000,"cdns",3,7,29,30);
               b2 = new GETTINPAID("2010-01-01","2000-01-03",100000,"orcl",3,7,29,30);
               b3 = new GETTINPAID("2010-01-01","2000-01-03",100000,"affx",3,7,29,30);
               b4 = new GETTINPAID("2010-01-01","2000-01-03",100000,"ibm",3,7,29,30);
               b5 = new GETTINPAID("2010-01-01","2000-01-03",100000,"msft",3,7,29,30);
               b6 = new GETTINPAID("2010-01-01","2000-01-03",100000,"yhoo",3,7,29,30);
               b7 = new GETTINPAID("2010-01-04","2000-01-03",100000,"isrg",3,7,29,30);
               b8 = new GETTINPAID("2010-01-01","2000-01-03",100000,"lmt",3,7,29,30);
               b9 = new GETTINPAID("2010-01-01","2000-01-03",100000,"amat",3,7,29,30);
               */
              
               takeTicker= "f";
               b0 = new GETTINPAID("2001-01-02","2000-01-03",100000,takeTicker,3,7,29,300,0.9);
               b1 = new GETTINPAID("2002-01-02","2001-01-02",100000,takeTicker,3,7,29,300,0.9);
        	   b2 = new GETTINPAID("2003-01-02","2002-01-02",100000,takeTicker,3,7,29,300,0.9);
        	   b3 = new GETTINPAID("2004-01-02","2003-01-02",100000,takeTicker,3,7,29,300,0.9);
        	   b4 = new GETTINPAID("2005-01-03","2004-01-02",100000,takeTicker,3,7,29,300,0.9);
        	   b5 = new GETTINPAID("2006-01-03","2005-01-03",100000,takeTicker,3,7,29,300,0.9);
        	   b6 = new GETTINPAID("2007-01-03","2006-01-03",100000,takeTicker,3,7,29,300,0.9);
        	   b7 = new GETTINPAID("2008-01-02","2007-01-03",100000,takeTicker,3,7,29,300,0.9);
        	   b8 = new GETTINPAID("2009-01-02","2008-01-02",100000,takeTicker,3,7,29,300,0.9);
        	   b9 = new GETTINPAID("2010-01-01","2009-01-02",100000,takeTicker,3,7,29,300,0.9);
               
        	   temporary = JOptionPane.showInputDialog(null,"Enter the number of companies: ");
        	   takeDateStart = JOptionPane.showInputDialog(null,"Enter the START date (yyyy-mm-dd): ");
        	   takeDateEnd = JOptionPane.showInputDialog(null,"Enter the END date (yyyy-mm-dd): ");
        	   for(int i = 0; i < Integer.parseInt(temporary); i++){
        		   takeTicker = JOptionPane.showInputDialog(null,"Enter a ticker: ");
        		   testPortfolio.add(new GETTINPAID("2010-01-01","2009-01-02",100000,takeTicker,3,7,29,300,0.9));
        		   System.out.println(testPortfolio.get(i).percentage());
        	   }
               averageReturn = b0.percentage()+b1.percentage()+b2.percentage()+b3.percentage()+b4.percentage()+b5.percentage()+b6.percentage()+b7.percentage()+b8.percentage()+b9.percentage();
               averageReturn = Double.valueOf(twoDForm.format(averageReturn/10));
               
		offscreen = createImage(screenWidth,screenHeight);
		bufferGraphics = offscreen.getGraphics();
		resize(screenWidth, screenHeight);
		repaint();

	}
	public static void main(String[] args) {}
	public void paint (Graphics g) {
		bufferGraphics.setColor(Color.black);
		bufferGraphics.fillRect(0,0,screenWidth,screenHeight);
		bufferGraphics.setColor(Color.green);
		bufferGraphics.drawString("50%-",gOX-26,gOY+(int)(gHeight/2-50*2));
		bufferGraphics.drawRect(gOX,gOY,gLength,gHeight);
		bufferGraphics.drawLine(gOX,gOY+gHeight/2,gOX+gLength,gOY+gHeight/2);
		bufferGraphics.setColor(Color.red);

		//yearly results
		int interval = 20,barWidth = 15;
		/*
		bufferGraphics.fillRect(gOX+interval, (int)Math.min(gOY+gHeight/2-b0.percentage()*2,gOY+gHeight/2), barWidth, (int) (Math.max(gOY+gHeight/2-b0.percentage()*2,gOY+gHeight/2)-Math.min(gOY+gHeight/2-b0.percentage()*2,gOY+gHeight/2)));
		bufferGraphics.fillRect(gOX+2*interval, (int)Math.min(gOY+gHeight/2-b1.percentage()*2,gOY+gHeight/2), barWidth, (int) (Math.max(gOY+gHeight/2-b1.percentage()*2,gOY+gHeight/2)-Math.min(gOY+gHeight/2-b1.percentage()*2,gOY+gHeight/2)));
		bufferGraphics.fillRect(gOX+3*interval, (int)Math.min(gOY+gHeight/2-b2.percentage()*2,gOY+gHeight/2), barWidth, (int) (Math.max(gOY+gHeight/2-b2.percentage()*2,gOY+gHeight/2)-Math.min(gOY+gHeight/2-b2.percentage()*2,gOY+gHeight/2)));
		bufferGraphics.fillRect(gOX+4*interval, (int)Math.min(gOY+gHeight/2-b3.percentage()*2,gOY+gHeight/2), barWidth, (int) (Math.max(gOY+gHeight/2-b3.percentage()*2,gOY+gHeight/2)-Math.min(gOY+gHeight/2-b3.percentage()*2,gOY+gHeight/2)));
		bufferGraphics.fillRect(gOX+5*interval, (int)Math.min(gOY+gHeight/2-b4.percentage()*2,gOY+gHeight/2), barWidth, (int) (Math.max(gOY+gHeight/2-b4.percentage()*2,gOY+gHeight/2)-Math.min(gOY+gHeight/2-b4.percentage()*2,gOY+gHeight/2)));
		bufferGraphics.fillRect(gOX+6*interval, (int)Math.min(gOY+gHeight/2-b5.percentage()*2,gOY+gHeight/2), barWidth, (int) (Math.max(gOY+gHeight/2-b5.percentage()*2,gOY+gHeight/2)-Math.min(gOY+gHeight/2-b5.percentage()*2,gOY+gHeight/2)));
		bufferGraphics.fillRect(gOX+7*interval, (int)Math.min(gOY+gHeight/2-b6.percentage()*2,gOY+gHeight/2), barWidth, (int) (Math.max(gOY+gHeight/2-b6.percentage()*2,gOY+gHeight/2)-Math.min(gOY+gHeight/2-b6.percentage()*2,gOY+gHeight/2)));
		bufferGraphics.fillRect(gOX+8*interval, (int)Math.min(gOY+gHeight/2-b7.percentage()*2,gOY+gHeight/2), barWidth, (int) (Math.max(gOY+gHeight/2-b7.percentage()*2,gOY+gHeight/2)-Math.min(gOY+gHeight/2-b7.percentage()*2,gOY+gHeight/2)));
		bufferGraphics.fillRect(gOX+9*interval, (int)Math.min(gOY+gHeight/2-b8.percentage()*2,gOY+gHeight/2), barWidth, (int) (Math.max(gOY+gHeight/2-b8.percentage()*2,gOY+gHeight/2)-Math.min(gOY+gHeight/2-b8.percentage()*2,gOY+gHeight/2)));
		bufferGraphics.fillRect(gOX+10*interval, (int)Math.min(gOY+gHeight/2-b9.percentage()*2,gOY+gHeight/2), barWidth, (int) (Math.max(gOY+gHeight/2-b9.percentage()*2,gOY+gHeight/2)-Math.min(gOY+gHeight/2-b9.percentage()*2,gOY+gHeight/2)));  
		bufferGraphics.drawString(b0.percentage()+"%", gOX+gLength+7, gOY+10);
		bufferGraphics.drawString(b1.percentage()+"%", gOX+gLength+7, gOY+25);
		bufferGraphics.drawString(b2.percentage()+"%", gOX+gLength+7, gOY+40);
		bufferGraphics.drawString(b3.percentage()+"%", gOX+gLength+7, gOY+55);
		bufferGraphics.drawString(b4.percentage()+"%", gOX+gLength+7, gOY+70);
		bufferGraphics.drawString(b5.percentage()+"%", gOX+gLength+7, gOY+85);
		bufferGraphics.drawString(b6.percentage()+"%", gOX+gLength+7, gOY+100);
		bufferGraphics.drawString(b7.percentage()+"%", gOX+gLength+7, gOY+115);
		bufferGraphics.drawString(b8.percentage()+"%", gOX+gLength+7, gOY+130);
		bufferGraphics.drawString(b9.percentage()+"%", gOX+gLength+7, gOY+145);
		*/
		
		for(int i = 0; i < testPortfolio.size();i++){
			bufferGraphics.fillRect(gOX+(i+1)*interval, (int)Math.min(gOY+gHeight/2-testPortfolio.get(i).percentage()*2,gOY+gHeight/2), barWidth, (int) (Math.max(gOY+gHeight/2-testPortfolio.get(i).percentage()*2,gOY+gHeight/2)-Math.min(gOY+gHeight/2-testPortfolio.get(i).percentage()*2,gOY+gHeight/2)));  
			bufferGraphics.drawString(testPortfolio.get(i).percentage()+"%", gOX+gLength+7, gOY+i*15+10);
		}
		
		bufferGraphics.drawString(averageReturn+"%", gOX+gLength+7, gOY+165);

		//percentage change
		/*
               for(int i = graphStart; i <globalTmpGraphInfo.getGraphValues().length-1; i++){
                       if(i < globalTmpGraphInfo.getGraphValues().length-1&&i<graphStart+gLength)
                               bufferGraphics.drawLine(gOX+i-graphStart,(int)globalTmpGraphInfo.getGraphValues()[i],gOX+i+1-graphStart,(int)globalTmpGraphInfo.getGraphValues()[i+1]);
               }*/
		//transaction histogram
		/*
		 *
		 *
		 * do this
		 */

		//Mouseball
		bufferGraphics.setColor(Color.cyan);
		bufferGraphics.fillOval(mX-4,mY-4,8,8);
		g.drawImage(offscreen,0,0,this);
	}
	public void update(Graphics g){
		paint(g);
	}

	public class graphInfo{
		double[]trueValues,percentValues,graphValues;
		graphInfo(ArrayList <Double> equity){
			trueValues = new double [equity.size()];
			percentValues = new double [equity.size()];
			for(int i = 0; i < trueValues.length; i++){
				trueValues[i] = equity.get(i);
			}
			function(trueValues);
		}
		void function(double[]value){
			double[] tmpGraphValues = new double[value.length];
			percentValues[0]=0;
			for(int i = 1; i < percentValues.length;i++){
				if((value[i]-value[i-1])/value[i-1] == 0)
					percentValues[i] = percentValues[i-1];
				else if((value[i]-value[i-1])/value[i-1] != 0)
					percentValues[i] = Double.valueOf(twoDForm.format(100*(value[i]-value[0])/value[0]));
				//System.out.println(percentValues[i]);
			}
			tmpGraphValues[0] = gOY + gHeight/2;
			for(int i = 1; i < tmpGraphValues.length; i++){
				tmpGraphValues[i] = gOY + gHeight/2 - 2*percentValues[i];
				//System.out.println(tmpGraphValues[i]);
			}
			graphValues = tmpGraphValues;
		}
		public double[] getGraphValues(){
			return graphValues;
		}
	}
	public class GETTINPAID {
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		String ticker,first,last;
		int stocks;
		int dateOne,dateTwo;
		double capital, worth, marker, original,temp;
		float[][]local;
		Date[]calendar;
		double [] fast,slow,fast2,slow2,longTermTrend,ATR;
		double stopLoss;
		ArrayList <Double> cash = new ArrayList<Double>();
		ArrayList <transaction> trades = new ArrayList<transaction>();
		ReadFiles z;
		int commission = 10;

		GETTINPAID(double c, String d,int indicatorParam1,int indicatorParam2, 
				int indicatorParam3, int indicatorParam4, double indicatorParam5){
			z = new ReadFiles(d);
			ticker = d;
			//System.out.println(z.checkIsFile());
			//System.out.println(z.findRowNumber());
			//z.printArray();
			z.convertToArray();
			z.createDataArray(z.items);
			//z.printDataArray();
			z.createDateArray(z.getArray());
			//z.printDateArray();


			first = z.getArray()[0][0];
			last = z.getArray()[z.getArray().length-1][0];
			capital = c;
			worth = c;
			original = c;
			calendar = z.dateArray;
			//z.printArray();
			//local = new float[calendar.length][7];
			//createLocalDateArray(z.dateArray);
			//createLocalArray(z.dataArray);
			fast = createSMAArray(indicatorParam1,z.dataArray);
			slow = createSMAArray(indicatorParam2,z.dataArray);
			fast2 = createEMAArray(indicatorParam3,z.dataArray);
			slow2 = createEMAArray(indicatorParam4,z.dataArray);
			stopLoss = indicatorParam5;

			longTermTrend = createEMAArray(indicatorParam4,z.dataArray);
			//ATR = createATR(z.dataArray,14);
			run();
		}
		
		GETTINPAID(String a, String b,  double c, String d,int indicatorParam1,
				int indicatorParam2, int indicatorParam3, int indicatorParam4, double indicatorParam5){
			z = new ReadFiles(d);
			ticker = d;
			//System.out.println(z.checkIsFile());
			//System.out.println(z.findRowNumber());
			//z.printArray();
			z.convertToArray();
			z.createDataArray(z.items);
			//z.printDataArray();
			z.createDateArray(z.getArray());
			//z.printDateArray();

			first = a;
			last = b;
			capital = c;
			worth = c;
			original = c;
			calendar = z.dateArray;
			//z.printArray();
			//local = new float[calendar.length][7];
			//createLocalDateArray(z.dateArray);
			//createLocalArray(z.dataArray);
			fast = createSMAArray(indicatorParam1,z.dataArray);
			slow = createSMAArray(indicatorParam2,z.dataArray);
			fast2 = createEMAArray(indicatorParam3,z.dataArray);
			slow2 = createEMAArray(indicatorParam4,z.dataArray);
			stopLoss = indicatorParam5;
			longTermTrend = createEMAArray(indicatorParam4,z.dataArray);
			//ATR = createATR(z.dataArray,14);
			run();
		}
		public class transaction{
			//indicates transaction type 0 is buy 1 is sell
			int type;
			//number of shares in the transaction
			int numberOfShares;
			//price per share
			double pricePerShare;
			//date of Transaction
			Date dateOfTransaction;
			transaction(int a,int b,double c, Date d){
				type = a;
				numberOfShares = b;
				pricePerShare = c;
				dateOfTransaction = d;
			}
			public int getType(){return type;}
			public double holdings(){return numberOfShares * pricePerShare;}
			public Date getDate(){return dateOfTransaction;}
		}
		public int resizeArray(String[][] items){
			for(int i = 0; i < items.length; i++){
				if(first.equals(items[i][0])){
					dateOne = i;
					//System.out.println(dateOne);
				}
				if(last.equals(items[i][0])){
					dateTwo = i;
					//System.out.println(dateTwo);
				}
			}
			//System.out.println(dateTwo - dateOne);
			return dateTwo - dateOne;
		}
		//cuts date array into local one
		public void createLocalDateArray(Date[] dateArray){
			int k = dateOne;
			for(int i=0; i < (calendar.length); i++){
				calendar [i]= dateArray[k];
				k++;
			}
		}
		//prints local date array
		public void printLocalDateArray(){
			for(int x = 0; x < calendar.length; x++){
				System.out.printf("%s ", calendar[x]);
				System.out.println();
			}
		}
		//cuts data array into local one FLOATS ONLY
		public void createLocalArray(float[][] dataArray){
			int k = dateOne;
			for(int i=0; i < (local.length); i++){
				for(int j=0; j < 7; j++){
					local [i][j]= dataArray[k][j];
				}
				k++;
			}
		}
		//prints local array
		public void printLocalArray(){
			for(int x = 0; x < local.length; x++){
				for(int y = 0; y < local[x].length; y++){
					System.out.printf("%s ", local[x][y]);
				}
				System.out.println();
			}
		}
		//cuts data array into local one DOUBLES ONLY
		public void createLocalArrayDouble(int a,double[] d){
			double [] tmp = d;
			d = new double [a];
			int k = dateOne;
			for(int i=0; i < (tmp.length); i++){
				d [i]= tmp[k];
				k++;
			}
		}
		public double[] createSMAArray(int a,float[][] dataArray){
			int smaDays = a;    // days
			double [] sma = new double[dataArray.length-smaDays+1];
			float sum = 0;
			for(int i = 0; i < sma.length; i++) {
				for(int j = 0; j < smaDays; j++) {
					sum += dataArray[j + i][6];
				}
				sma[i] = sum/smaDays;
				//System.out.println(i+" Sma: "+sma[i]);
				sum = 0;
			}
			return sma;
		}
		public double[] createEMAArray(int a,float[][] dataArray){
			int emaDays = a;    // days
			double exponent = ((double)2/(emaDays+1));
			//System.out.println(exponent);
			double [] ema = new double[dataArray.length];
			ema[ema.length-1] = dataArray [dataArray.length-1][6];
			//System.out.println(ema.length-1+" ema: "+ema[ema.length-1]);
			for(int i = ema.length-2; i >= 0; i--) {
				ema[i] = dataArray[i][6]*exponent + ema[i+1]*(1-exponent);
				//System.out.println(i+" ema: "+ema[i]);
			}
			return ema;
		}
		//finish this
		public double[] createATR(float[][] d,int a){
			float [][] trueRange = new float[d.length-2][7];
			double [] atr = new double[d.length-1];
			for(int i = trueRange.length-1; i >= 0; i--){
				trueRange[i][6]= Math.max(d[i][2],d[i+1][4])-Math.min(d[i][3],d[i+1][4]);
			}
			atr = createSMAArray(a,trueRange);
			for(int i = atr.length-1; i >= 0; i--){
				System.out.println(atr[i]);
			}
			return atr;
		}
		public void run(){
			int start = startPoint(last,z.items);
			for(int x = getStart(start)-1; x > 1; x--){
				//if the smaller moving average crosses above the longer and no position held
				if(up(x)&&marker==0){
					System.out.println("Buy " + z.dateArray[x-2]);
					longBuy(z.dataArray[x-2][4],x-2);
					//repurchase(local[x-2][4],local[x-2][0]);
					marker = z.dataArray[x-2][4];
				}
				//if the price crosses below the trend 
				else if(down(x) && marker != 0){
					System.out.println("Sell " + z.dateArray[x-2]);
					longSell(z.dataArray[x-2][4],x-2);
					//shortSell(local[x-2][4],local[x-2][0]);
					marker = 0;
				}
				else if (z.dataArray[x][6]<marker*stopLoss && marker != 0){
					System.out.println("Stop Loss");
					longSell(z.dataArray[x-2][4],x-2);
					marker = 0;
				}
				//sets offensive stance
				cash.add(worth);
			}	
			bank();
		}
		private int getStart(int x) {
			if(x>slow.length-1)
				return slow.length-1;
			return x;
		}
		public void longBuy(float price, int date){
			if(stocks == 0){
				stocks = (int)(capital/(double)price);
				System.out.println("Bought: " + stocks +" "+ticker+ " stocks at " + Double.valueOf(twoDForm.format((double)price)));
				System.out.println("Date: " + calendar[(int)date]);
				capital = Double.valueOf(twoDForm.format((capital-commission)%(double)price));
				capital = Double.valueOf(twoDForm.format(capital));
				worth = Double.valueOf(twoDForm.format((stocks*(double)price+capital)));
				trades.add(new transaction(0,stocks,price,calendar[(int)date]));
			}
		}
		public void longSell(float price, int date){
			if(stocks > 0){
				capital += Double.valueOf(twoDForm.format(stocks*(double)price));
				capital -= commission;
				System.out.println("Sold: " + stocks +" "+ticker+ " stocks at " + Double.valueOf(twoDForm.format((double)price)));
				System.out.println("Date: " + calendar[(int)date]);
				trades.add(new transaction(1,stocks,price,calendar[(int)date]));
				stocks = 0;
				capital = Double.valueOf(twoDForm.format(capital));
				worth = capital;
			}
		}
		/*public void shortSell(float price, double date){
                       if(stocks == 0){
                               stocks = (int)(capital/(3*(double)price));
                               System.out.println("Sold: " + stocks + " stocks at " + Double.valueOf(twoDForm.format((double)price)));
                               System.out.println("Date: " + calendar[(int)date-dateOne]);
                               capital += Double.valueOf(twoDForm.format(stocks*(double)price));
                               worth = capital;
                       }
               }
               public void repurchase(float price, double date){
                       if(stocks > 0){
                               capital -= Double.valueOf(twoDForm.format(stocks*(double)price));
                               System.out.println("Bought: " + stocks + " stocks at " + Double.valueOf(twoDForm.format((double)price)));
                               System.out.println("Date: " + calendar[(int)date-dateOne]);
                               stocks = 0;
                               capital = Double.valueOf(twoDForm.format(capital));
                               worth = capital;
                               System.out.println("Worth: " + worth);
                       }
               }*/
		public void bank(){
			longSell(Float.valueOf(twoDForm.format(z.dataArray[0][6])),0);
			cash.add(worth);
			//System.out.println("$" +worth);
		}
		public double percentage(){
			return Double.valueOf(twoDForm.format(((capital-original)/original)*100));
		}
		public ArrayList<Double> getCash (){
			for(int i=0; i < cash.size(); i++){
				//System.out.println(cash.get(i) + " "+ calendar[i]);
			}
			return cash;
		}
		public ArrayList<transaction> getTransactions(){
			for(int i=0; i < trades.size(); i++){
				//System.out.println(trades.get(i).holdings());
			}
			return trades;
		}
		public int startPoint(String a, String[][] b){
			int start = 0;
			for(int i = b.length-1; i >=0; i--){
				if(a.equals(b[i][0])){
					start = i;
					dateOne = i;
					break;
				}
			}
			return start;
		}
		public boolean up(int x){
			//fast average crosses above slow average
			if(fast[x-1] > slow[x-1] && fast[x+1] < slow[x+1]){
				return true;
			}
			else return false;
		}
		public boolean down(int x){
			//turnaround on fast2 
			if((fast2[x+1] < fast2[x] && fast2[x-1] < fast2[x])){
				return true;
			}
			else return false;
		}
		/*
		public boolean rebound(int x){
			//price moves above 300 daymoving average
			if(z.dataArray[x-2][6]>longTermTrend[x-2]){
				return true;
			}
			return false;
		}*/
	}
	public class ReadFiles {
		File file;
		int row;
		String [][] items;
		float[][] dataArray;
		Date[] dateArray;
		String theDate;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		public ReadFiles(String d) {
			file = new File("C:\\Users\\Parth Patil\\workspace\\parthCollegeSystem\\bin\\All\\" + d +".csv");
			dataArray = new float[findRowNumber()][7];
			dateArray = new Date[findRowNumber()];
		}
		//check if the file is a file
		public boolean checkIsFile(){
			return file.isFile();
		}
		//find number of rows in csv file
		public int findRowNumber(){
			row = 0;
			if(checkIsFile()){
				//do this if it's a file
				try{
					BufferedReader reader = new BufferedReader(new FileReader(file));
					while((reader.readLine()) !=null){
						row++;
					}
				}catch(Exception e){
					System.out.println(e);
				}

			}else{
				System.out.println("This is not a file");
			}
			return row;
		}
		//converts the csv file to an array
		public void convertToArray(){
			int r = 0;
			items = new String[findRowNumber()][7];

			try{
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line = null;

				while((line=reader.readLine()) !=null){
					StringTokenizer z = new StringTokenizer(line,",");
					while(z.hasMoreTokens()){
						for(int c = 0; c < 7; c++){
							items[r][c] = z.nextToken();
						}
						r++;
					}
				}
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		//prints out ITEMS array
		public void printArray(){
			for(int x = 0; x < items.length; x++){
				System.out.printf("%s - ", x);
				for(int y = 0; y < items[x].length; y++){
					System.out.printf("%s ", items[x][y]);
				}
				System.out.println();
			}
		}
		//return array ITEMS
		public String[][] getArray(){
			return items;
		}
		public void createDateArray(String[][] n){
			for(int x = 0; x<n.length; x++){
				for(int y = 0; y<n[x].length; y++){
					if(y == 0){
						try{
							Date newdate = (Date)df.parse(n[x][0]);
							dateArray[x] = newdate;
						}catch(Exception e){
							System.out.println(e);
						}
					}
				}
			}
		}
		//create a float array for rest of elements
		public void createDataArray(String[][] n){
			for(int x = 0; x < n.length; x++){
				for(int y = 0; y < n[x].length; y++){
					switch(y){
					case 0:
						dataArray[x][y]= (int)x;
						break;
					case 1:
						dataArray[x][y]=new Float(n[x][y]);
						break;
					case 2:
						dataArray[x][y]=new Float(n[x][y]);
						break;
					case 3:
						dataArray[x][y]=new Float(n[x][y]);
						break;
					case 4:
						dataArray[x][y]=new Float(n[x][y]);
						break;
					case 5:
						dataArray[x][y]=new Float(n[x][y]);
						break;
					case 6:
						dataArray[x][y]=new Float(n[x][y]);
						break;
					case 7:
						dataArray[x][y]=new Float(n[x][y]);
						break;
					}
				}
			}
		}

		//print data array
		public void printDataArray(){
			for(int x = 0; x<dataArray.length;x++){
				for(int y = 0;y<dataArray[x].length; y++){
					System.out.printf("%s ", dataArray[x][y]);
				}
				System.out.println();
			}
		}
		//print date array
		public void printDateArray(){
			for(int x = 0; x<dateArray.length;x++){
				System.out.printf("%s ", dateArray[x]);
				System.out.println();
			}
		}
	}
	public void mouseDragged(MouseEvent e) {
		mX = e.getX();mY = e.getY();
		if(mX > gOX && mX < gOX+gLength && mX-gOX+graphStart < globalTmpGraphInfo.getGraphValues().length){
			mY = (int)globalTmpGraphInfo.getGraphValues()[mX-gOX+graphStart];
		}
		repaint();
	}	
	public void mouseMoved(MouseEvent e) {
		mX = e.getX();mY = e.getY();
		/*if(mX > gOX && mX < gOX+gLength && mX-gOX+graphStart < globalTmpGraphInfo.getGraphValues().length){
    		   mY = (int)globalTmpGraphInfo.getGraphValues()[mX-gOX+graphStart];
    	   }*/
		repaint();
	}
	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar()=='q' && graphStart != 0){
			graphStart-=5;
		}
		else if(e.getKeyChar()=='w'){
			graphStart+=5;
		}
		if(mX > gOX && mX < gOX+gLength && mX-gOX+graphStart < globalTmpGraphInfo.getGraphValues().length){
			mY = (int)globalTmpGraphInfo.getGraphValues()[mX-gOX+graphStart];
		}
		repaint();
	}	
	public void keyReleased(KeyEvent e) {}
}