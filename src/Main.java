import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int M20 = 0;
        int M50 = 0;
        int M100 = 0;
        int M200 = 0;
        int M500 = 0;
        int opcion;

        do {
            System.out.println("--- Menú de la Alcancía ---");
            System.out.println(" Esta alcancia recibe monedas de $20,50,$100,$200 o $500");
            System.out.println("1. Agregar monedas");
            System.out.println("2. Contar monedas");
            System.out.println("3. Calcular total");
            System.out.println("4. Romper alcancía");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion){
                //especificar moneda
                case 1: //agregar una moneda de una de las denominaciones indicadas,
                    System.out.println("Ingrese una moneda($20,50,$100,$200 o $500 según corresponda): ");
                    int moneda = scanner.nextInt();
                    if(moneda ==20) {
                        M20++;
                    }else if (moneda== 50){
                        M50++;
                    } else if (moneda==100) {
                        M100++;
                    } else if (moneda==200) {
                        M200++;
                    } else if (moneda==500) {
                        M500++;
                    }else{
                        System.out.println("Error en la denominación");
                    }
                    break;

                case 2: //contar cuántas monedas tiene de cada denominación
                    System.out.println("#  monedas por valor: ");
                    System.out.println("20="+M20);
                    System.out.println("50="+M50);
                    System.out.println("100="+M100);
                    System.out.println("200=" +M200);
                    System.out.println("500="+M500);
                    break;

                case 3: //calcular el total de dinero ahorrado
                    int total=M20*20+M50*50+M100*100+M200*200+M500*500;
                    System.out.println("El valor ahorrado es = " + total);

                case 4: //romper la alcancía vaciando su contenido
                    int romper_alcancia =M20*20+M50*50+M100*100+M200*200+M500*500;
                    System.out.println("Se ha ahorrado: ");
                    System.out.println("20="+M20);
                    System.out.println("50="+M50);
                    System.out.println("100="+M100);
                    System.out.println("200="+M200);
                    System.out.println("500="+M500);
                    System.out.println("Total ahorrado: $" + romper_alcancia);
                    break;

            }
        }while (opcion !=0);
        scanner.close();
    }
}