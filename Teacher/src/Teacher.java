import java.util.Date;

public class Teacher {
    private String name;
    private String sex;
    private Integer rank;
    private Date birth;
    private static final Double BASIC_SALARY = 1.490;
    private Integer level;
    private Integer tier;

    public Teacher(String name, String sex, Integer rank, Integer tier, Integer level, Date birth) {
        this.name = name;
        this.sex = sex;
        this.rank = rank;
        this.birth = birth;
        this.level = level;
        this.tier = tier;
    }

    public Double coefficientsSalary(Double basicCoefficients, Double basicSum, Integer lengthTier) {
        if (tier >= 1 && tier <= lengthTier) {
            return basicCoefficients + (tier - 1) * basicSum;
        }
        return null;
    }

    public Double coefficientsSalaryWithTier() {
        if (level >= 1 && level <= 3 && rank == 1) {
            Double basicCoefficients = 4.40;
            return coefficientsSalary(basicCoefficients, 0.34, 8);
        } else if ((level >= 1 && level <= 3 && rank == 2) || (level == 0 && rank == 1)) {
            Double basicCoefficients = 4.00;
            return coefficientsSalary(basicCoefficients, 0.34, 8);
        } else if ((level >= 1 && level <= 3 && rank == 3) || (level == 0 && rank == 2)) {
            Double basicCoefficients = 2.34;
            return coefficientsSalary(basicCoefficients, 0.33, 9);
        } else if (level == 0 && rank == 3) {
            Double basicCoefficients = 2.10;
            return coefficientsSalary(basicCoefficients, 0.31, 9);
        }
        return null;
    }

    public Double salary() {
        if (coefficientsSalaryWithTier() != null) {
            return BASIC_SALARY * coefficientsSalaryWithTier();
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

    public static void main(String[] args) {

        Teacher teacher = new Teacher("Nguyen Van A", "Nam",1,11,2,new Date(2002,04,26));
        System.out.println("Salary: " +  (teacher.salary() == null ? "Khong hop le" : Math.round(teacher.salary()*10000.0)/10000.0));

    }
}
