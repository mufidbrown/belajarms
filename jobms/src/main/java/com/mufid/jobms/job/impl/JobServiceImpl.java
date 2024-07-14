package com.mufid.jobms.job.impl;


import com.mufid.jobms.job.Job;
import com.mufid.jobms.job.JobRepository;
import com.mufid.jobms.job.JobService;
import com.mufid.jobms.job.dto.JobWithCompanyDTO;
import com.mufid.jobms.job.external.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {
    // private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;

    @Autowired
    RestTemplate restTemplate;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<JobWithCompanyDTO> findAll() {
        List<Job> jobs = jobRepository.findAll();
        List<JobWithCompanyDTO> jobWithCompanyDTOs = new ArrayList<>();

        return jobs.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private JobWithCompanyDTO convertToDto(Job job){
            JobWithCompanyDTO jobWithCompanyDTO = new JobWithCompanyDTO();
            jobWithCompanyDTO.setJob(job);
//            RestTemplate restTemplate = new RestTemplate();
            Company company = restTemplate.getForObject(
                    "http://COMPANY-SERVICE:8081/companies/" + job.getCompanyId(),
                    Company.class);
            jobWithCompanyDTO.setCompany(company);

            return jobWithCompanyDTO;
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}



//        RestTemplate restTemplate = new RestTemplate();

//        for (Job job:
//             jobs) {
//            JobWithCompanyDTO jobWithCompanyDTO = new JobWithCompanyDTO();
//            jobWithCompanyDTO.setJob(job);
//
//            Company company = restTemplate.getForObject(
//                    "http://localhost:8081/companies/" + job.getCompanyId(),
//                    Company.class);
//            jobWithCompanyDTO.setCompany(company);
//
//            jobWithCompanyDTOs.add(jobWithCompanyDTO);
//        }



//        Company company = restTemplate.getForObject("http://localhost:8081/companies/1",
//                Company.class);
//        System.out.println("COMPANY : " + company.getName());
//        System.out.println("COMPANY : " + company.getId());
//        return jobRepository.findAll();

//        return jobWithCompanyDTOs;

