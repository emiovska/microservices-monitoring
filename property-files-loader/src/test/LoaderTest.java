import com.msm.property.file.loader.demo.TestResource;
import com.msm.property.file.loader.readers.PropertyFilesReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;


/**
 * @author riste.jovanoski
 * @since 6/13/2017
 */
public class LoaderTest {

    @Test
    public void testFileLoader() {
        Map<Class, Object> parsedFiles = PropertyFilesReader.loadPropertyFiles();
        System.out.println(parsedFiles);
        TestResource resource = (TestResource) parsedFiles.get(TestResource.class);
        System.out.println(resource.getProperty1());
        System.out.println(resource.getProperty2());
        System.out.println(resource.getProperty3());
        System.out.println(resource.getProperty4());
        System.out.println(resource.getProperty5());
        Assert.assertNotEquals(parsedFiles.size(), 0);
    }

}
