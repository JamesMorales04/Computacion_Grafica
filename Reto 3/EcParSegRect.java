public class EcParSegRect {
    int[] punto1 = new int[2];
    int[] punto2= new int[2];
    public EcParSegRect(int x1,int y1, int x2, int y2){
        punto1[0]=x1;
        punto1[1]=y1;
        punto2[0]=x2;
        punto2[1]=y2;
    }
    public static int[] solve(EcParSegRect epsr1, EcParSegRect epsr2) {
        int[] valor = new int[2];
        double m1 = (epsr1.punto2[1] - epsr1.punto1[1])/(epsr1.punto2[0] - epsr1.punto1[0]);
        double m2 = (epsr2.punto2[1] - epsr2.punto1[1])/(epsr2.punto2[0] - epsr2.punto1[0]);
        return valor;
    }
    public static void main(String[] args) {
        
    }
}