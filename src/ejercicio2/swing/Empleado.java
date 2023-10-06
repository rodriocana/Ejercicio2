/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2.swing;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Empleado {

    static Scanner sc = new Scanner(System.in);

    private int numeroEmpleado;
    private String Apellido;
    private GregorianCalendar FechaDeAlta;
    private float Sueldo;
    private Empleado Siguiente;

    private static int ContadorEmple = 0;  // metodo estatico para que sea unico y no se cree en cada empleado creado
    private static Empleado inicio = null; // atributo para enlazar los empleados y debe ser estatico
    private static Empleado actual = null;

    public Empleado(String Apellido, float Sueldo) {

        this.numeroEmpleado = ++ContadorEmple;
        this.Apellido = Apellido;
        this.Sueldo = Sueldo;
        this.FechaDeAlta = new GregorianCalendar();
        this.Siguiente = null;

        if (inicio == null) {

            inicio = this;

        } else {

            this.Siguiente = inicio;
            inicio = this;
        }

        actual = inicio;

    }

    public Empleado() {

        pedirDatos();

        this.numeroEmpleado = ++ContadorEmple;
        this.FechaDeAlta = new GregorianCalendar();
        this.Siguiente = null;

        if (inicio == null) {

            inicio = this;

        } else {

            this.Siguiente = inicio;
            inicio = this;
        }

        actual = inicio;

    }

    public static void avanzar() {

        actual = actual.Siguiente;

    }

    public void pedirDatos() {

        System.out.println("Apellido del empleado:");
        Apellido = sc.next();

        System.out.println("Sueldo del empleado");
        Sueldo = sc.nextInt();

    }

    public static void retroceder() {

        Empleado aux = inicio;

        while (aux.Siguiente != actual) {

            aux = aux.Siguiente;
        }

        actual = aux;
    }

    /* public void esUltimo(){
        
       if(actual.Siguiente == null){
           
           return 
       }
    }*/
    public static int getContadorEmple() {
        return ContadorEmple;
    }

    public static Empleado getActual() {
        return actual;
    }

    public static void setContadorEmple(int aContadorEmple) {
        ContadorEmple = aContadorEmple;
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public GregorianCalendar getFechaDeAlta() {
        return FechaDeAlta;
    }

    public void setFechaDeAlta(GregorianCalendar FechaDeAlta) {
        this.FechaDeAlta = FechaDeAlta;
    }

    public float getSueldo() {
        return Sueldo;
    }

    public void setSueldo(float Sueldo) {
        this.Sueldo = Sueldo;
    }

    public static Empleado getInicio() {
        return inicio;
    }

    public static void setInicio(Empleado inicio) {
        Empleado.inicio = inicio;
    }

    public Empleado getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(Empleado Siguiente) {
        this.Siguiente = Siguiente;
    }

    @Override
    public String toString() {
        return "Empleado{" + "numeroEmpleado=" + numeroEmpleado + ", Apellido=" + Apellido + ", Sueldo=" + Sueldo + ')';
    }

}
