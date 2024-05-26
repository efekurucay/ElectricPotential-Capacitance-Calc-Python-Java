  

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

public class electric_potential {
    public static void main(String[] args) {
        // Öğrenci numarası ve yük hesaplamaları
        int studentId = 20808005; // Öğrenci numaranızı buraya girin
        double charge = (studentId % 10) * 1e-9; // nC cinsinden yük
        double epsilon_0 = 8.85e-12; // C^2/(N·m^2)

        // Matris boyutu ve hücre uzunluğu
        int matrixSize = 10;
        double cellLength = 0.1; // metre

        // Potansiyel matrisi oluşturma
        double[][] potentialMatrix = new double[matrixSize][matrixSize];

        // Potansiyel hesaplama fonksiyonu
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                double x = i * cellLength;
                double y = j * cellLength;
                potentialMatrix[i][j] = calculatePotential(charge, x, y, epsilon_0);
            }
        }

        // Potansiyel matrisini yazdırma
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                System.out.printf("%.2e ", potentialMatrix[i][j]);
            }
            System.out.println();
        }
    }

    public static double calculatePotential(double q, double x, double y, double epsilon_0) {
        double r = Math.sqrt(x * x + y * y);
        if (r == 0) {
            return Double.POSITIVE_INFINITY; // Sonsuz potansiyel
        }
        return q / (4 * Math.PI * epsilon_0 * r);
    }
}
