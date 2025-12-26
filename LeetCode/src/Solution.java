import java.util.*;

public class Solution {

    public static int maxArea2(int[] height) {

        int maxArea = 0;
        int currentArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {

                currentArea = Math.min(height[i], height[j]) * (j - i);
                if (currentArea > maxArea) {
                    maxArea = currentArea;
                }
            }
        }

        return maxArea;
    }

    public static int maxArea(int[] height) {

        int maxArea = 0;
        int currentArea = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            currentArea = Math.min(height[left], height[right]) * (right - left);
            if (currentArea > maxArea) {
                maxArea = currentArea;
            }

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static int[] twoSum(int[] nums, int target) {

        int sum = 0;
        int[] arr = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {

            sum += nums[i];
            for (int j = i + 1; j < nums.length; j++) {

                sum += nums[j];
                if (sum == target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                } else {
                    sum -= nums[j];
                }
            }
            sum = 0;
        }

        return arr;
    }

    public static int mySqrt(int x) {

        if (x < 0) return -1;
        if (x == 0) return 0;

        int left = 1;
        int right = x;
        int mid;

        while (left <= right) {

            mid = (left + right) / 2;
            if (mid < x / mid) { // same as: mid * mid < x
                left = mid + 1;
            } else if (mid > x / mid) { // same as: mid * mid > x
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return right;
    }

    public static int myAtoi(String s) {

        int sign = 1;
        int number = 0;

        while (s.startsWith(" ")) {
            s = s.substring(1);
        }

        if (s.startsWith("-")) {
            sign = -1;
            s = s.substring(1);
        } else if (s.startsWith("+")) {
            s = s.substring(1);
        }

        if (s.startsWith("0") && s.length() == 1) {
            return 0;
        }

        while (s.startsWith("0")) {
            s = s.substring(1);
        }

        var charArr = s.toCharArray();

        for (int i = 0; i < charArr.length; i++) {

            if (charArr[i] >= '0' && charArr[i] <= '9') {
                try {
                    number = Math.multiplyExact(number, 10);
                    number = Math.addExact(number, charArr[i] - 48);
                } catch (ArithmeticException e) {
                    if (sign == -1) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
            } else {
                break;
            }
        }

        number = number * sign;
        return number;
    }

    public static boolean isPalindrome(String s) {

        if (s.length() == 1 || s.isEmpty()) return true;

        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            s = s.substring(1, s.length() - 1);
            return isPalindrome(s);
        } else {
            return false;
        }
    }

    public static boolean isPalindrome(int x) {

        if (x < 0) return false;

        String s = String.valueOf(x);

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static int reverse(int x) {

        int sign = x < 0 ? -1 : 1;
        if (sign < 0) {

            try {
                x = Math.multiplyExact(x, -1);
            } catch (ArithmeticException ae) {
                return 0;
            }

        }
        int reversedNum = 0;

        int length = String.valueOf(x).length();

        for (int i = 0; i < length; i++) {

            if (reversedNum > Integer.MAX_VALUE / 10) {
                return 0;
            }

            reversedNum = reversedNum * 10 + (x % 10);
            x = x / 10;
        }

        return reversedNum * sign;
    }

    public static int lengthOfLastWord(String s) {

        if (s.isEmpty()) return 0;

        int index = s.length() - 1;
        int count = 0;

        while (s.charAt(index) == ' ') {
            if (index > 0)
                index--;
        }

        while (s.charAt(index) != ' ') {

            index--;
            count++;

            if (index == -1) {
                break;
            }
        }

        return count;
    }

    public static List<String> findRepeatedDnaSequences(String s) {

        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String current = s.substring(i, i + 10);

            boolean isNew = seen.add(current); // Try to add 'current' to 'seen' set
            if (!isNew) {                      // If 'current' was already in the set (i.e. not new)
                repeated.add(current);         // Add it to 'repeated' set
            }

        }

        return new ArrayList<>(repeated);
    }

    public static int majorityElement(int[] nums) {

        int criteria = nums.length / 2;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {

            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                var oldVal = hashMap.get(num);
                hashMap.replace(num, ++oldVal);
            }
        }

        int majNum = -1;

        for (var entry : hashMap.entrySet()) {
            if (entry.getValue() > criteria) {
                majNum = entry.getKey();
                break;
            }
        }

        return majNum;
    }

    public static List<Integer> majorityElement2(int[] nums) {

        int criteria = nums.length / 3;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {

            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                var oldVal = hashMap.get(num);
                hashMap.replace(num, ++oldVal);
            }
        }

        for (var entry : hashMap.entrySet()) {
            if (entry.getValue() > criteria) {
                list.add(entry.getKey());
            }
        }

        return list;
    }

    public static boolean isValidPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static String addBinary(String a, String b) {

        if (a.equals("0") && b.equals("0")) return "0";

        StringBuilder sbA = new StringBuilder(a);
        StringBuilder sbB = new StringBuilder(b);

        StringBuilder sum = new StringBuilder();

        int largerLength = Math.max(a.length(), b.length());

        while (sbA.length() < largerLength) {
            sbA.insert(0, "0");
        }

        while (sbB.length() < largerLength) {
            sbB.insert(0, "0");
        }

        int carry = 0;

        for (int i = largerLength - 1; i >= 0; i--) {

            int aDigit = Integer.parseInt(sbA.substring(i, i + 1));
            int bDigit = Integer.parseInt(sbB.substring(i, i + 1));
            int digitSum = aDigit + bDigit + carry;

            switch (digitSum) {
                case 0:
                    sum.append("0");
                    carry = 0;
                    break;
                case 1:
                    sum.append("1");
                    carry = 0;
                    break;
                case 2:
                    sum.append("0");
                    carry = 1;
                    break;
                case 3:
                    sum.append("1");
                    carry = 1;
                    break;
            }
        }

        if (carry == 1) {
            sum.append("1");
        }

        return String.valueOf(sum.reverse());
    }

    public static int removeElement(int[] nums, int val) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static String mergeAlternately(String word1, String word2) {

        int shorterLength = Math.min(word1.length(), word2.length());

        StringBuilder res = new StringBuilder();

        int i;

        for (i = 0; i < shorterLength; i++) {
            res.append(word1.charAt(i));
            res.append(word2.charAt(i));
        }

        if (word1.length() > word2.length()) {
            res.append(word1.substring(i));
        } else if (word1.length() < word2.length()) {
            res.append(word2.substring(i));
        }

        return res.toString();
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> list = new ArrayList<>();
        boolean res;

        for (int i = 0; i < candies.length; i++) {

            int[] copyArr = new int[candies.length];

            for (int j = 0; j < copyArr.length; j++) {
                copyArr[j] = candies[j];
            }

            res = true;
            copyArr[i] += extraCandies;

            for (int numOfCandies : copyArr) {

                if (numOfCandies > copyArr[i]) {
                    res = false;
                    break;
                }
            }

            list.add(res);
        }

        return list;
    }

    public static List<Boolean> kidsWithCandies2(int[] candies, int extraCandies) {

        List<Boolean> list = new ArrayList<>();
        int[] copyArr = new int[candies.length];

        for (int i = 0; i < candies.length; i++) {
            copyArr[i] = candies[i];
            copyArr[i] += extraCandies;
        }

        for (int i = 0; i < copyArr.length; i++) {

            boolean res = true;
            for (int j = 0; j < candies.length; j++) {

                if (i == j) continue;

                if (candies[j] > copyArr[i]) {
                    res = false;
                    break;
                }
            }

            list.add(res);
        }

        return list;
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int[] copyArr = new int[flowerbed.length];
        System.arraycopy(flowerbed, 0, copyArr, 0, flowerbed.length);

        if (copyArr.length == 0) {
            return n == 0;
        }
        if (copyArr.length == 1) {

            if (copyArr[0] == 0) return n == 1 || n == 0;
            if (copyArr[0] == 1) return n == 0;
        }

        if (copyArr[0] == 0 && copyArr[1] == 0) {
            //plant
            copyArr[0] = 1;
            n--;
        }

        if (copyArr[copyArr.length - 1] == 0 &&
            copyArr[copyArr.length - 2] == 0) {
            //plant
            copyArr[copyArr.length - 1] = 1;
            n--;
        }

        for (int i = 1; i < copyArr.length - 1; i++) {

            if (n <= 0) break;

            if (copyArr[i - 1] == 0 && copyArr[i] == 0 && copyArr[i + 1] == 0) {
                //plant
                copyArr[i] = 1;
                n--;
            }
        }

        return n <= 0;
    }

    public static boolean increasingTriplet(int[] nums) {

        int lastIndex = nums.length - 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= lastIndex - 2; i += 1) {

            for (int j = i + 1; j <= lastIndex - 1; j += 1) {

                if (nums[j] > nums[i]) {

                    for (int k = j + 1; k <= lastIndex; k += 1) {

                        if (nums[k] > nums[j]) {
                            sb.append(nums[i]).append(", ")
                                    .append(nums[j]).append(", ")
                                    .append(nums[k]).append(", ");
                            System.out.println(sb);
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public static boolean isSubsequence(String s, String t) {

        if (s.isEmpty()) return true;
        if (t.isEmpty()) return false;

        int pointerS = 0;
        int pointerT = 0;
        int count = 0;

        do {

            if (s.charAt(pointerS) == t.charAt(pointerT)) {
                pointerS++;
                pointerT++;
                count++;
            } else {
                pointerT++;
            }

            if (pointerT >= t.length()) {
                break;
            }

        } while (pointerS < s.length());


        return count == s.length();
    }

    public static double findMaxAverage(int[] nums, int k) {

        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        double bestAVG;
        double sum = 0;


        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        bestAVG = sum / k;

        for (int i = k; i < nums.length; i += 1) {


            sum -= nums[i - k];
            sum += nums[i];

            if ((sum / k) > bestAVG) {
                bestAVG = sum / k;
            }
        }

        return bestAVG;
    }

    public static String reverseWords(String s) {

        s = s.trim();
        StringBuilder sentence = new StringBuilder();
        StringBuilder word = new StringBuilder();

        int index = s.length() - 1;

        for (int i = index; i >= 0; i--) {

            if (s.charAt(i) != ' ') {
                word.append(s.charAt(i));
            }

            if ((s.charAt(i) == ' ' && s.charAt(i - 1) != ' ') || i == 0) {
                sentence.append(word.reverse());
                if (i != 0) {
                    sentence.append(" ");
                }
                word.setLength(0);
            }
        }

        return sentence.toString();
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];
        int left = 1;
        int right = 1;
        int index = 0;
        int count = 0;
        int i = 1;

        do {

            if (i < index) {
                left *= nums[i];
                i++;
                count++;
            } else if (i > index) {
                right *= nums[i];
                i++;
                count++;
            } else { // i == index
                i++;
            }

            if (count == nums.length - 1) {
                answer[index] = left * right;
                index++;
                left = 1;
                right = 1;
                count = 0;
                i = 0;
            }

        } while (index <= answer.length - 1);

        return answer;
    }

    public static int largestAltitude(int[] gain) {

        int[] altitudes = new int[gain.length + 1];
        altitudes[0] = 0;
        int i = 0;
        int j = 1;
        int max = altitudes[0];

        while (j < altitudes.length) {

            altitudes[j] = altitudes[j - 1] + gain[i];

            if (altitudes[j] > max) {
                max = altitudes[j];
            }

            j++;
            i++;
        }

        return max;
    }

}
