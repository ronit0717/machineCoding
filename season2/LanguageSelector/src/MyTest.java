import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MyTest {

    @Test
    public void sampleTest1() {
        LanguageAcceptor languageAcceptor = new LanguageAcceptor();
        String headerTag = "fr-CA, fr-FR";
        Set<String> acceptedTags = new HashSet<>();
        acceptedTags.add("en-US");
        acceptedTags.add("fr-FR");
        Set<String> parsedTags = languageAcceptor.parseAcceptLanguages(headerTag, acceptedTags);

        //write assertions
        assert parsedTags.size() == 1 : "Expected size 1, but got " + parsedTags.size();
        assert parsedTags.contains("fr-FR") : "Expected to contain 'fr-FR', but it does not.";
    }

    @Test
    public void sampleTest2() {
        LanguageAcceptor languageAcceptor = new LanguageAcceptor();
        String headerTag = "en-US";
        Set<String> acceptedTags = new HashSet<>();
        acceptedTags.add("en-US");
        acceptedTags.add("fr-FR");
        Set<String> parsedTags = languageAcceptor.parseAcceptLanguages(headerTag, acceptedTags);

        //write assertions
        assert parsedTags.size() == 1 : "Expected size 1, but got " + parsedTags.size();
        assert parsedTags.contains("en-US") : "Expected to contain 'en-US', but it does not.";
    }
}
