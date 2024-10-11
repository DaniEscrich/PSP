public class ej1_2 {
    public static void main(String[] args) {
        int[][] num = new int[3][6];
        for (int f = 0; f<num.length; f++){
            for (int c = 0; c<num[f].length; c++){
                num[f][c]=0;
            }
        }
        num[0][1] = 30;
        num[0][2] = 2;
        num[0][5] = 5;
        num[1][0] = 75;
        num[2][2] = -2;
        num[2][3] = 9;
        num[2][5] = 11;
        System.out.print("   C0" + " " + "C1" + " " + "C2" + " " +"C3" + " " + "C4" + " " + "C5");
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print("F"+i +" ");
            for (int j = 0; j < 6; j++) {
                System.out.print(num[i][j] + "  ");
            }
            System.out.println();
        }
    }
    }

