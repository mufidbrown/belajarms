package com.mufid.jobms.job;


import com.mufid.jobms.job.dto.JobWithCompanyDTO;

import java.util.List;

public interface JobService {
//    List<Job> findAll();

    List<JobWithCompanyDTO> findAll();

    void createJob(Job job);

    JobWithCompanyDTO getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
