BattleSquare [][] mapper = new BattleSquare[75][49];
int framecounter = 0;
public void setup()
{
	size(1800,980);
	initializeBattlefield();
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
	private boolean ative, selecting, selected;
	public BattleSquare(int inputX, int inputY)
	{
		trackX = inputX*20;
		trackY = inputY*20;
		selecting = false;
		selected = false;
		active = true;
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