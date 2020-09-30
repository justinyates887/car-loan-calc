
public class CarLoan {

/* This code is to help calculate a monthly car loan. This calculator operates on a primitive formula, 
not the actual APR formula. New methods with a switch can be added to add variability to interests rates
depending on the credit score of the applicant, as well as Scanner elements to make it interative. This 
code is for practice and not meant to function in a real world setting. */

  int carLoan;
  int loanLength;
  int interestRate;
  int downPayment;

  public CarLoan(int carLoan, int loanLength, int interestRate, int downPayment){
  }

	public static void main(String[] args) {
    CarLoan kia = new CarLoan(10000, 3, 5, 2000);

   kia.getLoan(10000);
   kia.getLength(3);
   kia.getRate(5);
   kia.getDown(2000);

   kia.validLoanCheck(10000, 5);
   kia.validDownPayment(10000, 2000);

    if(kia.validLoanCheck(10000, 5) && kia.validDownPayment(10000, 2000) == true){
      kia.calculateMonthlyPayment(10000, 3, 5, 2000);
    }
    else{
      System.out.println("The loan had been denied");
    }

	}

  public boolean validLoanCheck(int loan, int interest){
    carLoan = loan;
    interestRate = interest;

    if (carLoan > 0 && interestRate >= 0){
      return true;
    }
    else{
      System.out.println("You cannot take out a loan of $0.00!");
      return false;
    }
  }

  public boolean validDownPayment(int loan, int down){
    downPayment = down;
    carLoan = loan;

    if (down >= loan){
      System.out.println("Your down payment can't exceed vehicle price!");
      return false;
    }
    else{
      return true;
    }
  }

  public double calculateMonthlyPayment(int loan, int length, int rate, int down){
    carLoan = loan;
    loanLength = length;
    interestRate = rate;
    downPayment = down;

    double lengthInMonths = length * 12;
    double remainingBalance = loan - down;
    double principlePaymentPerMonth = remainingBalance / lengthInMonths;
    double monthlyInterest = principlePaymentPerMonth * rate / 100;
    double monthlyPayment = principlePaymentPerMonth + monthlyInterest;

    System.out.println("Your monthly payment is $" + monthlyPayment);

    return monthlyPayment;
  }

  public int getLoan(int loan){
    carLoan = loan;
    System.out.println("Your car loan is $" + loan);
    return loan;
  }

  public int getLength(int length){
    loanLength = length;
    System.out.println("Your requested loan length is " + length + " years.");
    return length;
  }

  public int getRate(int rate){
    interestRate = rate;
    System.out.println("You have been approved for a rate of " + rate + "%");
    return rate;
  }

  public int getDown(int down){
    downPayment = down;
    System.out.println("Your down payment is $" + down);
    return down;
  }
}
