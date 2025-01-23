package com.influencer.education.teacher.repo;

import com.influencer.education.teacher.entity.Teacher;
import com.influencer.education.teacher.entity.TeacherProjection;
import com.influencer.education.teacher.entity.University;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MyDataUniversityRepo extends JpaRepository<University, Integer> {

}
