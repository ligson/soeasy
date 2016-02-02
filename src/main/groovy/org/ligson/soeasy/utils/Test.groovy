public class Test {


    public static void rename(File root) {
        root.eachFile {
            if (it.isDirectory()) {
                rename(it)
            } else {
                File file = new File(it.getParent(), it.name + ".groovy");
                it.renameTo(file)
            }
        }
    }

    public static void main(String[] args) {
        def file = new File("F:\\workspace\\soeasy\\src\\main\\groovy\\org\\ligson");
        rename(file);
    }
}


