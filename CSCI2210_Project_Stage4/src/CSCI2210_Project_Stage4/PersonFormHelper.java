package CSCI2210_Project_Stage4;

/**
 * @author Jillian Stork
 * CSCI 2210 Project
 * Conference Management System
 * Person form helper
 * This class build the form fields for Person subclasses
 */
import javax.swing.*;

public class PersonFormHelper {
    public JTextField nameF, emailF, phoneF, addressF, bioF, orgF, jobF;

    public PersonFormHelper(String name, String email, String phone,
                            String address, String bio, String org, String job) {
        nameF    = new JTextField(name);
        emailF   = new JTextField(email);
        phoneF   = new JTextField(phone);
        addressF = new JTextField(address);
        bioF     = new JTextField(bio);
        orgF     = new JTextField(org);
        jobF     = new JTextField(job);
    }

    public PersonFormHelper() { this("","","","","","",""); }

    public Object[] getFields() {
        return new Object[]{
            "Name:", nameF, "Email:", emailF, "Phone:", phoneF,
            "Address:", addressF, "Biography:", bioF,
            "Organization:", orgF, "Job Title:", jobF
        };
    }
}
