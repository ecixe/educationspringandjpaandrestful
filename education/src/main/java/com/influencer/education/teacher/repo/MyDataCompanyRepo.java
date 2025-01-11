package com.influencer.education.teacher.repo;

import com.influencer.education.teacher.entity.Company;
import com.influencer.education.teacher.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyDataCompanyRepo extends JpaRepository<Company, Integer> {

}
