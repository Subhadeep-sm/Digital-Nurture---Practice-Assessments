import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return "ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class EcommerceSearch {

    // Linear Search
    public static int linearSearch(Product[] products, String name) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }


    public static void sortProductsByName(Product[] products) {
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
    }

    // Binary Search
    public static int binarySearch(Product[] products, String name) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int result = name.compareToIgnoreCase(products[mid].productName);
            if (result == 0) return mid;
            else if (result < 0) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Product " + (i + 1) + ":");
            System.out.print("Product ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Product Name: ");
            String name = sc.nextLine();
            System.out.print("Category: ");
            String category = sc.nextLine();

            products[i] = new Product(id, name, category);
        }

   
        System.out.print("\nEnter product name to search: ");
        String searchName = sc.nextLine();

        // Linear Search
        int indexLinear = linearSearch(products, searchName);
        if (indexLinear != -1)
            System.out.println("Linear Search: Product found - " + products[indexLinear]);
        else
            System.out.println("Linear Search: Product not found");


        sortProductsByName(products);

        // Binary Search
        int indexBinary = binarySearch(products, searchName);
        if (indexBinary != -1)
            System.out.println("Binary Search: Product found - " + products[indexBinary]);
        else
            System.out.println("Binary Search: Product not found");

        sc.close();
    }
}
