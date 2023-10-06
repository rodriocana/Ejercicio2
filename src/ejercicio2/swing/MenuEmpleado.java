/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2.swing;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Rodri
 */
public class MenuEmpleado extends JFrame {

    private Empleado actual;  // creamos esta variable para igualarla al empleado actual que haya en ese momento

    private JTextField txtApellido, txtSueldo, txtFechaDeAlta;
    private JButton btnAnterior, btnSiguiente, btnCrear, btnAceptar, btnCancelar;
    private boolean habilitar;

    private static String txtEmple = "Empleado: ";
    private int contador = Empleado.getContadorEmple();

    public MenuEmpleado() {

        super("Gestion de empleados");
        //setTitle("Gestion de empleados");
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // inicializa los componentes
        txtApellido = new JTextField(10);
        txtSueldo = new JTextField(10);
        txtFechaDeAlta = new JTextField(10);

        btnAnterior = new JButton("Anterior");
        btnAnterior.setForeground(Color.blue);
        btnAnterior.setBackground(Color.orange);

        btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setForeground(Color.blue);
        btnSiguiente.setBackground(Color.orange);

        btnCrear = new JButton("Crear");

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setForeground(Color.orange);
        btnAceptar.setBackground(Color.blue);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(Color.orange);
        btnCancelar.setBackground(Color.blue);

        //desactivamos los botones al principio
        btnSiguiente.setEnabled(true);
        btnAnterior.setEnabled(true);

        // creo una label para el contador de empleados
        final JLabel LabelContador = new JLabel();

        // declaro un Jpanel nuevo
        JPanel panelDatos = new JPanel(new GridLayout(4, 2));

        //añado los elementos al panel creado anteriormente por orden.
        panelDatos.add(new JLabel("Apellido:"));  // Creo varios JLabel pasandole un String como parametro y añadiendolos al panel.
        panelDatos.add(txtApellido);
        
        panelDatos.add(new JLabel("Sueldo: "));
        panelDatos.add(txtSueldo);
        
        panelDatos.add(new JLabel("Fecha de alta: "));
        panelDatos.add(txtFechaDeAlta);
        
        

        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(btnAnterior);
        panelBotones.add(btnSiguiente);
        panelBotones.add(btnCrear);
        panelBotones.add(btnAceptar);
        panelBotones.add(btnCancelar);

        //Agregar paneles a la ventana principal
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(LabelContador, BorderLayout.EAST);
        getContentPane().add(panelDatos, BorderLayout.CENTER);
        getContentPane().add(panelBotones, BorderLayout.SOUTH);
        getContentPane().add(panelBotones, BorderLayout.NORTH);

        // Mostrar el primer empleado
        LabelContador.setText(txtEmple + contador);
        txtApellido.setText(Empleado.getActual().getApellido());
        txtSueldo.setText(Double.toString(Empleado.getActual().getSueldo()));
        txtFechaDeAlta.setText(Empleado.getActual().getFechaDeAlta().getTime().toString());
        btnAnterior.setEnabled(false);
        btnAceptar.setEnabled(false);
        btnCancelar.setEnabled(false);

        //BOTON ANTERIOR
        btnAnterior.addActionListener(new ActionListener() {  // Evento de boton retroceder

            public void actionPerformed(ActionEvent e) {

                Empleado.retroceder();
                actual = Empleado.getActual();
                actualizarInterfaz();
                btnSiguiente.setEnabled(true);

                contador++;
                LabelContador.setText(txtEmple + contador);

                if (actual == Empleado.getInicio()) {  //getInicio es estatico y siempre es NULL 

                    btnAnterior.setEnabled(false);
                }
            }

        });

        // BOTON SIGUIENTE
        btnSiguiente.addActionListener(new ActionListener() {  // Evento de boton avanzar

            public void actionPerformed(ActionEvent e) {

                Empleado.avanzar();
                actual = Empleado.getActual();
                actualizarInterfaz();
                btnAnterior.setEnabled(true);

                contador--;
                LabelContador.setText(txtEmple + contador);

                if (actual.getSiguiente() == null) {

                    btnSiguiente.setEnabled(false);
                }
            }

        });

        // BOTON CREAR //
        btnCrear.addActionListener(new ActionListener() {  // Evento de boton.

            public void actionPerformed(ActionEvent e) {

                btnAceptar.setEnabled(true);
                btnCancelar.setEnabled(true);
                
                btnSiguiente.setEnabled(false);
                btnAnterior.setEnabled(false);
                resetearCampos();

            }

        });

        // BOTON ACEPTAR //
        btnAceptar.addActionListener(new ActionListener() {  // Evento de boton.

            public void actionPerformed(ActionEvent e) {

                    String apellido = txtApellido.getText();
                    double sueldo = (Double.parseDouble(txtSueldo.getText()));
               
                    btnSiguiente.setEnabled(true);
                    btnAnterior.setEnabled(true);
                    
                    btnCancelar.setEnabled(false);
                    btnAceptar.setEnabled(false);

                    // llamamos al constructor de empleado y le seteamos por parametro lo que hayamos escrito en txtApellido y sueldo.
                    Empleado emple = new Empleado(apellido, (float) sueldo);
                    Empleado.getActual().setApellido(apellido);
                    Empleado.getActual().setSueldo((float) sueldo);
                    contador++;
               }

        });

        // BOTON CANCELAR //
        btnCancelar.addActionListener(new ActionListener() {  // Evento de boton.

            public void actionPerformed(ActionEvent e) {

                btnAnterior.setEnabled(false);
                btnAceptar.setEnabled(false);
                btnCancelar.setEnabled(false);
                
                btnSiguiente.setEnabled(true);
                btnAnterior.setEnabled(true);
                
                txtApellido.setText(Empleado.getActual().getApellido());
                txtSueldo.setText(Double.toString(Empleado.getActual().getSueldo()));
                txtFechaDeAlta.setText(Empleado.getActual().getFechaDeAlta().getTime().toString());
                
                //actualizarInterfaz();
            }

        });

    }

    public void resetearCampos() {

        txtApellido.setText("");
        txtSueldo.setText("");

    }

    private void habilitarCampos(boolean habilitar) {

        txtApellido.setEnabled(habilitar);
        txtSueldo.setEnabled(habilitar);
        txtFechaDeAlta.setEnabled(habilitar);
        btnAceptar.setEnabled(habilitar);
        btnCancelar.setEnabled(habilitar);

    }

    private void actualizarInterfaz() {

        if (actual != null) {

            txtApellido.setText(Empleado.getActual().getApellido());
            txtSueldo.setText(Double.toString(Empleado.getActual().getSueldo()));
            txtFechaDeAlta.setText(Empleado.getActual().getFechaDeAlta().getTime().toString());

            
        } else {

            txtApellido.setText("");
            txtSueldo.setText("");
            txtFechaDeAlta.setText("");
        }

    }

}
