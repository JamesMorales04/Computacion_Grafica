public class Vector4 {

    double[] punto;

    public Vector4(Double x, Double y, double z){
        punto=new double[]{x,y,z};
    }    



    public static Vector4 crossProduct(Vector4 vector1, Vector4 vector2) {
        
        double x=(vector1.punto[1]*vector2.punto[2])-(vector1.punto[2]*vector2.punto[1]);
        double y=(vector1.punto[2]*vector2.punto[0])-(vector1.punto[0]*vector2.punto[2]);
        double z=(vector1.punto[0]*vector2.punto[1])-(vector1.punto[1]*vector2.punto[0]);
        Vector4 valor = new Vector4(x,y ,z );


        return valor;
    }

    public static double dotProduct(Vector4 vector1, Vector4 vector2) {
        double valor=0;
        for (int i = 0; i < vector1.punto.length;i++) {
            valor+=vector1.punto[i]*vector2.punto[i];
        }
        return valor;
    }

    public double magnitude() {
        double operaciones=Math.pow(punto[0], 2)+Math.pow(punto[1], 2)+Math.pow(punto[2], 2);
        double raiz=Math.sqrt(operaciones);
        double valor=Math.abs(raiz);
        return valor;
    }

    public void normalice(){
        double magnitud= magnitude();
        for (int i = 0; i < punto.length; i++) {
            punto[i]=punto[i]/magnitud;
        }
    }

    public static void main(String[] args) {

        Vector4 vector1 = new Vector4(2.0, 5.0, 4.0);
        Vector4 vector2 = new Vector4(4.0, 3.0, 7.0);
        
        System.out.println(vector1.magnitude());
    }
}