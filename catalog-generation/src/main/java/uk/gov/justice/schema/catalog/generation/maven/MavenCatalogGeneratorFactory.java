package uk.gov.justice.schema.catalog.generation.maven;

import uk.gov.justice.maven.generator.io.files.parser.core.Generator;
import uk.gov.justice.maven.generator.io.files.parser.core.GeneratorFactory;
import uk.gov.justice.schema.catalog.generation.ObjectFactory;

import java.net.URI;
import java.util.List;

public class MavenCatalogGeneratorFactory implements GeneratorFactory<List<URI>> {

    @Override
    public Generator<List<URI>> create() {
        return new MavenCatalogGenerator(new ObjectFactory());
    }
}
