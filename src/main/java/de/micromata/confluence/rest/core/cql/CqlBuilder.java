package de.micromata.confluence.rest.core.cql;

import org.apache.commons.lang3.StringUtils;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 04.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class CqlBuilder {

    public static final String WHITESPACE = " ";

    private StringBuffer jql = null;

    public CqlBuilder() {
        jql = new StringBuffer();
    }

    public JqlKeyword addCondition(EField field, EOperator operator, String... operand) {
        JqlKeyword jqlKeyword = new JqlKeyword();

        if (field != null) {
            jql.append(field).append(WHITESPACE);
        }
        if (operator != null) {
            jql.append(operator).append(WHITESPACE);
        }
        if (operand != null) {
            if(operand.length > 1){
                String join = StringUtils.join(operand, ",");
                jql.append("(").append(join).append(") ");
            }else {
                jql.append(operand[0]).append(WHITESPACE);
            }
        }

        return jqlKeyword;
    }

    public CqlBuilder getCqlBuilder() {
        return this;
    }

    public void clear() {
        jql.setLength(0);
    }

    public class JqlKeyword {

        public CqlBuilder and() {
            jql.append(EKeyword.AND).append(WHITESPACE);
            return getCqlBuilder();
        }

        public CqlBuilder or() {
            jql.append(EKeyword.OR).append(WHITESPACE);
            return getCqlBuilder();
        }

        public String orderBy(SortOrder order, EField... fields) {
            if (fields == null || order == null || fields.length == 0) {
                return build();
            }

            jql.append(EKeyword.ORDER_BY).append(WHITESPACE);
            jql.append(fields[0]);

            for (int i = 1; i < fields.length; i++) {
                jql.append(", ");
                jql.append(fields[i]);
            }

            jql.append(WHITESPACE + order);

            return build();
        }

        /**
         * Return the request String and clear the buffer.
         *
         * @return
         */
        public String build() {
            String request = jql.toString();
            clear();
            return request;
        }
    }
}
