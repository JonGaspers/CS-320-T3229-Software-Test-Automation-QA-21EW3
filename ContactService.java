/*
 * Author Name: 
 * Date: January 23, 2021
 * CourseID: CS-320-T3229
 * Description: This is the main service class for the ContactService application. The ContactService allows for 
 * adding new contacts, updating current contacts, and removing contacts.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactService {
	
	public List<Contact> list;
	/*
	 * ContactService constructor
	 */
	public ContactService() { 
		list = new ArrayList<Contact>();
	}
	/*
	 * Adds contact based on contactId
	 * If contact exists: return false
	 * if contact !exists: add contact, return true
	 */
	public boolean addContact(Contact contact) {
		boolean exists = false;
		for (Contact element : list) { //search list of contacts to see if contact already exists.
			if (element.equals(contact)) {
				exists = true;
			}
		}
		if (!exists) { //contact does not exist, add contact, return true
			list.add(contact);
			System.out.println("Contact added.");
			return true;
		}
		else { //contact already exists, return false
			System.out.println("Contact already exists.");
			return false;
		}
	}
	/*
	 * Deletes contact based on contactId
	 * If contact found: Delete contact, return true
	 * If contact !found: return false
	 */
	public boolean deleteContact(String contactId) {
		for (Contact contact : list) { //search list 
			if (contact.getContactID().equals(contactId)) { //if contact in list delete it, return true
				list.remove(contact);
				return true;
			}
		}
		return false;
	}
	/*
	 * Updates contact based on contactId
	 * If contact found: Update contact, return true
	 * If contact !found: Failed to update contact, return false
	 */
	public boolean UpdateContact(String contactId, String firstName, String lastName, String phoneNum, String address) {
		for (Contact contact : list) {
			if (contact.getContactID().equals(contactId)) {
				if(!(firstName.length() > 10 && firstName != null)) {
					contact.setFirstName(firstName);
				}
				if (!(lastName.length() > 10 && lastName != null)) {
					contact.setLastName(lastName);
				}
				if ((phoneNum.length() == 10) && phoneNum != null) {
					contact.setPhoneNum(phoneNum);
				}
				if (!(address.length() > 30) && address != null) {
					contact.setAddress(address);
				}
				return true; //contact updated successfully
			}
			else { System.out.print("Contact ID could not be found."); return false;} //contact couldn't be found, failed to update
		}
		return false; //failed to update
	}

	
	public static void main(String[] args) {
		ContactService cs = new ContactService();
		Scanner sc = new Scanner(System.in);
		int i = 0; //generic loop condition
		String userIn = "";
		while(i == 0) { //main program loop
			System.out.println("Commands:");
			System.out.println("\"add\" to add contact");
			System.out.println("\"update\" to update contact");
			System.out.println("\"delete\" to remove a contact");
			System.out.println("\"exit\" to exit the program");
			System.out.println("Enter command: ");
			userIn = sc.nextLine();
			if(userIn.equals("add")) { //show add contact menu
				System.out.println("Enter Contact ID (Must be unique and less than 10 characters): ");
				String contactID = sc.nextLine();
				System.out.println("Enter First Name: ");
				String firstName = sc.nextLine();
				System.out.println("Enter Last Name");
				String lastName = sc.nextLine();
				System.out.println("Enter phone number (must be 10 characters): ");
				String phoneNum = sc.nextLine();
				System.out.println("Enter address (Less than 30 characters): ");
				String address = sc.nextLine();
				cs.addContact(new Contact(contactID, firstName, lastName, phoneNum, address)); //add new contact
				//System.out.println("Contact added.");
			}
			if (userIn.equals("update")) { //Show update contact menu
				String searchID = "";
				System.out.println("Enter the contact ID for the contact to be updated: ");
				searchID = sc.nextLine();
				for (Contact contact : cs.list) {
					if (contact.getContactID().equals(searchID)) { //contact exists
						String contactID = contact.getContactID();
						String firstName = contact.getFirstName();
						String lastName = contact.getLastName();
						String phoneNum = contact.getPhoneNum();
						String address = contact.getAddress();
						System.out.println("Found Contact with ID(" + contactID + ") Contact details:"); //Display contact info
						System.out.println("First Name: " + firstName);
						System.out.println("Last Name: " + lastName);
						System.out.println("Phone Number: " + phoneNum);
						System.out.println("Address: " + address);
						System.out.println("Enter term to update(first, last, number, address): "); 
						userIn = sc.nextLine(); // get input to find which item to update
						if (userIn.equals("first")) {
							System.out.println("Enter new First Name: ");
							firstName = sc.nextLine();
							cs.UpdateContact(contactID, firstName, lastName, phoneNum, address);
							System.out.println("Contact Updated!");
						} else if (userIn.equals("last")) {
							System.out.println("Enter new Last Name: ");
							lastName = sc.nextLine();
							cs.UpdateContact(contactID, firstName, lastName, phoneNum, address);
							System.out.println("Contact Updated!");
						} else if (userIn.equals("number")) {
							System.out.println("Enter a new number: ");
							phoneNum = sc.nextLine();
							cs.UpdateContact(contactID, firstName, lastName, phoneNum, address);
							System.out.println("Contact Updated!");
						} else if (userIn.equals("address")) {
							System.out.println("Enter a new address: ");
							address = sc.nextLine();
							cs.UpdateContact(contactID, firstName, lastName, phoneNum, address);
							System.out.println("Contact Updated!");
						}
					}
				}
			} else if (userIn.equals("delete")) { //Menu for deleting contact
				System.out.println("Enter contact ID of the contact to be removed: ");
				String contactId = sc.nextLine();
				for (Contact contact : cs.list) {
					if (contact.getContactID().equals(contactId)) {
						cs.deleteContact(contactId);
						System.out.println("Contact deleted!");
					} else {
						System.out.println("Contact could not be found.");
						break;
					}
				}
			} else if (userIn.equals("exit")) { //exit main program loop
				i = 1;
			}
		}
		sc.close(); //close scanner
	}

}
