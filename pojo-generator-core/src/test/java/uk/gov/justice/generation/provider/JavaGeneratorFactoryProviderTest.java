package uk.gov.justice.generation.provider;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static uk.gov.justice.services.test.utils.core.reflection.ReflectionUtil.fieldValue;

import uk.gov.justice.generation.pojo.generators.ClassNameFactory;
import uk.gov.justice.generation.pojo.generators.JavaGeneratorFactory;

import java.util.Optional;

import org.junit.Test;

public class JavaGeneratorFactoryProviderTest {

    @Test
    public void shouldProvideJavaGeneratorFactory() throws Exception {
        final ClassNameFactory classNameFactory = mock(ClassNameFactory.class);

        final JavaGeneratorFactory javaGeneratorFactory = new JavaGeneratorFactoryProvider().create(classNameFactory);

        assertThat(fieldValue(javaGeneratorFactory, "classNameFactory"), is(Optional.of(classNameFactory)));
    }
}
