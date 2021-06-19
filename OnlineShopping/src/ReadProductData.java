import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadProductData {
	public static void main(String[] args) {
		BufferedReader reader;
    ArrayList<Product> products = new ArrayList<Product>();
		try {
			reader = new BufferedReader(new FileReader("products.txt"));
			String line = reader.readLine();
			while (line != null) {
        // System.out.println(line);
        String[] productInfos = line.split("/");
        // Create product
        Product product = new Product(productInfos[0], productInfos[1], productInfos[2], productInfos[3], productInfos[4], productInfos[5]);
        products.add(product);
				// read next line
				line = reader.readLine();
			}
			reader.close();
      System.out.println(products);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
