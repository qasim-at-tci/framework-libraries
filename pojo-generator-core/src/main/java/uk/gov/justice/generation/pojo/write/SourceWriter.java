package uk.gov.justice.generation.pojo.write;

import static java.lang.String.format;

import uk.gov.justice.generation.pojo.core.GenerationContext;
import uk.gov.justice.generation.pojo.generators.ClassGeneratable;

import java.io.IOException;
import java.nio.file.Path;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

public class SourceWriter {

    public void write(final ClassGeneratable classGenerator, final GenerationContext generationContext) {
        final TypeSpec typeSpec = classGenerator.generate();
        writeClass(generationContext.getOutputDirectoryPath(), generationContext.getPackageName(), typeSpec);
    }

    private void writeClass(final Path outputDirectory, final String packageName, final TypeSpec typeSpec) {
        try {
            JavaFile.builder(packageName, typeSpec)
                    .build()
                    .writeTo(outputDirectory);
        } catch (final IOException e) {
            throw new SourceCodeWriteException(format("Failed to write java file to '%s' for '%s.%s.java'", outputDirectory, packageName, typeSpec.name), e);
        }
    }
}
