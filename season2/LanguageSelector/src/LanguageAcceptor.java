import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
public class LanguageAcceptor {

    public Set<String> parseAcceptLanguages(String headerTag, Set<String> supportedLanguages) {
        Set<String> tags = getHeaderTags(headerTag);
        Set<String> acceptedTagSet = new HashSet<>();
        for (String tag : tags) {
            if (supportedLanguages.contains(tag)) {
                acceptedTagSet.add(tag);
            }
        }
        return acceptedTagSet;
    }

    private Set<String> getHeaderTags(String headerTag) {
        String[] splitStrs = headerTag.split(",");
        Set<String> tags = new HashSet<>();
        for (String str : splitStrs) {
            tags.add(str.trim());
        }
        return tags;
    }
}
