
package pkg8reinas;


public class Main 
{
    int[][] tablero;
    int N;
    int cont=0;
    public Main()
    {
        
        N = 8;
        tablero = new int[N][N];
        inicializarTablero();        
        solucion(0);
        System.out.println("Cantidad de soluciones: "+cont);
    }
    
    public static void main(String[] args) {
        Main ProblemaReinas = new Main();
    }
    
    public void solucion(int p){ //p:columna
        if(p==N){
            mostrarTablero();
            cont++;
            System.out.println();
        }
        else
        {
            for(int i=0; i<N; i++)
            {
                if(distintaFila(i) && distintaColumna(p) && distintaDiagonal(i,p))
                {
                    agregar(i,p);
                    p++;
                    solucion(p);
                    p--;
                }
                quitar(i,p);
            }
        }
    
    }
    
    public void inicializarTablero()
    {
        for(int i=0 ; i<N ; i++)
        {
            for(int j=0 ; j<N ; j++)
                tablero[i][j] = 0;
        }
        //tablero[3][4] = 1;
    }
    public void mostrarTablero()
    {
        for(int i=0 ; i<N ; i++)
        {
            System.out.print("[ ");
            for(int j=0 ; j<N ; j++)
                System.out.print(tablero[i][j]+" ");
            System.out.print("]");
            System.out.println();
        }
    }
    //Restricciones --------------------------------------
    public boolean distintaFila(int f)
    {
        boolean distFila = true;
        int i=0;
        while (i<N && distFila)
        {
            if(tablero[f][i]==1)
                distFila = false;
            i++;
        }
        return distFila;
    }
    public boolean distintaColumna(int c)
    {
        boolean distColumna = true;
        int i=0;
        while (i<N && distColumna)
        {
            if(tablero[i][c]==1)
                distColumna = false;
            i++;
        }
        return distColumna;
    }
    public boolean distintaDiagonal(int f, int c){
        boolean distDiagonal = true;
        int fi = f;
        int ci = c;
        //Verifico diagonal izquierda hacia arriba
        while(f>0 && c>0 && distDiagonal)
        {
            f--;
            c--;
            if(tablero[f][c] == 1){
                distDiagonal = false;
            }
        }
        f = fi;
        c = ci;
        //Verifico diagonal izquierda hacia abajo(N-1 = 7)
        while(f<N-1 && c > 0 && distDiagonal){
            f++;
            c--;
            if(tablero[f][c] == 1){
                distDiagonal = false;
            }
        }
        f = fi;
        c = ci;
        //Verifico diagonal derecha hacia arriba
        while(f>0 && c<N-1 && distDiagonal){
            f--;
            c++;
            if(tablero[f][c] == 1){
                distDiagonal = false;
            }
        }
        f = fi;
        c = ci;
        //Verifico diagonal derecha hacia abajo
        while(f<N-1 && c<N-1 && distDiagonal)
        {
            f++;
            c++;
            if(tablero[f][c] == 1){
                distDiagonal = false;
            }
        }
        
        return distDiagonal;
    }
    //add and remove
    public void agregar(int f, int c){
        tablero[f][c] = 1;
    }
    public void quitar(int f, int c){
        tablero[f][c] = 0;
    } 
    
}
