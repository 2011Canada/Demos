package com.revature.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.revature.models.PurchaseHistory;
import com.revature.models.PurchaseHistoryLine;

@Component
@Aspect
public class CardStockLoggingAspect {

	
	
	
	//whenever a new purchase involving cardstock is successfully made
	
	//pointcut expression
	@Pointcut(value = "execution(com.revature.models.PurchaseHistory com.revature.services.*.savePurchaseHistory(..))")
	public void specificPointCut() {
	}
	
	@AfterReturning(pointcut = "specificPointCut()", returning = "ph")
	public void logIfCardStock(PurchaseHistory ph) {
		for(PurchaseHistoryLine phl : ph.getTotalPurchase()) {
			if(phl.getOption().getType().equals("CardStock")) {
				System.out.println(ph.getPurchaser().getName() + " bought " + phl.getAmount() + " CardStock" );
			}
		}
	}
	
	
}
