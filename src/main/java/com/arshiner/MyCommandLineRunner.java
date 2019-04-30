package com.arshiner;


import java.util.Timer;
import java.util.TimerTask;

import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.arshiner.quartz.job.FlashCelueTask;
import com.arshiner.quartz.service.SchedulerJobService;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
	@Autowired
	SchedulerJobService schedulerJobService;
	@Autowired
	FlashCelueTask FlashCelueTask;
	@Override
	public void run(String... var1) throws Exception {
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				try {
					FlashCelueTask.executeF();
				} catch (JobExecutionException e) {
					e.printStackTrace();
					
				}
			}
			
		};
		Timer timer = new Timer();
		timer.schedule(timerTask, 10, 100000);
		
	}
}
