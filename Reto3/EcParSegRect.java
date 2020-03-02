public class EcParSegRect {
    double[] punto1 = new double[2];
    double[] punto2 = new double[2];
    public EcParSegRect(double x1,double y1, double x2, double y2){
        punto1[0]=x1;
        punto1[1]=y1;
        punto2[0]=x2;
        punto2[1]=y2;
    }
    public static double[] solve(EcParSegRect epsr1, EcParSegRect epsr2) {
        double[] valor = new double[2];
        double m1 = (epsr1.punto2[1] - epsr1.punto1[1])/(epsr1.punto2[0] - epsr1.punto1[0]);
        double m2 = (epsr2.punto2[1] - epsr2.punto1[1])/(epsr2.punto2[0] - epsr2.punto1[0]);
        if (m1==m2){
            System.out.println("Las lineas son paralelas");
            System.exit(0);
        }
        double b1 = (epsr1.punto1[1] - m1*(epsr1.punto1[0]));
        double b2 = (epsr2.punto1[1] - m2*(epsr2.punto1[0]));
        valor [0] = (b2-b1) / (m1-m2);
        valor [1] = (m1) * valor[0] + b1;
        System.out.println(valor[0]+" "+valor[1]);
        return valor;
    }
    public static void main(String[] args) {
        EcParSegRect ecu1 = new EcParSegRect(9.6, 8, 11, 4);
        EcParSegRect ecu2 = new EcParSegRect(8, 15, -2.3, 5);
        solve(ecu1, ecu2);
    }
}