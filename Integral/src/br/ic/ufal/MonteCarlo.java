package br.ic.ufal;

//Program to approximate the double integral of f(x,y)=8x+6y
//over the rectangle [0,1]x[0,2].
public class MonteCarlo {
	
public static void main(String[] args) {
 //Get the number N of random points as a command-line parameter
	int N = 1000;//Integer.parseInt(args[0]);
	double x = 0; //x-coordinate of a random point
	double y = 0; //y-coordinate of a random point
	double f = 0.0; //Value of f at a random point
 double mf = 0.0; //Mean of the values of f
 double mf2 = 0.0; //Mean of the values of f^2
 for (int i=0;i<N;i++) { //Get the random coordinates
    x = Math.random(); //x is between 0 and 1
    y = 2 * Math.random(); //y is between 0 and 2
    f = 8*x + 6*y; //Value of the function
    mf = mf + f; //Add to the sum of the f values
    mf2 = mf2 + f*f; //Add to the sum of the f^2 values
 }
 mf = mf/N; //Compute the mean of the f values
 mf2 = mf2/N; //Compute the mean of the f^2 values
 System.out.println("N = " + N + ": integral = " + vol()*mf + " +/- "
  + vol()*Math.sqrt((mf2 - Math.pow(mf,2))/N)); //Print the result
 
 System.out.println("≈ "+ (vol()*mf + (vol()*Math.sqrt((mf2 - Math.pow(mf,2))/N))));
}
//The volume of the rectangle [0,1]x[0,2]
public static double vol() {
 return 1*2;
}
}
