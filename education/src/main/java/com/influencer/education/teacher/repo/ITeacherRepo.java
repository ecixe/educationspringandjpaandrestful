package com.influencer.education.teacher.repo;

import com.influencer.education.teacher.entity.Teacher;
import java.util.List;

 public interface ITeacherRepo {
     List<Teacher> getList();
     void update(Teacher teacher);
     void delete(Integer id);
     void insert(Teacher teacher);
     Teacher findById(Integer id);
     List<Teacher> getList(String name, String surname, String email, Integer age, Integer universityId, String password, Integer address);
}
