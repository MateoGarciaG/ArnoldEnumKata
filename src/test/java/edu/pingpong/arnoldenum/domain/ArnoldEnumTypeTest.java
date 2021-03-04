package edu.pingpong.arnoldenum.domain;

/* IMPORT ASSERTJ */
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.stream.Collector;

import edu.pingpong.arnoldenum.domain.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ArnoldEnumTypeTest {

	public static String[] planetas;
	
	
	@BeforeClass
	public static void CreacionArrayPlanetasSetup(){
		planetas = new String[8];
		
		Arrays.stream(Planeta.values()).forEach(p -> planetas[p.ordinal()] = p.name());

		int planetasIncluidos = (int) Arrays.stream(Planeta.values()).count();

		assertThat(planetasIncluidos).isEqualTo(Planeta.values().length);
	}
	

	@Test
	public void PlanetaConstructorTest() {

		Planeta planeta = Planeta.MERCURY;
		assertThat(planeta).isInstanceOf(Planeta.class);
		assertThat(planeta.ordinal()).isEqualTo(0);
		assertThat(planeta.name()).isEqualToIgnoringWhitespace("MERCURY");
		assertThat(Planeta.valueOf(planeta.name())).isEqualTo(Planeta.MERCURY);
		assertThat(planeta.compareTo(planeta.MERCURY)).isEqualTo(0);
		assertThat(planeta.toString()).isEqualToIgnoringWhitespace("MERCURY");
		assertThat(planeta.equals(planeta.MERCURY)).isEqualTo(true);
		assertThat(Planeta.values()[0]).isEqualTo(planeta);
	}
	
	@Test
	public void PlanetaGetMasaTest(){		
		Planeta planeta = Planeta.MERCURY;
		assertThat(planeta.getMasa()).isEqualTo(3.303e+23);
	}
	
	@Test
	public void PlanetaGetRadioTest(){		
		Planeta planeta = Planeta.MERCURY;
		assertThat(planeta.getRadio()).isEqualTo(2.4397e+6);
	}	
	
	@Test
	public void PlanetaNamesIteratorTest(){
		for(Planeta planeta : Planeta.values()){
			assertThat(planeta.name()).isIn(planetas);
		}
	}
	
	@Test
	public void PesoSuperficieMercurioTest(){
		Planeta planeta = Planeta.MERCURY;
		double pesoHumano = 175;
		assertEquals(66.107583, planeta.MERCURY.pesoSuperficie(pesoHumano) , 0.001);
	}
	
	@Test
	public void ArrayPlanetasTerrestresTest(){

		String[] planetasTerrestres = new String[4];


			// sublist(): Nos permite hacer rangos de elementos de una lista.
			// Donde el ultimo rango por defecto e le rest -1, como en python
		Arrays.asList(Planeta.values()).subList(0, 4).stream().forEach(p -> planetasTerrestres[p.ordinal()] = p.name());


		// Tuve que realizar Casting porque count() retornaba un LONG
		int planetasIncluidos = (int) Arrays.asList(Planeta.values()).subList(0, 4).stream().count();
		

		assertThat(planetasIncluidos).isEqualTo(4);
		
		for(Planeta planeta : Planeta.getPlanetasTerrestres()){
			assertThat(planeta.name()).isIn(planetasTerrestres);
		}		
	}
	
	@Test
	public void ArrayGigantesGaseosos(){

		String[] gigantesGaseosos = new String[4];

		// p.ordinal() sigue mantieniendo su index dentro de la lista de ENUM, por lo cual por ejemplo: URANUS, su index es 6. Y al introducirla dentro gigantesGaseosos[] el cual solo tiene 4 elementos, obviamente serán IndexOutOfRanges. Por lo cual al restarle -4, 6 -4: 2. El 2 si es un index de: gigantesGaseosos
		Arrays.asList(Planeta.values()).subList(4, 8).stream().forEach(p -> gigantesGaseosos[p.ordinal()-4] = p.name());


		// Tuve que realizar Casting porque count() retornaba un LONG
		int planetasIncluidos = (int) Arrays.asList(Planeta.values()).subList(4, 8).stream().count();

		assertThat(planetasIncluidos).isEqualTo(4);
		
		for(Planeta planeta : Planeta.getGigantesGaseosos()){
			assertThat(planeta.name()).isIn(gigantesGaseosos);
		}		
	}
	

}
