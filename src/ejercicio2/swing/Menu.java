/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JFrame {

    private String Apellido;
    private String Sueldo;
    private String FechaDeAlta;

    private JLabel ApellidoLabel;
    private JLabel SueldoLabel;
    private JLabel FechaLabel;

    private static String ApellidoString = "Apellido Empleado: ";
    private static String SueldoString = "Sueldo Empleado: ";
    private static String FechaString = "Fecha Empleado: ";

    private TextField ApellidoField;
    private TextField SueldoField;
    private TextField FechaField;

    private boolean focusIsSet = false;

    public Component createComponents() {

        JButton button = new JButton("Avanzar");

        JPanel pane = new JPanel();
        pane.setBorder(BorderFactory.createEmptyBorder(
                30, //arriba
                30, //izquierda
                10, //abajo
                30) //derecha
        );
        pane.setLayout(new GridLayout(0, 1));
        pane.add(button);

        return pane;

    }

    public Menu() {

        super("Gestión de empleados"); //titulo de la app que se encuentra en el constructor de JFrame.java

        //creamos las etiquetas o capas
        ApellidoLabel = new JLabel(ApellidoString);
        SueldoLabel = new JLabel(SueldoString);
        FechaLabel = new JLabel(FechaString);

        //Campo donde vamos a introducir el apellido
        ApellidoField = new TextField(10);
        SueldoField = new TextField(10);
        FechaField = new TextField(10);

        //Dispone la geometrÃ­a de las etiquetas en un panel
        JPanel labelPane = new JPanel();
        labelPane.setLayout(new GridLayout(0, 1));
        labelPane.add(ApellidoLabel);
        labelPane.add(SueldoLabel);
        labelPane.add(FechaLabel);

        //Dispone los campos de texto en otro panel
        JPanel fieldPane = new JPanel();
        fieldPane.setLayout(new GridLayout(0, 1));
        fieldPane.add(ApellidoField);
        fieldPane.add(SueldoField);
        fieldPane.add(FechaField);
        
        JButton button = new JButton("Avanzar");
        JButton button2 = new JButton("Retroceder");

        JPanel contentPane = new JPanel();  //creamos nuevo panel para introducir todo
        
        contentPane.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BorderLayout());
        contentPane.add(labelPane, BorderLayout.CENTER);
        contentPane.add(fieldPane, BorderLayout.EAST);
        
        contentPane.setLayout(new GridLayout(1, 0));
        contentPane.add(button);
        contentPane.add(button2);
        
        

        setContentPane(contentPane);

    }

}
