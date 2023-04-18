package com.samplejunit.junitmockito;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.samplejunit.junitmockito.entity.DeleteInactiveUsersJob;

@Configuration
@EnableScheduling
public class SchedulerConfig  {

@Autowired
private DeleteInactiveUsersJob deleteInactiveUsersJob;


private static final Logger logger = LoggerFactory.getLogger(SchedulerConfig.class);

@Scheduled(cron="${cronExpression}")
public void deleteInactiveUsers()
{
	logger.info("Scheduled cron Inactive Student........"+ LocalTime.now());
	deleteInactiveUsersJob.deleteInactiveUsers();
}
}