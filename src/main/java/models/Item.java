package models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Item {

    private String type;
    protected final Logger log;
    private String name;

    public Item(String type){
        this.log = LogManager.getLogger(this.getClass().getName());
        this.type = name;
    }

    public Item(Logger log){
        this.log = log;
    }

    public Item(){
        this.log = LogManager.getLogger(this.getClass().getName());
    }

    public String getType() {
        return type;
    }

    public Item setType(String type) {
        this.type = type;
        return this;
    }
}
