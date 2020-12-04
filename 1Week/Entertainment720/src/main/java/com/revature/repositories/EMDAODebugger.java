package com.revature.repositories;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.revature.exceptions.MediaNotFoundException;
import com.revature.models.EntertainmentMedia;

public class EMDAODebugger {

	public static void main(String[] args) {
		EntertainmentMediaDAO emd = new EntertainmentMediaMemoryDao();
		
		List<EntertainmentMedia> catalgoue = emd.findAll();

		Collections.sort(catalgoue, new EntertainmentMediaRatingComparator());
		
		for(EntertainmentMedia em : catalgoue) {
			System.out.println(em);
		}
		
		Collections.sort(catalgoue, (o1,o2)->{
			if(o1.getPrice() > o2.getPrice()) {
				return 1;
			} else if (o1.getPrice() < o2.getPrice()) {
				return -1;
			}else {
				return 0;
			}
		});
		
		
		
		
		catalgoue.forEach(e->System.out.println(e.display()));
		//tree set and treemap will order them based on their comparison
//		
//		Set<EntertainmentMedia> setCat = new TreeSet<>(catalgoue);
//		
//		for(EntertainmentMedia em : setCat) {
//			System.out.println(em);
//		}
		
		
	}

}
