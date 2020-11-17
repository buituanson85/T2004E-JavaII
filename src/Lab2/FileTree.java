package Lab2;

import java.io.File;
import java.io.IOException;

public class FileTree {
    public void read(String path, int count) throws IOException {
        File file = new File(path);
        String spaces = " ";
        for (int  i = 0; i < count; i++){
            spaces = spaces + " ";
        }

        if (file.isDirectory()){
            String[] ls = file.list();
            for (int i = 0; i < ls.length; i++){
                System.out.println(spaces + "Path: " + ls[i]);
                File file1 = new File(spaces + "Path: " + ls[i]);
                if (file1.isDirectory()){
                    read(file1.getAbsolutePath(), count + 1);
                }
            }
        }else {
            System.out.println(spaces + "Path: " + file.getName());
        }
    }
    public static void main(String[] args) {
        String current = System.getProperty("user.dir");
        File file = new File(current);
        try {
            System.out.println(file.getCanonicalPath());
            System.out.println("isFile: " + file.isFile());
            System.out.println("is Directory: " + file.isDirectory());
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileTree fileTree = new FileTree();

        try {
            fileTree.read(current, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
