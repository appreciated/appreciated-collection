package com.github.appreciated.collection.demo.component;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ExampleContent extends VerticalLayout {
    public ExampleContent() {
        this("Your Content");
    }

    public ExampleContent(String label) {
        add(new Label("< " + label + " >"));
        getStyle().set("border", "1px solid var(--lumo-primary-color)");
        setWidth("400px");
        setHeight("400px");
        setAlignItems(FlexComponent.Alignment.CENTER);
        setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
    }
}
