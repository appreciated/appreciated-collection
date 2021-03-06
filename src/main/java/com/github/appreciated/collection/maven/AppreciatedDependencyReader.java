package com.github.appreciated.collection.maven;

import com.github.appreciated.demo.helper.dependencies.MavenDependencyReader;

public class AppreciatedDependencyReader extends MavenDependencyReader {
    public AppreciatedDependencyReader(String artifactID) {
        super("com.github.appreciated", artifactID);
    }

    public static void main(String[] args) {
        System.out.println(new AppreciatedDependencyReader("card"));
    }
}
