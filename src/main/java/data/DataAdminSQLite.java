package data;

import org.sqlite.JDBC;
import targets.MiddleTarget;
import targets.SmallTarget;
import targets.SuperTarget;
import targets.Target;
import utils.CaseName;
import utils.TargetType;
import utils.TargetsFieldsName;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

public class DataAdminSQLite implements DataAdmin {

    //адрес подключения
    public static final String STAT_ADDRESS = "jdbc:sqlite:DataBase.sqlite";
    public Target obj;

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
    public void createNote(Target object, TargetType targetType) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO DataBase('id', 'name', 'startDate', 'endData', 'queue', 'color', 'blocked', 'parentID', 'status', 'targetType')" +
                "VALUES(?,?,?,?,?,?,?,?,?,?)")){
            statement.setObject(1, object.getId());
            statement.setObject(2, object.name);
            statement.setObject(3, object.startData.getTime());
            statement.setObject(4, object.endData.getTime());
            statement.setObject(5, object.queue);
            statement.setObject(6, object.color);
            statement.setObject(7, object.blocked);
            statement.setObject(8, object.parentID);

            switch(targetType){
                case Small:
                    statement.setObject(9,  CaseName.TODO_CASE.ordinal());
                    statement.setObject(10, targetType.Small.ordinal());
                    break;

                case Middle:
                    statement.setObject(9, CaseName.TODO_CASE.ordinal());
                    statement.setObject(10, targetType.Middle.ordinal());
                    break;

                case Super:
                    statement.setObject(9,  CaseName.TODO_CASE.ordinal());
                    statement.setObject(10, targetType.Super.ordinal());
                    break;

            }

            statement.execute();
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
                    statement.setObject(1, object.startData.getTime());
                    break;
                case END_DATA:
                    statement.setObject(1, object.endData.getTime());
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
                case PARENT_ID:
                    statement.setObject(1, object.parentID);
                    break;
                case STATUS:
                    statement.setObject(1, object.status.ordinal());
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

    public List<Target> getAllObjects(String parentID) {

        try (PreparedStatement statement = this.connection.prepareStatement("SELECT id, name, startDate, endData, queue, color, blocked, parentID, status, targetType FROM DataBase WHERE parentID = ?")) {
            // В данный список будем загружать наши продукты, полученные из БД
            List<Target> targets = new ArrayList<Target>();
            statement.setObject(1, parentID);
            ResultSet resultSet = statement.executeQuery();
            // Проходимся по нашему resultSet и заносим данные в products
            while (resultSet.next()) {

                // Создаем по кусочкам Target
                //TODO придумать, как разделять на типы Targetов
                GregorianCalendar startD = new GregorianCalendar();
                startD.setTime(resultSet.getDate("startDate"));

                GregorianCalendar endD = new GregorianCalendar();
                endD.setTime(resultSet.getDate("endData"));

                switch(TargetType.values()[resultSet.getInt("targetType")]){

                    case Small:
                        this.obj = new SmallTarget(resultSet.getString("name"),
                                endD,
                                resultSet.getInt("queue"),
                                resultSet.getInt("color"),
                                resultSet.getString("parentID"));
                        obj.status = CaseName.values()[resultSet.getInt("status")];

                        break;
                    case Super:
                        this.obj = new SuperTarget(resultSet.getString("name"),
                                endD,
                                resultSet.getInt("queue"),
                                resultSet.getInt("color"));
                        break;
                    case Middle:
                        this.obj = new MiddleTarget(resultSet.getString("name"),
                                endD,
                                resultSet.getInt("queue"),
                                resultSet.getInt("color"),
                                resultSet.getString("parentID"));
                        break;

                }

                obj.setId(resultSet.getString("id"));
                obj.startData = startD;
                obj.blocked = resultSet.getInt("blocked");
                obj.parentID = resultSet.getString("parentID");

                targets.add(obj);
            }
            this.obj = null;
            return targets;

        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Target getById(String id){
        try (Statement statement = this.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT id, name, startDate, endData, queue, color, blocked, parentID, status, targetType WHERE id = "+id+" FROM DataBase");
            // Проходимся по нашему resultSet и заносим данные в products
            while (resultSet.next()) {

                // Создаем по кусочкам Target
                GregorianCalendar startD = new GregorianCalendar();
                startD.setTime(resultSet.getDate("startDate"));

                GregorianCalendar endD = new GregorianCalendar();
                endD.setTime(resultSet.getDate("endData"));

                switch(TargetType.values()[resultSet.getInt("targetType")]){

                    case Small:
                        this.obj = new SmallTarget(resultSet.getString("name"),
                                endD,
                                resultSet.getInt("queue"),
                                resultSet.getInt("color"),
                                resultSet.getString("parentID"));
                        obj.status = CaseName.values()[resultSet.getInt("status")];
                        break;
                    case Super:
                        this.obj = new SuperTarget(resultSet.getString("name"),
                                endD,
                                resultSet.getInt("queue"),
                                resultSet.getInt("color"));
                        break;
                    case Middle:
                        this.obj = new MiddleTarget(resultSet.getString("name"),
                                endD,
                                resultSet.getInt("queue"),
                                resultSet.getInt("color"),
                                resultSet.getString("parentID"));
                        break;

                }

                obj.setId(resultSet.getString("id"));
                obj.startData = startD;
                obj.blocked = resultSet.getInt("blocked");
                obj.parentID = resultSet.getString("parentID");

            }
            return obj;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
