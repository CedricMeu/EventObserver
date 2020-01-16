package io.github.cedricmeu.util.mvc;

import io.github.cedricmeu.util.Subject;

/**
 * @author Cedric Meukens
 */
public abstract class Controller implements IController {
    private Subject model;
    private IView view;

    public Controller(Subject model, IView view) {
        setModel(model);
        setView(view);
        view.setController(this);
        model.addObserver(view);
    }

    @Override
    public IView getView() {
        return view;
    }

    @Override
    public void setView(IView view) {
        this.view = view;
    }

    @Override
    public Subject getModel() {
        return model;
    }

    @Override
    public void setModel(Subject model) {
        this.model = model;
    }
}
