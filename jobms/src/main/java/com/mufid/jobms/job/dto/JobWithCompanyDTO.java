package com.mufid.jobms.job.dto;

import com.mufid.jobms.job.Job;
import com.mufid.jobms.job.external.Company;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobWithCompanyDTO {

    private Job job;
    private Company company;

}
