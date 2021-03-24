public enum Skill {
    NOTHING("Без умения"),
    TRAVELER("Путник"),
    MIGHTY_WARRIOR("Могучий воин"),
    RULER("Правитель"),
    PROPHET("Пророк")
    ;
    private String description;
    Skill(String description) {
        this.description=description;
    }

    @Override
    public String toString() {
        return "Умение:"+description;
    }
}
