package ch.borja.specalizr.api.element;


import ch.borja.specalizr.api.query.ElementQueryComponent;
import ch.borja.specalizr.api.query.ElementVisitor;

public class Panel extends ElementBase implements Clickable, Validatable {

    private Panel(final ElementQueryComponent... elementQueryComponentList) {
        super(elementQueryComponentList);
    }

    @Override
    public <T> T accept(final ElementVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public static Panel panel(final ElementQueryComponent... elementQueryComponentList) {
        return new Panel(elementQueryComponentList);
    }

}
