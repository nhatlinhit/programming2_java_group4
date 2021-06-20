import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadUserData {

	public ArrayList<User> readUserData() {
		BufferedReader reader;
		ArrayList<User> users = new ArrayList<User>();
		int num = 1;
		try {
			reader = new BufferedReader(new FileReader("usersData.txt"));
			String line = reader.readLine();

			while (line != null) {
				// Get infos from line
        String[] userInfos = line.split("/");
        // Create User
				
        User user = new User(userInfos[0], userInfos[1], userInfos[2], userInfos[3], userInfos[4], userInfos[5], userInfos[6], userInfos[7]);
        users.add(user);
        
				num += 1;
				// read next line
				line = reader.readLine();
			}
			
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return users;

	}

}
