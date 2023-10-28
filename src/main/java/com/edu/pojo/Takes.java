package com.edu.pojo;

public class Takes {
    private String studentid;
    private String courseid;
    private String cname;
    private String lecturer;
    private String header;
    private String first;
    private String second;

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Takes{" +
                "studentid='" + studentid + '\'' +
                ", courseid='" + courseid + '\'' +
                ", cname='" + cname + '\'' +
                ", lecturer='" + lecturer + '\'' +
                ", header='" + header + '\'' +
                ", first='" + first + '\'' +
                ", second='" + second + '\'' +
                '}';
    }
}
