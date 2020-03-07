/**
 * Matrix3x3
 */


public class Matrix4x4 {

    public static Point4 times(int[][] matriz, Point4 punto) {
        int x=0,y=0,z=0,w=0;
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
                        z+=matriz[i][j]*punto.punto[j];
                        break;
                    case 3:
                        w+=matriz[i][j]*punto.punto[j];
                        break;

                }
            }
        }
        Point4 valor = new Point4(x, y, z,w);
        return valor;
    }

    public static int[][] times(int[][] matriz1, int[][] matriz2) {
        int[][] matriz_resultado= new int[4][4];
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
        double[][] matriz_resultado= new double[4][4];
        for (int i = 0; i < matriz1.length; i++) {

            for (int j = 0; j < matriz1[i].length; j++) {

                for (int k = 0; k < matriz1.length; k++) {
                    matriz_resultado[i][j]+=matriz1[i][k]*matriz2[k][j];
                }
            }
        }
        return matriz_resultado;
    }

    public static Point4 times(double[][] matriz, Point4 punto) {
        double x=0,y=0,z=0,w=0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                switch (i) {
                    case 0:
                        x+=matriz[i][j]*punto.punto_d[j];
                        break;
                    case 1:
                        y+=matriz[i][j]*punto.punto_d[j];
                        break;
                    case 2:
                        z+=matriz[i][j]*punto.punto_d[j];
                        break;
                    case 3:
                        w+=matriz[i][j]*punto.punto_d[j];
                        break;

                }
            }
        }
        Point4 valor = new Point4(x, y, z,w);
        return valor;
    }
    
}