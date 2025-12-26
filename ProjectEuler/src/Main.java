import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        System.out.println("1) " + multiplesOf3or5(1000));

        long res = evenFibonacciSum(4000000);

        System.out.println("2) " + res);

        long res2 = largestPrimeFactor(600_851_475_143L);

        System.out.println("3) " + res2);

        System.out.println("4) " + largestPalindromeProduct());

        System.out.println("5) " + smallestMultiple());

        System.out.println("6) " + sumSquareDifference(100));

        var nthPrime = nthPrime(10001);

        System.out.println("7) " + nthPrime);

        System.out.println("8) " + largestProductInSeries(13));

        System.out.println("9) " + specialPythagoreanTriplet());

        System.out.println("10) " + summationOfPrimes(2000000));

        System.out.println("11) " + largestProductInGrid());

        highlyDivisibleTriNumber(500);

        System.out.println("13) " + largestSum());

        System.out.println(longestCollatzSequence());

        System.out.println("15) " + latticePaths(20));

        System.out.println("16) " + powerDigitSum());

        System.out.println("18) " + maximumPathSumI());

        System.out.println("20) " + factorialDigitSum(100));



    }

    private static int multiplesOf3or5(int limit) {

        int sum = 0;

        for (int i = 1; i < limit; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    private static int evenFibonacciSum(int condition) {

        int first = 1;
        int second = 2;

        int sum = 0;

        while (true) {
            int temp = first;
            first = second;
            second = temp + second;

            if (first > condition) {
                break;
            }
            if (first % 2 == 0) {
                sum += first;
            }
        }
        return sum;
    }

    private static long largestPrimeFactor(long num) {

        long lpf = 0;

        for (int i = 2; i <= Math.sqrt(num); i++) {

            if (num % i == 0) {
                if (isPrime(i)) {
                    lpf = i;
                }
            }
        }
        return lpf;
    }

    private static boolean isPrime(long num) {

        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static int largestPalindromeProduct() {
        int product;
        int palindrome = 0;

        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j <= 999; j++) {

                product = i * j;
                if (isPalindrome(product)) {
                    if (product > palindrome) {
                        palindrome = product;
                    }
                }
            }
        }

        return palindrome;
    }

    private static boolean isPalindrome(int num) {

        String str = String.valueOf(num);

        for (int i = 0; i <= (str.length() / 2) - 1; i++) {

            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    private static int smallestMultiple() {

        boolean flag = false;
        int num = 120;
        int points;

        while (!flag) {
            points = 0;

            for (int i = 1; i <= 20; i++) {

                if (num % i != 0) {
                    num++;
                    break;
                } else {
                    points += 1;
                }
            }

            if (points == 20) {
                flag = true;
            }
        }

        return num;
    }

    private static int sumSquareDifference(int range) {

        int sum1 = 0;
        int sum2 = 0;


        for (int i = 1; i <= range; i++) {

            sum1 += i * i;

            sum2 += i;
        }

        sum2 = sum2 * sum2;

        return Math.abs(sum2 - sum1);
    }

    private static long nthPrime(int index) {

        int myIndex = 0;
        int myNum = 2;

        while (myIndex != index) {

            if (isPrime(myNum)) {
                myIndex++;
            }

            if (myIndex != index) {
                myNum++;
            }
        }

        return myNum;
    }

    private static long largestProductInSeries(int length) {

        if (length < 0) return 0;

        String data = """
                73167176531330624919225119674426574742355349194934
                96983520312774506326239578318016984801869478851843
                85861560789112949495459501737958331952853208805511
                12540698747158523863050715693290963295227443043557
                66896648950445244523161731856403098711121722383113
                62229893423380308135336276614282806444486645238749
                30358907296290491560440772390713810515859307960866
                70172427121883998797908792274921901699720888093776
                65727333001053367881220235421809751254540594752243
                52584907711670556013604839586446706324415722155397
                53697817977846174064955149290862569321978468622482
                83972241375657056057490261407972968652414535100474
                82166370484403199890008895243450658541227588666881
                16427171479924442928230863465674813919123162824586
                17866458359124566529476545682848912883142607690042
                24219022671055626321111109370544217506941658960408
                07198403850962455444362981230987879927244284909188
                84580156166097919133875499200524063689912560717606
                05886116467109405077541002256983155200055935729725
                71636269561882670428252483600823257530420752963450
                """;

        data = data.replaceAll("\\s+", "");
        long bestMaxProduct = 0;

        for (int i = 0; i <= data.length() - length; i++) {

            long maxProduct = 1;

            var part = data.substring(i, i + length);
            int[] intArray = part.chars()  // Get character stream
                    .map(c -> c - '0')  // Convert char to actual int value
                    .toArray();  // Convert to int array

            for (int num : intArray) {
                maxProduct *= num;
            }

            if (maxProduct > bestMaxProduct) {
                bestMaxProduct = maxProduct;
            }
        }

        return bestMaxProduct;
    }

    private static int specialPythagoreanTriplet() {

        int a, b;
        double c;

        for (a = 1; a < 1000; a++) {

            for (b = a; b < 1000; b++) {

                c = Math.sqrt(a * a + b * b);

                if (isNaturalNumber(c)) {
                    if (a + b + c == 1000) {
                        System.out.println("a = " + a + ", b = " + b + ", c = " + (int) c);
                        return (int) (a * b * c);
                    }
                }
            }
        }

        return -1;
    }

    private static long summationOfPrimes(long limit) {

        long sum = 0;
        for (int i = 1; i < limit; i++) {

            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }

    private static boolean isNaturalNumber(double num) {
        return num >= 0 && num == (long) num;
    }

    private static void highlyDivisibleTriNumber(long divisors) {

        long triNum;
        long numDivisors = 0;
        long naturalNum = 1;

        while (true) {

            triNum = triangularNumber(naturalNum);

            for (int i = 1; i <= (long) Math.sqrt(triNum); i++) {

                if (triNum % i == 0) {
                    numDivisors += 2;
                }

                if (i == triNum / i) {
                    numDivisors--;
                    // If n is a perfect square, don't count sqrt(n) twice
                }
            }

            if (numDivisors > divisors) {
                break;
            }

            numDivisors = 0;
            naturalNum++;
        }

        System.out.println("12) " + triNum + " has " + numDivisors + " divisors.");
    }

    private static long triangularNumber(long index) {

        if (index < 1) return -1;
        long sum = 0;

        for (long i = 1; i <= index; i++) {
            sum += i;
        }

        return sum;
    }

    private static String longestCollatzSequence() {

        long num;
        long maxNumber = 0;
        long longest = 0;

        for (num = 1; num < 1000000; num++) {

            var length = produceCollatzSequence(num);

            if (length > longest) {
                longest = length;
                maxNumber = num;
            }
        }

        return "14) The number: " + maxNumber + " has the longest Collatz chain with "
               + longest + " steps.";
    }

    private static int produceCollatzSequence(long num) {


        int length = 1;

        while (num != 1) {

            //System.out.print(num + "->");
            length++;
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = (3 * num) + 1;
            }

        }

        //System.out.println("1");
        return length;
    }

    private static long factorial(long n) {

        if (n < 0) return -1;
        if (n < 2) return 1;

        return n * factorial(n - 1);
    }

    private static BigInteger factorialHavingLargeResult(int n) {

        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    private static BigInteger latticePaths(int n) {

        var numerator = factorialHavingLargeResult(2 * n);
        var denominator = factorialHavingLargeResult(n).multiply(factorialHavingLargeResult(n));

        return numerator.divide(denominator);
    }

    private static int largestProductInGrid() {

        String data = """
                08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
                49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
                81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
                52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
                22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
                24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
                32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
                67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
                24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
                21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
                78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
                16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
                86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
                19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
                04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
                88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
                04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
                20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
                20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
                01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48
                """;

        // Convert to 2D array
        String[] rows = data.strip().split("\n");
        int[][] grid = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String[] numbers = rows[i].trim().split("\\s+");
            grid[i] = new int[numbers.length];
            for (int j = 0; j < numbers.length; j++) {
                grid[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        int maxProduct = 0;
        int bestI = 0;
        int bestJ = 0;

        // Iterate through the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                // Right (→)
                if (j + 3 < grid[i].length) {
                    int product = grid[i][j] * grid[i][j + 1] * grid[i][j + 2] * grid[i][j + 3];
                    maxProduct = Math.max(maxProduct, product);
                }

                // Down (↓)
                if (i + 3 < grid.length) {
                    int product = grid[i][j] * grid[i + 1][j] * grid[i + 2][j] * grid[i + 3][j];
                    maxProduct = Math.max(maxProduct, product);
                }

                // Diagonal Down-Right (↘)
                if (i + 3 < grid.length && j + 3 < grid[i].length) {
                    int product = grid[i][j] * grid[i + 1][j + 1] * grid[i + 2][j + 2] * grid[i + 3][j + 3];
                    maxProduct = Math.max(maxProduct, product);
                }

                // Diagonal Down-Left (↙)
                if (i + 3 < grid.length && j - 3 >= 0) {
                    int product = grid[i][j] * grid[i + 1][j - 1] * grid[i + 2][j - 2] * grid[i + 3][j - 3];
                    maxProduct = Math.max(maxProduct, product);
                }
            }
        }

        return maxProduct;
    }

    private static String largestSum() {

        String[] numbers = {
                "37107287533902102798797998220837590246510135740250",
                "46376937677490009712648124896970078050417018260538",
                "74324986199524741059474233309513058123726617309629",
                "91942213363574161572522430563301811072406154908250",
                "23067588207539346171171980310421047513778063246676",
                "89261670696623633820136378418383684178734361726757",
                "28112879812849979408065481931592621691275889832738",
                "44274228917432520321923589422876796487670272189318",
                "47451445736001306439091167216856844588711603153276",
                "70386486105843025439939619828917593665686757934951",
                "62176457141856560629502157223196586755079324193331",
                "64906352462741904929101432445813822663347944758178",
                "92575867718337217661963751590579239728245598838407",
                "58203565325359399008402633568948830189458628227828",
                "80181199384826282014278194139940567587151170094390",
                "35398664372827112653829987240784473053190104293586",
                "86515506006295864861532075273371959191420517255829",
                "71693888707715466499115593487603532921714970056938",
                "54370070576826684624621495650076471787294438377604",
                "53282654108756828443191190634694037855217779295145",
                "36123272525000296071075082563815656710885258350721",
                "45876576172410976447339110607218265236877223636045",
                "17423706905851860660448207621209813287860733969412",
                "81142660418086830619328460811191061556940512689692",
                "51934325451728388641918047049293215058642563049483",
                "62467221648435076201727918039944693004732956340691",
                "15732444386908125794514089057706229429197107928209",
                "55037687525678773091862540744969844508330393682126",
                "18336384825330154686196124348767681297534375946515",
                "80386287592878490201521685554828717201219257766954",
                "78182833757993103614740356856449095527097864797581",
                "16726320100436897842553539920931837441497806860984",
                "48403098129077791799088218795327364475675590848030",
                "87086987551392711854517078544161852424320693150332",
                "59959406895756536782107074926966537676326235447210",
                "69793950679652694742597709739166693763042633987085",
                "41052684708299085211399427365734116182760315001271",
                "65378607361501080857009149939512557028198746004375",
                "35829035317434717326932123578154982629742552737307",
                "94953759765105305946966067683156574377167401875275",
                "88902802571733229619176668713819931811048770190271",
                "25267680276078003013678680992525463401061632866526",
                "36270218540497705585629946580636237993140746255962",
                "24074486908231174977792365466257246923322810917141",
                "91430288197103288597806669760892938638285025333403",
                "34413065578016127815921815005561868836468420090470",
                "23053081172816430487623791969842487255036638784583",
                "11487696932154902810424020138335124462181441773470",
                "63783299490636259666498587618221225225512486764533",
                "67720186971698544312419572409913959008952310058822",
                "95548255300263520781532296796249481641953868218774",
                "76085327132285723110424803456124867697064507995236",
                "37774242535411291684276865538926205024910326572967",
                "23701913275725675285653248258265463092207058596522",
                "29798860272258331913126375147341994889534765745501",
                "18495701454879288984856827726077713721403798879715",
                "38298203783031473527721580348144513491373226651381",
                "34829543829199918180278916522431027392251122869539",
                "40957953066405232632538044100059654939159879593635",
                "29746152185502371307642255121183693803580388584903",
                "41698116222072977186158236678424689157993532961922",
                "62467957194401269043877107275048102390895523597457",
                "23189706772547915061505504953922979530901129967519",
                "86188088225875314529584099251203829009407770775672",
                "11306739708304724483816533873502340845647058077308",
                "82959174767140363198008187129011875491310547126581",
                "97623331044818386269515456334926366572897563400500",
                "42846280183517070527831839425882145521227251250327",
                "55121603546981200581762165212827652751691296897789",
                "32238195734329339946437501907836945765883352399886",
                "75506164965184775180738168837861091527357929701337",
                "62177842752192623401942399639168044983993173312731",
                "32924185707147349566916674687634660915035914677504",
                "99518671430235219628894890102423325116913619626622",
                "73267460800591547471830798392868535206946944540724",
                "76841822524674417161514036427982273348055556214818",
                "97142617910342598647204516893989422179826088076852",
                "87783646182799346313767754307809363333018982642090",
                "10848802521674670883215120185883543223812876952786",
                "71329612474782464538636993009049310363619763878039",
                "62184073572399794223406235393808339651327408011116",
                "66627891981488087797941876876144230030984490851411",
                "60661826293682836764744779239180335110989069790714",
                "85786944089552990653640447425576083659976645795096",
                "66024396409905389607120198219976047599490197230297",
                "64913982680032973156037120041377903785566085089252",
                "16730939319872750275468906903707539413042652315011",
                "94809377245048795150954100921645863754710598436791",
                "78639167021187492431995700641917969777599028300699",
                "15368713711936614952811305876380278410754449733078",
                "40789923115535562561142322423255033685442488917353",
                "44889911501440648020369068063960672322193204149535",
                "41503128880339536053299340368006977710650566631954",
                "81234880673210146739058568557934581403627822703280",
                "82616570773948327592232845941706525094512325230608",
                "22918802058777319719839450180888072429661980811197",
                "77158542502016545090413245809786882778948721859617",
                "72107838435069186155435662884062257473692284509516",
                "20849603980134001723930671666823555245252804609722",
                "53503534226472524250874054075591789781264330331690",
        };

        // Step 1: Sum the numbers
        BigInteger sum = BigInteger.ZERO;

        for (String number : numbers) {
            sum = sum.add(new BigInteger(number));
        }

        // Step 2: Get the first 10 digits
        String sumString = sum.toString();
        String first10Digits = sumString.substring(0, 10);

        // Print the first 10 digits
        return first10Digits;
    }

    private static long powerDigitSum() {

        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= 1000; i++) {
            result = result.multiply(BigInteger.valueOf(2));
        }

        long sum = 0;
        String res = result.toString();

        for (int i = 0; i < res.length(); i++) {
            sum += Integer.parseInt(res.substring(i, i + 1));
        }

        return sum;
    }

    private static int greedyMaxPathSum() {

        String input = """
                75
                95 64
                17 47 82
                18 35 87 10
                20 04 82 47 65
                19 01 23 75 03 34
                88 02 77 73 07 63 67
                99 65 04 28 06 16 70 92
                41 41 26 56 83 40 80 70 33
                41 48 72 33 47 32 37 16 94 29
                53 71 44 65 25 43 91 52 97 51 14
                70 11 33 28 77 73 17 78 39 68 17 57
                91 71 52 38 17 14 91 43 58 50 27 29 48
                63 66 04 68 89 53 67 30 73 16 69 87 40 31
                04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
                """;

        String[] rows = input.strip().split("\n");
        int[][] triangleArr = new int[rows.length][];

        for (int i = 0; i < rows.length; i++) {

            String[] numbers = rows[i].trim().split("\\s+");
            triangleArr[i] = new int[numbers.length];

            for (int j = 0; j < numbers.length; j++) {
                triangleArr[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        int row;
        int column = 0;
        int sum = triangleArr[0][0];

        for (row = 0; row < rows.length - 1; row++) {

            if (triangleArr[row + 1][column] >= triangleArr[row + 1][column + 1]) {
                sum += triangleArr[row + 1][column];
            } else {
                sum += triangleArr[row + 1][column + 1];
                column++;
            }
        }
        return sum;
    }

    public static int maximumPathSumI() {

        String input = """
                75
                95 64
                17 47 82
                18 35 87 10
                20 04 82 47 65
                19 01 23 75 03 34
                88 02 77 73 07 63 67
                99 65 04 28 06 16 70 92
                41 41 26 56 83 40 80 70 33
                41 48 72 33 47 32 37 16 94 29
                53 71 44 65 25 43 91 52 97 51 14
                70 11 33 28 77 73 17 78 39 68 17 57
                91 71 52 38 17 14 91 43 58 50 27 29 48
                63 66 04 68 89 53 67 30 73 16 69 87 40 31
                04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
                """;

        String[] rows = input.strip().split("\n");
        int[][] triangle = new int[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            String[] numbers = rows[i].trim().split("\\s+");
            triangle[i] = new int[numbers.length];
            for (int j = 0; j < numbers.length; j++) {
                triangle[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        // Bottom-up DP approach
        for (int row = triangle.length - 2; row >= 0; row--) {
            for (int column = 0; column < triangle[row].length; column++) {
                // Replace each element with itself + max of two numbers below
                triangle[row][column] += Math.max(triangle[row + 1][column], triangle[row + 1][column + 1]);
            }
        }

        return triangle[0][0]; // The top element now contains the max path sum
    }

    private static void pascalTriangle(int[] arr, int lines) {

        if (lines <= 0) return;

        for (int i = 1; i <= lines + 1; i++) {
            System.out.print(" ");
        }

        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }

        int newSize = arr.length + 1;
        int[] newArr = new int[newSize];

        for (int i = 0; i < newArr.length; i++) {

            if (i == 0 || i == newSize - 1) {
                newArr[i] = 1;
            } else {
                newArr[i] = arr[i - 1] + arr[i];
            }
        }

        System.out.println();
        pascalTriangle(newArr, --lines);
    }

    private static int factorialDigitSum(int num) {

        BigInteger bigInteger = BigInteger.ONE;

        for (long i = num; i >= 1; i--) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }

        String numString = bigInteger.toString();
        int sum = 0;

        for (int i = 0; i < numString.length(); i++) {
            sum += Integer.parseInt(numString.substring(i, i + 1));
        }

        return sum;
    }

}


