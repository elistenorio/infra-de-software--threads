import java.util.Scanner;

public class Main {

    static boolean pausaBateria = true;

    public static void main(String[] args) {


        Thread bateria = new Thread(() -> {

            while(true){

                if(pausaBateria){

                    try{
                        Thread.sleep(100);
                    } catch (InterruptedException e){
                        return;
                    }

                } else{

                    System.out.println("Bateria tocando");

                    try{
                        Thread.sleep(500);
                    } catch (InterruptedException e){
                        return;
                    }

                }

            }
        });


        bateria.start();

        Scanner scanner = new Scanner(System.in);


        while(true){

            String status = scanner.nextLine();

            if(status.equals("tocar")){
                pausaBateria = false;
            }

            else if (status.equals("pausar")){
                pausaBateria = true;
            }

            else if (status.equals("interromper")){
                bateria.interrupt();
                break;
            }

        }




    }
}