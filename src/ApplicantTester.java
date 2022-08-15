import java.io.File;
import java.io.IOException;
import java.util.*;

public class ApplicantTester {
    public static void main(String[] args) {
        // The below should print:
        System.out.println(getPriorityApplicants(3, "applicants.csv"));
        // [1. E011964 (Shamir), 2. E013285 (Clarice), 3. T793412 (Jacky)]
        System.out.println(getPriorityApplicants(4, "applicants.csv"));
        System.out.println(getPriorityApplicants(5, "applicants.csv"));

        System.out.println(getPriorityApplicants(2, "tests/applicants1.csv"));
        System.out.println(getPriorityApplicants(3, "tests/applicants1.csv"));
        System.out.println(getPriorityApplicants(4, "tests/applicants1.csv"));

        System.out.println(getPriorityApplicants(2, "tests/applicants2.csv"));
        System.out.println(getPriorityApplicants(3, "tests/applicants2.csv"));
        System.out.println(getPriorityApplicants(4, "tests/applicants2.csv"));

        System.out.println(getPriorityApplicants(9999, "tests/applicants3.csv"));
        System.out.println(getPriorityApplicants(2, "tests/applicants4.csv"));
        System.out.println(getPriorityApplicants(3, "tests/applicants4.csv"));
        System.out.println(getPriorityApplicants(4, "tests/applicants4.csv"));
        System.out.println(getPriorityApplicants(5, "tests/applicants4.csv"));
        System.out.println(getPriorityApplicants(6, "tests/applicants4.csv"));
    }

    /**
     *  Obtain an ArrayList of Strings of the summarised details of priority applicants
     * @param k The estimated daily workload capacity
     * @param filename The String filename of the file of applicants to be processed
     * @return The ArrayList of Strings of the summarised details of priority applicants
     */
    public static ArrayList<String> getPriorityApplicants(int k, String filename) {
        // Complete the code below this comment.
        // You are allowed to add auxiliary methods if required
        // Note that you are not allowed to change the parameter signature and method name
        // Note the qn requirements to have only ONE data structure and an auxiliary array of size n for storage

        ArrayList<String> chosen = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File(filename));
            String[] itemDetails = sc.nextLine().split(",");
            int N = Integer.parseInt(itemDetails[0]);
            int n = N - k + 1;
            Applicant[] applicantList = new Applicant[N];
            Deque<Integer> deq = new LinkedList<>();
            Applicant lastAdded = null;

            for(int i = 0; i < N && sc.hasNext(); i++) {
                String[] line = sc.nextLine().split(",");
                Applicant applicant = new Applicant(line, itemDetails[1]);
                applicantList[i] = applicant;
            }

            sc.close();

            for(int i = 0; i < N; i++) {
//                System.out.println(deq);
                while(deq.peekLast() != null && applicantList[deq.peekLast()].compareTo(applicantList[i]) < 0) deq.removeLast();
                deq.addLast(i);
                if(i >= n-1) {
                    Applicant temp = applicantList[deq.peekFirst()];
//                    System.out.println(deq);
                    if(lastAdded == null || !temp.getSummarisedDetails().equals(lastAdded.getSummarisedDetails())) {
//                        System.out.println(deq.peekFirst()+" "+temp.getSummarisedDetails());
                        lastAdded = temp;
                        chosen.add(lastAdded.getSummarisedDetails());
                    }
                    if(deq.peekFirst().equals(i-n+1)) deq.removeFirst();
                }
            }
//            System.out.println(deq);
        } catch(IOException ignored) {}

        return chosen;
    }
}
