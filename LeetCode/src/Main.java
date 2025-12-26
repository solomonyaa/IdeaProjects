import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] heightArr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        var res = Solution.maxArea(heightArr);
        System.out.println(res);

        int[] testCase1 = {3, 2, 4};
        var res2 = Solution.twoSum(testCase1, 6);
        System.out.println(Arrays.toString(res2));

        ListNode ln1 = new ListNode(2);
        ln1.next = new ListNode(4);
        ln1.next.next = new ListNode(3);

        ListNode ln2 = new ListNode(5);
        ln2.next = new ListNode(6);
        ln2.next.next = new ListNode(4);

        var squareRoot = Solution.mySqrt(16);
        System.out.println(squareRoot);

        var atoiNum = Solution.myAtoi("-+12");
        System.out.println(atoiNum);

        var isPalindrome = Solution.isPalindrome("1203021");
        System.out.println(isPalindrome);

        var reversedNum = Solution.reverse(-2147483648);
        System.out.println(reversedNum);

        var wordLength = Solution.lengthOfLastWord("");
        System.out.println(wordLength);

        var repeatedDnaSequences =
                Solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(repeatedDnaSequences);

        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        var majorityElement = Solution.majorityElement(arr);
        System.out.println("Majority Element = " + majorityElement);

        int[] arr2 = {1, 2};
        var majorityElementList = Solution.majorityElement2(arr2);
        System.out.println(majorityElementList);

        var isValidPalindrome = Solution.isValidPalindrome("A man, a plan, a canal: Panama");
        System.out.println(isValidPalindrome);

        var stRes = Solution.addBinary("11", "1");
        System.out.println(stRes);

        int[] intArr = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int k = Solution.removeElement(intArr, 2);
        System.out.println("k = " + k);
        System.out.println(Arrays.toString(intArr));

        String strResult = Solution.mergeAlternately("abcd", "pq");
        System.out.println(strResult);

        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        var kids = Solution.kidsWithCandies2(candies, extraCandies);
        System.out.println(kids);

        int[] flowerbed = {1, 0, 0, 0, 1};
        int newFlowers = 1;
        var canPlaceFlowers = Solution.canPlaceFlowers(flowerbed, newFlowers);
        System.out.println("Can place flowers? " + canPlaceFlowers);

        int[] numbers = {2, 1, 5, 0, 4, 6};
        System.out.println(Solution.increasingTriplet(numbers));

        System.out.println("Is Subsequence: " + Solution.isSubsequence("aef", "abcdehf"));

        int[] arr3 = {1, 12, -5, -6, 50, 3};
        System.out.println(Solution.findMaxAverage(arr3, 4));

        String inputString = "a good   example";
        System.out.println(Solution.reverseWords(inputString));

        int[] intArray = {5, 3};
        System.out.println(Arrays.toString(Solution.productExceptSelf(intArray)));

        int[] gain = {-3};
        System.out.println("highest altitude: " + Solution.largestAltitude(gain));

    }
}

