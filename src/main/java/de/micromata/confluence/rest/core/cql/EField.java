package de.micromata.confluence.rest.core.cql;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 04.07.2016
 * Project: ConfluenceTransferPlugin
 */
public enum EField {

    ANCESTOR("ancestor", EFieldType.CONTENT),

    CONTAINER("container", EFieldType.CONTENT),

    CONTENT("content", EFieldType.CONTENT),

    CREATED("created", EFieldType.DATE),

    CREATOR("creator", EFieldType.USER),

    CONTRIBUTOR("contributor", EFieldType.USER),

    FAVOURITE("favourite", EFieldType.USER),

    ID("id", EFieldType.CONTENT),

    LABEL("label", EFieldType.STRING),

    LASTMODIFIED("lastmodified", EFieldType.DATE),

    MACRO("marco", EFieldType.STRING),

    MENTION("mention", EFieldType.USER),

    PARENT("parent", EFieldType.CONTENT),

    SPACE("space", EFieldType.SPACE),

    TEXT("text", EFieldType.TEXT),

    TITLE("title", EFieldType.TEXT),

    TYPE("type", EFieldType.TYPE),

    WATCHER("watcher", EFieldType.USER);
    /**
     * The name of the field.
     */
    private final String field;

    /**
     * The type of the field.
     */
    private final EFieldType type;

    /**
     * Instantiates a new field.
     *
     * @param field = name of the field
     * @param type  = type of the field
     */
    EField(String field, EFieldType type) {
        this.field = field;
        this.type = type;
    }

    /**
     * Gets the name of the field.
     *
     * @return the field name
     */
    public String getField() {
        return field;
    }

    /**
     * Gets the type of the field.
     *
     * @return the field type
     */
    public EFieldType getType() {
        return type;
    }

    @Override
    public String toString() {
        return getField();
    }
}
