import java.util.ArrayList;

public enum School {
//    FROSTY_CASTLE("треуг вправо"),
//    CITY_OF_DRAGON("квадрат"),
//    LYRIA("треуг вверх"),
//    MORAE("круг"),
//    ICE_CITY("треуг вниз"),
//    LANTERN_COUNTRY("крест"),
//    MAGIC_ACADEMY("ромб"),
//    INDESTRUCTIBLE_CITY("плюс")
    FROSTY_CASTLE("Морозный замок"),
    CITY_OF_DRAGON("Город Драконов"),
    LYRIA("Лирия"),
    MORAE("Морай"),
    ICE_CITY("Ледяной город"),
    LANTERN_COUNTRY("Страна фонарей"),
    MAGIC_ACADEMY("Академия магии"),
    INDESTRUCTIBLE_CITY("Нерушимый город")
    ;

    private String description;
    School(String description) {
        this.description=description;
    }
    @Override
    public String toString() {
        return "Школа:"+description;
    }
}
