
/*
 * Author Name: Jonathon Gaspers
 * Date: January 23, 2021
 * CourseID: CS-320-T3229
 * Description: This is the Junit unit test case for Contact.java. This will test creating a new contact,
 * creating a contact with an ID that is too long, creating a contact with first or last name's too long, 
 * creating a contact with a phone number that is not exactly 10 characters, and creating a contact with
 * an address that is over 30 characters in length. As when creating a new contact object, if any of the parameters
 * are invalid, it will throw an IllegalArgumentException, these tests will fail due to those errors.
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactTest {
	
	/*
	 * Test the creation of a contact object
	 * Expected Result: Pass
	 * Expected Result Reason: All parameters for the Contact constructor are valid.
	 */
	@Test
	void CreateContactObjectTest() {
		Contact contact = new Contact("0000000001", "Jon", "Toucan", "0123456789", "This is an address");
		assertTrue(contact instanceof Contact);
	}
	
	/* 
	 * Test if the given ContactID will throw an error if the ID is greater than 10 characters in length.
	 * Expected: Error
	 * Expected Result Reason: Failed due to "IllegalArgumentException" error from the ID being longer than 10 characters.
	 */
	@Test
	void ContactIDLengthTest() {
		Contact contactIDTest = new Contact("01234567890", "Name", "LastName", "0123456789", "This is an address");
		assertFalse(contactIDTest instanceof Contact);
	}
	
	/*
	 * Test if the given ContactID will throw an error if the ID is null.
	 * Expected: Error
	 * Expected Result Reason: Failed due to "IllegalArgumentException" error from the ID being null.
	 */
	@Test
	void ContactIDNullTest() {
		Contact contactIDTestNull = new Contact(null, "name", "LastName", "0123456789", "This is an address");
		assertFalse(contactIDTestNull instanceof Contact);
	}
	
	/*
	 * Test if the given First Name will throw an error if it is larger than 10 characters.
	 * Expected: Error
	 * Expected Result Reason: Failed due to "IllegalArgumentException" error from the name being longer than 10 characters.
	 */
	@Test
	void ContactFirstNameLengthTest() {
		Contact contactFirstNameTest = new Contact("0123456789", "This Name is longer than 10", "LastName", "0123456789", "This is an address");
		assertTrue(contactFirstNameTest instanceof Contact);
	}
	
	/*
	 * Test if the given First Name will throw an error if it is null.
	 * Expected: Error
	 * Expected Result Reason: Failed due to "IllegalArgumentException" error from the name being null.
	 */
	@Test
	void ContactFirstNameNullTest() {
		Contact contactFirstNameTestNull = new Contact("0123456789", null, "LastName", "0123456789", "This is an address");
		assertTrue(contactFirstNameTestNull instanceof Contact);
	}
	
	/*
	 * Test if the given Last Name will throw an error if it is larger than 10 characters.
	 * Expected: Error
	 * Expected Result Reason: Failed due to "IllegalArgumentException" error from the name being longer than 10 characters.
	 */
	@Test
	void ContactLastNameLengthTest() {
		Contact contactLastNameTest = new Contact("0123456789", "Jon", "This is longer than 10", "0123456789", "This is an address");
		assertTrue(contactLastNameTest instanceof Contact);
	}
	
	/*
	 * Test if the given Last Name will throw an error if it is null.
	 * Expected: Error
	 * Expected Result Reason: Failed due to "IllegalArgumentException" error from the name being null.
	 */
	@Test
	void ContactLastNameNullTest() {
		Contact contactLastNameTestNull = new Contact("0123456789", "Jon", null, "0123456789", "This is an address");
		assertTrue(contactLastNameTestNull instanceof Contact);
	}
	
	/*
	 * Test if the given phone number will throw an error if it is not exactly 10 characters in length.
	 * Expected: Error
	 * Expected Result Reason: Failed due to "IllegalArgumentException" error from the number not being exactly 10 characters.
	 */
	@Test
	void ContactPhoneNumberLengthTest() {
		Contact contactPhoneNumberTest = new Contact("0123456789", "Jon", "LastName", "0123456789101112", "This is an address");
		assertTrue(contactPhoneNumberTest instanceof Contact);
	}
	
	/*
	 * Test if the given phone number will throw an error if it is null.
	 * Expected: Error
	 * Expected Result Reason: Failed due to "IllegalArgumentException" error from the number being null.
	 */
	@Test
	void ContactPhoneNumberNullTest() {
		Contact contactPhoneNumberNullTest = new Contact("0123456789", "Jon", "LastName", null, "This is an address");
		assertTrue(contactPhoneNumberNullTest instanceof Contact);
	}
	
	/*
	 * Test if the given address will throw an error if it is larger than 30 characters.
	 * Expected: Error
	 * Expected Result Reason: Failed due to "IllegalArgumentException" error from the address being larger than 30 characters.
	 */
	@Test
	void ContactAddressLengthTest() {
		Contact contactAddressLengthTest = new Contact("01234566789", "Jon", "LastName", "0123456789", "This is longer than 30 characters in length.");
		assertTrue(contactAddressLengthTest instanceof Contact);
	}
	
	/*
	 * Test if the given address will throw an error if it is null.
	 * Expected: Error
	 * Expected Result Reason: Failed due to "IllegalArgumentException" error from the address being null.
	 */
	@Test
	void ContactAddressNullTest() {
		Contact contactAddressNullTest = new Contact("0123456789", "Jon", "LastName", "0123456789", null);
		assertTrue(contactAddressNullTest instanceof Contact);
	}
}
