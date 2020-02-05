import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.util.Random;

public class ClaseR extends JPanel {
    

    int dentro = 0;
    int izquierda = 1;
    int derecha = 2;
    int abajo = 8;
    int arriba = 4;

    int x_max = 200;
    int y_max = 200;
    int x_min = 100;
    int y_min = 100;

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.drawRect(100, 100, 100, 100);

        ClaseR clipping = new ClaseR();

        int[] linea1 = { 105, 105, 190, 190 };
        int[] linea2 = { 300, 100, 190, 300 };
        int [][] lineas_plus= {linea1,linea2};
        boolean[] lineas = new boolean[2];

        lineas[0] = clipping.algoritmo_clipping(linea1);
        lineas[1] = clipping.algoritmo_clipping(linea2);

        for (int i = 0; i < 2; i++) {
            if (lineas[i]==true){
                g2d.setColor(Color.blue);
            }else{
                g2d.setColor(Color.red);
            }
            g2d.drawLine(lineas_plus[i][0], lineas_plus[i][1], lineas_plus[i][2], lineas_plus[i][3]);
        }

        System.out.println(lineas[0]);
        System.out.println(lineas[1]);

    }

    public int OutCode(int x, int y) {

        int code = dentro;
        if (x < x_min) {
            code = izquierda;
        } else if (x > x_max) {
            code = derecha;
        }
        if (y < y_min) {
            code = abajo;
        } else if (y > y_max) {
            code = arriba;
        }
        return code;

    }

    public boolean algoritmo_clipping(int[] linea){

        System.out.println(OutCode(250,100)); 
        System.out.println(OutCode(250,20)); 

        // Compute region codes for P1, P2 
        int code1 = OutCode(linea[0], linea[1]); 
        int code2 = OutCode(linea[2], linea[3]); 
  
        // Initialize line as outside the rectangular window 
        boolean aceptado = false; 
  
        while (true) 
        { 
            if ((code1 == 0) && (code2 == 0)) 
            { 
                // If both endpoints lie within rectangle 
                aceptado = true; 
                break; 
            } 
            else if ((code1 & code2)!=0)
            { 
                // If both endpoints are outside rectangle, 
                // in same region 
                break; 
            }
            else{
                break;
            }
        }
        return aceptado;

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