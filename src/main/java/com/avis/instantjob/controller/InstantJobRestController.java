package com.avis.instantjob.controller;

import com.avis.instantjob.model.Job;
import com.avis.instantjob.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class InstantJobRestController {

    @Autowired
    private JobRepository jobRepository;

    @Value("${my.greeting}")
    private String greeting_message;

    @GetMapping("/greeting")
    public String greeting() {
        return greeting_message;
    }

    @PostMapping("/postJob")
    public Job createJob(@RequestBody Job job) {
        if (job.getDate() == null) {
            job.setDate(LocalDate.now().toString());
        }
        return jobRepository.save(job);
    }

    @GetMapping("/getJobs")
    public Iterable<Job> getJob() {
        return jobRepository.findAll();
    }

    @GetMapping()
    public String initializer() {
        return "Application running successfully...";
    }
}
