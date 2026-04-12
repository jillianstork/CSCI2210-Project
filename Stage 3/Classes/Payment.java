/**
 * Class description.
 * @author Maya L. Garcia Schafer
 * Created on 04/09/2026
 */

public class Payment {

    private Registration registration;
    private double amountPaid;
    private String payMethod;
    private String datePaid;
    private String status;

    /**
     * Constructor to initialize registrationId, amount paid,
     * pay method, date paid, and status.
     * @param registration Registration the registration id
     * @param amountPaid double the amount paid
     * @param payMethod String the pay method
     * @param datePaid String the date a payment was made
     * @param status String the status of the payment
     */
    public Payment(Registration registration, double amountPaid,
        String payMethod) {
        this.registration = registration;
        this.amountPaid = amountPaid;
        this.payMethod = payMethod;
        this.status = "Pending";
    }

    /**
     * Gets the amount paid.
     * @return amountPaid double the amount paid
     */
    public double getAmountPaid() {
        return amountPaid;
    }

    /**
     * Sets the amount paid.
     * @param amountPaid double the amount paid
     */
    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    /**
     * Gets the date paid.
     * @return datePaid String the day payment was made
     */
    public String getDatePaid() {
        return datePaid;
    }

    /**
     * Gets the payment method.
     * @return payMethod String the payment method.
     */
    public String getPayMethod() {
        return payMethod;
    }

    /**
     * Sets the payment method.
     * @param payMethod String the payment method
     */
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    /**
     * Gets the status of a payment.
     * @return status String the status of a payment
     */
    public String getStatus() {
        return status;
    }
    
    /**
     * Gets the registration to which a payment is tied.
     * @return registration Registration the registration
     */
    public Registration getRegistration() {
        return registration;
    }

    /**
     * Processes a payment.
     * @param datePaid String the date of the payment
     */
    public void processPayment(String datePaid) {
        if (!status.equals("Pending")) {
            return;
        }
        else {
            this.datePaid = datePaid;
            this.status = "Completed";
        }
    }  
}
