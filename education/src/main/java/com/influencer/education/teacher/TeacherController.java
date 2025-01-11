package com.influencer.education.teacher;

import com.influencer.education.common.dto.CommonDTO;
import com.influencer.education.teacher.dto.TeacherDTO;
import com.influencer.education.teacher.dto.TeacherMapper;
import com.influencer.education.teacher.repo.MyDataTeacherRepo;
import com.influencer.education.teacher.repo.TeacherRepo;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;

    @RestController
    @CrossOrigin
    @RequestMapping("/teachers")
    public class TeacherController {
        private final MyDataTeacherRepo dataRepo;

        private final TeacherRepo teacherRepo;

        public TeacherController(MyDataTeacherRepo dataRepo, TeacherRepo teacherRepo) {
            this.teacherRepo = teacherRepo;
            this.dataRepo = dataRepo;
        }

        @GetMapping
        public CommonDTO getList(@RequestParam(required = false) String name,
                                 @RequestParam(required = false) String surname,
                                 @RequestParam(required = false) String email,
                                 @RequestParam(required = false) Integer age,
                                 @RequestParam(required = false, name = "university") Integer universityId,
                                 @RequestParam(required = false) String password,
                                 @RequestParam(required = false) Integer address) {
//        return repo.getList("Sarkhan", "Rasullu", null, null, null, null);
//        return dataRepo.findAll(Sort.by("age"));
        /*
        if (pageNumber!=null) {
            PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
            Page<Teacher> all = dataRepo.findAll(pageRequest);
            return all.getContent();
        }else {
            return dataRepo.findAll();
        }*/
            return new CommonDTO().setObject(teacherRepo.getList(name, surname, email, age, universityId, password, address)
                            .stream()
                            .map(TeacherMapper.MAPPER::toDto)
                            .collect(Collectors.toList()))
                    .setDateTime(LocalDateTime.now());

            /*
            List<TeacherDTO> result = new ArrayList<>();
            for (Teacher teacher : list) {
                result.add(new TeacherDTO()
                        .setId(teacher.getId())
                        .setName(teacher.getName())
                        .setSurname(teacher.getSurname())
                        .setEmail(teacher.getEmail())
                        .setAge(teacher.getAge())
                        .setUniversity(new UniversityDTO()
                                .setId(teacher.getUniversity().getId())
                                .setName(teacher.getUniversity().getName())
                        )
                );
            }
            return result;
            */
        }


    //    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public CommonDTO save(@RequestBody TeacherDTO teacherDTO) {
        teacherRepo.insert(TeacherMapper.MAPPER.toEntity(teacherDTO));
        return new CommonDTO().setDateTime(LocalDateTime.now())
                .setMessage("Successfully insert");
    }

    @PutMapping
    public CommonDTO update(@RequestBody TeacherDTO teacherDTO) {
        dataRepo.save(TeacherMapper.MAPPER.toEntity(teacherDTO));
        return new CommonDTO().setDateTime(LocalDateTime.now())
                .setMessage("Successfully update");
    }

    @DeleteMapping
    public CommonDTO delete(@RequestParam Integer id) {
        dataRepo.delete(id);
        return new CommonDTO().setDateTime(LocalDateTime.now())
                .setMessage("Successfully delete");
    }

    @GetMapping("{id}")
    public CommonDTO findById(@PathVariable("id") Integer id) {
        return new CommonDTO().setObject(dataRepo.findById(id).map(TeacherMapper.MAPPER::toDto).orElse(new TeacherDTO()))
                .setDateTime(LocalDateTime.now());
    }


}
