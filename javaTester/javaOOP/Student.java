package javaOOP;

public class Student {
	private int studentCode;
	private String studentName;
	private float theoryScore;
	private float practiceScore;

	public Student(int studentCode, String studentName, float theoryScore, float practiceScore) {
		super();
		this.studentCode = studentCode;
		this.studentName = studentName;
		this.theoryScore = theoryScore;
		this.practiceScore = practiceScore;
	}

	private int getStudentCode() {
		return studentCode;
	}

	private String getStudentName() {
		return studentName;
	}

	private float getMediumScore() {
		return (this.theoryScore + this.practiceScore * 2) / 3;
	}

	private void showStudentInfo() {
		System.out.println("**************************");
		System.out.println("Student ID= " + getStudentCode());
		System.out.println("Student Name= " + getStudentName());
		System.out.println("Student Average Point= " + getMediumScore());
	}

	public static void main(String[] args) {
		Student sv1 = new Student(1209, "Dao Thi Hanh", 7.5f, 8f);
		Student sv2 = new Student(1210, "Do thi Chanh", 9f, 9.5f);
		Student sv3 = new Student(1211, "Dao Thi Huyen", 6f, 8.5f);
		sv1.showStudentInfo();
		sv2.showStudentInfo();
		sv3.showStudentInfo();

	}

}
