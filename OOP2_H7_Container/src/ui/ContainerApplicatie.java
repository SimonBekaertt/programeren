package ui;

import domein.Container;
import domein.ContainerEigenaarCompare;
import domein.ContainerMassaCompare;
import java.util.Arrays;

public class ContainerApplicatie {

    public static void main(String[] args) {
        Container[] containers = new Container[4];
        
        containers[0] = new Container("Antwerpen", 60, 150, 1234);
        containers[1] = new Container("Rotterdam", 70, 110, 2568);
        containers[2] = new Container("Calais", 80, 90, 8569);
        containers[3] = new Container("Brugge", 70, 100, 8564);
                
        Arrays.sort(containers);

        System.out.printf("Containers bij natuurlijk sorteren: %n");
        for (Container container : containers) {
            System.out.printf("%dm² - %s - %dkg%n", 
                    container.getVolume(),
                    container.getEigenaar(),
                    container.getMassa());
        }

        System.out.printf("%nContainers bij sorteren op massa: %n");
        ContainerMassaCompare massaCompare = new ContainerMassaCompare();
        Arrays.sort(containers, massaCompare);
        for (Container container : containers) {
            System.out.printf("%dkg - %s - %dm²%n",
                     container.getMassa(),
                     container.getEigenaar(),
                     container.getVolume());
        }

        System.out.printf("%nContainers bij sorteren op eigenaar: %n");
        ContainerEigenaarCompare eigenaarCompare = new ContainerEigenaarCompare();
        Arrays.sort(containers, eigenaarCompare);
        for (Container container : containers) {
            System.out.printf("%s - %dm² - %dkg%n",
                    container.getEigenaar(),
                    container.getVolume(),
                    container.getMassa());
        }
        
        Container nieuweContainer = new Container("Antwerpen", 70, 75, 8564);
        boolean isReedsToegevoegd = false;
        
        for (Container container : containers) {
            if (container.equals(nieuweContainer))
            {
                isReedsToegevoegd = true;
                break;
            }
        }
        
        System.out.printf("%n%s%n",
                isReedsToegevoegd ? 
                        "Fout: De container werd reeds toegevoegd aan de array."
                        :
                        "De container is nog niet toegevoegd aan de array.");
    }
}