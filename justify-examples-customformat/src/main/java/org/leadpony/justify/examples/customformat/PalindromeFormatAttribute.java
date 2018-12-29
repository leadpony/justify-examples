package org.leadpony.justify.examples.customformat;

import javax.json.JsonString;
import javax.json.JsonValue;

import org.leadpony.justify.api.InstanceType;
import org.leadpony.justify.spi.FormatAttribute;

/**
 * A custom format attribute which represents "palindrome" format.
 */
public class PalindromeFormatAttribute implements FormatAttribute {

    /**
     * Returns the attribute name.
     * @return the attribute name.
     */
    @Override
    public String name() {
        return "palindrome";
    }

    /**
     * Returns the type of the target instance to check.
     * @return the type of the target instance. 
     */
    @Override
    public InstanceType valueType() {
        return InstanceType.STRING;
    }

    /**
     * Tests whether the instance is palindrome or not.
     * @return {@code true} if the value is a palindrome, 
     *         {@code false} if the value is not a palindrome.
     */
    @Override
    public boolean test(JsonValue value) {
        String string = ((JsonString)value).getString();
        int i = 0;
        int j = string.length() - 1;
        while (i < j) {
            if (string.charAt(i++) != string.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
