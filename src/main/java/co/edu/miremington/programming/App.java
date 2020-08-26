package co.edu.miremington.programming;

import org.apache.log4j.Logger;

import java.util.Scanner;


/**
 * @author devnix
 * @version 1.0.0
 * @apiNote App calculator!
 */
public class App {
    static final Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {

        logger.info("welcome!");
        try {
            logger.info("---------------------------------");
            logger.info("###    Addition Operation  ###");
            Addition addition = new Addition();
            addition.loadOne();
            addition.loadTwo();
            addition.operate();
            logger.info("---------------------------------");
            addition.showResult();
            logger.info("---------------------------------");

            logger.info("###    Subtraction Operation  ###");
            Subtraction subtraction = new Subtraction();
            subtraction.loadOne();
            subtraction.loadTwo();
            subtraction.operate();
            logger.info("---------------------------------");
            subtraction.showResult();
            logger.info("---------------------------------");

            logger.info("###    Multiplication Operation  ###");
            Multiplication multiplication = new Multiplication();
            multiplication.loadOne();
            multiplication.loadTwo();
            multiplication.operate();
            logger.info("---------------------------------");
            multiplication.showResult();
            logger.info("---------------------------------");

            logger.info("###    Division Operation  ###");
            Division division = new Division();
            division.loadOne();
            division.loadTwo();
            division.operate();
            logger.info("---------------------------------");
            division.showResult();
            logger.info("---------------------------------");

            logger.info("###    Boost Operation  ###");
            Boost boost = new Boost();
            boost.loadOne();
            boost.loadTwo();
            boost.operate();
            logger.info("---------------------------------");
            boost.showResult();
            logger.info("---------------------------------");

            logger.info("###    Greatest Common Divisor Operation  ###");
            GreatestCommonDivisor gcd = new GreatestCommonDivisor();
            gcd.loadOne();
            gcd.loadTwo();
            gcd.operate();
            logger.info("---------------------------------");
            gcd.showResult();
            logger.info("---------------------------------");

            logger.info("###    Factorial Operation  ###");
            Factorial factorial = new Factorial();
            factorial.loadOne();
            factorial.operate();
            logger.info("---------------------------------");
            factorial.showResult();
            logger.info("---------------------------------");

        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }


    static class Operation {
        protected Scanner sc;
        protected double valueOne;
        protected double valueTwo;
        protected double result;

        public Operation() {
            this.sc = new Scanner(System.in);
        }

        /**
         * Method used to assign a value to valueOne
         */
        public void loadOne() {
            logger.info("Enter the first value:");
            try {
                valueOne = sc.nextDouble();
            } catch (Exception e) {
                logger.error(e);
            }
        }

        /**
         * Method used to assign a value to valueTwo
         */
        public void loadTwo() {
            logger.info("Enter the second value:");
            try {
                valueTwo = sc.nextDouble();
            } catch (Exception e) {
                logger.error(e);
            }
        }

        public void showResult() {
            logger.info("result: " + result);
        }
    }

    /**
     *  Method that assigns the add operation
     *
     */
    static class Addition extends Operation {
        public void operate() { result = valueOne + valueTwo; }
    }

    /**
     *  Method that assigns the subtraction operation
     *
     */
    static class Subtraction extends Operation {
        public void operate() { result = valueOne - valueTwo; }
    }

    /**
     *  Method that assigns the multiplication operation
     *
     */
    static class Multiplication extends Operation {
        public void operate() { result = valueOne * valueTwo; }
    }

    /**
     *  Method that assigns the division operation
     *
     */
    static class Division extends Operation {
        public void operate() { result = valueOne / valueTwo; }
    }

    /**
     *  Method that assigns the boost operation
     *
     */
    static class Boost extends Operation {
        public void operate() { result = Math.pow(valueOne, valueTwo); }
    }

    /**
     *  Method that assigns the greatest common divisor operation
     *
     */
    static class GreatestCommonDivisor extends Operation {
        public void operate() {
            double a = Math.max(valueOne, valueTwo);
            double b = Math.min(valueOne, valueTwo);
            do {
                result = b;
                b = a%b;
                a = result;
            } while (b!=0);
        }
    }

    /**
     *  Method that assigns the factorial operation
     *
     */
    static class Factorial extends Operation {
        public void operate() {
            result = 1;
            for (double i = 1; i <= valueOne; i++) {
                result *= i;
            }
        }
    }

}
