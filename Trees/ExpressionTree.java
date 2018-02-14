import java.util.Scanner;
 
class myExpressionTree
{
    public static class Node
    {
    	    
    	public Node left, right;   // The usual pointers.
    	public boolean isLeaf;             // Is this a leaf?
    	public double value;                  // If so, we'll store the number here.
    	public Character op;                    // If not, we need to know which operator.
    	
		public void printPostorder()
		{
			printPostorder(this);
		}

		public void printPostorder(Node n)
		{
			if (n != null)
			{
				if (n.left != null)
					printPostorder(n.left);
				if (n.right != null)
					printPostorder(n.right);
				System.out.print(n.op);
			}
		}

        public Node(Character d)
        {
            op = d; left = null; right = null;
        }
        
        public Node(Node l, Character d, Node r)
        {
            op = d; left = l; right = r;
        }
        
        
        public int computeAnswer ()
        {
            return compute (root);
        }
        
        int compute (Node node)
        {
            if (node.isLeaf) {
                return node.value;
            }

            // Otherwise do left and right, and add.
            int leftValue = compute (node.left);
            int rightValue = compute (node.right);

            if (node.op == '+') {
                return leftValue + rightValue;
            }
            else if (node.op == '-') {
                return leftValue - rightValue;
            }
            else if (node.op == '*') {
                return leftValue * rightValue;
            }
            else {
                return leftValue / rightValue;
            }

        }
        

        public String convertToPostfix ()
        {
            String str = postOrder (root);
            return str;
        }
        
        String postOrder (Node node)
        {
            String result = "";
            if (node.left != null) {
                result += postOrder (node.left);
            }
            if (node.right != null) {
                result += " " + postOrder (node.right);
            }
            if (node.isLeaf) {
                result += " " + node.value;
            }
            else {
                result += " " + node.op;
            }
            return result;
        }
    }

public class ExpressionTree {

    public void main (String[] args)
    {
    	Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a mathematical expression");
		String input = sc.nextLine();
		StackList<Character> operator  = new StackList<Character>();
        StackList<Double> operand = new StackList<Double>();
    	double n1, n2, result;
    	char op;
		//Algorithm to determine if paranthesis are balanced
			System.out.print("Enter expression: ");
            StackList<Integer> left = new StackList<>();
            for(int i =0; i < input.length(); i++){
                if(input.charAt(i) == '(')
                    left.push(i);

                if(input.charAt(i) == ')') {
                    if(left.isEmpty())
                        left.push(0);
                    else
                    	left.pop();
                }
            }
            if(left.isEmpty())
               System.out.println("Your expression is Balanced");
            else
               System.out.println("Your expression is NOT Balanced");
            ExpressionTree expTree = new ExpressionTree ();
            int v = expTree.computeAnswer();
            System.out.println (s + " = " + v);
            String postStr = expTree.convertToPostfix ();
            PostfixEvaluator postfixEval = new PostfixEvaluator();
            int p = postfixEval.compute (postStr);
            System.out.println ("Postfix: " + postStr + "    postfix eval=" + p);
    }
    

}  

}