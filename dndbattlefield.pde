BattleSquare [][] mapper = new BattleSquare[75][49];
int framecounter = 0;
boolean keyLeft;
boolean keyUp;
boolean keyRight;
boolean keyDown;
int [] cursorXY= new int[]{0,0};
public void setup()
{
	size(1800,980);
	initializeBattlefield();
	mapper[0][0].setStatus(2);
	mapper[0][1].setStatus(3);
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
	if (keyLeft = true && framecounter %10==0)
	{
		cursorXY[1]++;
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
	private int trackX, trackY, status;
	public BattleSquare(int inputX, int inputY)
	{
		trackX = inputX*20;
		trackY = inputY*20;
		status = 1;/* 0 = nonactive, 1 = active, waiting, 2 = cursor blinking, 3 = cursor selected*/
	}
	public void setStatus(int input){status = input;}
	public void show()
	{
		fill(0);
		if(status == 1)
		{
			stroke(255);
			rect(trackX,trackY,19,19);
		}
		else if(status == 3)
		{
			stroke(0,255,0);
			rect(trackX,trackY,19,19);
			rect(trackX+1,trackY+1,17,17);
		}
		else
		{
			stroke(255);
			rect(trackX,trackY,19,19);
			if(framecounter<31)
			{
				stroke(0,255,0);
				rect(trackX,trackY,19,19);
				rect(trackX+1,trackY+1,17,17);
			}
		}
	}
}