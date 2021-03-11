
import models.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private final static Logger LOG = LogManager.getLogger("Тест");

    public static void main(String[] args) {
        LOG.info("=========Start========");

        String[] colors = new String[]{
                "red",
                "blue",
                "green",
                "yellow"};

        List<Car> cars = new ArrayList<>();

        for (String color : colors){
            LOG.debug(String.format("send color %s to constroctor Car", color));
            cars.add(new Car(color, true));
        }

        LOG.info(cars);


        System.out.println("=========Finish========");
    }

}