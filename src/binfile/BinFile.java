package binfile;

import java.io.*;

public class BinFile {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String comand, s;
        boolean exit = true;
        int n;
        RandomAccessFile f;
        while (exit) {
            System.out.print("Введите 'add' если хотите добавить записи" + "\nВведите 'read' если хотите посмотреть таблицу" + "\nВведите 'exit' есди хотите выйти из программы" + "\nКоманда: ");
            comand = br.readLine ();
            if (comand.equals("add")){
                System.out.print("Введите сколько записей хотите добавить: ");
                n = Integer.parseInt(br.readLine ());
                s = "";
                for (int i=0; i< n; i++) {
                    System.out.print("Введите название продукта (7 букв): ");
                    s = s + br.readLine () + " ";
                    System.out.print("Введите штрих-код продукта (6 цифр): ");
                    s = s + br.readLine () + " ";
                    System.out.print("Введите цену продукта (4 цифры): ");
                    s = s + br.readLine () + "\n";
                }
                try {
                    f = new RandomAccessFile("data.dat", "rw");
                    f.seek(f.length());
                    f.write(s.getBytes("CP1251"));
                    f.close();
                } catch (Exception ex) {
                }
                System.out.print("ЗАПИСИ ДОБАВЛЕНЫ\n");
            } else if (comand.equals("read")) {
                try {
                    f = new RandomAccessFile ("data.dat","r");
                    f.seek(0);
                    byte [] bytes = new byte[(int) f.length()];
                    f.read(bytes);
                    f.close();
                    String a = new String (bytes, "CP1251");
                    System.out.println(a);
                } catch (Exception ex) {
                }
            } else if(comand.equals("exit")) exit = false;
        }
    }    
}
