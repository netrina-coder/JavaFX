package com.example.demo;

public class Tabulate {
    public double function(double x, double b){
        if (b*x<=0.45) return b*x-Math.tan(b*x);
        return  (b*x+Math.log10(b*x));
    }


    public double calculateSum(double[] array) {
        double sum = 0;
        for (double value : array){
            sum+=value;
        }
        return sum;
    }
    public double calculateAverage(double[] array){
        return calculateSum(array)/array.length;
    }


public double[] createXArray(double start,double end,double step){
    int stepCount = calculateStepCount(start,end,step);
    double[] xArray= new double[stepCount];
    for (int i=0;i<stepCount;i++){
        xArray[i]= start+i*step;
    }
    return xArray;
}
    public double[] createYArray(double b,double[] xArray){
        double[] yArray= new double[xArray.length];
        for (int i=0;i<xArray.length;i++){
            yArray[i]= function(xArray[i],b);
        }
        return yArray;
    }


    public int findMaxIndex(double [] yArray) {
        int maxIndex=0;
        double array;
        for (int i=1; i<yArray.length; i++){
            if (yArray[i]>yArray[maxIndex]){
                maxIndex=i;
            }
        }
        return maxIndex;
    }

    public int findMinIndex(double[] array) {
        int minIndex=0;
        for (int i = 1; i<array.length; i++){
            if (array[i]< array[minIndex]){
                minIndex=i;
            }
        }
        return minIndex;
    }
    public int calculateStepCount(double start, double end, double step) {
        return (int) Math.ceil((end-start)/step+1);
    }

    public  void printMinElement(double[] xArray, double[] yArray){
        int minIndex = findMinIndex(yArray);

        System.out.printf("The minimum value of: y=%6.2f at x=%6.2f (index%d)%n",yArray[minIndex],xArray[minIndex],minIndex);
    }
    public void printMaxElement(double[] xArray, double [] yArray){
        int maxIndex = findMaxIndex(yArray);
        System.out.printf("The maximum value of: y=%6.2f at x=%6.2f (index%d)%n",yArray[maxIndex],xArray[maxIndex],maxIndex);
    }



}










