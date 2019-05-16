package br.gov.ce.seplag.esocial.mensageiro.schedule;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

@Component
public class Agendador {

	private final TaskScheduler executor;
	
	ScheduledFuture<?> future;

    @Autowired
    public Agendador(TaskScheduler taskExecutor) {
        this.executor = taskExecutor;
    }

    public void scheduling(final Runnable task, long periodoMillis) {

        // Schedule a task that will run as soon as possible and every 1000ms after the previous completion
    	future = executor.scheduleWithFixedDelay(task, Date.from(LocalDateTime.now().plusSeconds(10)
            .atZone(ZoneId.systemDefault()).toInstant()), periodoMillis);
    	
    }
    
    public void cancelSchedule() {
    	if (future != null) {
    		future.cancel(false);
    	} else {
    		System.out.println("Nenhuma automação foi detectada");
    	}
    }
}
