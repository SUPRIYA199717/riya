//avg of digits
import java.util.Scanner;
class AvgofDigits
{
public static void main(String [] args)
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter the number:");
int n=sc.nextInt();
int count=0,s=0,i=1;
do
{
int p=n%10;
s=s+p;
n=n/10;
count++;
i=s/count;
}
while(n!=0);
System.out.println("Average of digits:"+ i);

}
}