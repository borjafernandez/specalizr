package ch.borja.specalizr.api.element;


import ch.borja.specalizr.api.query.ElementQueryComponent;
import ch.borja.specalizr.api.query.ElementVisitor;

public class Link extends ElementBase implements Clickable {

    private Link(final ElementQueryComponent... elementQueryComponentList) {
        super(elementQueryComponentList);
    }

    @Override
    public <T> T accept(final ElementVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public static Link link(final ElementQueryComponent... elementQueryComponentList) {
        return new Link(elementQueryComponentList);
    }

}
