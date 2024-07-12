package logexecutiontime.service;

import org.springframework.stereotype.Service;

import logexecutiontime.annotation.LogExecutionTime;

@Service
public class MyService {

    @LogExecutionTime
    public void serve() throws InterruptedException {
        // Simulate method execution time
        Thread.sleep(2000);
    }
}

