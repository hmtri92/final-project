package com.csc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.csc.service.ScheduledService;

@Service
public class ScheduledServiceImpl extends QuartzJobBean {


	
	public boolean updateAllBalanceInfo(){
		
				
		return false;		
	}

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		// TODO Auto-generated method stub
	/*	scheduledService.updateAllBalanceInfo();*/
		System.err.println("Run update balance services");
	}
}
