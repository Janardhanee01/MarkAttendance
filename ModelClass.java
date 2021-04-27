package com.example.markattendance;

public class ModelClass {

    private int sno;
    private String name;
    private int year;
    private String department;


    public ModelClass(int sno, String name, int year, String department) {
        this.sno = sno;
        this.name = name;
        this.year = year;
        this.department = department;
    }


        public int getSno() {
            return sno;
        }

        public String getName() {
            return name;
        }

        public int getYear() {
            return year;
        }

        public String getDepartment() {
            return department;
        }
}
