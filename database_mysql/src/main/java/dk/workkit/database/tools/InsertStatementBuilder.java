package dk.workkit.database.tools;

import org.javatuples.Pair;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsertStatementBuilder {

    private final List<Pair<String, Object>> entries;
    private final Connection connection;
    private final String tableName;

    public InsertStatementBuilder(Connection connection, String tableName) {
        this.connection = connection;
        this.entries = new ArrayList<>();
        this.tableName = tableName;
    }

    public InsertStatementBuilder set(String name, Object value) {
        this.entries.add(new Pair<>(name, value));
        return this;
    }

    public PreparedStatement build() throws SQLException {
        String query = "INSERT INTO " + tableName +
                " (" +
                getColumnNames() +
                ") VALUES(" +
                getQuestionMarks() +
                ");";
        System.out.println(query);
        PreparedStatement stmt = connection.prepareStatement(query);
        for (int index = 1; index <= entries.size(); index++) {
            stmt.setObject(index, entries.get(index - 1).getValue1());
        }
        return stmt;
    }

    private String getColumnNames() {
        StringBuilder builder = new StringBuilder();
        entries.stream().map(Pair::getValue0).forEach(e -> {
            builder.append(e);
            builder.append(",");
        });
        return builder.substring(0, builder.length() - 1);
    }

    private String getQuestionMarks() {
        StringBuilder sb = new StringBuilder();
        entries.forEach(e -> sb.append("?,"));
        return sb.substring(0, sb.length() - 1);
    }

}
