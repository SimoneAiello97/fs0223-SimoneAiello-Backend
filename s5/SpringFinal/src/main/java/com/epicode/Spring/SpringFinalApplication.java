package com.epicode.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.epicode.Spring.Factory.ConcreteFactoryCentroDiControllo;
import com.epicode.Spring.Factory.ConcreteFactorySonda;
import com.epicode.Spring.Factory.entities.CentroDiControllo;
import com.epicode.Spring.Factory.entities.Sonda;
import com.epicode.Spring.Factory.interfaces.ISensore;
import com.epicode.Spring.Observer.entities.CentroDiControlloObserver;
import com.epicode.Spring.Observer.entities.SondaObserver;

@SpringBootApplication
public class SpringFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFinalApplication.class, args);
	System.out.println("------------FACTORY--------------");
		
	ConcreteFactorySonda sondaFactory = new ConcreteFactorySonda();
	ConcreteFactoryCentroDiControllo centroDiControlloFactory = new ConcreteFactoryCentroDiControllo();
	CentroDiControllo c1 = centroDiControlloFactory.createCentroDiControllo();
	
	Sonda s1 = sondaFactory.createSonda(1, 12.2, 13.1);
	Sonda s2 = sondaFactory.createSonda(2, 12.2, 13.1);
	
	s1.setCc(c1);
	s2.setCc(c1);
	s1.setSmokeLevel(6);
	s2.setSmokeLevel(2);
	
	System.out.println("---------------OBSERVER AND PROXY---------------");
	
	SondaObserver so1 = new SondaObserver(3, 67.32, 89.42);
	SondaObserver so2 = new SondaObserver(4, 43.211, 31.32);
	
	CentroDiControlloObserver co1 = new CentroDiControlloObserver();
	
	so1.addObserver(co1);
	so2.addObserver(co1);
	so2.setSmokeLevel(7);
	
	
	}

}
