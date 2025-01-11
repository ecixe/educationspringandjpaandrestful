package com.influencer.education.teacher.repo;

import com.influencer.education.teacher.entity.Teacher;
import com.influencer.education.teacher.entity.TeacherProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MyDataTeacherRepo extends JpaRepository<Teacher, Integer> {

    //Bu Springin sayesinde By dan sonra yazdigimiz ile db da yazdigizi birlesdirir
    public List<Teacher> findByName(String name);
    public List<Teacher> findByNameAndSurnameOrAge(String name, String surname, Integer age);

    @Query(nativeQuery = true, value = "select *, concat(name,' ',surname) as fullname from teacher")
    public List<TeacherProjection> finAll();

    @Modifying
    @Query("DELETE FROM Teacher t WHERE t.id = :id")
    void delete(@Param("id") Integer id);
}
