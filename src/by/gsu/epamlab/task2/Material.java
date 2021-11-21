package by.gsu.epamlab.task2;

public class Material {
    private String name;
    private final double density;

    public Material() {
        density = 0.0;
    }

    public Material(String name, double density) {
        this.name = name;
        this.density = density;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDensity() {
        return density;
    }

    @Override
    public String toString() {
        return name + ';' + density;
    }
}
