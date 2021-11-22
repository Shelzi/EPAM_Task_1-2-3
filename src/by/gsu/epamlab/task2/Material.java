package by.gsu.epamlab.task2;

public class Material {
    private String name;
    private final double DENSITY;

    public Material() {
        DENSITY = 0.0;
    }

    public Material(String name, double density) {
        this.name = name;
        this.DENSITY = density;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDENSITY() {
        return DENSITY;
    }

    @Override
    public String toString() {
        return String.format("%s;%d", name, DENSITY);
    }
}
