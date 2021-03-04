package edu.pingpong.arnoldenum;

import java.util.*;

import edu.pingpong.arnoldenum.domain.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
		 
        double peso = 1.0; // kg
        
        for(Planeta planeta : Planeta.values()){
            System.out.printf("Your weight on %s is %f N%n", planeta.name(), planeta.pesoSuperficie(peso));
        }
        
        System.out.println("\nYour weight only on the terrestrial planets: ");
        for(Planeta planeta: Planeta.getPlanetasTerrestres()){
            System.out.printf("Your weight on %s is %f N%n", planeta.name(), planeta.pesoSuperficie(peso));
        }
        
        System.out.println("\nYour weight only on the gas giant planets: ");
        for(Planeta planeta: Planeta.getGigantesGaseosos()){
            System.out.printf("Your weight on %s is %f N%n", planeta.name(), planeta.pesoSuperficie(peso));
        }


        


        String[] gigantesGaseosos = new String[4];

        Arrays.asList(Planeta.values()).subList(4, 8).stream().forEach(p -> gigantesGaseosos[p.ordinal()-4] = p.name());

		// Tuve que realizar Casting porque count() retornaba un LONG
		int planetasIncluidos = (int) Arrays.asList(Planeta.values()).subList(4, 8).stream().peek(System.out::println).count();

        System.out.println(planetasIncluidos);

		
		for(Planeta planeta : Planeta.getGigantesGaseosos()){
			System.out.println(planeta);

        }
    }
}
