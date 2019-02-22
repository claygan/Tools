package com.quest.test.json.beans;

import java.util.List;

/**
 * Created by Quest on 2018/8/21.
 */
public class UserInfo {
    private String name;
    private int age;
    private String job;
    private Parent parent;

    public UserInfo() {
    }

    public static class Parent{
        private String father;
        private String month;
        private List<Company> companyList;

        public Parent() {
        }

        public String getFather() {
            return father;
        }

        public void setFather(String father) {
            this.father = father;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public List<Company> getCompanyList() {
            return companyList;
        }

        public void setCompanyList(List<Company> companyList) {
            this.companyList = companyList;
        }
    }
    public static class Company{
        private String cname;
        private String code;

        public Company() {
        }

        public String getCname() {
            return cname;
        }

        public void setCname(String cname) {
            this.cname = cname;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
