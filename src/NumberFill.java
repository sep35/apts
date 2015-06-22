import java.lang.Character;
import java.lang.Integer;
import java.util.Stack;

public class NumberFill {
        char [][]pic;
        int count = 0;
        int max,max_x;
        int rangex, rangey;
        boolean colorFound;
        Stack<Integer> points;
       
        public void explore (int x, int  y){
                if (x>=rangex || x<0)
                        return;
                if (y>=rangey || y<0)
                        return;
                if (pic[y][x]=='X')
                        return;
                else if (pic[y][x]=='.'){
                        pic[y][x]='X';
                        points.push(x);
                        explore(x+1, y);
                        explore(x-1, y);
                        explore(x, y+1);
                        explore(x, y-1);
                }
                else if (Character.isDigit(pic[y][x])){
                        colorFound = true;
                        int tmp = Integer.valueOf(String.valueOf(pic[y][x]));
                        // what if it's all zero sequence?
                        if (tmp > max){
                                max = tmp;
                                max_x = x;
                        }
                        else if (tmp == max){
                                if(x<max_x)
                                        max_x = x;
                        }
                        pic[y][x]='X';
                        points.push(x);
                        explore(x+1, y);
                        explore(x-1, y);
                        explore(x, y+1);
                        explore(x, y-1);
                }
        }
       
        public int gradient(String[] picture) {
                points = new Stack<Integer>();
                pic = new char[picture.length][picture[0].length()];
                rangex = picture[0].length();
                rangey = picture.length;
                for(int i = 0; i<picture.length; i++){
                        for (int j = 0; j < picture[0].length(); j++){
                                pic[i][j]=picture[i].charAt(j);
                        }
                }
               
                for(int i = 0; i<picture.length; i++){
                        for (int j = 0; j < picture[0].length(); j++){
                                if (!points.isEmpty())
                                        points.clear();
                                colorFound = false;
                                max_x = rangex+1;
                                max = 0;
                                explore(j,i);
                                if(colorFound){
                                        while (!points.empty()){
                                                count = count + points.pop() - max_x + max;
                                        }
                                }
                        }
                }
                return count;
        }
}
