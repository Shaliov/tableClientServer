package by.bsuir.Shaliov.ppvis.laba3.table.overall.enumeration;

/**
 * Created by Andrey on 5/31/2016.
 */
public enum AcademicDegrees {
    кн("кандитат наук"),
    дн("доктор наук");

    private String name;

    AcademicDegrees(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
