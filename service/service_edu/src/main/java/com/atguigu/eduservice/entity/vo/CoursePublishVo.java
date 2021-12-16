package com.atguigu.eduservice.entity.vo;

public class CoursePublishVo {
    private String id;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;//只用于显示

    public CoursePublishVo() {
    }

    public CoursePublishVo(String id, String title, String cover, Integer lessonNum, String subjectLevelOne, String subjectLevelTwo, String teacherName, String price) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.lessonNum = lessonNum;
        this.subjectLevelOne = subjectLevelOne;
        this.subjectLevelTwo = subjectLevelTwo;
        this.teacherName = teacherName;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getLessonNum() {
        return lessonNum;
    }

    public void setLessonNum(Integer lessonNum) {
        this.lessonNum = lessonNum;
    }

    public String getSubjectLevelOne() {
        return subjectLevelOne;
    }

    public void setSubjectLevelOne(String subjectLevelOne) {
        this.subjectLevelOne = subjectLevelOne;
    }

    public String getSubjectLevelTwo() {
        return subjectLevelTwo;
    }

    public void setSubjectLevelTwo(String subjectLevelTwo) {
        this.subjectLevelTwo = subjectLevelTwo;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CoursePublishVo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                ", lessonNum=" + lessonNum +
                ", subjectLevelOne='" + subjectLevelOne + '\'' +
                ", subjectLevelTwo='" + subjectLevelTwo + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
