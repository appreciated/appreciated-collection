package com.github.appreciated.collection.maven;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.IOException;
import java.util.Optional;

public class DependencyReader {

    private final Optional<Dependency> dependency;
    private String groupID;
    private String artifactID;

    public DependencyReader(String artifactID) {
        this("com.github.appreciated", artifactID);
    }

    public DependencyReader(String groupID, String artifactID) {
        this.groupID = groupID;
        this.artifactID = artifactID;
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = null;
        try {
            model = reader.read(this.getClass().getClassLoader().getResource("pom.xml").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        dependency = model.getDependencies().stream()
                .filter(dependency -> dependency.getArtifactId().equals(artifactID))
                .findFirst();
    }

    public static void main(String[] args) {
        System.out.println(new DependencyReader("card").artifactID);
    }

    public String getDependencyString() {
        if (dependency.isPresent()) {
            Dependency dependency = this.dependency.get();
            String dependencyString = "<dependency>\n" +
                    "    <groupId>" + groupID + "</groupId>\n" +
                    "    <artifactId>" + artifactID + "</artifactId>\n" +
                    "    <version>" + dependency.getVersion() + "</version>\n" +
                    "</dependency>";
            return dependencyString;
        }
        return null;
    }
}
