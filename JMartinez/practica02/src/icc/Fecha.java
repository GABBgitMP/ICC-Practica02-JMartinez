/** 
 * El objetivo de esta practica es que el alumno ejercite la teoria acerca del uso y aplicaci ́on
    de las instrucciones condicionales dentro de un programa, as ́ı como de la creaci ́on y uso de
    objetos de clases existentes.
 * En una institucion bancaria se requiere hacer cierto manejo de fechas para determinar, por
    ejemplo, la fecha final de una inversn de dinero. Por ello el proposito de este problema
    es escribir una clase para crear y manejar fechas.
 * @author Martinez Padron Jorge Gabriel
 * @version 1a edicion
 */



import java.util.Scanner;

public class Fecha {

    /** Atributos */
        public int dia;
        public int mes;  
        public String mesNombre;
        public int anio;

    /** Constructor por omision. Construye la fecha 01/enero/2026  */ 
    public Fecha(){
        asignarFecha(1, 1, 2026);

    }

    /** Contructor con parametros dia, mes y año; con numeros enteros */
    public Fecha(int dia, int mes, int anio){
        asignarFecha(dia, mes, anio);
    }

    /** Constructor con parametros dia, nombre del mes y año */
    public Fecha(int dia, String mesNombre, int anio){
        asignarFecha(dia, mesNombre, anio);
    }

    /** Metodo para evaluar si un año es bisiesto, Si el residuo del año entre 4 es 0 y el residuo del año entre 100 es diferente de 0 es bisiesto, o si el residuo del año entre 400 es 0 es bisiesto */
    public boolean esBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0); 
    }

    /** Metodo para devolver el número de días en un año bisiesto */
    public int diasBisiesto(int anio){
        if (esBisiesto(anio)){
            return 366;
        } else {
            return 365;
        }
    }

    /** Metodo para devolver el número de días en un mes dado */
    public int diasMeses(int mes, int anio) {
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) { // Meses con 31 días
            return 31;
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) { // Meses con 30 días
            return 30;
        } else if (mes == 2) { // Febrero y verificamos si es bisiesto
            if (esBisiesto(anio)){
                return 29;
            } else {
                return 28;
            }
        } else {
            return 0; // Mes inválido
        }
    }
    

    /** Metodo para asignar valor a los campos de una fecha.*/
    public void asignarFecha(int dia, int mes, int anio){

        if (mes >= 1 && mes <= 12) { // Verificar si el número del mes es válido
            int DiasMax = diasMeses(mes, anio); 

            if (dia >= 1 && dia <= DiasMax) { // Verificar si el día es válido para el mes y año especificados
                this.dia = dia;
                this.mes = mes;
                this.mesNombre = obtenerNombreMes(mes);
                this.anio = anio;
            } else {
                System.out.println("Dia invalido para el mes y año especificados.");                
            }
        } else {
            System.out.println("Mes invalido. Debe estar entre 1 y 12.");


        }
    
    }

    /** Metodo para asignar valor a los campos de una fecha con cadena de caracteres.*/
    public void asignarFecha(int dia, String mesNombre, int anio){
        int numMes = obtenerNumeroMes(mesNombre);   
        if (numMes >= 1 && numMes <= 12) { // Verificar si el número del mes es válido

            int DiasMax = diasMeses(numMes, anio); 
            if (dia >= 1 && dia <= DiasMax) { // Verificar si el día es válido para el mes y año especificados
                this.dia = dia;
                this.mes = numMes;
                this.mesNombre = obtenerNombreMes(numMes);
                this.anio = anio;
            } else {
                System.out.println("Dia invalido para el mes y año especificados.");                
            }
        } else {
            System.out.println("El nombre del mes es invalido.");


        }
    }

    /** Metodo para obtener el dia de una fecha. */
    public int obtenerDia() {
        return dia;
    }

    /** Metodo para obtener el mes de una fecha. */
    public int obtenerMes() {
        return mes;
    }

    /** Metodo para obtener el nombre del mes de una fecha. */
    public String obtenerMesNombre() {
        return mesNombre;
    }

    /** Metodo para obtener el año de una fecha. */
    public int obtenerAnio() {
        return anio;
    }

    /** Metodo para calcular los días transcurridos dada una fecha */
    public int diasTranscurridos() { 
        int dias = 0;

        for (int m = 1; m < mes; m++) {
            dias += diasMeses(m, anio);
        }
        dias += dia;
        return dias;
    }

    /** Metodo auxiliar para calcular la diferencia de días entre dos fechas, este metodo hace calcula todos los dias transcurridos desde el año 1 */
    public int diasTranscurridosAnio() {
        int dias = 0;
        for (int a = 1; a < anio; a++) {
            dias += diasBisiesto(a);
        }
        dias += diasTranscurridos();
        return dias;
    }
    

    /** Metodo para calcular la diferencia en dias entre dos fechas */
    public static int diferenciaFechas (Fecha fecha1, Fecha fecha2) {
        int diasFecha = fecha1.diasTranscurridosAnio();
        int diasFecha2 = fecha2.diasTranscurridosAnio();
        return Math.abs(diasFecha - diasFecha2); // Devuelve el valor absoluto de la diferencia ya que no existen dias negativos 
    
    }

    /** Metodo que dada una fecha inicial y un numero entero que representa una cantidad de dias, obtener la fecha que corresponde, */
    public Fecha fechaFutura(Fecha fecha, int dias) {
        int diasTotales = fecha.diasTranscurridosAnio() + dias;
        int anioFuturo = 1; 

        while (diasTotales > diasBisiesto(anioFuturo)) { // Mientras los días totales sean mayores que los dias en el año futuro, se resta el numero de dias en ese año y se incrementa el año futuro porque se ha pasado a un nuevo año.
            diasTotales -= diasBisiesto(anioFuturo);
            anioFuturo++; 
        }

        int mesFuturo = 1; 

        while (diasTotales > diasMeses(mesFuturo, anioFuturo)) { // Mientras los días totales sean mayores que los dias en el mes futuro, se resta el numero de dias en ese mes y se incrementa el mes futuro porque se ha pasado a un nuevo mes.
            diasTotales -= diasMeses(mesFuturo, anioFuturo);
            mesFuturo++;
        }

        int diaFuturo = diasTotales; // Los días restantes representan el día futuro.
        return new Fecha(diaFuturo, mesFuturo, anioFuturo);
    }

    /** Metodo para verificar si dos fechas son iguales */
    public static boolean fechasIguales(Fecha fecha1, Fecha fecha2) {
        return fecha1.diasTranscurridosAnio() == fecha2.diasTranscurridosAnio();
    }


    /** Metodo para Devolver la cadena correspondiente a un mes a partir de que reciba un numero.*/ 
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

    /** Metodo para devolver el numero correspondiente a un mes a partir de que reciba una cadena con su nombre.*/
    public int obtenerNumeroMes (String mesNombre) {
        if (mesNombre == null) { // Verificar si la cadena no existe o es nula
            return 0;
        }

        String nombre = mesNombre.trim().toLowerCase(); // Convertir a minúsculas y eliminar espacios en blanco al inicio y al final

        if (nombre.equals("enero") || nombre.equals("1")) {
            return 1;
        } else if (nombre.equals("febrero") || nombre.equals("2")) { 
            return 2;
        } else if (nombre.equals("marzo") || nombre.equals("3")) {
            return 3;
        } else if (nombre.equals("abril") || nombre.equals("4")) {
            return 4;
        } else if (nombre.equals("mayo") || nombre.equals("5")) {
            return 5;
        } else if (nombre.equals("junio") || nombre.equals("6")) {
            return 6;
        } else if (nombre.equals("julio") || nombre.equals("7")) {
            return 7;
        } else if (nombre.equals("agosto") || nombre.equals("8")) {
            return 8;
        } else if (nombre.equals("septiembre") || nombre.equals("9")) {
            return 9;
        } else if (nombre.equals("octubre") || nombre.equals("10")) {
            return 10;
        } else if (nombre.equals("noviembre") || nombre.equals("11")) {
            return 11;
        } else if (nombre.equals("diciembre") || nombre.equals("12")) {
            return 12;
        } else {
            return 0; 
        }
    }

    


    /** Metodo para representar una fecha en el formato dd/mes/aaaa , donde dd es el dia, mes es el nombre del mes. y aaaa son cuatro dıgitos que representan el año. */
    public String toString() {
        if (mesNombre != null) { // Verificar si el nombre del mes no existe o es nulo
                return dia + "/" + obtenerNombreMes(obtenerNumeroMes(mesNombre)) + "/" + anio;
            }
        return dia + "/" + obtenerNombreMes(mes) + "/" + anio;
    }

    

    /** Metodo main, las pruebas que hice durante la elaboraciin del codigo
     * 
    public static void main (String[] args) {
        Fecha fechaini = new Fecha();
        System.out.println(fechaini);
        Fecha fechainici = new Fecha();
        System.out.println(fechainici);
        Fecha fechaNum = new Fecha(15, 3, 2026);
        System.out.println(fechaNum);
        Fecha fechaCadena = new Fecha(30, "SEptiEmBRe", 2026);
        System.out.println(fechaCadena);
        System.out.println(fechaCadena.obtenerMesNombre());
        fechaini.asignarFecha(30, 12, 2027);
        System.out.println(fechaini);

        System.out.println(fechaini.diasTranscurridos());
    
        System.out.println(fechaCadena.diasTranscurridos());
        

        System.out.println(diferenciaFechas(fechainici, fechaini));
        
        System.out.println(fechaini.diasTranscurridosAnio());
        System.out.println(fechainici.diasTranscurridosAnio());

        System.out.println(fechasIguales(fechaini, fechainici));

        System.out.println(fechaini.fechaFutura(fechaini, 5));



    } */

}

/** Clase para gestionar el tiempo de inversión */
class TiempoDeInversion {

    /** Metodo main */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Bienvenido inversionista aqui podras calcular el tiempo de inversion de tu dinero");
        System.out.print("¿Cual es su nombre?: ");

        String nombre = scanner.nextLine(); // Leer el nombre del usuario
        String nombreSinEspacio = nombre.trim(); // Elimina espacios en blanco al inicio y al final del nombre

        boolean continuar = true;
        while (continuar) {

            System.out.println();
            System.out.print("Hola " + nombreSinEspacio + ", ¿Cual es el monto que desea invertir?: ");

            int monto = scanner.nextInt(); // Leer el monto de inversión
            System.out.println("Monto ingresado: " + monto);

            System.out.println();
            System.out.println("¿Cual es la fecha que desea que sea el inicio de su inversion? ");
            System.out.println();
            System.out.print("Ingrese el dia: ");
            int dia = scanner.nextInt(); 
            scanner.nextLine();
            System.out.print("Ingrese el mes: ");
            String mes = scanner.nextLine(); 
            System.out.print("Ingrese el año: ");
            int anio = scanner.nextInt(); 
            System.out.println();

            Fecha fechaInicio = new Fecha(dia, mes, anio); // Crear un objeto Fecha con la fecha de inicio
            System.out.println("Fecha de inicio ingresada: " + fechaInicio);

            if (fechaInicio.obtenerMes() == 0) {
                System.out.println();
                System.out.println("El mes o dia ingresado es invalido. Por favor, ingrese un mes valido.");
                return ; // Salir del programa si el mes es inválido
            }

            System.out.println();
            System.out.println("¿Cual es la fecha que desea que sea el fin de su inversion? ");
            System.out.println();
            System.out.print("Ingrese el dia: ");
            int diaFin = scanner.nextInt(); 
            scanner.nextLine();
            System.out.print("Ingrese el mes: ");
            String mesFin = scanner.nextLine(); 
            System.out.print("Ingrese el año: ");
            int anioFin = scanner.nextInt(); 
            System.out.println();

            Fecha fechaFin = new Fecha(diaFin, mesFin, anioFin); // Crear un objeto Fecha con la fecha de fin
            System.out.println("Fecha de fin ingresada: " + fechaFin);

            if (fechaFin.obtenerMes() == 0) {
                System.out.println();
                System.out.println("El mes o dia ingresado es invalido. Por favor, ingrese un mes valido.");
                return ; // Salir del programa si el mes es inválido
            }

            System.out.println();
            int diasInversion = Fecha.diferenciaFechas(fechaInicio, fechaFin);
            System.out.println("El tiempo de inversion de su dinero es de: " + diasInversion + " dias");
            System.out.println("Su rendimiento al 12% de los dias de inversion es de: " + (monto * 0.12 * diasInversion / 365) + " pesos"); // Segun la formula de rendimiento al 12%

            String respuesta;

            do {
                System.out.println();
                System.out.print("Desea hacer otra simulacion de inversion? (si/no): ");
                respuesta = scanner.next();

                if (respuesta.equalsIgnoreCase("no")) {
                    continuar = false;
                    System.out.println();
                    System.out.println("Gracias por usar nuestro simulador de inversion, hasta luego " + nombreSinEspacio + " :D");
                } else if (respuesta.equalsIgnoreCase("si")) {
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
                } else {
                    System.out.println("Respuesta invalida. Por favor, ingrese 'si' o 'no'.");
                }
            } while (!respuesta.equalsIgnoreCase("no") && !respuesta.equalsIgnoreCase("si"));
        }
    }
}