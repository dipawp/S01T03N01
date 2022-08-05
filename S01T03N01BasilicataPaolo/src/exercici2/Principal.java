package exercici2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> primeraLlista = new ArrayList<Integer>();
		List<Integer> segonaLlista = new ArrayList<Integer>();
		
		for(int i = 0; i <= 100; i++) {
			primeraLlista.add(i);
		}
		
		
		
		for(int i = 100; i >= 0; i--) {
			segonaLlista.add(primeraLlista.get(i));
		}
		
		ListIterator<Integer> listIterator = primeraLlista.listIterator();
		while(listIterator.hasNext()) {
			segonaLlista.add(listIterator.next());
		}
		

	}

}
