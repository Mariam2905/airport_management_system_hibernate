package org.example.service;

import org.example.domain_models.Company;

import java.util.List;

public interface CompanyService {

    Company getById(long id);
    List<Company> getAll();
    List<Company> get(int offset, int perPage, String sort);
    Company save(Company company);
    Company update(Company company, long company_id);
    void delete(long companyId);


}