package com.mufid.companyms.company;

import java.util.List;

public interface CompanyService {

//    List<Company> findAll();

    List<Company> getAllCompanies();
    boolean updateCompany(Company company, Long id);
    void createCompany(Company company);
    boolean deleteCompanyById(Long id);
    Company getCompanyById(Long id);
}
