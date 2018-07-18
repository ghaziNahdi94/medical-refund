package com.cynapsys.schedule;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cynapsys.Repositories.BordereauRepository;
import com.cynapsys.Repositories.BulletinSoinRepository;
import com.cynapsys.Repositories.ParametresRepository;
import com.cynapsys.controllers.BulletinSoinController;
import com.cynapsys.controllers.Parametres;
import com.cynapsys.entities.Bordereau;
import com.cynapsys.entities.BulletinSoin;

@Component
public class VerifictionBordoreau {


	@Autowired
	private ParametresRepository pr;
	
	@Autowired
	private BulletinSoinRepository bsr;
	
	@Autowired
	private BordereauRepository br;
	
	
	
	@EventListener(ApplicationReadyEvent.class)
	public void initDates() {
		
		if(pr.findById(0) == null) {
		//Les dates par défaut   forme:(jour;heure:minute)
				List<String> dates = new ArrayList();
				String date1 = "1;8:30";
				String date2 = "16;8:30";
				dates.add(date1);
				dates.add(date2);
								
				Parametres	p = new Parametres(0,dates);
		
				pr.save(p);
				
				System.out.println("initialisation des dates d'envoi----------------------------");
		}
				
		if(br.findAll() == null || br.findAll().size() == 0) {
				Bordereau bordereau = new Bordereau();
				
				br.save(bordereau);
				
				System.out.println("Un nouveau bordereau est crée----------------------------");
		}
	}
	
	
	
	
	
	@Scheduled(fixedDelay=60000)
	public void sendedToGAT() {
		
	Date now = new Date();
	
	int day = now.getDate();
	int hour = now.getHours();
	int minute = now.getMinutes();
	
	
	
	Parametres param = pr.findById(0);
	
	if(param != null) {
	List<String> dates = param.getDatesEnvoi();
	
	
	new Thread(new Runnable() {
		
		@Override
		public void run() {
			
			for(String date : dates) {
				
				String dayStr = date.split(";")[0].trim();
				String timeStr = date.split(";")[1].trim();
				String hourStr = timeStr.split(":")[0].trim();
				String minuteStr = timeStr.split(":")[1].trim();
				
				
				
				if(Integer.parseInt(dayStr) == day && Integer.parseInt(hourStr) == hour && Integer.parseInt(minuteStr) == minute) {
					changeStatesToGat();
				}
				
			}
			
		}
	}).start();

	}
			
	}
	
	
	
	
	
	
	
	private void changeStatesToGat() {
		
		
		Bordereau bordereau = br.findAll().stream().filter(bord -> bord.getDateEnvoi() == null).collect(Collectors.toList()).get(0);
		

		List<BulletinSoin> bulletins = bsr.findAll();
		
		
		List<BulletinSoin> enCours = bulletins.stream().filter(b -> b.getEtat().equals("En cours")).collect(Collectors.toList());
		
		
		for(BulletinSoin b : enCours) {
			
			b.setEtat("Chez GAT");
			b.setBordereauId(bordereau.getId());
		
		}
		
		
		bsr.saveAll(enCours);
		
		bordereau.setDateEnvoi(new Date());
		br.save(bordereau);
		
		
		bordereau = new Bordereau();
		
		br.save(bordereau);
		
		System.out.println("Un nouveau bordereau est crée----------------------------");
		
	}
	
	
}
