import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private ArrayList<String> lines;
    private static Scanner sc;
    private String name;

    public Solution() {
        this.lines = new ArrayList<>();
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.report(new File(args[0]), Integer.valueOf(args[1])));
    }

    public String report(File f, int sIndex) {
        parseFile(f);
        
        if(sIndex > lines.size()-1) {
            return "Cannot find " + sIndex;
        }

        boolean status = findStatus(sIndex);
        if(status) {
            return correctMessage(sIndex);
        } else {
            return "Error: " + sIndex;
        }
    }
    
    public void parseFile(File file) {

        try {
            sc = new Scanner(file);
        } catch(Exception e) {
            System.out.println("could not find the file!");
        }

        while(sc.hasNext()) {
            lines.add(sc.nextLine());
        }
    }

    public boolean findStatus(int sIndex) {
        boolean[] status = new boolean[lines.size()];
        String[] firstLine = lines.get(0).split(" ");
        if(firstLine.length != 4) {
            return false;
        }

        status[0] = true;
        name = firstLine[0];

        if(!validName(name)) {
            return false;
        }

        try{
            int x = Integer.parseInt(firstLine[1]);
            int y = Integer.parseInt(firstLine[2]);
            int z = Integer.parseInt(firstLine[3]);


            for(int i = 1; i < sIndex+1; i++) {
                String[] curInfo = lines.get(i).split(" ");
                if(curInfo.length != 7) {
                    return false;
                }

                if(!name.equals(curInfo[0]) || x != Integer.parseInt(curInfo[1]) || y != Integer.parseInt(curInfo[2]) || z != Integer.parseInt(curInfo[3])) {
                    return false;
                }

                //get offsets
                int xOff = Integer.parseInt(curInfo[4]);
                int yOff = Integer.parseInt(curInfo[5]);
                int zOff = Integer.parseInt(curInfo[6]);

                //get current position
                x += xOff;
                y += yOff;
                z += zOff;
                status[i] = true;
            }
        } catch(Exception e) {
            return false;
        }
        return status[sIndex];
    }

    public String correctMessage(int index) {
        String res;

        String[] arr = lines.get(index).split(" ");
        if(arr.length == 4) {
            res = arr[0] + " " + index + " " + Integer.parseInt(arr[1]) + " " + Integer.parseInt(arr[2]) + " " + Integer.parseInt(arr[3]);
        } else {
            res = arr[0] + " " + index + " " + (Integer.parseInt(arr[1]) + Integer.parseInt(arr[4])) + " " + (Integer.parseInt(arr[2]) + Integer.parseInt(arr[5])) + " " + (Integer.parseInt(arr[3]) + Integer.parseInt(arr[6]));
        }
        return res;
    }

    public boolean validName(String name) {
        return name.matches("[a-zA-Z0-9]+");
    }
}