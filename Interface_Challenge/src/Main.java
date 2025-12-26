import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Mappable londonTownHall = new Building("London Town Hall", UsageType.GOVERNMENT);
        Mappable downingSt = new UtilityLine("Downing St", UtilityType.FIBER_OPTIC);
        Mappable stThomasHospital = new Building("St Thomas' Hospital", UsageType.HOSPITAL);
        Mappable CarnabySt = new UtilityLine("Carnaby St", UtilityType.ELECTRICAL);

        List<Mappable> mappables = new ArrayList<>();
        mappables.add(londonTownHall);
        mappables.add(downingSt);
        mappables.add(stThomasHospital);
        mappables.add(CarnabySt);

        for (var m : mappables){
            Mappable.mapIt(m);
        }
    }
}