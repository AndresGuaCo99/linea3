import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner =new Scanner(System.in);;

        int c1=0;   //candidato 1
        int c2=0;   //candidato 2
        int c3=0;   //candidato 3
        int costo_c1=0; //calcula el costo de campaña del candidato 1.
        int costo_c2=0; //calcula el costo de campaña del candidato 2.
        int costo_c3=0; //calcula el costo de campaña del candidato 3.
        int totalVotos=0; //calcula el total de votos de los candidatos.
        int voto =0;


        int opcion;

        do{
            System.out.println("\nElecciones del municipio Premier");
            System.out.println("1. Eleccion de candidato");
            System.out.println("2. Calcular costo de campaña por candidato");
            System.out.println("3. Vaciar urnas");
            System.out.println("4. Calcular total de votos");
            System.out.println("5. Porcentaje de votos por candidato");
            System.out.println("6. Costo promedio de campaña en las elecciones");
            System.out.println("7. Salir");
            System.out.print("\nIngrese una opción: ");
            opcion =scanner.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Candidatos\n1. Candidato 1 \n2. Candidato 2\n3. Candidato 3");
                    System.out.print("Elija un candidato = ");
                    int candidato = scanner.nextInt();

                    if (candidato == 1){
                        System.out.println("Usted ha elegido al candidato 1");
                        c1++;
                    } else if (candidato == 2) {
                        System.out.println("Usted ha elegido al candidato 2");
                        c2++;
                    } else if (candidato == 3) {
                        System.out.println("Usted ha elegido al candidato 3 ");
                        c3++;
                    }else {
                        System.out.println("Opción no valida");
            }
                    totalVotos++;
                break;

                case 2: //Calcular el costo de campaña de un candidato dependiendo de la influencia publicitaria de cada voto.

                    System.out.println("Candidatos");
                    System.out.print("Digite 1, 2 o 3 según corresponda: ");
                    System.out.println("\n1. candidato 1 \n2. Candidato 2 \n3. Candidato 3");
                    System.out.print("Seleccione el candidato: ");
                    candidato = scanner.nextInt();

                    if(candidato >=1 && candidato <=3 ){
                        System.out.println(" Influencia en campaña ");
                        System.out.println("\nDigite 1, 2 o 3 según corresponda: ");
                        System.out.println("1. Internet ");
                        System.out.println("2. Radio");
                        System.out.println("3. TV");
                        System.out.print("\nDigite una opción : ");

                        int campaña = scanner.nextInt();

                        switch (campaña){
                            case 1:
                                voto=700000;
                                break;
                            case 2:
                                voto=200000;
                                break;
                            case 3:
                                voto=600000;
                                break;
                            default:
                                System.out.println("opción invalida");
                                break;
                        }
                        if (candidato == 1){
                            costo_c1 += voto;
                            System.out.println("El costo de campaña para el candidato 1 es: " +costo_c1 );
                        } else if (candidato == 2) {
                            costo_c2 += voto;
                            System.out.println("El costo de campaña para el candidato 2 es: "+costo_c2);
                        }else {
                            costo_c3 += voto;
                            System.out.println("El costo de campaña para el candidato 3 es: "+costo_c3);
                        }
                        break;
                    }
                case 3: //Vaciar todas las urnas de la votación.
                    c1=0;c2=0;c3=0;
                    costo_c1=0;costo_c2=0;costo_c3=0;
                    totalVotos=0;
                    System.out.println("Las urnas han sido vaciadas");
                    break;

                case 4: //Conocer el número total de votos.
                    System.out.println("El total de votos en esta campaña es: "+totalVotos);
                    break;

                case 5: //Porcentaje de votos obtenidos por cada candidato.
                    if(totalVotos>0){
                        double porcentajeC1 = c1/ totalVotos*100;
                        double porcentajeC2 = c2/ totalVotos*100;
                        double porcentajeC3 = c3/ totalVotos*100;
                        System.out.println("El porcentaje del candidato 1 es : " +porcentajeC1+"%");
                        System.out.println("El porcentaje del candidato 2 es : " +porcentajeC2+"%");
                        System.out.println("El porcentaje del candidato 3 es : " +porcentajeC3+"%");
                    }else{
                    }
                    break;

                case 6: //Costo promedio de campaña en las elecciones.
                    int costopromcamp = costo_c1+costo_c2+costo_c3;

                    double costoprom = costopromcamp / totalVotos;
                    System.out.println("El costo promedio de la campaña es: "+costoprom);

                case 7:
                    System.out.println("Saliendo de la aplicación");
                    break;
            }
        }while (opcion != 7);
        scanner.close();
    }
}