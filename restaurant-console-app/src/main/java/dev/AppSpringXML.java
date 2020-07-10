package dev;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.ihm.Menu;

public class AppSpringXML {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config-fichier.xml");
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config-memoir.xml");
		//Scanner scanner = context.getBean(Scanner.class);
		//context.close();

		// récupération du bean Menu
		Menu menu = context.getBean(Menu.class);
		menu.afficher();
		// fermeture du Scanner
		context.getBean(Scanner.class).close();
		// fermeture du contexte Spring
		context.close();
	}
}