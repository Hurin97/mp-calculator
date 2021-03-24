import java.util.Comparator;
import java.util.List;

public class BranchesOfMentors {
    public List<Mentor> branchesOfMentors;
    public Integer totalPrice;
    public Double totalPoints;

    public Comparator<BranchesOfMentors> branchesOfMentorsComparator = new BranchesPointsComparator()
            .thenComparing(new BranchesPriceComparator());
    public Comparator<BranchesOfMentors> cmp= new BranchesOfMentors.BranchesPointsComparator();
    public BranchesOfMentors(List<Mentor> branchesOfMentors) {
        this.branchesOfMentors = branchesOfMentors;
    }

    public BranchesOfMentors(List<Mentor> branchesOfMentors, Integer totalPrice, Double totalPoints) {
        this.branchesOfMentors = branchesOfMentors;
        this.totalPrice = totalPrice;
        this.totalPoints = totalPoints;
    }

    public BranchesOfMentors() {
    }

    public List<Mentor> getBranchesOfMentors() {
        return branchesOfMentors;
    }

    public void setBranchesOfMentors(List<Mentor> branchesOfMentors) {
        this.branchesOfMentors = branchesOfMentors;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Double totalPoints) {
        this.totalPoints = totalPoints;
    }


    public Comparator<BranchesOfMentors> getBranchesOfMentorsComparator() {
        return branchesOfMentorsComparator;
    }

    public void setBranchesOfMentorsComparator(Comparator<BranchesOfMentors> branchesOfMentorsComparator) {
        this.branchesOfMentorsComparator = branchesOfMentorsComparator;
    }

    @Override
    public String toString() {
        StringBuilder branch = new StringBuilder();
        for (Mentor ment:branchesOfMentors) {
            branch.append(ment.toString()+"|");
        }
        return "|"+totalPoints+"|"+totalPrice+"|"+branch+"\n";
    }

    public class BranchesPointsComparator implements Comparator<BranchesOfMentors> {

        public int compare (BranchesOfMentors a, BranchesOfMentors b) {
            if (a.getTotalPoints()<b.getTotalPoints())
                return 2;
            else if (a.getTotalPoints()>b.getTotalPoints())
                return -1;
            else return 1;
        }
    }
    public class BranchesPriceComparator implements Comparator<BranchesOfMentors> {
        public int compare (BranchesOfMentors a, BranchesOfMentors b) {
            if (a.getTotalPrice()<b.getTotalPrice())
                return 2;
            else if (a.getTotalPrice()>b.getTotalPrice())
                return -1;
            else return 1;
        }


    }
}
