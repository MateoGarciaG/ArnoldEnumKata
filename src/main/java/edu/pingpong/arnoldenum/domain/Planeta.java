package edu.pingpong.arnoldenum.domain;

import java.util.*;

public enum Planeta {
    
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6),
    MARS(6.421e+23, 3.3972e6),
    JUPITER(1.9e+27,   7.1492e7),
    SATURN(5.688e+26, 6.0268e7),
    URANUS(8.686e+25, 2.5559e7),
    NEPTUNE(1.024e+26, 2.4746e7);

    private final double masa;
    private final double radio;
    public static final double G = 6.67300E-11;

    Planeta(double masa, double radio) {
        this.masa = masa;
        this.radio = radio;
    }

    double getMasa() {
        return this.masa;
    }

    double getRadio() {
        return this.radio;
    }

    public double masaHumano(double peso) {
        return peso / EARTH.gravedadEnSuperficie();
    }

    public double gravedadEnSuperficie() {
        return G * (this.getMasa() / (this.getRadio() * this.getRadio()));
    }

    public double pesoSuperficie(double peso) {

        return this.masaHumano(peso) * this.gravedadEnSuperficie();
    }

    public static EnumSet<Planeta> getPlanetasTerrestres() {
		
        return EnumSet.range(Planeta.MERCURY, Planeta.MARS);
	}

	public static EnumSet<Planeta> getGigantesGaseosos() {
		return EnumSet.range(Planeta.JUPITER, Planeta.NEPTUNE);
	}

}
