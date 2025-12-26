enum UtilityType {ELECTRICAL, FIBER_OPTIC, WATER, GAS, SEWER}

enum LineMarker {SOLID, DASHED, DOTTED}

public class UtilityLine implements Mappable {
    private final String name;
    private final UtilityType utilityType;
    private final LineMarker lineMarker;
    private final Color color;
    private final GeometryType shape = GeometryType.LINE;

    public UtilityLine(String name, UtilityType utility) {
        this.name = name;
        this.utilityType = utility;

        switch(this.utilityType) {
            case ELECTRICAL:
                this.lineMarker = LineMarker.SOLID;
                this.color = Color.RED;
                break;
            case FIBER_OPTIC:
                this.lineMarker = LineMarker.SOLID;
                this.color = Color.GRAY;
                break;
            case WATER:
                this.lineMarker = LineMarker.DOTTED;
                this.color = Color.BLUE;
                break;
            case GAS:
                this.lineMarker = LineMarker.DOTTED;
                this.color = Color.YELLOW;
                break;
            case SEWER:
                this.lineMarker = LineMarker.DASHED;
                this.color = Color.BLACK;
                break;
            default:
                this.lineMarker = LineMarker.SOLID;
                this.color = Color.WHITE;
        }
    }

    @Override
    public String getLabel() {
        return this.name + " (" + this.utilityType + ")";
    }

    @Override
    public GeometryType getShape() {
        return this.shape;
    }

    @Override
    public String getMarker() {
        return this.color + " " + this.lineMarker;
    }

    public String getName() {
        return name;
    }

    public String getUtilityType() {
        return this.utilityType.toString();
    }

    @Override
    public String toJason() {
        return Mappable.super.toJason() + String.format("\"name\": \"%s\", \"utility\": \"%s\"",
                getName(), getUtilityType());
    }
}
