package by.bsuir.Shaliov.ppvis.laba3.table.overall.enumeration;

/**
 * Created by Andrey on 5/31/2016.
 */
public enum AcademicTitles {
    доцент("доцент"),
    профессор("профессор");

    private String name;

    AcademicTitles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
