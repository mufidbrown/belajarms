package com.mufid.jobms.job;


import com.mufid.jobms.job.dto.JobDTO;

import java.util.List;

public interface JobService {
//    List<Job> findAll();

    List<JobDTO> findAll();

    void createJob(Job job);

    JobDTO getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
