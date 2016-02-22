package scripts

public class Test {
    public static void rename(File root) {
        root.eachFile {
            if (it.isDirectory()) {
                rename(it)
            } else {
                def name = it.name.replaceAll(".groovy", "");
                File file = new File(it.getParent(), name + ".java");
                it.renameTo(file)
            }
        }
    }

    public static void main(String[] args) {
        def file = new File("F:\\workspace\\soeasy\\src\\main\\java\\org\\ligson");
        rename(file);
    }
}


