package org.example.domain_models;



import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;
import java.util.Set;

/**
 * This class represents a persistent class for Company.
 */

@Entity
@Table(name= "company")
public class Company {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long company_id;


    @Column
    private String company_name;

    @Column
    private Date found_date;



    // Constructor with all members
    public Company(Long company_id, String company_name, Date found_date) {
        this.company_id = company_id;
        this.company_name = company_name;
        this.found_date = found_date;
    }

    //no-argument constructor
    public Company() {

    }


//getter and setter methods

    public Long getCompany_id() {
        return company_id;
    }
    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }



    public String getCompany_name() {
        return company_name;
    }
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }



    public Date getFound_date() {
        return found_date;
    }
    public void setFound_date(Date found_date) {
        this.found_date = found_date;
    }



    @Override
    public String toString() {
        return "Company{" +
                "company_id=" + company_id +
                ", companyName='" + company_name + '\'' +
                ", foundDate=" + found_date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return company_id.equals(company.company_id) && company_name.equals(company.company_name) && found_date.equals(company.found_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company_id, company_name, found_date);
    }
}
