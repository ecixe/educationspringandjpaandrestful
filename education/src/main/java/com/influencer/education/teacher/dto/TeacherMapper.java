package com.influencer.education.teacher.dto;

import com.influencer.education.teacher.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherMapper {

    TeacherMapper MAPPER = Mappers.getMapper(TeacherMapper.class);

    TeacherDTO toDto(Teacher teacher);
    Teacher toEntity(TeacherDTO teacherDTO);
}
