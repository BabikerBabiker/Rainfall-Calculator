import java.util.*;

public class Rain {
    public static String getMonth(int j){
        j++;
        switch (j) {
            case 1:
                return "January";
            case 2:
                return "February";    
            case 3: 
                return "March";
            case 4: 
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7: 
                return "July";
            case 8:
                return "August";
            case 9: 
                return "September";
            case 10: 
                return "October";
            case 11: 
                return "November";
            case 12:
                return "December";
            default:
                return "";    
            }
    }

    public static void calcTotal(double[] vals) {
        double total = 0.0;
        for (int i = 0; i <= vals.length - 1; i++)
            total+=vals[i];

        System.out.println("Total Rainfall: " + total);
    } 

    public static void calcAVG(double[] vals) {
        double total = 0.0;
        for (int i = 0; i <= vals.length - 1; i++)
            total+=vals[i];

        System.out.println("Average Ranfall: " + total/vals.length);
    }

    public static void findExtrema(double[] vals) {
        double high = 0.0;
        double low = vals[0];
        String highMonth = "";
        String lowMonth = "";

        for (int i = 0; i <= vals.length-1; i++) {
            if (vals[i] > high) {
                high = vals[i];
                highMonth = getMonth(i+1);
            } else if (vals[i] < low) {
                low = vals[i];
                lowMonth = getMonth(i+1);
            }
        }

        System.out.println("Highest was " + highMonth + ": " + high);
        System.out.println("Lowest was " + lowMonth + ": " + low);
    }

    public static void sort(double[] vals) {
        System.out.println("\n\nRainfall Sorted [High --> Low]\n--------------------------");

        String[] months = new String[vals.length];
        for (int i = 0; i < vals.length; i++)
            months[i] = getMonth(i);
    
        for (int i = 0; i < vals.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < vals.length; j++)
                if (vals[j] > vals[max])
                    max = j;
    
            double tempVal = vals[max];
            vals[max] = vals[i];
            vals[i] = tempVal;
    
            String tempMonth = months[max];
            months[max] = months[i];
            months[i] = tempMonth;
        }
    
        for (int i = 0; i < vals.length; i++)
            System.out.println(months[i] + ": " + vals[i]);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] rainfall = new double[12];
        int size = rainfall.length;
        double temp = -1;
        String month = "";

        for (int i = 0; i <= size-1;)
            do {
                month = getMonth(i);
                System.out.print("Enter rainfall for " + month + ": ");
                temp = scan.nextDouble();

                if (temp < 0) {
                    System.out.println("\ninvalid data (negative rainfall) -- retry");
                    continue;
                }
                rainfall[i] = temp;
                i++;
                break;
            } while (true);

        System.out.println("\n\nRESULTS\n--------------");
        calcTotal(rainfall);
        calcAVG(rainfall);
        findExtrema(rainfall);
        sort(rainfall);
        scan.close();
    }
}