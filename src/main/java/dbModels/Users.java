package dbModels;


import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.DbName;
import org.javalite.activejdbc.annotations.Table;

@DbName("dmitrybase")
@Table("data.tablename")
public class Users extends Model {
}