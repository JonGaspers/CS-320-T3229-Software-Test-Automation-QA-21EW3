/*
 * Author Name: Jonathon Gaspers
 * Date: January 23, 2021
 * CourseID: CS-320-T3229
 * Description: This is the JUnit unit test case for the ContactService class. This will test
 * adding a single contact, adding multiple contacts, check if an error occurs when attempting to
 * add an already existing contact, test updating a contact, and test deleting a contact.
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
	//Create instance of ContactService
	ContactService cs = new ContactService();
	
	/*
	 * Test to see if adding a single contact works.
	 * Expected: Pass
	 * Expected Result Reason: Successfully added a contact. 
	 */
	@Test
	void ContactServiceAddSingleContactTest() {
		Contact contact1 = new Contact("001", "Josh", "Orr", "9315551234", "Montana");
		assertEquals(true, cs.addContact(contact1));
	}
	/*
	 * Test to see if adding multiple contacts works.
	 * Expected: Pass
	 * Expected Result Reason: Successfully added multiple contacts.
	 */
	@Test
	void ContactServiceAddMultipleContactTest() {
		Contact contact1 = new Contact("001", "Josh", "Orr", "9315551234", "Montana");
		Contact contact2 = new Contact("002", "Jeffrey", "Grandin", "9315551233", "Canada");
		assertEquals(true, cs.addContact(contact1));
		assertEquals(true, cs.addContact(contact2));		
	}
	/*
	 * Test to see if adding an already existing contact fails.
	 * Expected: Pass
	 * Expected Result Reason: Attempting to add a contact that already exists returns false, tested for false so test should pass.
	 */
	@Test
	void ContactServiceAddSameContactTest() {
		Contact c1 = new Contact("001", "Sara", "C.", "4315551234", "Japan");
		assertEquals(true, cs.addContact(c1));
		assertEquals(false, cs.addContact(c1));
	}
	/*
	 * Test to see if updating a contact is successful.
	 * Expected: Pass
	 * Expected Result Reason: Updated contact successfully.
	 */
	@Test
	void ContactServiceUpdateContactTest() {
		Contact contact1 = new Contact("001", "Kurtis", "Earwood", "5558675309", "California");
		assertEquals(true, cs.addContact(contact1));
		assertEquals(true, cs.UpdateContact("001", "Kurtis", "Earwood", "5551231234", "Address"));
	}
	/*
	 * Test to see if deleting a contact is successful.
	 * Expected: Pass
	 * Expected Result Reason: Deleted contact Successfully
	 */
	@Test
	void ContactServiceDeleteContactTest() {
		Contact contact1 = new Contact("001", "Jon", "Gaspers", "0123456789", "Florida");
		cs.addContact(contact1);
		assertEquals(true, cs.deleteContact("001"));
	}
}
