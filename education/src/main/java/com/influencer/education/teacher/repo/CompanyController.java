package com.influencer.education.teacher.repo;
import com.influencer.education.teacher.entity.Company;
import com.influencer.education.teacher.entity.Teacher;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private final MyDataCompanyRepo dataRepo;
    public CompanyController(MyDataCompanyRepo dataRepo) {
        this.dataRepo = dataRepo;
    }
    @GetMapping
    public List<Company> getList(/*@RequestParam(required = false, value = "page_number") Integer pageNumber, @RequestParam(required = false, value = "page_size") Integer pageSize*/) {
        return dataRepo.findAll();
    }

}
