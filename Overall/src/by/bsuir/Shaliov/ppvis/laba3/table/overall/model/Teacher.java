package by.bsuir.Shaliov.ppvis.laba3.table.overall.model;



/**
 * Created by Andrey on 5/30/2016.
 */
public class Teacher {
    private String fio;
    private String name;
    private String secondaryName;
    private String middleName;
    private Object departmentName;
    private Object faculty;
    private Object academicTitle;
    private Object academicDegree;

    public Teacher() {
        name = "";
        secondaryName = "";
        middleName = "";
        fio = name + " " + secondaryName + " " + middleName;
        departmentName = "";
        faculty = "";
        academicDegree = "";
        academicTitle = "";
    }

    public Teacher(Object faculty, Object departmentName, String name, String secondaryName,
                   String middleName, Object academicTitle, Object academicDegree) {
        this.faculty = faculty;
        this.departmentName = departmentName;
        this.name = name;
        this.secondaryName = secondaryName;
        this.middleName = middleName;
        this.fio = name + " " + secondaryName + " " + middleName;
        this.academicTitle = academicTitle;
        this.academicDegree = academicDegree;

    }

    public void setFio(String name, String secondaryName, String middleName) {
        this.fio = name + " " + secondaryName + " " + middleName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setAcademicTitle(String academicTitle) {
        this.academicTitle = academicTitle;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    public Object get(int index) {
        switch (index) {
            case 0:
                return getFaculty();
            case 1:
                return getDepartmentName();
            case 2:
                return getFio();
            case 3:
                return getAcademicTitle();
            case 4:
                return getAcademicDegree();
            default:
                return "";
        }
    }

    public String getFio() {
        return name + " " + secondaryName + " " + middleName;
    }

    public Object getDepartmentName() {
        return departmentName;
    }

    public Object getFaculty() {
        return faculty;
    }

    public Object getAcademicTitle() {
        return academicTitle;
    }

    public Object getAcademicDegree() {
        return academicDegree;
    }

    public String getName() {
        return name;
    }

    public String getSecondaryName() {
        return secondaryName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondaryName(String secondaryName) {
        this.secondaryName = secondaryName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setDepartmentName(Object departmentName) {
        this.departmentName = departmentName;
    }

    public void setFaculty(Object faculty) {
        this.faculty = faculty;
    }

    public void setAcademicTitle(Object academicTitle) {
        this.academicTitle = academicTitle;
    }

    public void setAcademicDegree(Object academicDegree) {
        this.academicDegree = academicDegree;
    }
}