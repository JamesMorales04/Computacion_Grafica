/**
 * Translacion
 */
public class Translacion {

    Edge puntos;
    double dx,dy,dz;

    public Translacion(double dx, double dy, double dz, Edge puntos){
        this.puntos= puntos;
        this.dx=dx;
        this.dy=dy;
        this.dz=dz;
    }

    public void movimiento(){
        for (int i = 0; i < puntos.nodos.length; i++) {
            Point4 nuevo_valor=nueva_posicion(this.puntos.nodos[i][0], this.puntos.nodos[i][1],this.puntos.nodos[i][2]);
            this.puntos.nodos[i][0]=nuevo_valor.punto_d[0];
            this.puntos.nodos[i][1]=nuevo_valor.punto_d[1];
            this.puntos.nodos[i][2]=nuevo_valor.punto_d[2];
        }
    }
    public void movimiento_inverso(){
        for (int i = 0; i < puntos.nodos.length; i++) {
            Point4 nuevo_valor=nueva_posicion_inverso(this.puntos.nodos[i][0], this.puntos.nodos[i][1],this.puntos.nodos[i][2]);
            this.puntos.nodos[i][0]=nuevo_valor.punto_d[0];
            this.puntos.nodos[i][1]=nuevo_valor.punto_d[1];
            this.puntos.nodos[i][2]=nuevo_valor.punto_d[2];
        }
    }
    public void movimiento_inverso_re(){
        for (int i = 0; i < puntos.nodos.length; i++) {
            Point4 nuevo_valor=nueva_posicion_retornar(this.puntos.nodos[i][0], this.puntos.nodos[i][1],this.puntos.nodos[i][2]);
            this.puntos.nodos[i][0]=nuevo_valor.punto_d[0];
            this.puntos.nodos[i][1]=nuevo_valor.punto_d[1];
            this.puntos.nodos[i][2]=nuevo_valor.punto_d[2];
        }
    }
    public Point4 nueva_posicion(double x, double y,double z){
        Matrix4x4 matriz_translacion = new Matrix4x4();
        double[][] matriz = new double[4][4];
        Point4 punto= new Point4(x, y, z ,1.0);

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j]=0;

                if(i==j){
                    matriz[i][j]=1.0;
                }
                if(j==3 && i!=3){
                    if(i==0){
                        matriz[i][j]=this.dx;
                    }
                    if(i==1){
                        matriz[i][j]=this.dy;
                    }
                    if(i==2){
                        matriz[i][j]=this.dz;
                    }

                }
            }
        }

        return matriz_translacion.times(matriz, punto);
    }
    public Point4 nueva_posicion_inverso(double x, double y,double z){
        Matrix4x4 matriz_translacion = new Matrix4x4();
        double[][] matriz = new double[4][4];
        Point4 punto= new Point4(x, y, z ,1.0);

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j]=0;
                
                if(i==j){
                    matriz[i][j]=1.0;
                }
                if(j==3 && i!=3){
                    if(i==0){
                        matriz[i][j]=-this.dx;
                    }
                    if(i==1){
                        matriz[i][j]=-this.dy;
                    }
                    if(i==2){
                        matriz[i][j]=-this.dz;
                    }

                }
            }
        }
        return matriz_translacion.times(matriz, punto);
    }
    public Point4 nueva_posicion_retornar(double x, double y,double z){
        Matrix4x4 matriz_translacion = new Matrix4x4();
        double[][] matriz = new double[4][4];
        Point4 punto= new Point4(x, y, z ,1.0);

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j]=0;
                
                if(i==j){
                    matriz[i][j]=1.0;
                }
                if(j==3 && i!=3){
                    if(i==0){
                        matriz[i][j]=-x;
                    }
                    if(i==1){
                        matriz[i][j]=-y;
                    }
                    if(i==2){
                        matriz[i][j]=-z;
                    }

                }
            }
        }
        return matriz_translacion.times(matriz, punto);
    }
    

}