  

/**---------------------------------------------------
 * Akdeniz University CSE122 Physics II Homework
 * @author: Yahya Efe Kuruçay
 * @since: 26.05.2024
 * Description: Homework
 * Score: ?
 * Website: https://efekurucay.com
*---------------------------------------------------*/


/***
 *    ███████ ███████ ███████   |    ███████ ███████ ███████ 
 *    ██      ██      ██        |    ██      ██      ██      
 *    █████   █████   █████     |    █████   █████   █████   
 *    ██      ██      ██        |    ██      ██      ██      
 *    ███████ ██      ███████   |    ███████ ██      ███████ 
 *                            
 *                            
 */



import java.util.Scanner;

public class capacitor {
    // epsilon (F/m)
    private static final double EPSILON_0 = 8.854e-12;

    // Kapasitans hesaplama
    public static double calculateCapacitance(double area, double separation) {
        double area_m2 = area * 1e-6; // mm^2'yi m^2'ye dönüştür
        double separation_m = separation * 1e-3; // mm'yi m'ye dönüştür
        double capacitance = (EPSILON_0 * area_m2) / separation_m;
        return capacitance * 1e12; // F'yi pF'ye dönüştür
    }

    // Üst plakada biriken yük yükü 
    public static double calculateCharge(double capacitance, double voltage) {
        return capacitance * voltage; // Yük (pC)
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter plate area (mm^2): ");
        double area = scanner.nextDouble();

        System.out.print("Enter separation (mm): ");
        double separation = scanner.nextDouble();

        System.out.print("Enter battery voltage (V): ");
        double voltage = scanner.nextDouble();

        // Kapasitansı hesapla
        double capacitance = calculateCapacitance(area, separation);

        // Üst plaka yükünü hesapla
        double charge = calculateCharge(capacitance, voltage);

        // Sonuçları ekrana yazdır
        System.out.printf("Capacitance: %.2f pF%n", capacitance);
        System.out.printf("Top Plate Charge: %.2f pC%n", charge);

        scanner.close();
    }
}

/***
 *              _____                    _____                    _____          
 *             /\    \                  /\    \                  /\    \         
 *            /::\    \                /::\    \                /::\    \        
 *           /::::\    \              /::::\    \              /::::\    \       
 *          /::::::\    \            /::::::\    \            /::::::\    \      
 *         /:::/\:::\    \          /:::/\:::\    \          /:::/\:::\    \     
 *        /:::/__\:::\    \        /:::/__\:::\    \        /:::/__\:::\    \    
 *       /::::\   \:::\    \      /::::\   \:::\    \      /::::\   \:::\    \   
 *      /::::::\   \:::\    \    /::::::\   \:::\    \    /::::::\   \:::\    \  
 *     /:::/\:::\   \:::\    \  /:::/\:::\   \:::\    \  /:::/\:::\   \:::\    \ 
 *    /:::/__\:::\   \:::\____\/:::/  \:::\   \:::\____\/:::/__\:::\   \:::\____\
 *    \:::\   \:::\   \::/    /\::/    \:::\   \::/    /\:::\   \:::\   \::/    /
 *     \:::\   \:::\   \/____/  \/____/ \:::\   \/____/  \:::\   \:::\   \/____/ 
 *      \:::\   \:::\    \               \:::\    \       \:::\   \:::\    \     
 *       \:::\   \:::\____\               \:::\____\       \:::\   \:::\____\    
 *        \:::\   \::/    /                \::/    /        \:::\   \::/    /    
 *         \:::\   \/____/                  \/____/          \:::\   \/____/     
 *          \:::\    \                                        \:::\    \         
 *           \:::\____\                                        \:::\____\        
 *            \::/    /                                         \::/    /        
 *             \/____/                                           \/____/         
 *                                                                               
 */

/*
 *            __     _                                                          
 *           / _|   | |                                                         
 *       ___| |_ ___| | ___   _ _ __ _   _  ___ __ _ _   _   ___ ___  _ __ ___  
 *      / _ \  _/ _ \ |/ / | | | '__| | | |/ __/ _` | | | | / __/ _ \| '_ ` _ \ 
 *     |  __/ ||  __/   <| |_| | |  | |_| | (_| (_| | |_| || (_| (_) | | | | | |
 *      \___|_| \___|_|\_\\__,_|_|   \__,_|\___\__,_|\__, (_)___\___/|_| |_| |_|
 *                                                    __/ |                     
 *                                                   |___/                      
 */
