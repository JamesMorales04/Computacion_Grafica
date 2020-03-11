import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
class Keylistener implements KeyListener 
{
    Translacion mover;
    Escalado ampliar;
    Rotacionx rotarx;
    Rotaciony rotary;
    Rotacionz rotarz;
    Proyeccion proyeccion;


    public Keylistener(Translacion mover,Escalado ampliar, Rotacionx rotarx,Rotaciony rotary,Rotacionz rotarz,Proyeccion proyeccion){
        this.mover= mover;
        this.rotarx= rotarx;
        this.rotary= rotary;
        this.rotarz= rotarz;
        this.ampliar= ampliar;
        this.proyeccion=proyeccion;
    }
	public void keyTyped(KeyEvent e) 
	{
		char c = e.getKeyChar();
		//System.out.println("Key Typed: " + c);
	}
	public void keyPressed(KeyEvent e) 
	{
		char c = e.getKeyChar();
        
        //Translacion
		if (c == 'w')
		{
            mover.dy=15;
            mover.dx=0;
            mover.dz=0;
            mover.movimiento();
		}
		if (c == 's')
		{
            mover.dy=-15;
            mover.dx=0;
            mover.dz=0;
            mover.movimiento();
		}
		if (c == 'a')
		{
            mover.dx=-15;
            mover.dy=0;
            mover.dz=0;
            mover.movimiento();
		}
		if (c == 'd')
		{
            mover.dx=15;
            mover.dy=0;
            mover.dz=0;
            mover.movimiento();
        }
        //Rotacion x
        if (c == 'u')
		{
			rotarx.angulo=0.18;
            rotarx.movimiento();
        }
        if (c == 'j')
		{
			rotarx.angulo=-0.18;
            rotarx.movimiento();
        }
        
        //Rotar y
        if (c == 'i')
		{
			rotary.angulo=0.18;
            rotary.movimiento();
        }
        if (c == 'k')
		{
			rotary.angulo=-0.18;
            rotary.movimiento();
        }

        //Rotar z

        if (c == 'o')
		{
			rotarz.angulo=0.18;
            rotarz.movimiento();
        }
        if (c == 'l')
		{
			rotarz.angulo=-0.18;
            rotarz.movimiento();
        }

        //Escalado


        if (c == 'n')
		{
			ampliar.Sy=1.1;
            ampliar.Sx=1.1;
            ampliar.Sz=1.1;
            ampliar.movimiento();

        }
        if (c == 'm')
		{
            ampliar.Sy=0.9;
            ampliar.Sx=0.9;
            ampliar.Sz=0.9;
            ampliar.movimiento();

        }
        //Proyeccion
        if (c == 'z')
		{
			proyeccion.d-=10;
            proyeccion.movimiento();

        }
        if (c == 'x')
		{
            proyeccion.d+=10;
            proyeccion.movimiento();

        }
	}
	public void keyReleased(KeyEvent e) 
	{
		char c = e.getKeyChar();
		//System.out.println("Key Released: " + c);
	}
}