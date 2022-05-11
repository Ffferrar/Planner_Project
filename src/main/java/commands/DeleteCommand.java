package commands;

import data.DataAdmin;
import data.DataAdminSQLite;
import targets.Target;

import java.sql.SQLException;

public class DeleteCommand extends Command {

    public Target obj;
    public DataAdmin dataAdmin;
    public DeleteCommand(Target obj) throws SQLException {
        this.obj = obj;
        this.dataAdmin = new DataAdminSQLite();
    }
    public void execute(){
        this.dataAdmin.deleteNote(this.obj);
    }
}
