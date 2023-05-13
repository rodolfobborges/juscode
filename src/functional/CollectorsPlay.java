package functional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsPlay {

    static class Tag {
        private final String name;
        private final LocalDateTime time;

        public Tag(String name) {
            this.name = name;
            this.time = LocalDateTime.now();
        }

        public String getName() {
            return name;
        }

        public LocalDateTime getTime() {
            return time;
        }

        @Override
        public String toString() {
            return "Tag{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) {

        Tag[] allTags = {
                new Tag("Urgent"),
                new Tag("Unread"),
                new Tag("Read"),
                new Tag("Response required")
        };

        System.out.println(
                "All tags: " + Arrays.stream(allTags)
                        .map(Tag::getName)
                        .collect(Collectors.joining(", ")));

        Long moreThanOneWordCount = Arrays.stream(allTags)
                .filter(tag -> tag.getName().split(" ").length > 1 )
                .collect(Collectors.counting());

        System.out.println("Count tags with more than one word: " + moreThanOneWordCount);

        final int MAX_LENGTH = 4;
        System.out.println("Tags with less than " + MAX_LENGTH);
        List<Tag> tagsName = Arrays.stream(allTags)
                .collect(Collectors.partitioningBy(tag -> tag.getName().length() < MAX_LENGTH))
                .get(true);
        tagsName.forEach(System.out::println);

    }

}
