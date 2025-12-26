public class Main {
    public static void main(String[] args)
    {
        /*int highScorePosition = calculateHighScorePosition(1500);
        displayHighScorePosition("Tim", highScorePosition);

        highScorePosition = calculateHighScorePosition(1000);
        displayHighScorePosition("Bob", highScorePosition);

        highScorePosition = calculateHighScorePosition(500);
        displayHighScorePosition("Percy", highScorePosition);

        highScorePosition = calculateHighScorePosition(100);
        displayHighScorePosition("Gilbert", highScorePosition);

        highScorePosition = calculateHighScorePosition(25);
        displayHighScorePosition("James", highScorePosition);*/

        /*System.out.println(convertToCentimeters(5, 9));
        System.out.println(convertToCentimeters(11));*/

        System.out.println(getDurationString(3945));
        System.out.println(getDurationString(65, 45));
        System.out.println(getDurationStringNormal(3945));
    }

    public static void displayHighScorePosition(String playerName, int playerPosition)
    {
        System.out.println(playerName + " managed to get into position " + playerPosition +
                " on the high score list.");
    }

    public static int calculateHighScorePosition(int playerScore)
    {
        int position = 4;
        if (playerScore >= 1000)
            position = 1;
        else if (playerScore >= 500)
            position = 2;
        else if (playerScore >= 100)
            position = 3;
        return position;
    }

    public static double convertToCentimeters(int heightInInches)
    {
        final double ONE_INCH = 2.54;
        return (heightInInches * ONE_INCH);
    }
    public static double convertToCentimeters(int feet, int inches)
    {
        //final double ONE_FOOT = 30.48;
        //return ((feet * ONE_FOOT) + convertToCentimeters(inches));

        final int ONE_FOOT_IN_INCHES = 12;
        int heightInInches = (feet * ONE_FOOT_IN_INCHES) + inches;
        return convertToCentimeters(heightInInches);
    }

    public static String getDurationStringNormal(int seconds)
    {
        if (seconds < 0)
            return "Please enter a valid number of seconds.";

        final int secondsInMinute = 60;
        final int minutesInHour = 60;
        int hours = (seconds / secondsInMinute) / minutesInHour;
        int minutes = (seconds / secondsInMinute) % minutesInHour;
        seconds = seconds % secondsInMinute;
        String res = hours + "h " + minutes + "m " + seconds + "s ";
        return res;
    }
    public static String getDurationString(int seconds)
    {
        if (seconds < 0)
            return "Please enter a valid number of seconds.";

        int minutes = seconds / 60;
        seconds = seconds % 60;
        return getDurationString(minutes, seconds);
    }
    public static String getDurationString(int minutes, int seconds)
    {
        if (seconds < 0 || seconds > 59 || minutes < 0)
            return "Please enter a valid number of seconds and minutes.";

        int hours = minutes / 60;
        minutes = minutes % 60;
        return hours + "h " + minutes + "m " + seconds + "s ";
    }
}