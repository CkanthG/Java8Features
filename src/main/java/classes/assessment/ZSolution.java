package classes.assessment;

// Za-lan-do codility assignment
class ZSolution {
    public void solution(int N) {

        while (N > 0) {
            int enable_print = N % 10;
            System.out.print(enable_print);
            if (enable_print == 0 && N % 10 != 0) {
                enable_print = 1;
            }
            else if (enable_print == 1) {
                enable_print = 1;
            }
            N = N / 10;
        }
    }

    public String solution(int AA, int AB, int BB) {
        StringBuilder result = new StringBuilder();

        // Append "AA" and "BB" while checking for sequences
        while (AA > 0 && BB > 0) {
            if (result.length() >= 2 && result.substring(result.length() - 2).equals("AA")) {
                break; // Prevent "AAA"
            }
            result.append("AA");
            AA--;

            if (result.length() >= 2 && result.substring(result.length() - 2).equals("BB")) {
                break; // Prevent "BBB"
            }
            result.append("BB");
            BB--;
        }

        // Append remaining "AB" if available
        while (AB > 0) {
            if (result.length() >= 2 && result.substring(result.length() - 2).equals("AA")) {
                break; // Prevent "AAA"
            }
            result.append("AB");
            AB--;
        }

        // Append any remaining "AA" or "BB"
        while (AA > 0) {
            if (result.length() >= 2 && result.substring(result.length() - 2).equals("AA")) {
                break; // Prevent "AAA"
            }
            result.append("AA");
            AA--;
        }
        while (BB > 0) {
            if (result.length() >= 2 && result.substring(result.length() - 2).equals("BB")) {
                break; // Prevent "BBB"
            }
            result.append("BB");
            BB--;
        }

        return result.toString();
    }

    public String solution(String S) {
        // Implement the optimized solution
        StringBuilder stack = new StringBuilder();

        for (char c : S.toCharArray()) {
            int len = stack.length();
            if (len > 0 && (
                    (stack.charAt(len - 1) == 'A' && c == 'B') ||
                            (stack.charAt(len - 1) == 'B' && c == 'A') ||
                            (stack.charAt(len - 1) == 'C' && c == 'D') ||
                            (stack.charAt(len - 1) == 'D' && c == 'C')
            )) {
                stack.deleteCharAt(len - 1); // Remove the top element
            } else {
                stack.append(c); // Add the current character to the stack
            }
        }

        return stack.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ZSolution().solution("ACBDACBD"));
        System.out.println(new ZSolution().solution("CABDC"));
        System.out.println(new ZSolution().solution("CABDCD"));
    }
}
