package by.gsu.epamlab.task2;

public class Runner {
    public static void main(String[] args) {
        Material steel = new Material("steel", 7850.0);
        Subject wire = new Subject("wire", steel, 0.03);
        System.out.println(wire);
        Material copper = new Material("copper", 8500.0);
        wire.setMaterial(copper);
        System.out.println(wire);
        System.out.printf("%s%n",String.valueOf(wire.getMass()));
    }
}
