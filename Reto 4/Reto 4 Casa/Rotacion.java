
/**
 * Escalado
 */
public class Rotacion {
    Edge puntos;
    double angulo;

    public Rotacion(double angulo, Edge punto){
        this.puntos= punto;
        this.angulo=angulo;
    }

    public void movimiento(){
        
        for (int i = 0; i < puntos.nodos.length; i++) {
            Point3 nuevo_valor=nueva_posicion((double)this.puntos.nodos[i][0],(double) this.puntos.nodos[i][1]);
            this.puntos.nodos[i][0]=(int)nuevo_valor.punto_d[0];
            this.puntos.nodos[i][1]=(int)nuevo_valor.punto_d[1];
        }

    }

    public Point3 nueva_posicion(double x, double y){
        Matrix3x3 matriz_translacion = new Matrix3x3();
        double[][] matriz = new double[3][3];
        Point3 punto= new Point3(x, y, 1.0);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                switch (j) {
                    case 0:
                        if(i==0){
                            matriz[i][j]=Math.cos(angulo);
                        }else if(i==1){
                            matriz[i][j]=Math.sin(angulo);
                        }else{
                            matriz[i][j]=0;
                        }
                        break;
                    case 1:
                        if(i==0){
                            matriz[i][j]=-Math.sin(angulo);
                        }else if(i==1){
                            matriz[i][j]=Math.cos(angulo);
                        }else{
                            matriz[i][j]=0.0;
                        }
                        break;
                    case 2:
                        if(i==2){
                            matriz[i][j]=1.0;
                        }
                        else{
                            matriz[i][j]=0.0;
                        }
                        break;

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
    

