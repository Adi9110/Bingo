
import java.util.Scanner;
class Bingo
{
    private String Pname;
    private int[][] bing;
    Bingo(String name)
    {
        Pname=name;
        bing=new int[5][5];
        for(int i=0;i<5;i++)
        {    for(int j=0;j<5;j++)
            {
                bing[i][j]=0;
            }    
        }
    }

    public void boardEntry(int i,int j,int val)
    {
        bing[i][j]=val;
    }

    public void clrscr()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void display()
    {   
        System.out.println(" "+bing[0][0]+" |  "+bing[0][1]+" |  "+bing[0][2]+" |  "+bing[0][3]+" |  "+bing[0][4]);
        System.out.println(" "+bing[1][0]+" |  "+bing[1][1]+" |  "+bing[1][2]+" |  "+bing[1][3]+" | "+bing[1][4]);
        System.out.println(""+bing[2][0]+" | "+bing[2][1]+" | "+bing[2][2]+" | "+bing[2][3]+" | "+bing[2][4]);
        System.out.println(""+bing[3][0]+" | "+bing[3][1]+" | "+bing[3][2]+" | "+bing[3][3]+" | "+bing[3][4]);
        System.out.println(""+bing[4][0]+" | "+bing[4][1]+" | "+bing[4][2]+" | "+bing[4][3]+" | "+bing[4][4]);
    }

    public boolean valCheck(int i,int j,int val)
    {
        if(val<1 || val>25)
        {
            System.out.println("Invalid Number!. Enter number from 1-25");
            return false;
        }
        else 
        {
            for(int a=0;a<=i;a++)
                for(int b=0;b<5;b++)
                {
                    if(bing[a][b]==val)
                    {
                        System.out.println("number already entered. Please Enter number from 1-25 non-repeating");
                        return false;
                    }
                }
        }
        return true;

    }

}

public class App
{
    
   
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Your name:");
        String name=sc.nextLine();
        Bingo b=new Bingo(name);
        System.out.println(" "+1+" |  "+2+" |  "+3+" |  "+4+" |  "+5);
        System.out.println(" "+6+" |  "+7+" |  "+8+" |  "+9+" | "+10);
        System.out.println(""+11+" | "+12+" | "+13+" | "+14+" | "+15);
        System.out.println(""+16+" | "+17+" | "+18+" | "+19+" | "+20);
        System.out.println(""+21+" | "+22+" | "+23+" | "+24+" | "+25);
        System.out.println("Above is your bingo board,Enter your board entries(1-25) in the order of the number");
        OUTER:for(int i=0;i<5;i++)
        {
            INNER:for(int j=0;j<5;j++)
            {
                int val=sc.nextInt();
                boolean valid=false;
                valid=b.valCheck(i,j,val);
                if(valid)
                    b.boardEntry(i, j, val);
                else
                {
                    j--;
                    continue INNER;
                }
            }

        }
        b.clrscr();
        b.display();
        Bingo sys=new Bingo("System");

    }
}