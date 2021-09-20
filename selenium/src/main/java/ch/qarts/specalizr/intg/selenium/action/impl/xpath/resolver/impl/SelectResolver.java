package ch.qarts.specalizr.intg.selenium.action.impl.xpath.resolver.impl;

import ch.qarts.specalizr.api.element.Select;
import org.openqa.selenium.By;

public class SelectResolver extends ElementResolver<Select> {

    SelectResolver(ResolverContext resolverContext) {
        super(resolverContext);
    }

    @Override
    public By resolve(Select element) {
        return merge("//select", element.getElementQueryComponentList());
    }

}
