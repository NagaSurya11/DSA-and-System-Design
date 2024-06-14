package DSA.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class JobScheduling {
    class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    // Function to find the maximum profit and the number of jobs done.
    int[] jobScheduling(Job arr[], int n) {
        // Your code here
        int totalJobs = 0;
        int totalProfit = 0;
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }
        Comparator<Job> comparator = (o1, o2) -> Integer.compare(o2.profit,
            o1.profit);
        Arrays.sort(arr, comparator);
        Job[] jobs = new Job[maxDeadline];
        for (Job job: arr) {
            int currIdx = job.deadline - 1;
            while (currIdx >= 0 && jobs[currIdx] != null) {
                currIdx--;
            }
            if (currIdx >= 0) {
                jobs[currIdx] = job;
            }
        }

        for (Job job : jobs) {
            if (job != null) {
                totalJobs++;
                totalProfit += job.profit;
            }
        }

        return new int[] { totalJobs, totalProfit };
    }

    public static void main(String[] args) {
        int N = 5;
        JobScheduling obj = new JobScheduling();
        Job[] Jobs = { obj.new Job(1, 2, 100),
                obj.new Job(2, 1, 19),
                obj.new Job(3, 2, 27),
                obj.new Job(4, 1, 25),
                obj.new Job(5, 1, 15) };
        int[] result = obj.jobScheduling(Jobs, N);

        System.out.println(result[0] + " " + result[1]);
    }
}
