/**
 * ClaseR
 */
public class Proyeccion {
    Edge puntos;
    int d;

    public Proyeccion(int d, Edge puntos){
        this.puntos= puntos;
        this.d=d;
    }

    public void movimiento(){

        for (int i = 0; i < puntos.nodos.length; i++) {
            Point4 nuevo_valor=nueva_posicion(this.puntos.nodos[i][0], this.puntos.nodos[i][1], this.puntos.nodos[i][2]);
            this.puntos.nodos[i][0]=nuevo_valor.punto_d[0]/(nuevo_valor.punto_d[2]/d);
            this.puntos.nodos[i][1]=nuevo_valor.punto_d[1]/(nuevo_valor.punto_d[2]/d);
            this.puntos.nodos[i][2]=nuevo_valor.punto_d[2]/(nuevo_valor.punto_d[2]/d);
            
        }

    }

    public Point4 nueva_posicion(double x, double y,double z){
        Matrix4x4 matriz_translacion = new Matrix4x4();
        double[][] matriz = new double[4][4];
        Point4 punto= new Point4(x, y, z,1.0);

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                matriz[i][j]=0;

                if(i==j && i!=3){
                    matriz[i][j]=1.0;
                }
                if(i==3 && j==2){
                    matriz[i][j]=1/this.d;
                    System.out.println(1/d);
                }
            }
        }


        return matriz_translacion.times(matriz, punto);
    }


    
    public static void main(String[] args) {
        
        Edge cosa2= new Edge();
        cosa2.leer_archivo();
        Proyeccion cosa= new Proyeccion(-500,cosa2);
        cosa.movimiento();
        
    }
}