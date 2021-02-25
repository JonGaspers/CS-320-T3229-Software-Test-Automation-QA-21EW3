/*
 * Author Name: Jonathon Gaspers
 * Date: January 23, 2021
 * CourseID: CS-320-T3229
 * Description: This is the Contact object class to hold each contacts information within the Contact Object list in 
 * ContactService.
 */

import java.lang.IllegalArgumentException;

public class Contact {
	//set contact info to private so getters/setters are used to edit
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String address;
	
	public Contact (String contactID, String firstName, String lastName, String phoneNum, String address) {
		//validate the input, if the input is invalid, throw illegal arugment exception and alert user about what was wrong.
		if (contactID.length() > 10 || contactID == null) {
			throw new IllegalArgumentException("Invalid Contact ID, Contact ID must be below 10 characters in length.");
		}
		if (firstName.length() > 10 || firstName == null) {
			throw new IllegalArgumentException("Invalid first name, first name must be below 10 characters in length.");
		}
		if (lastName.length() > 10 || lastName == null) {
			throw new IllegalArgumentException("Invalid last name, last name must be below 10 characters in length.");
		}
		if (phoneNum.length() != 10 || phoneNum == null) {
			throw new IllegalArgumentException("Invalid phone number, phone numbers have to be exactly 10 characters in length.");			
		}
		if (address.length() > 30 || address == null) {
			throw new IllegalArgumentException("Invalid address, address cannot be longer than 30 characters in length.");
		}
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.address = address;
	}

	
	/*
	 * Getters and setters for the contact variables (first name, last name, contact ID, address, phone number)
	 */
	public String getContactID() {
		return contactID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setContactID(String contactID) {
		this.contactID = contactID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void setAddress(String address) {
		this.address = address;
	}	
}
