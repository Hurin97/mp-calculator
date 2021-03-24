public class Mentor {
    public int id;
    public String name;
    public Double Points;
    public School school;
    public Skill skill;
    public int price;
    public Integer rank;
    public Integer level;

    public Mentor(int id, String name, Double points, School school, Skill skill, int price, Integer rank, Integer level) {
        this.id = id;
        this.name = name;
        Points = points;
        this.school = school;
        this.skill = skill;
        this.price = price;
        this.rank = rank;
        this.level = level;
    }

    @Override
    public String toString() {
//        return "♣"+name+"♦"+school.toString()+"♠"+skill.toString();
        return name+" "+school.toString()+" "+skill.toString();
    }
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPoints() {
        return Points;
    }

    public void setPoints(Double points) {
        Points = points;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
