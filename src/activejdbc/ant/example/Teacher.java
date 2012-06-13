package activejdbc.ant.example;

import org.javalite.activejdbc.Model;

public class Teacher extends Model {
    static {
	validatePresenceOf("name_first", "name_last");
    }
}
