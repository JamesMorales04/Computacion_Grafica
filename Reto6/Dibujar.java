import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JFrame;
/**
 * Dibujar
 */
public class Dibujar extends JPanel{

    static Edge punto;
    static Proyeccion proyeccion;
    static Translacion mover;
    static Escalado ampliar;
    static Rotacionx rotarx;
    static Rotaciony rotary;
    static Rotacionz rotarz;

    public Dibujar(){
        this.punto= new Edge();
        this.punto.leer_archivo();
        this.proyeccion= new Proyeccion(-500,punto);
        this.proyeccion.movimiento();
        this.mover= new Translacion(0,0,0,this.punto);
        this.ampliar= new Escalado(0.9, 1.1,0, this.punto);
        this.rotarx= new Rotacionx(0.0,punto);
        this.rotary= new Rotaciony(0.0,punto);
        this.rotarz= new Rotacionz(0.0,punto);

    }

    public void dibujar(Graphics g2d, double[][] nodo, int[][] arista) {
        double[][] nodos= nodo;
        int[][] aristas= arista;

        g2d.setColor(Color.black);
        int con = aristas.length;

        for (int i = 0; i < con; i++) {
            
            int x1 = (int)nodos[aristas[i][0]][0] ;
            int y1 = 448 - (int)nodos[aristas[i][0]][1];
            int x2 = (int)nodos[aristas[i][1]][0];
            int y2 = 448 - (int)nodos[aristas[i][1]][1];
            g2d.drawLine(x1,y1,x2,y2);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        dibujar(g2d, punto.nodos, punto.aristas);
        repaint();
        
    }
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Reto Casa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Dibujar());
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); 
        frame.addKeyListener(new Keylistener(mover,ampliar,rotarx,rotary,rotarz,proyeccion));
  
    }
}