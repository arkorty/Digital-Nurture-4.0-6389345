public class Main {
    public static void main(String[] args) {
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB", "1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .setOperatingSystem("Windows 11")
                .build();

        Computer officeComputer = new Computer.Builder("Intel i5", "16GB", "512GB SSD")
                .setOperatingSystem("Ubuntu 22.04")
                .build();

        System.out.println("Gaming PC: " + gamingComputer);
        System.out.println("Office PC: " + officeComputer);
    }
} 
