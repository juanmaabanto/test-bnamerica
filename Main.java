import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //printNumbers();

        //System.out.println(isAnagram("RIESGO", "SERGIO"));
        //System.out.println(isAnagram("RIESGO", "SERPIO"));

        //int arr[]={60,50,10,15,80,45};
        //bubbleSorter(arr);

        consumerAPI();
    }

    public static void consumerAPI() {
        String apiUrl = "https://feriados-cl-api.herokuapp.com/feriados ";
        String dbUrl = "";
        String dbUser = "";
        String dbPassword = "";

        // Esta clase realizara el consumo de la api
        HttpService httpService = new HttpService();
        // Esta clase es para guardar en la bd
        DataBase dataBase = new DataBase(dbUrl, dbUser, dbPassword);

        try {
            // obtenemos la información de la api
            String response = httpService.fetch(apiUrl);
            System.out.println(response);

            // Guardar los datos en la base de datos
            dataBase.save(response);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void bubbleSorter(int[] arr) {
        Arrays.stream(arr).forEach(n -> System.out.print(n + " "));

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("\nsortered:");
        Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
    }

    public static Boolean isAnagram(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return false;
        }
        if (word1.length() != word2.length()) {
            return false;
        }

        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static void printNumbers() {
        for(int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}


