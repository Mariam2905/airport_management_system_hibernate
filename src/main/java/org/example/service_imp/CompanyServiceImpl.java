package org.example.service_imp;

        import jakarta.persistence.TypedQuery;
        import org.example.domain_models.Company;
        import org.example.hibernate_util.HibernateUtil;
        import org.example.service.CompanyService;
        import org.hibernate.HibernateException;
        import org.hibernate.Session;
        import org.hibernate.Transaction;

        import javax.management.Query;
        import java.util.ArrayList;
        import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    List companyList = new ArrayList<>();


    /**
     * Method gets the company data by company_id.
     * @return company data
     */
    @Override
    public Company getById(long id) {
        Company company;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            company = session.get(Company.class, id);
            transaction.commit();
        }        catch(HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            session.close();
        }
        return company;
    }


    /**
     * Method gets all company data from company entity.
     * @return all information about all the companies from entity company.
     */
    @Override
    public List<Company> getAll() {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            List<Company> companyList = session.createQuery("FROM Company ").list();
            transaction.commit();
        }        catch(HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            session.close();
        }
        return companyList;
    }


    /**
     * Method gets company data by pages.
     * @param offset from which company should be shown the page.
     * @param perPage how many companies are being shown in a page
     * @param sort by which column of the company table
     * @return the sorted company data from some point to some point.
     */
    @Override
    public List<Company> get(int offset, int perPage, String sort) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            String query = "select c from Company c where c.company_id >= :offset order by c." + sort;
            TypedQuery<Company> typedQuery = session.createQuery(query,Company.class);
            typedQuery.setParameter("offset", offset);
            typedQuery.setMaxResults(perPage);
            List<Company> companyList = typedQuery.getResultList();
            session.getTransaction().commit();
        }catch(HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            session.close();
        }
        return companyList;
    }


    /**
     * Saves a new company into our passenger entity.
     * @param company will be saved
     * @return saves company
     */
    @Override
    public Company save(Company company) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.persist(company);
            transaction.commit();
        }
        catch(HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            session.close();
        }
        return company;
    }


    /**
     * Updates company by its id
     * @param company
     * @return the updated company
     */

    @Override
    public Company update(Company company, long id) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            company.setCompany_id(id);
            session.merge(company);
            transaction.commit();
        }
        catch(HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            session.close();
        }
        return company;
    }


    /**
     * Deletes a passenger from an entity by company_id
     * @param companyId
     */
    @Override
    public void delete(long companyId) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.remove(session.get(Company.class, companyId));
            transaction.commit();
        }
        catch(HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            session.close();
        }

    }




}
