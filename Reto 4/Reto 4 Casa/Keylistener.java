import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
class Keylistener implements KeyListener 
{
    static Translacion mover;
    static Escalado ampliar;
    static Rotacion rotar;


    public Keylistener(Translacion mover,Escalado ampliar, Rotacion rotar){
        this.mover= mover;
        this.rotar= rotar;
        this.ampliar= ampliar;
    }
	public void keyTyped(KeyEvent e) 
	{
		char c = e.getKeyChar();
		//System.out.println("Key Typed: " + c);
	}
	public void keyPressed(KeyEvent e) 
	{
		char c = e.getKeyChar();
		
		if (c == 'w')
		{
            mover.dy=15;
            mover.dx=0;
            mover.movimiento();
            System.out.println(mover.dy);
		}
		if (c == 's')
		{
            mover.dy=-15;
            mover.dx=0;
            mover.movimiento();
            System.out.println(mover.dy);
		}
		if (c == 'a')
		{
            mover.dx=-15;
            mover.dy=0;
            mover.movimiento();
            System.out.println(mover.dx);
		}
		if (c == 'd')
		{
            mover.dx=15;
            mover.dy=0;
            mover.movimiento();
            System.out.println(mover.dx);
        }
        
        if (c == 'i')
		{
			rotar.angulo=0.1;
            rotar.movimiento();
            System.out.println(rotar.angulo);
        }
        if (c == 'k')
		{
			rotar.angulo=-0.1;
            rotar.movimiento();
            System.out.println(rotar.angulo);
        }
        if (c == 'o')
		{
			ampliar.Sy=1.1;
            ampliar.Sx=1.1;
            ampliar.movimiento();
            System.out.println(ampliar.Sx);
            System.out.println(ampliar.Sy);
        }
        if (c == 'l')
		{
            ampliar.Sy=0.9;
            ampliar.Sx=0.9;
            ampliar.movimiento();
            System.out.println(ampliar.Sx);
            System.out.println(ampliar.Sy);
        }
	}
	public void keyReleased(KeyEvent e) 
	{
		char c = e.getKeyChar();
		//System.out.println("Key Released: " + c);
	}
}