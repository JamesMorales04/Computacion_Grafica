package Computacion_Grafica.Reto3;

public class Matrix3x3 {

    public static Point3 times(int[][] matriz, Point3 punto) {
        int x=0,y=0,w=0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                switch (i) {
                    case 0:
                        x+=matriz[i][j]*punto.punto[j];
                        break;
                    case 1:
                        y+=matriz[i][j]*punto.punto[j];
                        break;
                    case 2:
                        w+=matriz[i][j]*punto.punto[j];
                        break;

                }
            }
        }
        Point3 valor = new Point3(x, y, w);
        return valor;
    }

    public static int[][] times(int[][] matriz1, int[][] matriz2) {
        int[][] matriz_resultado= new int[3][3];
        for (int i = 0; i < matriz1.length; i++) {

            for (int j = 0; j < matriz1[i].length; j++) {

                for (int k = 0; k < matriz1.length; k++) {
                    matriz_resultado[i][j]+=matriz1[i][k]*matriz2[k][j];
                }
            }
        }
        return matriz_resultado;
    }

    public static double[][] times(double[][] matriz1, double[][] matriz2) {
        double[][] matriz_resultado= new double[3][3];
        for (int i = 0; i < matriz1.length; i++) {

            for (int j = 0; j < matriz1[i].length; j++) {

                for (int k = 0; k < matriz1.length; k++) {
                    matriz_resultado[i][j]+=matriz1[i][k]*matriz2[k][j];
                }
            }
        }
        return matriz_resultado;
    }

    public static Point3 times(Double[][] matriz, Point3 punto) {
        double x=0,y=0,w=0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                switch (i) {
                    case 0:
                        x+=matriz[i][j]*punto.punto[j];
                        break;
                    case 1:
                        y+=matriz[i][j]*punto.punto[j];
                        break;
                    case 2:
                        w+=matriz[i][j]*punto.punto[j];
                        break;

                }
            }
        }
        Point3 valor = new Point3(x, y, w);
        return valor;
    }
    
}