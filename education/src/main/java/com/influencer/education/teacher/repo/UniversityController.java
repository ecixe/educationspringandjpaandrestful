package com.influencer.education.teacher.repo;
import com.influencer.education.teacher.entity.Teacher;
import com.influencer.education.teacher.entity.University;
import java.util.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/university")
public class UniversityController {
    private final MyDataUniversityRepo dataRepo;
    public UniversityController( MyDataUniversityRepo dataRepo) {
        this.dataRepo = dataRepo;
    }
    @GetMapping
    public List<University> getList() {
        return dataRepo.findAll();
    }

    public void insert(){
        University university = new University();
        university.setName("Ganja");

        Teacher teacher = new Teacher();
        teacher.setName("Test");

        Teacher teacher2 = new Teacher();
        teacher2.setName("Test2");

        university.setTeacherList(Arrays.asList(teacher, teacher2));

        dataRepo.save(university);
    }

}
