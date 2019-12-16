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
import com.jadm.springQtz.Jobs.JobB;
import com.jadm.springQtz.Jobs.JobC;



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
 
    /*
	@Bean
    public JobDetail jobCDetails() {
        return JobBuilder.newJob(JobC.class).withIdentity("sampleJobC")
                .storeDurably().build();
    }

    @Bean
    public Trigger jobCTrigger(JobDetail jobCDetails) {

        return TriggerBuilder.newTrigger().forJob(jobCDetails)

                .withIdentity("sampleTriggerC")
                .withSchedule(CronScheduleBuilder.cronSchedule(CronConfig))
                //.forJob(sampleJobA)
                .build();
    }
	
    /*  
   
public class ConfigureBJob{
	
	@Bean
    public JobDetail jobBDetails() {
        return JobBuilder.newJob(JobB.class).withIdentity("sampleJobB")
                .storeDurably().build();
    }

    @Bean
    public Trigger jobBTrigger(JobDetail jobBDetails) {

        return TriggerBuilder.newTrigger().forJob(jobBDetails)

                .withIdentity("sampleTriggerB")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * ? * * *"))
                //.forJob(sampleJobC)
                .build();
    }
    
}

    @Bean
    public JobDetail jobSp2Details() {
        return JobBuilder.newJob(JobSp2.class).withIdentity("sampleJobC")
                .storeDurably().build();
    }

    @Bean
    public Trigger jobSp2Trigger(JobDetail jobBDetails) {

        return TriggerBuilder.newTrigger().forJob(jobBDetails)

                .withIdentity("sampleTriggerC")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * ? * * *"))
                .build();
    }
*/	
}
