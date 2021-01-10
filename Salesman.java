
/**
 * @author Brian Grammer
 * CS 0401
 * Tuesdays & Thursdays at 1:00 P.M.
 */
import java.util.Scanner;
import java.util.Locale;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.text.NumberFormat;

public class Salesman {
	private static int[] pricesRegular = { 290, 60, 160, 1479, 2465 };
	private static int[] pricesDiscount = { 261, 50, 140, 1479, 1479 };
	private static int[] pricesMarkUp = { 319, 66, 176, 1627, 2712 };
	private static String[] productsOrder = { "Pygmy Puffs", "Individual Extendable Ears", "Pack of 3 Extendable Ears",
			"Regular Wands", "Autographed Wands" };
	private static ArrayList<String> questions = new ArrayList<String>();
	private static String answer = "";
	private static Scanner dialogue = new Scanner(System.in);
	private static StringBuilder receipt = new StringBuilder();
	private static Locale locale = new Locale("en", "US");
	private static NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
	private static boolean mainLoop = true;
	private static final String introDialogue = "Welcome to the shop! These are our products and prices! \n"
			+ "------------------------------------------------------- \n"
			+ "Pygmy Puffs 				    290  Knuts \n" + "Extendable Ears (each) 	    		    60   Knuts \n"
			+ "Extendable Ears (bag of three)  	    160  Knuts \n"
			+ "Trick Wands (regular) 			    1479 Knuts \n" + "Trick Wand (autographed) 		    2465 Knuts\n\n"
			+ "Would you like to buy anything? (Yes or No) \nFYI, Our establishment is case sensitive!\n";

	private static final String yesDialogue = "\nGreat! Do you want these prices or would you prefer to try your skill for a discount? \r\n"
			+ "You may elect to answer a challenge question -- if you answer correctly you will get discounted prices \r\n"
			+ "But if you answer incorrectly, you must pay a 10% penalty on your overall bill.\r\n" + "\n"
			+ "Say 'Yes' to take the quiz or 'No' to use the original prices \nAgain, Our establishment is case sensitive! If I can't understand you, I'll assume you don't want to take the quiz!\n";

	private static final String correctDialogue = "\nYou got the question right! Now you get a 10% discount on all of our prices!\nHere are our new prices!\n"

			+ "------------------------------------------------------------------------------\n"
			+ "Pygmy Puffs 				    261  Knuts \n" + "Extendable Ears (each) 	    		    50   Knuts \n"
			+ "Extendable Ears (bag of three)  	    140  Knuts \n"
			+ "Trick Wand (regular) 		    	    1479 Knuts  \nTrick Wand (autographed)		    1479 Knuts\n\n\n";

	private static final String incorrectDialogue = "\nYou got the question wrong :( Now there is a 10% markup on all the prices.\nHere are the new prices:\n"
			+ "-------------------------------------------------------------------------- \n"
			+ "Pygmy Puffs 				    319  Knuts \n" + "Extendable Ears (each) 	    		    66   Knuts \n"
			+ "Extendable Ears (bag of three)  	    176  Knuts \n"
			+ "Trick Wands (regular) 			    1627 Knuts \n"
			+ "Trick Wand (autographed) 		    2712 Knuts\n\n\n";
	private static final String menuDialogue = "What would you like to do?\n" + "	1) Update Pygmy Puffs Order\r\n"
			+ "	2) Update Extendable Ears Order\r\n" + "	3) Update Trick Wands Order\r\n"
			+ "	4) Show price list\r\n" + "	5) Check Out";

	public static void main(String[] args) {
		 while(mainLoop) {
		 //Welcoming the next customer. If yes, continue. If no, quits the program.
		 Scanner introscanner = new Scanner(System.in);
		 System.out.println("Welcome to Brian's Beloved Grocery Outlet & Co.\n" + "Can we help the next customer? ('Yes' or 'No')\n");
		 String response = introscanner.next();
		 if (response.equalsIgnoreCase("No"))
		 System.exit(0);
		 else if(response.equalsIgnoreCase("Yes")) {
		loadQuestion();
		do {
			System.out.println(introDialogue);
			answer = dialogue.next();
			// boolean method to decide whether code loops or not.
		} while (!loop(answer));
		switch (answer) {

		// If the person wants to buy something.
		case "Yes":
			System.out.println(yesDialogue);
			answer = dialogue.next();
			if (answer.equals("Yes")) {
				System.out.println(
						"\nYou have accepted the challenge! Type the number of the correct answer, such as '1','2', etc. \n");
				String question;
				// Chooses a random question for the ArrayList "questions"
				int r = (int) (Math.random() * questions.size());
				question = questions.get(r);
				System.out.println("\n" + question);
				answer = dialogue.next();
				// r is the number of the correct answer to the question
				// If it is right, there is a discount (discountedSalesman)
				// If it is wrong, there is a markup (markupedSalesman)
				if (r == 0) {
					if (answer.equals("1")) {
						System.out.println(correctDialogue);
						discountedSalesman();
						continue;
					} else
						System.out.println(incorrectDialogue);
					markupedSalesman();
				}
				if (r == 1) {
					if (answer.equals("3")) {
						System.out.println(correctDialogue);
						discountedSalesman();
						continue;

					} else {
						System.out.println(incorrectDialogue);
						markupedSalesman();
					}
				}
				if (r == 2) {
					if (answer.equals("2")) {
						System.out.println(correctDialogue);
						discountedSalesman();
						continue;

					} else {
						System.out.println(incorrectDialogue);
						markupedSalesman();
					}
				}
				if (r == 3) {
					if (answer.equals("4")) {
						System.out.println(correctDialogue);
						discountedSalesman();
						continue;

					} else {
						System.out.println(incorrectDialogue);
						markupedSalesman();
					}
				}
				if (r == 4) {
					if (answer.equals("1")) {
						System.out.println(correctDialogue);
						discountedSalesman();
						continue;

					} else {
						System.out.println(incorrectDialogue);
						markupedSalesman();
					}
				}
				if (r == 5) {
					if (answer.equals("2")) {
						System.out.println(correctDialogue);
						discountedSalesman();
						continue;

					} else {
						System.out.println(incorrectDialogue);
						markupedSalesman();
					}
				}
				// If the customer chooses not to take the quiz. regularSalesman is the method
				// for regular prices.
			} else {
				System.out.println("Okay we'll stick to the original prices!");
				regularSalesman();
			}
			break;

		// If the person does not want to buy anything.
		case "No":
			System.out.println("See Ya!");
			dialogue.close();
			System.exit(0);
			break;
		}
	}
	 }
	 }

	private static void loadQuestion() {
		// Loads Questions to the ArrayList "questions"
		questions.add("What is the circumference of the Sun? \n" + "1) 4,366,813 Kilometers \n" + "2) 600 Gigameters \n"
				+ "3) 1,879,900 miles \n" + "4) 6.02214076×10²³ micrometers\n");

		questions.add("What is the derivative of x²? \n" + "1) 3x² \n" + "2) 2x + C \n" + "3) 2x \n" + "4) 0 \n");

		questions.add("How many total frames is Sheik's up tilt in Super Smash Bros. Ultimate? \n" + "1) 17 frames \n"
				+ "2) 32 frames \n" + "3) 43 frames \n" + "4) 29 frames \n");

		questions.add("What is Overwatch's D.Va real name? \n" + "1) Kim Lip \n" + "2) Son Seungwan \n"
				+ "3) Kim Taeyeon \n" + "4) Hana Song \n");

		questions.add(
				"In Electromagnetic Physics, what is the sum of magnetic field vectors dotted into an area vector?\n"
						+ "1) Magnetic Flux \n" + "2) Electromotive Force \n" + "3) Potential Energy \n"
						+ "4) Capacitance \n");

		questions.add("What is the longest song from the band 'Rush'?\n" + "1) Xanadu \n" + "2) 2112 \n"
				+ "3) Clockwork Angels \n" + "4) Test for Echo \n");
	}

	private static void discountedSalesman() {
		// Three different scanners for different inputs... probably a little
		// complicated but I ran into problems with just one scanner so I made each
		// choice have its own.
		Scanner order = new Scanner(System.in);
		Scanner quantity = new Scanner(System.in);
		Scanner payment = new Scanner(System.in);
		// I organized the quantity and total price into arrays.
		int[] amount = { 0, 0, 0, 0, 0 };
		int[] receiptTotal = new int[5];
		int orderOption;
		boolean looper = true;
		// Loops the menu dialogue (choosing whether to update orders or go to bill)
		while (looper) {
			System.out.println(menuDialogue);
			orderOption = order.nextInt();
			if (orderOption <= 0)
				continue;
			switch (orderOption) {
			case 1:
				System.out.println("Here is your current order: " + amount[0] + " Pygmy Puffs have been ordered");
				System.out.println("\nHow many Pygmy Puffs would you like for 261 Knuts each?\n");
				amount[0] = quantity.nextInt();
				if (amount[0] < 0) {
					receiptTotal[0] = 0;
					amount[0] = 0;
					System.out.println("Negative number taken as 0\n");
					break;
				} else {
					receiptTotal[0] = amount[0] * pricesDiscount[0];
					break;
				}
			case 2:
				System.out.println("Here is your current order: " + amount[1] + " Extendable Ears have been ordered");
				System.out.println("\nHow many Extendable Ears would you like for:\r\n" + "	50 Knuts each\r\n"
						+ "	140 Knuts per bag of 3\r\n\n" + "(Please indicate only the total number you would like)\n");
				amount[1] = quantity.nextInt();
				if (amount[1] < 0) {
					receiptTotal[1] = 0;
					amount[1] = 0;
					System.out.println("Negative number taken as 0\n");
					break;
				} else {
					int extendEach, extendBundle;
					extendEach = amount[1] % 3;
					extendBundle = (amount[1] - extendEach) / 3;
					amount[1] = extendEach;
					amount[2] = extendBundle;
					receiptTotal[1] = amount[1] * pricesDiscount[1];
					receiptTotal[2] = amount[2] * pricesDiscount[2];
					break;
				}
			case 3:
				System.out.println("Here is your current order: " + amount[3] + " Regular Wands have been ordered\n"
						+ "			    " + amount[4] + " Autographed Wands have been ordered\n");
				System.out.println("\nHow many Regular Wands would you like for: 1479 Knuts each");
				amount[3] = quantity.nextInt();
				if (amount[3] < 0) {
					receiptTotal[3] = 0;
					amount[3] = 0;
					System.out.println("Negative number taken as 0\n");
					break;
				} else {
					receiptTotal[3] = amount[3] * pricesDiscount[3];
				}
				System.out.println("\nHow many Autographed Wands would you like for: 1479 Knuts each");
				amount[4] = quantity.nextInt();
				if (amount[4] < 0) {
					receiptTotal[4] = 0;
					amount[4] = 0;
					System.out.println("Negative number taken as 0\n");
				} else {
					receiptTotal[4] = amount[4] * pricesDiscount[4];
					break;
				}
			case 4:
				System.out.println("Here is our price list: \r\n" + "	Pygmy Puffs (each)			261 Knuts\r\n"
						+ "	Extendable Ears (each)			50 Knuts\r\n"
						+ "	Extendable Ears (bag of three)		140 Knuts\r\n"
						+ "	Trick Wand (regular)			1479 Knuts\r\n"
						+ "	Trick Wand (autographed)		1479 Knuts\n");
				break;
			case 5:
				boolean loopityloop = true;
				System.out.println("Here is your subtotal: \n");
				int sum = 0;
				for (int i = 0; i < 5; i++) {
					if (amount[i] != 0) {
						receipt.append(receiptTotal[i] + " ");
						System.out.println(amount[i] + " " + productsOrder[i] + " at " + pricesDiscount[i] + " each: "
								+ formatter.format(receiptTotal[i]) + "\n");
						sum += receiptTotal[i];

					}
				}
				System.out.println("-------------------------------------------");
				System.out.println("Total:				" + formatter.format(sum) + "\n");
				System.out.println("Please enter a payment amount in the following format\n"
						+ "<amount><space><currency>\n" + "Where <amount> = an integer\n"
						+ "Where <space> = a blank space\n" + "Where <currency> = {Knuts, Sickles, Galleons}\n"
						+ "You may enter as many times as you like. Each entry will be added to your total until sufficient funds have been obtained.\r\n\n"
						+ "	Recall the currency exchange:\r\n" + "		29 Knuts = 1 Sickle\r\n"
						+ "		493 Knuts = 17 Sickles = 1 Galleon");
				int cashMoneyint = 0;
				int debt = 0;
				int totalpaid = 0;
				while (loopityloop) {
					System.out.println("Payment> ");
					cashMoneyint = payment.nextInt();
					String cashMoney = payment.next();
					if (cashMoney.equalsIgnoreCase("Knuts")) {
						int knuts = 0;
						knuts = cashMoneyint;
						totalpaid += knuts;
						debt = sum - totalpaid;
						// Finds exact change with least amount of coins.
						if (debt < 0) {
							int change = Math.abs(sum - totalpaid);
							int galleonsChange = (Math.round((int) change / 493));
							change %= 493;
							int sicklesChange = (Math.round((int) change / 29));
							change %= 29;
							int knutsChange = (Math.round((int) change / 1));
							

							System.out.println(
									"Thank you for shopping at BBG & Co.\n" + "Your change is: \n" + galleonsChange
											+ " Galleons\n" + sicklesChange + " Sickles\n" + knutsChange + " Knuts\n");
							looper = false;
							break;

						} else
						// No change given if amount paid is exact.
						if (debt == 0) {
							System.out.println("Thank you for shopping at BBG & Co.\n");
							looper = false;
							break;
						} else {
							System.out.println(
									"You added " + formatter.format(knuts) + " to your total\n" + "You have paid "
											+ formatter.format(totalpaid) + " out of " + formatter.format(sum)
											+ " Knuts\n" + "You still owe " + formatter.format(debt) + " knuts\n");
							continue;
						}
					} else if (cashMoney.equalsIgnoreCase("Sickles")) {
						int sickles = 0;
						sickles = cashMoneyint * 29;
						totalpaid += sickles;
						debt = sum - totalpaid;
						// Finds exact change with least amount of coins.
						if (debt < 0) {
							int change = Math.abs(sum - totalpaid);
							int galleonsChange = (Math.round((int) change / 493));
							change %= 493;
							int sicklesChange = (Math.round((int) change / 29));
							change %= 29;
							int knutsChange = (Math.round((int) change / 1));
							System.out.println(
									"Thank you for shopping at BBG & Co.\n" + "Your change is: \n" + galleonsChange
											+ " Galleons\n" + sicklesChange + " Sickles\n" + knutsChange + " Knuts\n");
							looper = false;
							break;
						}
						// No change given if amount paid is exact.
						else if (debt == 0) {
							System.out.println("Thank you for shopping at BBG & Co.\n");
							looper = false;
							break;
						} else {
							System.out.println(
									"You added " + formatter.format(sickles) + " to your total\n" + "You have paid "
											+ formatter.format(totalpaid) + " out of " + formatter.format(sum)
											+ " Knuts\n" + "You still owe " + formatter.format(debt) + " knuts\n");
							continue;
						}

					} else if (cashMoney.equalsIgnoreCase("Galleons")) {
						int galleons = 0;
						galleons = cashMoneyint * 493;
						totalpaid += galleons;
						debt = sum - totalpaid;
						// Finds exact change with least amount of coins.
						if (debt < 0) {
							int change = Math.abs(sum - totalpaid);
							int galleonsChange = (Math.round((int) change / 493));
							change %= 493;
							int sicklesChange = (Math.round((int) change / 29));
							change %= 29;
							int knutsChange = (Math.round((int) change / 1));
							System.out.println(
									"Thank you for shopping at BBG & Co.\n" + "Your change is: \n" + galleonsChange
											+ " Galleons\n" + sicklesChange + " Sickles\n" + knutsChange + " Knuts\n");
							looper = false;
							break;
						}
						// No change given if amount paid is exact.
						else if (debt == 0) {
							System.out.println("Thank you for shopping at BBG & Co.\n");
							looper = false;
							break;
						} else {
							System.out.println(
									"You added " + formatter.format(galleons) + " to your total\n" + "You have paid "
											+ formatter.format(totalpaid) + " out of " + formatter.format(sum)
											+ " Knuts\n" + "You still owe " + formatter.format(debt) + " knuts\n");
							continue;
						}

					} else {
						looper = false;
						continue;
					}
				}
			}
		}

	}

	private static void markupedSalesman() {
		Scanner order = new Scanner(System.in);
		Scanner quantity = new Scanner(System.in);
		Scanner payment = new Scanner(System.in);
		int[] amount = { 0, 0, 0, 0, 0 };
		int[] receiptTotal = new int[5];
		int orderOption;
		boolean looper = true;
		while (looper) {
			System.out.println(menuDialogue);
			orderOption = order.nextInt();
			if (orderOption <= 0)
				continue;
			switch (orderOption) {
			case 1:
				System.out.println("Here is your current order: " + amount[0] + " Pygmy Puffs have been ordered");
				System.out.println("\nHow many Pygmy Puffs would you like for 319 Knuts each?\n");
				amount[0] = quantity.nextInt();
				if (amount[0] < 0) {
					receiptTotal[0] = 0;
					amount[0] = 0;
					System.out.println("Negative number taken as 0\n");
					break;
				} else {
					receiptTotal[0] = amount[0] * pricesMarkUp[0];
					break;
				}
			case 2:
				System.out.println("Here is your current order: " + amount[1] + " Extendable Ears have been ordered");
				System.out.println("\nHow many Extendable Ears would you like for:\r\n" + "	66 Knuts each\r\n"
						+ "	176 Knuts per bag of 3\r\n\n" + "(Please indicate only the total number you would like)\n");
				amount[1] = quantity.nextInt();
				if (amount[1] < 0) {
					receiptTotal[1] = 0;
					amount[1] = 0;
					System.out.println("Negative number taken as 0\n");
					break;
				} else {
					int extendEach, extendBundle;
					extendEach = amount[1] % 3;
					extendBundle = (amount[1] - extendEach) / 3;
					amount[1] = extendEach;
					amount[2] = extendBundle;
					receiptTotal[1] = amount[1] * pricesMarkUp[1];
					receiptTotal[2] = amount[2] * pricesMarkUp[2];
					break;
				}
			case 3:
				System.out.println("Here is your current order: " + amount[3] + " Regular Wands have been ordered\n"
						+ "			    " + amount[4] + " Autographed Wands have been ordered\n");
				System.out.println("\nHow many Regular Wands would you like for: 1627 Knuts each");
				amount[3] = quantity.nextInt();
				if (amount[3] < 0) {
					receiptTotal[3] = 0;
					amount[3] = 0;
					System.out.println("Negative number taken as 0\n");
				} else {
					receiptTotal[3] = amount[3] * pricesMarkUp[3];
				}
				System.out.println("\nHow many Autographed Wands would you like for: 2712 Knuts each");
				amount[4] = quantity.nextInt();
				if (amount[4] < 0) {
					receiptTotal[4] = 0;
					amount[4] = 0;
					System.out.println("Negative number taken as 0\n");
					break;
				} else {
					receiptTotal[4] = amount[4] * pricesMarkUp[4];
					break;
				}

			case 4:
				System.out.println("Here is our price list: \r\n" + "	Pygmy Puffs (each)			319 Knuts\r\n"
						+ "	Extendable Ears (each)			66 Knuts\r\n"
						+ "	Extendable Ears (bag of three)		176 Knuts\r\n"
						+ "	Trick Wand (regular)			1627 Knuts\r\n"
						+ "	Trick Wand (autographed)		2712 Knuts\n");
				break;
			case 5:
				boolean loopityloop = true;
				System.out.println("Here is your subtotal (10% Markup): \n");
				int sum = 0;
				for (int i = 0; i < 5; i++) {
					if (amount[i] != 0) {
						receipt.append(receiptTotal[i] + " ");
						System.out.println(amount[i] + " " + productsOrder[i] + " at " + pricesMarkUp[i] + " each: "
								+ formatter.format(receiptTotal[i]));
						sum += receiptTotal[i];

					}
				}
				System.out.println("-------------------------------------------");
				System.out.println("				" + formatter.format(sum) + "\n");
				System.out.println("Please enter a payment amount in the following format\n"
						+ "<amount><space><currency>\n" + "Where <amount> = an integer\n"
						+ "Where <space> = a blank space\n" + "Where <currency> = {Knuts, Sickles, Galleons}\n"
						+ "You may enter as many times as you like.  Each entry will be	added to your total until sufficient funds have been obtained.\r\n\n"
						+ "	Recall the currency exchange:\r\n" + "		29 Knuts = 1 Sickle\r\n"
						+ "		493 Knuts = 17 Sickles = 1 Galleon");
				int cashMoneyint = 0;
				int debt = 0;
				int totalpaid = 0;
				while (loopityloop) {
					System.out.println("Payment> ");
					cashMoneyint = payment.nextInt();
					String cashMoney = payment.next();
					if (cashMoney.equalsIgnoreCase("Knuts")) {
						int knuts = 0;
						knuts = cashMoneyint;
						totalpaid += knuts;
						debt = sum - totalpaid;
						// Finds exact change with least amount of coins.
						if (debt < 0) {
							int change = Math.abs(sum - totalpaid);
							int galleonsChange = (Math.round((int) change / 493));
							change %= 493;
							int sicklesChange = (Math.round((int) change / 29));
							change %= 29;
							int knutsChange = (Math.round((int) change / 1));
							System.out.println(
									"Thank you for shopping at BBG & Co.\n" + "Your change is: \n" + galleonsChange
											+ " Galleons\n" + sicklesChange + " Sickles\n" + knutsChange + " Knuts\n");
							looper = false;
							break;
						}
						// No change given if amount paid is exact.
						else if (debt == 0) {
							System.out.println("Thank you for shopping at BBG & Co.\n");
							looper = false;
							break;
						} else {
							System.out.println(
									"You added " + formatter.format(knuts) + " to your total\n" + "You have paid "
											+ formatter.format(totalpaid) + " out of " + formatter.format(sum)
											+ " Knuts\n" + "You still owe " + formatter.format(debt) + " knuts\n");
							continue;
						}
					} else if (cashMoney.equalsIgnoreCase("Sickles")) {
						int sickles = 0;
						sickles = cashMoneyint * 29;
						totalpaid += sickles;
						debt = sum - totalpaid;
						// Finds exact change with least amount of coins.
						if (debt < 0) {
							int change = Math.abs(sum - totalpaid);
							int galleonsChange = (Math.round((int) change / 493));
							change %= 493;
							int sicklesChange = (Math.round((int) change / 29));
							change %= 29;
							int knutsChange = (Math.round((int) change / 1));
							System.out.println(
									"Thank you for shopping at BBG & Co.\n" + "Your change is: \n" + galleonsChange
											+ " Galleons\n" + sicklesChange + " Sickles\n" + knutsChange + " Knuts\n");
							looper = false;
							break;
						} else
						// No change given if amount paid is exact.
						if (debt == 0) {
							System.out.println("Thank you for shopping at BBG & Co.\n");
							looper = false;
							break;
						} else {
							System.out.println(
									"You added " + formatter.format(sickles) + " to your total\n" + "You have paid "
											+ formatter.format(totalpaid) + " out of " + formatter.format(sum)
											+ " Knuts\n" + "You still owe " + formatter.format(debt) + " knuts\n");
							continue;
						}

					} else if (cashMoney.equalsIgnoreCase("Galleons")) {
						int galleons = 0;
						galleons = cashMoneyint * 493;
						totalpaid += galleons;
						debt = sum - totalpaid;
						// Finds exact change with least amount of coins.
						if (debt < 0) {
							int change = Math.abs(sum - totalpaid);
							int galleonsChange = (Math.round((int) change / 493));
							change %= 493;
							int sicklesChange = (Math.round((int) change / 29));
							change %= 29;
							int knutsChange = (Math.round((int) change / 1));
							System.out.println(
									"Thank you for shopping at BBG & Co.\n" + "Your change is: \n" + galleonsChange
											+ " Galleons\n" + sicklesChange + " Sickles\n" + knutsChange + " Knuts\n");
							looper = false;
							break;
						} else
						// No change given if amount paid is exact.
						if (debt == 0) {
							System.out.println("Thank you for shopping at BBG & Co.\n");
							looper = false;
							break;
						} else {
							System.out.println(
									"You added " + formatter.format(galleons) + " to your total\n" + "You have paid "
											+ formatter.format(totalpaid) + " out of " + formatter.format(sum)
											+ " Knuts\n" + "You still owe " + formatter.format(debt) + " knuts\n");
							continue;
						}

					} else {
						looper = false;
						continue;
					}

				}
			}
		}
	}

	private static void regularSalesman() {
		Scanner order = new Scanner(System.in);
		Scanner quantity = new Scanner(System.in);
		Scanner payment = new Scanner(System.in);
		int[] amount = { 0, 0, 0, 0, 0 };
		int[] receiptTotal = new int[5];
		int orderOption;
		boolean looper = true;
		while (looper) {
			System.out.println(menuDialogue);
			orderOption = order.nextInt();
			if (orderOption <= 0)
				continue;
			switch (orderOption) {
			case 1:
				System.out.println("Here is your current order: " + amount[0] + " Pygmy Puffs have been ordered");
				System.out.println("\nHow many Pygmy Puffs would you like for 290 Knuts each?\n");
				amount[0] = quantity.nextInt();
				if (amount[0] < 0) {
					receiptTotal[0] = 0;
					amount[0] = 0;
					System.out.println("Negative number taken as 0\n");
					break;
				} else {
					receiptTotal[0] = amount[0] * pricesRegular[0];
					break;
				}
			case 2:
				System.out.println("Here is your current order: " + amount[1] + " Extendable Ears have been ordered");
				System.out.println("\nHow many Extendable Ears would you like for:\r\n" + "	60 Knuts each\r\n"
						+ "	160 Knuts per bag of 3\r\n\n" + "(Please indicate only the total number you would like)\n");
				amount[1] = quantity.nextInt();
				if (amount[1] < 0) {
					receiptTotal[1] = 0;
					amount[1] = 0;
					System.out.println("Negative number taken as 0\n");
					break;
				} else {
					int extendEach, extendBundle;
					extendEach = amount[1] % 3;
					extendBundle = (amount[1] - extendEach) / 3;
					amount[1] = extendEach;
					amount[2] = extendBundle;
					receiptTotal[1] = amount[1] * pricesRegular[1];
					receiptTotal[2] = amount[2] * pricesRegular[2];
					break;
				}
			case 3:
				System.out.println("Here is your current order: " + amount[3] + " Regular Wands have been ordered\n"
						+ "			    " + amount[4] + " Autographed Wands have been ordered\n");
				System.out.println("\nHow many Regular Wands would you like for: 1479 Knuts each");
				amount[3] = quantity.nextInt();
				if (amount[3] < 0) {
					receiptTotal[3] = 0;
					amount[3] = 0;
					System.out.println("Negative number taken as 0\n");
				} else {
					receiptTotal[3] = amount[3] * pricesRegular[3];
				}
				System.out.println("\nHow many Autographed Wands would you like for: 2465 Knuts each");
				amount[4] = quantity.nextInt();
				if (amount[4] < 0) {
					receiptTotal[4] = 0;
					amount[4] = 0;
					System.out.println("Negative number taken as 0\n");
					break;
				} else {
					receiptTotal[4] = amount[4] * pricesRegular[4];
					break;
				}
			case 4:
				System.out.println("Here is our price list: \r\n" + "	Pygmy Puffs (each)			290 Knuts\r\n"
						+ "	Extendable Ears (each)			60 Knuts\r\n"
						+ "	Extendable Ears (bag of three)		160 Knuts\r\n"
						+ "	Trick Wand (regular)			1479 Knuts\r\n"
						+ "	Trick Wand (autographed)		2465 Knuts\n");
				break;
			case 5:
				boolean loopityloop = true;
				System.out.println("Here is your subtotal: \n");
				int sum = 0;
				for (int i = 0; i < 5; i++) {
					if (amount[i] != 0) {
						receipt.append(receiptTotal[i] + " ");
						System.out.println(amount[i] + " " + productsOrder[i] + " at " + pricesRegular[i] + " each: "
								+ formatter.format(receiptTotal[i]));
						sum += receiptTotal[i];

					}
				}
				System.out.println("-------------------------------------------");
				System.out.println("				" + formatter.format(sum) + "\n");
				System.out.println("Please enter a payment amount in the following format\n"
						+ "<amount><space><currency>\n" + "Where <amount> = an integer\n"
						+ "Where <space> = a blank space\n" + "Where <currency> = {Knuts, Sickles, Galleons}\n"
						+ "You may enter as many times as you like.  Each entry will be added to your total until sufficient funds have been obtained.\r\n\n"
						+ "	Recall the currency exchange:\r\n" + "		29 Knuts = 1 Sickle\r\n"
						+ "		493 Knuts = 17 Sickles = 1 Galleon");
				int cashMoneyint = 0;
				int debt = 0;
				int totalpaid = 0;
				while (loopityloop) {
					System.out.println("Payment> ");
					cashMoneyint = payment.nextInt();
					String cashMoney = payment.next();
					if (cashMoney.equalsIgnoreCase("Knuts")) {
						int knuts = 0;
						knuts = cashMoneyint;
						totalpaid += knuts;
						debt = sum - totalpaid;
						// Finds exact change with least amount of coins.
						if (debt < 0) {
							int change = Math.abs(sum - totalpaid);
							int galleonsChange = (Math.round((int) change / 493));
							change %= 493;
							int sicklesChange = (Math.round((int) change / 29));
							change %= 29;
							int knutsChange = (Math.round((int) change / 1));
							System.out.println(
									"Thank you for shopping at BBG & Co.\n" + "Your change is: \n" + galleonsChange
											+ " Galleons\n" + sicklesChange + " Sickles\n" + knutsChange + " Knuts\n");
							looper = false;
							break;
						} else
						// No change given if amount paid is exact.
						if (debt == 0) {
							System.out.println("Thank you for shopping at BBG & Co.\n");
							looper = false;
							break;
						} else {
							System.out.println(
									"You added " + formatter.format(knuts) + " to your total\n" + "You have paid "
											+ formatter.format(totalpaid) + " out of " + formatter.format(sum)
											+ " Knuts\n" + "You still owe " + formatter.format(debt) + " knuts\n");
							continue;
						}
					} else if (cashMoney.equalsIgnoreCase("Sickles")) {
						int sickles = 0;
						sickles = cashMoneyint * 29;
						totalpaid += sickles;
						debt = sum - totalpaid;
						// Finds exact change with least amount of coins.
						if (debt < 0) {
							int change = Math.abs(sum - totalpaid);
							int galleonsChange = (Math.round((int) change / 493));
							change %= 493;
							int sicklesChange = (Math.round((int) change / 29));
							change %= 29;
							int knutsChange = (Math.round((int) change / 1));
							System.out.println(
									"Thank you for shopping at BBG & Co.\n" + "Your change is: \n" + galleonsChange
											+ " Galleons\n" + sicklesChange + " Sickles\n" + knutsChange + " Knuts\n");
							looper = false;
							break;
						} else
						// No change given if amount paid is exact.
						if (debt == 0) {
							System.out.println("Thank you for shopping at BBG & Co.\n");
							looper = false;
							break;
						} else {
							System.out.println(
									"You added " + formatter.format(sickles) + " to your total\n" + "You have paid "
											+ formatter.format(totalpaid) + " out of " + formatter.format(sum)
											+ " Knuts\n" + "You still owe " + formatter.format(debt) + " knuts\n");
							continue;
						}

					} else if (cashMoney.equalsIgnoreCase("Galleons")) {
						int galleons = 0;
						galleons = cashMoneyint * 493;
						totalpaid += galleons;
						debt = sum - totalpaid;
						// Finds exact change with least amount of coins.
						if (debt < 0) {
							int change = Math.abs(sum - totalpaid);
							int galleonsChange = (Math.round((int) change / 493));
							change %= 493;
							int sicklesChange = (Math.round((int) change / 29));
							change %= 29;
							int knutsChange = (Math.round((int) change / 1));
							System.out.println(
									"Thank you for shopping at BBG & Co.\n" + "Your change is: \n" + galleonsChange
											+ " Galleons\n" + sicklesChange + " Sickles\n" + knutsChange + " Knuts\n");
							looper = false;
							break;
						} else
						// No change given if amount paid is exact.
						if (debt == 0) {
							System.out.println("Thank you for shopping at BBG & Co.\n");
							looper = false;
							break;
						} else {
							System.out.println(
									"You added " + formatter.format(galleons) + " to your total\n" + "You have paid "
											+ formatter.format(totalpaid) + " out of " + formatter.format(sum)
											+ " Knuts\n" + "You still owe " + formatter.format(debt) + " knuts\n");
							continue;
						}

					} else {
						looper = false;
						continue;
					}

				}

			}
		}

	}

	private static boolean loop(String ans) {
		if ((ans.equals("Yes") || ans.equals("No"))) {
			return true;
		} else {
			System.out.println("That is not a valid answer, please respond in English.\n");
			return false;
		}
	}
}
