import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.util.Random; 


public class CasaR extends JPanel {

  /*
   * En esta función se dibuja.
   * La función es llamada por Java2D.
   * Se recibe una variable Graphics, que contiene la información del contexto
   * gráfico.
   * Es necesario hacerle un cast a Graphics2D para trabajar en Java2D.
   */
  
  public void paintComponent(Graphics g) {
        
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.black);
    g2d.drawRect(0, 0, 400, 400);

    CasaR cosa = new CasaR();
    int y=50;
    int x=100;
    for (int i = 0 ; i <= 8 ; i++) {
      cosa.linea(y, 400, 50, x,g2d);
      y+=50;
      x+=50;
    }
  }

  public void linea(int x1,int x2,int y1,int y2, Graphics2D g2d) {

    int dy= y2-y1;
    int dx= x2-x1;
    int incE=2*dy;
    int incNE=2*dy-2*dx;
    int d=2*dy-dx;
    int y=y1;
    for (int x = x1; x <=x2; x++) {

        g2d.drawLine(x,450-y,x,450-y);
        if(d<=0){
            d+=incE;
        }else{
            d+=incNE;
            y+=1;
        }
    }
  }

  public static void main(String[] args) {
        JFrame frame = new JFrame("Reto Casa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new CasaR());
        frame.setSize(419, 448);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
  }
}