package sajidHackathon;

public class Main1 {

	public static void main(String[] args) {
		int noOfDesiredCourse = 3; // front end exception handling needed
		int totalCredits = 60; // front end exception handling needed
		double currentCGPA = 1.80; // front end exception handling needed
		double targetCGPA = 2.10; // front end exception handling needed

		String[][] lowestGrades = new String[noOfDesiredCourse][2];
		lowestGrades[0][0] = "cse115"; // from database
		lowestGrades[0][1] = "C"; // from database
		lowestGrades[1][0] = "mat116"; // from database
		lowestGrades[1][1] = "D+"; // from database
		lowestGrades[2][0] = "phy108"; // from database
		lowestGrades[2][1] = "d"; // from database

		String[][] requiredGrade = new String[noOfDesiredCourse][2];

		double totalcurrentCGPA = totalCredits * currentCGPA;
		double totaltargetCGPA = totalCredits * targetCGPA;

		if (totaltargetCGPA > totalcurrentCGPA) {
			double pointRequired = totaltargetCGPA - totalcurrentCGPA;

			System.out.println(pointRequired);

			double pointBoostRequired = pointRequired / noOfDesiredCourse;
			double pointBoostRequiredPerGrade = pointBoostRequired / 3;

			System.out.println(pointBoostRequiredPerGrade); // test

			for (int i = 0; i < noOfDesiredCourse; i++) {

				double requiredPoint = gradeToPoint(lowestGrades[i][1]) + pointBoostRequiredPerGrade;

				if (requiredPoint <= 4.0) {
					requiredGrade[i][0] = lowestGrades[i][0];
					requiredGrade[i][1] = pointToGrade(requiredPoint);

					System.out.print(requiredGrade[i][0] + "\t"); // front end output
					System.out.println(requiredGrade[i][1]); // front end output
				} else {
					System.out.println("you must take more course to meet target cgpa"); // front end output
					break;
				}

			}

		} else
			System.out.println("your current cgpa meets targetted cpga"); // front end output
		String possibleGrade = "b-";
		int index1 = 0, index2 = 1; // index1 will come from user

		//String[][] newRequiredGrade = new String[noOfDesiredCourse][2];
		//newRequiredGrade = 
		changeSuggestedGrade(requiredGrade, possibleGrade, index1, index2);
//		
//		for (int i = 0; i < noOfDesiredCourse; i++) {
//			System.out.print(newRequiredGrade[i][0] + "\t");
//			System.out.println(newRequiredGrade[i][1]);
//			
//		}
	}

	static double gradeToPoint(String grade) {
		double point = 0.0;
		if (grade == "a" || grade == "A") {
			return point = 4.0;
		}

		else if (grade == "a-" || grade == "A-") {
			return point = 3.7;
		} else if (grade == "b+" || grade == "B+") {
			return point = 3.3;
		} else if (grade == "b" || grade == "B") {
			return point = 3.0;
		} else if (grade == "b-" || grade == "B-") {
			return point = 2.7;
		} else if (grade == "c+" || grade == "C+") {
			return point = 2.3;
		} else if (grade == "c" || grade == "C") {
			return point = 2.0;
		} else if (grade == "c-" || grade == "C-") {
			return point = 1.7;
		} else if (grade == "d+" || grade == "D+") {
			return point = 1.30;
		} else if (grade == "d" || grade == "D") {
			return point = 1.0;
		} else {
			return point;
		}

	}

	static String pointToGrade(double point) {
		String grade = "F";
		if (point == 4.0) {
			return grade = "A";
		} else if (point >= 3.7 && point <= 4.0) {
			return grade = "A-";
		} else if (point >= 3.3 && point <= 3.7) {
			return grade = "B+";
		} else if (point >= 3.0 && point <= 3.3) {
			return grade = "B";
		} else if (point >= 2.7 && point <= 3.0) {
			return grade = "B-";
		} else if (point >= 2.3 && point <= 2.7) {
			return grade = "C+";
		} else if (point >= 2.0 && point <= 2.3) {
			return grade = "C";
		} else if (point >= 1.7 && point <= 2.0) {
			return grade = "C-";
		} else if (point >= 1.3 && point <= 1.7) {
			return grade = "D+";
		} else if (point >= 1.0 && point <= 1.3) {
			return grade = "D";
		} else
			return grade;
	}

	static void changeSuggestedGrade(String suggestedGrades[][], String possibleGrade, int i, int j) {
		// String[][] newSuggestedGrades = new
		// String[suggestedGrades[0].length][suggestedGrades[1].length];

		double[] suggestedPoint = new double[suggestedGrades.length];
		for (int k = 0; k < suggestedGrades.length; k++) {
			// suggestedPoint[k][0] = suggestedGrades[k][0];
			suggestedPoint[k] = gradeToPoint(suggestedGrades[k][1]);
		}
		double possiblePoint = gradeToPoint(possibleGrade);
		//System.out.println(possiblePoint);
		double balancePoint = suggestedPoint[i] - possiblePoint;
		//System.out.println(balancePoint);

		balancePoint = balancePoint/(suggestedGrades.length - 1);
		//System.out.println(balancePoint);

		for (int k = 0; k < suggestedGrades.length; k++) {
			if (i != k) {
				
				if (suggestedPoint[k] + balancePoint <= 4) {
					suggestedPoint[k] = suggestedPoint[k] + balancePoint;
					suggestedGrades[k][1] = pointToGrade(suggestedPoint[k]);
				} else {
					System.out.println("add more courses"); // front end output
					return;
				}
			}
			else {
				suggestedPoint[k] = possiblePoint;
				suggestedGrades[k][1] = pointToGrade(possiblePoint);
			}
				
		}
		
		for (int k = 0; k < suggestedGrades.length; k++) {
			System.out.print(suggestedGrades[k][0]+ "\t");
			System.out.println(suggestedGrades[k][1]);
		}
		return;
	}

}
