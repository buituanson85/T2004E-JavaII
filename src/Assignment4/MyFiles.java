package Assignment4;

import java.io.File;

public class MyFiles {
    public static void main(String[] args) {
        File file = new File("D:\\T2004E-JavaII\\src");
        MyFiles myFiles = new MyFiles();
        myFiles.traverseDepthFiles(file);
    }

    public void traverseDepthFiles(final File file) {
        // check xem fileOrDir la file hay foder
        if (file.isDirectory()) {
            // in ten folder ra man hinh
            System.out.println(file.getAbsolutePath());

            final File[] children = file.listFiles();
            if (children == null) {
                return;
            }

            for (final File each : children) {
                // gọi lại hàm traverseDepthFiles()
                traverseDepthFiles(each);
            }
        } else {
            // in ten file ra man hinh
            System.out.println(file.getAbsolutePath());
        }
    }
}