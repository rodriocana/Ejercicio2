/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author Rodri
 */
public class Principal {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Empleado emple1 = new Empleado("Ocaña", 2000);
        Empleado emple2 = new Empleado("Benitez", 3000);
        Empleado emple3 = new Empleado("Slezak", 4000);
        Empleado emple4 = new Empleado("Rodriguez", 2200);
        Empleado emple5 = new Empleado("Lopez", 1500);

        MenuEmpleado menu = new MenuEmpleado();
        

        menu.pack();
        menu.setVisible(true);

    }

}
