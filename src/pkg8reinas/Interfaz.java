
package pkg8reinas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Interfaz extends JPanel{
    
    private ArrayList<Solucion> soluciones = new ArrayList<>();
    
    private int N;
    private int anchoCuadrado;
    private int p;// indece de la lista de soluciones
    public Interfaz(ArrayList<Solucion> soluciones){
        N = 8;
        anchoCuadrado = 50;
        this.soluciones = soluciones;
        p=0;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //titulo
        g.setColor(Color.GRAY);
        g.setFont(new Font("Arial", Font.PLAIN, 40));
        g.drawString("Solución "+(p+1)+" de 92",90,50);
        
        dibujarTablero(g);

    }
    
    public void dibujarTablero(Graphics g){
        int x = 60;
        int y = 75;
        Color color1 = Color.white;
        Color color2 = Color.black;
        g.setColor(color1);
        for(int i=0; i<N; i++)//i = f
        {
            for(int j=0; j<N; j++){//j = c
                
                g.fillRect(x, y, anchoCuadrado, anchoCuadrado);
                x = x + anchoCuadrado;
                
                
                if(g.getColor()==color1)
                    g.setColor(color2);
                else
                    g.setColor(color1);   
                if(soluciones.get(p).getSolucion()[j]== i){
                    //System.out.println("kiu");
                   // System.out.println(soluciones.get(p).getSolucion()[j]);
                    g.setFont(new Font("Arial", Font.PLAIN, 40));
                    g.drawString("R", x-(anchoCuadrado/2)-15, y+(anchoCuadrado/2)+15);
                }
            }
            if(g.getColor()==color1)
                g.setColor(color2);
            else
               g.setColor(color1);   
            
            x = 60;
            y = y+anchoCuadrado;
        }
        
    }
    
    public void siguiente(){
        if(p<91){
            p++;
            repaint();
        }
       
    }
    public void anterior(){
        if(p>0){
            p--;
            repaint();
        }
    }

}
