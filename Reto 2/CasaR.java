import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.Random; 

public class CasaR extends JPanel {

    static int[][] lineas = new int[100][1];
    int x_max = 200;
    int y_max = 200;
    int x_min = 100;
    int y_min = 100;

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.drawRect(100, 100, 100, 100);

        CasaR clipping = new CasaR();

        //int[] linea1 = { 105, 105, 190, 190 };
        //int[] linea2 = { 50, 130, 300, 300 };

        
        for (int i = 0; i < 100; i++) {
            clipping.algoritmo_clipping(lineas[i], g2d);
        }


    }

    static int[] generador_lineas(){
        int[] linea= new int[4];
        for (int i = 0; i < linea.length; i++) {
            linea[i]=(int)(Math.random()*300);
        }
        return linea;
    }

    double maximo(double arr[], int n) {
        double m = 0;
        for (int i = 0; i < n; ++i){


            if (m < arr[i]){
                m = arr[i];
            }
        }
        return m;
    }

    double minimo(double arr[], int n) {
        double m = 1;
        for (int i = 0; i < n; ++i){
            if (m > arr[i]){
                m = arr[i];
            }
        }
        return m;
    }

    void algoritmo_clipping(int[] Linea, Graphics2D g2d) {
        
        double[] p=new double[4];

        p[0] = -(Linea[2] - Linea[0]);
        p[1]= -p[0];
        p[2]= -(Linea[3] - Linea[1]);
        p[3]= -p[2];

        double[] q=new double[4];

        q[0] = Linea[0] - x_min;
        q[1]= x_max - Linea[0];
        q[2]= Linea[1] - y_min;
        q[3]= y_max - Linea[1];

        double[] posarr= new double[5];
        double[] negarr= new double[5];
        int posind = 1, negind = 1;

        posarr[0] = 1;
        negarr[0] = 0;

        if (p[0] != 0) {
            double r1 = q[0] / p[0];
            double r2 = q[1] / p[1];
            if (p[0] < 0) {
                negarr[negind++] = r1; 
                posarr[posind++] = r2; 
            } else {
                negarr[negind++] = r2;
                posarr[posind++] = r1;
            }
        }
        if (p[2] != 0) {
            double r3 = q[2] / p[2];
            double r4 = q[3] / p[3];
            if (p[2] < 0) {
                negarr[negind++] = r3;
                posarr[posind++] = r4;
            } else {
                negarr[negind++] = r4;
                posarr[posind++] = r3;
            }
        }
        
        double xn1, yn1, xn2, yn2;
        double rn1, rn2;
        rn1 = maximo(negarr, negind); 
        rn2 = minimo(posarr, posind); 

       
        xn1 = Linea[0] + p[1] * rn1;
        yn1 = Linea[1] + p[3] * rn1;

        xn2 = Linea[0] + p[1] * rn2;
        yn2 = Linea[1] + p[3] * rn2;

        g2d.setColor(Color.blue);
        
        g2d.drawLine((int)Math.round(xn1),(int) Math.round(yn1), (int)Math.round(xn2),(int)Math.round(yn2)); 

        g2d.setColor(Color.red);

        g2d.drawLine(Linea[0],  Linea[1], (int)Math.round(xn1),(int) Math.round(yn1));

        g2d.drawLine(Linea[2],  Linea[3], (int)Math.round(xn2), (int)Math.round(yn2));
        
        
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Reto Casa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new CasaR());
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        for (int i = 0; i < 100; i++) {
            lineas[i]=generador_lineas();
        }
    }
}