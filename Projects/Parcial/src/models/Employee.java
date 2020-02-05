package models;

public class Employee {
	
	public static final int SALARY_POINT_VALUE = 14420;
	public static final double PENSION_CONTRIBUTION_PERCENTAGE = 0.04;
	public static final double SOLIDARITY_FOUND_PERCENTAGE = 0.02;
	public static final double SOURCE_RETENTION = 0.0448;
	public static final double HEALTH_CONTRIBUTION_PERCENTAGE = 0.04;
	public static final double PREMIUM_SERVICES_DIVISOR = 0.02;
	public static final double PREMIUM_HOLIDAYS_DIVISOR = 0.02;
	
	private long id;
	private String firstName;
	private String lastName;
	private RankingCategory rankingCategory;
	private DocumentType docType;
	private BondingType bondingType;
	private int salaryPoints;
	private int workedMonths;
	
	public Employee(long id, String firstName, String lastName, RankingCategory rankingCategory, DocumentType docType, BondingType bondingType,int salaryPoints, int workedMonths){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.rankingCategory = rankingCategory;
		this.docType = docType;
		this.salaryPoints = salaryPoints;
		this.workedMonths = workedMonths;
		this.bondingType = bondingType;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public RankingCategory getRankingCategory() {
		return rankingCategory;
	}

	public DocumentType getRouteTime() {
		return docType;
	}

	public long getId(){
		return this.id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setRankingCategory(RankingCategory rankingCategory) {
		this.rankingCategory = rankingCategory;
	}

	public void setDocumentType(DocumentType docType) {
		this.docType = docType;
	}

	public BondingType getBondingType() {
		return bondingType;
	}

	public void setBondingType(BondingType bondingType) {
		this.bondingType = bondingType;
	}
	
	public double calculateBasicSalary() {
		double basicSalary = SALARY_POINT_VALUE * this.salaryPoints;
		if(this.bondingType.equals(BondingType.OCCASIONAL_HALFTIME))
			basicSalary /= 2;
		return basicSalary;
	}
	
	public double calculateNetWorthToPay(){
		double income = 0;
		double expenses = 0;
		double salary = this.calculateBasicSalary();
		switch(rankingCategory) {
		case AUXILIARY:
		case ASSISTANT:
			income += salary;
			if(this.workedMonths >= 12)
				income += salary;
			expenses += PENSION_CONTRIBUTION_PERCENTAGE * salary;
			expenses += HEALTH_CONTRIBUTION_PERCENTAGE * salary;
			break;
		case HEADLINE:
			if(bondingType.equals(BondingType.PLANT_EMPLOYEE)){
				income += salary;
				income += salary;
				income += salary/PREMIUM_SERVICES_DIVISOR;
				income += salary/PREMIUM_HOLIDAYS_DIVISOR;
				expenses += PENSION_CONTRIBUTION_PERCENTAGE * salary;
				expenses += HEALTH_CONTRIBUTION_PERCENTAGE * salary;
				expenses += SOLIDARITY_FOUND_PERCENTAGE * income;
				expenses += SOURCE_RETENTION * income;
			}
			break;
		case ASSOCIATED:
			if(bondingType.equals(BondingType.PLANT_EMPLOYEE)){
				income += salary;
				income += salary;
				income += salary/PREMIUM_SERVICES_DIVISOR;
				income += salary;
				income += salary/PREMIUM_HOLIDAYS_DIVISOR;
				expenses += PENSION_CONTRIBUTION_PERCENTAGE * salary;
				expenses += (HEALTH_CONTRIBUTION_PERCENTAGE * salary);
				expenses += (SOLIDARITY_FOUND_PERCENTAGE * income);
				expenses += (SOURCE_RETENTION * income);
			}
			break;
			default:
				income += salary;
				break;
		}
		return (income - expenses);
	}

	public Object[] toObjectArray(){
		return new Object[]{this.id, this.firstName, this.lastName, this.rankingCategory, this.docType, this.salaryPoints, this.workedMonths, this.calculateBasicSalary(), this.calculateNetWorthToPay()};
	}

}