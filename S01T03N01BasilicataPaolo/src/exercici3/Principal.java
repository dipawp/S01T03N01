package exercici3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class Principal {
	
	public static HashMap<String,String> hashQuiz = null;
	public static List<String> llistaPaisos = null;
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		//crea el fitxer classificació si no existeix
		File classificacio = new File("src/classificacio.txt");
		if(!classificacio.exists()) {
			try {
				classificacio.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("No es pot crear el fitxer classificacio.txt");
			}
		}

		hashQuiz = new HashMap<String,String>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/Countries.txt"));
			//Requereix Java 8+
			Stream lines = br.lines();
			Iterator<String> it = lines.iterator();
			while(it.hasNext()) {
				//El mètode trim elimina tots els espais que hi puguin haver al principi i final de línia
				//El mètode split divideix les línies per paraules i retorna un Array de Strings
				String[] str = it.next().trim().split(" ");
				hashQuiz.put(str[0], str[1]);
			}
			br.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		llistaPaisos = new ArrayList<String>(hashQuiz.keySet());	
		Principal.iniciaJoc();
	}
	
	
	public static void iniciaJoc() {
		Random random = new Random();
		String nom = null;
		byte puntuacio = 0;
		byte index = 1;
		
		System.out.println("Introdueix el teu nom per començar el joc");
		Scanner scanner = new Scanner(System.in);
		nom = scanner.nextLine();
		
		do {
			int rdn = random.nextInt(0, llistaPaisos.size());
			String pais = llistaPaisos.get(rdn);
			System.out.println("Quina es la capital de " + pais);
		    String result = scanner.nextLine();
		    if(hashQuiz.get(pais).equalsIgnoreCase(result)) {
		    	puntuacio += 1;
		    }
			index++;
			
		}while(index <=10);
		scanner.close();
		System.out.println(nom + " la teva puntuacio es: " + puntuacio);
		Principal.guardarResultat(nom, puntuacio);
		
	}
	
	public static void guardarResultat(String nom, byte puntuacio) {
		File classificacio = new File("src/classificacio.txt");
		//if(!classificacio.exists()){
			try {
				classificacio.createNewFile();
				FileWriter writer = new FileWriter("src/classificacio.txt",true);
				writer.write(nom + " " + puntuacio + "\n");
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("No es possible guardar el resultat");
			}
		//}
	}

}
