package com.edu.pojo;

public class Apply {
    private String studentid;
    private String courseid;
    private String reason;
    private String prove;
    private String state;
    private String reject;

    private String statement;
    private String first;
    private String second;

    public void setStatement(String state){
        if(state.equals("1")){
             this.statement = "等待重新提交";
        }else if(state.equals("2")){
            this.statement = "已提交申请";
        }else if(state.equals("3")){
            this.statement = "第一审批人通过";
        }else if(state.equals("4")){
            this.statement = "第二审批人通过";
        }else if(state.equals("5")){
            this.statement = "已通过";
        }else if(state.equals("6")){
            this.statement = "已驳回";
        }else if(state.equals("7")){
            this.statement = "通过已确认";
        }else if(state.equals("8")){
            this.statement = "驳回已确认";
        }

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

    public String getStatement() {
        return statement;
    }



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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getProve() {
        return prove;
    }

    public void setProve(String prove) {
        this.prove = prove;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getReject() {
        return reject;
    }

    public void setReject(String reject) {
        this.reject = reject;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "studentid='" + studentid + '\'' +
                ", courseid='" + courseid + '\'' +
                ", reason='" + reason + '\'' +
                ", prove='" + prove + '\'' +
                ", state='" + state + '\'' +
                ", reject='" + reject + '\'' +
                '}';
    }
}
