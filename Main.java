import java.util.*;

class Node
{
int val;
Node left,right;
public Node(int val)
{
this.val=val;
this.left=null;
this.right=null;1
}
}
class Main
{
int sum=0,max=0,min=0;
public Node insert(Node root, int val)
{
if(root==null)
   return new Node(val); 

if(val<root.val)
{
   root.left=insert(root.left,val);
}
else if(val>root.val)
{
   root.right=insert(root.right,val);
}
return root;
}
// Write this code above public static void main
private void helper(Node root, List<Integer> res)
{
if(root==null) return;
helper(root.left,res);
res.add(root.val);
helper(root.right,res);
}
public List<Integer> inorder(Node root)
{
List<Integer> res=new ArrayList<>();
helper(root,res);
return res;
}

// Write this code above public static void main
private void helper1(Node root, List<Integer> res)
{
if(root==null) return;
res.add(root.val);
helper1(root.left,res);
helper1(root.right,res);
}
public List<Integer> preorder(Node root)
{
List<Integer> res=new ArrayList<>();
helper1(root,res);
return res;
}

// Write this code above public static void main
private void helper2(Node root, List<Integer> res)
{
if(root==null) return;
helper2(root.left,res);
helper2(root.right,res);
res.add(root.val);
}
public List<Integer> postorder(Node root)
{
List<Integer> res=new ArrayList<>();
helper2(root,res);
return res;
}

public List<List<Integer>> level(Node root)
{
List<List<Integer>> result=new ArrayList<>();
if(root==null) return result;
Queue<Node> queue=new LinkedList<>();
queue.add(root);

while(!queue.isEmpty())
{
int levelsize=queue.size();
List<Integer> currentLevel=new ArrayList<>();

for(int i=0;i<levelsize;i++)
{
Node currentNode=queue.remove();
currentLevel.add(currentNode.val);

if(currentNode.left!=null)
queue.add(currentNode.left);

if(currentNode.right!=null)
queue.add(currentNode.right);
}
result.add(currentLevel);
}
return result;
}
public static void main(String args[])
{
Main sol=new Main();
Scanner sc=new Scanner(System.in);

System.out.print("Enter Root val : ");
Node root=new Node(sc.nextInt());
int choice,no;
String data=null;
List<Integer> result;
do
{
System.out.println("\t\t\tMenu");
System.out.println("\n1. Insert ");
System.out.println("2. Inorder ");
System.out.println("3. Preorder ");
System.out.println("4. Postorder ");
System.out.println("5. Levelorder ");

System.out.print("Enter the Choice : ");
choice=sc.nextInt();
switch(choice)
{
case 1:
System.out.println("Insert Node ");
System.out.println("Enter No of Nodes : ");
no=sc.nextInt();
for(int i=1;i<=no;i++)
{
System.out.print("Enter value " + i + ":");
sol.insert(root,sc.nextInt());
}
System.out.println("Nodes Inserted successfully");
break;
case 2: // Add below code into switch case
System.out.println("Inorder"); 
result=sol.inorder(root);
System.out.println(result + "\n");
break;
case 3: // Add below code into switch case
System.out.println("Preorder"); 
result=sol.preorder(root);
System.out.println(result + "\n");
break;
case 4: // Add below code into switch case
System.out.println("Postorder"); 
result=sol.postorder(root);
System.out.println(result + "\n");
break;
case 5: // Add below code into switch case
System.out.println("Levelorder"); 
List<List<Integer>>  result1=sol.level(root);
System.out.println(result1 + "\n");
break;

default:
System.out.println("Invalid choice ! Try again");
break;
}
}while(choice!=12);
}
}