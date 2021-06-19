import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadCustomerData {
	public static void main(String[] args) {
		BufferedReader reader;
    ArrayList<Customer> customers = new ArrayList<Customer>();
		try {
			reader = new BufferedReader(new FileReader("customers.txt"));
			String line = reader.readLine();
			while (line != null) {
        // System.out.println(line);
        String[] customerInfos = line.split("/");
        // Create customer
        Customer customer = new Customer(customerInfos[0], customerInfos[1], customerInfos[2], customerInfos[3], customerInfos[4], customerInfos[5]);

        customers.add(customer);
				// read next line
				line = reader.readLine();
			}
			reader.close();
      System.out.println(customers);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}
}
