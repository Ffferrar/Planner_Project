package data;

import org.sqlite.JDBC;
import targets.Target;
import utils.TargetsFieldsName;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

public class DataAdminSQLite implements DataAdmin {

    //адрес подключения
    public static final String STAT_ADDRESS = "jdbc:sqlite:DataBase.sqlite";

    //определяем Singleton
    private static DataAdminSQLite instance = null;

    public static synchronized DataAdminSQLite getInstance() throws SQLException{
        if (instance == null){
            instance = new DataAdminSQLite();
        }
        return instance;
    }

    // храним соединение с БД
    private Connection connection;

    public DataAdminSQLite() throws SQLException{
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(STAT_ADDRESS);
    }

    @Override
    public void createNote(Target object) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO DataBase('name', 'startDate', 'endData', 'queue', 'color', 'blocked')" +
                "VALUES(?,?,?,?,?,?)")){
            statement.setObject(1, object.name);
            statement.setObject(2, object.startData);
            statement.setObject(3, object.endData);
            statement.setObject(4, object.queue);
            statement.setObject(5, object.color);
            statement.setObject(6, object.blocked);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void changeNote(Target object, TargetsFieldsName field) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO DataBase(field)"+
                        "VALUE(?)" +
                        " WHERE id = ?")){
            switch(field){
                case NAME:
                    statement.setObject(1, object.name);
                    break;
                case START_DATA:
                    statement.setObject(1, object.startData);
                    break;
                case END_DATA:
                    statement.setObject(1, object.endData);
                    break;
                case QUEUE:
                    statement.setObject(1, object.queue);
                    break;
                case COLOR:
                    statement.setObject(1, object.color);
                    break;
                case BLOCKED:
                    statement.setObject(1, object.blocked);
                    break;

            }

            statement.setObject(2, object.getId());
            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteNote(Target object) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "DELETE FROM DataBase WHERE id = ?")){
            statement.setObject(1, object.getId());
            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /*public List<Target> getAllObjects() {

        try (Statement statement = this.connection.createStatement()) {
            // В данный список будем загружать наши продукты, полученные из БД
            List<Target> targets = new ArrayList<Target>();
            ResultSet resultSet = statement.executeQuery("SELECT name, startDate, endData, queue, color, blocked FROM DataBase");
            // Проходимся по нашему resultSet и заносим данные в products
            while (resultSet.next()) {
                targets.add(new (resultSet.get("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getString("category_name")));
            }
            return targets;

        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }*/
}
