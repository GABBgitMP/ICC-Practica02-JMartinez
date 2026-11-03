# PRACTICA 02 - INTRODUCCION A CIENCIAS DE LA COMPUTACION

- ALUMNO: Martinez Padron Jorge Gabriel
- FECHA DE ENTREGA: 13 de noviembre del 2026 
- AYUDANTE DE LABORATORIO: Rosa Victoria Villa Padilla
- PROFESOR: Salvador López Mendoza

## OBJETIVO

Ejercitar la teoria acerca del uso y aplicacion de las instrucciones condicionales dentro de un programa, ası como de la creacion y uso de los objetos de clases existentes.

## CONTENIDO

### 1. Fecha.java
Simula una institucion bancaria se requiere hacer cierto manejo de fechas para determinar, por ejemplo, la fecha final de una inversion de dinero. 


## ESTRUCTURA

```
/
├── JMartinez/
│   └── practica02/
│       └── src/
│           └── icc/
│               └── Fecha.java
└── README.md
```
- El código está documentado con formato Javadoc y correctamente indentado

El codigo se compila con la JVM dentro de la estructura en el archivo "icc/" en la terminal escribir "javac Fecha.java" y se creo un archivo Fecha.class
Para ejecutar el codigo en la terminal seguido al paso anterior escribir "java Fecha.java"

```
/** 
 * El objetivo de esta practica es que el alumno ejercite la teoria acerca del uso y aplicaci ́on
    de las instrucciones condicionales dentro de un programa, as ́ı como de la creaci ́on y uso de
    objetos de clases existentes.
 * En una institucion bancaria se requiere hacer cierto manejo de fechas para determinar, por
    ejemplo, la fecha final de una inversn de dinero. Por ello el prop ́osito de este problema
    es escribir una clase para crear y manejar fechas.
 * @author Martinez Padron Jorge Gabriel
 * @version 1a edicion
 */

import java.util.Scanner;

public class Fecha {
    private int dia;
    private int mes;  
    private int anio;

    

    /** Metodo para obtener el nombre del mes apartir de su numero en el calendario 
     * Tipo de retorno tipo string */ 

    public String obtenerNombreMes(int mes) {
        if (mes == 1) {
            return "Enero";
        } else if (mes == 2) {
            return "Febrero";
        } else if (mes == 3) {
            return "Marzo";
        } else if (mes == 4) {
            return "Abril";
        } else if (mes == 5) {
            return "Mayo";
        } else if (mes == 6) {
            return "Junio";
        } else if (mes == 7) {
            return "Julio";
        } else if (mes == 8) {
            return "Agosto";
        } else if (mes == 9) {
            return "Septiembre";
        } else if (mes == 10) {
            return "Octubre";
        } else if (mes == 11) {
            return "Noviembre";
        } else if (mes == 12) {
            return "Diciembre";
        } else {
            return "Mes invalido";
        }
    }

    /** Constructor por omision. Construye la fecha 01/enero/2026  */ 

    public Fecha(){
        this.dia = 1;
        this.mes = 1;
        this.anio = 2026;

    }

/**Metodo para representar la fecha en cadena de caracteres */

    public String toString() {
        return dia + "/" + obtenerNombreMes(mes) + "/" + anio;
    }

    /** Metodo main */
        public static void main (String[] args) {
            Fecha fechaini = new Fecha();
            System.out.println(fechaini);
        
        }

    public class TiempoDeInversion{

        /** Metodo main */
        public static void main (String[] args) {
            Fecha fechaini = new Fecha();
            System.out.println(fechaini);
        
        }
    }
}

```
