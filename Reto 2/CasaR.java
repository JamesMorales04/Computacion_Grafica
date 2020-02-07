import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class CasaR extends JPanel {

    int x_max = 200;
    int y_max = 200;
    int x_min = 100;
    int y_min = 100;

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.drawRect(100, 100, 100, 100);

        CasaR clipping = new CasaR();

        int[] linea1 = { 105, 105, 190, 190 };
        int[] linea2 = { 50, 130, 300, 300 };

        clipping.algoritmo_clipping(linea1, g2d);
        clipping.algoritmo_clipping(linea2, g2d);

    }

    int maximo(int arr[], int n) {
        int m = 0;
        for (int i = 0; i < n; ++i)
            if (m < arr[i])
                m = arr[i];
        return m;
    }

    int minimo(int arr[], int n) {
        int m = 1;
        for (int i = 0; i < n; ++i)
            if (m > arr[i])
                m = arr[i];
        return m;
    }

    void algoritmo_clipping(int[] Linea, Graphics2D g2d) {
        
        int[] p=new int[4];

        p[0] = -(Linea[2] - Linea[0]);
        p[1]= -p[0];
        p[2]= -(Linea[3] - Linea[1]);
        p[3]= -p[2];

        int[] q=new int[4];

        q[0] = Linea[0] - x_min;
        q[1]= x_max - Linea[0];
        q[2]= Linea[1] - y_min;
        q[3]= y_max - Linea[1];

        int[] posarr= new int[5];
        int[] negarr= new int[5];
        int posind = 1, negind = 1;

        posarr[0] = 1;
        negarr[0] = 0;

        if (p[0] != 0) {
            int r1 = q[0] / p[0];
            int r2 = q[1] / p[1];
            if (p[0] < 0) {
            negarr[negind++] = r1; // for negative p[0], add it to negative array
            posarr[posind++] = r2; // and add p[1] to positive array
            } else {
            negarr[negind++] = r2;
            posarr[posind++] = r1;
            }
        }
        if (p[2] != 0) {
            int r3 = q[2] / p[2];
            int r4 = q[3] / p[3];
            if (p[2] < 0) {
            negarr[negind++] = r3;
            posarr[posind++] = r4;
            } else {
            negarr[negind++] = r4;
            posarr[posind++] = r3;
            }
        }

        int xn1, yn1, xn2, yn2;
        int rn1, rn2;
        rn1 = maximo(negarr, negind); // maximum of negative array
        rn2 = minimo(posarr, posind); // minimum of positive array

       
        xn1 = Linea[0] + p[1] * rn1;
        yn1 = Linea[1] + p[3] * rn1;

        xn2 = Linea[0] + p[1] * rn2;
        yn2 = Linea[1] + p[3] * rn2;

        System.out.println(xn1);
        
        g2d.drawLine(xn1, yn1, xn2,yn2); 

        g2d.setColor(Color.blue);

        g2d.drawLine(Linea[0],  Linea[1], xn1, yn1);

        g2d.setColor(Color.red);

        g2d.drawLine(Linea[2],  Linea[3], xn2, yn2);
        
        
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Reto Casa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new CasaR());
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}