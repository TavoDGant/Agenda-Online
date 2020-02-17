/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Consultas;
import modelo.Contacto;
import vista.Principal;
import vista.vAgregar;
import vista.vBuscar;

/**
 *
 * @author ta_o1
 */
public class Controller implements ActionListener{
    
    private Consultas consul;
    private Contacto contact;
    private Principal princi;
    private vAgregar vag;
    private vBuscar vBus;

    public Controller(Consultas consul, Contacto contact, Principal princi, vAgregar vag, vBuscar vBus) {
        this.consul = consul;
        this.contact = contact;
        this.princi = princi;
        this.vag = vag;
        this.vBus = vBus;
        
        this.princi.btnAgregar.addActionListener(this);
        this.vag.btnAgregar.addActionListener(this);
        
        this.princi.btnBuscar.addActionListener(this);
        this.vBus.btnBuscar.addActionListener(this);
        
        this.vBus.btnActualizar.addActionListener(this);
        this.vBus.btnEliminar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==princi.btnAgregar){
            vag.setVisible(true);
        }
        if(e.getSource()==princi.btnBuscar){
            vBus.setVisible(true);
        }
        if(e.getSource()==vag.btnAgregar){
                contact.setNombre(vag.txtNombre.getText());
                contact.setApellido(vag.txtApellido.getText());
                contact.setCorreo(vag.txtCorreo.getText());
                contact.setTelefono(vag.txtTelefono.getText());
                if(consul.registrar(contact))
                {
                    JOptionPane.showMessageDialog(null, "Registro guardado");
                    limpiar();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Error al guardar");                
                }
        }
        if(e.getSource()==vBus.btnBuscar){
            contact.setNombre(vBus.txtNombre.getText());
            if(consul.buscar(contact)){
                vBus.txtNombre.setText(contact.getNombre());
                vBus.txtApellido.setText(contact.getApellido());
                vBus.txtCorreo.setText(contact.getCorreo());
                vBus.txtTelefono.setText(contact.getTelefono());
            }
            else{
                JOptionPane.showMessageDialog(null, "Contacto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                limpiarVBus();
                
            }
        }
        if(e.getSource()==vBus.btnActualizar){
            contact.setNombre(vBus.txtNombre.getText());
            contact.setApellido(vBus.txtApellido.getText());
            contact.setCorreo(vBus.txtCorreo.getText());
            contact.setTelefono(vBus.txtTelefono.getText());
            if(consul.actualizar(contact)){
                JOptionPane.showMessageDialog(null, "Datos Actualizados", "Info", JOptionPane.INFORMATION_MESSAGE);
                limpiarVBus();
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al actualizar", "Error", JOptionPane.ERROR_MESSAGE);
                limpiarVBus();
            }
        }
        
        if(e.getSource()==vBus.btnEliminar){
            contact.setNombre(vBus.txtNombre.getText());
            if(consul.eliminar(contact)){
                JOptionPane.showMessageDialog(null, "Datos Eliminados", "Info", JOptionPane.INFORMATION_MESSAGE);
                limpiarVBus();
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al Eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                limpiarVBus();
            }
        }
        
    }
    
    
    public void limpiar(){
        vag.txtNombre.setText(null);
        vag.txtApellido.setText(null);
        vag.txtCorreo.setText(null);
        vag.txtTelefono.setText(null);
    }
    public void limpiarVBus(){
        vBus.txtNombre.setText(null);
        vBus.txtApellido.setText(null);
        vBus.txtCorreo.setText(null);
        vBus.txtTelefono.setText(null);
    }
    
}
