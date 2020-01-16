package io.github.cedricmeu.util.mvc;

import io.github.cedricmeu.util.Observer;

import java.awt.*;

/**
 * @author Cedric Meukens
 */
public interface IView extends Observer {

    void setController(IController controller);

    IController getController();

    Component getUI();

}
