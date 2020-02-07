import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.JFrame;


public class CasaR extends JPanel {

  /*
   * En esta función se dibuja. La función es llamada por Java2D. Se recibe una
   * variable Graphics, que contiene la información del contexto gráfico. Es
   * necesario hacerle un cast a Graphics2D para trabajar en Java2D.
   */

  public void paintComponent(Graphics g) {

    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.black);
    g2d.drawRect(0, 0, 400, 400);

    CasaR cosa = new CasaR();

    int x1 = 0;
    int y1 = 100;
    int x2 = 400;
    int y2 = 400;
    int x3 = 50;
    int y3 = 450;
    int x4 = 0;
    int y4 = 400;

    for (int i = 0; i <= 20; i++) {
      cosa.linea(x1, 400, 50, y1, g2d);
      cosa.linea(x2, 0, 450, y2, g2d);
      cosa.linea(0, x3, y3, 50, g2d);
      cosa.linea(x4, 400, 450, y4, g2d);

      x2 -= 20;
      y2 -= 20;
      x1 += 20;
      y1 += 20;
      x3 += 20;
      y3 -= 20;
      x4 += 20;
      y4 -= 20;

    }
  }

  public void linea(int x1, int x2, int y1, int y2, Graphics2D g2d) {

    int d = 0;

    int dx = Math.abs(x2 - x1)*2;
    int dy = Math.abs(y2 - y1)*2;
    
    int x = x1;
    int y = y1;

    int ix;
    int iy;

    if(x1<x2){
      ix=1;
    }else{
      ix=-1;
    }

    if(y1<y2){
      iy=1;
    }else{
      iy=-1;
    }

    
    if (dx >= dy) {
      while (x != x2) {
        g2d.drawLine(x, 450 - y, x, 450 - y);
        x += ix;
        d += dy;
        if (d > (dx/2)) {
          y += iy;
          d -= dx;
        }
      }
    } else {
      while (y != y2) {
        g2d.drawLine(x, 450 - y, x, 450 - y);
        y += iy;
        d += dx;
        if (d > (dy/2)) {
          x += ix;
          d -= dy;
        }
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