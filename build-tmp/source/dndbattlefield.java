import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class dndbattlefield extends PApplet {

BattleSquare [][] mapper = new BattleSquare[75][49];
int framecounter = 0;
public void setup()
{
	
	initializeBattlefield();
	//TESTING THE BLINKS
	mapper[((int)(Math.random()*75))][((int)(Math.random()*49))].setSelecting(true);
	System.out.println(((int)(Math.random()*75)));
	mapper[((int)(Math.random()*75))][((int)(Math.random()*49))].setSelecting(true);
	System.out.println(((int)(Math.random()*75)));
	mapper[((int)(Math.random()*75))][((int)(Math.random()*49))].setSelecting(true);
	System.out.println(((int)(Math.random()*75)));
	mapper[((int)(Math.random()*75))][((int)(Math.random()*49))].setSelecting(true);
	System.out.println(((int)(Math.random()*75)));
	mapper[((int)(Math.random()*75))][((int)(Math.random()*49))].setSelected(true);
	System.out.println(((int)(Math.random()*75)));
	mapper[((int)(Math.random()*75))][((int)(Math.random()*49))].setSelected(true);
	System.out.println(((int)(Math.random()*75)));
	mapper[((int)(Math.random()*75))][((int)(Math.random()*49))].setSelected(true);
	System.out.println(((int)(Math.random()*75)));
	mapper[((int)(Math.random()*75))][((int)(Math.random()*49))].setSelected(true);
	System.out.println(((int)(Math.random()*75)));
}
public void draw()
{
	countframe();
	background(0);
	showBattlefield();
}
public void countframe()
{
	framecounter++;
	if(framecounter>60){framecounter=0;}
}
public void initializeBattlefield()
{
	for(int i=0;i<75;i++)
	{
		for(int j=0;j<49;j++)
		{
			mapper[i][j] = new BattleSquare(i,j);
		}
	}
}
public void showBattlefield()
{
	for(int i=0;i<75;i++)
	{
		for(int j=0;j<49;j++)
		{
			mapper[i][j].show();
		}
	}
}
class BattleSquare
{
	private int trackX, trackY;
	private boolean selecting, selected;
	public BattleSquare(int inputX, int inputY)
	{
		trackX = inputX*20;
		trackY = inputY*20;
		selecting = false;
		selected = false;
	}
	public void setSelecting(boolean input){selecting = input;}
	public void setSelected(boolean input){selected = input;}
	public void show()
	{
		stroke(255);
		fill(0);
		if(selected == false && selecting == false)
		{
			rect(trackX,trackY,19,19);
		}
		else if(selected == false)
		{
			rect(trackX,trackY,19,19);
			rect(trackX+1,trackY+1,17,17);
		}
		else
		{
			rect(trackX,trackY,19,19);
			if(framecounter<31){rect(trackX+1,trackY+1,17,17);}
		}
	}
}
  public void settings() { 	size(1800,980); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "dndbattlefield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
