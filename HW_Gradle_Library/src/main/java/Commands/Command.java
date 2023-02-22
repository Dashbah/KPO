package Commands;

import models.Storage;

/**
 * Command interface to work with Storage class java/models/Storage.java
 */
public interface Command {
    void execute(Storage storage);
}
