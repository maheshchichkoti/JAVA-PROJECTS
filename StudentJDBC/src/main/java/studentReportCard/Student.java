package studentReportCard;

class Student {

	private int id;
	private String name;
	private int english;
	private int kannada;
	private int maths;
	private int chemistry;
	private int science;
	private int biology;
	private String result;
	private double percentage;

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

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getKannada() {
		return kannada;
	}

	public void setKannada(int kannada) {
		this.kannada = kannada;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public int getChemistry() {
		return chemistry;
	}

	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public int getBiology() {
		return biology;
	}

	public void setBiology(int biology) {
		this.biology = biology;
	}

	public String getResult() {
		if ((english >= 35) && (kannada >= 35) && (maths >= 35) && (chemistry >= 35) && (science >= 35)
				&& (biology >= 35)) {
			return "Pass";
		} else
			return "Fail";
	}

	public double getPercentage() {
		int s = kannada + maths + english + science + chemistry + biology;
		return (s * 100) / 600;

	}

	@Override
	public String toString() {
		return "Student Name = " + name + " \nId = " + id + "\nEnglish=" + english + ", Kannada=" + kannada + ", Maths="
				+ maths + ", Chemistry=" + chemistry + ", Science=" + science + ", Biology=" + biology
				+ "\nFinal Result --> " + getResult() + "\n Percentage=" + getPercentage() + "%";
	}

	public Student(int id, String name, int english, int kannada, int maths, int chemistry, int science, int biology) {
		super();
		this.id = id;
		this.name = name;
		this.english = english;
		this.kannada = kannada;
		this.maths = maths;
		this.chemistry = chemistry;
		this.science = science;
		this.biology = biology;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

}
