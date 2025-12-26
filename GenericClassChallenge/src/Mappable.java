public interface Mappable {

    void render(); // by default, it's both public and abstract

    static double[] stringToLatitudeLongitude(String location){

        var splits = location.split(",");
        double latitude = Double.parseDouble(splits[0]);
        double longitude = Double.parseDouble(splits[1]);
        return new double[]{latitude, longitude};
    }
}
