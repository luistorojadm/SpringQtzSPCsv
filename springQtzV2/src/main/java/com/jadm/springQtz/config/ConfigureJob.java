package com.jadm.springQtz.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;

import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.jadm.springQtz.Jobs.JobA;




@Configuration
public class ConfigureJob {
	
	@Value("${cron.expression}")
    private String CronConfig;
	
	
	@Bean
    public JobDetail jobADetails() {
        return JobBuilder.newJob(JobA.class).withIdentity("sampleJobA")
                .storeDurably().build();
    }

    @Bean
    public Trigger jobATrigger(JobDetail jobADetails) {

        return TriggerBuilder.newTrigger().forJob(jobADetails)

                .withIdentity("sampleTriggerA")
                .withSchedule(CronScheduleBuilder.cronSchedule(CronConfig))
                .build();
    }
 
    
}
