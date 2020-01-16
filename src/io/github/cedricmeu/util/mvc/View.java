package io.github.cedricmeu.util.mvc;

import io.github.cedricmeu.util.Observer;

/**
 * @author Cedric Meukens
 */
public abstract class View implements IView, Observer {

    private IController controller;

    @Override
    public IController getController() {
        return controller;
    }

    @Override
    public void setController(IController controller) {
        this.controller = controller;
    }
}
