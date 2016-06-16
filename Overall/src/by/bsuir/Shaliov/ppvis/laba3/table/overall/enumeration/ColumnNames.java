package by.bsuir.Shaliov.ppvis.laba3.table.overall.enumeration;

/**
 * Created by Andrey on 5/31/2016.
 */
public enum ColumnNames {
    FACULTY("Факультет"),
    DEPARTMENT_NAME("Название кафедры"),
    FIO("ФИО преподавателя"),
    ACADEMIC_TITLE("ученое звание"),
    ACADEMIC_DEGREE("ученая степень"), ;

    private String name;

    ColumnNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


