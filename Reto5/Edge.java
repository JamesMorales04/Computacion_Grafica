import java.io.*;



public class Edge{

    double[][] nodos;
    double[][] aristas;

    public void leer_archivo(){
        int a=0;
        int con=0;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File ("Reto5/casa.txt");
			fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            System.out.println("Leyendo el contendio del archivo.txt");
            String linea;
            while ((linea=br.readLine())!=null) {
                if (linea.indexOf(" ")!=-1 ) {
                    String[] nodo=linea.split(" ",3);
                    nodos[con][0] =Integer.parseInt(nodo[0]);
                    nodos[con][1] =Integer.parseInt(nodo[1]);
                    nodos[con][2] =Integer.parseInt(""+nodo[2].substring(2,5));
                    con +=1;
                    if(con==a){
                        break;
                    }
                }
                else{
                    a =Integer.parseInt(linea);
                    nodos = new double[a][3];
                }
            }
            con=0;
            while ((linea=br.readLine())!=null) {
                if (linea.indexOf(" ")!=-1 ) {
                    String[] nodo=linea.split(" ",2);
                    aristas[con][0] =Integer.parseInt(nodo[0]);
                    aristas[con][1] =Integer.parseInt(nodo[1]);
                    con +=1;
                    if(con==a){
                        break;
                    }
                }
                else{
                    a =Integer.parseInt(linea);
                    aristas = new double[a][2];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if( null != fr ){
                    fr.close();
                 }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
        
    }
    
    public static void main(String[] args) {
        Edge cosa= new Edge();
        cosa.leer_archivo();
        for (int i = 0; i < cosa.nodos.length; i++) {
            for (int j = 0; j < cosa.nodos[i].length; j++) {
                System.out.print(cosa.nodos[i][j]+"  ");
            }
            System.out.println();
        }
    }
    
}
