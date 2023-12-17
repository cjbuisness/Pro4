import java.util.ArrayList;
import java.util.List;

/*
* profile class creates & manages profiles
* Utilized by ProfileManager
*/

public class Profile {

	/*
	* methods to:
	* return name, status, and friend proilfes
	* set/add profile & friends
	*/

    private String name;
    private String status;
    private List<Profile> friendProfiles;

    public Profile(String name, String status) {
        this.name = name;
        this.status = status;
        this.friendProfiles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addFriend(Profile friend) {
        friendProfiles.add(friend);
    }

    public List<Profile> getFriendProfiles() {
        return new ArrayList<>(friendProfiles);
    }
}
