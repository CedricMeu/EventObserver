package io.github.cedricmeu.util.mvc;

import io.github.cedricmeu.util.Subject;

/**
 * @author Cedric Meukens
 */
public interface IController {

    IView getView();

    void setView(IView view);

    Subject getModel();

    void setModel(Subject model);

}
