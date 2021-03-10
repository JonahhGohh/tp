package seedu.address.testutil;

import seedu.address.model.student.Address;
import seedu.address.model.student.Email;
import seedu.address.model.student.Name;
import seedu.address.model.student.Phone;
import seedu.address.model.student.Student;

/**
 * A utility class to help with building Student objects.
 */
public class StudentBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_STUDY_LEVEL = "Sec 5";
    public static final String DEFAULT_GUARDIAN_PHONE = "33333333";
    public static final String DEFAULT_RELATIONSHIP = "Mother";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private String studyLevel;
    private Phone guardianPhone;
    private String relationship;

    /**
     * Creates a {@code StudentBuilder} with the default details.
     */
    public StudentBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        studyLevel = DEFAULT_STUDY_LEVEL;
        guardianPhone = new Phone(DEFAULT_GUARDIAN_PHONE);
        relationship = DEFAULT_RELATIONSHIP;
    }

    /**
     * Initializes the StudentBuilder with the data of {@code studentToCopy}.
     */
    public StudentBuilder(Student studentToCopy) {
        name = studentToCopy.getName();
        phone = studentToCopy.getPhone();
        email = studentToCopy.getEmail();
        address = studentToCopy.getAddress();
        studyLevel = studentToCopy.getStudyLevel();
        guardianPhone = studentToCopy.getGuardianPhone();
        relationship = studentToCopy.getRelationship();
    }

    /**
     * Sets the {@code Name} of the {@code Student} that we are building.
     */
    public StudentBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Student} that we are building.
     */
    public StudentBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Student} that we are building.
     */
    public StudentBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Student} that we are building.
     */
    public StudentBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code studyLevel} of the {@code Student} that we are building.
     */
    public StudentBuilder withStudyLevel(String studyLevel) {
        this.studyLevel = studyLevel;
        return this;
    }

    /**
     * Sets the {@code guardianPhone} of the {@code Student} that we are building.
     */
    public StudentBuilder withGuardianPhone(String guardianPhone) {
        this.guardianPhone = new Phone(guardianPhone);
        return this;
    }

    /**
     * Sets the {@code relationship} of the {@code Student} that we are building.
     */
    public StudentBuilder withRelationship(String relationship) {
        this.relationship = relationship;
        return this;
    }

    public Student build() {
        return new Student(name, phone, email, address, studyLevel, guardianPhone, relationship);
    }

}