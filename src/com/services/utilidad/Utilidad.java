package com.services.utilidad;

import java.text.*;
import java.util.Date;
public class Utilidad {
	
	public static void main(String[] args ){
		
		System.out.println("Fecha " + getFechaFormato(ParseFecha("20-09-2018")));
		
	}
	
	/**
     * Permite convertir un String en fecha (Date).
     * @param fecha Cadena de fecha dd-MM-yyyy
     * @return Objeto Date
     */
    public static java.sql.Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaDate = null;
        
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return new java.sql.Date(fechaDate.getTime());
    }

    /**
     * Permite convertir  fecha (Date) a string formato dd/MM/YYYY .
     * @param fecha Cadena de fecha dd-MM-yyyy
     * @return Objeto Date
     */
    public static String getFechaFormato(Date fecha)
    {
        String strDate ="" ;
    	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		 strDate = dateFormat.format(fecha);
        return strDate;
    }
    
    
    public static Date devolverFecha(Date fechaEntrada) throws ParseException { 

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        String fechaString = fechaEntrada.toString(); // Convierte Date a String
        Date miFecha = formato.parse(fechaString); // convierte String a Date
        return miFecha;

      }
}
