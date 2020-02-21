/**
 * Translacion
 */
public class Translacion {

    Edge puntos;
    int dx;
    int dy;

    public Translacion(int dx, int dy, Edge puntos){
        this.puntos= puntos;
        this.puntos.leer_archivo();
        this.dx=dx;
        this.dy=dy;
    }

    public void movimiento(){

        for (int i = 0; i < puntos.nodos.length; i++) {
            Point3 nuevo_valor=nueva_posicion(this.puntos.nodos[i][0], this.puntos.nodos[i][1],dx,dy);
            this.puntos.nodos[i][0]=nuevo_valor.punto[0];
            this.puntos.nodos[i][1]=nuevo_valor.punto[1];
        }

    }

    public Point3 nueva_posicion(int x, int y,int dx, int dy){
        Matrix3x3 matriz_translacion = new Matrix3x3();
        int[][] matriz = new int[3][3];
        Point3 punto= new Point3(x, y, 1);

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                switch (j) {
                    case 0:
                        if(i==0){
                            matriz[i][j]=1;
                        }else{
                            matriz[i][j]=0;
                        }
                        break;
                    case 1:
                        if(i==1){
                            matriz[i][j]=1;
                        }else{
                            matriz[i][j]=0;
                        }
                        break;
                    case 2:
                        if(i==0){
                            matriz[i][j]=dx;
                        }else if(i==1){
                            matriz[i][j]=dy;
                        }
                        else{
                            matriz[i][j]=1;
                        }
                        break;

                }
            }
        }

        return matriz_translacion.times(matriz, punto);
    }
    

}