package com.epicode.Spring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.epicode.Spring.Factory.ConcreteFactoryCentroDiControllo;
import com.epicode.Spring.Factory.ConcreteFactorySonda;
import com.epicode.Spring.Factory.entities.CentroDiControllo;
import com.epicode.Spring.Factory.entities.Sonda;

@SuppressWarnings("deprecation")
public class TestJava {
	
	    static ConcreteFactorySonda factoryS = new ConcreteFactorySonda();
	    static ConcreteFactoryCentroDiControllo factoryC = new  ConcreteFactoryCentroDiControllo();
	    static Sonda s1 = factoryS.createSonda(1, 98.12, 21.4);
	    static CentroDiControllo c1 = factoryC.createCentroDiControllo();

	    @Test
	    void testDatiSonda() {
	        System.out.println("test sonda s1");
	        assertEquals(1, s1.getId());
	        assertEquals(98.12, s1.getLatitude());
	        assertEquals(21.4, s1.getLongitude());
	        s1.setCc(c1);
	        assertEquals(c1,s1.getCc());
	    }

	   
}
