//Method 1(Time Complexity: O(n^2) and Space Complexity: O(1))
import java.util.*;
class Main {
   public static int trap(int[] a) {
        int n=a.length;
        int ans=0;
        int lmax=0,rmax=0;
        for(int i=1;i<n-1;i++)
        {
            lmax=a[i];
                for(int j=0;j<i;j++)
                {
                    lmax=Math.max(a[j],lmax);
                }
            rmax=a[i];
            for(int j=i+1;j<n;j++)
            {
                rmax=Math.max(a[j],rmax);
            }
            ans+=(Math.min(lmax,rmax)-a[i]);
        }
        return ans;
    }
 public static void main(String[] args)
    {
 	  int arr[] = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println("Maximum water accumulated is " + trap(arr));
    }
}
/////////////////////////////////////////////
////////////////////////////////////////////
//Method 2 Efficient Solution (Time Complexity: O(n) and Space Complexity: O(n))
import java.util.*;
class Main {
    public static int trap(int[] a) {
        int n=a.length;
        int ans=0;
        int lmax[]=new int[n];
          int rmax[]=new int[n];
        lmax[0]=a[0];
        for(int i=1;i<n;i++)
        {
            lmax[i]=Math.max(lmax[i-1],a[i]);
        }
        rmax[n-1]=a[n-1];
        for(int i=n-2;i>=0;i--)
        {
            rmax[i]=Math.max(a[i],rmax[i+1]);
        }
        for(int i=1;i<n-1;i++)
        {
            ans+=(Math.min(lmax[i],rmax[i])-a[i]);
        }
        return ans;    
    }
 public static void main(String[] args)
    {
 	  int arr[] = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println("Maximum water accumulated is " + trap(arr));
    }
}