import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadProductData {
	

	public ArrayList<Product> readData() {
		BufferedReader reader;
		ArrayList<Product> products = new ArrayList<Product>();
		int num = 1;
		try {
			reader = new BufferedReader(new FileReader("products.txt"));
			String line = reader.readLine();

			while (line != null) {
				// Get infos from line
        String[] productInfos = line.split("/");
				// convert data type
				double price = Double.parseDouble(productInfos[4]);
				int stock = Integer.parseInt(productInfos[5]);
        // Create product
				
        Product product = new Product(productInfos[0], productInfos[1], productInfos[2], productInfos[3], price, stock);
        products.add(product);

				System.out.println("------ Product ["+ num +"] -------");
				System.out.println(product);
				System.out.println();
				num++;
				// read next line
				line = reader.readLine();
			}
			
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return products;

	}

}
