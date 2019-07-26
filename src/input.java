import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class input implements KeyListener{
	boolean left,right,up,down;
	public void keyPressed(KeyEvent e){
		switch(e.getKeyCode())
		{
		case 37:
			left=true;
			break;
		case 38:
			up=true;
			break;
		case 39:
			right=true;
			break;
		case 40:
			down=true;
			break;
		}
	}
public void keyReleased(KeyEvent e){
	switch(e.getKeyCode()){
case 37:
	left=false;
	break;
case 38:
	up=false;
	break;
case 39:
	right=false;
	break;
case 40:
	down=false;
	break;
	}
	}
public void keyTyped(KeyEvent e){
	
}
}
