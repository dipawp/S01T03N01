package exercici1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<Month> months = new ArrayList<Month>();
		HashSet<Month> hashMonths;
		
		String[] mesos = {"gener","febrer","març","april","maig","juny","juliol","setembre","octubre","novembre","desembre"};

		
		for(int i = 0; i < mesos.length; i++) {
			Month month = new Month(mesos[i]);
			months.add(month);
		}
		
		Month month = new Month("agost");
		months.add(7, month);
		
		
		hashMonths = new HashSet<Month>(months);
		//aquest element ja está en la llista i per tant no es pot duplicar
		hashMonths.add(month);
	
		
		
		
		System.out.println("Llista mesos ArrayList");
		for(int i = 0; i< months.size(); i++) {
			System.out.println(months.get(i).getName());
		}
		
		Iterator<Month> iterator = hashMonths.iterator();
		
		System.out.println("\n" + "Llista mesos HashSet");
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getName());
		}
		
	}

}
