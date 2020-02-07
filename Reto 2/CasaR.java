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
        int[] linea2 = { 50, 130, 300, 130 };

        clipping.algoritmo_clipping(linea1, g2d);
        clipping.algoritmo_clipping(linea2, g2d);

    }

    public void algoritmo_clipping(int[] linea,Graphics2D g2d){
        float t1,t2,temp;
        float[] p = new float[4];
        float[] q= new float[4];
        int xx1,xx2,yy1,yy2,dx,dy;

        dx=linea[2]-linea[0];
        dy=linea[3]-linea[1];

        p[0]=-dx;
        p[1]=dx;
        p[2]=-dy;
        p[3]=dy;

        q[0]=linea[0]-x_min;
        q[1]=x_max-linea[0];
        q[2]=linea[1]-y_min;
        q[3]=y_max-linea[1];

        for(int i=0;i<4;i++)
        {
            if(p[i]==0)
            {
                if(q[i]>=0)
                {
                    if(i<2)
                    {
                        if(linea[1]<y_min)
                        {
                            linea[1]=y_min;
                        }
                    
                        if(linea[3]>y_max)
                        {
                            linea[3]=y_max;
                        }
                        g2d.setColor(Color.red);
                        g2d.drawLine(linea[0],linea[1],linea[2],linea[3]);
                        g2d.setColor(Color.blue);
                    }
                    
                    if(i>1)
                    {
                        if(linea[0]<x_min)
                        {
                            linea[0]=x_min;
                        }
                        
                        if(linea[3]>x_max)
                        {
                            linea[3]=x_max;
                        }
                        g2d.setColor(Color.red);
                        g2d.drawLine(linea[0],linea[1],linea[2],linea[3]);
                        g2d.setColor(Color.blue);
                    }
                }
            }
        }
        
        t1=0;
        t2=1;
        
        for(int i=0;i<4;i++)
        {
            temp=q[i]/p[i];
            
            if(p[i]<0)
            {
                if(t1<=temp)
                    t1=temp;
            }
            else
            {
                if(t2>temp)
                    t2=temp;
            }
        }
	
        if(t1<t2)
        {
            xx1 = linea[0] + (int)t1 * (int) p[1];
            xx2 = linea[0] + (int)t2 * (int)p[1];
            yy1 = linea[1] + (int)t1 * (int)p[3];
            yy2 = linea[1] + (int)t2 * (int)p[3];
            g2d.setColor(Color.blue);
            g2d.drawLine(xx1,yy1,xx2,yy2);
        }
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