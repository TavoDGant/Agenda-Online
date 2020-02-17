/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaenlinea;

import controlador.Controller;
import modelo.Consultas;
import modelo.Contacto;
import vista.Principal;
import vista.vAgregar;
import vista.vBuscar;

/**
 *
 * @author ta_o1
 */
public class AgendaEnLinea {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Consultas cs = new Consultas();
        Contacto ct = new Contacto();
        Principal vista = new Principal();
        vAgregar vagr = new vAgregar();
        vBuscar vB = new vBuscar();
        
        Controller ctrl = new Controller(cs, ct, vista, vagr, vB);
        vista.setVisible(true);
    }
    
}
