package au.com.autopark;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AutoParkApp {

	private static final char L= 'L';
	private static final char R = 'R';

	private static final String COMMANDS_REGEX = "([0-9]|1[0-4]),([0-9]|1[0-4]):([LRF]+)";

	private List<Location> locations = new ArrayList<Location>();

	public AutoParkApp(String input) throws Exception {
		trackLocations(input);
	}

	private void trackLocations(String input) throws Exception {
		Matcher matcher = Pattern.compile(COMMANDS_REGEX).matcher(input);

		if (!matcher.matches()) {
			throw new Exception("Invalid Command");
		}

		int vertical = Integer.parseInt(matcher.group(1));
		int horizontal = Integer.parseInt(matcher.group(2));

		Location startLocation = new Location(vertical, horizontal);

		locations.add(startLocation);

		Location currentLocation = new Location(startLocation);
		
		String commands = matcher.group(3);
		
		for (int i = 0; i < commands.length(); i++) {
	
			char command = commands.charAt(i);

			if (command == L) {
				currentLocation.left();
			} else if (command == R) {
				currentLocation.right();
			} else {
				currentLocation.forward();
			}
			locations.add(currentLocation);
		}
	}

		
	public Location getStartLocation() {
		return locations.get(0);
	}

	
	public Location getEndLocation() {
		return locations.get(locations.size() - 1);
	}

	
	public List<Location> getPositions() {
		return locations;
	}

	

}
