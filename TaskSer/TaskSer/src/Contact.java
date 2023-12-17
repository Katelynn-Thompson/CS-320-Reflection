public class Contact {
    private String contactID;    // length <= 10
    private String firstName;    // length <= 10
    private String lastName;     // length <= 10
    private String phoneNumber;  // length == 10
    private String address;      // length <= 30

    // Constructor with validation (as shown in the previous response)

    // Getters

    /**
     * Get the contact ID.
     * @return The contact ID.
     */
    public String getContactID() {
        return contactID;
    }

    /**
     * Get the first name.
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the last name.
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get the phone number.
     * @return The phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Get the address.
     * @return The address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Main method for testing.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        try {
            // Example usage
            Contact c = new Contact();

            // Print contact details
            System.out.println("Contact ID: " + c.getContactID());
            System.out.println("First Name: " + c.getFirstName());
            System.out.println("Last Name: " + c.getLastName());
            System.out.println("Phone Number: " + c.getPhoneNumber());
            System.out.println("Address: " + c.getAddress());
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating contact: " + e.getMessage());
        }
    }

	public Object setPhoneNumber(String string) {
		return null;
	}

	public void setLastName(String string) {
		
	}

	public void setAddress(String address2) {

		
	}

	public void setFirstName(String string) {

		
	}
}
