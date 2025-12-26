public class Car {
    private String manufacturer;
    private String model;
    private String color;
    private int doors;
    private int year;
    private boolean convertible;

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getDoors() {
        return doors;
    }
    public int getYear() {
        return year;
    }

    public boolean isConvertible() {
        return convertible;
    }

    public void setManufacturer(String manufacturer) {
        if(manufacturer == null){
            this.manufacturer = "Unknown";
            return;
        }
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }

    public String describeCar(){
        return ("Manufacturer: " + manufacturer +
                "\nModel: " + model +
                "\nYear: " + year +
                "\nColor: " + color +
                "\nDoors: " + doors + "\n" +
                (convertible ? "Convertible" : ""));
    }
}

