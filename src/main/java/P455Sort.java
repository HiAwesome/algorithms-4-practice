import java.util.Arrays;

/**
 * https://www.jianshu.com/p/e9eb56a220b2
 *
 * @author moqi
 * On 6/20/20 22:07
 */

public class P455Sort {

    public static void main(String[] args) {
        Student[] a = new Student[5];
        a[0] = new Student(1, "sun1");
        a[1] = new Student(2, "sun2");
        a[2] = new Student(3, "sun3");
        a[3] = new Student(1, "sun1");
        a[4] = new Student(4, "sun4");
        int N = a.length;
        int R = 5;

        Student[] aux = new Student[N];
        int[] count = new int[R + 1];

        //计算频率
        for (Student student : a) {
            int group = student.getGroup();
            count[group + 1]++;

        }
        //频率转索引  前面的小键相加
        for (int r = 0; r < R; r++) {
            count[r + 1] += count[r];

        }
        //元素分类  划分按组别（键）
        for (Student student : a) {
            int group = student.getGroup();
            aux[count[group]++] = student;
        }

        System.arraycopy(aux, 0, a, 0, N);

        System.out.println("aux = " + Arrays.toString(aux));
    }

}


class Student {
    private int group;//组号
    private String name;//名字

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int group, String name) {
        this.name = name;
        this.group = group;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "group=" + group +
                ", name='" + name + '\'' +
                '}';
    }
}
