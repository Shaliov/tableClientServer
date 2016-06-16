package by.bsuir.Shaliov.ppvis.laba3.table.overall.enumeration;

/**
 * Created by Andrey on 5/31/2016.
 */
public enum Departments {

    ИИТ("Интеллектуальныых информационных технологий"),
    ИТАС("Информационных технологий автоматизированных систем"),
    СУ("Систем управления"),
    ТОЭ("Теоретических основ электротехники"),
    РС("Радиотехнических систем"),
    ИР("Информационных радиотехнологий");

    private String name;

    Departments(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
