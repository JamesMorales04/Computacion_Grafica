import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.util.Random; 


public class ClaseR extends JPanel {

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

        g2d.setColor(Color.blue);

        g2d.drawLine(200, 100, 200, 300);
        g2d.drawLine(100, 200, 300, 200);

        int x1=100;
        int x2=200;
        int y1=150;
        int y2=200;
        //line(150, 150, 300,250 );
        int dy= y2-y1;
        int dx= x2-x1;
        int incE=2*dy;
        int incNE=2*dy-2*dx;
        int d=2*dy-dx;
        int y=y1;
        for (int x = x1; x <=x2; x++) {

            g2d.drawLine(x+150, 300-y, x+150, 300-y);
            if(d<=0){
                d+=incE;
            }else{
                d+=incNE;
                y+=1;
            }
        }
  }

  public static void main(String[] args) {
        JFrame frame = new JFrame("Reto Clase");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ClaseR());
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        
  }
}