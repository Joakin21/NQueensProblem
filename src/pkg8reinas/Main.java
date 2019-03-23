
package pkg8reinas;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;


public class Main implements KeyListener
{  
    private Interfaz interfaz;
    
    public Main(){
        JFrame frame = new JFrame();
        
        ProblemaReinas problema_reinas = new ProblemaReinas();//ya hace la solucion apenas se instancia
        interfaz = new Interfaz(problema_reinas.getSoluciones());

        frame.setTitle("Problema de las 8 Reinas");
        frame.setSize(530,560);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.addKeyListener(this);
        

        frame.add(interfaz);
        
    }
    
    public static void main(String[] args) {
        Main app = new Main();
    }   

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
       if(e.getKeyCode()==37 )//LEFT
            interfaz.anterior();
       if(e.getKeyCode()==39)//RIGHT
            interfaz.siguiente();
    }

    @Override
    public void keyReleased(KeyEvent e) {
     
    }


}