package generics.recursion;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recursion {

    public List<String> getParts(Path path) {
        List<String> list = new ArrayList<>();
        while (path != null){
            list.add(path.getFileName().toString());
            path = path.getParent();
        }
        Collections.reverse(list);
        System.out.println(list);
        return null;
    }

    public List<String> getParts2(Path path) {

        if (path.getParent() != null){
            getParts2(path.getParent());
        }
        System.out.println(path.getFileName());

        return null;
    }

    public List<String> getParts3(Path path, List<String> parts) {

        if (path.getParent() != null){
            getParts3(path.getParent(), parts);
        }
        parts.add(path.getFileName().toString());
        return null;
    }

    public List<String> getParts4(Path path) {

        if (path == null) {
            return new ArrayList<>();
        }
        List<String> result = getParts4(path.getParent());
        result.add(path.getFileName().toString());

        return result;
    }
}
