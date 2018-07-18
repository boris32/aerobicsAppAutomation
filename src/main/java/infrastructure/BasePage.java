package infrastructure;

import java.util.logging.Logger;

/**
 * Created by Boris on 6/29/2018.
 */
public class BasePage {
    protected Logger logger;

    public BasePage () {
        logger = Logger.getLogger("BasePageLogger");
    }
}
