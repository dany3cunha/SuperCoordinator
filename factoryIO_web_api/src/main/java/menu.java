import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class menu {
    public static void main(String[] args) {

        ArrayList<sim_object> sim_elements = new ArrayList<>();

        int selection = 0;
        Scanner input = new Scanner(System.in);
        while (selection != 4) {
            System.out.println("-------------------------------\n");
            System.out.println("1 - List all simulation elements");
            System.out.println("2 - Turn on/off the emitter of the entry conveyor");
            System.out.println("3 - Turn on/off the remover of the exit conveyor");
            System.out.println("4 - Exit program");

            selection = input.nextInt();
            String value;
            switch (selection) {
                case 1:
                    // get all elements of simulation environment
                    jsonReader.getSimulationElements(sim_elements);
                    // print in the console
                    for (sim_object obj : sim_elements) {
                        System.out.println(obj.toString());
                    }
                    break;
                case 2:
                    value = Objects.requireNonNull(jsonReader.getElementStatus("Emitter 0")).toLowerCase();
                    if (value.equals("false")) {
                        System.out.println("Emitter 0: ON");
                        jsonReader.setElement("Emitter 0", "true");
                    } else {
                        System.out.println("Emitter 0: OFF");
                        jsonReader.setElement("Emitter 0", "false");
                    }
                    break;
                case 3:
                    value = Objects.requireNonNull(jsonReader.getElementStatus("Remover 0")).toLowerCase();
                    if (value.equals("false")) {
                        System.out.println("Remover 0: ON");
                        jsonReader.setElement("Remover 0", "true");
                    } else {
                        System.out.println("Remover 0: OFF");
                        jsonReader.setElement("Remover 0", "false");
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
