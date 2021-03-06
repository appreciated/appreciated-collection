package com.github.appreciated.collection.demo.paperripple;


import com.github.appreciated.collection.demo.paperripple.demo.PaperRippleExample;
import com.github.appreciated.collection.maven.AppreciatedDependencyReader;
import com.github.appreciated.demo.helper.DemoHelperView;
import com.github.appreciated.demo.helper.entity.CodeExample;
import com.github.appreciated.demo.helper.entity.GithubDependencies;
import com.github.appreciated.demo.helper.entity.GithubUrl;
import com.github.appreciated.demo.helper.view.devices.IPadMiniView;
import com.github.appreciated.demo.helper.view.devices.Orientation;
import com.github.appreciated.prism.element.Language;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.Route;

@Push
@Route("paper-ripple/")
@BodySize(height = "100%", width = "100%")
public class PaperRippleDemo extends DemoHelperView {

    public PaperRippleDemo() {
        super(new GithubUrl("https://github.com/appreciated/paper-ripple"), new GithubDependencies("https://github.com/PolymerElements/paper-ripple"));
        withHorizontalHeader("PaperRipple",
                "Allows to give the user feedback when a component was clicked.",
                "./frontend/images/ripple/logo.png")
                .withDevice(new IPadMiniView(new PaperRippleExample()).withOrientation(Orientation.PORTRAIT))
                .withStep("Add dependency", "Add the dependency by adding it to your POM",
                        new CodeExample(new AppreciatedDependencyReader("paper-ripple")))
                .withStep("Install dependency", "Install the dependency by running the following Maven goal",
                        new CodeExample("install", Language.markup, "Maven")
                )
                .resetCounterStep()
                .withStep("Some code examples", "Add PaperRipple to your View",
                        new CodeExample(PaperRippleExample.class)
                )
                .withDependencyNotice();
    }
}
