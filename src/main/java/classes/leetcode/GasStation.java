package classes.leetcode;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int tank = 0;
        int totalGas = 0;
        int totalCost = 0;
        for (int i=0; i<gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        if (totalGas < totalCost) {
            return -1;
        } else {
            return start;
        }
    }

    public static void main(String[] args) {
        System.out.println(new GasStation().canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));
        System.out.println(new GasStation().canCompleteCircuit(new int[]{2,3,4},new int[]{3,4,3}));
    }
}
