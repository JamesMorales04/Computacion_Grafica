public class Point3{

    int[] punto;
    double[] punto_d;

    public Point3(int x1, int y1, int w1){
        punto=new int[]{x1,y1,w1};
    }    

    public Point3(Double x1, Double y1, Double w1){
        punto_d=new double[]{x1,y1,w1};
    }    

}