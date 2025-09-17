/*Jackson Dahlke
 * CS1150 Mon-Wed
 * Sep. 3, 2025
 * Assignment #1
 * This program outputs a little bit about myself as well as some celsius to 
 * fahrenhiet calculations.
 */
public class DahlkeJacksonAssignment1 {
	public static void main(String[] args) {
		// Part 1:
		// Paragraph 1 about me
		System.out.println("     Hello there! My name is Jackson Dahlke and I am excited to learn \n"
				+ "Java! I have previous experience in coding and I am certified in Python \n"
				+ "by the Python Institute. I am very aware however that some of my skills \n"
				+ "will not translate well while I will have to learn new things about java. \n"
				+ "In my free time I love to play video games and hang out with friends. \n"
				+ "I have also created a few smaller games using the Python program. Enough \n"
				+ "about my experience, let me tell you what I am doing here in college. \n"
				+ "I am taking the Computer Engineering degree offered at UCCS.");
		// Paragraph 2 about me
		System.out.println( "    One of my favorite movies is the movie Interstellar. If you \n"
				+ "have not seen the movie the basic premise is space travel mixed with \n"
				+ "a lot of quantum mechanics and a great storyto go along with it. I \n"
				+ "won't spoil any of it as it is a really good movie but I want to \n"
				+ "talk about the core mechanic, time. In the movie, they talk about \n"
				+ "how time can strech and squeze in our four dimentions. But beings \n"
				+ "who are in the fifth dimention are outside of our four dimentions. \n"
				+ "Therefore they are not bound by time. I think this is a really cool \n"
				+ "concept that should be expanded upon!");
		// Part 2
		// Fahrenheit to Celsius Convertions
		//Variable Declarations
		double num0 = 0;
		double num10 = 10;
		double num20 = 20;
		double num30 = 30;
		double num40 = 40;
		double num50 = 50;
		double num60 = 60;
		double num70 = 70;
		double num80 = 80;
		double num90 = 90;
		double num100 = 100;
		//Printing the chart and math
		System.out.println("\nFahrenheit    Celsius \n"
				+ "--------------------- \n"
				+ num0 + "           " + ((num0-32.0)*5.0/9.0) + "\n"
				+ num10 + "          " + ((num10-32.0)*5.0/9.0) + "\n"
				+ num20 + "          " + ((num20-32.0)*5.0/9.0) + "\n"
				+ num30 + "          " + ((num30-32.0)*5.0/9.0) + "\n"
				+ num40 + "          " + ((num40-32.0)*5.0/9.0) + "\n"
				+ num50 + "          " + ((num50-32.0)*5.0/9.0) + "\n"
				+ num60 + "          " + ((num60-32.0)*5.0/9.0) + "\n"
				+ num70 + "          " + ((num70-32.0)*5.0/9.0) + "\n"
				+ num80 + "          " + ((num80-32.0)*5.0/9.0) + "\n"
				+ num90 + "          " + ((num90-32.0)*5.0/9.0) + "\n"
				+ num100 + "         " + ((num100-32.0)*5.0/9.0));
	}
}