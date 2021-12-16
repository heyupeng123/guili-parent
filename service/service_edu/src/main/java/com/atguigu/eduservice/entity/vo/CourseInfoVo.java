package com.atguigu.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class CourseInfoVo {

    @ApiModelProperty(value = "课程ID")
    private String id;

    @ApiModelProperty(value = "课程讲师ID")
    private String teacherId;

    @ApiModelProperty(value = "课程专业ID")
    private String subjectId;

    @ApiModelProperty(value = "一级课程分类ID")
    private String subjectParentId;

    @ApiModelProperty(value = "课程标题")
    private String title;

    @ApiModelProperty(value = "课程销售价格，设置为0则可免费观看")
    private BigDecimal price;

    @ApiModelProperty(value = "总课时")
    private Integer lessonNum;

    @ApiModelProperty(value = "课程封面图片路径")
    private String cover;

    @ApiModelProperty(value = "课程简介")
    private String description;

    public CourseInfoVo() {
    }

    public CourseInfoVo(String id, String teacherId, String subjectId, String subjectParentId, String title, BigDecimal price, Integer lessonNum, String cover, String description) {
        this.id = id;
        this.teacherId = teacherId;
        this.subjectId = subjectId;
        this.subjectParentId = subjectParentId;
        this.title = title;
        this.price = price;
        this.lessonNum = lessonNum;
        this.cover = cover;
        this.description = description;
    }

    public String getSubjectParentId() {
        return subjectParentId;
    }

    public void setSubjectParentId(String subjectParentId) {
        this.subjectParentId = subjectParentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getLessonNum() {
        return lessonNum;
    }

    public void setLessonNum(Integer lessonNum) {
        this.lessonNum = lessonNum;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CourseInfoVo{" +
                "id='" + id + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", subjectId='" + subjectId + '\'' +
                ", subjectParentId='" + subjectParentId + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", lessonNum=" + lessonNum +
                ", cover='" + cover + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
