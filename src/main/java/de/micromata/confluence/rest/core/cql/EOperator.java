package de.micromata.confluence.rest.core.cql;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 06.07.2016
 * Project: ConfluenceTransferPlugin
 */
public enum EOperator {

    /**
     * The "=" operator is used to search for content where the value of the specified field exactly matches the specified value.
     * (Note: cannot be used with text fields; see the CONTAINS operator instead.)
     * To find content where the value of a specified field exactly matches multiple values, use multiple "=" statements with the AND operator.
     */
    EQUALS("="),

    /**
     * The "!=" operator is used to search for content where the value of the specified field does not match the specified value.
     * (Note: cannot be used with text fields; see the DOES NOT MATCH ("!~") operator instead.)
     * Note: typing field != value is the same as typing NOT field = value.
     */
    NOT_EQUALS("!="),


    /**
     * The ">" operator is used to search for content where the value of the specified field is greater than the specified value.
     * Cannot be used with text fields.
     * Note that the ">" operator can only be used with fields which support range operators (e.g. date fields and numeric fields).
     * To see a field's supported operators, check the individual field reference.
     */
    GREATER_THAN(">"),

    /**
     * The ">=" operator is used to search for content where the value of the specified field is greater than or equal to the specified value.
     * Cannot be used with text fields.
     * Note that the ">=" operator can only be used with fields which support range operators (e.g. date fields).
     * To see a field's supported operators, check the individual field reference.
     */
    GREATER_THAN_EQUALS(">="),

    /**
     * The "<" operator is used to search for content where the value of the specified field is less than the specified value.
     * Cannot be used with text fields.
     * Note that the "<" operator can only be used with fields which support range operators (e.g. date fields).
     * To see a field's supported operators, check the individual field reference.
     */
    LESS_THAN("<"),

    /**
     * The "<=" operator is used to search for content where the value of the specified field is less than or equal to than the specified value.
     * Cannot be used with text fields.
     * Note that the "<=" operator can only be used with fields which support range operators (e.g. date fields).
     * To see a field's supported operators, check the individual field reference.
     */
    LESS_THAN_EQUALS("<="),

    /**
     * The "IN" operator is used to search for content where the value of the specified field is one of multiple specified values.
     * The values are specified as a comma-delimited list, surrounded by parentheses.
     * Using "IN" is equivalent to using multiple EQUALS (=) statements with the OR keyword, but is shorter and more convenient.
     * That is, typing creator IN (tom, jane, harry) is the same as typing creator = "tom" OR creator = "jane" OR creator = "harry".
     */
    IN("in"),

    /**
     * The "NOT IN" operator is used to search for content where the value of the specified field is not one of multiple specified values.
     * Using "NOT IN" is equivalent to using multiple NOT_EQUALS (!=) statements, but is shorter and more convenient.
     * That is, typing creator NOT IN (tom, jane, harry) is the same as typing creator != "tom" AND creator != "jane" AND creator != "harry".
     */
    NOT_IN("not in"),

    /**
     * The "~" operator is used to search for content where the value of the specified field matches the specified value
     * (either an exact match or a "fuzzy" match — see examples below). The "~" operator can only be used with text fields, for example:
     * •title
     * •text
     * Note: when using the "~" operator, the value on the right-hand side of the operator can be specified using Confluence text-search syntax.
     */
    CONTAINS("~"),

    /**
     * The "!~" operator is used to search for content where the value of the specified field is not a "fuzzy" match for the specified value.
     * The "!~" operator can only be used with text fields, for example:
     * •title
     * •text
     * Note: when using the "!~" operator, the value on the right-hand side of the operator can be specified using Confluence text-search syntax.
     */
    DOES_NOT_CONTAIN("!~");
    /**
     * The operator.
     */
    private final String operator;

    /**
     * Instantiates a new operator.
     *
     * @param operator the name of the operator
     */
    EOperator(String operator) {
        this.operator = operator;
    }

    /**
     * Gets the operator.
     *
     * @return the operator
     */
    public String getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return getOperator();
    }
}
