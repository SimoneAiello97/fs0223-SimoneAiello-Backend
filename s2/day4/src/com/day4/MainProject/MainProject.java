package com.day4.MainProject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.day4.classes.Category;
import com.day4.classes.Customer;
import com.day4.classes.Order;
import com.day4.classes.Product;

public class MainProject {
	
	static Logger log = LoggerFactory.getLogger(MainProject.class);
	public static void main(String[] args) {
		//Mi creo dei Prodotti
		Product p1 = new Product(789_123_456L, "Piccolo Principe", Category.Books, 9.90);
		Product p2 = new Product(789_123_457L, "Harry Potter", Category.Books, 109.90);
		Product p3 = new Product(123_123_457L, "Mazza da Baseball", Category.Boys, 115.90);
		Product p4 = new Product(456_123_457L, "Biberon", Category.Baby, 789.90);
		
		List<Product> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		
		// ESERCIZIO 1
		Stream<Product> libriSopraCento = list.stream()	
				.filter(el -> el.getCategory().equals(Category.Books))
				.filter(el -> (el.getPrice() > 100));
		List<Product> esercizio1 = libriSopraCento.collect(Collectors.toList());
		esercizio1.forEach(el -> log.info("Libri sopra i 100: " + el.getName()));
		
		// ESERCIZIO 2
		Stream<Product> prodottiBambini = list.stream().filter(el -> el.getCategory().equals(Category.Baby));
		List<Product> esercizio2 = prodottiBambini.collect(Collectors.toList());
		esercizio2.forEach(el -> log.info("Prodotti bimbi: " + el.getName()));
		
		// ESERCIZIO 3
		Stream<Product> prodottiBoys = list.stream()
                .filter(el -> el.getCategory().equals(Category.Boys))
                .map(el -> {
                    el.setPrice(el.getPrice() - (el.getPrice() / 10));
                    return el;
                });
		List<Product> esercizio3 = prodottiBoys.collect(Collectors.toList());
		esercizio3.forEach(el -> log.info("Prodotti boys scontati del 10%: " + el.getName() + ", Prezzo: " + el.getPrice()));

		// ESERCIZIO 4
		Customer a = new Customer(123l, "Mario Rossi", 1);
		Customer b = new Customer(124l, "Giuseppe Verdi", 2);
		
		Order a1 = new Order(789_1233L, "Delivered", LocalDate.of(2021, 12, 25), LocalDate.of(2021, 7, 25), list, a);
		Order a2 = new Order(789_1231L, "Delivered", LocalDate.of(2021, 3, 25), LocalDate.of(2021, 3, 25), list, a);
		Order b1 = new Order(789_1234L, "Delivered", LocalDate.of(2021, 3, 25), LocalDate.of(2021, 3, 25), list, b);
		Order b2 = new Order(789_124L, "Delivered", LocalDate.of(2021, 12, 25), LocalDate.of(2021, 9, 12), list, b);

		
		List<Order> listaOrdini = new ArrayList<>();
		listaOrdini.add(a1);
		listaOrdini.add(a2);
		listaOrdini.add(b1);
		listaOrdini.add(b2);

		
		Stream<Order> ordiniFiltrati = listaOrdini.stream()
				.filter(el -> el.getCustomer().getTier() ==2)
				.filter(el -> el.getOrderDate().compareTo(LocalDate.of(2021, 2, 1))>0)
				.filter(el -> el.getOrderDate().compareTo(LocalDate.of(2021, 4, 1))<0);
		
		List<Order> esercizio4 = ordiniFiltrati.collect(Collectors.toList());
		esercizio4.forEach(el -> log.info("Ordini consegnati tra l'1/2/2021 e 1/4/2021: " + el.getId()));
		
	}

}
