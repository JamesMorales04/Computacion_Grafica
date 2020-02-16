import java.io.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class Edge extends JPanel {
    int[][] nodos;
    int[][] aristas;
    public void leer_archivo(Graphics g2d){
        int x1;
        int x2;
        int y1;
        int y2;
        int a=0;
        int con=0;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File ("Reto 3/casa.txt");
			fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            System.out.println("Leyendo el contendio del archivo.txt");
            String linea;
            while ((linea=br.readLine())!=null) {
                if (linea.indexOf(" ")!=-1 ) {
                    String[] nodo=linea.split(" ",2);
                    nodos[con][0] =Integer.parseInt(nodo[0]);
                    nodos[con][1] =Integer.parseInt(nodo[1]);
                    con +=1;
                    if(con==a){
                        break;
                    }
                }
                else{
                    a =Integer.parseInt(linea);
                    nodos = new int[a][2];
                }
            }
            con=0;
            while ((linea=br.readLine())!=null) {
                if (linea.indexOf(" ")!=-1 ) {
                    String[] nodo=linea.split(" ",2);
                    aristas[con][0] =Integer.parseInt(nodo[0]);
                    aristas[con][1] =Integer.parseInt(nodo[1]);
                    con +=1;
                    if(con==a){
                        break;
                    }
                }
                else{
                    a =Integer.parseInt(linea);
                    aristas = new int[a][2];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if( null != fr ){
                    fr.close();
                 }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
        g2d.setColor(Color.black);
        con = aristas.length;
        for (int i = 0; i < con; i++) {
        x1 = nodos[aristas[i][0]][0];
        y1 = 448 - nodos[aristas[i][0]][1];
        x2 = nodos[aristas[i][1]][0];
        y2 = 448 - nodos[aristas[i][1]][1];
        g2d.drawLine(x1,y1,x2,y2);
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Edge ed = new Edge();
        ed.leer_archivo(g);
    }
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Reto Casa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Edge());
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);   
    }
}