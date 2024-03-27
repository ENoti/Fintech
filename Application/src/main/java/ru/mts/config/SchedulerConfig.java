package ru.mts.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.mts.repository.AnimalsRepositoryImpl;

import javax.annotation.PostConstruct;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduler.enabled", matchIfMissing = true)
@Slf4j
public class SchedulerConfig {
    @Autowired
    AnimalsRepositoryImpl animalsRepository;

    @PostConstruct
    public void postConstruct(){
        Thread findAverageAgeThread = new Thread("AverageThread") {

            public void run() {
                try {
                    while (true) {
                        log.info("{}: {}", this.getName(), animalsRepository.findAverageAge());
                        Thread.sleep(20000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread findDuplicateThread = new Thread("PrintDuplicateThread") {

            public void run() {
                try {
                    while (true) {
                        log.info("{}: {}", this.getName(), animalsRepository.findDuplicateTrue());
                        Thread.sleep(10000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        findDuplicateThread.start();
        findAverageAgeThread.start();
    }
}
