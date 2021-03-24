import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Processing {
    public void start() {
        String fOUT ="mentors_I.txt";
        List<Mentor> mentors = new ArrayList<Mentor>();
        mentors.add(new Mentor(1,"Е Юньсинь",90.0,School.FROSTY_CASTLE,Skill.TRAVELER,1,1,1));
        mentors.add(new Mentor(2,"Дун Сюань",100.0,School.CITY_OF_DRAGON,Skill.TRAVELER,1,1,1));
        mentors.add(new Mentor(3,"Туму",70.0,School.LYRIA,Skill.MIGHTY_WARRIOR,1,1,1));
        mentors.add(new Mentor(4,"Мазар",80.0,School.MORAE,Skill.NOTHING,1,1,1));
        mentors.add(new Mentor(5,"Гот-Рагг",120.0,School.MORAE,Skill.RULER,1,1,1));
        mentors.add(new Mentor(6,"Архат Солнца",110.0,School.MORAE,Skill.NOTHING,1,1,1));
        mentors.add(new Mentor(7,"Е Юншан",280.0,School.FROSTY_CASTLE,Skill.TRAVELER,2,2,1));
        mentors.add(new Mentor(8,"Клемент",140.0,School.ICE_CITY,Skill.PROPHET,2,2,1));
        mentors.add(new Mentor(9,"Лян Цзи",160.0,School.LANTERN_COUNTRY,Skill.PROPHET,2,2,1));
        mentors.add(new Mentor(10,"Фриза",220.0,School.MAGIC_ACADEMY,Skill.MIGHTY_WARRIOR,2,2,1));
        mentors.add(new Mentor(11,"Диния",240.0,School.INDESTRUCTIBLE_CITY,Skill.MIGHTY_WARRIOR,2,2,1));
        mentors.add(new Mentor(12,"Анжелина",200.0,School.MAGIC_ACADEMY,Skill.RULER,2,2,1));
        mentors.add(new Mentor(13,"Чжэнь Юаньян",180.0,School.LYRIA,Skill.NOTHING,2,2,1));
        mentors.add(new Mentor(14,"Шагг-Неграт",260.0,School.MORAE,Skill.NOTHING,2,2,1));
        mentors.add(new Mentor(15,"Юнни",300.0,School.CITY_OF_DRAGON,Skill.TRAVELER,3,3,1));
        mentors.add(new Mentor(16,"Марианна",330.0,School.ICE_CITY,Skill.PROPHET,3,3,1));
        mentors.add(new Mentor(17,"Густав",240.0,School.ICE_CITY,Skill.MIGHTY_WARRIOR,3,3,1));
        mentors.add(new Mentor(18,"Хэлянь",270.0,School.CITY_OF_DRAGON,Skill.RULER,3,3,1));
        mentors.add(new Mentor(19,"Кандист",360.0,School.INDESTRUCTIBLE_CITY,Skill.MIGHTY_WARRIOR,3,3,1));
        mentors.add(new Mentor(20,"Му Шихуань",210.0,School.LANTERN_COUNTRY,Skill.RULER,3,3,1));
        mentors.add(new Mentor(21,"Магна",390.0,School.MAGIC_ACADEMY,Skill.NOTHING,3,3,1));
        mentors.add(new Mentor(22,"Шелли",520.0,School.ICE_CITY,Skill.TRAVELER,4,4,1));
        mentors.add(new Mentor(23,"Юй Хайнин",320.0,School.LYRIA,Skill.TRAVELER,4,4,1));
        mentors.add(new Mentor(24,"Дармаг",440.0,School.MAGIC_ACADEMY,Skill.TRAVELER,4,4,1));
        mentors.add(new Mentor(25,"Анфантрина",480.0,School.ICE_CITY,Skill.PROPHET,4,4,1));
        mentors.add(new Mentor(26,"Му Янхай",560.0,School.LANTERN_COUNTRY,Skill.MIGHTY_WARRIOR,4,4,1));
        mentors.add(new Mentor(27,"Эрликсон",360.0,School.INDESTRUCTIBLE_CITY,Skill.RULER,4,4,1));
        mentors.add(new Mentor(28,"Двуликий",400.0,School.MORAE,Skill.NOTHING,4,4,1));
        mentors.add(new Mentor(29,"Гаотинь",600.0,School.MORAE,Skill.NOTHING,5,5,1));
//        BranchesOfMentors res = this.operation(mentors.get(0),mentors.get(1),mentors.get(14),mentors.get(6),mentors.get(21),mentors.get(23));
        SortedSet<BranchesOfMentors> resultSet = this.generation(mentors);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fOUT);
            fileOutputStream.write("|Всего очков в день|Затраченные очки потенциала|Набор наставников| \n".getBytes());
            resultSet.stream().forEach(b-> {
                try {
                    fileOutputStream.write(b.toString().getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            fileOutputStream.write(("Всего наборов:"+resultSet.size()).getBytes());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Всего наборов:"+resultSet.size());
    }

    public SortedSet<BranchesOfMentors> generation (List<Mentor> mentorList) {
        SortedSet<BranchesOfMentors> resultSet = new TreeSet(new BranchesOfMentors().branchesOfMentorsComparator);
        int N = mentorList.size()-1;
//        int N=5;
        int k = 6;
        int count=0;
        int[] combinationArr=firstCombination(k);
        resultSet.add(this.operation(mentorList.get(combinationArr[0]),mentorList.get(combinationArr[1]),
                mentorList.get(combinationArr[2]),mentorList.get(combinationArr[3]),
                mentorList.get(combinationArr[4]),mentorList.get(combinationArr[5])));
        count++;
        while (hasNextCombination(combinationArr,N,k)) {
            resultSet.add(this.operation(mentorList.get(combinationArr[0]),mentorList.get(combinationArr[1]),
                    mentorList.get(combinationArr[2]),mentorList.get(combinationArr[3]),
                    mentorList.get(combinationArr[4]),mentorList.get(combinationArr[5])));
        }
        return resultSet;
    }

    public int[] firstCombination(int k){
        int [] arr = new int [k];
        for (int i = 0; i < k; i++)
            arr[i] = i ;
        return arr;
    }

    public boolean hasNextCombination (int[] x, int N, int k) {
        for (int i=k-1; i>=0;i--) {
            if (x[i]<N-k+i+1){
                x[i]++;
                for (int j = i; j < k - 1; j++)
                    x[j + 1] = x[j] + 1;
                return true;
            }
        }
        return false;
    }

    public BranchesOfMentors operation(Mentor m1, Mentor m2, Mentor m3, Mentor m4, Mentor m5, Mentor m6) {
        List <Mentor> mL = new ArrayList<Mentor>() ;
        mL.add(m1);
        mL.add(m2);
        mL.add(m3);
        mL.add(m4);
        mL.add(m5);
        mL.add(m6);

        BranchesOfMentors bOM = this.countingPointsV2(mL);
        return bOM;
    }
    public BranchesOfMentors countingPoints (List<Mentor> mentorList) {
        int frostyCastle=0;
        int cityDragon=0;
        int lyria=0;
        int morae=0;
        int iceC=0;
        int lCountry=0;
        int magicAc=0;
        int indC=0;
        int noth=0;
        int trav=0;
        int mWar=0;
        int rul=0;
        int proph=0;
        int highPosIC=0;
        Double highPosMP=0.0;
        int highIClev=0;
        int highICrank=0;
        for (Mentor ment :mentorList) {
            switch (ment.getSchool()) {
                case FROSTY_CASTLE:
                    frostyCastle++;
                    break;
                case CITY_OF_DRAGON:
                    cityDragon++;
                    break;
                case LYRIA:
                    lyria++;
                    break;
                case MORAE:
                    morae++;
                    if (highPosMP<ment.getPoints()){
                        highPosMP=ment.getPoints();
                    }
                    break;
                case ICE_CITY:
                    iceC++;
                    break;
                case LANTERN_COUNTRY:
                    lCountry++;
                    break;
                case MAGIC_ACADEMY:
                    magicAc++;
                    break;
                case INDESTRUCTIBLE_CITY:
                    indC++;
                    if(highIClev<ment.getLevel()){
                        highIClev=ment.getLevel();
                        highPosIC=ment.getId();
                    } else if (highICrank<ment.getRank()) {
                        highICrank=ment.getRank();
                        highPosIC=ment.getId();
                    }
                    break;
            }
            switch (ment.getSkill()) {
                case NOTHING:
                    noth++;
                    break;
                case TRAVELER:
                    trav++;
                    break;
                case MIGHTY_WARRIOR:
                    mWar++;
                    break;
                case RULER:
                    rul++;
                    break;
                case PROPHET:
                    proph++;
                    break;
            }
        }
        Integer totalPrice=0;
        Double totalPoints=0.0;
        Double totalMp= 1.0;
        boolean cityOfDragonBonus=false;
        boolean lyriaBonus=false;
        for (int i=0; i<mentorList.size();i++) {
            Mentor ment=mentorList.get(i);
            Double mn = 1.0;
            switch (ment.getSchool()) {
                case FROSTY_CASTLE:
                    if (frostyCastle==2) {
                        mn*=1.2;
                    }
                    break;
                case CITY_OF_DRAGON:
                    if (cityDragon>=2){
                        if (cityOfDragonBonus==false){
                            totalMp*=1.1;
                            cityOfDragonBonus=true;
                        }
                    }
                    break;
                case LYRIA:
                    if(lyria==3&&lyriaBonus==false){
                       totalMp*=1.5;
                       lyriaBonus=true;
                    }
                    break;
                case MORAE:
                    if(morae>=3&&morae<6&&highPosMP==ment.getPoints()){
                        mn*=2;
                    } else if(morae==6){
                        mn*=2.5;
                    }
                    break;
                case ICE_CITY:
                    if(iceC==5){
                        mn*=1.6;
                    }
                    break;
                case LANTERN_COUNTRY:
                    if (lCountry==3){
                        mn*=2;
                    }
                    break;
                case MAGIC_ACADEMY:
                    if(magicAc==1){
                        mn*=1.5;
                    }
                    break;
                case INDESTRUCTIBLE_CITY:
                    if (indC<=1&&highPosIC==ment.getId()){
                        mn*=1.5;
                    }
                    break;
            }
            switch (ment.getSkill()){
                case NOTHING:
                    break;
                case TRAVELER:
                    if (trav>=3&&trav<6) {
                        mn*=1.3;
                    }
                    if (trav==6) {
                        mn*=2;
                    }
                    break;
                case MIGHTY_WARRIOR:
                    if(mWar>=2&&mWar<4){
                        mn*=1.35;
                    } else
                    if (mWar==4){
                        mn*=1.7;
                    } else
                    if (mWar==5) {
                        mn*=2.05;
                    }
                    break;
                case RULER:
                    if (rul>=3&&rul<6) {
                        mn*=1.5;
                    } else if (rul==6) {
                        mn*=2.6;
                    }
                    break;
                case PROPHET:
                    if (proph==3) {
                        mn*=1.5;
                    } else if(proph==4){
                        mn*=2;
                    }
                    break;
            }
            totalPoints+=ment.getPoints()*mn;
            totalPrice+=ment.getPrice();
        }
        totalPoints*=totalMp;
        BranchesOfMentors bOM=new BranchesOfMentors(mentorList,totalPrice,totalPoints);
        return bOM;
    }

    public BranchesOfMentors countingPointsV2 (List<Mentor> mentorList) {
        int frostyCastle=0;
        int cityDragon=0;
        int lyria=0;
        int morae=0;
        int iceC=0;
        int lCountry=0;
        int magicAc=0;
        int indC=0;
        int noth=0;
        int trav=0;
        int mWar=0;
        int rul=0;
        int proph=0;
        int highPosIC=0;
        Double highPosMP=0.0;
        int highIClev=0;
        int highICrank=0;
        for (Mentor ment :mentorList) {
            switch (ment.getSchool()) {
                case FROSTY_CASTLE:
                    frostyCastle++;
                    break;
                case CITY_OF_DRAGON:
                    cityDragon++;
                    break;
                case LYRIA:
                    lyria++;
                    break;
                case MORAE:
                    morae++;
                    if (highPosMP<ment.getPoints()){
                        highPosMP=ment.getPoints();
                    }
                    break;
                case ICE_CITY:
                    iceC++;
                    break;
                case LANTERN_COUNTRY:
                    lCountry++;
                    break;
                case MAGIC_ACADEMY:
                    magicAc++;
                    break;
                case INDESTRUCTIBLE_CITY:
                    indC++;
                    if(highIClev<ment.getLevel()){
                        highIClev=ment.getLevel();
                        highPosIC=ment.getId();
                    } else if (highICrank<ment.getRank()) {
                        highICrank=ment.getRank();
                        highPosIC=ment.getId();
                    }
                    break;
            }
            switch (ment.getSkill()) {
                case NOTHING:
                    noth++;
                    break;
                case TRAVELER:
                    trav++;
                    break;
                case MIGHTY_WARRIOR:
                    mWar++;
                    break;
                case RULER:
                    rul++;
                    break;
                case PROPHET:
                    proph++;
                    break;
            }
        }
        Integer totalPrice=0;
        Double totalPoints=0.0;
        Double defaultBranchPoints=0.0;
        Double totalMp= 1.0;
        boolean cityOfDragonBonus=false;
        boolean lyriaBonus=false;
        for (int i=0; i<mentorList.size();i++) {
            Mentor ment=mentorList.get(i);
            Double points = ment.getPoints();
            switch (ment.getSchool()) {
                case FROSTY_CASTLE:
                    if (frostyCastle==2) {
                        totalPoints+=points*0.2;
                    }
                    break;
                case CITY_OF_DRAGON:
                    if (cityDragon>=2){
                        if (cityOfDragonBonus==false){
                            totalMp*=1.1;
                            cityOfDragonBonus=true;
                        }
                    }
                    break;
                case LYRIA:
                    if(lyria==3){
                        if(lyria==3&&lyriaBonus==false){
                            totalMp*=1.5;
                            lyriaBonus=true;
                        }
                    }
                    break;
                case MORAE:
                    if(morae>=3&&morae<6&&highPosMP==points){
                        totalPoints+=points;
                    } else if(morae==6){
                        totalPoints+=points*1.5;
                    }
                    break;
                case ICE_CITY:
                    if(iceC==5){
                        totalPoints+=points*0.6;
                    }
                    break;
                case LANTERN_COUNTRY:
                    if (lCountry==3){
                        totalPoints+=points ;
                    }
                    break;
                case MAGIC_ACADEMY:
                    if(magicAc==1){
                        totalPoints+=points*0.5;
                    }
                    break;
                case INDESTRUCTIBLE_CITY:
                    if (indC<=1&&highPosIC==ment.getId()){
                        totalPoints+=points*0.5;
                    }
                    break;
            }
            switch (ment.getSkill()){
                case NOTHING:
                    break;
                case TRAVELER:
                    if (trav>=3&&trav<6) {
                        totalPoints+=points*0.3;
                    }
                    if (trav==6) {
                        totalPoints+=points;
                    }
                    break;
                case MIGHTY_WARRIOR:
                    if(mWar>=2&&mWar<4){
                        totalPoints+=points*0.35;
                    } else
                    if (mWar==4){
                        totalPoints+=points*0.7;
                    } else
                    if (mWar==5) {
                        totalPoints+=points*1.05;
                    }
                    break;
                case RULER:
                    if (rul>=3&&rul<6) {
                        totalPoints+=points*0.5;
                    } else if (rul==6) {
                        totalPoints+=points*1.6;
                    }
                    break;
                case PROPHET:
                    if (proph==3) {
                        totalPoints+=points*0.5;
                    } else if(proph==4){
                        totalPoints+=points;
                    }
                    break;
            }
            defaultBranchPoints+=points;
            totalPrice+=ment.getPrice();
        }
        totalPoints+=defaultBranchPoints*totalMp;
        BranchesOfMentors bOM=new BranchesOfMentors(mentorList,totalPrice,totalPoints);

        return bOM;
    }
}