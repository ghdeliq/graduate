package com.numberone.system.service.impl;

import com.numberone.common.exception.BusinessException;
import com.numberone.common.support.Convert;
import com.numberone.system.domain.CourseClass;
import com.numberone.system.domain.SysCourse;
import com.numberone.system.mapper.CourseClassMapper;
import com.numberone.system.mapper.SysCourseMapper;
import com.numberone.system.service.ISysCourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysCourseServiceImpl implements ISysCourseService {

    private static final Logger log = LoggerFactory.getLogger(SysCourseServiceImpl.class);

    @Autowired
    private SysCourseMapper sysCourseMapper;

    @Autowired
    private CourseClassMapper courseClassMapper;

    /**
     * 查询所有课程列表
     * （未删除的）
     */
    @Override
    public List<SysCourse> selectCourses() {
        log.info("查询所有课程列表（未删除的）");
        List<SysCourse> courseList = sysCourseMapper.selectCourses();
        for (SysCourse c : courseList) {
            log.info("course ", c.toString());
        }
        return courseList;    }

    /**
     * 根据dept_id查询课程列表
     * （未删除的）
     */
    @Override
    public List<SysCourse> selectCoursesByDeptId(Long deptId) {
        int classId = deptId.intValue();
        CourseClass courseClass = new CourseClass();
        courseClass.setClassId(new Integer(classId));
        List<CourseClass> cclist = courseClassMapper.selectCourseClassList(courseClass);
        List<SysCourse> courseList = new ArrayList<SysCourse>();
        for (CourseClass cc : cclist) {
            log.info("课程Service  cc ", cc.toString());
            SysCourse course = sysCourseMapper.selectCourseById(cc.getCourseId());
            log.info("课程Service  course", course.toString());
            courseList.add(course);
        }
        return courseList;
    }

    /**
     * 查询所有在开设课程
     */
    @Override
    public List<SysCourse> selectUseCourses() {
        List<SysCourse> courseList = sysCourseMapper.selectUseCourses();
        return courseList;
    }

    /**
     * 增加课程
     *
     * @param course
     */
    @Override
    public int insertCourse(SysCourse course) {
        int num = sysCourseMapper.insertCourse(course);
        return num;
    }

    /**
     * 删除课程
     * （软删除）
     *
     * @param courseId
     */
    @Override
    public int deleteCourseByCourseId(Integer courseId) {
        int num = sysCourseMapper.deleteByCourseIdSoft(courseId);
        return num;
    }

    /**
     * 更换教材
     *
     * @param course
     */
    @Override
    public int changeTextbook(SysCourse course) {
        int num = sysCourseMapper.updateTextbookByCourseId(course);
        return num;
    }

    /**
     * 根据课程Id获取教材信息
     *
     * @param courseId
     * @return course
     */
    @Override
    public SysCourse getCourseById(Integer courseId) {
        SysCourse course = sysCourseMapper.selectCourseById(courseId);
        return course;
    }

    /**
     * 批量删除角色用户信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
//    @Override
//    public int deleteCourseByIds(String ids) throws BusinessException {
//        Integer[] courseIds = Convert.toIntArray(ids);
////        for (Integer courseId : courseIds)
////        {
////            SysCourse course = getCourseById(courseId);
////        }
//        return sysCourseMapper.deleteCourseByIds(courseIds);
//    }
}
