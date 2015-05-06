package com.csc.ultil;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.csc.service.ScheduledService;

public class AutoUpdateBalanceHistory extends QuartzJobBean{
	private ScheduledService scheduledService;
	
	public void setScheduledService(ScheduledService scheduledService){
		this.scheduledService = scheduledService;
	}

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		scheduledService.updateBalanceHistory();
	}

}
