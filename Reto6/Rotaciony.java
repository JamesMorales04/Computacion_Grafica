
/**
 * Escalado
 */
public class Rotaciony {
    Edge puntos;
    double angulo;

    public Rotaciony(double angulo, Edge punto){
        this.puntos= punto;
        this.angulo=angulo;
    }

    public void movimiento(){
        System.out.println(puntos.nodos.length);
        for (int i = 0; i < puntos.nodos.length; i++) {
            Point4 nuevo_valor=nueva_posicion(this.puntos.nodos[i][0],this.puntos.nodos[i][1],this.puntos.nodos[i][2]);
            this.puntos.nodos[i][0]=nuevo_valor.punto_d[0];
            this.puntos.nodos[i][1]=nuevo_valor.punto_d[1];
            this.puntos.nodos[i][2]=nuevo_valor.punto_d[2];
        }

    }

    public Point4 nueva_posicion(double x, double y, double z){
        Matrix4x4 matriz_translacion = new Matrix4x4();
        double[][] matriz = new double[4][4];
        Point4 punto= new Point4(x, y, z,1.0);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j]=0;

                
                if(i==j){
                    matriz[i][j]=1.0;
                    if(i==1 || i==2){
                        matriz[i][j]=Math.cos(this.angulo);
                    }

                }
                if(i==2 && j==0){
                    matriz[i][j]=-Math.sin(this.angulo);
                }
                if(i==0 && j==2){
                    matriz[i][j]=Math.sin(this.angulo);
                }
            }
        }
        return matriz_translacion.times(matriz, punto);
    }
    
    /*public static void main(String[] args) {
        Escalado prueba = new Escalado(0.9, 1.1);
        prueba.movimiento();
        for (int i = 0; i < prueba.puntos.nodos.length; i++) {
            for (int j = 0; j < prueba.puntos.nodos[i].length; j++) {
                System.out.print(prueba.puntos.nodos[i][j]+" ");
            }
            System.out.println();
        }
    }*/

}
    

