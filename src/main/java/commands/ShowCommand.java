package commands;

import data.DataAdmin;
import data.DataAdminSQLite;
import targets.Target;

import java.sql.SQLException;
import java.util.List;

public class ShowCommand extends Command{

    public DataAdmin dataAdmin;

    public ShowCommand(String parentID) throws SQLException {
        this.parentID = parentID;
        this.dataAdmin = new DataAdminSQLite();

    }

    public List<Target> execute(){
        return this.dataAdmin.getAllObjects(this.parentID);
    }
}
