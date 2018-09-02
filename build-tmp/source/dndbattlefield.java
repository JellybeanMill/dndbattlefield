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
boolean keyLeft;
boolean keyUp;
boolean keyRight;
boolean keyDown;
int cursorX = 0;
int cursorY = 0;
boolean cursorDown=false;
public void setup()
{
	
	initializeBattlefield();
}
public void draw()
{
	countframe();
	background(0);
	determineCursor();
	showBattlefield();
}
public void keyPressed()
{
	if (key == CODED)
	{
		if(keyCode == LEFT){keyLeft = true;}
		if(keyCode == UP){keyUp = true;}
		if(keyCode == RIGHT){keyRight = true;}
		if(keyCode == DOWN){keyDown = true;}
	}
}
public void keyReleased()
{
	if (key == CODED)
	{
		if(keyCode == LEFT){keyLeft = false;}
		if(keyCode == UP){keyUp = false;}
		if(keyCode == RIGHT){keyRight = false;}
		if(keyCode == DOWN){keyDown = false;}
	}
}
public void determineCursor()
{
	if (keyLeft == true && cursorX>0 && framecounter%5==0)
	{
		mapper[cursorX][cursorY].setCursorStatus(1);
		cursorX--;
		mapper[cursorX][cursorY].setCursorStatus(2);
	}
	else if (keyRight == true && cursorX<74 && framecounter%5==0)
	{
		mapper[cursorX][cursorY].setCursorStatus(1);
		cursorX++;
		mapper[cursorX][cursorY].setCursorStatus(2);
	}
	else if (keyUp == true && cursorY>0 && framecounter%5==0)
	{
		mapper[cursorX][cursorY].setCursorStatus(1);
		cursorY--;
		mapper[cursorX][cursorY].setCursorStatus(2);
	}
	else if (keyDown == true && cursorY<48 && framecounter%5==0)
	{
		mapper[cursorX][cursorY].setCursorStatus(1);
		cursorY++;
		mapper[cursorX][cursorY].setCursorStatus(2);
	}
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
	private int trackX, trackY, status, cursorStatus;
	public BattleSquare(int inputX, int inputY)
	{
		trackX = inputX*20;
		trackY = inputY*20;
		cursorStatus = 1; /*1 = normal, 2 = selecting, 3 = selected*/
		status = 1;/* 0 = nonactive, 1 = active*/
	}
	public void setCursorStatus(int input){cursorStatus = input;}
	public void setStatus(int input){status = input;}
	public void show()
	{
		fill(0);
		//For normal field descrptions
		if(status == 1)
		{
			stroke(255);
			rect(trackX,trackY,19,19);
		}
		//For cursor looks
		if(cursorStatus == 3)
		{
			stroke(0,255,0);
			rect(trackX,trackY,19,19);
			rect(trackX+1,trackY+1,17,17);
		}
		else if (cursorStatus == 2)
		{
			stroke(255);
			rect(trackX,trackY,19,19);
			if(framecounter<31 || keyPressed)
			{
				stroke(0,255,0);
				rect(trackX,trackY,19,19);
				rect(trackX+1,trackY+1,17,17);
			}
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
