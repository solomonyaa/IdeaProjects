enum GeometryType {POINT, LINE, POLYGON}

public interface Mappable {
    String JSON_PROPERTY = """
            "properties": {%s}""";

    static void mapIt(Mappable mappable) {

        String output = mappable.toJason();

        System.out.printf((JSON_PROPERTY) + "%n", output);
    }

    default String toJason() {
        return String.format("\"type\": \"%s\", \"label\": \"%s\", \"marker\": \"%s\", ",
                this.getShape(), this.getLabel(), this.getMarker());
    }

    String getLabel();

    GeometryType getShape();

    String getMarker();
}
