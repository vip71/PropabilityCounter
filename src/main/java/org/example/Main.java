package org.example;

import java.security.SecureRandom;

import static java.lang.Math.*;

public class Main {
    static double a=0,b=1,M=1;

    public static void main(String[] args) {
        SecureRandom random=new SecureRandom();

        doExercise(1,0,8,2,random);
        doExercise(2,0,3.14,1,random);
        doExercise(3,0,1,10,random);
    }

    private static void doExercise(int numberOfExercise,double thisA,double thisB,double thisM ,SecureRandom random) {
        a=thisA;
        b=thisB;
        M=thisM;
        doApproximations(numberOfExercise, random);
        System.out.println();
    }

    private static void doApproximations(int numberOfExercise,SecureRandom random) {
        for(int i=50;i<=5000;i+=50)
        {
            System.out.print(i);
            for(int j=0;j<50;j++)System.out.print(";"+countIntegral(numberOfExercise,i, random));
            System.out.println();
        }
    }

static double countIntegral(int numberOfExercise,int precision, SecureRandom random)
    {
        double x,y;

        int sum=0;
        for(int i=0;i<precision;i++) {
            x = a+random.nextDouble() * (b - a);
            y = random.nextDouble() * (M);
            if(function(numberOfExercise,x)>y) sum++;
        }
        return (b-a)*abs(M)*sum/precision;
    }

    static double function(int numberOfExercise,double x)
    {
        return switch (numberOfExercise) {
            case 1 -> Math.cbrt(x);
            case 2 -> sin(x);
            case 3 -> 4 * x * Math.pow(1 - x, 3);
            default -> 0;
        };
    }
}