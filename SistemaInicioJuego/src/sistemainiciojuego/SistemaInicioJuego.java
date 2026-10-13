package sistemainiciojuego;

import java.util.Scanner;

public class SistemaInicioJuego {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int totalJugadores = 5; 
        int votosListos = 0;
        boolean partidaIniciada = false;
        
        System.out.println("-SISTEMA DE SALA DE ESPERA-");
        System.out.println("Jugadores conectados: " + totalJugadores);
        
        while (!partidaIniciada) {
            System.out.println("\n-Acciones Disponibles-");
            System.out.println("1. (Usuario) Presionar botón para solicitar inicio de partida");
            System.out.println("2. (Usuario Admin) Iniciar partida manualmente");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    votosListos++;
                    System.out.println("\n[Usuario] Has solicitado que la partida comience.");
                    System.out.println("[Servidor -> Admin] (AVISO VISUAL) Un jugador más está listo. (" + votosListos + "/" + totalJugadores + " votos)");
                    
                    if (votosListos > totalJugadores / 2) {
                        System.out.println("[Servidor] Se ha alcanzado la mayoría de votos de los jugadores.");
                        System.out.println("-LA PARTIDA INICIA AUTOMÁTICAMENTE-");
                        partidaIniciada = true;
                    }
                    break;
                    
                case 2:
                    System.out.println("\n[Admin] Intentando iniciar la partida...");
                    
                    if (votosListos > totalJugadores / 2) {
                        System.out.println("-LA PARTIDA INICIA (Decisión manual del Admin con mayoría)-");
                        partidaIniciada = true;
                    } else {
                        System.out.println("[Servidor] ADVERTENCIA: La mayoría de los jugadores aún no ha solicitado comenzar.");
                        System.out.print("[Servidor] ¿Está seguro de iniciar la partida? (S/N): ");
                        String confirmacion = scanner.next();
                        
                        if (confirmacion.equalsIgnoreCase("S")) {
                            System.out.println(">> LA PARTIDA INICIA (Decisión forzada del Admin) <<");
                            partidaIniciada = true;
                        } else {
                            System.out.println("[Sistema] Acción cancelada. Permaneciendo en la sala de espera.");
                        }
                    }
                    break;
                    
                case 3:
                    System.out.println("Saliendo del simulador...");
                    return;
                    
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
        
        System.out.println("\nJUEGO EN PROGRESO");
        scanner.close();
    }
}