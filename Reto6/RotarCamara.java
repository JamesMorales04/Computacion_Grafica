/**
 * RotarCamara
 */
public class RotarCamara {
    Edge puntos;

    public RotarCamara(Edge punto) {
        this.puntos = punto;
    }

    public Point4 nueva_posicion(double x, double y, double z) {
        Matrix4x4 matriz_translacion = new Matrix4x4();
        double[][] matriz = new double[4][4];
        Point4 punto = new Point4(x, y, z, 1.0);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = 0;
            }
        }
        return matriz_translacion.times(matriz, punto);
    }
}