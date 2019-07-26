import java.awt.*;
import java.awt.image.*;
import java.applet.*;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.*;
public class project extends Applet implements Runnable{
	public static int WIDTH=1050;
	public static int HEIGHT=656,score=0;
	public static double oxygen=100.0000,threadwaiting=20;
	boolean loveflag=false,success=false,oxysrt=false;
	Image fish1,fish2,fish3,fish4,fish5,playerfish,queenfish,heart,crab,checkmark,bubbles1,
	efish1,efish2,efish3,efish4,efish5,efish6,efish7,efish8;
	BufferedImage screen=new BufferedImage(WIDTH,HEIGHT,4);
	//BufferedImage sprite=new BufferedImage(200,220,4);
	BufferedImage point5=new BufferedImage(53,50,4);
	BufferedImage point10=new BufferedImage(78,68,4);
	BufferedImage point20=new BufferedImage(98,91,4);
	BufferedImage minuspoint30=new BufferedImage(53,50,4);
	BufferedImage back=new BufferedImage(1050,656,4);
	AudioClip backmusic,eating,fishbite,iloveyou,lost,loveyoutoo,getlost;
	Graphics s=screen.getGraphics();
	public void init()
	{
		setSize(WIDTH,HEIGHT);
		Thread th=new Thread(this);
		th.start();
		addKeyListener(input);
	}
	public void paint(Graphics g){
		s.setColor(Color.cyan);
		s.fillRect(0, 0,WIDTH,HEIGHT);
		s.drawImage(back, 0, 0, this);
		s.setColor(Color.green);
		
		s.fillRect(5,5,140,80);
		s.setColor(Color.white);
		s.fillRect(15,10,120,70);
		s.setColor(Color.black);
		s.setFont(new Font("Arial",Font.BOLD,20));
		s.drawString("Oxygen",40,27);
		s.setColor(Color.green);
		s.setFont(new Font("Arial",Font.PLAIN,30));
		if(oxygen<15) s.setColor(Color.red);
		s.drawString((Double.toString(oxygen)).substring(0,4),50,57);
		s.setColor(Color.green);
		s.fillRect(900,5,140,80);
		s.setColor(Color.white);
		s.fillRect(910,10,120,70);
		s.setColor(Color.black);
		s.setFont(new Font("Arial",Font.BOLD,20));
		s.drawString("Score",945,27);
		s.setColor(Color.green);
		s.setFont(new Font("Arial",Font.PLAIN,30));
		s.drawString((Integer.toString(score)),955,57);
		//s.drawImage(sprite,x,y,this);
		if(score>=highscore && loveflag==true){s.drawImage(heart, templovex, templovey, this);}
		s.drawImage(playerfish, x, y, this);
		s.drawImage(fish3, m3,n3, this);
		s.drawImage(fish1, m1, n1, this);
		s.drawImage(fish2, m2, n2, this);
		s.drawImage(fish4, m4, n4, this);
		s.drawImage(fish5, m5, n5, this);
		s.drawImage(crab, 550, 550, this);
		s.drawImage(bubbles1, 500, 550, this);s.drawImage(bubbles1, 0, 550, this);s.drawImage(bubbles1, 100, 550, this);
		s.drawImage(bubbles1, 200, 550, this);s.drawImage(bubbles1, 300, 550, this);
		s.drawImage(bubbles1, 600, 550, this);s.drawImage(bubbles1, 400, 550, this);s.drawImage(bubbles1, 500, 550, this);
		s.drawImage(bubbles1, 600, 550, this);s.drawImage(bubbles1, 700, 550, this);s.drawImage(bubbles1, 800, 550, this);
		s.drawImage(bubbles1, 900, 550, this);s.drawImage(bubbles1, 1000, 550, this);
		s.drawImage(efish1, e1x, e1y, this);
		s.drawImage(efish2, e2x, e2y, this);
		s.drawImage(efish3, e3x, e3y, this);
		s.drawImage(efish4, e4x, e4y, this);
		s.drawImage(efish5, e5x, e5y, this);
		s.drawImage(efish6, e6x, e6y, this);
		s.drawImage(efish7, e7x, e7y, this);
		s.drawImage(efish8, e8x, e8y, this);
		s.drawImage(queenfish, xq, yq, this);
		if(score>=highscore) s.drawImage(checkmark, 970, 55, this);
		//Increasing score by eating face
		if((e1y+30>y+125 && e1y+30<y+145) &&   (e1x==x+240)){
			temp1=e1x;temp2=e1y;
			if(score<highscore) score=score+5;
			e1x=1500;e1y=1500;
			eating.play();
		}
		if((e2y+50>y+125 && e2y+50<y+145) &&   (e2x==x+240)){
			temp1=e2x;temp2=e2y;
			if(score<highscore)score=score+5;
			e2x=1500;e2y=1500;
			eating.play();
		}
		if((e3y+60>y+125 && e3y+60<y+145) &&   (e3x==x+240)){
			temp5=e3x;temp6=e3y;
			if(score<highscore)score=score+10;
			e3x=1500;e3y=1500;
			eating.play();
		}
		if((e4y+70>y+125 && e4y+70<y+145) &&   (e4x==x+240)){
			temp7=e4x;temp8=e4y;
			if(score<highscore) score=score+20;
			e4x=1500;e4y=1550;
			eating.play();
		}
		if((e5y+45>y+125 && e5y+45<y+145) &&   (e5x==x+240)){
			temp5=e5x;temp6=e5y;
			if(score<highscore)score=score+10;
			e5x=1500;e5y=1500;
			eating.play();
		}
		if((e6y+60>y+125 && e6y+60<y+145) &&   (e6x==x+240)){
			temp5=e6x;temp6=e6y;
			if(score<highscore)score=score+10;
			e6x=1500;e6y=1500;
			eating.play();
		}
		if((e7y+60>y+125 && e7y+60<y+145) &&   (e7x==x+240)){
			temp5=e7x;temp6=e7y;
			if(score<highscore)score=score+10;
			e7x=1500;e7y=1500;
			eating.play();
		}
		if((e8y+40>y+125 && e8y+40<y+145) &&   (e8x==x+240)){
			temp1=e8x;temp2=e8y;
			if(score<highscore)score=score+5;
			e8x=1500;e8y=1500;
			eating.play();
		}
		
		if((yq+135>y+125 && yq+135<y+145) &&   (xq==x+260))
			{
			iloveyou.play();
			}
		if(score<highscore && yq+135>y+125 && yq+135<y+145 &&   (xq==x+90) ) getlost.play();
		if(score>=highscore)  
		{
			score=highscore;        //making sure score does not cross high score
		if((yq+135>y+125 && yq+135<y+145) &&   (xq==x+200)){  //after score reach high score checking if player fish approaches queen fish 
			templovex=x+40;templovey=yq-170;
			loveyoutoo.play();
			loveflag=true; 
			//love successful
		}
		}
		
		//Decreasing score when beaten by big fishes
		if((y+97+60>n1+120 && y+97-60<n1+160) &&   (x==m1+320)){
			temp3=x;temp4=y;
			if(score>-1)score=score-30;
			fishbite.play();
		}
		
		if((y+97+60>n2+110 && y+97-60<n2+140) &&   (x==m2+250)){
			temp3=x;temp4=y;
			if(score>-1)score=score-30;
			fishbite.play();
		}
		
		if((y+97+60>n3+95 && y+97-60<n3+190) &&   (x==m3+230)){
			temp3=x;temp4=y;
			if(score>-1)score=score-30;
			fishbite.play();
		}
		
		if((y+97+60>n5+150 && y+97-60<n5+195) &&   (x==m5+330)){
			temp3=x;temp4=y;
			if(score>-1)score=score-30;
			fishbite.play();
		}
		
		if((n4+100>y+30 && n4+100<y+195) &&   (m4==x+240)){   //Fish coming in opposite direction
			temp3=m4;temp4=n4;
			if(score>-1)score=score-30;
			fishbite.play();
		}
		
		
		//Taking point symbols out of screen
		if(temp2<=1500)temp2++;
		if(temp4<=1500) temp4++;
		if(temp6<=1500) temp6++;
		if(temp8<=1500)temp8++;
		
		
		if(score>=highscore && loveflag==true){s.setFont(new Font("Arial",Font.BOLD,100)); s.drawString("You won",320,100);success=true;backmusic.stop();threadwaiting-=0.5;}
		if(score<0 || oxysrt==true){s.setFont(new Font("Arial",Font.BOLD,100));s.setColor(Color.red); s.drawString("You Lost",320,100);backmusic.stop();threadwaiting-=0.5;}
		
		
		s.drawImage(point5, temp1,temp2,this);
		s.drawImage(point10, temp5,temp6,this);
		s.drawImage(point20, temp7,temp8,this);
		s.drawImage(minuspoint30, temp3,temp4,this);
		g.drawImage(screen, 0,0,this);
		}
	
	int x=300,y=100,xq=-800,yq=200,
	m1=1000,n1=300,m2=1000,n2=200,m3=1000,n3=350,m4=-500,n4=300,m5=1000,n5=400,
	e1x=-100,e1y=300,e2x=-100,e2y=180,e3x=-100,e3y=400,e4x=-100,e4y=350,
	e5x=-100,e5y=350,e6x=-100,e6y=450,e7x=-100,e7y=400,e8x=-100,e8y=300,
	temp1=1600,temp2=1600,temp3=1600,temp4=1600,temp5=1600,temp6=1600,temp7=1600,temp8=1600,
	templovex=1700,templovey=1700,
	highscore=50;
	
	input input=new input();
	
	public void update(Graphics g){
		paint(g);
	}
	
	public BufferedImage makeTransparent(BufferedImage image)
	{
		BufferedImage temp=new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_ARGB);
		for(int i=0;i<image.getWidth();i++)
		{
			for(int j=0;j<image.getHeight();j++)
			{
				if(image.getRGB(i, j)!=image.getRGB(0,0))
				{
					temp.setRGB(i, j,image.getRGB(i, j));
				}
			}
		}
		return temp;
	}
	public void run()
	{
		try{
			back=ImageIO.read(new File("img/Back.jpg"));
			heart=getImage(getCodeBase(), "img/heart.gif");
			playerfish=getImage(getCodeBase(), "img/playerfish.gif");
			fish1=getImage(getCodeBase(), "img/Fish1.gif");
			fish2=getImage(getCodeBase(), "img/Fish2.gif");
			fish3=getImage(getCodeBase(), "img/Fish3.gif");
			fish4=getImage(getCodeBase(), "img/Fish4.gif");
			fish5=getImage(getCodeBase(), "img/Fish5.gif");
			efish1=getImage(getCodeBase(), "img/efish1.gif");
			efish2=getImage(getCodeBase(), "img/efish2.gif");
			efish3=getImage(getCodeBase(), "img/efish3.gif");
			efish4=getImage(getCodeBase(), "img/efish4.gif");
			efish5=getImage(getCodeBase(), "img/efish5.gif");
			efish6=getImage(getCodeBase(), "img/efish6.gif");
			efish7=getImage(getCodeBase(), "img/efish7.gif");
			efish8=getImage(getCodeBase(), "img/efish8.gif");
			crab=getImage(getCodeBase(), "img/crab.gif");
			bubbles1=getImage(getCodeBase(), "img/bubbles1.gif");
			point5=ImageIO.read(new File("img/point5.png"));
			point5=makeTransparent(point5);
			point10=ImageIO.read(new File("img/point10.png"));
			point10=makeTransparent(point10);
			point20=ImageIO.read(new File("img/point20.png"));
			point20=makeTransparent(point20);
			minuspoint30=ImageIO.read(new File("img/minuspoint30.png"));
			minuspoint30=makeTransparent(minuspoint30);
			queenfish=getImage(getCodeBase(), "img/queenfish.gif");
			checkmark=getImage(getCodeBase(), "img/checkmark.gif");
			
			
			backmusic = getAudioClip(getCodeBase(), "music/back.au");
			getlost = getAudioClip(getCodeBase(), "music/getlost.au");
			eating = getAudioClip(getCodeBase(), "music/eating.au");
			fishbite = getAudioClip(getCodeBase(), "music/fishbite.au");
			iloveyou = getAudioClip(getCodeBase(), "music/iloveyou.au");
			lost = getAudioClip(getCodeBase(), "music/lost.au");
			loveyoutoo = getAudioClip(getCodeBase(), "music/loveyoutoo.au");
			backmusic.loop();
			
			
			}
		    catch(Exception e){System.out.println("error getting image");}
			while(true)  //game loop
			{
				if(input.left){--x;}
				else if(input.right){++x;}
				else if(input.down){++y;}
				else if(input.up){--y;}  //Player fish movement by arrow keys
				
			//Controlling Fish movements	
			if(x>=1200)x=-70;
			if(y<=0) y=0;
			if(y+145>=656) y=511;
			if(m1==1000){
				m1=-100*ThreadLocalRandom.current().nextInt(10, 16);
				n1=100*ThreadLocalRandom.current().nextInt(2, 6);} 
			if(m2==1000){
				m2=-100*ThreadLocalRandom.current().nextInt(10, 16);
				n2=100*ThreadLocalRandom.current().nextInt(2, 6);
			}
			if(m3==1000){
				m3=-100*ThreadLocalRandom.current().nextInt(10, 16);
				n3=100*ThreadLocalRandom.current().nextInt(2, 6);
			}
			if(m5==1000){
				m5=-100*ThreadLocalRandom.current().nextInt(10, 16);
				n5=100*ThreadLocalRandom.current().nextInt(2, 6);
			}
			
			if(m4==-500){
				m4=100*ThreadLocalRandom.current().nextInt(10, 16);
				n4=100*ThreadLocalRandom.current().nextInt(2, 6);
			}
			
			m1++;m2++;m3++;m5++;
			m4--;
			
			if(xq==-800){
				xq=100*ThreadLocalRandom.current().nextInt(10, 16);
				yq=100*ThreadLocalRandom.current().nextInt(2, 6);
			}
			xq--;
			
			if(e1x==-100){
				e1x=100*ThreadLocalRandom.current().nextInt(10, 21);
				e1y=100*ThreadLocalRandom.current().nextInt(1, 6);} 
			if(e2x==-100){
				e2x=100*ThreadLocalRandom.current().nextInt(10, 21);
				e2y=100*ThreadLocalRandom.current().nextInt(1, 6);}
			if(e3x==-100){
				e3x=100*ThreadLocalRandom.current().nextInt(10, 31);
				e3y=100*ThreadLocalRandom.current().nextInt(1, 6);}
			if(e4x==-100){
				e4x=100*ThreadLocalRandom.current().nextInt(10, 41);
				e4y=100*ThreadLocalRandom.current().nextInt(1, 6);}
			if(e5x==-100){
				e5x=100*ThreadLocalRandom.current().nextInt(10, 31);
				e5y=100*ThreadLocalRandom.current().nextInt(1, 6);}
			if(e6x==-100){
				e6x=100*ThreadLocalRandom.current().nextInt(10, 31);
				e6y=100*ThreadLocalRandom.current().nextInt(1, 6);}
			if(e7x==-100){
				e7x=100*ThreadLocalRandom.current().nextInt(10, 21); 
				e7y=100*ThreadLocalRandom.current().nextInt(1, 6);}
			if(e8x==-100){
				e8x=100*ThreadLocalRandom.current().nextInt(10, 21);
				e8y=100*ThreadLocalRandom.current().nextInt(1, 6);}
			
			e1x--;e2x--;e3x--;e4x--;e5x--;e6x--;e7x--;e8x--;
			
			if(y>400) oxygen=100.00000; //oxygen refresh
			if(oxygen>0)oxygen=oxygen-0.05;
			else {oxysrt=true;lost.play();}
			
			repaint();
			
			try{
			Thread.sleep(12);
			if((success==true || score<0 ||oxysrt==true) && threadwaiting<=0) {Thread.currentThread().stop();}
			}catch(Exception e){System.out.println("error");
			}
		}
	}
	}

