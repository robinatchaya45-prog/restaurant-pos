Package com.restaurant.pos.friend2.model;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Customer domain model.
 * Owned by Friend 2 - do not duplicate elsewhere in the codebase.
 */
public class Customer {

    private static final Pattern PHONE_PATTERN = Pattern.compile("^[0-9+\\-() ]{7,20}$");

    private Long customerId;
    private String name;
    private String phone;

    public Customer() {
    }

    public Customer(Long customerId, String name, String phone) {
        setName(name);
        setPhone(phone);
        this.customerId = customerId;
    }

    public Customer(String name, String phone) {
        this(null, name, phone);
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name must not be empty");
        }
        if (name.trim().length() > 150) {
            throw new IllegalArgumentException("Customer name is too long");
        }
        this.name = name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer phone must not be empty");
        }
        String trimmed = phone.trim();
        if (!PHONE_PATTERN.matcher(trimmed).matches()) {
            throw new IllegalArgumentException("Customer phone number is invalid");
        }
        this.phone = trimmed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}