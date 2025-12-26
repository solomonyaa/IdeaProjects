enum UsageType {BUSINESS, ENTERTAINMENT, HOUSE, RESIDENTIAL, SCHOOL, HOSPITAL, GOVERNMENT}

enum PointMarker {CIRCLE, DIAMOND, ARROW, BUBBLE, RECTANGLE, SQUARE, STAR}

public class Building implements Mappable {
    private final String name;
    private final UsageType buildingType;
    private final PointMarker pointMarker;
    private final Color color;
    private final GeometryType shape = GeometryType.POINT;

    public Building(String name, UsageType buildingType) {
        this.name = name;
        this.buildingType = buildingType;

        switch(this.buildingType) {
            case BUSINESS:
                this.pointMarker = PointMarker.BUBBLE;
                this.color = Color.RED;
                break;
            case ENTERTAINMENT:
                this.pointMarker = PointMarker.DIAMOND;
                this.color = Color.YELLOW;
                break;
            case SCHOOL:
                this.pointMarker = PointMarker.SQUARE;
                this.color = Color.GREEN;
                break;
            case HOSPITAL:
                this.pointMarker = PointMarker.RECTANGLE;
                this.color = Color.BLUE;
                break;
            case GOVERNMENT:
                this.pointMarker = PointMarker.STAR;
                this.color = Color.BLACK;
                break;
            default:
                this.pointMarker = PointMarker.CIRCLE;
                this.color = Color.WHITE;
        }
    }

    @Override
    public String getLabel() {
        return this.name + " (" + this.buildingType + ")";
    }

    @Override
    public GeometryType getShape() {
        return this.shape;
    }

    @Override
    public String getMarker() {
        return this.color + " " + this.pointMarker;
    }

    public String getName() {
        return name;
    }

    public String getBuildingType() {
        return this.buildingType.toString();
    }

    @Override
    public String toJason() {
        return Mappable.super.toJason() + String.format("\"name\": \"%s\", \"usage\": \"%s\"",
                getName(), getBuildingType());
    }
}
